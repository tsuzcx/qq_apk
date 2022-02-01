package com.tencent.mm.media.widget.camerarecordview.preview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.c;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "ROTATION_FIX", "", "drawHeight", "drawWidth", "eglContext", "Landroid/opengl/EGLContext;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglSurfaceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "frameDrawCallback", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "releaseLock", "Ljava/lang/Object;", "renderOutputBuffer", "Ljava/nio/IntBuffer;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "takePicture", "", "takePictureCallback", "Landroid/graphics/Bitmap;", "bitmap", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "setView", "actualRenderRotation", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getEGLSurface", "callback", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureObject", "initRender", "createSurfaceTexture", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "input", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "needPostRenderThread", "block", "setOnDrawListener", "frameAvailableListener", "setRender", "updateCameraConfig", "updateImageTexture", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public EGLContext eXL;
  private EGLSurface eglSurface;
  private int mWn;
  private int mWo;
  com.tencent.mm.media.j.a nBj;
  final Object nBo;
  private kotlin.g.a.b<? super EGLSurface, ah> nKA;
  public kotlin.g.a.b<? super d, ah> nKB;
  private IntBuffer nKC;
  private boolean nKD;
  private kotlin.g.a.b<? super Bitmap, ah> nKE;
  private final int nKF;
  c nKz;
  
  public a(c paramc)
  {
    this.nKz = paramc;
    this.nKF = 360;
    this.nBo = new Object();
  }
  
  private final int bum()
  {
    Object localObject = MMApplicationContext.getContext().getSystemService("window");
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
    int i;
    switch (((WindowManager)localObject).getDefaultDisplay().getRotation())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return (com.tencent.mm.media.widget.a.b.bsL() - i + this.nKF) % this.nKF;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public final void a(final int paramInt, final kotlin.g.a.a<ah> parama)
  {
    this.nKz.H((kotlin.g.a.a)new a(this, parama, paramInt));
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    s.u(paramb, "cameraConfig");
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", s.X("updateCameraConfig: ", paramb), new Object[0]);
    paramb = com.tencent.mm.media.widget.a.b.bsP();
    com.tencent.mm.media.j.a locala = this.nBj;
    if (locala != null) {
      locala.el(paramb.x, paramb.y);
    }
    paramb = this.nBj;
    if (paramb != null) {
      paramb.th(bum());
    }
    paramb = this.nBj;
    if (paramb != null) {
      paramb.fQ(com.tencent.mm.media.widget.a.b.isFrontCamera());
    }
  }
  
  public void b(final com.tencent.mm.media.j.a parama)
  {
    s.u(parama, "renderer");
    this.nBj = parama;
    com.tencent.mm.media.j.a locala = this.nBj;
    if (locala != null) {
      locala.nDu = ((kotlin.g.a.a)new c(this, parama));
    }
  }
  
  public final void bgx()
  {
    com.tencent.mm.media.j.a locala = this.nBj;
    if (locala != null) {
      locala.nDp = true;
    }
  }
  
  public final d bul()
  {
    com.tencent.mm.media.j.a locala = this.nBj;
    if (locala == null) {
      return null;
    }
    return locala.bpP();
  }
  
  public g getFrameDataCallback()
  {
    return null;
  }
  
  public final SurfaceTexture getSurfaceTexture()
  {
    com.tencent.mm.media.j.a locala = this.nBj;
    if (locala == null) {
      return null;
    }
    return locala.bpL();
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    Object localObject = this.nBj;
    if (localObject != null) {
      ((com.tencent.mm.media.j.a)localObject).onDrawFrame(paramGL10);
    }
    if (this.nKD)
    {
      this.nKD = false;
      this.nKC = IntBuffer.allocate(this.mWo * this.mWn);
      paramGL10 = this.nKC;
      s.checkNotNull(paramGL10);
      paramGL10.position(0);
      GLES20.glReadPixels(0, 0, this.mWn, this.mWo, 6408, 5121, (Buffer)this.nKC);
      paramGL10 = Bitmap.createBitmap(this.mWn, this.mWo, Bitmap.Config.ARGB_8888);
      paramGL10.copyPixelsFromBuffer((Buffer)this.nKC);
      localObject = new Matrix();
      ((Matrix)localObject).preScale(-1.0F, 1.0F);
      ((Matrix)localObject).preRotate(180.0F);
      localObject = Bitmap.createBitmap(paramGL10, 0, 0, this.mWn, this.mWo, (Matrix)localObject, false);
      paramGL10.recycle();
      paramGL10 = this.nKE;
      if (paramGL10 != null)
      {
        s.s(localObject, "bmp");
        paramGL10.invoke(localObject);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.mWn = paramInt1;
    this.mWo = paramInt2;
    com.tencent.mm.media.j.a locala = this.nBj;
    if (locala != null) {
      locala.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.eXL = EGL14.eglGetCurrentContext();
    this.eglSurface = EGL14.eglGetCurrentSurface(12377);
    Object localObject = this.nKA;
    if (localObject != null)
    {
      EGLSurface localEGLSurface = this.eglSurface;
      s.checkNotNull(localEGLSurface);
      ((kotlin.g.a.b)localObject).invoke(localEGLSurface);
    }
    this.nKA = null;
    localObject = this.nBj;
    if (localObject != null) {
      ((com.tencent.mm.media.j.a)localObject).onSurfaceCreated(paramGL10, paramEGLConfig);
    }
  }
  
  public final void t(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    Log.i("MicroMsg.CameraPreviewGLSurfaceView", "release, needPostRenderThread:" + paramBoolean1 + ", block:" + paramBoolean2);
    ??? = (kotlin.g.a.a)new b(this, paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      long l = Util.currentTicks();
      Log.i("MicroMsg.CameraPreviewGLSurfaceView", "start post release");
      this.nKz.H((kotlin.g.a.a)???);
      if (paramBoolean2) {}
      synchronized (this.nBo)
      {
        try
        {
          this.nBo.wait(100L);
          ah localah = ah.aiuX;
          Log.i("MicroMsg.CameraPreviewGLSurfaceView", "wait release finished cost:" + Util.ticksToNow(l) + "ms");
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.CameraPreviewGLSurfaceView", (Throwable)localException, "wait release error", new Object[0]);
          }
        }
      }
    }
    ((kotlin.g.a.a)???).invoke();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(a parama, kotlin.g.a.a<ah> parama1, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama, com.tencent.mm.media.j.a parama1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.a
 * JD-Core Version:    0.7.0.1
 */