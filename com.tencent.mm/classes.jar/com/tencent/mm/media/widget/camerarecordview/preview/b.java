package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "()V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public final class b
  implements TextureView.SurfaceTextureListener, e
{
  public static final b.a gBL;
  private SurfaceTexture gAZ;
  private d.g.a.b<? super SurfaceTexture, y> gBB;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gBC;
  private boolean gBE;
  private c.b gBJ;
  private ArrayList<d.g.a.a<y>> gBK;
  com.tencent.mm.media.i.a gsB;
  private HandlerThread gsj;
  private ap gsk;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94332);
    gBL = new b.a((byte)0);
    AppMethodBeat.o(94332);
  }
  
  public b()
  {
    AppMethodBeat.i(94331);
    this.gBK = new ArrayList();
    aoc();
    AppMethodBeat.o(94331);
  }
  
  private final void aoc()
  {
    AppMethodBeat.i(94330);
    HandlerThread localHandlerThread = com.tencent.e.c.d.gx("CameraPreviewTextureView_renderThread", -2);
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
    AppMethodBeat.o(94330);
  }
  
  public final void a(com.tencent.mm.media.i.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94325);
    k.h(parama, "renderer");
    ad.i("MicroMsg.CameraPreviewGLTextureRender", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.gBC = locala;
      locala = this.gBC;
      if (locala != null) {
        locala.b(parama);
      }
      this.gsB = parama;
      AppMethodBeat.o(94325);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94317);
    k.h(paramb, "cameraConfig");
    ad.i("MicroMsg.CameraPreviewGLTextureRender", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94317);
      return;
    }
    AppMethodBeat.o(94317);
  }
  
  public final void anS()
  {
    AppMethodBeat.i(94323);
    ad.m("MicroMsg.CameraPreviewGLTextureRender", "tryStopCameraPreview", new Object[0]);
    this.gBB = null;
    AppMethodBeat.o(94323);
  }
  
  public final void anT()
  {
    AppMethodBeat.i(94329);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.anT();
      AppMethodBeat.o(94329);
      return;
    }
    AppMethodBeat.o(94329);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.gBJ;
    if (localb != null) {
      return localb.gwo;
    }
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(94328);
    Object localObject = this.gBC;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(94328);
      return localObject;
    }
    AppMethodBeat.o(94328);
    return null;
  }
  
  public final com.tencent.mm.media.f.d getPreviewTexture()
  {
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null) {
      return locala.guz;
    }
    return null;
  }
  
  public final void j(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(94327);
    k.h(parama, "r");
    if (this.gsk != null)
    {
      ap localap = this.gsk;
      if (localap != null)
      {
        localap.post((Runnable)new c(parama));
        AppMethodBeat.o(94327);
        return;
      }
      AppMethodBeat.o(94327);
      return;
    }
    this.gBK.add(parama);
    AppMethodBeat.o(94327);
  }
  
  public final void m(d.g.a.b<? super SurfaceTexture, y> paramb)
  {
    AppMethodBeat.i(94322);
    ad.m("MicroMsg.CameraPreviewGLTextureRender", "tryCameraPreview canPreview:" + this.gBE, new Object[0]);
    if (this.gBE)
    {
      if (paramb != null)
      {
        Object localObject = this.gBC;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture();; localObject = null)
        {
          paramb.aA(localObject);
          AppMethodBeat.o(94322);
          return;
        }
      }
      AppMethodBeat.o(94322);
      return;
    }
    this.gBB = paramb;
    AppMethodBeat.o(94322);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94321);
    ad.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.gsk);
    if (this.gsk == null) {
      aoc();
    }
    if (paramSurfaceTexture != null)
    {
      j((d.g.a.a)new b(paramSurfaceTexture, this, paramInt1, paramInt2));
      AppMethodBeat.o(94321);
      return;
    }
    AppMethodBeat.o(94321);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(94319);
    ad.m("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureDestroyed", new Object[0]);
    this.gBE = false;
    j((d.g.a.a)new c(this));
    AppMethodBeat.o(94319);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94318);
    ad.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    j((d.g.a.a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(94318);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void release()
  {
    AppMethodBeat.i(94320);
    j((d.g.a.a)new e(this));
    AppMethodBeat.o(94320);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(94326);
    j((d.g.a.a)new f(this));
    AppMethodBeat.o(94326);
  }
  
  public final void setOnDrawListener(d.g.a.b<? super com.tencent.mm.media.f.d, y> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      locala.gBQ = paramb;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender$onSurfaceTextureAvailable$1$1"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(SurfaceTexture paramSurfaceTexture, b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.b
 * JD-Core Version:    0.7.0.1
 */