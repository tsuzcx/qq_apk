package com.tencent.mm.compatible.deviceinfo;

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

public final class aa
{
  public volatile boolean fez;
  public MediaCodec lXj;
  public MediaCodecProxyUtils.a lXk;
  public AtomicInteger lXl;
  private AtomicInteger lXm;
  private AtomicInteger lXn;
  private AtomicInteger lXo;
  private AtomicInteger lXp;
  private final int lXq;
  private long lXr;
  private long lXs;
  
  private aa(MediaCodec paramMediaCodec, MediaCodecProxyUtils.a parama)
  {
    AppMethodBeat.i(155772);
    this.fez = false;
    this.lXl = new AtomicInteger();
    this.lXm = new AtomicInteger();
    this.lXn = new AtomicInteger();
    this.lXo = new AtomicInteger();
    this.lXp = new AtomicInteger();
    this.lXq = 10;
    this.lXr = 0L;
    this.lXs = 5000L;
    this.lXj = paramMediaCodec;
    this.lXk = parama;
    this.fez = true;
    AppMethodBeat.o(155772);
  }
  
  public static aa Dw(String paramString)
  {
    AppMethodBeat.i(155768);
    Log.i("MicroMsg.MediaCodecProxy", "into createDecoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.qY(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qY(60);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createDecoderByType(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qY(61);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.a(localMediaCodec.hashCode(), false, paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.a(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.aPF();
      localObject1 = localObject2;
      localObject2 = new aa(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
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
  
  public static aa Dx(String paramString)
  {
    AppMethodBeat.i(155771);
    Log.i("MicroMsg.MediaCodecProxy", "into createByCodecName, name = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.qY(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qY(66);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createByCodecName(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qY(67);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.w(localMediaCodec.hashCode(), paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.aPF();
      localObject1 = localObject2;
      localObject2 = new aa(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
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
      parama.stack = g(paramException);
    }
    MediaCodecProxyUtils.b.qY(paramInt);
    MediaCodecProxyUtils.b.a(paramInt, parama);
    AppMethodBeat.o(155796);
  }
  
  private void aPC()
  {
    AppMethodBeat.i(155774);
    int i = this.lXl.get() + this.lXo.get() + this.lXp.get() + this.lXm.get() + this.lXn.get();
    if (i > 10)
    {
      Log.d("MicroMsg.MediaCodecProxy", "reportCount count:[%d]", new Object[] { Integer.valueOf(i) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("countFlush:").append(this.lXl).append(";countDequeueInputBuffer:").append(this.lXo).append(";countDequeueOutputBuffer:").append(this.lXp).append(";countQueueInputBuffer:").append(this.lXm).append(";countQueueSecureInputBuffer:").append(this.lXn).append(";");
      if (this.lXk != null)
      {
        String str = "";
        if (this.lXk.lXC != null) {
          str = this.lXk.lXC.replace(",", ";");
        }
        localStringBuilder.append(this.lXk.lXA).append(";").append(this.lXk.mimeType).append(";").append(this.lXk.lXB).append(";").append(MMApplicationContext.getProcessName()).append(";").append(str).append(";stack:").append(this.lXk.stack);
      }
      MediaCodecProxyUtils.b.qY(16);
      MediaCodecProxyUtils.b.x(16, localStringBuilder.toString());
      this.lXl.set(0);
      this.lXo.set(0);
      this.lXp.set(0);
      this.lXm.set(0);
      this.lXn.set(0);
    }
    AppMethodBeat.o(155774);
  }
  
  private static String g(Exception paramException)
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
  
  public static aa u(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(155770);
    Log.i("MicroMsg.MediaCodecProxy", "into createEncoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.qY(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qY(63);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createEncoderByType(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qY(64);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.a(localMediaCodec.hashCode(), true, paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.a(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.aPF();
      localObject1 = localObject2;
      localObject2 = new aa(localMediaCodec, (MediaCodecProxyUtils.a)localObject2);
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
      if (!this.fez)
      {
        Log.e("MicroMsg.MediaCodecProxy", "queueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy queueInputBuffer not alive");
      }
      this.lXj.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
      AppMethodBeat.o(155779);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.qY(40);
      this.lXm.getAndIncrement();
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.lXr > this.lXs))
      {
        this.lXr = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new aa.1(this));
      }
      AppMethodBeat.o(155779);
      throw localException;
    }
  }
  
  /* Error */
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 330
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 71
    //   8: ldc_w 332
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: invokestatic 274	android/os/Process:myTid	()I
    //   20: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: invokestatic 280	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: invokevirtual 283	java/lang/Thread:getName	()Ljava/lang/String;
    //   32: aastore
    //   33: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: new 181	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 334
    //   43: invokespecial 337	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: astore 5
    //   48: aload_1
    //   49: ifnull +117 -> 166
    //   52: aload_1
    //   53: invokevirtual 340	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload 5
    //   60: aload 4
    //   62: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 342
    //   68: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: astore 5
    //   73: aload_2
    //   74: ifnull +100 -> 174
    //   77: aload_2
    //   78: invokevirtual 345	android/view/Surface:toString	()Ljava/lang/String;
    //   81: astore 4
    //   83: ldc 71
    //   85: aload 5
    //   87: aload 4
    //   89: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 347
    //   95: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload_3
    //   99: invokevirtual 350	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 352	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 35	com/tencent/mm/compatible/deviceinfo/aa:fez	Z
    //   112: ifne +11 -> 123
    //   115: ldc 71
    //   117: ldc_w 354
    //   120: invokestatic 291	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: ifnull +14 -> 138
    //   127: aload_0
    //   128: getfield 60	com/tencent/mm/compatible/deviceinfo/aa:lXk	Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;
    //   131: aload_1
    //   132: invokevirtual 340	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   135: putfield 206	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a:lXC	Ljava/lang/String;
    //   138: bipush 75
    //   140: invokestatic 86	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$b:qY	(I)V
    //   143: aload_0
    //   144: getfield 58	com/tencent/mm/compatible/deviceinfo/aa:lXj	Landroid/media/MediaCodec;
    //   147: aload_1
    //   148: aload_2
    //   149: aconst_null
    //   150: iload_3
    //   151: invokevirtual 358	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   154: bipush 76
    //   156: invokestatic 86	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$b:qY	(I)V
    //   159: ldc_w 330
    //   162: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: ldc_w 360
    //   169: astore 4
    //   171: goto -113 -> 58
    //   174: ldc_w 360
    //   177: astore 4
    //   179: goto -96 -> 83
    //   182: astore_1
    //   183: ldc 71
    //   185: aload_1
    //   186: ldc_w 362
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: bipush 32
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 60	com/tencent/mm/compatible/deviceinfo/aa:lXk	Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;
    //   203: invokestatic 129	com/tencent/mm/compatible/deviceinfo/aa:a	(ILjava/lang/Exception;Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;)V
    //   206: ldc_w 330
    //   209: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	aa
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
  
  public final ByteBuffer[] aPD()
  {
    AppMethodBeat.i(155786);
    try
    {
      MediaCodecProxyUtils.b.qY(126);
      ByteBuffer[] arrayOfByteBuffer = this.lXj.getInputBuffers();
      MediaCodecProxyUtils.b.qY(127);
      AppMethodBeat.o(155786);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffers", new Object[0]);
      a(49, localException, this.lXk);
      AppMethodBeat.o(155786);
      throw localException;
    }
  }
  
  public final ByteBuffer[] aPE()
  {
    AppMethodBeat.i(155787);
    try
    {
      MediaCodecProxyUtils.b.qY(129);
      ByteBuffer[] arrayOfByteBuffer = this.lXj.getOutputBuffers();
      MediaCodecProxyUtils.b.qY(130);
      AppMethodBeat.o(155787);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffers", new Object[0]);
      a(50, localException, this.lXk);
      AppMethodBeat.o(155787);
      throw localException;
    }
  }
  
  public final Surface createInputSurface()
  {
    AppMethodBeat.i(155776);
    try
    {
      MediaCodecProxyUtils.b.qY(87);
      Surface localSurface = this.lXj.createInputSurface();
      MediaCodecProxyUtils.b.qY(88);
      AppMethodBeat.o(155776);
      return localSurface;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy createInputSurface", new Object[0]);
      a(36, localException, this.lXk);
      AppMethodBeat.o(155776);
      throw localException;
    }
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(155780);
    try
    {
      if (!this.fez)
      {
        Log.e("MicroMsg.MediaCodecProxy", "dequeueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueInputBuffer not alive");
      }
      int i = this.lXj.dequeueInputBuffer(paramLong);
      AppMethodBeat.o(155780);
      return i;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy dequeueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.qY(42);
      this.lXo.getAndIncrement();
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.lXr > this.lXs))
      {
        this.lXr = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new aa.2(this));
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
      if (!this.fez)
      {
        Log.e("MicroMsg.MediaCodecProxy", "dequeueOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueOutputBuffer not alive");
      }
      int i = this.lXj.dequeueOutputBuffer(paramBufferInfo, paramLong);
      AppMethodBeat.o(155781);
      return i;
    }
    catch (Exception paramBufferInfo)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBufferInfo, "MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.qY(43);
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.lXr > this.lXs))
      {
        this.lXr = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new aa.3(this));
      }
      this.lXp.getAndIncrement();
      AppMethodBeat.o(155781);
      throw paramBufferInfo;
    }
  }
  
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(155788);
    try
    {
      ByteBuffer localByteBuffer = this.lXj.getInputBuffer(paramInt);
      AppMethodBeat.o(155788);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffer", new Object[0]);
      a(51, localException, this.lXk);
      AppMethodBeat.o(155788);
      throw localException;
    }
  }
  
  public final String getName()
  {
    AppMethodBeat.i(155791);
    try
    {
      MediaCodecProxyUtils.b.qY(147);
      String str = this.lXj.getName();
      MediaCodecProxyUtils.b.qY(148);
      AppMethodBeat.o(155791);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getName", new Object[0]);
      a(56, localException, this.lXk);
      AppMethodBeat.o(155791);
      throw localException;
    }
  }
  
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    AppMethodBeat.i(155789);
    try
    {
      ByteBuffer localByteBuffer = this.lXj.getOutputBuffer(paramInt);
      AppMethodBeat.o(155789);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffer", new Object[0]);
      a(53, localException, this.lXk);
      AppMethodBeat.o(155789);
      throw localException;
    }
  }
  
  public final MediaFormat getOutputFormat()
  {
    AppMethodBeat.i(155785);
    try
    {
      MediaCodecProxyUtils.b.qY(120);
      MediaFormat localMediaFormat = this.lXj.getOutputFormat();
      MediaCodecProxyUtils.b.qY(121);
      AppMethodBeat.o(155785);
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputFormat, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(47, localException, this.lXk);
      AppMethodBeat.o(155785);
      throw localException;
    }
  }
  
  public final Image getOutputImage(int paramInt)
  {
    AppMethodBeat.i(155790);
    try
    {
      MediaCodecProxyUtils.b.qY(141);
      Image localImage = this.lXj.getOutputImage(paramInt);
      MediaCodecProxyUtils.b.qY(142);
      AppMethodBeat.o(155790);
      return localImage;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputImage", new Object[0]);
      a(54, localException, this.lXk);
      AppMethodBeat.o(155790);
      throw localException;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(155773);
    try
    {
      MediaCodecProxyUtils.b.qY(11);
      Log.i("MicroMsg.MediaCodecProxy", "into release function, thread:[%s], stack:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Util.getStack().toString() });
      if (!this.fez)
      {
        Log.e("MicroMsg.MediaCodecProxy", "release error, multi release, stack:[%s]", new Object[] { Util.getStack().toString() });
        a(10, null, this.lXk);
      }
      MediaCodecProxyUtils.qX(this.lXj.hashCode());
      MediaCodecProxyUtils.aPF();
      MediaCodecProxyUtils.b.qY(69);
      this.lXj.release();
      MediaCodecProxyUtils.b.qY(70);
      aPC();
      this.fez = false;
      AppMethodBeat.o(155773);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy release", new Object[0]);
      a(30, localException, this.lXk);
      AppMethodBeat.o(155773);
      throw localException;
    }
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(155782);
    try
    {
      if (!this.fez)
      {
        Log.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
      }
      this.lXj.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(155782);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy releaseOutputBuffer 1, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(44, localException, this.lXk);
      AppMethodBeat.o(155782);
      throw localException;
    }
  }
  
  public final void setCallback(MediaCodec.Callback paramCallback)
  {
    AppMethodBeat.i(155794);
    this.lXj.setCallback(paramCallback);
    AppMethodBeat.o(155794);
  }
  
  public final void setCallback(MediaCodec.Callback paramCallback, Handler paramHandler)
  {
    AppMethodBeat.i(155793);
    this.lXj.setCallback(paramCallback, paramHandler);
    AppMethodBeat.o(155793);
  }
  
  public final void setOutputSurface(Surface paramSurface)
  {
    AppMethodBeat.i(240864);
    try
    {
      MediaCodecProxyUtils.b.qY(81);
      this.lXj.setOutputSurface(paramSurface);
      MediaCodecProxyUtils.b.qY(82);
      AppMethodBeat.o(240864);
      return;
    }
    catch (Exception paramSurface)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", paramSurface, "MediaCodecProxy setOutputSurface", new Object[0]);
      a(34, paramSurface, this.lXk);
      AppMethodBeat.o(240864);
      throw paramSurface;
    }
  }
  
  public final void setParameters(Bundle paramBundle)
  {
    AppMethodBeat.i(155792);
    try
    {
      MediaCodecProxyUtils.b.qY(150);
      this.lXj.setParameters(paramBundle);
      MediaCodecProxyUtils.b.qY(151);
      AppMethodBeat.o(155792);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBundle, "MediaCodecProxy setParameters, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(57, paramBundle, this.lXk);
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
      MediaCodecProxyUtils.b.qY(117);
      this.lXj.signalEndOfInputStream();
      MediaCodecProxyUtils.b.qY(118);
      AppMethodBeat.o(155784);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy signalEndOfInputStream, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(46, localException, this.lXk);
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
      if (!this.fez) {
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy start not alive");
      }
      MediaCodecProxyUtils.b.qY(90);
      this.lXj.start();
      MediaCodecProxyUtils.b.qY(91);
      AppMethodBeat.o(155777);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy start", new Object[0]);
      a(37, localException, this.lXk);
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
      if (!this.fez) {
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy stop not alive");
      }
      MediaCodecProxyUtils.b.qY(93);
      this.lXj.stop();
      MediaCodecProxyUtils.b.qY(94);
      AppMethodBeat.o(155778);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy stop", new Object[0]);
      a(38, localException, this.lXk);
      AppMethodBeat.o(155778);
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.aa
 * JD-Core Version:    0.7.0.1
 */