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
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "ROTATION_FIX", "", "drawHeight", "drawWidth", "eglContext", "Landroid/opengl/EGLContext;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglSurfaceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "frameDrawCallback", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "renderOutputBuffer", "Ljava/nio/IntBuffer;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "takePicture", "", "takePictureCallback", "Landroid/graphics/Bitmap;", "bitmap", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "setView", "actualRenderRotation", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getEGLSurface", "callback", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureObject", "initRender", "createSurfaceTexture", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "input", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setOnDrawListener", "frameAvailableListener", "setRender", "updateCameraConfig", "updateImageTexture", "plugin-mediaeditor_release"})
public abstract class a
{
  private EGLSurface eglSurface;
  private int hEp;
  private int hEq;
  com.tencent.mm.media.j.a ihs;
  public EGLContext ilv;
  private kotlin.g.a.b<? super EGLSurface, x> iqK;
  public kotlin.g.a.b<? super d, x> iqL;
  private IntBuffer iqM;
  private boolean iqN;
  private kotlin.g.a.b<? super Bitmap, x> iqO;
  private final int iqP;
  f iqQ;
  
  public a(f paramf)
  {
    this.iqQ = paramf;
    this.iqP = 360;
  }
  
  private final int aQv()
  {
    Object localObject = MMApplicationContext.getContext().getSystemService("window");
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.g(localObject, "(MMApplicationContext.ge…owManager).defaultDisplay");
    int i;
    switch (((Display)localObject).getRotation())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return (com.tencent.mm.media.widget.a.b.aPk() - i + this.iqP) % this.iqP;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public final void a(final int paramInt, final kotlin.g.a.a<x> parama)
  {
    this.iqQ.j((kotlin.g.a.a)new a(this, parama, paramInt));
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    p.h(paramb, "cameraConfig");
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig: ".concat(String.valueOf(paramb)), new Object[0]);
    paramb = com.tencent.mm.media.widget.a.b.aPo();
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null) {
      locala.cZ(paramb.x, paramb.y);
    }
    paramb = this.ihs;
    if (paramb != null) {
      paramb.qx(aQv());
    }
    paramb = this.ihs;
    if (paramb != null) {
      paramb.eD(com.tencent.mm.media.widget.a.b.aPn());
    }
  }
  
  public final void aEy()
  {
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null) {
      locala.ijr = true;
    }
  }
  
  public final d aQu()
  {
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null) {
      return locala.ijq;
    }
    return null;
  }
  
  public void b(final com.tencent.mm.media.j.a parama)
  {
    p.h(parama, "renderer");
    this.ihs = parama;
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null) {
      locala.ijw = ((kotlin.g.a.a)new c(this, parama));
    }
  }
  
  public g getFrameDataCallback()
  {
    return null;
  }
  
  public final SurfaceTexture getSurfaceTexture()
  {
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null) {
      return locala.getTexture();
    }
    return null;
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    Object localObject = this.ihs;
    if (localObject != null) {
      ((com.tencent.mm.media.j.a)localObject).onDrawFrame(paramGL10);
    }
    if (this.iqN)
    {
      this.iqN = false;
      this.iqM = IntBuffer.allocate(this.hEq * this.hEp);
      paramGL10 = this.iqM;
      if (paramGL10 == null) {
        p.hyc();
      }
      paramGL10.position(0);
      GLES20.glReadPixels(0, 0, this.hEp, this.hEq, 6408, 5121, (Buffer)this.iqM);
      paramGL10 = Bitmap.createBitmap(this.hEp, this.hEq, Bitmap.Config.ARGB_8888);
      paramGL10.copyPixelsFromBuffer((Buffer)this.iqM);
      localObject = new Matrix();
      ((Matrix)localObject).preScale(-1.0F, 1.0F);
      ((Matrix)localObject).preRotate(180.0F);
      localObject = Bitmap.createBitmap(paramGL10, 0, 0, this.hEp, this.hEq, (Matrix)localObject, false);
      paramGL10.recycle();
      paramGL10 = this.iqO;
      if (paramGL10 != null)
      {
        p.g(localObject, "bmp");
        paramGL10.invoke(localObject);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.hEp = paramInt1;
    this.hEq = paramInt2;
    com.tencent.mm.media.j.a locala = this.ihs;
    if (locala != null) {
      locala.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.ilv = EGL14.eglGetCurrentContext();
    this.eglSurface = EGL14.eglGetCurrentSurface(12377);
    Object localObject = this.iqK;
    if (localObject != null)
    {
      EGLSurface localEGLSurface = this.eglSurface;
      if (localEGLSurface == null) {
        p.hyc();
      }
      ((kotlin.g.a.b)localObject).invoke(localEGLSurface);
    }
    this.iqK = null;
    localObject = this.ihs;
    if (localObject != null) {
      ((com.tencent.mm.media.j.a)localObject).onSurfaceCreated(paramGL10, paramEGLConfig);
    }
  }
  
  public final void release()
  {
    this.iqQ.j((kotlin.g.a.a)new b(this));
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(a parama, kotlin.g.a.a parama1, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(a parama, com.tencent.mm.media.j.a parama1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.a
 * JD-Core Version:    0.7.0.1
 */