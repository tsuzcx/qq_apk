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
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.a.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canPreview", "", "frameRotate", "", "ignoreRender", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getEGLSurface", "callback", "Landroid/opengl/EGLSurface;", "Lkotlin/ParameterName;", "name", "eglSurface", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "ignore", "queueEvent", "r", "Lkotlin/Function0;", "release", "setOnDrawListener", "frameAvailableListener", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "w", "h", "surfaceCreated", "surfaceDestroyed", "tryCameraPreview", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"})
public class CameraPreviewGLSurfaceView
  extends GLSurfaceView
  implements e
{
  public static final CameraPreviewGLSurfaceView.a iqA;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a hDt;
  private kotlin.g.a.b<? super SurfaceTexture, x> iqw;
  private int iqx;
  private boolean iqy;
  private boolean iqz;
  
  static
  {
    AppMethodBeat.i(94310);
    iqA = new CameraPreviewGLSurfaceView.a((byte)0);
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
      setEGLContextFactory((GLSurfaceView.EGLContextFactory)new com.tencent.mm.media.j.a.b());
      setEGLContextClientVersion(MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3));
      setEGLConfigChooser((GLSurfaceView.EGLConfigChooser)new com.tencent.mm.media.j.a.a());
      setPreserveEGLContextOnPause(false);
      setRenderer((GLSurfaceView.Renderer)new GLSurfaceView.Renderer()
      {
        public final void onDrawFrame(GL10 paramAnonymousGL10)
        {
          AppMethodBeat.i(94292);
          if (!CameraPreviewGLSurfaceView.b(this.iqB))
          {
            com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.iqB);
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
          Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceChanged width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2, new Object[0]);
          com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.iqB);
          if (locala != null)
          {
            locala.a(CameraPreviewGLSurfaceView.c(this.iqB), (kotlin.g.a.a)new a(this, paramAnonymousGL10, paramAnonymousInt1, paramAnonymousInt2));
            AppMethodBeat.o(94293);
            return;
          }
          AppMethodBeat.o(94293);
        }
        
        public final void onSurfaceCreated(GL10 paramAnonymousGL10, EGLConfig paramAnonymousEGLConfig)
        {
          AppMethodBeat.i(94294);
          Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceCreated", new Object[0]);
          com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.iqB);
          if (locala != null)
          {
            locala.onSurfaceCreated(paramAnonymousGL10, paramAnonymousEGLConfig);
            AppMethodBeat.o(94294);
            return;
          }
          AppMethodBeat.o(94294);
        }
        
        @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
        static final class a
          extends q
          implements kotlin.g.a.a<x>
        {
          a(CameraPreviewGLSurfaceView.1 param1, GL10 paramGL10, int paramInt1, int paramInt2)
          {
            super();
          }
        }
      });
      setRenderMode(0);
      Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "init create CameraPreviewGLSurfaceView", new Object[0]);
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
  
  public void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94296);
    p.h(parama, "renderer");
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "setPreviewRenderer cpuCrop:".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null) {
      locala.release();
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((e)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new c((f)this))
    {
      this.hDt = locala;
      locala = this.hDt;
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
    p.h(paramb, "cameraConfig");
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig:".concat(String.valueOf(paramb)), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.a(paramb);
      AppMethodBeat.o(94297);
      return;
    }
    AppMethodBeat.o(94297);
  }
  
  public void aEx()
  {
    AppMethodBeat.i(94299);
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "tryStopCameraPreview", new Object[0]);
    this.iqw = null;
    AppMethodBeat.o(94299);
  }
  
  public void aEy()
  {
    AppMethodBeat.i(94303);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.aEy();
      AppMethodBeat.o(94303);
      return;
    }
    AppMethodBeat.o(94303);
  }
  
  public void d(kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94298);
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "tryCameraPreview  canPreview:" + this.iqy, new Object[0]);
    if (this.iqy)
    {
      Object localObject3 = new StringBuilder("callback.invoke  ");
      Object localObject1 = this.hDt;
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();; localObject1 = null)
      {
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", localObject1, new Object[0]);
        if (paramb == null) {
          break;
        }
        localObject3 = this.hDt;
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject3).getSurfaceTexture();
        }
        paramb.invoke(localObject1);
        AppMethodBeat.o(94298);
        return;
      }
      AppMethodBeat.o(94298);
      return;
    }
    this.iqw = paramb;
    AppMethodBeat.o(94298);
  }
  
  public EGLContext getEGLContext()
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null) {
      return locala.ilv;
    }
    return null;
  }
  
  public g getFrameDataCallback()
  {
    AppMethodBeat.i(94304);
    Object localObject = this.hDt;
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
    AppMethodBeat.i(218885);
    Object localObject = this.hDt;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).aQu();
      AppMethodBeat.o(218885);
      return localObject;
    }
    AppMethodBeat.o(218885);
    return null;
  }
  
  public void j(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(94305);
    p.h(parama, "r");
    queueEvent((Runnable)new a(parama));
    AppMethodBeat.o(94305);
  }
  
  public void release()
  {
    AppMethodBeat.i(94302);
    getHolder().removeCallback((SurfaceHolder.Callback)this);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null) {
      locala.release();
    }
    this.iqy = false;
    AppMethodBeat.o(94302);
  }
  
  public void setOnDrawListener(kotlin.g.a.b<? super d, x> paramb)
  {
    AppMethodBeat.i(94300);
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.hDt;
    if (locala != null)
    {
      locala.iqL = paramb;
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
      Log.i("MicroMsg.CameraPreviewGLSurfaceView", localSurface + ", format:" + paramInt1 + ", w:" + paramInt2 + ", h:" + paramInt3);
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
      Log.i("MicroMsg.CameraPreviewGLSurfaceView", localSurface);
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
      Log.i("MicroMsg.CameraPreviewGLSurfaceView", localObject);
      localObject = this.hDt;
      if (localObject != null) {
        ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).release();
      }
      this.iqy = false;
      super.surfaceDestroyed(paramSurfaceHolder);
      AppMethodBeat.o(94307);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */