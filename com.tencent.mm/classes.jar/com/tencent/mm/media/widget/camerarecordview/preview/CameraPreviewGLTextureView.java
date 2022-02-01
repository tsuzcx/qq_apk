package com.tencent.mm.media.widget.camerarecordview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.media.widget.camerarecordview.preview.a.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLTextureView
  extends ObservableTextureView
  implements TextureView.SurfaceTextureListener, e
{
  public static final CameraPreviewGLTextureView.a gBN;
  private SurfaceTexture gAZ;
  private d.g.a.b<? super SurfaceTexture, y> gBB;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gBC;
  private boolean gBE;
  private c.b gBJ;
  private ArrayList<d.g.a.a<y>> gBK;
  private com.tencent.mm.media.i.a gsB;
  private HandlerThread gsj;
  private ap gsk;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94356);
    gBN = new CameraPreviewGLTextureView.a((byte)0);
    AppMethodBeat.o(94356);
  }
  
  public CameraPreviewGLTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94355);
    this.gBK = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    aoc();
    AppMethodBeat.o(94355);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94354);
    this.gBK = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    aoc();
    AppMethodBeat.o(94354);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94353);
    this.gBK = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    aoc();
    AppMethodBeat.o(94353);
  }
  
  private final void aoc()
  {
    AppMethodBeat.i(94352);
    HandlerThread localHandlerThread = com.tencent.e.c.d.gu("CameraPreviewTextureView_renderThread", -2);
    localHandlerThread.start();
    this.gsk = new ap(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.gBK);
    this.gBK.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      j((d.g.a.a)((Iterator)localObject).next());
    }
    this.gsj = localHandlerThread;
    AppMethodBeat.o(94352);
  }
  
  public final void a(com.tencent.mm.media.i.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94347);
    k.h(parama, "renderer");
    ad.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new c((f)this))
    {
      this.gBC = locala;
      locala = this.gBC;
      if (locala != null) {
        locala.b(parama);
      }
      this.gsB = parama;
      AppMethodBeat.o(94347);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94339);
    k.h(paramb, "cameraConfig");
    ad.i("MicroMsg.CameraPreviewGLTextureView", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94339);
      return;
    }
    AppMethodBeat.o(94339);
  }
  
  public final void anS()
  {
    AppMethodBeat.i(94345);
    ad.m("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
    this.gBB = null;
    AppMethodBeat.o(94345);
  }
  
  public final void anT()
  {
    AppMethodBeat.i(94351);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.anT();
      AppMethodBeat.o(94351);
      return;
    }
    AppMethodBeat.o(94351);
  }
  
  public EGLContext getEGLContext()
  {
    c.b localb = this.gBJ;
    if (localb != null) {
      return localb.gwo;
    }
    return null;
  }
  
  public g getFrameDataCallback()
  {
    AppMethodBeat.i(94350);
    Object localObject = this.gBC;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(94350);
      return localObject;
    }
    AppMethodBeat.o(94350);
    return null;
  }
  
  public com.tencent.mm.media.f.d getPreviewTexture()
  {
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null) {
      return locala.guz;
    }
    return null;
  }
  
  protected final com.tencent.mm.media.i.a getRenderer()
  {
    return this.gsB;
  }
  
  public final void j(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(94349);
    k.h(parama, "r");
    if (this.gsk != null)
    {
      ap localap = this.gsk;
      if (localap != null)
      {
        localap.post((Runnable)new d(parama));
        AppMethodBeat.o(94349);
        return;
      }
      AppMethodBeat.o(94349);
      return;
    }
    this.gBK.add(parama);
    AppMethodBeat.o(94349);
  }
  
  public final void m(d.g.a.b<? super SurfaceTexture, y> paramb)
  {
    AppMethodBeat.i(94344);
    ad.m("MicroMsg.CameraPreviewGLTextureView", "tryCameraPreview canPreview:" + this.gBE, new Object[0]);
    if (this.gBE)
    {
      if (paramb != null)
      {
        Object localObject = this.gBC;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture();; localObject = null)
        {
          paramb.aA(localObject);
          AppMethodBeat.o(94344);
          return;
        }
      }
      AppMethodBeat.o(94344);
      return;
    }
    this.gBB = paramb;
    AppMethodBeat.o(94344);
  }
  
  public void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94343);
    ad.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.gsk);
    if (this.gsk == null) {
      aoc();
    }
    if (paramSurfaceTexture != null)
    {
      j((d.g.a.a)new b(paramSurfaceTexture, this, paramInt1, paramInt2, paramSurfaceTexture));
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
    this.gBE = false;
    j((d.g.a.a)new c(this));
    AppMethodBeat.o(94341);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94340);
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    ad.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    j((d.g.a.a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(94340);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94342);
    Object localObject = this.gsB;
    if (localObject != null) {
      com.tencent.mm.media.i.a.a((com.tencent.mm.media.i.a)localObject);
    }
    this.gsB = null;
    setSurfaceTextureListener(null);
    localObject = this.gBC;
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
    j((d.g.a.a)new e(this));
    AppMethodBeat.o(94348);
  }
  
  public void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.f.d, y> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      locala.gBQ = paramb;
    }
  }
  
  protected final void setRenderer(com.tencent.mm.media.i.a parama)
  {
    this.gsB = parama;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$onSurfaceTextureAvailable$1$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(SurfaceTexture paramSurfaceTexture1, CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView
 * JD-Core Version:    0.7.0.1
 */