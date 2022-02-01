package com.tencent.mm.media.widget.camerarecordview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class CameraPreviewGLTextureView
  extends ObservableTextureView
  implements TextureView.SurfaceTextureListener, b
{
  public static final CameraPreviewGLTextureView.a nKw;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a mVj;
  private com.tencent.mm.media.j.a nBj;
  private MMHandler nBk;
  private c.b nFD;
  private kotlin.g.a.b<? super SurfaceTexture, ah> nKm;
  private boolean nKo;
  private ArrayList<kotlin.g.a.a<ah>> nKt;
  private HandlerThread nty;
  private SurfaceTexture nwH;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94356);
    nKw = new CameraPreviewGLTextureView.a((byte)0);
    AppMethodBeat.o(94356);
  }
  
  public CameraPreviewGLTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94355);
    this.nKt = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    buk();
    AppMethodBeat.o(94355);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94354);
    this.nKt = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    buk();
    AppMethodBeat.o(94354);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94353);
    this.nKt = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    buk();
    AppMethodBeat.o(94353);
  }
  
  private static final void I(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(237731);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(237731);
  }
  
  private final void buk()
  {
    AppMethodBeat.i(94352);
    HandlerThread localHandlerThread = com.tencent.threadpool.c.d.jv("CameraPreviewTextureView_renderThread", -2);
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
    AppMethodBeat.o(94352);
  }
  
  public final void H(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(94349);
    s.u(parama, "r");
    if (this.nBk != null)
    {
      MMHandler localMMHandler = this.nBk;
      if (localMMHandler != null) {
        localMMHandler.post(new CameraPreviewGLTextureView..ExternalSyntheticLambda0(parama));
      }
      AppMethodBeat.o(94349);
      return;
    }
    this.nKt.add(parama);
    AppMethodBeat.o(94349);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94347);
    s.u(parama, "renderer");
    Log.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
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
      AppMethodBeat.o(94347);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94339);
    s.u(paramb, "cameraConfig");
    Log.i("MicroMsg.CameraPreviewGLTextureView", s.X("updateCameraConfig: ", paramb));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.a(paramb);
    }
    AppMethodBeat.o(94339);
  }
  
  public final void bgw()
  {
    AppMethodBeat.i(94345);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
    this.nKm = null;
    AppMethodBeat.o(94345);
  }
  
  public final void bgx()
  {
    AppMethodBeat.i(94351);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.bgx();
    }
    AppMethodBeat.o(94351);
  }
  
  public EGLContext getEGLContext()
  {
    c.b localb = this.nFD;
    if (localb == null) {
      return null;
    }
    return localb.eXL;
  }
  
  public g getFrameDataCallback()
  {
    AppMethodBeat.i(94350);
    Object localObject = this.mVj;
    if (localObject == null)
    {
      AppMethodBeat.o(94350);
      return null;
    }
    localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
    AppMethodBeat.o(94350);
    return localObject;
  }
  
  public com.tencent.mm.media.g.d getPreviewTexture()
  {
    AppMethodBeat.i(237789);
    Object localObject = this.nBj;
    if (localObject == null)
    {
      AppMethodBeat.o(237789);
      return null;
    }
    localObject = ((com.tencent.mm.media.j.a)localObject).bpP();
    AppMethodBeat.o(237789);
    return localObject;
  }
  
  protected final com.tencent.mm.media.j.a getRenderer()
  {
    return this.nBj;
  }
  
  public void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94343);
    s.u(paramSurfaceTexture, "surfaceTexture");
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.nBk);
    if (this.nBk == null) {
      buk();
    }
    H((kotlin.g.a.a)new b(this, paramSurfaceTexture, paramInt1, paramInt2, paramSurfaceTexture));
    AppMethodBeat.o(94343);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(94341);
    s.u(paramSurfaceTexture, "p0");
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    this.nKo = false;
    H((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(94341);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94340);
    s.u(paramSurfaceTexture, "surfaceTexture");
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    H((kotlin.g.a.a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(94340);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94342);
    Object localObject = this.nBj;
    if (localObject != null) {
      com.tencent.mm.media.j.a.a((com.tencent.mm.media.j.a)localObject);
    }
    this.nBj = null;
    setSurfaceTextureListener(null);
    localObject = this.mVj;
    if (localObject != null) {
      com.tencent.mm.media.widget.camerarecordview.preview.a.a.a((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject, false, false, 3);
    }
    AppMethodBeat.o(94342);
  }
  
  public void requestRender()
  {
    AppMethodBeat.i(94348);
    H((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(94348);
  }
  
  public void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, ah> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.nKB = paramb;
    }
  }
  
  protected final void setRenderer(com.tencent.mm.media.j.a parama)
  {
    this.nBj = parama;
  }
  
  public final void t(kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    AppMethodBeat.i(94344);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureView", s.X("tryCameraPreview canPreview:", Boolean.valueOf(this.nKo)), new Object[0]);
    if (this.nKo)
    {
      if (paramb != null)
      {
        localObject = this.mVj;
        if (localObject != null) {
          break label66;
        }
      }
      label66:
      for (Object localObject = null;; localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture())
      {
        paramb.invoke(localObject);
        AppMethodBeat.o(94344);
        return;
      }
    }
    this.nKm = paramb;
    AppMethodBeat.o(94344);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(CameraPreviewGLTextureView paramCameraPreviewGLTextureView, SurfaceTexture paramSurfaceTexture1, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView
 * JD-Core Version:    0.7.0.1
 */