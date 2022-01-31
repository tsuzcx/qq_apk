package com.tencent.mm.media.widget.camerarecordview.preview;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.b;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTextureId", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLTextureView
  extends ObservableTextureView
  implements TextureView.SurfaceTextureListener, c
{
  public static final CameraPreviewGLTextureView.a fbK;
  private Surface axw;
  private HandlerThread eVQ;
  private ak eVR;
  private com.tencent.mm.media.h.a eWh;
  private boolean fbA;
  private b.b fbF;
  private SurfaceTexture fbG;
  private int fbH;
  private int fbI;
  private ArrayList<a.f.a.a<y>> fbJ;
  private a.f.a.b<? super SurfaceTexture, y> fbx;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a fby;
  
  static
  {
    AppMethodBeat.i(13304);
    fbK = new CameraPreviewGLTextureView.a((byte)0);
    AppMethodBeat.o(13304);
  }
  
  public CameraPreviewGLTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(13303);
    this.fbJ = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    Xm();
    AppMethodBeat.o(13303);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13302);
    this.fbJ = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    Xm();
    AppMethodBeat.o(13302);
  }
  
  public CameraPreviewGLTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(13301);
    this.fbJ = new ArrayList();
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    Xm();
    AppMethodBeat.o(13301);
  }
  
  private final void Xm()
  {
    AppMethodBeat.i(13300);
    HandlerThread localHandlerThread = com.tencent.mm.sdk.g.d.ey("CameraPreviewTextureView_renderThread", -2);
    localHandlerThread.start();
    this.eVR = new ak(localHandlerThread.getLooper());
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.fbJ);
    this.fbJ.clear();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      e((a.f.a.a)((Iterator)localObject).next());
    }
    this.eVQ = localHandlerThread;
    AppMethodBeat.o(13300);
  }
  
  public final void Xk()
  {
    AppMethodBeat.i(13294);
    ab.b("MicroMsg.CameraPreviewGLTextureView", "tryStopCameraPreview", new Object[0]);
    this.fbx = null;
    AppMethodBeat.o(13294);
  }
  
  public final void Xl()
  {
    AppMethodBeat.i(13299);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null)
    {
      locala.Xl();
      AppMethodBeat.o(13299);
      return;
    }
    AppMethodBeat.o(13299);
  }
  
  public final void a(com.tencent.mm.media.h.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(13295);
    j.q(parama, "renderer");
    ab.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((c)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((d)this))
    {
      this.fby = locala;
      locala = this.fby;
      if (locala != null) {
        locala.b(parama);
      }
      this.eWh = parama;
      AppMethodBeat.o(13295);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(13288);
    j.q(paramb, "cameraConfig");
    ab.i("MicroMsg.CameraPreviewGLTextureView", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(13288);
      return;
    }
    AppMethodBeat.o(13288);
  }
  
  public final void e(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(13297);
    j.q(parama, "r");
    if (this.eVR != null)
    {
      ak localak = this.eVR;
      if (localak != null)
      {
        localak.post((Runnable)new b(parama));
        AppMethodBeat.o(13297);
        return;
      }
      AppMethodBeat.o(13297);
      return;
    }
    this.fbJ.add(parama);
    AppMethodBeat.o(13297);
  }
  
  public final void e(a.f.a.b<? super SurfaceTexture, y> paramb)
  {
    AppMethodBeat.i(13293);
    ab.b("MicroMsg.CameraPreviewGLTextureView", "tryCameraPreview canPreview:" + this.fbA, new Object[0]);
    if (this.fbA)
    {
      Object localObject = this.fby;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture();; localObject = null)
      {
        paramb.S(localObject);
        AppMethodBeat.o(13293);
        return;
      }
    }
    this.fbx = paramb;
    AppMethodBeat.o(13293);
  }
  
  public EGLContext getEGLContext()
  {
    b.b localb = this.fbF;
    if (localb != null) {
      return localb.eZz;
    }
    return null;
  }
  
  public f getFrameDataCallback()
  {
    AppMethodBeat.i(13298);
    Object localObject = this.fby;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(13298);
      return localObject;
    }
    AppMethodBeat.o(13298);
    return null;
  }
  
  public int getPreviewTextureId()
  {
    com.tencent.mm.media.h.a locala = this.eWh;
    if (locala != null) {
      return locala.eYa;
    }
    return -1;
  }
  
  protected final com.tencent.mm.media.h.a getRenderer()
  {
    return this.eWh;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13292);
    ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.eVR);
    if (this.eVR == null) {
      Xm();
    }
    if (paramSurfaceTexture != null)
    {
      e((a.f.a.a)new CameraPreviewGLTextureView.b(paramSurfaceTexture, this, paramInt1, paramInt2, paramSurfaceTexture));
      AppMethodBeat.o(13292);
      return;
    }
    AppMethodBeat.o(13292);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(13290);
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    this.fbA = false;
    e((a.f.a.a)new CameraPreviewGLTextureView.c(this));
    AppMethodBeat.o(13290);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13289);
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    ab.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    e((a.f.a.a)new CameraPreviewGLTextureView.d(this, paramInt1, paramInt2));
    AppMethodBeat.o(13289);
  }
  
  public final void release()
  {
    AppMethodBeat.i(13291);
    setSurfaceTextureListener(null);
    AppMethodBeat.o(13291);
  }
  
  public void requestRender()
  {
    AppMethodBeat.i(13296);
    e((a.f.a.a)new CameraPreviewGLTextureView.e(this));
    AppMethodBeat.o(13296);
  }
  
  public void setOnDrawListener(a.f.a.b<? super Integer, y> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null) {
      locala.fbN = paramb;
    }
  }
  
  protected final void setRenderer(com.tencent.mm.media.h.a parama)
  {
    this.eWh = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView
 * JD-Core Version:    0.7.0.1
 */