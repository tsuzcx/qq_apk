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
import android.widget.Toast;
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
  public volatile boolean dfl;
  public MediaCodec jtS;
  public MediaCodecProxyUtils.a jtT;
  public AtomicInteger jtU;
  private AtomicInteger jtV;
  private AtomicInteger jtW;
  private AtomicInteger jtX;
  private AtomicInteger jtY;
  private final int jtZ;
  private long jua;
  private long jub;
  
  private aa(MediaCodec paramMediaCodec, MediaCodecProxyUtils.a parama)
  {
    AppMethodBeat.i(155772);
    this.dfl = false;
    this.jtU = new AtomicInteger();
    this.jtV = new AtomicInteger();
    this.jtW = new AtomicInteger();
    this.jtX = new AtomicInteger();
    this.jtY = new AtomicInteger();
    this.jtZ = 10;
    this.jua = 0L;
    this.jub = 5000L;
    this.jtS = paramMediaCodec;
    this.jtT = parama;
    this.dfl = true;
    AppMethodBeat.o(155772);
  }
  
  public static aa KR(String paramString)
  {
    AppMethodBeat.i(155768);
    Log.i("MicroMsg.MediaCodecProxy", "into createDecoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.qS(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qS(60);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createDecoderByType(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qS(61);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.a(localMediaCodec.hashCode(), false, paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.a(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.avl();
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
  
  public static aa KS(String paramString)
  {
    AppMethodBeat.i(155769);
    paramString = t(paramString, false);
    AppMethodBeat.o(155769);
    return paramString;
  }
  
  public static aa KT(String paramString)
  {
    AppMethodBeat.i(155771);
    Log.i("MicroMsg.MediaCodecProxy", "into createByCodecName, name = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.qS(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qS(66);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createByCodecName(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qS(67);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.w(localMediaCodec.hashCode(), paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.avl();
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
      parama.stack = f(paramException);
    }
    MediaCodecProxyUtils.b.qS(paramInt);
    MediaCodecProxyUtils.b.a(paramInt, parama);
    AppMethodBeat.o(155796);
  }
  
  private void avh()
  {
    AppMethodBeat.i(155774);
    int i = this.jtU.get() + this.jtX.get() + this.jtY.get() + this.jtV.get() + this.jtW.get();
    if (i > 10)
    {
      Log.d("MicroMsg.MediaCodecProxy", "reportCount count:[%d]", new Object[] { Integer.valueOf(i) });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("countFlush:").append(this.jtU).append(";countDequeueInputBuffer:").append(this.jtX).append(";countDequeueOutputBuffer:").append(this.jtY).append(";countQueueInputBuffer:").append(this.jtV).append(";countQueueSecureInputBuffer:").append(this.jtW).append(";");
      if (this.jtT != null)
      {
        String str = "";
        if (this.jtT.jul != null) {
          str = this.jtT.jul.replace(",", ";");
        }
        localStringBuilder.append(this.jtT.juj).append(";").append(this.jtT.mimeType).append(";").append(this.jtT.juk).append(";").append(MMApplicationContext.getProcessName()).append(";").append(str).append(";stack:").append(this.jtT.stack);
      }
      MediaCodecProxyUtils.b.qS(16);
      MediaCodecProxyUtils.b.x(16, localStringBuilder.toString());
      this.jtU.set(0);
      this.jtX.set(0);
      this.jtY.set(0);
      this.jtV.set(0);
      this.jtW.set(0);
    }
    AppMethodBeat.o(155774);
  }
  
  private static String f(Exception paramException)
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
  
  public static aa t(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(155770);
    Log.i("MicroMsg.MediaCodecProxy", "into createEncoderByType, type = [%s]", new Object[] { paramString });
    Object localObject2 = new MediaCodecProxyUtils.a();
    Object localObject1 = localObject2;
    try
    {
      MediaCodecProxyUtils.b.qS(7);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qS(63);
      localObject1 = localObject2;
      MediaCodec localMediaCodec = MediaCodec.createEncoderByType(paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.b.qS(64);
      localObject1 = localObject2;
      localObject2 = MediaCodecProxyUtils.a(localMediaCodec.hashCode(), true, paramString);
      localObject1 = localObject2;
      MediaCodecProxyUtils.a(paramString, (MediaCodecProxyUtils.a)localObject2);
      localObject1 = localObject2;
      MediaCodecProxyUtils.avl();
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
  
  public final int EX(long paramLong)
  {
    AppMethodBeat.i(155780);
    try
    {
      if (!this.dfl)
      {
        Log.e("MicroMsg.MediaCodecProxy", "dequeueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueInputBuffer not alive");
      }
      int i = this.jtS.dequeueInputBuffer(paramLong);
      AppMethodBeat.o(155780);
      return i;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy dequeueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.qS(42);
      this.jtX.getAndIncrement();
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.jua > this.jub))
      {
        this.jua = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249310);
            Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy dequeueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
            AppMethodBeat.o(249310);
          }
        });
      }
      AppMethodBeat.o(155780);
      throw localException;
    }
  }
  
  public final int a(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(155781);
    try
    {
      if (!this.dfl)
      {
        Log.e("MicroMsg.MediaCodecProxy", "dequeueOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy dequeueOutputBuffer not alive");
      }
      int i = this.jtS.dequeueOutputBuffer(paramBufferInfo, paramLong);
      AppMethodBeat.o(155781);
      return i;
    }
    catch (Exception paramBufferInfo)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBufferInfo, "MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.qS(43);
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.jua > this.jub))
      {
        this.jua = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249250);
            Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
            AppMethodBeat.o(249250);
          }
        });
      }
      this.jtY.getAndIncrement();
      AppMethodBeat.o(155781);
      throw paramBufferInfo;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(155779);
    try
    {
      if (!this.dfl)
      {
        Log.e("MicroMsg.MediaCodecProxy", "queueInputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy queueInputBuffer not alive");
      }
      this.jtS.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
      AppMethodBeat.o(155779);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      MediaCodecProxyUtils.b.qS(40);
      this.jtV.getAndIncrement();
      if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) && (System.currentTimeMillis() - this.jua > this.jub))
      {
        this.jua = System.currentTimeMillis();
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(249306);
            Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
            AppMethodBeat.o(249306);
          }
        });
      }
      AppMethodBeat.o(155779);
      throw localException;
    }
  }
  
  public final void a(MediaCodec.Callback paramCallback)
  {
    AppMethodBeat.i(155794);
    this.jtS.setCallback(paramCallback);
    AppMethodBeat.o(155794);
  }
  
  @TargetApi(23)
  public final void a(MediaCodec.Callback paramCallback, Handler paramHandler)
  {
    AppMethodBeat.i(155793);
    this.jtS.setCallback(paramCallback, paramHandler);
    AppMethodBeat.o(155793);
  }
  
  /* Error */
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 376
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 77
    //   8: ldc_w 378
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: invokestatic 285	android/os/Process:myTid	()I
    //   20: invokestatic 188	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: invokestatic 291	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   29: invokevirtual 294	java/lang/Thread:getName	()Ljava/lang/String;
    //   32: aastore
    //   33: invokestatic 84	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: new 193	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 380
    //   43: invokespecial 383	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: astore 5
    //   48: aload_1
    //   49: ifnull +117 -> 166
    //   52: aload_1
    //   53: invokevirtual 386	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   56: astore 4
    //   58: aload 5
    //   60: aload 4
    //   62: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 388
    //   68: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: astore 5
    //   73: aload_2
    //   74: ifnull +100 -> 174
    //   77: aload_2
    //   78: invokevirtual 391	android/view/Surface:toString	()Ljava/lang/String;
    //   81: astore 4
    //   83: ldc 77
    //   85: aload 5
    //   87: aload 4
    //   89: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 393
    //   95: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload_3
    //   99: invokevirtual 396	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 398	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 41	com/tencent/mm/compatible/deviceinfo/aa:dfl	Z
    //   112: ifne +11 -> 123
    //   115: ldc 77
    //   117: ldc_w 400
    //   120: invokestatic 302	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: ifnull +14 -> 138
    //   127: aload_0
    //   128: getfield 66	com/tencent/mm/compatible/deviceinfo/aa:jtT	Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;
    //   131: aload_1
    //   132: invokevirtual 386	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   135: putfield 218	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a:jul	Ljava/lang/String;
    //   138: bipush 75
    //   140: invokestatic 92	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$b:qS	(I)V
    //   143: aload_0
    //   144: getfield 64	com/tencent/mm/compatible/deviceinfo/aa:jtS	Landroid/media/MediaCodec;
    //   147: aload_1
    //   148: aload_2
    //   149: aconst_null
    //   150: iload_3
    //   151: invokevirtual 404	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   154: bipush 76
    //   156: invokestatic 92	com/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$b:qS	(I)V
    //   159: ldc_w 376
    //   162: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: ldc_w 406
    //   169: astore 4
    //   171: goto -113 -> 58
    //   174: ldc_w 406
    //   177: astore 4
    //   179: goto -96 -> 83
    //   182: astore_1
    //   183: ldc 77
    //   185: aload_1
    //   186: ldc_w 408
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: bipush 32
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 66	com/tencent/mm/compatible/deviceinfo/aa:jtT	Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;
    //   203: invokestatic 135	com/tencent/mm/compatible/deviceinfo/aa:a	(ILjava/lang/Exception;Lcom/tencent/mm/compatible/deviceinfo/MediaCodecProxyUtils$a;)V
    //   206: ldc_w 376
    //   209: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final MediaFormat avi()
  {
    AppMethodBeat.i(155785);
    try
    {
      MediaCodecProxyUtils.b.qS(120);
      MediaFormat localMediaFormat = this.jtS.getOutputFormat();
      MediaCodecProxyUtils.b.qS(121);
      AppMethodBeat.o(155785);
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputFormat, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(47, localException, this.jtT);
      AppMethodBeat.o(155785);
      throw localException;
    }
  }
  
  public final ByteBuffer[] avj()
  {
    AppMethodBeat.i(155786);
    try
    {
      MediaCodecProxyUtils.b.qS(126);
      ByteBuffer[] arrayOfByteBuffer = this.jtS.getInputBuffers();
      MediaCodecProxyUtils.b.qS(127);
      AppMethodBeat.o(155786);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffers", new Object[0]);
      a(49, localException, this.jtT);
      AppMethodBeat.o(155786);
      throw localException;
    }
  }
  
  public final ByteBuffer[] avk()
  {
    AppMethodBeat.i(155787);
    try
    {
      MediaCodecProxyUtils.b.qS(129);
      ByteBuffer[] arrayOfByteBuffer = this.jtS.getOutputBuffers();
      MediaCodecProxyUtils.b.qS(130);
      AppMethodBeat.o(155787);
      return arrayOfByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffers", new Object[0]);
      a(50, localException, this.jtT);
      AppMethodBeat.o(155787);
      throw localException;
    }
  }
  
  public final Surface createInputSurface()
  {
    AppMethodBeat.i(155776);
    try
    {
      MediaCodecProxyUtils.b.qS(87);
      Surface localSurface = this.jtS.createInputSurface();
      MediaCodecProxyUtils.b.qS(88);
      AppMethodBeat.o(155776);
      return localSurface;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy createInputSurface", new Object[0]);
      a(36, localException, this.jtT);
      AppMethodBeat.o(155776);
      throw localException;
    }
  }
  
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(155788);
    try
    {
      ByteBuffer localByteBuffer = this.jtS.getInputBuffer(paramInt);
      AppMethodBeat.o(155788);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getInputBuffer", new Object[0]);
      a(51, localException, this.jtT);
      AppMethodBeat.o(155788);
      throw localException;
    }
  }
  
  public final String getName()
  {
    AppMethodBeat.i(155791);
    try
    {
      MediaCodecProxyUtils.b.qS(147);
      String str = this.jtS.getName();
      MediaCodecProxyUtils.b.qS(148);
      AppMethodBeat.o(155791);
      return str;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getName", new Object[0]);
      a(56, localException, this.jtT);
      AppMethodBeat.o(155791);
      throw localException;
    }
  }
  
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    AppMethodBeat.i(155789);
    try
    {
      ByteBuffer localByteBuffer = this.jtS.getOutputBuffer(paramInt);
      AppMethodBeat.o(155789);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputBuffer", new Object[0]);
      a(53, localException, this.jtT);
      AppMethodBeat.o(155789);
      throw localException;
    }
  }
  
  public final Image qQ(int paramInt)
  {
    AppMethodBeat.i(155790);
    try
    {
      MediaCodecProxyUtils.b.qS(141);
      Image localImage = this.jtS.getOutputImage(paramInt);
      MediaCodecProxyUtils.b.qS(142);
      AppMethodBeat.o(155790);
      return localImage;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy getOutputImage", new Object[0]);
      a(54, localException, this.jtT);
      AppMethodBeat.o(155790);
      throw localException;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(155773);
    try
    {
      MediaCodecProxyUtils.b.qS(11);
      Log.i("MicroMsg.MediaCodecProxy", "into release function, thread:[%s], stack:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Util.getStack().toString() });
      if (!this.dfl)
      {
        Log.e("MicroMsg.MediaCodecProxy", "release error, multi release, stack:[%s]", new Object[] { Util.getStack().toString() });
        a(10, null, this.jtT);
      }
      MediaCodecProxyUtils.qR(this.jtS.hashCode());
      MediaCodecProxyUtils.avl();
      MediaCodecProxyUtils.b.qS(69);
      this.jtS.release();
      MediaCodecProxyUtils.b.qS(70);
      avh();
      this.dfl = false;
      AppMethodBeat.o(155773);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy release", new Object[0]);
      a(30, localException, this.jtT);
      AppMethodBeat.o(155773);
      throw localException;
    }
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(155782);
    try
    {
      if (!this.dfl)
      {
        Log.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
      }
      this.jtS.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(155782);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy releaseOutputBuffer 1, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(44, localException, this.jtT);
      AppMethodBeat.o(155782);
      throw localException;
    }
  }
  
  public final void setParameters(Bundle paramBundle)
  {
    AppMethodBeat.i(155792);
    try
    {
      MediaCodecProxyUtils.b.qS(150);
      this.jtS.setParameters(paramBundle);
      MediaCodecProxyUtils.b.qS(151);
      AppMethodBeat.o(155792);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", paramBundle, "MediaCodecProxy setParameters, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(57, paramBundle, this.jtT);
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
      MediaCodecProxyUtils.b.qS(117);
      this.jtS.signalEndOfInputStream();
      MediaCodecProxyUtils.b.qS(118);
      AppMethodBeat.o(155784);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy signalEndOfInputStream, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(46, localException, this.jtT);
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
      if (!this.dfl) {
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy start not alive");
      }
      MediaCodecProxyUtils.b.qS(90);
      this.jtS.start();
      MediaCodecProxyUtils.b.qS(91);
      AppMethodBeat.o(155777);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy start", new Object[0]);
      a(37, localException, this.jtT);
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
      if (!this.dfl) {
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy stop not alive");
      }
      MediaCodecProxyUtils.b.qS(93);
      this.jtS.stop();
      MediaCodecProxyUtils.b.qS(94);
      AppMethodBeat.o(155778);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy stop", new Object[0]);
      a(38, localException, this.jtT);
      AppMethodBeat.o(155778);
      throw localException;
    }
  }
  
  public final void u(int paramInt, long paramLong)
  {
    AppMethodBeat.i(155783);
    try
    {
      if (!this.dfl)
      {
        Log.e("MicroMsg.MediaCodecProxy", "releaseOutputBuffer function, threadName:[%s]", new Object[] { Integer.valueOf(Process.myTid()), Thread.currentThread().getName() });
        Log.e("MicroMsg.MediaCodecProxy", "MediaCodecProxy releaseOutputBuffer not alive");
      }
      MediaCodecProxyUtils.b.qS(114);
      this.jtS.releaseOutputBuffer(paramInt, paramLong);
      MediaCodecProxyUtils.b.qS(115);
      AppMethodBeat.o(155783);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecProxy", localException, "MediaCodecProxy releaseOutputBuffer 2, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) });
      a(45, localException, this.jtT);
      AppMethodBeat.o(155783);
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.aa
 * JD-Core Version:    0.7.0.1
 */