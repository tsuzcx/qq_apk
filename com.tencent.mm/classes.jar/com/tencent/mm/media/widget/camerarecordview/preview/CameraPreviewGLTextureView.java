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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLTextureView
  extends ObservableTextureView
  implements TextureView.SurfaceTextureListener, e
{
  public static final CameraPreviewGLTextureView.a iqH;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
  private HandlerThread igZ;
  private MMHandler iha;
  private com.tencent.mm.media.j.a ihs;
  private c.b ilw;
  private SurfaceTexture ipT;
  private ArrayList<kotlin.g.a.a<x>> iqE;
  private kotlin.g.a.b<? super SurfaceTexture, x> iqw;
  private boolean iqy;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(94356);
    iqH = new CameraPreviewGLTextureView.a((byte)0);
    AppMethodBeat.o(94356);
  }
  
  public CameraPreviewGLTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94355);
    this.iqE = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    aQt();
    AppMethodBeat.o(94355);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94354);
    this.iqE = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    aQt();
    AppMethodBeat.o(94354);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94353);
    this.iqE = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    aQt();
    AppMethodBeat.o(94353);
  }
  
  private final void aQt()
  {
    AppMethodBeat.i(94352);
    HandlerThread localHandlerThread = com.tencent.f.c.d.hz("CameraPreviewTextureView_renderThread", -2);
    localHandlerThread.start();
    this.iha = new MMHandler(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.iqE);
    this.iqE.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      j((kotlin.g.a.a)((Iterator)localObject).next());
    }
    this.igZ = localHandlerThread;
    AppMethodBeat.o(94352);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94347);
    p.h(parama, "renderer");
    Log.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new c((f)this))
    {
      this.hDt = locala;
      locala = this.hDt;
      if (locala != null) {
        locala.b(parama);
      }
      this.ihs = parama;
      AppMethodBeat.o(94347);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94339);
    p.h(paramb, "cameraConfig");
    Log.i("MicroMsg.CameraPreviewGLTextureView", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94339);
      return;
    }
    AppMethodBeat.o(94339);
  }
  
  public final void aEx()
  {
    AppMethodBeat.i(94345);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
    this.iqw = null;
    AppMethodBeat.o(94345);
  }
  
  public final void aEy()
  {
    AppMethodBeat.i(94351);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.aEy();
      AppMethodBeat.o(94351);
      return;
    }
    AppMethodBeat.o(94351);
  }
  
  public final void d(kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    AppMethodBeat.i(94344);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureView", "tryCameraPreview canPreview:" + this.iqy, new Object[0]);
    if (this.iqy)
    {
      if (paramb != null)
      {
        Object localObject = this.hDt;
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
    this.iqw = paramb;
    AppMethodBeat.o(94344);
  }
  
  public EGLContext getEGLContext()
  {
    c.b localb = this.ilw;
    if (localb != null) {
      return localb.ilv;
    }
    return null;
  }
  
  public g getFrameDataCallback()
  {
    AppMethodBeat.i(94350);
    Object localObject = this.hDt;
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
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null) {
      return locala.ijq;
    }
    return null;
  }
  
  protected final com.tencent.mm.media.j.a getRenderer()
  {
    return this.ihs;
  }
  
  public final void j(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(94349);
    p.h(parama, "r");
    if (this.iha != null)
    {
      MMHandler localMMHandler = this.iha;
      if (localMMHandler != null)
      {
        localMMHandler.post((Runnable)new d(parama));
        AppMethodBeat.o(94349);
        return;
      }
      AppMethodBeat.o(94349);
      return;
    }
    this.iqE.add(parama);
    AppMethodBeat.o(94349);
  }
  
  public void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94343);
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.iha);
    if (this.iha == null) {
      aQt();
    }
    if (paramSurfaceTexture != null)
    {
      j((kotlin.g.a.a)new b(paramSurfaceTexture, this, paramInt1, paramInt2, paramSurfaceTexture));
      AppMethodBeat.o(94343);
      return;
    }
    AppMethodBeat.o(94343);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(94341);
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    this.iqy = false;
    j((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(94341);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94340);
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    j((kotlin.g.a.a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(94340);
  }
  
  public final void release()
  {
    AppMethodBeat.i(94342);
    Object localObject = this.ihs;
    if (localObject != null) {
      com.tencent.mm.media.j.a.a((com.tencent.mm.media.j.a)localObject);
    }
    this.ihs = null;
    setSurfaceTextureListener(null);
    localObject = this.hDt;
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
    j((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(94348);
  }
  
  public void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, x> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null) {
      locala.iqL = paramb;
    }
  }
  
  protected final void setRenderer(com.tencent.mm.media.j.a parama)
  {
    this.ihs = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView$onSurfaceTextureAvailable$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(SurfaceTexture paramSurfaceTexture1, CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(CameraPreviewGLTextureView paramCameraPreviewGLTextureView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(CameraPreviewGLTextureView paramCameraPreviewGLTextureView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView
 * JD-Core Version:    0.7.0.1
 */