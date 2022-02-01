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
import com.tencent.f.c.d;
import com.tencent.f.e.a;
import com.tencent.f.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder;", "Lcom/tencent/mm/media/encoder/ITransEncoder;", "bufId", "", "videoWidth", "videoHeight", "(III)V", "copyTmpBuffer", "Ljava/nio/ByteBuffer;", "curEncodeIndex", "encodePipeline", "Lcom/tencent/threadpool/internal/PipelineEx;", "encodeRGB2YuvHandler", "Landroid/os/Handler;", "encodeRGB2YuvHandlerThread", "Landroid/os/HandlerThread;", "encodeRGB2YuvImageReader", "Landroid/media/ImageReader;", "inputTexId", "isStopped", "", "renderYuvCount", "rgb2yuvEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "startEncodeTick", "", "stopLock", "Ljava/lang/Object;", "writeDataWaitEncodeLock", "writeYuvCount", "writeYuvDataEncodeLock", "writeYuvRenderWaitLock", "yuvHeight", "yuvRenderProc", "Lcom/tencent/mm/media/render/proc/RGB2YUVPortraitRenderProc;", "yuvWidth", "checkStartEncodeLoop", "", "encodeLoop", "finishEncode", "getFrameCount", "notifyToEncode", "processImageYUVBufferToWriteYUVData", "width", "height", "plane", "Landroid/media/Image$Plane;", "requestEncode", "timestampMs", "setupImageReader", "videoDataRenderEnvironment", "texId", "texWidth", "texHeight", "start", "stop", "waitWriteYuv", "Companion", "plugin-mediaeditor_release"})
public final class h
{
  public static final h.a ifX;
  private final int bufId;
  public volatile int ifA;
  private ByteBuffer ifH;
  public ImageReader ifI;
  public Handler ifJ;
  public HandlerThread ifK;
  private com.tencent.mm.media.j.b.h ifL;
  private c.b ifM;
  public int ifN;
  public int ifO;
  public volatile boolean ifP;
  public long ifQ;
  private final Object ifR;
  public final Object ifS;
  public final Object ifT;
  private volatile int ifU;
  public volatile int ifV;
  public int ifW;
  public f<?> ifx;
  private final Object stopLock;
  public final int videoHeight;
  public final int videoWidth;
  
  static
  {
    AppMethodBeat.i(218742);
    ifX = new h.a((byte)0);
    AppMethodBeat.o(218742);
  }
  
  public h(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(218741);
    this.bufId = paramInt1;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    HandlerThread localHandlerThread = d.hz("X264TransImageReaderEncoder_rgb2yuv_thread", -4);
    p.g(localHandlerThread, "SpecialThreadFactory.cre….THREAD_PRIORITY_DISPLAY)");
    this.ifK = localHandlerThread;
    this.stopLock = new Object();
    this.ifR = new Object();
    this.ifS = new Object();
    this.ifT = new Object();
    Log.i("MicroMsg.X264TransImageReaderEncoder", "create X264TransImageReaderEncoder, width:" + this.videoWidth + ", height:" + this.videoHeight);
    AppMethodBeat.o(218741);
  }
  
  private final boolean a(int paramInt1, int paramInt2, Image.Plane paramPlane)
  {
    AppMethodBeat.i(218738);
    synchronized (this.stopLock)
    {
      if (this.bufId >= 0)
      {
        long l = Util.currentTicks();
        Log.i("MicroMsg.X264TransImageReaderEncoder", "processImageYUVBufferToWriteYUVData, width:" + paramInt1 + ", height:" + paramInt2 + ", videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight);
        paramInt1 = paramPlane.getRowStride();
        paramInt2 = paramPlane.getPixelStride();
        if (this.ifH == null) {
          this.ifH = ByteBuffer.allocateDirect(this.ifN * this.ifO * paramInt2);
        }
        ByteBuffer localByteBuffer = this.ifH;
        if (localByteBuffer != null) {
          localByteBuffer.position(0);
        }
        paramPlane = paramPlane.getBuffer();
        paramPlane.position(0);
        SightVideoJNI.nativeBufferCopy(paramPlane, this.ifH, this.ifN * paramInt2, this.ifO, paramInt1 - paramInt2 * this.ifN);
        SightVideoJNI.writeYuvDataForMMSightWithBuffer(this.bufId, (Buffer)this.ifH, this.videoWidth, this.videoHeight, false, false, this.videoWidth, this.videoHeight);
        Log.i("MicroMsg.X264TransImageReaderEncoder", "end processImageYUVBufferToWriteYUVData, cost:" + Util.ticksToNow(l));
      }
      AppMethodBeat.o(218738);
      return false;
    }
  }
  
  private final void aMo()
  {
    AppMethodBeat.i(218739);
    synchronized (this.ifR)
    {
      try
      {
        Log.i("MicroMsg.X264TransImageReaderEncoder", "notify to encode");
        this.ifR.notifyAll();
        x localx = x.SXb;
        AppMethodBeat.o(218739);
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
    AppMethodBeat.i(218740);
    Log.i("MicroMsg.X264TransImageReaderEncoder", "stop");
    synchronized (this.stopLock)
    {
      Log.i("MicroMsg.X264TransImageReaderEncoder", "finishEncode, encodePipeline:" + this.ifx + ", renderYuvCount:" + this.ifU + ", writeYuvCount:" + this.ifV);
      this.ifP = true;
      aMo();
      Object localObject2 = this.ifI;
      if (localObject2 != null) {
        ((ImageReader)localObject2).close();
      }
      localObject2 = this.ifM;
      if (localObject2 != null)
      {
        Handler localHandler = this.ifJ;
        if (localHandler != null) {
          localHandler.post((Runnable)new c((c.b)localObject2, this));
        }
      }
      this.ifK.quitSafely();
      localObject2 = this.ifx;
      if (localObject2 != null) {
        ((f)localObject2).take();
      }
      this.ifI = null;
      this.ifM = null;
      this.ifx = null;
      localObject2 = x.SXb;
      AppMethodBeat.o(218740);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/threadpool/internal/Pipeline$NIL;", "kotlin.jvm.PlatformType", "input"})
  public static final class b<I, O>
    implements a<E, R>
  {
    public b(h paramh) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$finishEncode$1$1$1", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$$special$$inlined$let$lambda$1"})
  static final class c
    implements Runnable
  {
    c(c.b paramb, h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(218734);
      Object localObject = h.f(jdField_this);
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.h)localObject).release();
      }
      localObject = c.ilt;
      c.a.a(this.ifZ);
      AppMethodBeat.o(218734);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class d
    implements Runnable
  {
    public d(h paramh, long paramLong) {}
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(218735);
      Log.i("MicroMsg.X264TransImageReaderEncoder", "render gpu rgb2yuv, timestamp:" + this.iga);
      Object localObject1 = h.f(this.ifY);
      if (localObject1 != null) {
        ((com.tencent.mm.media.j.b.h)localObject1).aED();
      }
      localObject1 = h.e(this.ifY);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((c.b)localObject1).ilu;
        localObject2 = h.e(this.ifY);
        if (localObject2 == null) {
          break label166;
        }
        localObject2 = ((c.b)localObject2).eglSurface;
        label81:
        EGLExt.eglPresentationTimeANDROID((EGLDisplay)localObject1, (EGLSurface)localObject2, this.iga);
        localObject1 = c.ilt;
        localObject1 = h.e(this.ifY);
        if (localObject1 == null) {
          break label171;
        }
      }
      label166:
      label171:
      for (localObject1 = ((c.b)localObject1).ilu;; localObject1 = null)
      {
        c.b localb = h.e(this.ifY);
        localObject2 = localObject3;
        if (localb != null) {
          localObject2 = localb.eglSurface;
        }
        c.a.a((EGLDisplay)localObject1, (EGLSurface)localObject2);
        localObject1 = this.ifY;
        h.b((h)localObject1, h.b((h)localObject1) + 1);
        AppMethodBeat.o(218735);
        return;
        localObject1 = null;
        break;
        localObject2 = null;
        break label81;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "reader", "Landroid/media/ImageReader;", "kotlin.jvm.PlatformType", "onImageAvailable", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$setupImageReader$1$1"})
  public static final class e
    implements ImageReader.OnImageAvailableListener
  {
    public e(h paramh, c.b paramb, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onImageAvailable(ImageReader paramImageReader)
    {
      AppMethodBeat.i(218736);
      paramImageReader = paramImageReader.acquireNextImage();
      if (paramImageReader != null) {
        try
        {
          ??? = new StringBuilder("nextYUVImage, size:[").append(paramImageReader.getWidth()).append('x').append(paramImageReader.getHeight()).append("], format:").append(paramImageReader.getFormat()).append(", planes.size:").append(paramImageReader.getPlanes().length).append(", timestamp:").append(paramImageReader.getTimestamp()).append(", rowStride:");
          Object localObject3 = paramImageReader.getPlanes()[0];
          p.g(localObject3, "image.planes[0]");
          ??? = ((StringBuilder)???).append(((Image.Plane)localObject3).getRowStride()).append(", pixelStride:");
          localObject3 = paramImageReader.getPlanes()[0];
          p.g(localObject3, "image.planes[0]");
          ??? = ((StringBuilder)???).append(((Image.Plane)localObject3).getPixelStride()).append(',').append("buffer.capacity:");
          localObject3 = paramImageReader.getPlanes()[0];
          p.g(localObject3, "image.planes[0]");
          Log.i("MicroMsg.X264TransImageReaderEncoder", ((Image.Plane)localObject3).getBuffer().capacity());
          ??? = this.ifY;
          int i = paramImageReader.getWidth();
          int j = paramImageReader.getHeight();
          localObject3 = paramImageReader.getPlanes()[0];
          p.g(localObject3, "image.planes[0]");
          h.a((h)???, i, j, (Image.Plane)localObject3);
          ??? = this.ifY;
          h.a((h)???, h.a((h)???) + 1);
          Log.i("MicroMsg.X264TransImageReaderEncoder", "end processImageYUVBufferToWriteYUVData, writeYuvCount:" + h.a(this.ifY) + ", renderYuvCount:" + h.b(this.ifY));
          if (h.a(this.ifY) % 10 == 0) {
            h.c(this.ifY);
          }
          synchronized (h.d(this.ifY))
          {
            try
            {
              h.d(this.ifY).notifyAll();
              localObject3 = x.SXb;
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
          AppMethodBeat.o(218736);
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MicroMsg.X264TransImageReaderEncoder", (Throwable)localException1, "acquireNextImage error", new Object[0]);
          return;
        }
        finally
        {
          paramImageReader.close();
          AppMethodBeat.o(218736);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/media/encoder/X264TransImageReaderEncoder$setupImageReader$1$2"})
  public static final class f
    implements Runnable
  {
    public f(ImageReader paramImageReader, h paramh, c.b paramb, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void run()
    {
      AppMethodBeat.i(218737);
      h.a(this.ifY, c.a.a(c.ilt, this.igf.getSurface(), 0, 0, this.igb.ilv, 14));
      h.a(this.ifY, new com.tencent.mm.media.j.b.h(1, 15));
      com.tencent.mm.media.j.b.h localh = h.f(this.ifY);
      if (localh != null) {
        localh.cY(h.g(this.ifY), h.h(this.ifY));
      }
      localh = h.f(this.ifY);
      if (localh != null) {
        localh.ikZ = this.igc;
      }
      localh = h.f(this.ifY);
      if (localh != null) {
        localh.cZ(this.igd, this.ige);
      }
      Log.i("MicroMsg.X264TransImageReaderEncoder", "create rgb2yuvEGLEnvironment:" + h.e(this.ifY) + ", shareEGLContext:" + this.igb.ilv + ", texId:" + this.igc + ", texSize:[" + this.igd + ", " + this.ige + ']');
      AppMethodBeat.o(218737);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.e.h
 * JD-Core Version:    0.7.0.1
 */