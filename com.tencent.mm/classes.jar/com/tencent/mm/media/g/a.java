package com.tencent.mm.media.g;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.i.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bp;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "continueZeroPtsFrameCount", "", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "drawInOnFrameAvailableLock", "Ljava/lang/Object;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "firstFrame", "isFirstFrameAvailable", "isReleased", "lastFrameTimestamp", "lastPts", "newFrameAvailable", "newFrameLock", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "ptsStepUs", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getOutputSurface", "initForRemuxer", "canUseDrawInFrameAvailable", "width", "height", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "initWithSurface", "waitNewFrame", "isDrawInOnFrameAvailable", "queue", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setDrawInOnFrameAvailable", "draw", "setFirstFrameAvailable", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "setVideoFps", "fps", "updateDrawSize", "updateTextureSize", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a eWi;
  public final String TAG;
  public Surface axw;
  private SurfaceTexture bbI;
  private final HandlerThread eVQ;
  private ak eVR;
  b.b eVS;
  public a.f.a.b<? super Boolean, y> eVT;
  private final Object eVU;
  private boolean eVV;
  private volatile boolean eVW;
  private volatile boolean eVX;
  private a.f.a.b<? super Long, Bitmap> eVY;
  Bitmap eVZ;
  private volatile boolean eWa;
  private final Object eWb;
  a.f.a.a<y> eWc;
  int eWd;
  private int eWe;
  private boolean eWf;
  private long eWg;
  com.tencent.mm.media.h.a eWh;
  private long lastFrameTimestamp;
  
  static
  {
    AppMethodBeat.i(13028);
    eWi = new a.a((byte)0);
    AppMethodBeat.o(13028);
  }
  
  public a(com.tencent.mm.media.h.a parama)
  {
    AppMethodBeat.i(13027);
    this.eWh = parama;
    this.TAG = "MicroMsg.CodecInputSurface";
    this.eVQ = d.aqu("CodecInputSurface_renderThread");
    this.eVU = new Object();
    this.eWb = new Object();
    this.eWd = 33000000;
    this.eVQ.start();
    parama = this.eVQ;
    j.p(parama, "renderThread");
    this.eVR = new ak(parama.getLooper());
    this.eWf = true;
    AppMethodBeat.o(13027);
  }
  
  private final void UZ()
  {
    AppMethodBeat.i(154805);
    this.bbI = this.eWh.Vh();
    AppMethodBeat.o(154805);
  }
  
  private void cz(boolean paramBoolean)
  {
    AppMethodBeat.i(154806);
    synchronized (this.eWb)
    {
      this.eWa = paramBoolean;
      ab.i(this.TAG, "setDrawInOnFrameAvailable:".concat(String.valueOf(paramBoolean)));
      y localy = y.BMg;
      AppMethodBeat.o(154806);
      return;
    }
  }
  
  public final Surface UY()
  {
    AppMethodBeat.i(13020);
    if (this.bbI == null) {
      UZ();
    }
    Surface localSurface = new Surface(this.bbI);
    AppMethodBeat.o(13020);
    return localSurface;
  }
  
  public final void a(long paramLong, Bitmap paramBitmap)
  {
    AppMethodBeat.i(13017);
    d((a.f.a.a)new a.f(this, paramLong, paramBitmap));
    AppMethodBeat.o(13017);
  }
  
  public final void a(a.f.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(152090);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      ab.i(str, i);
      this.eVY = paramb;
      AppMethodBeat.o(152090);
      return;
    }
  }
  
  public final void a(Surface paramSurface, boolean paramBoolean, int paramInt1, int paramInt2, a.f.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(155526);
    this.axw = paramSurface;
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVK, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      cz(bool);
      ab.i(this.TAG, hashCode() + " initForRemuxer, surface:" + paramSurface + ", callback:false, drawInOnFrameAvailable:" + this.eWa);
      if (bp.dud())
      {
        ab.i(this.TAG, "in debug environment, set drawInOnFrameAvailable to true");
        cz(true);
      }
      if (!paramBoolean)
      {
        ab.i(this.TAG, "cannot use drawInFrameAvailable!");
        cz(false);
      }
      this.eWe = 0;
      d((a.f.a.a)new a.b(this, paramSurface, paramInt1, paramInt2, paramb));
      AppMethodBeat.o(155526);
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, a.f.a.b<? super byte[], y> paramb)
  {
    AppMethodBeat.i(13018);
    j.q(paramArrayOfByte, "data");
    j.q(paramb, "inputCallback");
    ab.d(this.TAG, "ByteArray length : " + paramArrayOfByte.length);
    d((a.f.a.a)new a.g(this, paramArrayOfByte, paramLong, paramb));
    AppMethodBeat.o(13018);
  }
  
  public final void cl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13021);
    this.eWh.cn(paramInt1, paramInt2);
    AppMethodBeat.o(13021);
  }
  
  public final void cm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13022);
    this.eWh.cm(paramInt1, paramInt2);
    AppMethodBeat.o(13022);
  }
  
  public final void d(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(13024);
    HandlerThread localHandlerThread = this.eVQ;
    j.p(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.eVX)) {
      this.eVR.post((Runnable)new b(parama));
    }
    AppMethodBeat.o(13024);
  }
  
  public final void jX(int paramInt)
  {
    AppMethodBeat.i(13023);
    this.eWh.jX(paramInt);
    AppMethodBeat.o(13023);
  }
  
  public final void release()
  {
    AppMethodBeat.i(13025);
    ab.i(this.TAG, hashCode() + " release resources");
    d((a.f.a.a)new a.e(this));
    AppMethodBeat.o(13025);
  }
  
  protected final void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(13026);
    Object localObject = this.eVS;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((b.b)localObject).eZx, ((b.b)localObject).eZy, paramLong);
    }
    localObject = com.tencent.mm.media.i.b.eZw;
    b.a.mS("eglPresentationTimeANDROID");
    AppMethodBeat.o(13026);
  }
  
  public final void u(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(13019);
    d((a.f.a.a)new h(this, paramInt, paramLong));
    AppMethodBeat.o(13019);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class h
    extends k
    implements a.f.a.a<y>
  {
    h(a parama, int paramInt, long paramLong)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class j
    implements SurfaceTexture.OnFrameAvailableListener
  {
    j(a parama) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(13016);
      Object localObject1 = a.b(this.eWj);
      Object localObject2 = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
      paramSurfaceTexture = a.f(this.eWj);
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
        ab.i((String)localObject1, paramSurfaceTexture + ", drawInOnFrameAvailable:" + a.g(this.eWj));
        paramSurfaceTexture = a.f(this.eWj);
        if (paramSurfaceTexture == null) {
          break label377;
        }
        if (paramSurfaceTexture.getTimestamp() > 0L) {
          break label217;
        }
        localObject1 = this.eWj;
        a.a((a)localObject1, a.i((a)localObject1) + 1);
      }
      for (;;)
      {
        if ((a.d(this.eWj)) && (paramSurfaceTexture.getTimestamp() <= 0L))
        {
          ab.i(a.b(this.eWj), "first frame available and new timestamp still zero!!");
          if (a.i(this.eWj) < 3) {
            break label246;
          }
          ab.i(a.b(this.eWj), "continue 3 frames pts is zero!!!");
          a.h(this.eWj);
          paramSurfaceTexture = a.j(this.eWj);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture.invoke();
            AppMethodBeat.o(13016);
            return;
            paramSurfaceTexture = null;
            break;
            label217:
            a.a(this.eWj, 0);
            continue;
          }
          AppMethodBeat.o(13016);
          return;
        }
      }
      a.a(this.eWj, paramSurfaceTexture.getTimestamp());
      label246:
      if (!a.d(this.eWj)) {
        a.e(this.eWj);
      }
      long l;
      if (a.g(this.eWj))
      {
        if (a.l(this.eWj) == null) {
          break label319;
        }
        localObject1 = this.eWj;
        l = a.k(this.eWj);
        paramSurfaceTexture = a.l(this.eWj);
      }
      for (;;)
      {
        a.a((a)localObject1, l, paramSurfaceTexture);
        AppMethodBeat.o(13016);
        return;
        label319:
        localObject1 = this.eWj;
        l = a.k(this.eWj);
        localObject2 = a.m(this.eWj);
        if (localObject2 != null) {
          paramSurfaceTexture = (Bitmap)((a.f.a.b)localObject2).S(Long.valueOf(paramSurfaceTexture.getTimestamp() / 1000L));
        } else {
          paramSurfaceTexture = null;
        }
      }
      label377:
      AppMethodBeat.o(13016);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.g.a
 * JD-Core Version:    0.7.0.1
 */