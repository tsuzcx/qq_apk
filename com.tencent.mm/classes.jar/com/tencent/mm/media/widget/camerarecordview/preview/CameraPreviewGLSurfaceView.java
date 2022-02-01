package com.tencent.mm.media.widget.camerarecordview.preview;

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
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.widget.camerarecordview.preview.a.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.y;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canPreview", "", "frameRotate", "", "ignoreRender", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getEGLSurface", "callback", "Landroid/opengl/EGLSurface;", "Lkotlin/ParameterName;", "name", "eglSurface", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "ignore", "queueEvent", "r", "Lkotlin/Function0;", "release", "setOnDrawListener", "frameAvailableListener", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "w", "h", "surfaceCreated", "surfaceDestroyed", "tryCameraPreview", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLSurfaceView
  extends GLSurfaceView
  implements e
{
  public static final CameraPreviewGLSurfaceView.a gBF;
  private boolean KBR;
  private d.g.a.b<? super SurfaceTexture, y> gBB;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gBC;
  private int gBD;
  private boolean gBE;
  
  static
  {
    AppMethodBeat.i(94310);
    gBF = new CameraPreviewGLSurfaceView.a((byte)0);
    AppMethodBeat.o(94310);
  }
  
  public CameraPreviewGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94309);
    getHolder().addCallback((SurfaceHolder.Callback)this);
    try
    {
      getHolder().setType(2);
      setEGLContextFactory((GLSurfaceView.EGLContextFactory)new com.tencent.mm.media.i.a.b());
      setEGLContextClientVersion(ax.aFC("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3));
      setEGLConfigChooser((GLSurfaceView.EGLConfigChooser)new com.tencent.mm.media.i.a.a());
      setPreserveEGLContextOnPause(false);
      setRenderer((GLSurfaceView.Renderer)new GLSurfaceView.Renderer()
      {
        public final void onDrawFrame(GL10 paramAnonymousGL10)
        {
          AppMethodBeat.i(94292);
          if (!CameraPreviewGLSurfaceView.e(this.gBG))
          {
            com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.gBG);
            if (locala != null)
            {
              locala.onDrawFrame(paramAnonymousGL10);
              AppMethodBeat.o(94292);
              return;
            }
          }
          AppMethodBeat.o(94292);
        }
        
        public final void onSurfaceChanged(final GL10 paramAnonymousGL10, final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(94293);
          ad.m("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceChanged width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2, new Object[0]);
          com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.gBG);
          if (locala != null)
          {
            locala.b(CameraPreviewGLSurfaceView.b(this.gBG), (d.g.a.a)new a(this, paramAnonymousGL10, paramAnonymousInt1, paramAnonymousInt2));
            AppMethodBeat.o(94293);
            return;
          }
          AppMethodBeat.o(94293);
        }
        
        public final void onSurfaceCreated(GL10 paramAnonymousGL10, EGLConfig paramAnonymousEGLConfig)
        {
          AppMethodBeat.i(94294);
          ad.m("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceCreated", new Object[0]);
          com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.gBG);
          if (locala != null)
          {
            locala.onSurfaceCreated(paramAnonymousGL10, paramAnonymousEGLConfig);
            AppMethodBeat.o(94294);
            return;
          }
          AppMethodBeat.o(94294);
        }
        
        @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
        static final class a
          extends d.g.b.l
          implements d.g.a.a<y>
        {
          a(CameraPreviewGLSurfaceView.1 param1, GL10 paramGL10, int paramInt1, int paramInt2)
          {
            super();
          }
        }
      });
      setRenderMode(0);
      ad.m("MicroMsg.CameraPreviewGLSurfaceView", "init create CameraPreviewGLSurfaceView", new Object[0]);
      AppMethodBeat.o(94309);
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
  
  public void a(com.tencent.mm.media.i.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94296);
    k.h(parama, "renderer");
    ad.m("MicroMsg.CameraPreviewGLSurfaceView", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new c((f)this))
    {
      this.gBC = locala;
      locala = this.gBC;
      if (locala == null) {
        break;
      }
      locala.b(parama);
      AppMethodBeat.o(94296);
      return;
    }
    AppMethodBeat.o(94296);
  }
  
  public void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94297);
    k.h(paramb, "cameraConfig");
    ad.m("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94297);
      return;
    }
    AppMethodBeat.o(94297);
  }
  
  public void anS()
  {
    AppMethodBeat.i(94299);
    ad.m("MicroMsg.CameraPreviewGLSurfaceView", "tryStopCameraPreview", new Object[0]);
    this.gBB = null;
    AppMethodBeat.o(94299);
  }
  
  public void anT()
  {
    AppMethodBeat.i(94303);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.anT();
      AppMethodBeat.o(94303);
      return;
    }
    AppMethodBeat.o(94303);
  }
  
  public EGLContext getEGLContext()
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      return locala.gwo;
    }
    return null;
  }
  
  public g getFrameDataCallback()
  {
    AppMethodBeat.i(94304);
    Object localObject = this.gBC;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
      AppMethodBeat.o(94304);
      return localObject;
    }
    AppMethodBeat.o(94304);
    return null;
  }
  
  public d getPreviewTexture()
  {
    AppMethodBeat.i(205890);
    Object localObject = this.gBC;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).fQI();
      AppMethodBeat.o(205890);
      return localObject;
    }
    AppMethodBeat.o(205890);
    return null;
  }
  
  public void j(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(94305);
    k.h(parama, "r");
    queueEvent((Runnable)new a(parama));
    AppMethodBeat.o(94305);
  }
  
  public void m(d.g.a.b<? super SurfaceTexture, y> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94298);
    ad.m("MicroMsg.CameraPreviewGLSurfaceView", "tryCameraPreview  canPreview:" + this.gBE, new Object[0]);
    if (this.gBE)
    {
      Object localObject3 = new StringBuilder("callback.invoke  ");
      Object localObject1 = this.gBC;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
      {
        ad.m("MicroMsg.CameraPreviewGLSurfaceView", localObject1, new Object[0]);
        if (paramb == null) {
          break;
        }
        localObject3 = this.gBC;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject3).getSurfaceTexture();
        }
        paramb.aA(localObject1);
        AppMethodBeat.o(94298);
        return;
      }
      AppMethodBeat.o(94298);
      return;
    }
    this.gBB = paramb;
    AppMethodBeat.o(94298);
  }
  
  public void release()
  {
    AppMethodBeat.i(94302);
    getHolder().removeCallback((SurfaceHolder.Callback)this);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null) {
      locala.release();
    }
    this.gBE = false;
    AppMethodBeat.o(94302);
  }
  
  public void setOnDrawListener(d.g.a.b<? super d, y> paramb)
  {
    AppMethodBeat.i(94300);
    ad.m("MicroMsg.CameraPreviewGLSurfaceView", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.gBC;
    if (locala != null)
    {
      locala.gBQ = paramb;
      AppMethodBeat.o(94300);
      return;
    }
    AppMethodBeat.o(94300);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94306);
    StringBuilder localStringBuilder = new StringBuilder("surfaceChanged:");
    if (paramSurfaceHolder != null) {}
    for (Surface localSurface = paramSurfaceHolder.getSurface();; localSurface = null)
    {
      ad.i("MicroMsg.CameraPreviewGLSurfaceView", localSurface + ", format:" + paramInt1 + ", w:" + paramInt2 + ", h:" + paramInt3);
      super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(94306);
      return;
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94308);
    StringBuilder localStringBuilder = new StringBuilder("surfaceCreated: ");
    if (paramSurfaceHolder != null) {}
    for (Surface localSurface = paramSurfaceHolder.getSurface();; localSurface = null)
    {
      ad.i("MicroMsg.CameraPreviewGLSurfaceView", localSurface);
      super.surfaceCreated(paramSurfaceHolder);
      AppMethodBeat.o(94308);
      return;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94307);
    StringBuilder localStringBuilder = new StringBuilder("surfaceDestroyed: ");
    if (paramSurfaceHolder != null) {}
    for (Object localObject = paramSurfaceHolder.getSurface();; localObject = null)
    {
      ad.i("MicroMsg.CameraPreviewGLSurfaceView", localObject);
      localObject = this.gBC;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).release();
      }
      this.gBE = false;
      super.surfaceDestroyed(paramSurfaceHolder);
      AppMethodBeat.o(94307);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */