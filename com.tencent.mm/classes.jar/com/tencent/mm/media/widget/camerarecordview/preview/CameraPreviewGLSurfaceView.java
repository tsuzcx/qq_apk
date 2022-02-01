package com.tencent.mm.media.widget.camerarecordview.preview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "canPreview", "", "frameRotate", "", "ignoreRender", "previewCallback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "", "previewController", "Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "clearFrame", "getEGLContext", "Landroid/opengl/EGLContext;", "getEGLSurface", "callback", "Landroid/opengl/EGLSurface;", "Lkotlin/ParameterName;", "name", "eglSurface", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "ignore", "queueEvent", "r", "Lkotlin/Function0;", "release", "setOnDrawListener", "frameAvailableListener", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "w", "h", "surfaceCreated", "surfaceDestroyed", "tryCameraPreview", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class CameraPreviewGLSurfaceView
  extends GLSurfaceView
  implements b
{
  public static final CameraPreviewGLSurfaceView.a nKl;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a mVj;
  private kotlin.g.a.b<? super SurfaceTexture, ah> nKm;
  private int nKn;
  private boolean nKo;
  private boolean nKp;
  
  static
  {
    AppMethodBeat.i(94310);
    nKl = new CameraPreviewGLSurfaceView.a((byte)0);
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
          if (!CameraPreviewGLSurfaceView.b(this.nKq))
          {
            com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.nKq);
            if (locala != null) {
              locala.onDrawFrame(paramAnonymousGL10);
            }
          }
          AppMethodBeat.o(94292);
        }
        
        public final void onSurfaceChanged(final GL10 paramAnonymousGL10, final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(94293);
          Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceChanged width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2, new Object[0]);
          com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.nKq);
          if (locala != null) {
            locala.a(CameraPreviewGLSurfaceView.c(this.nKq), (kotlin.g.a.a)new a(this.nKq, paramAnonymousGL10, paramAnonymousInt1, paramAnonymousInt2));
          }
          AppMethodBeat.o(94293);
        }
        
        public final void onSurfaceCreated(GL10 paramAnonymousGL10, EGLConfig paramAnonymousEGLConfig)
        {
          AppMethodBeat.i(94294);
          Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "onSurfaceCreated", new Object[0]);
          com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = CameraPreviewGLSurfaceView.a(this.nKq);
          if (locala != null) {
            locala.onSurfaceCreated(paramAnonymousGL10, paramAnonymousEGLConfig);
          }
          AppMethodBeat.o(94294);
        }
        
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements kotlin.g.a.a<ah>
        {
          a(CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView, GL10 paramGL10, int paramInt1, int paramInt2)
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
  
  private static final void ab(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(237724);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(237724);
  }
  
  public void H(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(94305);
    s.u(parama, "r");
    queueEvent(new CameraPreviewGLSurfaceView..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(94305);
  }
  
  public void a(com.tencent.mm.media.j.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(94296);
    s.u(parama, "renderer");
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "setPreviewRenderer cpuCrop:" + paramBoolean + ", previewController:" + this.mVj, new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      com.tencent.mm.media.widget.camerarecordview.preview.a.a.a(locala, false, true, 1);
    }
    if (paramBoolean) {}
    for (locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.b((b)this);; locala = (com.tencent.mm.media.widget.camerarecordview.preview.a.a)new com.tencent.mm.media.widget.camerarecordview.preview.a.c((c)this))
    {
      this.mVj = locala;
      locala = this.mVj;
      if (locala != null) {
        locala.b(parama);
      }
      AppMethodBeat.o(94296);
      return;
    }
  }
  
  public void a(com.tencent.mm.media.widget.a.b paramb)
  {
    AppMethodBeat.i(94297);
    s.u(paramb, "cameraConfig");
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", s.X("updateCameraConfig:", paramb), new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.a(paramb);
    }
    AppMethodBeat.o(94297);
  }
  
  public void bgw()
  {
    AppMethodBeat.i(94299);
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "tryStopCameraPreview", new Object[0]);
    this.nKm = null;
    AppMethodBeat.o(94299);
  }
  
  public void bgx()
  {
    AppMethodBeat.i(94303);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.bgx();
    }
    AppMethodBeat.o(94303);
  }
  
  public EGLContext getEGLContext()
  {
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala == null) {
      return null;
    }
    return locala.eXL;
  }
  
  public g getFrameDataCallback()
  {
    AppMethodBeat.i(94304);
    Object localObject = this.mVj;
    if (localObject == null)
    {
      AppMethodBeat.o(94304);
      return null;
    }
    localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).getFrameDataCallback();
    AppMethodBeat.o(94304);
    return localObject;
  }
  
  public d getPreviewTexture()
  {
    AppMethodBeat.i(237744);
    Object localObject = this.mVj;
    if (localObject == null)
    {
      AppMethodBeat.o(237744);
      return null;
    }
    localObject = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject).bul();
    AppMethodBeat.o(237744);
    return localObject;
  }
  
  public void release()
  {
    AppMethodBeat.i(94302);
    getHolder().removeCallback((SurfaceHolder.Callback)this);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      com.tencent.mm.media.widget.camerarecordview.preview.a.a.a(locala, false, false, 3);
    }
    this.nKo = false;
    AppMethodBeat.o(94302);
  }
  
  public void setOnDrawListener(kotlin.g.a.b<? super d, ah> paramb)
  {
    AppMethodBeat.i(94300);
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "setOnDrawListener", new Object[0]);
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      locala.nKB = paramb;
    }
    AppMethodBeat.o(94300);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(94306);
    s.u(paramSurfaceHolder, "holder");
    Log.i("MicroMsg.CameraPreviewGLSurfaceView", "surfaceChanged:" + paramSurfaceHolder.getSurface() + ", format:" + paramInt1 + ", w:" + paramInt2 + ", h:" + paramInt3);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(94306);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94308);
    s.u(paramSurfaceHolder, "holder");
    Log.i("MicroMsg.CameraPreviewGLSurfaceView", s.X("surfaceCreated: ", paramSurfaceHolder.getSurface()));
    super.surfaceCreated(paramSurfaceHolder);
    AppMethodBeat.o(94308);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(94307);
    s.u(paramSurfaceHolder, "holder");
    Log.i("MicroMsg.CameraPreviewGLSurfaceView", s.X("surfaceDestroyed: ", paramSurfaceHolder.getSurface()));
    com.tencent.mm.media.widget.camerarecordview.preview.a.a locala = this.mVj;
    if (locala != null) {
      com.tencent.mm.media.widget.camerarecordview.preview.a.a.a(locala, false, true, 1);
    }
    this.nKo = false;
    super.surfaceDestroyed(paramSurfaceHolder);
    AppMethodBeat.o(94307);
  }
  
  public void t(kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(94298);
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", s.X("tryCameraPreview  canPreview:", Boolean.valueOf(this.nKo)), new Object[0]);
    if (this.nKo)
    {
      Object localObject1 = this.mVj;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", s.X("callback.invoke  ", localObject1), new Object[0]);
        if (paramb != null)
        {
          localObject1 = this.mVj;
          if (localObject1 != null) {
            break label102;
          }
        }
      }
      label102:
      for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture())
      {
        paramb.invoke(localObject1);
        AppMethodBeat.o(94298);
        return;
        localObject1 = ((com.tencent.mm.media.widget.camerarecordview.preview.a.a)localObject1).getSurfaceTexture();
        break;
      }
    }
    this.nKm = paramb;
    AppMethodBeat.o(94298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */