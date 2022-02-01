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
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class z
{
  public volatile boolean dbi;
  public MediaCodec gJE;
  public MediaCodecProxyUtils.a gJF;
  public AtomicInteger gJG;
  private AtomicInteger gJH;
  private AtomicInteger gJI;
  private AtomicInteger gJJ;
  private AtomicInteger gJK;
  private final int gJL;
  private long gJM;
  private long gJN;
  
  private z(MediaCodec paramMediaCodec, MediaCodecProxyUtils.a parama)
  {
    AppMethodBeat.i(155772);
    this.dbi = false;
    this.gJG = new AtomicInteger();
    this.gJH = new AtomicInteger();
    this.gJI = new AtomicInteger();
    this.gJJ = new AtomicInteger();
    this.gJK = new AtomicInteger();
    this.gJL = 10;
    this.gJM = 0L;
    this.gJN = 5000L;
    this.gJE = paramMediaCodec;
    this.gJF = parama;
    this.dbi = true;
    AppMethodBeat.o(155772);
  }
  
  public static z DZ(String paramString)
  {
    AppMethodBeat.i(155768);
    Log.i("MicroMsg.MediaCodecProxy", "into createDecoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.oA(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.oA(60);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createDecoderByType(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.oA(61);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.a(localMediaCodec.hashCode(), false, paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.a(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.aoY();
      localObject1 = localObject2;
      localObject2 = new z(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
      AppMethodBeat.o(155768);
      return localObject2;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "createDecoderByType error ".concat(String.valueOf(paramString)), new Object[0]);
      a(0, localException, localObject1);
      MediaCodecProxyUtils.a(false, paramString, localObject1);
      AppMethodBeat.o(155768);
      throw localException;
    }
  }
  
  public static z Ea(String paramString)
  {
    AppMethodBeat.i(155769);
    paramString = q(paramString, false);
    AppMethodBeat.o(155769);
    return paramString;
  }
  
  public static z Eb(String paramString)
  {
    AppMethodBeat.i(155771);
    Log.i("MicroMsg.MediaCodecProxy", "into createByCodecName, name = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.oA(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.oA(66);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createByCodecName(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.oA(67);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.v(localMediaCodec.hashCode(), paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.aoY();
      localObject1 = localObject2;
      localObject2 = new z(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
      AppMethodBeat.o(155771);
      return localObject2;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "createByCodecName func error ".concat(String.valueOf(paramString)), new Object[0]);
      a(2, localException, localObject1);
      MediaCodecProxyUtils.c(paramString, localObject1);
      AppMethodBeat.o(155771);
      throw localException;
    }
  }
  
  public static void a(int paramInt, Exception paramException, MediaCodecProxyUtils.a parama)
  {
    AppMethodBeat.i(155796);
    if (parama != null) {
      parama.stack = h(paramException);
    }
    MediaCodecProxyUtils.b.oA(paramInt);
    MediaCodecProxyUtils.b.a(paramInt, parama);
    AppMethodBeat.o(155796);
  }
  
  private void aoX()
  {
    AppMethodBeat.i(155774);
    int i = this.gJG.get() + this.gJJ.get() + this.gJK.get() + this.gJH.get() + this.gJI.get();
    if (i > 10)
    {
      Log.d("MicroMsg.MediaCodecProxy", "reportCount count:[%d]", new Object[] { Integer.valueOf(i) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("countFlush:").append(this.gJG).append(";countDequeueInputBuffer:").append(this.gJJ).append(";countDequeueOutputBuffer:").append(this.gJK).append(";countQueueInputBuffer:").append(this.gJH).append(";countQueueSecureInputBuffer:").append(this.gJI).append(";");
      if (this.gJF != null)
      {
        String str = "";
        if (this.gJF.gJX != null) {
          str = this.gJF.gJX.replace(",", ";");
        }
        localStringBuilder.append(this.gJF.gJV).append(";").append(this.gJF.mimeType).append(";").append(this.gJF.gJW).append(";").append(MMApplicationContext.getProcessName()).append(";").append(str).append(";stack:").append(this.gJF.stack);
      }
      MediaCodecProxyUtils.b.oA(16);
      MediaCodecProxyUtils.b.w(16, localStringBuilder.toString());
      this.gJG.set(0);
      this.gJJ.set(0);
      this.gJK.set(0);
      this.gJH.set(0);
      this.gJI.set(0);
    }
    AppMethodBeat.o(155774);
  }
  
  private static String h(Exception paramException)
  {
    AppMethodBeat.i(155795);
    if (paramException != null)
    {
      paramException = paramException.toString() + "----" + Util.getStack().toString();
      AppMethodBeat.o(155795);
      return paramException;
    }
    paramException = Util.getStack().toString();
    AppMethodBeat.o(155795);
    return paramException;
  }
  
  public static z q(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(155770);
    Log.i("MicroMsg.MediaCodecProxy", "into createEncoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.oA(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.oA(63);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createEncoderByType(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.oA(64);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.a(localMediaCodec.hashCode(), true, paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.a(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.aoY();
      localObject1 = localObject2;
      localObject2 = new z(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
      AppMethodBeat.o(155770);
      return localObject2;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "createByCodecName error ".concat(String.valueOf(paramString)), new Object[0]);
      if (!paramBoolean)
      {
        a(1, localException, localObject1);
        MediaCodecProxyUtils.a(true, paramString, localObject1);
      }
      AppMethodBeat.o(155770);
      throw localException;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(155779);
    try
    {
      if (!this.dbi)
      {
        Log.e("MicroMsg.MediaCodecProxy", "queueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy queueInputBuffer not alive");
      }
      this.gJE.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
      AppMethodBeat.o(155779);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.oA(40);
      this.gJH.getAndIncrement();
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.gJM > this.gJN))
      {
        this.gJM = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new z.1(this));
      }
      AppMethodBeat.o(155779);
      throw localException;
    }
  }
  
  /* Error */
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 334
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 71
    //   8: ldc_w 336
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: invokestatic 278	android/os/Process:myTid	()I
    //   20: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: invokestatic 284	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: invokevirtual 287	java/lang/Thread:getName	()Ljava/lang/String;
    //   32: aastore
    //   33: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: new 187	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 338
    //   43: invokespecial 341	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: astore 5
    //   48: aload_1
    //   49: ifnull +117 -> 166
    //   52: aload_1
    //   53: invokevirtual 344	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload 5
    //   60: aload 4
    //   62: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 346
    //   68: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: astore 5
    //   73: aload_2
    //   74: ifnull +100 -> 174
    //   77: aload_2
    //   78: invokevirtual 349	android/view/Surface:toString	()Ljava/lang/String;
    //   81: astore 4
    //   83: ldc 71
    //   85: aload 5
    //   87: aload 4
    //   89: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 351
    //   95: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload_3
    //   99: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 356	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 35	com/tencent/mm/compatible/deviceinfo/z:dbi	Z
    //   112: ifne +11 -> 123
    //   115: ldc 71
    //   117: ldc_w 358
    //   120: invokestatic 295	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: ifnull +14 -> 138
    //   127: aload_0
    //   128: getfield 60	com/tencent/mm/compatible/deviceinfo/z:gJF	Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;
    //   131: aload_1
    //   132: invokevirtual 344	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   135: putfield 212	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a:gJX	Ljava/lang/String;
    //   138: bipush 75
    //   140: invokestatic 86	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$b:oA	(I)V
    //   143: aload_0
    //   144: getfield 58	com/tencent/mm/compatible/deviceinfo/z:gJE	Landroid/media/MediaCodec;
    //   147: aload_1
    //   148: aload_2
    //   149: aconst_null
    //   150: iload_3
    //   151: invokevirtual 362	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   154: bipush 76
    //   156: invokestatic 86	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$b:oA	(I)V
    //   159: ldc_w 334
    //   162: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: ldc_w 364
    //   169: astore 4
    //   171: goto -113 -> 58
    //   174: ldc_w 364
    //   177: astore 4
    //   179: goto -96 -> 83
    //   182: astore_1
    //   183: ldc 71
    //   185: aload_1
    //   186: ldc_w 366
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: bipush 32
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 60	com/tencent/mm/compatible/deviceinfo/z:gJF	Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;
    //   203: invokestatic 129	com/tencent/mm/compatible/deviceinfo/z:a	(ILjava/lang/Exception;Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;)V
    //   206: ldc_w 334
    //   209: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      MediaCodecProxyUtils.b.oA(87);
      Surface localSurface = this.gJE.createInputSurface();
      MediaCodecProxyUtils.b.oA(88);
      AppMethodBeat.o(155776);
      return localSurface;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy createInputSurface", new Object[0]);
      a(36, localException, this.gJF);
      AppMethodBeat.o(155776);
      throw localException;
    }
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(155780);
    try
    {
      if (!this.dbi)
      {
        Log.e("MicroMsg.MediaCodecProxy", "dequeueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueInputBuffer not alive");
      }
      int i = this.gJE.dequeueInputBuffer(paramLong);
      AppMethodBeat.o(155780);
      return i;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy dequeueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.oA(42);
      this.gJJ.getAndIncrement();
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.gJM > this.gJN))
      {
        this.gJM = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new z.2(this));
      }
      AppMethodBeat.o(155780);
      throw localException;
    }
  }
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(155781);
    try
    {
      if (!this.dbi)
      {
        Log.e("MicroMsg.MediaCodecProxy", "dequeueOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueOutputBuffer not alive");
      }
      int i = this.gJE.dequeueOutputBuffer(paramBufferInfo, paramLong);
      AppMethodBeat.o(155781);
      return i;
    }
    catch (Exception paramBufferInfo)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBufferInfo, "MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.oA(43);
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.gJM > this.gJN))
      {
        this.gJM = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new z.3(this));
      }
      this.gJK.getAndIncrement();
      AppMethodBeat.o(155781);
      throw paramBufferInfo;
    }
  }
  
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(155788);
    try
    {
      MediaCodecProxyUtils.b.oA(132);
      ByteBuffer localByteBuffer = this.gJE.getInputBuffer(paramInt);
      MediaCodecProxyUtils.b.oA(133);
      AppMethodBeat.o(155788);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffer", new Object[0]);
      a(51, localException, this.gJF);
      AppMethodBeat.o(155788);
      throw localException;
    }
  }
  
  public final ByteBuffer[] getInputBuffers()
  {
    AppMethodBeat.i(155786);
    try
    {
      MediaCodecProxyUtils.b.oA(126);
      ByteBuffer[] arrayOfByteBuffer = this.gJE.getInputBuffers();
      MediaCodecProxyUtils.b.oA(127);
      AppMethodBeat.o(155786);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffers", new Object[0]);
      a(49, localException, this.gJF);
      AppMethodBeat.o(155786);
      throw localException;
    }
  }
  
  public final String getName()
  {
    AppMethodBeat.i(155791);
    try
    {
      MediaCodecProxyUtils.b.oA(147);
      String str = this.gJE.getName();
      MediaCodecProxyUtils.b.oA(148);
      AppMethodBeat.o(155791);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getName", new Object[0]);
      a(56, localException, this.gJF);
      AppMethodBeat.o(155791);
      throw localException;
    }
  }
  
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    AppMethodBeat.i(155789);
    try
    {
      MediaCodecProxyUtils.b.oA(135);
      ByteBuffer localByteBuffer = this.gJE.getOutputBuffer(paramInt);
      MediaCodecProxyUtils.b.oA(136);
      AppMethodBeat.o(155789);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffer", new Object[0]);
      a(53, localException, this.gJF);
      AppMethodBeat.o(155789);
      throw localException;
    }
  }
  
  public final ByteBuffer[] getOutputBuffers()
  {
    AppMethodBeat.i(155787);
    try
    {
      MediaCodecProxyUtils.b.oA(129);
      ByteBuffer[] arrayOfByteBuffer = this.gJE.getOutputBuffers();
      MediaCodecProxyUtils.b.oA(130);
      AppMethodBeat.o(155787);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffers", new Object[0]);
      a(50, localException, this.gJF);
      AppMethodBeat.o(155787);
      throw localException;
    }
  }
  
  public final MediaFormat getOutputFormat()
  {
    AppMethodBeat.i(155785);
    try
    {
      MediaCodecProxyUtils.b.oA(120);
      MediaFormat localMediaFormat = this.gJE.getOutputFormat();
      MediaCodecProxyUtils.b.oA(121);
      AppMethodBeat.o(155785);
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputFormat, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(47, localException, this.gJF);
      AppMethodBeat.o(155785);
      throw localException;
    }
  }
  
  public final Image getOutputImage(int paramInt)
  {
    AppMethodBeat.i(155790);
    try
    {
      MediaCodecProxyUtils.b.oA(141);
      Image localImage = this.gJE.getOutputImage(paramInt);
      MediaCodecProxyUtils.b.oA(142);
      AppMethodBeat.o(155790);
      return localImage;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputImage", new Object[0]);
      a(54, localException, this.gJF);
      AppMethodBeat.o(155790);
      throw localException;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(155773);
    try
    {
      MediaCodecProxyUtils.b.oA(11);
      Log.i("MicroMsg.MediaCodecProxy", "into release function, thread:[%s], stack:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Util.getStack().toString() });
      if (!this.dbi)
      {
        Log.e("MicroMsg.MediaCodecProxy", "release error, multi release, stack:[%s]", new Object[] { Util.getStack().toString() });
        a(10, null, this.gJF);
      }
      MediaCodecProxyUtils.oz(this.gJE.hashCode());
      MediaCodecProxyUtils.aoY();
      MediaCodecProxyUtils.b.oA(69);
      this.gJE.release();
      MediaCodecProxyUtils.b.oA(70);
      aoX();
      this.dbi = false;
      AppMethodBeat.o(155773);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy release", new Object[0]);
      a(30, localException, this.gJF);
      AppMethodBeat.o(155773);
      throw localException;
    }
  }
  
  public final void releaseOutputBuffer(int paramInt, long paramLong)
  {
    AppMethodBeat.i(155783);
    try
    {
      if (!this.dbi)
      {
        Log.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
      }
      MediaCodecProxyUtils.b.oA(114);
      this.gJE.releaseOutputBuffer(paramInt, paramLong);
      MediaCodecProxyUtils.b.oA(115);
      AppMethodBeat.o(155783);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy releaseOutputBuffer 2, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(45, localException, this.gJF);
      AppMethodBeat.o(155783);
      throw localException;
    }
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(155782);
    try
    {
      if (!this.dbi)
      {
        Log.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
      }
      this.gJE.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(155782);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy releaseOutputBuffer 1, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(44, localException, this.gJF);
      AppMethodBeat.o(155782);
      throw localException;
    }
  }
  
  public final void setCallback(MediaCodec.Callback paramCallback)
  {
    AppMethodBeat.i(155794);
    this.gJE.setCallback(paramCallback);
    AppMethodBeat.o(155794);
  }
  
  @TargetApi(23)
  public final void setCallback(MediaCodec.Callback paramCallback, Handler paramHandler)
  {
    AppMethodBeat.i(155793);
    this.gJE.setCallback(paramCallback, paramHandler);
    AppMethodBeat.o(155793);
  }
  
  public final void setParameters(Bundle paramBundle)
  {
    AppMethodBeat.i(155792);
    try
    {
      MediaCodecProxyUtils.b.oA(150);
      this.gJE.setParameters(paramBundle);
      MediaCodecProxyUtils.b.oA(151);
      AppMethodBeat.o(155792);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBundle, "MediaCodecProxy setParameters, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(57, paramBundle, this.gJF);
      AppMethodBeat.o(155792);
      throw paramBundle;
    }
  }
  
  public final void signalEndOfInputStream()
  {
    AppMethodBeat.i(155784);
    try
    {
      Log.i("MicroMsg.MediaCodecProxy", "signalEndOfInputStream function, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.oA(117);
      this.gJE.signalEndOfInputStream();
      MediaCodecProxyUtils.b.oA(118);
      AppMethodBeat.o(155784);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy signalEndOfInputStream, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(46, localException, this.gJF);
      AppMethodBeat.o(155784);
      throw localException;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(155777);
    try
    {
      Log.i("MicroMsg.MediaCodecProxy", "start function, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      if (!this.dbi) {
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy start not alive");
      }
      MediaCodecProxyUtils.b.oA(90);
      this.gJE.start();
      MediaCodecProxyUtils.b.oA(91);
      AppMethodBeat.o(155777);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy start", new Object[0]);
      a(37, localException, this.gJF);
      AppMethodBeat.o(155777);
      throw localException;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(155778);
    try
    {
      Log.i("MicroMsg.MediaCodecProxy", "stop function, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      if (!this.dbi) {
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy stop not alive");
      }
      MediaCodecProxyUtils.b.oA(93);
      this.gJE.stop();
      MediaCodecProxyUtils.b.oA(94);
      AppMethodBeat.o(155778);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy stop", new Object[0]);
      a(38, localException, this.gJF);
      AppMethodBeat.o(155778);
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.z
 * JD-Core Version:    0.7.0.1
 */