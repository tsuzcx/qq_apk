package com.tencent.mm.media.e;

import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.e.c.d;
import com.tencent.e.e.a;
import com.tencent.e.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.h;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "videoWidth", "videoHeight", "(III)V", "copyTmpBuffer", "Ljava/nio/ByteBuffer;", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeRGB2YuvHandler", "Landroid/os/Handler;", "encodeRGB2YuvHandlerThread", "Landroid/os/HandlerThread;", "encodeRGB2YuvImageReader", "Landroid/media/ImageReader;", "inputTexId", "isStopped", "", "renderYuvCount", "rgb2yuvEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "startEncodeTick", "", "stopLock", "Ljava/lang/Object;", "writeDataWaitEncodeLock", "writeYuvCount", "writeYuvDataEncodeLock", "writeYuvRenderWaitLock", "yuvHeight", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVPortraitRenderProc;", "yuvWidth", "checkStartEncodeLoop", "", "encodeLoop", "finishEncode", "getFrameCount", "notifyToEncode", "processImageYUVBufferToWriteYUVData", "width", "height", "plane", "Landroid/media/Image$Plane;", "requestEncode", "timestampMs", "setupImageReader", "videoDataRenderEnvironment", "texId", "texWidth", "texHeight", "start", "stop", "waitWriteYuv", "Companion", "plugin-mediaeditor_release"})
public final class i
{
  public static final i.a kUL;
  private final Object aFF;
  private final int bufId;
  private c.b kUA;
  public int kUB;
  public int kUC;
  public volatile boolean kUD;
  public long kUE;
  private final Object kUF;
  public final Object kUG;
  public final Object kUH;
  private volatile int kUI;
  public volatile int kUJ;
  public int kUK;
  public f<?> kUl;
  public volatile int kUo;
  private ByteBuffer kUv;
  public ImageReader kUw;
  public Handler kUx;
  public HandlerThread kUy;
  private h kUz;
  public final int videoHeight;
  public final int videoWidth;
  
  static
  {
    AppMethodBeat.i(261695);
    kUL = new i.a((byte)0);
    AppMethodBeat.o(261695);
  }
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(261694);
    this.bufId = paramInt1;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    HandlerThread localHandlerThread = d.ij("X264TransImageReaderEncoder_rgb2yuv_thread", -4);
    p.j(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.kUy = localHandlerThread;
    this.aFF = new Object();
    this.kUF = new Object();
    this.kUG = new Object();
    this.kUH = new Object();
    Log.i("MicroMsg.X264TransImageReaderEncoder", "create X264TransImageReaderEncoder, width:" + this.videoWidth + ", height:" + this.videoHeight);
    AppMethodBeat.o(261694);
  }
  
  private final boolean a(int paramInt1, int paramInt2, Image.Plane paramPlane)
  {
    AppMethodBeat.i(261687);
    synchronized (this.aFF)
    {
      if (this.bufId >= 0)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.X264TransImageReaderEncoder", "processImageYUVBufferToWriteYUVData, width:" + paramInt1 + ", height:" + paramInt2 + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
        paramInt1 = paramPlane.getRowStride();
        paramInt2 = paramPlane.getPixelStride();
        if (this.kUv == null) {
          this.kUv = ByteBuffer.allocateDirect(this.kUB * this.kUC * paramInt2);
        }
        ByteBuffer localByteBuffer = this.kUv;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        paramPlane = paramPlane.getBuffer();
        paramPlane.position(0);
        SightVideoJNI.nativeBufferCopy(paramPlane, this.kUv, this.kUB * paramInt2, this.kUC, paramInt1 - paramInt2 * this.kUB);
        SightVideoJNI.writeYuvDataForMMSightWithBuffer(this.bufId, (Buffer)this.kUv, this.videoWidth, this.videoHeight, false, false, this.videoWidth, this.videoHeight);
        Log.i("MicroMsg.X264TransImageReaderEncoder", "end processImageYUVBufferToWriteYUVData, cost:" + Util.ticksToNow(l));
      }
      AppMethodBeat.o(261687);
      return false;
    }
  }
  
  private final void aUE()
  {
    AppMethodBeat.i(261688);
    synchronized (this.kUF)
    {
      try
      {
        Log.i("MicroMsg.X264TransImageReaderEncoder", "notify to encode");
        this.kUF.notifyAll();
        x localx = x.aazN;
        AppMethodBeat.o(261688);
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
  
  public final void stop()
  {
    AppMethodBeat.i(261691);
    Log.i("MicroMsg.X264TransImageReaderEncoder", "stop");
    synchronized (this.aFF)
    {
      Log.i("MicroMsg.X264TransImageReaderEncoder", "finishEncode, encodePipeline:" + this.kUl + ", renderYuvCount:" + this.kUI + ", writeYuvCount:" + this.kUJ);
      this.kUD = true;
      aUE();
      Object localObject2 = this.kUw;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localObject2 = this.kUA;
      if (localObject2 != null)
      {
        Handler localHandler = this.kUx;
        if (localHandler != null) {
          localHandler.post((Runnable)new c((c.b)localObject2, this));
        }
      }
      this.kUy.quitSafely();
      localObject2 = this.kUl;
      if (localObject2 != null) {
        ((f)localObject2).ipQ();
      }
      this.kUw = null;
      this.kUA = null;
      this.kUl = null;
      localObject2 = x.aazN;
      AppMethodBeat.o(261691);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  public static final class b<I, O>
    implements a<E, R>
  {
    public b(i parami) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$finishEncode$1$1$1", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$$special$$inlined$let$lambda$1"})
  static final class c
    implements Runnable
  {
    c(c.b paramb, i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(258830);
      Object localObject = i.f(jdField_this);
      if (localObject != null) {
        ((h)localObject).release();
      }
      localObject = c.lar;
      c.a.a(this.kUN);
      AppMethodBeat.o(258830);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(i parami, long paramLong) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(258223);
      if (i.i(this.kUM))
      {
        Log.i("MicroMsg.X264TransImageReaderEncoder", "render gpu rgb2yuv, already stop");
        AppMethodBeat.o(258223);
        return;
      }
      Log.i("MicroMsg.X264TransImageReaderEncoder", "render gpu rgb2yuv, timestamp:" + this.kUO);
      Object localObject1 = i.f(this.kUM);
      if (localObject1 != null) {
        ((h)localObject1).aMU();
      }
      localObject1 = i.e(this.kUM);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((c.b)localObject1).las;
        localObject2 = i.e(this.kUM);
        if (localObject2 == null) {
          break label189;
        }
        localObject2 = ((c.b)localObject2).eglSurface;
        label104:
        EGLExt.eglPresentationTimeANDROID((EGLDisplay)localObject1, (EGLSurface)localObject2, this.kUO);
        localObject1 = c.lar;
        localObject1 = i.e(this.kUM);
        if (localObject1 == null) {
          break label194;
        }
      }
      label189:
      label194:
      for (localObject1 = ((c.b)localObject1).las;; localObject1 = null)
      {
        c.b localb = i.e(this.kUM);
        localObject2 = localObject3;
        if (localb != null) {
          localObject2 = localb.eglSurface;
        }
        c.a.a((EGLDisplay)localObject1, (EGLSurface)localObject2);
        localObject1 = this.kUM;
        i.b((i)localObject1, i.b((i)localObject1) + 1);
        AppMethodBeat.o(258223);
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label104;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$setupImageReader$1$1"})
  public static final class e
    implements ImageReader.OnImageAvailableListener
  {
    public e(i parami, c.b paramb, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onImageAvailable(ImageReader paramImageReader)
    {
      AppMethodBeat.i(258309);
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null) {
        try
        {
          ??? = new StringBuilder("nextYUVImage, size:[").append(paramImageReader.getWidth()).append('x').append(paramImageReader.getHeight()).append("], format:").append(paramImageReader.getFormat()).append(", planes.size:").append(paramImageReader.getPlanes().length).append(", timestamp:").append(paramImageReader.getTimestamp()).append(", rowStride:");
          Object localObject3 = paramImageReader.getPlanes()[0];
          p.j(localObject3, "image.planes[0]");
          ??? = ((StringBuilder)???).append(((Image.Plane)localObject3).getRowStride()).append(", pixelStride:");
          localObject3 = paramImageReader.getPlanes()[0];
          p.j(localObject3, "image.planes[0]");
          ??? = ((StringBuilder)???).append(((Image.Plane)localObject3).getPixelStride()).append(',').append("buffer.capacity:");
          localObject3 = paramImageReader.getPlanes()[0];
          p.j(localObject3, "image.planes[0]");
          Log.i("MicroMsg.X264TransImageReaderEncoder", ((Image.Plane)localObject3).getBuffer().capacity());
          ??? = this.kUM;
          int i = paramImageReader.getWidth();
          int j = paramImageReader.getHeight();
          localObject3 = paramImageReader.getPlanes()[0];
          p.j(localObject3, "image.planes[0]");
          i.a((i)???, i, j, (Image.Plane)localObject3);
          ??? = this.kUM;
          i.a((i)???, i.a((i)???) + 1);
          Log.i("MicroMsg.X264TransImageReaderEncoder", "end processImageYUVBufferToWriteYUVData, writeYuvCount:" + i.a(this.kUM) + ", renderYuvCount:" + i.b(this.kUM));
          if (i.a(this.kUM) % 10 == 0) {
            i.c(this.kUM);
          }
          synchronized (i.d(this.kUM))
          {
            try
            {
              i.d(this.kUM).notifyAll();
              localObject3 = x.aazN;
              return;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", (Throwable)localException2, "notifyAll writeYuvRenderWaitLock error", new Object[0]);
              }
            }
          }
          AppMethodBeat.o(258309);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", (Throwable)localException1, "acquireNextImage error", new Object[0]);
          return;
        }
        finally
        {
          paramImageReader.close();
          AppMethodBeat.o(258309);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$setupImageReader$1$2"})
  public static final class f
    implements Runnable
  {
    public f(ImageReader paramImageReader, i parami, c.b paramb, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void run()
    {
      AppMethodBeat.i(258089);
      i.a(this.kUM, c.a.a(c.lar, this.kUT.getSurface(), 0, 0, this.kUP.lau, 14));
      i.a(this.kUM, new h(1, 15));
      h localh = i.f(this.kUM);
      if (localh != null) {
        localh.du(i.g(this.kUM), i.h(this.kUM));
      }
      localh = i.f(this.kUM);
      if (localh != null) {
        localh.kZT = this.kUQ;
      }
      localh = i.f(this.kUM);
      if (localh != null) {
        localh.dv(this.kUR, this.kUS);
      }
      Log.i("MicroMsg.X264TransImageReaderEncoder", "create rgb2yuvEGLEnvironment:" + i.e(this.kUM) + ", shareEGLContext:" + this.kUP.lau + ", texId:" + this.kUQ + ", texSize:[" + this.kUR + ", " + this.kUS + ']');
      AppMethodBeat.o(258089);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.e.i
 * JD-Core Version:    0.7.0.1
 */