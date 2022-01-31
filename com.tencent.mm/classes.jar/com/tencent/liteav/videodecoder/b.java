package com.tencent.liteav.videodecoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class b
  implements a
{
  private MediaCodec.BufferInfo a;
  private MediaCodec b;
  private String c;
  private int d;
  private int e;
  private long f;
  private long g;
  private boolean h;
  private boolean i;
  private boolean j;
  private Surface k;
  private int l;
  private ArrayList<TXSNALPacket> m;
  private c n;
  private WeakReference<com.tencent.liteav.basic.c.a> o;
  
  public b()
  {
    AppMethodBeat.i(67769);
    this.a = new MediaCodec.BufferInfo();
    this.b = null;
    this.c = "video/avc";
    this.d = 540;
    this.e = 960;
    this.f = 0L;
    this.g = 0L;
    this.h = true;
    this.i = false;
    this.j = false;
    this.k = null;
    this.l = 0;
    this.m = new ArrayList();
    AppMethodBeat.o(67769);
  }
  
  private int a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    i1 = 1;
    i2 = -1;
    int i4 = 0;
    AppMethodBeat.i(146264);
    for (;;)
    {
      try
      {
        if ((this.b != null) || (this.k == null))
        {
          TXCLog.e("MediaCodecDecoder", "decode: init decoder error, can not init for decoder=" + this.b + ",surface=" + this.k);
          AppMethodBeat.o(146264);
          return -1;
        }
        this.j = paramBoolean;
        if (this.j)
        {
          this.c = "video/hevc";
          localMediaFormat = MediaFormat.createVideoFormat(this.c, this.d, this.e);
          if (paramByteBuffer1 != null) {
            localMediaFormat.setByteBuffer("csd-0", paramByteBuffer1);
          }
          if (paramByteBuffer2 != null) {
            localMediaFormat.setByteBuffer("csd-1", paramByteBuffer2);
          }
          this.b = MediaCodec.createDecoderByType(this.c);
        }
      }
      catch (Exception paramByteBuffer1)
      {
        MediaFormat localMediaFormat;
        i1 = 0;
      }
      try
      {
        this.b.configure(localMediaFormat, this.k, null, 0);
        i1 = 2;
        this.b.setVideoScalingMode(1);
        i1 = 3;
        this.b.start();
        i3 = 4;
        i1 = i3;
        TXCLog.w("MediaCodecDecoder", "decode: start decoder success, is hevc: " + this.j + " w = " + this.d + " h = " + this.e);
      }
      catch (Exception paramByteBuffer1)
      {
        break label262;
      }
      try
      {
        this.l = 0;
        i1 = i4;
        AppMethodBeat.o(146264);
        return i1;
      }
      catch (Exception paramByteBuffer1)
      {
        i2 = 0;
        i1 = i3;
        break label262;
      }
      this.c = "video/avc";
      continue;
      label262:
      if (this.b != null) {}
      try
      {
        this.b.release();
        TXCLog.w("MediaCodecDecoder", "decode: , decoder release success");
        this.b = null;
      }
      catch (Exception paramByteBuffer2)
      {
        for (;;)
        {
          TXCLog.e("MediaCodecDecoder", "decode: , decoder release exception: " + paramByteBuffer1.toString());
          this.b = null;
        }
      }
      finally
      {
        this.b = null;
        AppMethodBeat.o(146264);
      }
      TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i1 + " step exception: " + paramByteBuffer1.toString());
      f();
      i1 = i2;
    }
  }
  
  private void a()
  {
    AppMethodBeat.i(146265);
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        this.b.stop();
        TXCLog.w("MediaCodecDecoder", "decode: stop decoder sucess");
      }
      catch (Exception localException2)
      {
        TXCLog.e("MediaCodecDecoder", "decode: stop decoder Exception: " + localException2.toString());
        try
        {
          this.b.release();
          TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
          this.b = null;
          continue;
        }
        catch (Exception localException3)
        {
          TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException3.toString());
          this.b = null;
          continue;
        }
        finally
        {
          this.b = null;
          AppMethodBeat.o(146265);
        }
      }
      finally
      {
        try
        {
          this.b.release();
          TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
          this.b = null;
        }
        catch (Exception localException4)
        {
          TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException4.toString());
          this.b = null;
          continue;
        }
        finally
        {
          this.b = null;
          AppMethodBeat.o(146265);
        }
        AppMethodBeat.o(146265);
      }
      try
      {
        this.b.release();
        TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
        this.b = null;
      }
      catch (Exception localException1)
      {
        TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException1.toString());
        this.b = null;
      }
      finally
      {
        this.b = null;
        AppMethodBeat.o(146265);
      }
    }
    this.m.clear();
    this.f = 0L;
    this.h = true;
    AppMethodBeat.o(146265);
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(146267);
    this.b.releaseOutputBuffer(paramInt1, true);
    if ((this.a.flags & 0x4) != 0) {
      TXCLog.d("MediaCodecDecoder", "output EOS");
    }
    try
    {
      if (this.n != null) {
        this.n.onDecodeFrame(null, this.d, this.e, paramLong1, paramLong2, paramInt2);
      }
      label63:
      d();
      AppMethodBeat.o(146267);
      return;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(146271);
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      if (this.i)
      {
        AppMethodBeat.o(146271);
        return;
      }
      if ((this.j) && (!e()))
      {
        a();
        f();
        AppMethodBeat.o(146271);
        return;
      }
      a();
      a(null, null, this.j);
    }
    AppMethodBeat.o(146271);
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  private void b()
  {
    // Byte code:
    //   0: ldc 225
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 50	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   9: ifnonnull +16 -> 25
    //   12: ldc 86
    //   14: ldc 227
    //   16: invokestatic 111	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 225
    //   21: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: aload_0
    //   26: getfield 77	com/tencent/liteav/videodecoder/b:m	Ljava/util/ArrayList;
    //   29: iconst_0
    //   30: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   33: checkcast 233	com/tencent/liteav/basic/structs/TXSNALPacket
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +11 -> 49
    //   41: aload_2
    //   42: getfield 237	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   45: arraylength
    //   46: ifne +25 -> 71
    //   49: ldc 86
    //   51: ldc 239
    //   53: invokestatic 111	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: getfield 77	com/tencent/liteav/videodecoder/b:m	Ljava/util/ArrayList;
    //   60: iconst_0
    //   61: invokevirtual 242	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   64: pop
    //   65: ldc 225
    //   67: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: aload_0
    //   72: getfield 50	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   75: invokevirtual 246	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +8 -> 88
    //   83: aload_3
    //   84: arraylength
    //   85: ifne +16 -> 101
    //   88: ldc 86
    //   90: ldc 248
    //   92: invokestatic 111	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: ldc 225
    //   97: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: return
    //   101: aload_0
    //   102: getfield 50	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   105: ldc2_w 249
    //   108: invokevirtual 254	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   111: istore_1
    //   112: iload_1
    //   113: iflt +152 -> 265
    //   116: aload_3
    //   117: iload_1
    //   118: aaload
    //   119: aload_2
    //   120: getfield 237	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   123: invokevirtual 260	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   126: pop
    //   127: aload_0
    //   128: getfield 50	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   131: iload_1
    //   132: iconst_0
    //   133: aload_2
    //   134: getfield 237	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   137: arraylength
    //   138: aload_2
    //   139: getfield 263	com/tencent/liteav/basic/structs/TXSNALPacket:pts	J
    //   142: iconst_0
    //   143: invokevirtual 267	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   146: aload_0
    //   147: getfield 77	com/tencent/liteav/videodecoder/b:m	Ljava/util/ArrayList;
    //   150: iconst_0
    //   151: invokevirtual 242	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   154: pop
    //   155: aload_0
    //   156: getfield 60	com/tencent/liteav/videodecoder/b:f	J
    //   159: lconst_0
    //   160: lcmp
    //   161: ifne +18 -> 179
    //   164: ldc 86
    //   166: ldc_w 269
    //   169: iload_1
    //   170: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   173: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   176: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_0
    //   180: getfield 50	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   183: aload_0
    //   184: getfield 48	com/tencent/liteav/videodecoder/b:a	Landroid/media/MediaCodec$BufferInfo;
    //   187: ldc2_w 249
    //   190: invokevirtual 283	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   193: istore_1
    //   194: iload_1
    //   195: iflt +108 -> 303
    //   198: aload_0
    //   199: iload_1
    //   200: aload_0
    //   201: getfield 48	com/tencent/liteav/videodecoder/b:a	Landroid/media/MediaCodec$BufferInfo;
    //   204: getfield 286	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   207: aload_0
    //   208: getfield 48	com/tencent/liteav/videodecoder/b:a	Landroid/media/MediaCodec$BufferInfo;
    //   211: getfield 286	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   214: aload_2
    //   215: getfield 289	com/tencent/liteav/basic/structs/TXSNALPacket:rotation	I
    //   218: invokespecial 291	com/tencent/liteav/videodecoder/b:a	(IJJI)V
    //   221: aload_0
    //   222: iconst_0
    //   223: putfield 72	com/tencent/liteav/videodecoder/b:l	I
    //   226: ldc 225
    //   228: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: return
    //   232: astore 4
    //   234: ldc 86
    //   236: ldc_w 293
    //   239: aload 4
    //   241: invokestatic 296	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   244: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   247: invokestatic 111	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: sipush -10000
    //   253: istore_1
    //   254: goto -142 -> 112
    //   257: astore_3
    //   258: aload_0
    //   259: invokespecial 298	com/tencent/liteav/videodecoder/b:g	()V
    //   262: goto -107 -> 155
    //   265: ldc 86
    //   267: ldc_w 300
    //   270: invokestatic 158	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: goto -94 -> 179
    //   276: astore_3
    //   277: aload_0
    //   278: invokespecial 298	com/tencent/liteav/videodecoder/b:g	()V
    //   281: ldc 86
    //   283: ldc_w 302
    //   286: aload_3
    //   287: invokestatic 296	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   290: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   293: invokestatic 111	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: sipush -10000
    //   299: istore_1
    //   300: goto -106 -> 194
    //   303: iload_1
    //   304: iconst_m1
    //   305: if_icmpne +44 -> 349
    //   308: ldc2_w 303
    //   311: invokestatic 310	java/lang/Thread:sleep	(J)V
    //   314: ldc 86
    //   316: new 88	java/lang/StringBuilder
    //   319: dup
    //   320: ldc_w 312
    //   323: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   326: aload_0
    //   327: getfield 72	com/tencent/liteav/videodecoder/b:l	I
    //   330: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 200	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload_0
    //   340: invokespecial 298	com/tencent/liteav/videodecoder/b:g	()V
    //   343: ldc 225
    //   345: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: return
    //   349: iload_1
    //   350: bipush 253
    //   352: if_icmpne +17 -> 369
    //   355: ldc 86
    //   357: ldc_w 314
    //   360: invokestatic 200	com/tencent/liteav/basic/log/TXCLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: ldc 225
    //   365: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: iload_1
    //   370: bipush 254
    //   372: if_icmpne +13 -> 385
    //   375: aload_0
    //   376: invokespecial 316	com/tencent/liteav/videodecoder/b:c	()V
    //   379: ldc 225
    //   381: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: return
    //   385: ldc 86
    //   387: ldc_w 318
    //   390: iload_1
    //   391: invokestatic 275	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   394: invokevirtual 279	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   397: invokestatic 111	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: ldc 225
    //   402: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: return
    //   406: astore_2
    //   407: goto -93 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	b
    //   111	280	1	i1	int
    //   36	179	2	localTXSNALPacket	TXSNALPacket
    //   406	1	2	localInterruptedException	java.lang.InterruptedException
    //   78	39	3	arrayOfByteBuffer	ByteBuffer[]
    //   257	1	3	localException1	Exception
    //   276	11	3	localException2	Exception
    //   232	8	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   101	112	232	java/lang/Exception
    //   127	155	257	java/lang/Exception
    //   179	194	276	java/lang/Exception
    //   308	314	406	java/lang/InterruptedException
  }
  
  private void c()
  {
    AppMethodBeat.i(67775);
    MediaFormat localMediaFormat = this.b.getOutputFormat();
    TXCLog.d("MediaCodecDecoder", "decode output format changed: ".concat(String.valueOf(localMediaFormat)));
    int i3 = Math.abs(localMediaFormat.getInteger("crop-right") - localMediaFormat.getInteger("crop-left"));
    int i1 = Math.abs(localMediaFormat.getInteger("crop-bottom") - localMediaFormat.getInteger("crop-top"));
    int i4 = localMediaFormat.getInteger("width");
    int i2 = localMediaFormat.getInteger("height");
    i3 = Math.min(i3 + 1, i4);
    i1 = Math.min(i1 + 1, i2);
    if ((i3 != this.d) || (i1 != this.e))
    {
      this.d = i3;
      this.e = i1;
    }
    try
    {
      if (this.n != null) {
        this.n.onVideoSizeChange(this.d, this.e);
      }
      label159:
      TXCLog.d("MediaCodecDecoder", "decode: video size change to w:" + i3 + ",h:" + i1);
      AppMethodBeat.o(67775);
      return;
      if (this.h)
      {
        this.h = false;
        if (this.n != null) {
          this.n.onVideoSizeChange(this.d, this.e);
        }
      }
      AppMethodBeat.o(67775);
      return;
    }
    catch (Exception localException)
    {
      break label159;
    }
  }
  
  private void d()
  {
    AppMethodBeat.i(146268);
    if (this.f == 0L) {
      TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
    }
    long l1 = System.currentTimeMillis();
    if ((this.f > 0L) && (l1 > this.f + 1000L) && (l1 > this.g + 2000L) && (this.g != 0L))
    {
      TXCLog.e("MediaCodecDecoder", "frame interval[" + (l1 - this.f) + "] > 1000");
      this.g = l1;
    }
    if (this.g == 0L) {
      this.g = l1;
    }
    this.f = l1;
    AppMethodBeat.o(146268);
  }
  
  private boolean e()
  {
    AppMethodBeat.i(67782);
    Object localObject;
    int i3;
    int i1;
    String[] arrayOfString1;
    int i4;
    int i2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new MediaCodecList(1).getCodecInfos();
      i3 = localObject.length;
      i1 = 0;
      while (i1 < i3)
      {
        arrayOfString1 = localObject[i1];
        String[] arrayOfString2 = arrayOfString1.getSupportedTypes();
        i4 = arrayOfString2.length;
        i2 = 0;
        while (i2 < i4)
        {
          if (arrayOfString2[i2].contains("video/hevc"))
          {
            TXCLog.e("MediaCodecDecoder", "decode: video/hevc MediaCodecInfo: " + arrayOfString1.getName() + ",encoder:" + arrayOfString1.isEncoder());
            AppMethodBeat.o(67782);
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      AppMethodBeat.o(67782);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      i3 = MediaCodecList.getCodecCount();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = MediaCodecList.getCodecInfoAt(i1);
        arrayOfString1 = ((MediaCodecInfo)localObject).getSupportedTypes();
        i4 = arrayOfString1.length;
        i2 = 0;
        while (i2 < i4)
        {
          if (arrayOfString1[i2].contains("video/hevc"))
          {
            TXCLog.e("MediaCodecDecoder", "video/hevc MediaCodecInfo: " + ((MediaCodecInfo)localObject).getName() + ",encoder:" + ((MediaCodecInfo)localObject).isEncoder());
            AppMethodBeat.o(67782);
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    AppMethodBeat.o(67782);
    return false;
  }
  
  private void f()
  {
    AppMethodBeat.i(146269);
    if (!this.i)
    {
      TXCLog.w("MediaCodecDecoder", "decode: hw decode error, hevc: " + this.j);
      if (!this.j) {
        break label87;
      }
      com.tencent.liteav.basic.util.b.a(this.o, -2304, "h265解码失败");
    }
    for (;;)
    {
      this.i = true;
      if (this.n != null) {
        this.n.onDecodeFailed(-1);
      }
      AppMethodBeat.o(146269);
      return;
      label87:
      com.tencent.liteav.basic.util.b.a(this.o, 2106, "硬解启动失败，采用软解");
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(146270);
    if (this.l >= 40)
    {
      f();
      this.l = 0;
      AppMethodBeat.o(146270);
      return;
    }
    this.l += 1;
    AppMethodBeat.o(146270);
  }
  
  public int config(Surface paramSurface)
  {
    if (paramSurface == null) {
      return -1;
    }
    this.k = paramSurface;
    return 0;
  }
  
  public void decode(TXSNALPacket paramTXSNALPacket)
  {
    boolean bool = true;
    AppMethodBeat.i(146261);
    if (paramTXSNALPacket.codecId == 1) {}
    for (;;)
    {
      a(bool);
      this.m.add(paramTXSNALPacket);
      int i1;
      do
      {
        if (this.m.isEmpty()) {
          break;
        }
        i1 = this.m.size();
        b();
      } while (i1 != this.m.size());
      AppMethodBeat.o(146261);
      return;
      bool = false;
    }
  }
  
  public boolean isHevc()
  {
    return this.j;
  }
  
  public void setListener(c paramc)
  {
    this.n = paramc;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference)
  {
    this.o = paramWeakReference;
  }
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146262);
    int i1 = a(paramByteBuffer1, paramByteBuffer2, paramBoolean2);
    AppMethodBeat.o(146262);
    return i1;
  }
  
  public void stop()
  {
    AppMethodBeat.i(146263);
    a();
    AppMethodBeat.o(146263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.b
 * JD-Core Version:    0.7.0.1
 */