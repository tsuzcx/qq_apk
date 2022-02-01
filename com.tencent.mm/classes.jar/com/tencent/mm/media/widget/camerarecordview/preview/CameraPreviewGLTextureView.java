package com.tencent.mm.media.widget.camerarecordview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.a.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLTextureView
  extends ObservableTextureView
  implements TextureView.SurfaceTextureListener, e
{
  public static final CameraPreviewGLTextureView.a hus;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gKP;
  private HandlerThread hkS;
  private ap hkT;
  private com.tencent.mm.media.j.a hlj;
  private SurfaceTexture htD;
  private d.g.a.b<? super SurfaceTexture, z> hug;
  private boolean hui;
  private c.b huo;
  private ArrayList<d.g.a.a<z>> hup;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94356);
    hus = new CameraPreviewGLTextureView.a((byte)0);
    AppMethodBeat.o(94356);
  }
  
  public CameraPreviewGLTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94355);
    this.hup = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    axG();
    AppMethodBeat.o(94355);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94354);
    this.hup = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    axG();
    AppMethodBeat.o(94354);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94353);
    this.hup = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    axG();
    AppMethodBeat.o(94353);
  }
  
  private final void axG()
  {
    AppMethodBeat.i(94352);
    HandlerThread localHandlerThread = com.tencent.e.c.d.gW("CameraPreviewTextureView_renderThread", -2);
    localHandlerThread.start();
    this.hkT = new ap(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.hup);
    this.hup.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      h((d.g.a.a)((Iterator)localObject).next());
    }
    this.hkS = localHandlerThread;
    AppMethodBeat.o(94352);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94347);
    p.h(parama, "renderer");
    ad.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new c((f)this))
    {
      this.gKP = locala;
      locala = this.gKP;
      if (locala != null) {
        locala.b(parama);
      }
      this.hlj = parama;
      AppMethodBeat.o(94347);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94339);
    p.h(paramb, "cameraConfig");
    ad.i("MicroMsg.CameraPreviewGLTextureView", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94339);
      return;
    }
    AppMethodBeat.o(94339);
  }
  
  public final void amm()
  {
    AppMethodBeat.i(94345);
    ad.m("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
    this.hug = null;
    AppMethodBeat.o(94345);
  }
  
  public final void amn()
  {
    AppMethodBeat.i(94351);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null)
    {
      locala.amn();
      AppMethodBeat.o(94351);
      return;
    }
    AppMethodBeat.o(94351);
  }
  
  public final void d(d.g.a.b<? super SurfaceTexture, z> paramb)
  {
    AppMethodBeat.i(94344);
    ad.m("MicroMsg.CameraPreviewGLTextureView", "tryCameraPreview canPreview:" + this.hui, new Object[0]);
    if (this.hui)
    {
      if (paramb != null)
      {
        Object localObject = this.gKP;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture();; localObject = null)
        {
          paramb.invoke(localObject);
          AppMethodBeat.o(94344);
          return;
        }
      }
      AppMethodBeat.o(94344);
      return;
    }
    this.hug = paramb;
    AppMethodBeat.o(94344);
  }
  
  public EGLContext getEGLContext()
  {
    c.b localb = this.huo;
    if (localb != null) {
      return localb.hoR;
    }
    return null;
  }
  
  public g getFrameDataCallback()
  {
    AppMethodBeat.i(94350);
    Object localObject = this.gKP;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(94350);
      return localObject;
    }
    AppMethodBeat.o(94350);
    return null;
  }
  
  public com.tencent.mm.media.g.d getPreviewTexture()
  {
    com.tencent.mm.media.j.a locala = this.hlj;
    if (locala != null) {
      return locala.hnh;
    }
    return null;
  }
  
  protected final com.tencent.mm.media.j.a getRenderer()
  {
    return this.hlj;
  }
  
  public final void h(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(94349);
    p.h(parama, "r");
    if (this.hkT != null)
    {
      ap localap = this.hkT;
      if (localap != null)
      {
        localap.post((Runnable)new d(parama));
        AppMethodBeat.o(94349);
        return;
      }
      AppMethodBeat.o(94349);
      return;
    }
    this.hup.add(parama);
    AppMethodBeat.o(94349);
  }
  
  public void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94343);
    ad.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.hkT);
    if (this.hkT == null) {
      axG();
    }
    if (paramSurfaceTexture != null)
    {
      h((d.g.a.a)new b(paramSurfaceTexture, this, paramInt1, paramInt2, paramSurfaceTexture));
      AppMethodBeat.o(94343);
      return;
    }
    AppMethodBeat.o(94343);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(94341);
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    ad.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    this.hui = false;
    h((d.g.a.a)new c(this));
    AppMethodBeat.o(94341);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94340);
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    ad.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    h((d.g.a.a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(94340);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94342);
    Object localObject = this.hlj;
    if (localObject != null) {
      com.tencent.mm.media.j.a.a((com.tencent.mm.media.j.a)localObject);
    }
    this.hlj = null;
    setSurfaceTextureListener(null);
    localObject = this.gKP;
    if (localObject != null)
    {
      ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).release();
      AppMethodBeat.o(94342);
      return;
    }
    AppMethodBeat.o(94342);
  }
  
  public void requestRender()
  {
    AppMethodBeat.i(94348);
    h((d.g.a.a)new e(this));
    AppMethodBeat.o(94348);
  }
  
  public void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.g.d, z> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gKP;
    if (locala != null) {
      locala.huw = paramb;
    }
  }
  
  protected final void setRenderer(com.tencent.mm.media.j.a parama)
  {
    this.hlj = parama;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$onSurfaceTextureAvailable$1$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(SurfaceTexture paramSurfaceTexture1, CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView
 * JD-Core Version:    0.7.0.1
 */