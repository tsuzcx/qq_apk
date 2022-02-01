package com.tencent.mm.media.i;

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
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bv;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "blurBgBitmapProvider", "blurBgdBitmap", "continueZeroPtsFrameCount", "", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "drawInOnFrameAvailableLock", "Ljava/lang/Object;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "firstFrame", "isFirstFrameAvailable", "isReleased", "lastFrameTimestamp", "lastPts", "newFrameAvailable", "newFrameLock", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "ptsStepUs", "remuxStartTime", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getOutputSurface", "initForRemuxer", "canUseDrawInFrameAvailable", "width", "height", "startTime", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "initWithSurface", "waitNewFrame", "isDrawInOnFrameAvailable", "queue", "queueFirst", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "blurBg", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setDrawBlurBgBitmapProvider", "setDrawInOnFrameAvailable", "draw", "setFirstFrameAvailable", "setMirror", "mirror", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "setVideoFps", "fps", "updateDrawSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "mediaFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a hnZ;
  public final String TAG;
  c.b gNx;
  private long hkU;
  private final HandlerThread hnG;
  private aq hnH;
  public d.g.a.b<? super Boolean, z> hnI;
  private final Object hnJ;
  private boolean hnK;
  private volatile boolean hnL;
  private d.g.a.b<? super Long, Bitmap> hnM;
  Bitmap hnN;
  private d.g.a.b<? super Long, Bitmap> hnO;
  private Bitmap hnP;
  private volatile boolean hnQ;
  private final Object hnR;
  d.g.a.a<z> hnS;
  int hnT;
  private int hnU;
  private long hnV;
  private boolean hnW;
  private long hnX;
  public com.tencent.mm.media.j.a hnY;
  private volatile boolean isReleased;
  public Surface surface;
  private SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(93759);
    hnZ = new a.a((byte)0);
    AppMethodBeat.o(93759);
  }
  
  public a(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(93758);
    this.hnY = parama;
    this.TAG = "MicroMsg.CodecInputSurface";
    this.hnG = d.hi("CodecInputSurface_renderThread", 5);
    this.hnJ = new Object();
    this.hnR = new Object();
    this.hnT = 33000000;
    this.hnG.start();
    parama = this.hnG;
    p.g(parama, "renderThread");
    this.hnH = new aq(parama.getLooper());
    this.hnW = true;
    AppMethodBeat.o(93758);
  }
  
  private final void aud()
  {
    AppMethodBeat.i(93754);
    this.surfaceTexture = this.hnY.getTexture();
    AppMethodBeat.o(93754);
  }
  
  private void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(93755);
    synchronized (this.hnR)
    {
      this.hnQ = paramBoolean;
      ae.i(this.TAG, "setDrawInOnFrameAvailable:".concat(String.valueOf(paramBoolean)));
      z localz = z.Nhr;
      AppMethodBeat.o(93755);
      return;
    }
  }
  
  public final void a(final long paramLong, Bitmap paramBitmap1, final Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93744);
    j((d.g.a.a)new f(this, paramLong, paramBitmap1, paramBitmap2));
    AppMethodBeat.o(93744);
  }
  
  public final void a(final Surface paramSurface, boolean paramBoolean, final int paramInt1, final int paramInt2, long paramLong, final d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(217523);
    this.surface = paramSurface;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFn, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ef(bool);
      ae.i(this.TAG, hashCode() + " initForRemuxer, surface:" + paramSurface + ", callback:false, drawInOnFrameAvailable:" + this.hnQ);
      if (bv.fpT())
      {
        ae.i(this.TAG, "in debug environment, set drawInOnFrameAvailable to true");
        ef(true);
      }
      if (!paramBoolean)
      {
        ae.i(this.TAG, "cannot use drawInFrameAvailable!");
        ef(false);
      }
      this.hnU = 0;
      this.hnV = paramLong;
      j((d.g.a.a)new b(this, paramSurface, paramInt1, paramInt2, paramb));
      AppMethodBeat.o(217523);
      return;
    }
  }
  
  public final void a(final byte[] paramArrayOfByte, final long paramLong, d.g.a.b<? super byte[], z> paramb)
  {
    AppMethodBeat.i(93746);
    p.h(paramArrayOfByte, "data");
    p.h(paramb, "inputCallback");
    ae.d(this.TAG, "ByteArray length : " + paramArrayOfByte.length);
    j((d.g.a.a)new g(this, paramArrayOfByte, paramLong, paramb));
    AppMethodBeat.o(93746);
  }
  
  public final Surface auc()
  {
    AppMethodBeat.i(93748);
    if (this.surfaceTexture == null) {
      aud();
    }
    Surface localSurface = new Surface(this.surfaceTexture);
    AppMethodBeat.o(93748);
    return localSurface;
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93749);
    this.hnY.cT(paramInt1, paramInt2);
    AppMethodBeat.o(93749);
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93750);
    this.hnY.cU(paramInt1, paramInt2);
    AppMethodBeat.o(93750);
  }
  
  public final void e(MediaFormat paramMediaFormat)
  {
    int j = 0;
    AppMethodBeat.i(93751);
    p.h(paramMediaFormat, "mediaFormat");
    Object localObject1 = this.hnY;
    p.h(paramMediaFormat, "format");
    Object localObject2;
    int m;
    int k;
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFR, true))
    {
      if ((paramMediaFormat.containsKey("width")) && (paramMediaFormat.containsKey("height")))
      {
        ((com.tencent.mm.media.j.a)localObject1).gNs = paramMediaFormat.getInteger("width");
        ((com.tencent.mm.media.j.a)localObject1).gNt = paramMediaFormat.getInteger("height");
        localObject2 = ((com.tencent.mm.media.j.a)localObject1).hpT;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.a)localObject2).cU(((com.tencent.mm.media.j.a)localObject1).gNs, ((com.tencent.mm.media.j.a)localObject1).gNt);
        }
      }
      m = ((com.tencent.mm.media.j.a)localObject1).gNt;
      k = ((com.tencent.mm.media.j.a)localObject1).gNs;
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
      ae.i("MicroMsg.Media.AbsSurfaceRenderer", "updateTextureSizeByMediaFormat:textureWidth->" + ((com.tencent.mm.media.j.a)localObject1).gNs + " textureHeight->" + ((com.tencent.mm.media.j.a)localObject1).gNt + " validLeft->" + i + " validTop->" + m + " validRight->" + k + "  validBottom -> " + j);
      paramMediaFormat = ((com.tencent.mm.media.j.a)localObject1).hpT;
      if (paramMediaFormat != null)
      {
        localObject1 = new Point(i, m + 1);
        localObject2 = new Point(k + 1, j);
        p.h(localObject1, "leftTop");
        p.h(localObject2, "rightBottom");
        paramMediaFormat.hqw = ((Point)localObject1);
        paramMediaFormat.hqx = ((Point)localObject2);
        AppMethodBeat.o(93751);
        return;
      }
      AppMethodBeat.o(93751);
      return;
    }
  }
  
  public final void i(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93742);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      ae.i(str, i);
      this.hnM = paramb;
      AppMethodBeat.o(93742);
      return;
    }
  }
  
  public final void j(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(93753);
    HandlerThread localHandlerThread = this.hnG;
    p.g(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.isReleased))
    {
      this.hnH.post((Runnable)new b(parama));
      AppMethodBeat.o(93753);
      return;
    }
    ae.e(this.TAG, hashCode() + " queue already release");
    AppMethodBeat.o(93753);
  }
  
  public final void j(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93743);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlurBgBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      ae.i(str, i);
      this.hnO = paramb;
      AppMethodBeat.o(93743);
      return;
    }
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(93752);
    this.hnY.ng(paramInt);
    AppMethodBeat.o(93752);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93756);
    ae.i(this.TAG, hashCode() + " release resources");
    d.g.a.a locala = (d.g.a.a)new e(this);
    HandlerThread localHandlerThread = this.hnG;
    p.g(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.isReleased))
    {
      this.hnH.removeCallbacksAndMessages(null);
      this.hnH.post((Runnable)new b(locala));
    }
    for (;;)
    {
      this.isReleased = true;
      AppMethodBeat.o(93756);
      return;
      ae.e(this.TAG, hashCode() + " queueFirst already release");
    }
  }
  
  protected final void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(93757);
    Object localObject = this.gNx;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).hrE, ((c.b)localObject).eglSurface, paramLong);
    }
    localObject = c.hrD;
    c.a.yR("eglPresentationTimeANDROID");
    AppMethodBeat.o(93757);
  }
  
  public final void v(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(93747);
    j((d.g.a.a)new h(this, paramInt, paramLong));
    AppMethodBeat.o(93747);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(a parama, Surface paramSurface, int paramInt1, int paramInt2, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.a<z>
  {
    public c(a parama, EGLContext paramEGLContext, int paramInt1, int paramInt2, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class d
    extends q
    implements d.g.a.a<z>
  {
    public d(a parama, EGLContext paramEGLContext, Surface paramSurface, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(a parama, long paramLong, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(a parama, byte[] paramArrayOfByte, long paramLong, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements d.g.a.a<z>
  {
    h(a parama, int paramInt, long paramLong)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements d.g.a.a<z>
  {
    public i(a parama, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class k
    implements SurfaceTexture.OnFrameAvailableListener
  {
    k(a parama) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(93740);
      Object localObject1 = a.b(this.hoa);
      Object localObject2 = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
      paramSurfaceTexture = a.f(this.hoa);
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
        ae.i((String)localObject1, paramSurfaceTexture + ", drawInOnFrameAvailable:" + a.g(this.hoa));
        localObject1 = a.f(this.hoa);
        if (localObject1 == null) {
          break label428;
        }
        if (((SurfaceTexture)localObject1).getTimestamp() > 0L) {
          break label216;
        }
        paramSurfaceTexture = this.hoa;
        a.a(paramSurfaceTexture, a.i(paramSurfaceTexture) + 1);
      }
      for (;;)
      {
        if ((a.d(this.hoa)) && (((SurfaceTexture)localObject1).getTimestamp() <= 0L))
        {
          ae.i(a.b(this.hoa), "first frame available and new timestamp still zero!!");
          if (a.i(this.hoa) < 3) {
            break label245;
          }
          ae.i(a.b(this.hoa), "continue 3 frames pts is zero!!!");
          a.h(this.hoa);
          paramSurfaceTexture = a.j(this.hoa);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture.invoke();
            AppMethodBeat.o(93740);
            return;
            paramSurfaceTexture = null;
            break;
            label216:
            a.a(this.hoa, 0);
            continue;
          }
          AppMethodBeat.o(93740);
          return;
        }
      }
      a.a(this.hoa, ((SurfaceTexture)localObject1).getTimestamp());
      label245:
      if (!a.d(this.hoa)) {
        a.e(this.hoa);
      }
      long l;
      if (a.g(this.hoa))
      {
        if (a.l(this.hoa) == null) {
          break label328;
        }
        localObject2 = this.hoa;
        l = a.k(this.hoa);
        paramSurfaceTexture = a.l(this.hoa);
        localObject1 = a.m(this.hoa);
      }
      for (;;)
      {
        a.a((a)localObject2, l, paramSurfaceTexture, (Bitmap)localObject1);
        AppMethodBeat.o(93740);
        return;
        label328:
        localObject2 = this.hoa;
        l = a.k(this.hoa);
        paramSurfaceTexture = a.n(this.hoa);
        if (paramSurfaceTexture != null) {}
        for (paramSurfaceTexture = (Bitmap)paramSurfaceTexture.invoke(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));; paramSurfaceTexture = null)
        {
          d.g.a.b localb = a.o(this.hoa);
          if (localb == null) {
            break label422;
          }
          localObject1 = (Bitmap)localb.invoke(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.i.a
 * JD-Core Version:    0.7.0.1
 */