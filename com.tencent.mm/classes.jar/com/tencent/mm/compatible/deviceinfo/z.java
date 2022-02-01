package com.tencent.mm.compatible.deviceinfo;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class z
{
  public volatile boolean czg;
  private AtomicInteger fIA;
  private AtomicInteger fIB;
  private AtomicInteger fIC;
  private AtomicInteger fID;
  private final int fIE;
  public MediaCodec fIx;
  public MediaCodecProxyUtils.a fIy;
  public AtomicInteger fIz;
  
  private z(MediaCodec paramMediaCodec, MediaCodecProxyUtils.a parama)
  {
    AppMethodBeat.i(155772);
    this.czg = false;
    this.fIz = new AtomicInteger();
    this.fIA = new AtomicInteger();
    this.fIB = new AtomicInteger();
    this.fIC = new AtomicInteger();
    this.fID = new AtomicInteger();
    this.fIE = 10;
    this.fIx = paramMediaCodec;
    this.fIy = parama;
    this.czg = true;
    AppMethodBeat.o(155772);
  }
  
  private void Yn()
  {
    AppMethodBeat.i(155774);
    int i = this.fIz.get() + this.fIC.get() + this.fID.get() + this.fIA.get() + this.fIB.get();
    if (i > 10)
    {
      ac.d("MicroMsg.MediaCodecProxy", "reportCount count:[%d]", new Object[] { Integer.valueOf(i) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("countFlush:").append(this.fIz).append(";countDequeueInputBuffer:").append(this.fIC).append(";countDequeueOutputBuffer:").append(this.fID).append(";countQueueInputBuffer:").append(this.fIA).append(";countQueueSecureInputBuffer:").append(this.fIB).append(";");
      if (this.fIy != null)
      {
        String str = "";
        if (this.fIy.fIN != null) {
          str = this.fIy.fIN.replace(",", ";");
        }
        localStringBuilder.append(this.fIy.fIL).append(";").append(this.fIy.mimeType).append(";").append(this.fIy.fIM).append(";").append(ai.getProcessName()).append(";").append(str).append(";stack:").append(this.fIy.stack);
      }
      MediaCodecProxyUtils.b.kW(16);
      MediaCodecProxyUtils.b.u(16, localStringBuilder.toString());
      this.fIz.set(0);
      this.fIC.set(0);
      this.fID.set(0);
      this.fIA.set(0);
      this.fIB.set(0);
    }
    AppMethodBeat.o(155774);
  }
  
  public static void a(int paramInt, Exception paramException, MediaCodecProxyUtils.a parama)
  {
    AppMethodBeat.i(155796);
    if (parama != null) {
      parama.stack = h(paramException);
    }
    MediaCodecProxyUtils.b.kW(paramInt);
    MediaCodecProxyUtils.b.a(paramInt, parama);
    AppMethodBeat.o(155796);
  }
  
  private static String h(Exception paramException)
  {
    AppMethodBeat.i(155795);
    if (paramException != null)
    {
      paramException = paramException.toString() + "----" + bs.eWi().toString();
      AppMethodBeat.o(155795);
      return paramException;
    }
    paramException = bs.eWi().toString();
    AppMethodBeat.o(155795);
    return paramException;
  }
  
  public static z q(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(155770);
    ac.i("MicroMsg.MediaCodecProxy", "into createEncoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.kW(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.kW(63);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createEncoderByType(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.kW(64);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.a(localMediaCodec.hashCode(), true, paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.a(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.Yo();
      localObject1 = localObject2;
      localObject2 = new z(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
      AppMethodBeat.o(155770);
      return localObject2;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "createByCodecName error ".concat(String.valueOf(paramString)), new Object[0]);
      if (!paramBoolean)
      {
        a(1, localException, localObject1);
        MediaCodecProxyUtils.a(true, paramString, localObject1);
      }
      AppMethodBeat.o(155770);
      throw localException;
    }
  }
  
  public static z sx(String paramString)
  {
    AppMethodBeat.i(155768);
    ac.i("MicroMsg.MediaCodecProxy", "into createDecoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.kW(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.kW(60);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createDecoderByType(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.kW(61);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.a(localMediaCodec.hashCode(), false, paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.a(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.Yo();
      localObject1 = localObject2;
      localObject2 = new z(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
      AppMethodBeat.o(155768);
      return localObject2;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "createDecoderByType error ".concat(String.valueOf(paramString)), new Object[0]);
      a(0, localException, localObject1);
      MediaCodecProxyUtils.a(false, paramString, localObject1);
      AppMethodBeat.o(155768);
      throw localException;
    }
  }
  
  public static z sy(String paramString)
  {
    AppMethodBeat.i(155769);
    paramString = q(paramString, false);
    AppMethodBeat.o(155769);
    return paramString;
  }
  
  public static z sz(String paramString)
  {
    AppMethodBeat.i(155771);
    ac.i("MicroMsg.MediaCodecProxy", "into createByCodecName, name = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.kW(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.kW(66);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createByCodecName(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.kW(67);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.t(localMediaCodec.hashCode(), paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.Yo();
      localObject1 = localObject2;
      localObject2 = new z(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
      AppMethodBeat.o(155771);
      return localObject2;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "createByCodecName func error ".concat(String.valueOf(paramString)), new Object[0]);
      a(2, localException, localObject1);
      MediaCodecProxyUtils.c(paramString, localObject1);
      AppMethodBeat.o(155771);
      throw localException;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(155779);
    try
    {
      if (!this.czg)
      {
        ac.e("MicroMsg.MediaCodecProxy", "queueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        ac.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy queueInputBuffer not alive");
      }
      this.fIx.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
      AppMethodBeat.o(155779);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.kW(40);
      this.fIA.getAndIncrement();
      AppMethodBeat.o(155779);
      throw localException;
    }
  }
  
  /* Error */
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 297
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 63
    //   8: ldc_w 299
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: invokestatic 269	android/os/Process:myTid	()I
    //   20: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: invokestatic 275	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: invokevirtual 278	java/lang/Thread:getName	()Ljava/lang/String;
    //   32: aastore
    //   33: invokestatic 185	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: new 79	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 301
    //   43: invokespecial 304	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: astore 5
    //   48: aload_1
    //   49: ifnull +117 -> 166
    //   52: aload_1
    //   53: invokevirtual 307	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload 5
    //   60: aload 4
    //   62: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 309
    //   68: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: astore 5
    //   73: aload_2
    //   74: ifnull +100 -> 174
    //   77: aload_2
    //   78: invokevirtual 312	android/view/Surface:toString	()Ljava/lang/String;
    //   81: astore 4
    //   83: ldc 63
    //   85: aload 5
    //   87: aload 4
    //   89: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 314
    //   95: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload_3
    //   99: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 319	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 32	com/tencent/mm/compatible/deviceinfo/z:czg	Z
    //   112: ifne +11 -> 123
    //   115: ldc 63
    //   117: ldc_w 321
    //   120: invokestatic 286	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: ifnull +14 -> 138
    //   127: aload_0
    //   128: getfield 51	com/tencent/mm/compatible/deviceinfo/z:fIy	Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;
    //   131: aload_1
    //   132: invokevirtual 307	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   135: putfield 107	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a:fIN	Ljava/lang/String;
    //   138: bipush 75
    //   140: invokestatic 143	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$b:kW	(I)V
    //   143: aload_0
    //   144: getfield 49	com/tencent/mm/compatible/deviceinfo/z:fIx	Landroid/media/MediaCodec;
    //   147: aload_1
    //   148: aload_2
    //   149: aconst_null
    //   150: iload_3
    //   151: invokevirtual 325	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   154: bipush 76
    //   156: invokestatic 143	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$b:kW	(I)V
    //   159: ldc_w 297
    //   162: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: ldc_w 327
    //   169: astore 4
    //   171: goto -113 -> 58
    //   174: ldc_w 327
    //   177: astore 4
    //   179: goto -96 -> 83
    //   182: astore_1
    //   183: ldc 63
    //   185: aload_1
    //   186: ldc_w 329
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 221	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: bipush 32
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 51	com/tencent/mm/compatible/deviceinfo/z:fIy	Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;
    //   203: invokestatic 223	com/tencent/mm/compatible/deviceinfo/z:a	(ILjava/lang/Exception;Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;)V
    //   206: ldc_w 297
    //   209: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	z
    //   0	214	1	paramMediaFormat	MediaFormat
    //   0	214	2	paramSurface	Surface
    //   0	214	3	paramInt	int
    //   56	122	4	str	String
    //   46	40	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	48	182	java/lang/Exception
    //   52	58	182	java/lang/Exception
    //   58	73	182	java/lang/Exception
    //   77	83	182	java/lang/Exception
    //   83	123	182	java/lang/Exception
    //   127	138	182	java/lang/Exception
    //   138	159	182	java/lang/Exception
  }
  
  public final Surface createInputSurface()
  {
    AppMethodBeat.i(155776);
    try
    {
      MediaCodecProxyUtils.b.kW(87);
      Surface localSurface = this.fIx.createInputSurface();
      MediaCodecProxyUtils.b.kW(88);
      AppMethodBeat.o(155776);
      return localSurface;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy createInputSurface", new Object[0]);
      a(36, localException, this.fIy);
      AppMethodBeat.o(155776);
      throw localException;
    }
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(155780);
    try
    {
      if (!this.czg)
      {
        ac.e("MicroMsg.MediaCodecProxy", "dequeueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        ac.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueInputBuffer not alive");
      }
      int i = this.fIx.dequeueInputBuffer(paramLong);
      AppMethodBeat.o(155780);
      return i;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy dequeueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.kW(42);
      this.fIC.getAndIncrement();
      AppMethodBeat.o(155780);
      throw localException;
    }
  }
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(155781);
    try
    {
      if (!this.czg)
      {
        ac.e("MicroMsg.MediaCodecProxy", "dequeueOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        ac.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueOutputBuffer not alive");
      }
      int i = this.fIx.dequeueOutputBuffer(paramBufferInfo, paramLong);
      AppMethodBeat.o(155781);
      return i;
    }
    catch (Exception paramBufferInfo)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBufferInfo, "MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.kW(43);
      this.fID.getAndIncrement();
      AppMethodBeat.o(155781);
      throw paramBufferInfo;
    }
  }
  
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(155788);
    try
    {
      MediaCodecProxyUtils.b.kW(132);
      ByteBuffer localByteBuffer = this.fIx.getInputBuffer(paramInt);
      MediaCodecProxyUtils.b.kW(133);
      AppMethodBeat.o(155788);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffer", new Object[0]);
      a(51, localException, this.fIy);
      AppMethodBeat.o(155788);
      throw localException;
    }
  }
  
  public final ByteBuffer[] getInputBuffers()
  {
    AppMethodBeat.i(155786);
    try
    {
      MediaCodecProxyUtils.b.kW(126);
      ByteBuffer[] arrayOfByteBuffer = this.fIx.getInputBuffers();
      MediaCodecProxyUtils.b.kW(127);
      AppMethodBeat.o(155786);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffers", new Object[0]);
      a(49, localException, this.fIy);
      AppMethodBeat.o(155786);
      throw localException;
    }
  }
  
  public final String getName()
  {
    AppMethodBeat.i(155791);
    try
    {
      MediaCodecProxyUtils.b.kW(147);
      String str = this.fIx.getName();
      MediaCodecProxyUtils.b.kW(148);
      AppMethodBeat.o(155791);
      return str;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getName", new Object[0]);
      a(56, localException, this.fIy);
      AppMethodBeat.o(155791);
      throw localException;
    }
  }
  
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    AppMethodBeat.i(155789);
    try
    {
      MediaCodecProxyUtils.b.kW(135);
      ByteBuffer localByteBuffer = this.fIx.getOutputBuffer(paramInt);
      MediaCodecProxyUtils.b.kW(136);
      AppMethodBeat.o(155789);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffer", new Object[0]);
      a(53, localException, this.fIy);
      AppMethodBeat.o(155789);
      throw localException;
    }
  }
  
  public final ByteBuffer[] getOutputBuffers()
  {
    AppMethodBeat.i(155787);
    try
    {
      MediaCodecProxyUtils.b.kW(129);
      ByteBuffer[] arrayOfByteBuffer = this.fIx.getOutputBuffers();
      MediaCodecProxyUtils.b.kW(130);
      AppMethodBeat.o(155787);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffers", new Object[0]);
      a(50, localException, this.fIy);
      AppMethodBeat.o(155787);
      throw localException;
    }
  }
  
  public final MediaFormat getOutputFormat()
  {
    AppMethodBeat.i(155785);
    try
    {
      MediaCodecProxyUtils.b.kW(120);
      MediaFormat localMediaFormat = this.fIx.getOutputFormat();
      MediaCodecProxyUtils.b.kW(121);
      AppMethodBeat.o(155785);
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputFormat, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(47, localException, this.fIy);
      AppMethodBeat.o(155785);
      throw localException;
    }
  }
  
  public final Image getOutputImage(int paramInt)
  {
    AppMethodBeat.i(155790);
    try
    {
      MediaCodecProxyUtils.b.kW(141);
      Image localImage = this.fIx.getOutputImage(paramInt);
      MediaCodecProxyUtils.b.kW(142);
      AppMethodBeat.o(155790);
      return localImage;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputImage", new Object[0]);
      a(54, localException, this.fIy);
      AppMethodBeat.o(155790);
      throw localException;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(155773);
    try
    {
      MediaCodecProxyUtils.b.kW(11);
      ac.i("MicroMsg.MediaCodecProxy", "into release function, thread:[%s], stack:[%s]", new Object[] { Integer.valueOf(Process.myTid()), bs.eWi().toString() });
      if (!this.czg)
      {
        ac.e("MicroMsg.MediaCodecProxy", "release error, multi release, stack:[%s]", new Object[] { bs.eWi().toString() });
        a(10, null, this.fIy);
      }
      MediaCodecProxyUtils.kV(this.fIx.hashCode());
      MediaCodecProxyUtils.Yo();
      MediaCodecProxyUtils.b.kW(69);
      this.fIx.release();
      MediaCodecProxyUtils.b.kW(70);
      Yn();
      this.czg = false;
      AppMethodBeat.o(155773);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy release", new Object[0]);
      a(30, localException, this.fIy);
      AppMethodBeat.o(155773);
      throw localException;
    }
  }
  
  public final void releaseOutputBuffer(int paramInt, long paramLong)
  {
    AppMethodBeat.i(155783);
    try
    {
      if (!this.czg)
      {
        ac.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        ac.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
      }
      MediaCodecProxyUtils.b.kW(114);
      this.fIx.releaseOutputBuffer(paramInt, paramLong);
      MediaCodecProxyUtils.b.kW(115);
      AppMethodBeat.o(155783);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy releaseOutputBuffer 2, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(45, localException, this.fIy);
      AppMethodBeat.o(155783);
      throw localException;
    }
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(155782);
    try
    {
      if (!this.czg)
      {
        ac.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        ac.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
      }
      this.fIx.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(155782);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy releaseOutputBuffer 1, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(44, localException, this.fIy);
      AppMethodBeat.o(155782);
      throw localException;
    }
  }
  
  public final void setCallback(MediaCodec.Callback paramCallback)
  {
    AppMethodBeat.i(155794);
    this.fIx.setCallback(paramCallback);
    AppMethodBeat.o(155794);
  }
  
  @TargetApi(23)
  public final void setCallback(MediaCodec.Callback paramCallback, Handler paramHandler)
  {
    AppMethodBeat.i(155793);
    this.fIx.setCallback(paramCallback, paramHandler);
    AppMethodBeat.o(155793);
  }
  
  public final void setParameters(Bundle paramBundle)
  {
    AppMethodBeat.i(155792);
    try
    {
      MediaCodecProxyUtils.b.kW(150);
      this.fIx.setParameters(paramBundle);
      MediaCodecProxyUtils.b.kW(151);
      AppMethodBeat.o(155792);
      return;
    }
    catch (Exception paramBundle)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBundle, "MediaCodecProxy setParameters, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(57, paramBundle, this.fIy);
      AppMethodBeat.o(155792);
      throw paramBundle;
    }
  }
  
  public final void signalEndOfInputStream()
  {
    AppMethodBeat.i(155784);
    try
    {
      ac.i("MicroMsg.MediaCodecProxy", "signalEndOfInputStream function, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.kW(117);
      this.fIx.signalEndOfInputStream();
      MediaCodecProxyUtils.b.kW(118);
      AppMethodBeat.o(155784);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy signalEndOfInputStream, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(46, localException, this.fIy);
      AppMethodBeat.o(155784);
      throw localException;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(155777);
    try
    {
      ac.i("MicroMsg.MediaCodecProxy", "start function, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      if (!this.czg) {
        ac.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy start not alive");
      }
      MediaCodecProxyUtils.b.kW(90);
      this.fIx.start();
      MediaCodecProxyUtils.b.kW(91);
      AppMethodBeat.o(155777);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy start", new Object[0]);
      a(37, localException, this.fIy);
      AppMethodBeat.o(155777);
      throw localException;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(155778);
    try
    {
      ac.i("MicroMsg.MediaCodecProxy", "stop function, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      if (!this.czg) {
        ac.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy stop not alive");
      }
      MediaCodecProxyUtils.b.kW(93);
      this.fIx.stop();
      MediaCodecProxyUtils.b.kW(94);
      AppMethodBeat.o(155778);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy stop", new Object[0]);
      a(38, localException, this.fIy);
      AppMethodBeat.o(155778);
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.z
 * JD-Core Version:    0.7.0.1
 */