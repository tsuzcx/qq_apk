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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "blurBgBitmapProvider", "blurBgdBitmap", "continueZeroPtsFrameCount", "", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "drawInOnFrameAvailableLock", "Ljava/lang/Object;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "firstFrame", "isFirstFrameAvailable", "isReleased", "lastFrameTimestamp", "lastPts", "newFrameAvailable", "newFrameLock", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "ptsStepUs", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getOutputSurface", "initForRemuxer", "canUseDrawInFrameAvailable", "width", "height", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "initWithSurface", "waitNewFrame", "isDrawInOnFrameAvailable", "queue", "queueFirst", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "blurBg", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setDrawBlurBgBitmapProvider", "setDrawInOnFrameAvailable", "draw", "setFirstFrameAvailable", "setMirror", "mirror", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "setVideoFps", "fps", "updateDrawSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "mediaFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a gTj;
  public final String TAG;
  private long gOg;
  private final HandlerThread gSR;
  private ao gSS;
  public d.g.a.b<? super Boolean, y> gST;
  private final Object gSU;
  private boolean gSV;
  private volatile boolean gSW;
  private d.g.a.b<? super Long, Bitmap> gSX;
  Bitmap gSY;
  private d.g.a.b<? super Long, Bitmap> gSZ;
  private Bitmap gTa;
  private volatile boolean gTb;
  private final Object gTc;
  d.g.a.a<y> gTd;
  int gTe;
  private int gTf;
  private boolean gTg;
  private long gTh;
  public com.tencent.mm.media.i.a gTi;
  c.b gre;
  private volatile boolean isReleased;
  public Surface surface;
  private SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(93759);
    gTj = new a.a((byte)0);
    AppMethodBeat.o(93759);
  }
  
  public a(com.tencent.mm.media.i.a parama)
  {
    AppMethodBeat.i(93758);
    this.gTi = parama;
    this.TAG = "MicroMsg.CodecInputSurface";
    this.gSR = d.gB("CodecInputSurface_renderThread", 5);
    this.gSU = new Object();
    this.gTc = new Object();
    this.gTe = 33000000;
    this.gSR.start();
    parama = this.gSR;
    k.g(parama, "renderThread");
    this.gSS = new ao(parama.getLooper());
    this.gTg = true;
    AppMethodBeat.o(93758);
  }
  
  private final void arb()
  {
    AppMethodBeat.i(93754);
    this.surfaceTexture = this.gTi.getTexture();
    AppMethodBeat.o(93754);
  }
  
  private void eb(boolean paramBoolean)
  {
    AppMethodBeat.i(93755);
    synchronized (this.gTc)
    {
      this.gTb = paramBoolean;
      ac.i(this.TAG, "setDrawInOnFrameAvailable:".concat(String.valueOf(paramBoolean)));
      y localy = y.KTp;
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
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTB, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      eb(bool);
      ac.i(this.TAG, hashCode() + " initForRemuxer, surface:" + paramSurface + ", callback:false, drawInOnFrameAvailable:" + this.gTb);
      if (bt.eWo())
      {
        ac.i(this.TAG, "in debug environment, set drawInOnFrameAvailable to true");
        eb(true);
      }
      if (!paramBoolean)
      {
        ac.i(this.TAG, "cannot use drawInFrameAvailable!");
        eb(false);
      }
      this.gTf = 0;
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
    ac.d(this.TAG, "ByteArray length : " + paramArrayOfByte.length);
    i((d.g.a.a)new g(this, paramArrayOfByte, paramLong, paramb));
    AppMethodBeat.o(93746);
  }
  
  public final Surface ara()
  {
    AppMethodBeat.i(93748);
    if (this.surfaceTexture == null) {
      arb();
    }
    Surface localSurface = new Surface(this.surfaceTexture);
    AppMethodBeat.o(93748);
    return localSurface;
  }
  
  public final void cQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93749);
    this.gTi.cR(paramInt1, paramInt2);
    AppMethodBeat.o(93749);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93750);
    this.gTi.cS(paramInt1, paramInt2);
    AppMethodBeat.o(93750);
  }
  
  public final void e(MediaFormat paramMediaFormat)
  {
    int j = 0;
    AppMethodBeat.i(93751);
    k.h(paramMediaFormat, "mediaFormat");
    Object localObject1 = this.gTi;
    k.h(paramMediaFormat, "format");
    Object localObject2;
    int m;
    int k;
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUf, true))
    {
      if ((paramMediaFormat.containsKey("width")) && (paramMediaFormat.containsKey("height")))
      {
        ((com.tencent.mm.media.i.a)localObject1).gqZ = paramMediaFormat.getInteger("width");
        ((com.tencent.mm.media.i.a)localObject1).gra = paramMediaFormat.getInteger("height");
        localObject2 = ((com.tencent.mm.media.i.a)localObject1).gVc;
        if (localObject2 != null) {
          ((com.tencent.mm.media.i.b.a)localObject2).cS(((com.tencent.mm.media.i.a)localObject1).gqZ, ((com.tencent.mm.media.i.a)localObject1).gra);
        }
      }
      m = ((com.tencent.mm.media.i.a)localObject1).gra;
      k = ((com.tencent.mm.media.i.a)localObject1).gqZ;
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
      ac.i("MicroMsg.Media.AbsSurfaceRenderer", "updateTextureSizeByMediaFormat:textureWidth->" + ((com.tencent.mm.media.i.a)localObject1).gqZ + " textureHeight->" + ((com.tencent.mm.media.i.a)localObject1).gra + " validLeft->" + i + " validTop->" + m + " validRight->" + k + "  validBottom -> " + j);
      paramMediaFormat = ((com.tencent.mm.media.i.a)localObject1).gVc;
      if (paramMediaFormat != null)
      {
        localObject1 = new Point(i, m + 1);
        localObject2 = new Point(k + 1, j);
        k.h(localObject1, "leftTop");
        k.h(localObject2, "rightBottom");
        paramMediaFormat.gVE = ((Point)localObject1);
        paramMediaFormat.gVF = ((Point)localObject2);
        AppMethodBeat.o(93751);
        return;
      }
      AppMethodBeat.o(93751);
      return;
    }
  }
  
  public final void h(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93742);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      ac.i(str, i);
      this.gSX = paramb;
      AppMethodBeat.o(93742);
      return;
    }
  }
  
  public final void i(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(93753);
    HandlerThread localHandlerThread = this.gSR;
    k.g(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.isReleased))
    {
      this.gSS.post((Runnable)new b(parama));
      AppMethodBeat.o(93753);
      return;
    }
    ac.e(this.TAG, hashCode() + " queue already release");
    AppMethodBeat.o(93753);
  }
  
  public final void i(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93743);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlurBgBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      ac.i(str, i);
      this.gSZ = paramb;
      AppMethodBeat.o(93743);
      return;
    }
  }
  
  public final void mE(int paramInt)
  {
    AppMethodBeat.i(93752);
    this.gTi.mE(paramInt);
    AppMethodBeat.o(93752);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93756);
    ac.i(this.TAG, hashCode() + " release resources");
    d.g.a.a locala = (d.g.a.a)new e(this);
    HandlerThread localHandlerThread = this.gSR;
    k.g(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.isReleased))
    {
      this.gSS.removeCallbacksAndMessages(null);
      this.gSS.post((Runnable)new b(locala));
    }
    for (;;)
    {
      this.isReleased = true;
      AppMethodBeat.o(93756);
      return;
      ac.e(this.TAG, hashCode() + " queueFirst already release");
    }
  }
  
  protected final void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(93757);
    Object localObject = this.gre;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).gWK, ((c.b)localObject).eglSurface, paramLong);
    }
    localObject = c.gWJ;
    c.a.vq("eglPresentationTimeANDROID");
    AppMethodBeat.o(93757);
  }
  
  public final void v(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(93747);
    i((d.g.a.a)new h(this, paramInt, paramLong));
    AppMethodBeat.o(93747);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(a parama, Surface paramSurface, int paramInt1, int paramInt2, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(a parama, EGLContext paramEGLContext, int paramInt1, int paramInt2, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public d(a parama, EGLContext paramEGLContext, Surface paramSurface, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(a parama, long paramLong, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(a parama, byte[] paramArrayOfByte, long paramLong, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    h(a parama, int paramInt, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public i(a parama, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class k
    implements SurfaceTexture.OnFrameAvailableListener
  {
    k(a parama) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(93740);
      Object localObject1 = a.b(this.gTk);
      Object localObject2 = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
      paramSurfaceTexture = a.f(this.gTk);
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
        ac.i((String)localObject1, paramSurfaceTexture + ", drawInOnFrameAvailable:" + a.g(this.gTk));
        localObject1 = a.f(this.gTk);
        if (localObject1 == null) {
          break label428;
        }
        if (((SurfaceTexture)localObject1).getTimestamp() > 0L) {
          break label216;
        }
        paramSurfaceTexture = this.gTk;
        a.a(paramSurfaceTexture, a.i(paramSurfaceTexture) + 1);
      }
      for (;;)
      {
        if ((a.d(this.gTk)) && (((SurfaceTexture)localObject1).getTimestamp() <= 0L))
        {
          ac.i(a.b(this.gTk), "first frame available and new timestamp still zero!!");
          if (a.i(this.gTk) < 3) {
            break label245;
          }
          ac.i(a.b(this.gTk), "continue 3 frames pts is zero!!!");
          a.h(this.gTk);
          paramSurfaceTexture = a.j(this.gTk);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture.invoke();
            AppMethodBeat.o(93740);
            return;
            paramSurfaceTexture = null;
            break;
            label216:
            a.a(this.gTk, 0);
            continue;
          }
          AppMethodBeat.o(93740);
          return;
        }
      }
      a.a(this.gTk, ((SurfaceTexture)localObject1).getTimestamp());
      label245:
      if (!a.d(this.gTk)) {
        a.e(this.gTk);
      }
      long l;
      if (a.g(this.gTk))
      {
        if (a.l(this.gTk) == null) {
          break label328;
        }
        localObject2 = this.gTk;
        l = a.k(this.gTk);
        paramSurfaceTexture = a.l(this.gTk);
        localObject1 = a.m(this.gTk);
      }
      for (;;)
      {
        a.a((a)localObject2, l, paramSurfaceTexture, (Bitmap)localObject1);
        AppMethodBeat.o(93740);
        return;
        label328:
        localObject2 = this.gTk;
        l = a.k(this.gTk);
        paramSurfaceTexture = a.n(this.gTk);
        if (paramSurfaceTexture != null) {}
        for (paramSurfaceTexture = (Bitmap)paramSurfaceTexture.ay(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));; paramSurfaceTexture = null)
        {
          d.g.a.b localb = a.o(this.gTk);
          if (localb == null) {
            break label422;
          }
          localObject1 = (Bitmap)localb.ay(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));
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