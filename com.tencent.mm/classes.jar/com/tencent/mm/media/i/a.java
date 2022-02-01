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
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "TAG", "", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "Lkotlin/Function1;", "", "blurBgBitmapProvider", "blurBgdBitmap", "continueZeroPtsFrameCount", "", "currentRenderPtsNs", "drawCallback", "", "", "getDrawCallback", "()Lkotlin/jvm/functions/Function1;", "setDrawCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawInOnFrameAvailable", "drawInOnFrameAvailableLock", "Ljava/lang/Object;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getEglEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setEglEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "firstFrame", "isFirstFrameAvailable", "isReleased", "lastFrameTimestamp", "lastPts", "newFrameAvailable", "newFrameLock", "onDrawFrameOnFrameAvailableFailed", "Lkotlin/Function0;", "ptsStepUs", "remuxStartTime", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "setUpEnvWithShareContext", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getCurrentRenderPtsNs", "getEGLEnvironment", "getOutputSurface", "initForRemuxer", "canUseDrawInFrameAvailable", "width", "height", "startTime", "callback", "Lkotlin/ParameterName;", "name", "success", "initSurfaceTexture", "initWithSize", "eglContext", "Landroid/opengl/EGLContext;", "initWithSurface", "waitNewFrame", "isDrawInOnFrameAvailable", "queue", "queueFirst", "release", "requestDraw", "data", "", "pts", "inputCallback", "textureId", "bitmap", "waitFistFrameAvailable", "blurBg", "requestDrawInGLThread", "runInGlesThread", "setDrawBlendBitmap", "setDrawBlendBitmapProvider", "setDrawBlurBgBitmapProvider", "setDrawInOnFrameAvailable", "draw", "setFirstFrameAvailable", "setMirror", "mirror", "setOnDrawFrameOnFrameAvailableFailed", "setOnFrameAvailable", "setPresentationTime", "nsecs", "setRotate", "degree", "setVideoFps", "fps", "updateDrawSize", "updateTextureSize", "updateTextureSizeByMediaFormat", "mediaFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public final class a
{
  public static final a.a iht;
  public final String TAG;
  c.b hDs;
  private long idR;
  private final HandlerThread igZ;
  private MMHandler iha;
  public kotlin.g.a.b<? super Boolean, x> ihb;
  private final Object ihc;
  private boolean ihd;
  private volatile boolean ihe;
  private kotlin.g.a.b<? super Long, Bitmap> ihf;
  Bitmap ihg;
  private kotlin.g.a.b<? super Long, Bitmap> ihh;
  private Bitmap ihi;
  private volatile boolean ihj;
  private final Object ihk;
  kotlin.g.a.a<x> ihl;
  int ihm;
  private int ihn;
  private long iho;
  volatile long ihp;
  private boolean ihq;
  private long ihr;
  public com.tencent.mm.media.j.a ihs;
  private volatile boolean isReleased;
  public Surface surface;
  private SurfaceTexture surfaceTexture;
  
  static
  {
    AppMethodBeat.i(93759);
    iht = new a.a((byte)0);
    AppMethodBeat.o(93759);
  }
  
  public a(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(93758);
    this.ihs = parama;
    this.TAG = "MicroMsg.CodecInputSurface";
    this.igZ = d.hC("CodecInputSurface_renderThread", 5);
    this.ihc = new Object();
    this.ihk = new Object();
    this.ihm = 33000000;
    this.igZ.start();
    parama = this.igZ;
    p.g(parama, "renderThread");
    this.iha = new MMHandler(parama.getLooper());
    this.ihq = true;
    AppMethodBeat.o(93758);
  }
  
  private final void aMF()
  {
    AppMethodBeat.i(93754);
    this.surfaceTexture = this.ihs.getTexture();
    AppMethodBeat.o(93754);
  }
  
  private void eW(boolean paramBoolean)
  {
    AppMethodBeat.i(93755);
    synchronized (this.ihk)
    {
      this.ihj = paramBoolean;
      Log.i(this.TAG, "setDrawInOnFrameAvailable:".concat(String.valueOf(paramBoolean)));
      x localx = x.SXb;
      AppMethodBeat.o(93755);
      return;
    }
  }
  
  public final void a(final long paramLong, Bitmap paramBitmap1, final Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93744);
    k((kotlin.g.a.a)new f(this, true, paramLong, paramBitmap1, paramBitmap2));
    AppMethodBeat.o(93744);
  }
  
  public final void a(final Surface paramSurface, boolean paramBoolean, final int paramInt1, final int paramInt2, long paramLong, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(218750);
    this.surface = paramSurface;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYz, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      eW(bool);
      Log.i(this.TAG, hashCode() + " initForRemuxer, surface:" + paramSurface + ", callback:false, drawInOnFrameAvailable:" + this.ihj);
      if (WeChatEnvironment.hasDebugger())
      {
        Log.i(this.TAG, "in debug environment, set drawInOnFrameAvailable to true");
        eW(true);
      }
      if (!paramBoolean)
      {
        Log.i(this.TAG, "cannot use drawInFrameAvailable!");
        eW(false);
      }
      this.ihn = 0;
      this.iho = paramLong;
      k((kotlin.g.a.a)new b(this, paramSurface, paramInt1, paramInt2, paramb));
      AppMethodBeat.o(218750);
      return;
    }
  }
  
  public final void a(final byte[] paramArrayOfByte, final long paramLong, kotlin.g.a.b<? super byte[], x> paramb)
  {
    AppMethodBeat.i(93746);
    p.h(paramArrayOfByte, "data");
    p.h(paramb, "inputCallback");
    Log.d(this.TAG, "ByteArray length : " + paramArrayOfByte.length);
    k((kotlin.g.a.a)new g(this, paramArrayOfByte, paramLong, paramb));
    AppMethodBeat.o(93746);
  }
  
  public final Surface aME()
  {
    AppMethodBeat.i(93748);
    if (this.surfaceTexture == null) {
      aMF();
    }
    Surface localSurface = new Surface(this.surfaceTexture);
    AppMethodBeat.o(93748);
    return localSurface;
  }
  
  public final void cX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93749);
    this.ihs.cY(paramInt1, paramInt2);
    AppMethodBeat.o(93749);
  }
  
  public final void cZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93750);
    this.ihs.cZ(paramInt1, paramInt2);
    AppMethodBeat.o(93750);
  }
  
  public final void e(MediaFormat paramMediaFormat)
  {
    int j = 0;
    AppMethodBeat.i(93751);
    p.h(paramMediaFormat, "mediaFormat");
    Object localObject1 = this.ihs;
    p.h(paramMediaFormat, "format");
    Object localObject2;
    int m;
    int k;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZd, true))
    {
      if ((paramMediaFormat.containsKey("width")) && (paramMediaFormat.containsKey("height")))
      {
        ((com.tencent.mm.media.j.a)localObject1).hDn = paramMediaFormat.getInteger("width");
        ((com.tencent.mm.media.j.a)localObject1).hDo = paramMediaFormat.getInteger("height");
        localObject2 = ((com.tencent.mm.media.j.a)localObject1).ijo;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.a)localObject2).cZ(((com.tencent.mm.media.j.a)localObject1).hDn, ((com.tencent.mm.media.j.a)localObject1).hDo);
        }
      }
      m = ((com.tencent.mm.media.j.a)localObject1).hDo;
      k = ((com.tencent.mm.media.j.a)localObject1).hDn;
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
      Log.i("MicroMsg.Media.AbsSurfaceRenderer", "updateTextureSizeByMediaFormat:textureWidth->" + ((com.tencent.mm.media.j.a)localObject1).hDn + " textureHeight->" + ((com.tencent.mm.media.j.a)localObject1).hDo + " validLeft->" + i + " validTop->" + m + " validRight->" + k + "  validBottom -> " + j);
      paramMediaFormat = ((com.tencent.mm.media.j.a)localObject1).ijo;
      if (paramMediaFormat != null)
      {
        localObject1 = new Point(i, m + 1);
        localObject2 = new Point(k + 1, j);
        p.h(localObject1, "leftTop");
        p.h(localObject2, "rightBottom");
        paramMediaFormat.ijS = ((Point)localObject1);
        paramMediaFormat.ijT = ((Point)localObject2);
        AppMethodBeat.o(93751);
        return;
      }
      AppMethodBeat.o(93751);
      return;
    }
  }
  
  public final void i(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93742);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      Log.i(str, i);
      this.ihf = paramb;
      AppMethodBeat.o(93742);
      return;
    }
  }
  
  public final void j(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93743);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("setDrawBlurBgBitmapProvider:");
    if (paramb != null) {}
    for (int i = paramb.hashCode();; i = 0)
    {
      Log.i(str, i);
      this.ihh = paramb;
      AppMethodBeat.o(93743);
      return;
    }
  }
  
  public final void k(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(93753);
    HandlerThread localHandlerThread = this.igZ;
    p.g(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.isReleased))
    {
      this.iha.post((Runnable)new b(parama));
      AppMethodBeat.o(93753);
      return;
    }
    Log.e(this.TAG, hashCode() + " queue already release");
    AppMethodBeat.o(93753);
  }
  
  public final void qx(int paramInt)
  {
    AppMethodBeat.i(93752);
    this.ihs.qx(paramInt);
    AppMethodBeat.o(93752);
  }
  
  public final void release()
  {
    AppMethodBeat.i(93756);
    Log.i(this.TAG, hashCode() + " release resources");
    kotlin.g.a.a locala = (kotlin.g.a.a)new e(this);
    HandlerThread localHandlerThread = this.igZ;
    p.g(localHandlerThread, "renderThread");
    if ((localHandlerThread.isAlive()) && (!this.isReleased))
    {
      this.iha.removeCallbacksAndMessages(null);
      this.iha.post((Runnable)new b(locala));
    }
    for (;;)
    {
      this.isReleased = true;
      AppMethodBeat.o(93756);
      return;
      Log.e(this.TAG, hashCode() + " queueFirst already release");
    }
  }
  
  protected final void setPresentationTime(long paramLong)
  {
    AppMethodBeat.i(93757);
    Object localObject = this.hDs;
    if (localObject != null) {
      EGLExt.eglPresentationTimeANDROID(((c.b)localObject).ilu, ((c.b)localObject).eglSurface, paramLong);
    }
    this.ihp = paramLong;
    localObject = c.ilt;
    c.a.Hq("eglPresentationTimeANDROID");
    AppMethodBeat.o(93757);
  }
  
  public final void x(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(93747);
    k((kotlin.g.a.a)new h(this, paramInt, paramLong));
    AppMethodBeat.o(93747);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(a parama, Surface paramSurface, int paramInt1, int paramInt2, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public c(a parama, EGLContext paramEGLContext, int paramInt1, int paramInt2, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    public d(a parama, EGLContext paramEGLContext, Surface paramSurface, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(a parama, boolean paramBoolean, long paramLong, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(a parama, byte[] paramArrayOfByte, long paramLong, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(a parama, int paramInt, long paramLong)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    public i(a parama, SurfaceTexture paramSurfaceTexture)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
  static final class k
    implements SurfaceTexture.OnFrameAvailableListener
  {
    k(a parama) {}
    
    public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(93740);
      Object localObject1 = a.b(this.ihu);
      Object localObject2 = new StringBuilder("onFrameAvailable, thread:").append(Thread.currentThread()).append(", surface timestamp:");
      paramSurfaceTexture = a.f(this.ihu);
      if (paramSurfaceTexture != null)
      {
        paramSurfaceTexture = Long.valueOf(paramSurfaceTexture.getTimestamp());
        Log.i((String)localObject1, paramSurfaceTexture + ", drawInOnFrameAvailable:" + a.g(this.ihu));
        localObject1 = a.f(this.ihu);
        if (localObject1 == null) {
          break label428;
        }
        if (((SurfaceTexture)localObject1).getTimestamp() > 0L) {
          break label216;
        }
        paramSurfaceTexture = this.ihu;
        a.a(paramSurfaceTexture, a.i(paramSurfaceTexture) + 1);
      }
      for (;;)
      {
        if ((a.d(this.ihu)) && (((SurfaceTexture)localObject1).getTimestamp() <= 0L))
        {
          Log.i(a.b(this.ihu), "first frame available and new timestamp still zero!!");
          if (a.i(this.ihu) < 3) {
            break label245;
          }
          Log.i(a.b(this.ihu), "continue 3 frames pts is zero!!!");
          a.h(this.ihu);
          paramSurfaceTexture = a.j(this.ihu);
          if (paramSurfaceTexture != null)
          {
            paramSurfaceTexture.invoke();
            AppMethodBeat.o(93740);
            return;
            paramSurfaceTexture = null;
            break;
            label216:
            a.a(this.ihu, 0);
            continue;
          }
          AppMethodBeat.o(93740);
          return;
        }
      }
      a.a(this.ihu, ((SurfaceTexture)localObject1).getTimestamp());
      label245:
      if (!a.d(this.ihu)) {
        a.e(this.ihu);
      }
      long l;
      if (a.g(this.ihu))
      {
        if (a.l(this.ihu) == null) {
          break label328;
        }
        localObject2 = this.ihu;
        l = a.k(this.ihu);
        paramSurfaceTexture = a.l(this.ihu);
        localObject1 = a.m(this.ihu);
      }
      for (;;)
      {
        a.a((a)localObject2, l, paramSurfaceTexture, (Bitmap)localObject1);
        AppMethodBeat.o(93740);
        return;
        label328:
        localObject2 = this.ihu;
        l = a.k(this.ihu);
        paramSurfaceTexture = a.n(this.ihu);
        if (paramSurfaceTexture != null) {}
        for (paramSurfaceTexture = (Bitmap)paramSurfaceTexture.invoke(Long.valueOf(((SurfaceTexture)localObject1).getTimestamp() / 1000L));; paramSurfaceTexture = null)
        {
          kotlin.g.a.b localb = a.o(this.ihu);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.i.a
 * JD-Core Version:    0.7.0.1
 */