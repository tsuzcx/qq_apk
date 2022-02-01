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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLTextureView
  extends ObservableTextureView
  implements TextureView.SurfaceTextureListener, e
{
  public static final CameraPreviewGLTextureView.a hxg;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gNy;
  private HandlerThread hnG;
  private aq hnH;
  private com.tencent.mm.media.j.a hnY;
  private d.g.a.b<? super SurfaceTexture, z> hwU;
  private boolean hwW;
  private SurfaceTexture hwr;
  private c.b hxc;
  private ArrayList<d.g.a.a<z>> hxd;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94356);
    hxg = new CameraPreviewGLTextureView.a((byte)0);
    AppMethodBeat.o(94356);
  }
  
  public CameraPreviewGLTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94355);
    this.hxd = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    axV();
    AppMethodBeat.o(94355);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94354);
    this.hxd = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    axV();
    AppMethodBeat.o(94354);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94353);
    this.hxd = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    axV();
    AppMethodBeat.o(94353);
  }
  
  private final void axV()
  {
    AppMethodBeat.i(94352);
    HandlerThread localHandlerThread = com.tencent.e.c.d.hf("CameraPreviewTextureView_renderThread", -2);
    localHandlerThread.start();
    this.hnH = new aq(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.hxd);
    this.hxd.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      i((d.g.a.a)((Iterator)localObject).next());
    }
    this.hnG = localHandlerThread;
    AppMethodBeat.o(94352);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94347);
    p.h(parama, "renderer");
    ae.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new c((f)this))
    {
      this.gNy = locala;
      locala = this.gNy;
      if (locala != null) {
        locala.b(parama);
      }
      this.hnY = parama;
      AppMethodBeat.o(94347);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94339);
    p.h(paramb, "cameraConfig");
    ae.i("MicroMsg.CameraPreviewGLTextureView", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94339);
      return;
    }
    AppMethodBeat.o(94339);
  }
  
  public final void amB()
  {
    AppMethodBeat.i(94345);
    ae.m("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
    this.hwU = null;
    AppMethodBeat.o(94345);
  }
  
  public final void amC()
  {
    AppMethodBeat.i(94351);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
    if (locala != null)
    {
      locala.amC();
      AppMethodBeat.o(94351);
      return;
    }
    AppMethodBeat.o(94351);
  }
  
  public final void d(d.g.a.b<? super SurfaceTexture, z> paramb)
  {
    AppMethodBeat.i(94344);
    ae.m("MicroMsg.CameraPreviewGLTextureView", "tryCameraPreview canPreview:" + this.hwW, new Object[0]);
    if (this.hwW)
    {
      if (paramb != null)
      {
        Object localObject = this.gNy;
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
    this.hwU = paramb;
    AppMethodBeat.o(94344);
  }
  
  public EGLContext getEGLContext()
  {
    c.b localb = this.hxc;
    if (localb != null) {
      return localb.hrF;
    }
    return null;
  }
  
  public g getFrameDataCallback()
  {
    AppMethodBeat.i(94350);
    Object localObject = this.gNy;
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
    com.tencent.mm.media.j.a locala = this.hnY;
    if (locala != null) {
      return locala.hpV;
    }
    return null;
  }
  
  protected final com.tencent.mm.media.j.a getRenderer()
  {
    return this.hnY;
  }
  
  public final void i(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(94349);
    p.h(parama, "r");
    if (this.hnH != null)
    {
      aq localaq = this.hnH;
      if (localaq != null)
      {
        localaq.post((Runnable)new d(parama));
        AppMethodBeat.o(94349);
        return;
      }
      AppMethodBeat.o(94349);
      return;
    }
    this.hxd.add(parama);
    AppMethodBeat.o(94349);
  }
  
  public void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94343);
    ae.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.hnH);
    if (this.hnH == null) {
      axV();
    }
    if (paramSurfaceTexture != null)
    {
      i((d.g.a.a)new b(paramSurfaceTexture, this, paramInt1, paramInt2, paramSurfaceTexture));
      AppMethodBeat.o(94343);
      return;
    }
    AppMethodBeat.o(94343);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(94341);
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    ae.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    this.hwW = false;
    i((d.g.a.a)new c(this));
    AppMethodBeat.o(94341);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94340);
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    ae.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    i((d.g.a.a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(94340);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94342);
    Object localObject = this.hnY;
    if (localObject != null) {
      com.tencent.mm.media.j.a.a((com.tencent.mm.media.j.a)localObject);
    }
    this.hnY = null;
    setSurfaceTextureListener(null);
    localObject = this.gNy;
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
    i((d.g.a.a)new e(this));
    AppMethodBeat.o(94348);
  }
  
  public void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.g.d, z> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gNy;
    if (locala != null) {
      locala.hxk = paramb;
    }
  }
  
  protected final void setRenderer(com.tencent.mm.media.j.a parama)
  {
    this.hnY = parama;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$onSurfaceTextureAvailable$1$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(SurfaceTexture paramSurfaceTexture1, CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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