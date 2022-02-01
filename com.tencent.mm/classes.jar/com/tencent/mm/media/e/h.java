package com.tencent.mm.media.e;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.c.d;
import com.tencent.threadpool.e.f;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "videoWidth", "videoHeight", "(III)V", "copyTmpBuffer", "Ljava/nio/ByteBuffer;", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeRGB2YuvHandler", "Landroid/os/Handler;", "encodeRGB2YuvHandlerThread", "Landroid/os/HandlerThread;", "encodeRGB2YuvImageReader", "Landroid/media/ImageReader;", "inputTexId", "isStopped", "", "renderYuvCount", "rgb2yuvEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "startEncodeTick", "", "stopLock", "Ljava/lang/Object;", "writeDataWaitEncodeLock", "writeYuvCount", "writeYuvDataEncodeLock", "writeYuvRenderWaitLock", "yuvHeight", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVI420RenderProc;", "yuvWidth", "checkStartEncodeLoop", "", "encodeLoop", "finishEncode", "getFrameCount", "notifyToEncode", "processImageYUVBufferToWriteYUVData", "width", "height", "plane", "Landroid/media/Image$Plane;", "requestEncode", "timestampMs", "setupImageReader", "videoDataRenderEnvironment", "texId", "texWidth", "texHeight", "start", "stop", "waitWriteYuv", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h.a nzZ;
  private final int bufId;
  private final Object cBq;
  private ByteBuffer nAa;
  private ImageReader nAb;
  private Handler nAc;
  private HandlerThread nAd;
  private com.tencent.mm.media.j.b.h nAe;
  private c.b nAf;
  private int nAg;
  private int nAh;
  public volatile boolean nAi;
  private long nAj;
  private final Object nAk;
  public final Object nAl;
  public final Object nAm;
  private volatile int nAn;
  public volatile int nAo;
  private int nAp;
  private f<?> nzU;
  public volatile int nzX;
  private final int videoHeight;
  private final int videoWidth;
  
  static
  {
    AppMethodBeat.i(237053);
    nzZ = new h.a((byte)0);
    AppMethodBeat.o(237053);
  }
  
  public h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(236980);
    this.bufId = paramInt1;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    HandlerThread localHandlerThread = d.jv("X264TransImageReaderEncoder_rgb2yuv_thread", -4);
    s.s(localHandlerThread, "createEGLThread(\"X264Tra….THREAD_PRIORITY_DISPLAY)");
    this.nAd = localHandlerThread;
    this.cBq = new Object();
    this.nAk = new Object();
    this.nAl = new Object();
    this.nAm = new Object();
    Log.i("MicroMsg.X264TransImageReaderEncoder", "create X264TransImageReaderEncoder, width:" + this.videoWidth + ", height:" + this.videoHeight);
    SightVideoJNI.setI420Format(this.bufId, true);
    AppMethodBeat.o(236980);
  }
  
  /* Error */
  private static final ah a(h paramh, com.tencent.threadpool.e.e.a arg1)
  {
    // Byte code:
    //   0: ldc 216
    //   2: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 218
    //   8: invokestatic 221	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: invokestatic 227	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   14: lstore_3
    //   15: aload_0
    //   16: getfield 229	com/tencent/mm/media/e/h:nAi	Z
    //   19: ifne +271 -> 290
    //   22: ldc 182
    //   24: new 184	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 231
    //   30: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 233	com/tencent/mm/media/e/h:nzX	I
    //   37: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc 235
    //   42: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 237	com/tencent/mm/media/e/h:nAo	I
    //   49: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: invokestatic 227	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   61: lstore 5
    //   63: aload_0
    //   64: getfield 150	com/tencent/mm/media/e/h:bufId	I
    //   67: iconst_0
    //   68: aload_0
    //   69: getfield 233	com/tencent/mm/media/e/h:nzX	I
    //   72: invokestatic 243	java/lang/Math:max	(II)I
    //   75: iconst_0
    //   76: invokestatic 247	com/tencent/mm/plugin/sight/base/SightVideoJNI:triggerEncode	(IIZ)I
    //   79: istore_2
    //   80: ldc 182
    //   82: new 184	java/lang/StringBuilder
    //   85: dup
    //   86: ldc 249
    //   88: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: lload 5
    //   93: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   96: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: ldc_w 258
    //   102: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: getfield 233	com/tencent/mm/media/e/h:nzX	I
    //   109: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: ldc_w 260
    //   115: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload_2
    //   119: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: ldc_w 262
    //   125: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokestatic 268	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   131: invokevirtual 271	java/lang/Thread:getId	()J
    //   134: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: iload_2
    //   145: putfield 233	com/tencent/mm/media/e/h:nzX	I
    //   148: aload_0
    //   149: getfield 233	com/tencent/mm/media/e/h:nzX	I
    //   152: aload_0
    //   153: getfield 237	com/tencent/mm/media/e/h:nAo	I
    //   156: if_icmplt +39 -> 195
    //   159: aload_0
    //   160: getfield 229	com/tencent/mm/media/e/h:nAi	Z
    //   163: ifne +32 -> 195
    //   166: aload_0
    //   167: getfield 180	com/tencent/mm/media/e/h:nAm	Ljava/lang/Object;
    //   170: astore_1
    //   171: aload_1
    //   172: monitorenter
    //   173: ldc 182
    //   175: ldc_w 273
    //   178: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: aload_0
    //   182: getfield 180	com/tencent/mm/media/e/h:nAm	Ljava/lang/Object;
    //   185: invokevirtual 276	java/lang/Object:notifyAll	()V
    //   188: getstatic 282	kotlin/ah:aiuX	Lkotlin/ah;
    //   191: astore 8
    //   193: aload_1
    //   194: monitorexit
    //   195: aload_0
    //   196: getfield 229	com/tencent/mm/media/e/h:nAi	Z
    //   199: ifne -184 -> 15
    //   202: aload_0
    //   203: getfield 176	com/tencent/mm/media/e/h:nAk	Ljava/lang/Object;
    //   206: astore_1
    //   207: aload_1
    //   208: monitorenter
    //   209: aload_0
    //   210: getfield 176	com/tencent/mm/media/e/h:nAk	Ljava/lang/Object;
    //   213: invokevirtual 285	java/lang/Object:wait	()V
    //   216: getstatic 282	kotlin/ah:aiuX	Lkotlin/ah;
    //   219: astore 8
    //   221: aload_1
    //   222: monitorexit
    //   223: goto -208 -> 15
    //   226: astore 8
    //   228: ldc 182
    //   230: aload 8
    //   232: checkcast 287	java/lang/Throwable
    //   235: ldc_w 288
    //   238: iconst_0
    //   239: anewarray 4	java/lang/Object
    //   242: invokestatic 292	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: goto -57 -> 188
    //   248: astore_0
    //   249: aload_1
    //   250: monitorexit
    //   251: ldc 216
    //   253: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_0
    //   257: athrow
    //   258: astore 8
    //   260: ldc 182
    //   262: aload 8
    //   264: checkcast 287	java/lang/Throwable
    //   267: ldc_w 288
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 292	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: goto -61 -> 216
    //   280: astore_0
    //   281: aload_1
    //   282: monitorexit
    //   283: ldc 216
    //   285: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: aload_0
    //   289: athrow
    //   290: ldc 182
    //   292: ldc_w 294
    //   295: aload_0
    //   296: getfield 229	com/tencent/mm/media/e/h:nAi	Z
    //   299: invokestatic 300	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   302: invokestatic 304	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   305: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: invokestatic 227	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   311: lstore 5
    //   313: aload_0
    //   314: getfield 229	com/tencent/mm/media/e/h:nAi	Z
    //   317: ifne +187 -> 504
    //   320: iconst_1
    //   321: istore 7
    //   323: iload 7
    //   325: ifne +19 -> 344
    //   328: aload_0
    //   329: aload_0
    //   330: getfield 150	com/tencent/mm/media/e/h:bufId	I
    //   333: aload_0
    //   334: getfield 233	com/tencent/mm/media/e/h:nzX	I
    //   337: iconst_1
    //   338: invokestatic 247	com/tencent/mm/plugin/sight/base/SightVideoJNI:triggerEncode	(IIZ)I
    //   341: putfield 233	com/tencent/mm/media/e/h:nzX	I
    //   344: ldc 182
    //   346: new 184	java/lang/StringBuilder
    //   349: dup
    //   350: ldc_w 306
    //   353: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   356: lload 5
    //   358: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   361: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   364: ldc_w 258
    //   367: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_0
    //   371: getfield 233	com/tencent/mm/media/e/h:nzX	I
    //   374: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: ldc_w 308
    //   380: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 7
    //   385: invokevirtual 311	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   388: ldc_w 262
    //   391: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokestatic 268	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   397: invokevirtual 271	java/lang/Thread:getId	()J
    //   400: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   403: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: ldc 182
    //   411: new 184	java/lang/StringBuilder
    //   414: dup
    //   415: ldc_w 313
    //   418: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: aload_0
    //   422: getfield 315	com/tencent/mm/media/e/h:nAj	J
    //   425: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   428: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   431: ldc_w 317
    //   434: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: lload_3
    //   438: invokestatic 253	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   441: invokevirtual 256	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   444: ldc_w 319
    //   447: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: ldc 182
    //   458: new 184	java/lang/StringBuilder
    //   461: dup
    //   462: ldc_w 321
    //   465: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   468: aload_0
    //   469: getfield 323	com/tencent/mm/media/e/h:nAn	I
    //   472: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   475: ldc 235
    //   477: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload_0
    //   481: getfield 237	com/tencent/mm/media/e/h:nAo	I
    //   484: invokevirtual 193	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   487: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: getstatic 282	kotlin/ah:aiuX	Lkotlin/ah;
    //   496: astore_0
    //   497: ldc 216
    //   499: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   502: aload_0
    //   503: areturn
    //   504: iconst_0
    //   505: istore 7
    //   507: goto -184 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	510	0	paramh	h
    //   79	66	2	i	int
    //   14	424	3	l1	long
    //   61	296	5	l2	long
    //   321	185	7	bool	boolean
    //   191	29	8	localah	ah
    //   226	5	8	localException1	Exception
    //   258	5	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   173	188	226	java/lang/Exception
    //   173	188	248	finally
    //   188	193	248	finally
    //   228	245	248	finally
    //   209	216	258	java/lang/Exception
    //   209	216	280	finally
    //   216	221	280	finally
    //   260	277	280	finally
  }
  
  private static final void a(h paramh, long paramLong)
  {
    Object localObject3 = null;
    AppMethodBeat.i(237022);
    s.u(paramh, "this$0");
    if (paramh.nAi)
    {
      Log.i("MicroMsg.X264TransImageReaderEncoder", "render gpu rgb2yuv, already stop");
      AppMethodBeat.o(237022);
      return;
    }
    Log.i("MicroMsg.X264TransImageReaderEncoder", s.X("render gpu rgb2yuv, timestamp:", Long.valueOf(paramLong)));
    Object localObject1 = paramh.nAe;
    if (localObject1 != null) {
      ((com.tencent.mm.media.j.b.h)localObject1).bgE();
    }
    localObject1 = paramh.nAf;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = paramh.nAf;
      if (localObject2 != null) {
        break label160;
      }
      localObject2 = null;
      label90:
      EGLExt.eglPresentationTimeANDROID((EGLDisplay)localObject1, (EGLSurface)localObject2, paramLong);
      localObject1 = c.nFs;
      localObject1 = paramh.nAf;
      if (localObject1 != null) {
        break label170;
      }
      localObject1 = null;
      label113:
      localObject2 = paramh.nAf;
      if (localObject2 != null) {
        break label178;
      }
    }
    label160:
    label170:
    label178:
    for (Object localObject2 = localObject3;; localObject2 = ((c.b)localObject2).eglSurface)
    {
      c.a.a((EGLDisplay)localObject1, (EGLSurface)localObject2);
      paramh.nAn += 1;
      AppMethodBeat.o(237022);
      return;
      localObject1 = ((c.b)localObject1).nFB;
      break;
      localObject2 = ((c.b)localObject2).eglSurface;
      break label90;
      localObject1 = ((c.b)localObject1).nFB;
      break label113;
    }
  }
  
  private static final void a(h paramh, ImageReader paramImageReader)
  {
    AppMethodBeat.i(237006);
    s.u(paramh, "this$0");
    paramImageReader = paramImageReader.acquireNextImage();
    if (paramImageReader != null) {
      try
      {
        Log.i("MicroMsg.X264TransImageReaderEncoder", "nextYUVImage, size:[" + paramImageReader.getWidth() + 'x' + paramImageReader.getHeight() + "], format:" + paramImageReader.getFormat() + ", planes.size:" + paramImageReader.getPlanes().length + ", timestamp:" + paramImageReader.getTimestamp() + ", rowStride:" + paramImageReader.getPlanes()[0].getRowStride() + ", pixelStride:" + paramImageReader.getPlanes()[0].getPixelStride() + ",buffer.capacity:" + paramImageReader.getPlanes()[0].getBuffer().capacity());
        int i = paramImageReader.getWidth();
        int j = paramImageReader.getHeight();
        ??? = paramImageReader.getPlanes()[0];
        s.s(???, "image.planes[0]");
        paramh.a(i, j, (Image.Plane)???);
        paramh.nAo += 1;
        Log.i("MicroMsg.X264TransImageReaderEncoder", "end processImageYUVBufferToWriteYUVData, writeYuvCount:" + paramh.nAo + ", renderYuvCount:" + paramh.nAn);
        if (paramh.nAo % 10 == 0) {
          paramh.bpl();
        }
        synchronized (paramh.nAl)
        {
          try
          {
            paramh.nAl.notifyAll();
            paramh = ah.aiuX;
            return;
          }
          catch (Exception paramh)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", (Throwable)paramh, "notifyAll writeYuvRenderWaitLock error", new Object[0]);
            }
          }
        }
        AppMethodBeat.o(237006);
      }
      catch (Exception paramh)
      {
        Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", (Throwable)paramh, "acquireNextImage error", new Object[0]);
        return;
      }
      finally
      {
        paramImageReader.close();
        AppMethodBeat.o(237006);
      }
    }
  }
  
  private static final void a(h paramh, ImageReader paramImageReader, c.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(237015);
    s.u(paramh, "this$0");
    s.u(paramImageReader, "$it");
    s.u(paramb, "$videoDataRenderEnvironment");
    paramh.nAf = c.a.a(c.nFs, paramImageReader.getSurface(), 0, 0, paramb.eXL, 14);
    paramh.nAe = new com.tencent.mm.media.j.b.h(1, 15);
    paramImageReader = paramh.nAe;
    if (paramImageReader != null) {
      paramImageReader.ek(paramh.nAg, paramh.nAh);
    }
    paramImageReader = paramh.nAe;
    if (paramImageReader != null) {
      paramImageReader.nEW = paramInt1;
    }
    paramImageReader = paramh.nAe;
    if (paramImageReader != null) {
      paramImageReader.el(paramInt2, paramInt3);
    }
    Log.i("MicroMsg.X264TransImageReaderEncoder", "create rgb2yuvEGLEnvironment:" + paramh.nAf + ", shareEGLContext:" + paramb.eXL + ", texId:" + paramInt1 + ", texSize:[" + paramInt2 + ", " + paramInt3 + ']');
    AppMethodBeat.o(237015);
  }
  
  private static final void a(h paramh, c.b paramb)
  {
    AppMethodBeat.i(237045);
    s.u(paramh, "this$0");
    s.u(paramb, "$it");
    paramh = paramh.nAe;
    if (paramh != null) {
      paramh.release();
    }
    paramh = c.nFs;
    c.a.a(paramb);
    AppMethodBeat.o(237045);
  }
  
  private final boolean a(int paramInt1, int paramInt2, Image.Plane paramPlane)
  {
    AppMethodBeat.i(236986);
    synchronized (this.cBq)
    {
      if (this.bufId >= 0)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.X264TransImageReaderEncoder", "processImageYUVBufferToWriteYUVData, width:" + paramInt1 + ", height:" + paramInt2 + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
        paramInt1 = paramPlane.getRowStride();
        paramInt2 = paramPlane.getPixelStride();
        if (this.nAa == null) {
          this.nAa = ByteBuffer.allocateDirect(this.nAg * this.nAh * paramInt2);
        }
        ByteBuffer localByteBuffer = this.nAa;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        paramPlane = paramPlane.getBuffer();
        paramPlane.position(0);
        SightVideoJNI.nativeBufferCopy(paramPlane, this.nAa, this.nAg * paramInt2, this.nAh, paramInt1 - paramInt2 * this.nAg);
        SightVideoJNI.writeYuvDataForMMSightWithBuffer(this.bufId, (Buffer)this.nAa, this.videoWidth, this.videoHeight, false, false, this.videoWidth, this.videoHeight);
        Log.i("MicroMsg.X264TransImageReaderEncoder", s.X("end processImageYUVBufferToWriteYUVData, cost:", Long.valueOf(Util.ticksToNow(l))));
      }
      AppMethodBeat.o(236986);
      return false;
    }
  }
  
  private final void bpl()
  {
    AppMethodBeat.i(236990);
    synchronized (this.nAk)
    {
      try
      {
        Log.i("MicroMsg.X264TransImageReaderEncoder", "notify to encode");
        this.nAk.notifyAll();
        ah localah = ah.aiuX;
        AppMethodBeat.o(236990);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  public final void a(c.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(237078);
    s.u(paramb, "videoDataRenderEnvironment");
    Log.i("MicroMsg.X264TransImageReaderEncoder", "start");
    this.nAp = paramInt1;
    this.nAj = Util.currentTicks();
    this.nAg = (this.videoWidth / 4);
    this.nAh = (this.videoHeight * 3 / 2);
    this.nAb = ImageReader.newInstance(this.nAg, this.nAh, 1, 1);
    ImageReader localImageReader = this.nAb;
    if (localImageReader != null)
    {
      this.nAd.start();
      this.nAc = new Handler(this.nAd.getLooper());
      localImageReader.setOnImageAvailableListener(new h..ExternalSyntheticLambda0(this), this.nAc);
      Handler localHandler = this.nAc;
      if (localHandler != null) {
        localHandler.post(new h..ExternalSyntheticLambda3(this, localImageReader, paramb, paramInt1, paramInt2, paramInt3));
      }
    }
    Log.i("MicroMsg.X264TransImageReaderEncoder", "initRgb2YuvImageReader, yuv size:[" + this.nAg + 'x' + this.nAh + ']');
    AppMethodBeat.o(237078);
  }
  
  public final void hU(long paramLong)
  {
    AppMethodBeat.i(237084);
    Object localObject = this.nAc;
    if (localObject != null) {
      ((Handler)localObject).post(new h..ExternalSyntheticLambda2(this, paramLong));
    }
    if (this.nzU == null)
    {
      Log.i("MicroMsg.X264TransImageReaderEncoder", "do start encode loop");
      this.nzU = f.jZh().jZn().c(new h..ExternalSyntheticLambda1(this));
      localObject = this.nzU;
      if (localObject != null) {
        ((f)localObject).begin();
      }
    }
    AppMethodBeat.o(237084);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(237093);
    Log.i("MicroMsg.X264TransImageReaderEncoder", "stop");
    synchronized (this.cBq)
    {
      Log.i("MicroMsg.X264TransImageReaderEncoder", "finishEncode, encodePipeline:" + this.nzU + ", renderYuvCount:" + this.nAn + ", writeYuvCount:" + this.nAo);
      this.nAi = true;
      bpl();
      Object localObject2 = this.nAb;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localObject2 = this.nAf;
      if (localObject2 != null)
      {
        Handler localHandler = this.nAc;
        if (localHandler != null) {
          localHandler.post(new h..ExternalSyntheticLambda4(this, (c.b)localObject2));
        }
      }
      this.nAd.quitSafely();
      localObject2 = this.nzU;
      if (localObject2 != null) {
        ((f)localObject2).jZk();
      }
      this.nAb = null;
      this.nAf = null;
      this.nzU = null;
      localObject2 = ah.aiuX;
      AppMethodBeat.o(237093);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.h
 * JD-Core Version:    0.7.0.1
 */