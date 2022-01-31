package com.tencent.mm.media.widget.camerarecordview.preview;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canPreview", "", "frameRotate", "", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTextureId", "queueEvent", "r", "Lkotlin/Function0;", "release", "setOnDrawListener", "frameAvailableListener", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "w", "h", "surfaceCreated", "surfaceDestroyed", "tryCameraPreview", "callback", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public final class CameraPreviewGLSurfaceView
  extends GLSurfaceView
  implements c
{
  public static final CameraPreviewGLSurfaceView.a fbB;
  private boolean fbA;
  private a.f.a.b<? super SurfaceTexture, y> fbx;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a fby;
  private int fbz;
  
  static
  {
    AppMethodBeat.i(13282);
    fbB = new CameraPreviewGLSurfaceView.a((byte)0);
    AppMethodBeat.o(13282);
  }
  
  public CameraPreviewGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(13281);
    getHolder().addCallback((SurfaceHolder.Callback)this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory((GLSurfaceView.EGLContextFactory)new com.tencent.mm.media.h.a.b());
      setEGLContextClientVersion(2);
      setEGLConfigChooser((GLSurfaceView.EGLConfigChooser)new com.tencent.mm.media.h.a.a());
      setPreserveEGLContextOnPause(false);
      setRenderer((GLSurfaceView.Renderer)new CameraPreviewGLSurfaceView.1(this));
      setRenderMode(0);
      ab.b("MicroMsg.CameraPreviewGLSurfaceView", "init create CameraPreviewGLSurfaceView", new Object[0]);
      AppMethodBeat.o(13281);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          getHolder().setType(1);
        }
        catch (Exception paramContext)
        {
          try
          {
            getHolder().setType(0);
          }
          catch (Exception paramContext) {}
        }
      }
    }
  }
  
  public final void Xk()
  {
    AppMethodBeat.i(13275);
    ab.b("MicroMsg.CameraPreviewGLSurfaceView", "tryStopCameraPreview", new Object[0]);
    this.fbx = null;
    AppMethodBeat.o(13275);
  }
  
  public final void Xl()
  {
    AppMethodBeat.i(13278);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null)
    {
      locala.Xl();
      AppMethodBeat.o(13278);
      return;
    }
    AppMethodBeat.o(13278);
  }
  
  public final void a(com.tencent.mm.media.h.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(13272);
    j.q(parama, "renderer");
    ab.b("MicroMsg.CameraPreviewGLSurfaceView", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((c)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((d)this))
    {
      this.fby = locala;
      locala = this.fby;
      if (locala == null) {
        break;
      }
      locala.b(parama);
      AppMethodBeat.o(13272);
      return;
    }
    AppMethodBeat.o(13272);
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(13273);
    j.q(paramb, "cameraConfig");
    ab.b("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(13273);
      return;
    }
    AppMethodBeat.o(13273);
  }
  
  public final void e(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(13280);
    j.q(parama, "r");
    queueEvent((Runnable)new a(parama));
    AppMethodBeat.o(13280);
  }
  
  public final void e(a.f.a.b<? super SurfaceTexture, y> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(13274);
    ab.b("MicroMsg.CameraPreviewGLSurfaceView", "tryCameraPreview  canPreview:" + this.fbA, new Object[0]);
    if (this.fbA)
    {
      Object localObject3 = new StringBuilder("callback.invoke  ");
      Object localObject1 = this.fby;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
      {
        ab.b("MicroMsg.CameraPreviewGLSurfaceView", localObject1, new Object[0]);
        localObject3 = this.fby;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject3).getSurfaceTexture();
        }
        paramb.S(localObject1);
        AppMethodBeat.o(13274);
        return;
      }
    }
    this.fbx = paramb;
    AppMethodBeat.o(13274);
  }
  
  public final EGLContext getEGLContext()
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null) {
      return locala.eZz;
    }
    return null;
  }
  
  public final f getFrameDataCallback()
  {
    AppMethodBeat.i(13279);
    Object localObject = this.fby;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(13279);
      return localObject;
    }
    AppMethodBeat.o(13279);
    return null;
  }
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(152142);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null)
    {
      int i = locala.getTextureId();
      AppMethodBeat.o(152142);
      return i;
    }
    AppMethodBeat.o(152142);
    return -1;
  }
  
  public final void release()
  {
    AppMethodBeat.i(13277);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null) {
      locala.release();
    }
    this.fbA = false;
    AppMethodBeat.o(13277);
  }
  
  public final void setOnDrawListener(a.f.a.b<? super Integer, y> paramb)
  {
    AppMethodBeat.i(13276);
    ab.b("MicroMsg.CameraPreviewGLSurfaceView", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.fby;
    if (locala != null)
    {
      locala.fbN = paramb;
      AppMethodBeat.o(13276);
      return;
    }
    AppMethodBeat.o(13276);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152143);
    StringBuilder localStringBuilder = new StringBuilder("surfaceChanged:");
    if (paramSurfaceHolder != null) {}
    for (Surface localSurface = paramSurfaceHolder.getSurface();; localSurface = null)
    {
      ab.i("MicroMsg.CameraPreviewGLSurfaceView", localSurface + ", format:" + paramInt1 + ", w:" + paramInt2 + ", h:" + paramInt3);
      super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(152143);
      return;
    }
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(152145);
    StringBuilder localStringBuilder = new StringBuilder("surfaceCreated: ");
    if (paramSurfaceHolder != null) {}
    for (Surface localSurface = paramSurfaceHolder.getSurface();; localSurface = null)
    {
      ab.i("MicroMsg.CameraPreviewGLSurfaceView", localSurface);
      super.surfaceCreated(paramSurfaceHolder);
      AppMethodBeat.o(152145);
      return;
    }
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(152144);
    StringBuilder localStringBuilder = new StringBuilder("surfaceDestroyed: ");
    if (paramSurfaceHolder != null) {}
    for (Surface localSurface = paramSurfaceHolder.getSurface();; localSurface = null)
    {
      ab.i("MicroMsg.CameraPreviewGLSurfaceView", localSurface);
      super.surfaceDestroyed(paramSurfaceHolder);
      AppMethodBeat.o(152144);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */