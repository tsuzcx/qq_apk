package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public class TXCVideoDecoder
  implements com.tencent.liteav.basic.c.b, g
{
  private static final boolean NEW_DECODER = true;
  private static final String TAG = "TXCVideoDecoder";
  private static long mDecodeFirstFrameTS;
  private JSONArray mDecFormat;
  private int mDecoderCacheNum;
  private a mDecoderHandler;
  g mDecoderListener;
  private boolean mEnableDecoderChange;
  private boolean mEnableLimitDecCache;
  private boolean mEnableRestartDecoder;
  boolean mH265;
  boolean mHWDec;
  private ArrayList<TXSNALPacket> mNALList;
  private long mNativeContext;
  boolean mNeedSortFrame;
  private WeakReference<com.tencent.liteav.basic.c.b> mNotifyListener;
  private ByteBuffer mPps;
  boolean mRecvFirstFrame;
  private boolean mRestarting;
  private ByteBuffer mSps;
  private int mStreamType;
  Surface mSurface;
  private String mUserId;
  b mVideoDecoder;
  private int mVideoHeight;
  private int mVideoWidth;
  
  static
  {
    AppMethodBeat.i(16641);
    mDecodeFirstFrameTS = 0L;
    h.f();
    AppMethodBeat.o(16641);
  }
  
  public TXCVideoDecoder()
  {
    AppMethodBeat.i(16619);
    this.mRestarting = false;
    this.mStreamType = 0;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    this.mEnableDecoderChange = false;
    this.mEnableRestartDecoder = false;
    this.mEnableLimitDecCache = false;
    this.mDecFormat = null;
    this.mNALList = new ArrayList();
    this.mHWDec = true;
    this.mH265 = false;
    this.mNeedSortFrame = true;
    this.mRecvFirstFrame = false;
    mDecodeFirstFrameTS = 0L;
    AppMethodBeat.o(16619);
  }
  
  private void addOneNalToDecoder(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(16622);
    if (paramTXSNALPacket.nalType == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("iframe", bool);
      ((Bundle)localObject).putByteArray("nal", paramTXSNALPacket.nalData);
      ((Bundle)localObject).putLong("pts", paramTXSNALPacket.pts);
      ((Bundle)localObject).putLong("dts", paramTXSNALPacket.dts);
      ((Bundle)localObject).putInt("codecId", paramTXSNALPacket.codecId);
      paramTXSNALPacket = new Message();
      paramTXSNALPacket.what = 101;
      paramTXSNALPacket.setData((Bundle)localObject);
      localObject = this.mDecoderHandler;
      if (localObject != null) {
        ((Handler)localObject).sendMessage(paramTXSNALPacket);
      }
      this.mDecoderCacheNum += 1;
      AppMethodBeat.o(16622);
      return;
    }
  }
  
  private void decNALByNewWay(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(16623);
    if (this.mHWDec)
    {
      decodeFrame(paramTXSNALPacket.nalData, paramTXSNALPacket.pts, paramTXSNALPacket.dts, paramTXSNALPacket.rotation, paramTXSNALPacket.codecId, 0, 0, paramTXSNALPacket.nalType);
      AppMethodBeat.o(16623);
      return;
    }
    try
    {
      nativeDecodeFrame(this.mNativeContext, paramTXSNALPacket.nalData, paramTXSNALPacket.nalType, paramTXSNALPacket.pts, paramTXSNALPacket.dts, paramTXSNALPacket.rotation, paramTXSNALPacket.codecId);
      return;
    }
    finally
    {
      AppMethodBeat.o(16623);
    }
  }
  
  private void decNALByOldWay(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(16624);
    int i;
    try
    {
      if (paramTXSNALPacket.nalType == 0) {}
      for (i = 1; (!this.mRecvFirstFrame) && (i == 0); i = 0)
      {
        TXCLog.i("TXCVideoDecoder", "play:decode: push nal ignore p frame when not got i frame");
        AppMethodBeat.o(16624);
        return;
      }
      if ((!this.mRecvFirstFrame) && (i != 0))
      {
        TXCLog.w("TXCVideoDecoder", "play:decode: push first i frame");
        this.mRecvFirstFrame = true;
      }
      if ((!this.mRestarting) && (paramTXSNALPacket.codecId == 1) && (!this.mHWDec))
      {
        TXCLog.w("TXCVideoDecoder", "play:decode: hevc decode error  ");
        h.a(this.mNotifyListener, -2304, "h265 Decoding failed");
        this.mRestarting = true;
      }
      if (this.mDecoderHandler == null) {
        break label199;
      }
      if (!this.mNALList.isEmpty())
      {
        Iterator localIterator = this.mNALList.iterator();
        while (localIterator.hasNext()) {
          addOneNalToDecoder((TXSNALPacket)localIterator.next());
        }
      }
      this.mNALList.clear();
    }
    catch (Exception paramTXSNALPacket)
    {
      TXCLog.e("TXCVideoDecoder", "decode NAL By Old way failed.", paramTXSNALPacket);
      AppMethodBeat.o(16624);
      return;
    }
    addOneNalToDecoder(paramTXSNALPacket);
    AppMethodBeat.o(16624);
    return;
    label199:
    if ((i != 0) && (!this.mNALList.isEmpty())) {
      this.mNALList.clear();
    }
    this.mNALList.add(paramTXSNALPacket);
    if (!this.mRestarting) {
      start();
    }
    AppMethodBeat.o(16624);
  }
  
  /* Error */
  private void decodeFrame(byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc 246
    //   2: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 110	com/tencent/liteav/basic/structs/TXSNALPacket
    //   8: dup
    //   9: invokespecial 247	com/tencent/liteav/basic/structs/TXSNALPacket:<init>	()V
    //   12: astore 11
    //   14: aload 11
    //   16: aload_1
    //   17: putfield 128	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   20: aload 11
    //   22: lload_2
    //   23: putfield 136	com/tencent/liteav/basic/structs/TXSNALPacket:pts	J
    //   26: aload 11
    //   28: lload 4
    //   30: putfield 144	com/tencent/liteav/basic/structs/TXSNALPacket:dts	J
    //   33: aload 11
    //   35: iload 6
    //   37: putfield 176	com/tencent/liteav/basic/structs/TXSNALPacket:rotation	I
    //   40: aload 11
    //   42: iload 7
    //   44: putfield 148	com/tencent/liteav/basic/structs/TXSNALPacket:codecId	I
    //   47: aload 11
    //   49: iload 10
    //   51: putfield 113	com/tencent/liteav/basic/structs/TXSNALPacket:nalType	I
    //   54: aload_0
    //   55: monitorenter
    //   56: aload_0
    //   57: getfield 182	com/tencent/liteav/videodecoder/TXCVideoDecoder:mNativeContext	J
    //   60: lconst_0
    //   61: lcmp
    //   62: ifeq +114 -> 176
    //   65: aload_0
    //   66: getfield 249	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   69: ifnonnull +107 -> 176
    //   72: iload 7
    //   74: iconst_1
    //   75: if_icmpne +127 -> 202
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 102	com/tencent/liteav/videodecoder/TXCVideoDecoder:mH265	Z
    //   83: new 251	com/tencent/liteav/videodecoder/f
    //   86: dup
    //   87: invokespecial 252	com/tencent/liteav/videodecoder/f:<init>	()V
    //   90: astore_1
    //   91: aload_1
    //   92: iload 8
    //   94: iload 9
    //   96: invokevirtual 255	com/tencent/liteav/videodecoder/f:a	(II)V
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 259	com/tencent/liteav/videodecoder/f:setListener	(Lcom/tencent/liteav/videodecoder/g;)V
    //   104: aload_1
    //   105: new 261	java/lang/ref/WeakReference
    //   108: dup
    //   109: aload_0
    //   110: invokespecial 264	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   113: invokevirtual 268	com/tencent/liteav/videodecoder/f:setNotifyListener	(Ljava/lang/ref/WeakReference;)V
    //   116: aload_1
    //   117: aload_0
    //   118: getfield 93	com/tencent/liteav/videodecoder/TXCVideoDecoder:mDecFormat	Lorg/json/JSONArray;
    //   121: invokevirtual 271	com/tencent/liteav/videodecoder/f:a	(Lorg/json/JSONArray;)V
    //   124: aload_1
    //   125: aload_0
    //   126: getfield 273	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSurface	Landroid/view/Surface;
    //   129: invokevirtual 277	com/tencent/liteav/videodecoder/f:config	(Landroid/view/Surface;)I
    //   132: pop
    //   133: aload_1
    //   134: aload_0
    //   135: getfield 91	com/tencent/liteav/videodecoder/TXCVideoDecoder:mEnableLimitDecCache	Z
    //   138: invokevirtual 281	com/tencent/liteav/videodecoder/f:enableLimitDecCache	(Z)V
    //   141: aload_1
    //   142: aload_0
    //   143: getfield 283	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSps	Ljava/nio/ByteBuffer;
    //   146: aload_0
    //   147: getfield 285	com/tencent/liteav/videodecoder/TXCVideoDecoder:mPps	Ljava/nio/ByteBuffer;
    //   150: aload_0
    //   151: getfield 104	com/tencent/liteav/videodecoder/TXCVideoDecoder:mNeedSortFrame	Z
    //   154: aload_0
    //   155: getfield 102	com/tencent/liteav/videodecoder/TXCVideoDecoder:mH265	Z
    //   158: invokevirtual 288	com/tencent/liteav/videodecoder/f:start	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;ZZ)I
    //   161: pop
    //   162: aload_0
    //   163: iconst_1
    //   164: aload_0
    //   165: getfield 102	com/tencent/liteav/videodecoder/TXCVideoDecoder:mH265	Z
    //   168: invokespecial 292	com/tencent/liteav/videodecoder/TXCVideoDecoder:notifyDecoderStartEvent	(ZZ)V
    //   171: aload_0
    //   172: aload_1
    //   173: putfield 249	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   176: aload_0
    //   177: getfield 249	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   180: ifnull +14 -> 194
    //   183: aload_0
    //   184: getfield 249	com/tencent/liteav/videodecoder/TXCVideoDecoder:mVideoDecoder	Lcom/tencent/liteav/videodecoder/b;
    //   187: aload 11
    //   189: invokeinterface 297 2 0
    //   194: aload_0
    //   195: monitorexit
    //   196: ldc 246
    //   198: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: return
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 102	com/tencent/liteav/videodecoder/TXCVideoDecoder:mH265	Z
    //   207: goto -124 -> 83
    //   210: astore_1
    //   211: aload_0
    //   212: monitorexit
    //   213: ldc 246
    //   215: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	TXCVideoDecoder
    //   0	220	1	paramArrayOfByte	byte[]
    //   0	220	2	paramLong1	long
    //   0	220	4	paramLong2	long
    //   0	220	6	paramInt1	int
    //   0	220	7	paramInt2	int
    //   0	220	8	paramInt3	int
    //   0	220	9	paramInt4	int
    //   0	220	10	paramInt5	int
    //   12	176	11	localTXSNALPacket	TXSNALPacket
    // Exception table:
    //   from	to	target	type
    //   56	72	210	finally
    //   78	83	210	finally
    //   83	176	210	finally
    //   176	194	210	finally
    //   194	196	210	finally
    //   202	207	210	finally
  }
  
  private boolean hasSurface()
  {
    return this.mSurface != null;
  }
  
  private native long nativeCreateContext(boolean paramBoolean, Object paramObject);
  
  private native void nativeDecCache(long paramLong);
  
  private native void nativeDecodeFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
  
  private native void nativeDestroyContext(long paramLong);
  
  private native void nativeEnableDecodeChange(long paramLong, boolean paramBoolean);
  
  private native void nativeEnableRestartDecoder(long paramLong, boolean paramBoolean);
  
  private native void nativeNotifyHWDecoderError(long paramLong);
  
  private native void nativeNotifyPts(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native void nativeReStart(long paramLong, boolean paramBoolean);
  
  private native void nativeSetID(long paramLong, String paramString);
  
  private native void nativeSetStreamType(long paramLong, int paramInt);
  
  private void notifyDecoderStartEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 1L;
    AppMethodBeat.i(230180);
    String str = this.mUserId;
    if (paramBoolean1)
    {
      l1 = 1L;
      TXCEventRecorderProxy.a(str, 4005, l1, -1L, "", this.mStreamType);
      reportDecoderEvent(paramBoolean1, paramBoolean2);
      str = this.mUserId;
      if (!paramBoolean1) {
        break label84;
      }
    }
    label84:
    for (long l1 = l2;; l1 = 2L)
    {
      TXCKeyPointReportProxy.a(str, 40026, l1, this.mStreamType);
      AppMethodBeat.o(230180);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private void onDecodeDone(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(16637);
    if (mDecodeFirstFrameTS == 0L)
    {
      mDecodeFirstFrameTS = TXCTimeUtil.getTimeTick();
      TXCLog.i("TXCVideoDecoder", "[FirstFramePath][Video][Decoder] TXCVideoDecoder: decode first frame success. instance:" + hashCode() + " isHWAcc:false isH265:" + this.mH265 + " userId:" + this.mUserId + " type:" + this.mStreamType);
      TXCStatus.a(this.mUserId, 5005, this.mStreamType, Long.valueOf(mDecodeFirstFrameTS));
      if (!this.mH265) {
        break label238;
      }
    }
    label238:
    for (int i = 2;; i = 0)
    {
      TXCStatus.a(this.mUserId, 5004, this.mStreamType, Integer.valueOf(i));
      g localg = this.mDecoderListener;
      if (localg != null)
      {
        paramTXSVideoFrame.width = paramInt1;
        paramTXSVideoFrame.height = paramInt2;
        paramTXSVideoFrame.rotation = paramInt3;
        paramTXSVideoFrame.pts = paramLong1;
        paramTXSVideoFrame.frameType = paramInt4;
        localg.onDecodeFrame(paramTXSVideoFrame, paramInt1, paramInt2, paramLong1, paramLong2, paramInt3);
        if ((this.mVideoWidth != paramInt1) || (this.mVideoHeight != paramInt2))
        {
          this.mVideoWidth = paramInt1;
          this.mVideoHeight = paramInt2;
          localg.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
        }
      }
      AppMethodBeat.o(16637);
      return;
    }
  }
  
  private void onStartDecoder(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(230208);
    this.mH265 = paramBoolean2;
    this.mHWDec = paramBoolean1;
    notifyDecoderStartEvent(paramBoolean1, this.mH265);
    AppMethodBeat.o(230208);
  }
  
  private void reportDecoderEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(230182);
    Bundle localBundle = new Bundle();
    localBundle.putInt("EVT_ID", 2008);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    StringBuilder localStringBuilder = new StringBuilder("Enables ");
    if (paramBoolean2)
    {
      localStringBuilder.append("H265 ");
      if (!paramBoolean1) {
        break label184;
      }
      localStringBuilder.append("hardware ");
      label86:
      localStringBuilder.append("decoding");
      localBundle.putCharSequence("EVT_MSG", localStringBuilder.toString());
      if (!paramBoolean1) {
        break label196;
      }
    }
    label184:
    label196:
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("EVT_PARAM1", i);
      h.a(this.mNotifyListener, this.mUserId, 2008, localBundle);
      TXCLog.i("TXCVideoDecoder", "start video decoder:" + localStringBuilder.toString());
      AppMethodBeat.o(230182);
      return;
      localStringBuilder.append("H264 ");
      break;
      localStringBuilder.append("software ");
      break label86;
    }
  }
  
  /* Error */
  private int startDecodeThread()
  {
    // Byte code:
    //   0: sipush 16634
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 164	com/tencent/liteav/videodecoder/TXCVideoDecoder:mDecoderHandler	Lcom/tencent/liteav/videodecoder/TXCVideoDecoder$a;
    //   12: ifnull +21 -> 33
    //   15: ldc 18
    //   17: ldc_w 453
    //   20: invokestatic 455	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_0
    //   24: monitorexit
    //   25: sipush 16634
    //   28: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_m1
    //   32: ireturn
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 172	com/tencent/liteav/videodecoder/TXCVideoDecoder:mDecoderCacheNum	I
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 79	com/tencent/liteav/videodecoder/TXCVideoDecoder:mRestarting	Z
    //   43: new 457	android/os/HandlerThread
    //   46: dup
    //   47: ldc_w 459
    //   50: invokespecial 460	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 462	android/os/HandlerThread:start	()V
    //   58: aload_0
    //   59: getfield 100	com/tencent/liteav/videodecoder/TXCVideoDecoder:mHWDec	Z
    //   62: ifeq +115 -> 177
    //   65: aload_1
    //   66: new 347	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 464
    //   73: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 467	android/os/HandlerThread:getId	()J
    //   80: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 473	android/os/HandlerThread:setName	(Ljava/lang/String;)V
    //   89: new 10	com/tencent/liteav/videodecoder/TXCVideoDecoder$a
    //   92: dup
    //   93: aload_1
    //   94: invokevirtual 477	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   97: invokespecial 480	com/tencent/liteav/videodecoder/TXCVideoDecoder$a:<init>	(Landroid/os/Looper;)V
    //   100: astore_1
    //   101: aload_1
    //   102: aload_0
    //   103: getfield 102	com/tencent/liteav/videodecoder/TXCVideoDecoder:mH265	Z
    //   106: aload_0
    //   107: getfield 100	com/tencent/liteav/videodecoder/TXCVideoDecoder:mHWDec	Z
    //   110: aload_0
    //   111: getfield 273	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSurface	Landroid/view/Surface;
    //   114: aload_0
    //   115: getfield 283	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSps	Ljava/nio/ByteBuffer;
    //   118: aload_0
    //   119: getfield 285	com/tencent/liteav/videodecoder/TXCVideoDecoder:mPps	Ljava/nio/ByteBuffer;
    //   122: aload_0
    //   123: aload_0
    //   124: invokevirtual 483	com/tencent/liteav/videodecoder/TXCVideoDecoder$a:a	(ZZLandroid/view/Surface;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Lcom/tencent/liteav/videodecoder/g;Lcom/tencent/liteav/basic/c/b;)V
    //   127: ldc 18
    //   129: ldc_w 485
    //   132: invokestatic 201	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: invokestatic 489	android/os/Message:obtain	()Landroid/os/Message;
    //   138: astore_2
    //   139: aload_2
    //   140: bipush 100
    //   142: putfield 158	android/os/Message:what	I
    //   145: aload_2
    //   146: aload_0
    //   147: getfield 104	com/tencent/liteav/videodecoder/TXCVideoDecoder:mNeedSortFrame	Z
    //   150: invokestatic 494	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   153: putfield 498	android/os/Message:obj	Ljava/lang/Object;
    //   156: aload_1
    //   157: aload_2
    //   158: invokevirtual 499	com/tencent/liteav/videodecoder/TXCVideoDecoder$a:sendMessage	(Landroid/os/Message;)Z
    //   161: pop
    //   162: aload_0
    //   163: aload_1
    //   164: putfield 164	com/tencent/liteav/videodecoder/TXCVideoDecoder:mDecoderHandler	Lcom/tencent/liteav/videodecoder/TXCVideoDecoder$a;
    //   167: aload_0
    //   168: monitorexit
    //   169: sipush 16634
    //   172: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: iconst_0
    //   176: ireturn
    //   177: aload_1
    //   178: new 347	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 501
    //   185: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_1
    //   189: invokevirtual 467	android/os/HandlerThread:getId	()J
    //   192: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokevirtual 473	android/os/HandlerThread:setName	(Ljava/lang/String;)V
    //   201: goto -112 -> 89
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: sipush 16634
    //   210: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_1
    //   214: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	TXCVideoDecoder
    //   53	136	1	localObject1	Object
    //   204	10	1	localObject2	Object
    //   138	20	2	localMessage	Message
    // Exception table:
    //   from	to	target	type
    //   8	25	204	finally
    //   33	89	204	finally
    //   89	169	204	finally
    //   177	201	204	finally
  }
  
  private void stopDecodeThread()
  {
    AppMethodBeat.i(16635);
    try
    {
      if (this.mDecoderHandler != null) {
        this.mDecoderHandler.sendEmptyMessage(102);
      }
      this.mDecoderHandler = null;
      return;
    }
    finally
    {
      AppMethodBeat.o(16635);
    }
  }
  
  private void stopHWDecoder()
  {
    try
    {
      AppMethodBeat.i(16639);
      if (this.mVideoDecoder != null)
      {
        this.mVideoDecoder.stop();
        this.mVideoDecoder.setListener(null);
        this.mVideoDecoder.setNotifyListener(null);
        this.mVideoDecoder = null;
      }
      AppMethodBeat.o(16639);
      return;
    }
    finally {}
  }
  
  public long GetDecodeFirstFrameTS()
  {
    return mDecodeFirstFrameTS;
  }
  
  public void config(JSONArray paramJSONArray)
  {
    this.mDecFormat = paramJSONArray;
  }
  
  public void enableChange(boolean paramBoolean)
  {
    AppMethodBeat.i(16618);
    this.mEnableDecoderChange = paramBoolean;
    try
    {
      nativeEnableDecodeChange(this.mNativeContext, this.mEnableDecoderChange);
      return;
    }
    finally
    {
      AppMethodBeat.o(16618);
    }
  }
  
  public void enableHWDec(boolean paramBoolean)
  {
    this.mHWDec = paramBoolean;
  }
  
  public void enableLimitDecCache(boolean paramBoolean)
  {
    AppMethodBeat.i(230132);
    this.mEnableLimitDecCache = paramBoolean;
    b localb = this.mVideoDecoder;
    if (localb != null) {
      localb.enableLimitDecCache(this.mEnableLimitDecCache);
    }
    AppMethodBeat.o(230132);
  }
  
  public void enableRestart(boolean paramBoolean)
  {
    this.mEnableRestartDecoder = paramBoolean;
  }
  
  public int getDecoderCacheNum()
  {
    AppMethodBeat.i(16629);
    int i = this.mDecoderCacheNum;
    int j = this.mNALList.size();
    AppMethodBeat.o(16629);
    return i + j;
  }
  
  public boolean isH265()
  {
    return this.mH265;
  }
  
  public boolean isHardwareDecode()
  {
    return this.mVideoDecoder != null;
  }
  
  public void onDecodeFailed(int paramInt)
  {
    AppMethodBeat.i(16632);
    TXCStatus.a(this.mUserId, 5006, this.mStreamType, Integer.valueOf(paramInt));
    if (this.mDecoderListener != null) {
      this.mDecoderListener.onDecodeFailed(paramInt);
    }
    try
    {
      nativeDecCache(this.mNativeContext);
      return;
    }
    finally
    {
      AppMethodBeat.o(16632);
    }
  }
  
  public void onDecodeFrame(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3)
  {
    AppMethodBeat.i(16630);
    if (mDecodeFirstFrameTS == 0L)
    {
      mDecodeFirstFrameTS = TXCTimeUtil.getTimeTick();
      TXCLog.i("TXCVideoDecoder", "[FirstFramePath][Video][Decoder] TXCVideoDecoder: decode first frame success. instance:" + hashCode() + " isHWAcc:true isH265:" + this.mH265 + " userId:" + this.mUserId + " type:" + this.mStreamType);
      TXCStatus.a(this.mUserId, 5005, this.mStreamType, Long.valueOf(mDecodeFirstFrameTS));
      if (!this.mH265) {
        break label240;
      }
    }
    for (int i = 3;; i = 1)
    {
      TXCStatus.a(this.mUserId, 5004, this.mStreamType, Integer.valueOf(i));
      if (this.mDecoderListener != null) {
        this.mDecoderListener.onDecodeFrame(paramTXSVideoFrame, paramInt1, paramInt2, paramLong1, paramLong2, paramInt3);
      }
      if (this.mDecoderCacheNum > 0) {
        this.mDecoderCacheNum -= 1;
      }
      if (paramTXSVideoFrame == null) {}
      try
      {
        nativeNotifyPts(this.mNativeContext, paramLong1, paramInt1, paramInt2);
        paramInt1 = this.mVideoDecoder.GetDecodeCost();
        if (!this.mHWDec) {
          break;
        }
        return;
      }
      finally
      {
        label240:
        AppMethodBeat.o(16630);
      }
    }
  }
  
  public void onDecoderChange(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(230167);
    this.mH265 = paramBoolean;
    this.mHWDec = true;
    TXCLog.i("TXCVideoDecoder", "onDecoderChange " + paramString + " , isH265 = " + paramBoolean);
    reportDecoderEvent(this.mHWDec, paramBoolean);
    AppMethodBeat.o(230167);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(16615);
    if ((paramInt == 2106) || (paramInt == -2304)) {
      nativeNotifyHWDecoderError(this.mNativeContext);
    }
    h.a(this.mNotifyListener, this.mUserId, paramInt, paramBundle);
    AppMethodBeat.o(16615);
  }
  
  public void onVideoSizeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16631);
    g localg = this.mDecoderListener;
    if ((localg != null) && ((this.mVideoWidth != paramInt1) || (this.mVideoHeight != paramInt2)))
    {
      this.mVideoWidth = paramInt1;
      this.mVideoHeight = paramInt2;
      localg.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
    }
    AppMethodBeat.o(16631);
  }
  
  public void pushNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(16625);
    decNALByNewWay(paramTXSNALPacket);
    AppMethodBeat.o(16625);
  }
  
  public void restart(boolean paramBoolean)
  {
    AppMethodBeat.i(16628);
    try
    {
      this.mHWDec = paramBoolean;
      nativeReStart(this.mNativeContext, this.mHWDec);
      return;
    }
    finally
    {
      AppMethodBeat.o(16628);
    }
  }
  
  public void setListener(g paramg)
  {
    this.mDecoderListener = paramg;
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.c.b paramb)
  {
    AppMethodBeat.i(230140);
    this.mNotifyListener = new WeakReference(paramb);
    AppMethodBeat.o(230140);
  }
  
  public void setStreamType(int paramInt)
  {
    AppMethodBeat.i(16617);
    this.mStreamType = paramInt;
    try
    {
      nativeSetStreamType(this.mNativeContext, this.mStreamType);
      return;
    }
    finally
    {
      AppMethodBeat.o(16617);
    }
  }
  
  public void setUserId(String paramString)
  {
    AppMethodBeat.i(16616);
    this.mUserId = paramString;
    try
    {
      nativeSetID(this.mNativeContext, this.mUserId);
      return;
    }
    finally
    {
      AppMethodBeat.o(16616);
    }
  }
  
  public int setup(SurfaceTexture paramSurfaceTexture, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    AppMethodBeat.i(16621);
    try
    {
      if (this.mSurface != null)
      {
        this.mSurface.release();
        this.mSurface = null;
      }
      int i = setup(new Surface(paramSurfaceTexture), paramByteBuffer1, paramByteBuffer2, paramBoolean);
      AppMethodBeat.o(16621);
      return i;
    }
    finally
    {
      AppMethodBeat.o(16621);
    }
  }
  
  public int setup(Surface paramSurface, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    try
    {
      this.mSurface = paramSurface;
      this.mSps = paramByteBuffer1;
      this.mPps = paramByteBuffer2;
      this.mNeedSortFrame = paramBoolean;
      return 0;
    }
    finally {}
  }
  
  public int start()
  {
    int i = -1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(16626);
        if ((this.mHWDec) && (this.mSurface == null))
        {
          TXCLog.i("TXCVideoDecoder", "play:decode: start decoder error when not setup surface, id " + this.mUserId + "_" + this.mStreamType);
          AppMethodBeat.o(16626);
          return i;
        }
        if (this.mNativeContext != 0L)
        {
          TXCLog.w("TXCVideoDecoder", "play:decode: start decoder error when decoder is started, id " + this.mUserId + "_" + this.mStreamType);
          AppMethodBeat.o(16626);
          continue;
        }
        TXCLog.i("TXCVideoDecoder", "[FirstFramePath][Video][Decoder] TXCVideoDecoder: start decode. instance:" + this + " userId:" + this.mUserId + " type:" + this.mStreamType);
      }
      finally {}
      this.mNativeContext = nativeCreateContext(this.mHWDec, a.b());
      nativeSetID(this.mNativeContext, this.mUserId);
      nativeSetStreamType(this.mNativeContext, this.mStreamType);
      nativeEnableDecodeChange(this.mNativeContext, this.mEnableDecoderChange);
      nativeEnableRestartDecoder(this.mNativeContext, this.mEnableRestartDecoder);
      i = 0;
      AppMethodBeat.o(16626);
    }
  }
  
  public void stop()
  {
    try
    {
      AppMethodBeat.i(16627);
      if (this.mNativeContext == 0L)
      {
        TXCLog.w("TXCVideoDecoder", "play:decode: stop decoder ignore when decoder is stopped, id " + this.mUserId + "_" + this.mStreamType);
        AppMethodBeat.o(16627);
        return;
      }
      TXCLog.w("TXCVideoDecoder", "play:decode: stop decoder java id " + this.mUserId + "_" + this.mStreamType + " " + hashCode());
      nativeDestroyContext(this.mNativeContext);
      this.mNativeContext = 0L;
      this.mNALList.clear();
      this.mRecvFirstFrame = false;
      this.mDecoderCacheNum = 0;
      mDecodeFirstFrameTS = 0L;
    }
    finally
    {
      try
      {
        for (;;)
        {
          if (this.mVideoDecoder != null)
          {
            this.mVideoDecoder.stop();
            this.mVideoDecoder.setListener(null);
            this.mVideoDecoder.setNotifyListener(null);
            this.mVideoDecoder = null;
          }
          if (this.mSurface != null)
          {
            this.mSurface.release();
            this.mSurface = null;
          }
          AppMethodBeat.o(16627);
        }
      }
      finally
      {
        AppMethodBeat.o(16627);
      }
      localObject1 = finally;
    }
  }
  
  static class a
    extends Handler
  {
    b a;
    g b;
    WeakReference<com.tencent.liteav.basic.c.b> c;
    boolean d;
    boolean e;
    Surface f;
    private ByteBuffer g;
    private ByteBuffer h;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private void a()
    {
      AppMethodBeat.i(230600);
      if (this.a != null)
      {
        this.a.stop();
        this.a.setListener(null);
        this.a.setNotifyListener(null);
        this.a = null;
      }
      Looper.myLooper().quit();
      TXCLog.w("TXCVideoDecoder", "play:decode: stop decode hwdec: " + this.d);
      AppMethodBeat.o(230600);
    }
    
    private void a(boolean paramBoolean)
    {
      AppMethodBeat.i(16668);
      if (this.a != null)
      {
        TXCLog.i("TXCVideoDecoder", "play:decode: start decode ignore hwdec: " + this.d);
        AppMethodBeat.o(16668);
        return;
      }
      if (this.d) {}
      for (this.a = new f();; this.a = new TXCVideoFfmpegDecoder())
      {
        this.a.setListener(this.b);
        this.a.setNotifyListener(this.c);
        this.a.config(this.f);
        this.a.start(this.g, this.h, paramBoolean, this.e);
        TXCLog.w("TXCVideoDecoder", "play:decode: start decode hwdec: " + this.d + ", h265: " + this.e);
        AppMethodBeat.o(16668);
        return;
      }
    }
    
    private void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(16667);
      this.d = paramBoolean1;
      TXCLog.w("TXCVideoDecoder", "play:decode: restart decode hwdec: " + this.d);
      if (this.a != null)
      {
        this.a.stop();
        this.a.setListener(null);
        this.a.setNotifyListener(null);
        this.a = null;
      }
      a(paramBoolean2);
      AppMethodBeat.o(16667);
    }
    
    private void a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt)
    {
      AppMethodBeat.i(16665);
      TXSNALPacket localTXSNALPacket = new TXSNALPacket();
      localTXSNALPacket.nalData = paramArrayOfByte;
      localTXSNALPacket.pts = paramLong1;
      localTXSNALPacket.dts = paramLong2;
      localTXSNALPacket.codecId = paramInt;
      if (this.a != null) {
        this.a.decode(localTXSNALPacket);
      }
      AppMethodBeat.o(16665);
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, Surface paramSurface, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, g paramg, com.tencent.liteav.basic.c.b paramb)
    {
      AppMethodBeat.i(230595);
      this.e = paramBoolean1;
      this.d = paramBoolean2;
      this.f = paramSurface;
      this.g = paramByteBuffer1;
      this.h = paramByteBuffer2;
      this.b = paramg;
      this.c = new WeakReference(paramb);
      AppMethodBeat.o(230595);
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      AppMethodBeat.i(16663);
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(16663);
        return;
      case 100: 
        a(((Boolean)paramMessage.obj).booleanValue());
        AppMethodBeat.o(16663);
        return;
      case 101: 
        try
        {
          paramMessage = paramMessage.getData();
          a(paramMessage.getByteArray("nal"), paramMessage.getLong("pts"), paramMessage.getLong("dts"), paramMessage.getInt("codecId"));
          AppMethodBeat.o(16663);
          return;
        }
        catch (Exception paramMessage)
        {
          TXCLog.e("TXCVideoDecoder", "decode frame failed." + paramMessage.getMessage());
          AppMethodBeat.o(16663);
          return;
        }
      case 102: 
        a();
        AppMethodBeat.o(16663);
        return;
      }
      boolean bool1;
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        label165:
        if (paramMessage.arg2 != 1) {
          break label187;
        }
      }
      for (;;)
      {
        a(bool1, bool2);
        break;
        bool1 = false;
        break label165;
        label187:
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.TXCVideoDecoder
 * JD-Core Version:    0.7.0.1
 */