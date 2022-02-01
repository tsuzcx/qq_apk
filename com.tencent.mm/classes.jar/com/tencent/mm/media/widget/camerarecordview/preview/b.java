package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "()V", "canPreview", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "renderHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "renderThread", "Landroid/os/HandlerThread;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "runnableArray", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "surface", "Landroid/view/Surface;", "surfaceHeight", "", "surfaceWidth", "texture", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "initHandlerThread", "onSurfaceTextureAvailable", "surfaceTexture", "width", "height", "onSurfaceTextureDestroyed", "p0", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "queueEvent", "r", "quitHandlerThread", "release", "requestRender", "setOnDrawListener", "frameDrawCallback", "Lkotlin/ParameterName;", "name", "setPreviewRenderer", "cpuCrop", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public final class b
  implements TextureView.SurfaceTextureListener, e
{
  public static final b.a iqF;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
  private HandlerThread igZ;
  private MMHandler iha;
  com.tencent.mm.media.j.a ihs;
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
    AppMethodBeat.i(94332);
    iqF = new b.a((byte)0);
    AppMethodBeat.o(94332);
  }
  
  public b()
  {
    AppMethodBeat.i(94331);
    this.iqE = new ArrayList();
    aQt();
    AppMethodBeat.o(94331);
  }
  
  private final void aQt()
  {
    AppMethodBeat.i(94330);
    HandlerThread localHandlerThread = com.tencent.f.c.d.hC("CameraPreviewTextureView_renderThread", -2);
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
    AppMethodBeat.o(94330);
  }
  
  public final void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94325);
    p.h(parama, "renderer");
    Log.i("MicroMsg.CameraPreviewGLTextureRender", "setRenderer:" + parama.hashCode() + "  cpuCrop:" + paramBoolean);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((f)this))
    {
      this.hDt = locala;
      locala = this.hDt;
      if (locala != null) {
        locala.b(parama);
      }
      this.ihs = parama;
      AppMethodBeat.o(94325);
      return;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94317);
    p.h(paramb, "cameraConfig");
    Log.i("MicroMsg.CameraPreviewGLTextureRender", "updateCameraConfig: ".concat(String.valueOf(paramb)));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94317);
      return;
    }
    AppMethodBeat.o(94317);
  }
  
  public final void aEx()
  {
    AppMethodBeat.i(94323);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", "tryStopCameraPreview", new Object[0]);
    this.iqw = null;
    AppMethodBeat.o(94323);
  }
  
  public final void aEy()
  {
    AppMethodBeat.i(94329);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.aEy();
      AppMethodBeat.o(94329);
      return;
    }
    AppMethodBeat.o(94329);
  }
  
  public final void d(kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    AppMethodBeat.i(94322);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", "tryCameraPreview canPreview:" + this.iqy, new Object[0]);
    if (this.iqy)
    {
      if (paramb != null)
      {
        Object localObject = this.hDt;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getSurfaceTexture();; localObject = null)
        {
          paramb.invoke(localObject);
          AppMethodBeat.o(94322);
          return;
        }
      }
      AppMethodBeat.o(94322);
      return;
    }
    this.iqw = paramb;
    AppMethodBeat.o(94322);
  }
  
  public final EGLContext getEGLContext()
  {
    c.b localb = this.ilw;
    if (localb != null) {
      return localb.ilv;
    }
    return null;
  }
  
  public final g getFrameDataCallback()
  {
    AppMethodBeat.i(94328);
    Object localObject = this.hDt;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(94328);
      return localObject;
    }
    AppMethodBeat.o(94328);
    return null;
  }
  
  public final com.tencent.mm.media.g.d getPreviewTexture()
  {
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null) {
      return locala.ijq;
    }
    return null;
  }
  
  public final void j(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(94327);
    p.h(parama, "r");
    if (this.iha != null)
    {
      MMHandler localMMHandler = this.iha;
      if (localMMHandler != null)
      {
        localMMHandler.post((Runnable)new c(parama));
        AppMethodBeat.o(94327);
        return;
      }
      AppMethodBeat.o(94327);
      return;
    }
    this.iqE.add(parama);
    AppMethodBeat.o(94327);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94321);
    Log.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureAvailable, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2 + ", handler: " + this.iha);
    if (this.iha == null) {
      aQt();
    }
    if (paramSurfaceTexture != null)
    {
      j((kotlin.g.a.a)new b(paramSurfaceTexture, this, paramInt1, paramInt2));
      AppMethodBeat.o(94321);
      return;
    }
    AppMethodBeat.o(94321);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(94319);
    Log.printInfoStack("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureDestroyed", new Object[0]);
    this.iqy = false;
    j((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(94319);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(94318);
    Log.i("MicroMsg.CameraPreviewGLTextureRender", "onSurfaceTextureSizeChanged, surfaceTexture:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    j((kotlin.g.a.a)new d(this, paramInt1, paramInt2));
    AppMethodBeat.o(94318);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void release()
  {
    AppMethodBeat.i(94320);
    j((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(94320);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(94326);
    j((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(94326);
  }
  
  public final void setOnDrawListener(kotlin.g.a.b<? super com.tencent.mm.media.g.d, x> paramb)
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null) {
      locala.iqL = paramb;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureRender$onSurfaceTextureAvailable$1$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(SurfaceTexture paramSurfaceTexture, b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.b
 * JD-Core Version:    0.7.0.1
 */