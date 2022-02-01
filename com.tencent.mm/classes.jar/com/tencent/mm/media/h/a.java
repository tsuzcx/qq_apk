package com.tencent.mm.media.h;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "blurBgBitmapProvider", "blurBgdBitmap", "continueZeroPtsFrameCount", "", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "drawInOnFrameAvailableLock", "Ljava/lang/Object;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "firstFrame", "isFirstFrameAvailable", "isReleased", "lastFrameTimestamp", "lastPts", "newFrameAvailable", "newFrameLock", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "ptsStepUs", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getOutputSurface", "initForRemuxer", "canUseDrawInFrameAvailable", "width", "height", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "initWithSurface", "waitNewFrame", "isDrawInOnFrameAvailable", "queue", "queueFirst", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "blurBg", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setDrawBlurBgBitmapProvider", "setDrawInOnFrameAvailable", "draw", "setFirstFrameAvailable", "setMirror", "mirror", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "setVideoFps", "fps", "updateDrawSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "mediaFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a gsC;
  public final String TAG;
  private long gnu;
  private long gsA;
  public com.tencent.mm.media.i.a gsB;
  private final HandlerThread gsj;
  private ap gsk;
  c.b gsl;
  public d.g.a.b<? super Boolean, y> gsm;
  private final Object gsn;
  private boolean gso;
  private volatile boolean gsp;
  private d.g.a.b<? super Long, Bitmap> gsq;
  Bitmap gsr;
  private d.g.a.b<? super Long, Bitmap> gss;
  private Bitmap gst;
  private volatile boolean gsu;
  private final Object gsv;
  d.g.a.a<y> gsw;
  int gsx;
  private int gsy;
  private boolean gsz;
  private volatile boolean isReleased;
  public Surface surface;
  private SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(93759);
    gsC = new a.a((byte)0);
    AppMethodBeat.o(93759);
  }
  
  public a(com.tencent.mm.media.i.a parama)
  {
    AppMethodBeat.i(93758);
    this.gsB = parama;
    this.TAG = "MicroMsg.CodecInputSurface";
    this.gsj = d.gx("CodecInputSurface_renderThread", 5);
    this.gsn = new Object();
    this.gsv = new Object();
    this.gsx = 33000000;
    this.gsj.start();
    parama = this.gsj;
    k.g(parama, "renderThread");
    this.gsk = new ap(parama.getLooper());
    this.gsz = true;
    AppMethodBeat.o(93758);
  }
  
  private final void akc()
  {
    AppMethodBeat.i(93754);
    this.surfaceTexture = this.gsB.getTexture();
    AppMethodBeat.o(93754);
  }
  
  private void dG(boolean paramBoolean)
  {
    AppMethodBeat.i(93755);
    synchronized (this.gsv)
    {
      this.gsu = paramBoolean;
      ad.i(this.TAG, "setDrawInOnFrameAvailable:".concat(String.valueOf(paramBoolean)));
      y localy = y.JfV;
      AppMethodBeat.o(93755);
      return;
    }
  }
  
  public final void a(final long paramLong, Bitmap paramBitmap1, final Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93744);
    i((d.g.a.a)new f(this, paramLong, paramBitmap1, paramBitmap2));
    AppMethodBeat.o(93744);
  }
  
  public final void a(final Surface paramSurface, boolean paramBoolean, final int paramInt1, final int paramInt2, final d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(93741);
    this.surface = paramSurface;
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.ppQ, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      dG(bool);
      ad.i(this.TAG, hashCode() + " initForRemuxer, surface:" + paramSurface + ", callback:false, drawInOnFrameAvailable:" + this.gsu);
      if (bu.eGT())
      {
        ad.i(this.TAG, "in debug environment, set drawInOnFrameAvailable to true");
        dG(true);
      }
      if (!paramBoolean)
      {
        ad.i(this.TAG, "cannot use drawInFrameAvailable!");
        dG(false);
      }
      this.gsy = 0;
      i((d.g.a.a)new b(this, paramSurface, paramInt1, paramInt2, paramb));
      AppMethodBeat.o(93741);
      return;
    }
  }
  
  public final void a(final byte[] paramArrayOfByte, final long paramLong, d.g.a.b<? super byte[], y> paramb)
  {
    AppMethodBeat.i(93746);
    k.h(paramArrayOfByte, "data");
    k.h(paramb, "inputCallback");
    ad.d(this.TAG, "ByteArray length : " + paramArrayOfByte.length);
    i((d.g.a.a)new g(this, paramArrayOfByte, paramLong, paramb));
    AppMethodBeat.o(93746);
  }
  
  public final Surface akb()
  {
    AppMethodBeat.i(93748);
    if (this.surfaceTexture == null) {
      akc();
    }
    Surface localSurface = new Surface(this.surfaceTexture);
    AppMethodBeat.o(93748);
    return localSurface;
  }
  
  public final void c(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93742);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      ad.i(str, i);
      this.gsq = paramb;
      AppMethodBeat.o(93742);
      return;
    }
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93749);
    this.gsB.cT(paramInt1, paramInt2);
    AppMethodBeat.o(93749);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93750);
    this.gsB.cS(paramInt1, paramInt2);
    AppMethodBeat.o(93750);
  }
  
  public final void d(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93743);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlurBgBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      ad.i(str, i);
      this.gss = paramb;
      AppMethodBeat.o(93743);
      return;
    }
  }
  
  public final void e(MediaFormat paramMediaFormat)
  {
    int j = 0;
    AppMethodBeat.i(93751);
    k.h(paramMediaFormat, "mediaFormat");
    Object localObject1 = this.gsB;
    k.h(paramMediaFormat, "format");
    Object localObject2;
    int m;
    int k;
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqs, true))
    {
      if ((paramMediaFormat.containsKey("width")) && (paramMediaFormat.containsKey("height")))
      {
        ((com.tencent.mm.media.i.a)localObject1).guI = paramMediaFormat.getInteger("width");
        ((com.tencent.mm.media.i.a)localObject1).guJ = paramMediaFormat.getInteger("height");
        localObject2 = ((com.tencent.mm.media.i.a)localObject1).gux;
        if (localObject2 != null) {
          ((com.tencent.mm.media.i.b.a)localObject2).cS(((com.tencent.mm.media.i.a)localObject1).guI, ((com.tencent.mm.media.i.a)localObject1).guJ);
        }
      }
      m = ((com.tencent.mm.media.i.a)localObject1).guJ;
      k = ((com.tencent.mm.media.i.a)localObject1).guI;
      if (!paramMediaFormat.containsKey("crop-left")) {
        break label375;
      }
    }
    label375:
    for (int i = paramMediaFormat.getInteger("crop-left");; i = 0)
    {
      if (paramMediaFormat.containsKey("crop-top")) {
        j = paramMediaFormat.getInteger("crop-top");
      }
      if (paramMediaFormat.containsKey("crop-right")) {
        k = paramMediaFormat.getInteger("crop-right") + 1;
      }
      if (paramMediaFormat.containsKey("crop-bottom")) {
        m = paramMediaFormat.getInteger("crop-bottom") + 1;
      }
      ad.i("MicroMsg.Media.AbsSurfaceRenderer", "updateTextureSizeByMediaFormat:textureWidth->" + ((com.tencent.mm.media.i.a)localObject1).guI + " textureHeight->" + ((com.tencent.mm.media.i.a)localObject1).guJ + " validLeft->" + i + " validTop->" + m + " validRight->" + k + "  validBottom -> " + j);
      paramMediaFormat = ((com.tencent.mm.media.i.a)localObject1).gux;
      if (paramMediaFormat != null)
      {
        localObject1 = new Point(i, m + 1);
        localObject2 = new Point(k + 1, j);
        k.h(localObject1, "leftTop");
        k.h(localObject2, "rightBottom");
        paramMediaFormat.gvh = ((Point)localObject1);
        paramMediaFormat.gvi = ((Point)localObject2);
        AppMethodBeat.o(93751);
        return;
      }
      AppMethodBeat.o(93751);
      return;
    }
  }
  
  public final void i(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(93753);
    HandlerThread localHandlerThread = this.gsj;
    k.g(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.isReleased))
    {
      this.gsk.post((Runnable)new b(parama));
      AppMethodBeat.o(93753);
      return;
    }
    ad.e(this.TAG, hashCode() + " queue already release");
    AppMethodBeat.o(93753);
  }
  
  public final void mz(int paramInt)
  {
    AppMethodBeat.i(93752);
    this.gsB.mz(paramInt);
    AppMethodBeat.o(93752);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93756);
    ad.i(this.TAG, hashCode() + " release resources");
    d.g.a.a locala = (d.g.a.a)new e(this);
    HandlerThread localHandlerThread = this.gsj;
    k.g(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.isReleased))
    {
      this.gsk.removeCallbacksAndMessages(null);
      this.gsk.post((Runnable)new b(locala));
    }
    for (;;)
    {
      this.isReleased = true;
      AppMethodBeat.o(93756);
      return;
      ad.e(this.TAG, hashCode() + " queueFirst already release");
    }
  }
  
  protected final void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(93757);
    Object localObject = this.gsl;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).gwm, ((c.b)localObject).eglSurface, paramLong);
    }
    localObject = c.gwl;
    c.a.ro("eglPresentationTimeANDROID");
    AppMethodBeat.o(93757);
  }
  
  public final void w(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(93747);
    i((d.g.a.a)new h(this, paramInt, paramLong));
    AppMethodBeat.o(93747);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(a parama, Surface paramSurface, int paramInt1, int paramInt2, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(a parama, EGLContext paramEGLContext, int paramInt1, int paramInt2, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public d(a parama, EGLContext paramEGLContext, Surface paramSurface, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(a parama, long paramLong, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(a parama, byte[] paramArrayOfByte, long paramLong, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(a parama, int paramInt, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public i(a parama, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class j
    implements SurfaceTexture.OnFrameAvailableListener
  {
    j(a parama) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(93740);
      Object localObject1 = a.b(this.gsD);
      Object localObject2 = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
      paramSurfaceTexture = a.f(this.gsD);
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
        ad.i((String)localObject1, paramSurfaceTexture + ", drawInOnFrameAvailable:" + a.g(this.gsD));
        localObject1 = a.f(this.gsD);
        if (localObject1 == null) {
          break label428;
        }
        if (((SurfaceTexture)localObject1).getTimestamp() > 0L) {
          break label216;
        }
        paramSurfaceTexture = this.gsD;
        a.a(paramSurfaceTexture, a.i(paramSurfaceTexture) + 1);
      }
      for (;;)
      {
        if ((a.d(this.gsD)) && (((SurfaceTexture)localObject1).getTimestamp() <= 0L))
        {
          ad.i(a.b(this.gsD), "first frame available and new timestamp still zero!!");
          if (a.i(this.gsD) < 3) {
            break label245;
          }
          ad.i(a.b(this.gsD), "continue 3 frames pts is zero!!!");
          a.h(this.gsD);
          paramSurfaceTexture = a.j(this.gsD);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture.invoke();
            AppMethodBeat.o(93740);
            return;
            paramSurfaceTexture = null;
            break;
            label216:
            a.a(this.gsD, 0);
            continue;
          }
          AppMethodBeat.o(93740);
          return;
        }
      }
      a.a(this.gsD, ((SurfaceTexture)localObject1).getTimestamp());
      label245:
      if (!a.d(this.gsD)) {
        a.e(this.gsD);
      }
      long l;
      if (a.g(this.gsD))
      {
        if (a.l(this.gsD) == null) {
          break label328;
        }
        localObject2 = this.gsD;
        l = a.k(this.gsD);
        paramSurfaceTexture = a.l(this.gsD);
        localObject1 = a.m(this.gsD);
      }
      for (;;)
      {
        a.a((a)localObject2, l, paramSurfaceTexture, (Bitmap)localObject1);
        AppMethodBeat.o(93740);
        return;
        label328:
        localObject2 = this.gsD;
        l = a.k(this.gsD);
        paramSurfaceTexture = a.n(this.gsD);
        if (paramSurfaceTexture != null) {}
        for (paramSurfaceTexture = (Bitmap)paramSurfaceTexture.aA(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));; paramSurfaceTexture = null)
        {
          d.g.a.b localb = a.o(this.gsD);
          if (localb == null) {
            break label422;
          }
          localObject1 = (Bitmap)localb.aA(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));
          break;
        }
        label422:
        localObject1 = null;
      }
      label428:
      AppMethodBeat.o(93740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.h.a
 * JD-Core Version:    0.7.0.1
 */