package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ISurfaceListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "()V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceAvailable", "surfaceEx", "width", "height", "onSurfaceDestroyed", "p0", "onSurfaceSizeChanged", "onSurfaceUpdated", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  public static final a.a nKs;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a mVj;
  com.tencent.mm.media.j.a nBj;
  public MMHandler nBk;
  private c.b nFD;
  private kotlin.g.a.b<? super SurfaceTexture, ah> nKm;
  public boolean nKo;
  private ArrayList<kotlin.g.a.a<ah>> nKt;
  private HandlerThread nty;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94332);
    nKs = new a.a((byte)0);
    AppMethodBeat.o(94332);
  }
  
  public a()
  {
    AppMethodBeat.i(94331);
    this.nKt = new ArrayList();
    buk();
    AppMethodBeat.o(94331);
  }
  
  private static final void I(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(237709);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(237709);
  }
  
  public final void H(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(94327);
    s.u(parama, "r");
    if (this.nBk != null)
    {
      MMHandler localMMHandler = this.nBk;
      if (localMMHandler != null) {
        localMMHandler.post(new a..ExternalSyntheticLambda0(parama));
      }
      AppMethodBeat.o(94327);
      return;
    }
    this.nKt.add(parama);
    AppMethodBeat.o(94327);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94325);
    s.u(parama, "renderer");
    Log.i("MicroMsg.CameraPreviewGLTextureRender", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      com.tencent.mm.media.widget.camerarecordview.preview.a.a.a(locala, false, false, 3);
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((b)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((c)this))
    {
      this.mVj = locala;
      locala = this.mVj;
      if (locala != null) {
        locala.b(parama);
      }
      this.nBj = parama;
      AppMethodBeat.o(94325);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94317);
    s.u(paramb, "cameraConfig");
    Log.i("MicroMsg.CameraPreviewGLTextureRender", s.X("updateCameraConfig: ", paramb));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.a(paramb);
    }
    AppMethodBeat.o(94317);
  }
  
  public final void bgw()
  {
    AppMethodBeat.i(94323);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", "tryStopCameraPreview", new Object[0]);
    this.nKm = null;
    AppMethodBeat.o(94323);
  }
  
  public final void bgx()
  {
    AppMethodBeat.i(94329);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.bgx();
    }
    AppMethodBeat.o(94329);
  }
  
  public final void buk()
  {
    AppMethodBeat.i(94330);
    HandlerThread localHandlerThread = com.tencent.threadpool.c.d.jy("CameraPreviewTextureView_renderThread", -2);
    localHandlerThread.start();
    this.nBk = new MMHandler(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.nKt);
    this.nKt.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      H((kotlin.g.a.a)((Iterator)localObject).next());
    }
    localObject = ah.aiuX;
    this.nty = localHandlerThread;
    AppMethodBeat.o(94330);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.nFD;
    if (localb == null) {
      return null;
    }
    return localb.eXL;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(94328);
    Object localObject = this.mVj;
    if (localObject == null)
    {
      AppMethodBeat.o(94328);
      return null;
    }
    localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
    AppMethodBeat.o(94328);
    return localObject;
  }
  
  public final com.tencent.mm.media.g.d getPreviewTexture()
  {
    AppMethodBeat.i(237741);
    Object localObject = this.nBj;
    if (localObject == null)
    {
      AppMethodBeat.o(237741);
      return null;
    }
    localObject = ((com.tencent.mm.media.j.a)localObject).bpP();
    AppMethodBeat.o(237741);
    return localObject;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94320);
    H((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(94320);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(94326);
    H((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(94326);
  }
  
  public final void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, ah> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.nKB = paramb;
    }
  }
  
  public final void t(kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    AppMethodBeat.i(94322);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", s.X("tryCameraPreview canPreview:", Boolean.valueOf(this.nKo)), new Object[0]);
    if (this.nKo)
    {
      if (paramb != null)
      {
        localObject = this.mVj;
        if (localObject != null) {
          break label65;
        }
      }
      label65:
      for (Object localObject = null;; localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture())
      {
        paramb.invoke(localObject);
        AppMethodBeat.o(94322);
        return;
      }
    }
    this.nKm = paramb;
    AppMethodBeat.o(94322);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(a parama, int paramInt1, int paramInt2, Surface paramSurface)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    public d(a parama, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a
 * JD-Core Version:    0.7.0.1
 */