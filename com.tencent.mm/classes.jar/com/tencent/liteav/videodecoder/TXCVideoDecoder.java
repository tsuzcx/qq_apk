package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public class TXCVideoDecoder
  implements com.tencent.liteav.basic.b.b, f
{
  private static final boolean NEW_DECODER = true;
  private static final String TAG = "TXCVideoDecoder";
  private static long mDecodeFirstFrameTS;
  private JSONArray mDecFormat;
  private int mDecoderCacheNum;
  private a mDecoderHandler;
  f mDecoderListener;
  private boolean mEnableDecoderChange;
  private boolean mEnableLimitDecCache;
  private boolean mEnableRestartDecoder;
  boolean mHWDec;
  boolean mHevc;
  private ArrayList<TXSNALPacket> mNALList;
  private long mNativeContext;
  boolean mNeedSortFrame;
  private WeakReference<com.tencent.liteav.basic.b.b> mNotifyListener;
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
    com.tencent.liteav.basic.util.f.f();
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
    this.mHevc = false;
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
        com.tencent.liteav.basic.util.f.a(this.mNotifyListener, -2304, "h265 Decoding failed");
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
  
  private void decodeFrame(byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(222612);
    TXSNALPacket localTXSNALPacket = new TXSNALPacket();
    localTXSNALPacket.nalData = paramArrayOfByte;
    localTXSNALPacket.pts = paramLong1;
    localTXSNALPacket.dts = paramLong2;
    localTXSNALPacket.rotation = paramInt1;
    localTXSNALPacket.codecId = paramInt2;
    localTXSNALPacket.nalType = paramInt5;
    try
    {
      if ((this.mNativeContext != 0L) && (this.mVideoDecoder == null))
      {
        paramArrayOfByte = new e();
        paramArrayOfByte.a(paramInt3, paramInt4);
        paramArrayOfByte.setListener(this);
        paramArrayOfByte.setNotifyListener(this.mNotifyListener);
        paramArrayOfByte.a(this.mDecFormat);
        paramArrayOfByte.config(this.mSurface);
        paramArrayOfByte.enableLimitDecCache(this.mEnableLimitDecCache);
        paramArrayOfByte.start(this.mSps, this.mPps, this.mNeedSortFrame, this.mHevc);
        notifyDecoderStartEvent(true);
        this.mVideoDecoder = paramArrayOfByte;
      }
      if (this.mVideoDecoder != null) {
        this.mVideoDecoder.decode(localTXSNALPacket);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(222612);
    }
  }
  
  private boolean hasSurface()
  {
    return this.mSurface != null;
  }
  
  private native long nativeCreateContext(boolean paramBoolean);
  
  private native void nativeDecCache(long paramLong);
  
  private native void nativeDecodeFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, long paramLong2, long paramLong3, int paramInt2, int paramInt3);
  
  private native void nativeDestroyContext(long paramLong);
  
  private native void nativeEnableDecodeChange(long paramLong, boolean paramBoolean);
  
  private native void nativeEnableRestartDecoder(long paramLong, boolean paramBoolean);
  
  private native void nativeNotifyPts(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  private native void nativeReStart(long paramLong, boolean paramBoolean);
  
  private native void nativeSetID(long paramLong, String paramString);
  
  private native void nativeSetStreamType(long paramLong, int paramInt);
  
  private void notifyDecoderStartEvent(boolean paramBoolean)
  {
    long l2 = 1L;
    AppMethodBeat.i(16636);
    String str = this.mUserId;
    label80:
    int i;
    if (paramBoolean)
    {
      l1 = 1L;
      TXCEventRecorderProxy.a(str, 4005, l1, -1L, "", this.mStreamType);
      Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_ID", 2008);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (!paramBoolean) {
        break label159;
      }
      str = "Enables hardware decoding";
      localBundle.putCharSequence("EVT_MSG", str);
      if (!paramBoolean) {
        break label167;
      }
      i = 1;
      label96:
      localBundle.putInt("EVT_PARAM1", i);
      com.tencent.liteav.basic.util.f.a(this.mNotifyListener, this.mUserId, 2008, localBundle);
      str = this.mUserId;
      if (!paramBoolean) {
        break label172;
      }
    }
    label159:
    label167:
    label172:
    for (long l1 = l2;; l1 = 2L)
    {
      TXCKeyPointReportProxy.a(str, 40026, l1, this.mStreamType);
      AppMethodBeat.o(16636);
      return;
      l1 = 0L;
      break;
      str = "Enables software decoding";
      break label80;
      i = 2;
      break label96;
    }
  }
  
  private void onDecodeDone(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(16637);
    if (mDecodeFirstFrameTS == 0L)
    {
      mDecodeFirstFrameTS = TXCTimeUtil.getTimeTick();
      new StringBuilder("SoftDecode onDecodeFrame: decode first frame success:").append(this.mUserId).append("_").append(this.mStreamType);
      TXCStatus.a(this.mUserId, 5005, this.mStreamType, Long.valueOf(mDecodeFirstFrameTS));
      if (!this.mHevc) {
        break label205;
      }
    }
    label205:
    for (int i = 2;; i = 0)
    {
      TXCStatus.a(this.mUserId, 5004, this.mStreamType, Integer.valueOf(i));
      f localf = this.mDecoderListener;
      if (localf != null)
      {
        paramTXSVideoFrame.width = paramInt1;
        paramTXSVideoFrame.height = paramInt2;
        paramTXSVideoFrame.rotation = paramInt3;
        paramTXSVideoFrame.pts = paramLong1;
        paramTXSVideoFrame.frameType = paramInt4;
        localf.onDecodeFrame(paramTXSVideoFrame, paramInt1, paramInt2, paramLong1, paramLong2, paramInt3);
        if ((this.mVideoWidth != paramInt1) || (this.mVideoHeight != paramInt2))
        {
          this.mVideoWidth = paramInt1;
          this.mVideoHeight = paramInt2;
          localf.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
        }
      }
      AppMethodBeat.o(16637);
      return;
    }
  }
  
  private void onStartDecoder(boolean paramBoolean)
  {
    AppMethodBeat.i(16640);
    notifyDecoderStartEvent(paramBoolean);
    AppMethodBeat.o(16640);
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
    //   17: ldc_w 411
    //   20: invokestatic 413	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   43: new 415	android/os/HandlerThread
    //   46: dup
    //   47: ldc_w 417
    //   50: invokespecial 418	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 420	android/os/HandlerThread:start	()V
    //   58: aload_0
    //   59: getfield 100	com/tencent/liteav/videodecoder/TXCVideoDecoder:mHWDec	Z
    //   62: ifeq +115 -> 177
    //   65: aload_1
    //   66: new 355	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 422
    //   73: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 425	android/os/HandlerThread:getId	()J
    //   80: invokevirtual 428	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: invokevirtual 432	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 435	android/os/HandlerThread:setName	(Ljava/lang/String;)V
    //   89: new 10	com/tencent/liteav/videodecoder/TXCVideoDecoder$a
    //   92: dup
    //   93: aload_1
    //   94: invokevirtual 439	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   97: invokespecial 442	com/tencent/liteav/videodecoder/TXCVideoDecoder$a:<init>	(Landroid/os/Looper;)V
    //   100: astore_1
    //   101: aload_1
    //   102: aload_0
    //   103: getfield 102	com/tencent/liteav/videodecoder/TXCVideoDecoder:mHevc	Z
    //   106: aload_0
    //   107: getfield 100	com/tencent/liteav/videodecoder/TXCVideoDecoder:mHWDec	Z
    //   110: aload_0
    //   111: getfield 268	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSurface	Landroid/view/Surface;
    //   114: aload_0
    //   115: getfield 278	com/tencent/liteav/videodecoder/TXCVideoDecoder:mSps	Ljava/nio/ByteBuffer;
    //   118: aload_0
    //   119: getfield 280	com/tencent/liteav/videodecoder/TXCVideoDecoder:mPps	Ljava/nio/ByteBuffer;
    //   122: aload_0
    //   123: aload_0
    //   124: invokevirtual 445	com/tencent/liteav/videodecoder/TXCVideoDecoder$a:a	(ZZLandroid/view/Surface;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Lcom/tencent/liteav/videodecoder/f;Lcom/tencent/liteav/basic/b/b;)V
    //   127: ldc 18
    //   129: ldc_w 447
    //   132: invokestatic 201	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: invokestatic 451	android/os/Message:obtain	()Landroid/os/Message;
    //   138: astore_2
    //   139: aload_2
    //   140: bipush 100
    //   142: putfield 158	android/os/Message:what	I
    //   145: aload_2
    //   146: aload_0
    //   147: getfield 104	com/tencent/liteav/videodecoder/TXCVideoDecoder:mNeedSortFrame	Z
    //   150: invokestatic 456	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   153: putfield 460	android/os/Message:obj	Ljava/lang/Object;
    //   156: aload_1
    //   157: aload_2
    //   158: invokevirtual 461	com/tencent/liteav/videodecoder/TXCVideoDecoder$a:sendMessage	(Landroid/os/Message;)Z
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
    //   178: new 355	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 463
    //   185: invokespecial 360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_1
    //   189: invokevirtual 425	android/os/HandlerThread:getId	()J
    //   192: invokevirtual 428	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: invokevirtual 432	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokevirtual 435	android/os/HandlerThread:setName	(Ljava/lang/String;)V
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
    //   205	207	204	finally
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
    AppMethodBeat.i(222610);
    this.mEnableLimitDecCache = paramBoolean;
    b localb = this.mVideoDecoder;
    if (localb != null) {
      localb.enableLimitDecCache(this.mEnableLimitDecCache);
    }
    AppMethodBeat.o(222610);
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
  
  public boolean isHardwareDecode()
  {
    return this.mVideoDecoder != null;
  }
  
  public boolean isHevc()
  {
    AppMethodBeat.i(16633);
    a locala = this.mDecoderHandler;
    if (locala != null)
    {
      boolean bool = locala.a();
      AppMethodBeat.o(16633);
      return bool;
    }
    AppMethodBeat.o(16633);
    return false;
  }
  
  public void onDecodeFailed(int paramInt)
  {
    AppMethodBeat.i(16632);
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
      new StringBuilder("MediaCodec onDecodeFrame: decode first frame success:").append(this.mUserId).append("_").append(this.mStreamType);
      TXCStatus.a(this.mUserId, 5005, this.mStreamType, Long.valueOf(mDecodeFirstFrameTS));
      if (!this.mHevc) {
        break label207;
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
        TXCStatus.a(this.mUserId, 8004, this.mStreamType, Integer.valueOf(paramInt1));
        AppMethodBeat.o(16630);
        return;
      }
      finally
      {
        label207:
        AppMethodBeat.o(16630);
      }
    }
    TXCStatus.a(this.mUserId, 8003, this.mStreamType, Integer.valueOf(paramInt1));
    AppMethodBeat.o(16630);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(16615);
    com.tencent.liteav.basic.util.f.a(this.mNotifyListener, this.mUserId, paramInt, paramBundle);
    AppMethodBeat.o(16615);
  }
  
  public void onVideoSizeChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16631);
    f localf = this.mDecoderListener;
    if ((localf != null) && ((this.mVideoWidth != paramInt1) || (this.mVideoHeight != paramInt2)))
    {
      this.mVideoWidth = paramInt1;
      this.mVideoHeight = paramInt2;
      localf.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
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
  
  public void setListener(f paramf)
  {
    this.mDecoderListener = paramf;
  }
  
  public void setNotifyListener(com.tencent.liteav.basic.b.b paramb)
  {
    AppMethodBeat.i(222611);
    this.mNotifyListener = new WeakReference(paramb);
    AppMethodBeat.o(222611);
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
        TXCLog.w("TXCVideoDecoder", "play:decode: start decoder java id " + this.mUserId + "_" + this.mStreamType + " " + hashCode());
      }
      finally {}
      this.mNativeContext = nativeCreateContext(this.mHWDec);
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
    f b;
    WeakReference<com.tencent.liteav.basic.b.b> c;
    boolean d;
    boolean e;
    Surface f;
    private ByteBuffer g;
    private ByteBuffer h;
    
    public a(Looper paramLooper)
    {
      super();
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
      for (this.a = new e();; this.a = new TXCVideoFfmpegDecoder())
      {
        this.a.setListener(this.b);
        this.a.setNotifyListener(this.c);
        this.a.config(this.f);
        this.a.start(this.g, this.h, paramBoolean, this.e);
        TXCLog.w("TXCVideoDecoder", "play:decode: start decode hwdec: " + this.d + ", hevc: " + this.e);
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
    
    private void b()
    {
      AppMethodBeat.i(16666);
      if (this.a != null)
      {
        this.a.stop();
        this.a.setListener(null);
        this.a.setNotifyListener(null);
        this.a = null;
      }
      Looper.myLooper().quit();
      TXCLog.w("TXCVideoDecoder", "play:decode: stop decode hwdec: " + this.d);
      AppMethodBeat.o(16666);
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2, Surface paramSurface, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, f paramf, com.tencent.liteav.basic.b.b paramb)
    {
      AppMethodBeat.i(222609);
      this.e = paramBoolean1;
      this.d = paramBoolean2;
      this.f = paramSurface;
      this.g = paramByteBuffer1;
      this.h = paramByteBuffer2;
      this.b = paramf;
      this.c = new WeakReference(paramb);
      AppMethodBeat.o(222609);
    }
    
    public boolean a()
    {
      AppMethodBeat.i(16664);
      if (this.a != null)
      {
        boolean bool = this.a.isHevc();
        AppMethodBeat.o(16664);
        return bool;
      }
      AppMethodBeat.o(16664);
      return false;
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
        b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.TXCVideoDecoder
 * JD-Core Version:    0.7.0.1
 */