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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "ROTATION_FIX", "", "drawHeight", "drawWidth", "eglContext", "Landroid/opengl/EGLContext;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglSurfaceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "frameDrawCallback", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "renderOutputBuffer", "Ljava/nio/IntBuffer;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "takePicture", "", "takePictureCallback", "Landroid/graphics/Bitmap;", "bitmap", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "setView", "actualRenderRotation", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getEGLSurface", "callback", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureObject", "initRender", "createSurfaceTexture", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "input", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setOnDrawListener", "frameAvailableListener", "setRender", "updateCameraConfig", "updateImageTexture", "plugin-mediaeditor_release"})
public abstract class a
{
  private EGLSurface eglSurface;
  private int gOm;
  private int gOn;
  com.tencent.mm.media.j.a hnY;
  public EGLContext hrF;
  private d.g.a.b<? super EGLSurface, z> hxj;
  public d.g.a.b<? super d, z> hxk;
  private IntBuffer hxl;
  private boolean hxm;
  private d.g.a.b<? super Bitmap, z> hxn;
  private final int hxo;
  f hxp;
  
  public a(f paramf)
  {
    this.hxp = paramf;
    this.hxo = 360;
  }
  
  private final int axX()
  {
    Object localObject = ak.getContext().getSystemService("window");
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
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
      return (com.tencent.mm.media.widget.a.b.aws() - i + this.hxo) % this.hxo;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public final void a(final int paramInt, final d.g.a.a<z> parama)
  {
    this.hxp.i((d.g.a.a)new a(this, parama, paramInt));
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    p.h(paramb, "cameraConfig");
    ae.m("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig: ".concat(String.valueOf(paramb)), new Object[0]);
    paramb = com.tencent.mm.media.widget.a.b.aww();
    com.tencent.mm.media.j.a locala = this.hnY;
    if (locala != null) {
      locala.cU(paramb.x, paramb.y);
    }
    paramb = this.hnY;
    if (paramb != null) {
      paramb.ng(axX());
    }
    paramb = this.hnY;
    if (paramb != null) {
      paramb.ei(com.tencent.mm.media.widget.a.b.awv());
    }
  }
  
  public final void amC()
  {
    com.tencent.mm.media.j.a locala = this.hnY;
    if (locala != null) {
      locala.hpW = true;
    }
  }
  
  public final d axW()
  {
    com.tencent.mm.media.j.a locala = this.hnY;
    if (locala != null) {
      return locala.hpV;
    }
    return null;
  }
  
  public void b(final com.tencent.mm.media.j.a parama)
  {
    p.h(parama, "renderer");
    this.hnY = parama;
    com.tencent.mm.media.j.a locala = this.hnY;
    if (locala != null) {
      locala.hqb = ((d.g.a.a)new c(this, parama));
    }
  }
  
  public g getFrameDataCallback()
  {
    return null;
  }
  
  public final SurfaceTexture getSurfaceTexture()
  {
    com.tencent.mm.media.j.a locala = this.hnY;
    if (locala != null) {
      return locala.getTexture();
    }
    return null;
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    Object localObject = this.hnY;
    if (localObject != null) {
      ((com.tencent.mm.media.j.a)localObject).onDrawFrame(paramGL10);
    }
    if (this.hxm)
    {
      this.hxm = false;
      this.hxl = IntBuffer.allocate(this.gOn * this.gOm);
      paramGL10 = this.hxl;
      if (paramGL10 == null) {
        p.gkB();
      }
      paramGL10.position(0);
      GLES20.glReadPixels(0, 0, this.gOm, this.gOn, 6408, 5121, (Buffer)this.hxl);
      paramGL10 = Bitmap.createBitmap(this.gOm, this.gOn, Bitmap.Config.ARGB_8888);
      paramGL10.copyPixelsFromBuffer((Buffer)this.hxl);
      localObject = new Matrix();
      ((Matrix)localObject).preScale(-1.0F, 1.0F);
      ((Matrix)localObject).preRotate(180.0F);
      localObject = Bitmap.createBitmap(paramGL10, 0, 0, this.gOm, this.gOn, (Matrix)localObject, false);
      paramGL10.recycle();
      paramGL10 = this.hxn;
      if (paramGL10 != null)
      {
        p.g(localObject, "bmp");
        paramGL10.invoke(localObject);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.gOm = paramInt1;
    this.gOn = paramInt2;
    com.tencent.mm.media.j.a locala = this.hnY;
    if (locala != null) {
      locala.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.hrF = EGL14.eglGetCurrentContext();
    this.eglSurface = EGL14.eglGetCurrentSurface(12377);
    Object localObject = this.hxj;
    if (localObject != null)
    {
      EGLSurface localEGLSurface = this.eglSurface;
      if (localEGLSurface == null) {
        p.gkB();
      }
      ((d.g.a.b)localObject).invoke(localEGLSurface);
    }
    this.hxj = null;
    localObject = this.hnY;
    if (localObject != null) {
      ((com.tencent.mm.media.j.a)localObject).onSurfaceCreated(paramGL10, paramEGLConfig);
    }
  }
  
  public final void release()
  {
    this.hxp.i((d.g.a.a)new b(this));
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(a parama, d.g.a.a parama1, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(a parama, com.tencent.mm.media.j.a parama1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.a
 * JD-Core Version:    0.7.0.1
 */