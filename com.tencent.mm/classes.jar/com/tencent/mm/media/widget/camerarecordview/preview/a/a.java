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
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.widget.camerarecordview.preview.f;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.v;
import d.y;
import java.nio.Buffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "ROTATION_FIX", "", "drawHeight", "drawWidth", "eglContext", "Landroid/opengl/EGLContext;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglSurfaceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "frameDrawCallback", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "renderOutputBuffer", "Ljava/nio/IntBuffer;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "takePicture", "", "takePictureCallback", "Landroid/graphics/Bitmap;", "bitmap", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "setView", "actualRenderRotation", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getEGLSurface", "callback", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureObject", "initRender", "createSurfaceTexture", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "input", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setOnDrawListener", "frameAvailableListener", "setRender", "updateCameraConfig", "updateImageTexture", "plugin-mediaeditor_release"})
public abstract class a
{
  private d.g.a.b<? super EGLSurface, y> KBS;
  private EGLSurface eglSurface;
  public d.g.a.b<? super d, y> gBQ;
  private IntBuffer gBR;
  private boolean gBS;
  private d.g.a.b<? super Bitmap, y> gBT;
  private final int gBU;
  f gBV;
  com.tencent.mm.media.i.a gsB;
  private int guK;
  private int guL;
  public EGLContext gwo;
  
  public a(f paramf)
  {
    this.gBV = paramf;
    this.gBU = 360;
  }
  
  private final int aoe()
  {
    Object localObject = aj.getContext().getSystemService("window");
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    k.g(localObject, "(MMApplicationContext.ge…owManager).defaultDisplay");
    int i;
    switch (((Display)localObject).getRotation())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return (com.tencent.mm.media.widget.a.b.amy() - i + this.gBU) % this.gBU;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    k.h(paramb, "cameraConfig");
    ad.m("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig: ".concat(String.valueOf(paramb)), new Object[0]);
    paramb = com.tencent.mm.media.widget.a.b.amC();
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null) {
      locala.cS(paramb.x, paramb.y);
    }
    paramb = this.gsB;
    if (paramb != null) {
      paramb.mz(aoe());
    }
    paramb = this.gsB;
    if (paramb != null) {
      paramb.dJ(com.tencent.mm.media.widget.a.b.amB());
    }
  }
  
  public final void anT()
  {
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null) {
      locala.guA = true;
    }
  }
  
  public final void b(final int paramInt, final d.g.a.a<y> parama)
  {
    this.gBV.j((d.g.a.a)new a(this, parama, paramInt));
  }
  
  public void b(final com.tencent.mm.media.i.a parama)
  {
    k.h(parama, "renderer");
    this.gsB = parama;
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null) {
      locala.guG = ((d.g.a.a)new c(this, parama));
    }
  }
  
  public final d fQI()
  {
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null) {
      return locala.guz;
    }
    return null;
  }
  
  public g getFrameDataCallback()
  {
    return null;
  }
  
  public final SurfaceTexture getSurfaceTexture()
  {
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null) {
      return locala.getTexture();
    }
    return null;
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    Object localObject = this.gsB;
    if (localObject != null) {
      ((com.tencent.mm.media.i.a)localObject).onDrawFrame(paramGL10);
    }
    if (this.gBS)
    {
      this.gBS = false;
      this.gBR = IntBuffer.allocate(this.guL * this.guK);
      paramGL10 = this.gBR;
      if (paramGL10 == null) {
        k.fvU();
      }
      paramGL10.position(0);
      GLES20.glReadPixels(0, 0, this.guK, this.guL, 6408, 5121, (Buffer)this.gBR);
      paramGL10 = Bitmap.createBitmap(this.guK, this.guL, Bitmap.Config.ARGB_8888);
      paramGL10.copyPixelsFromBuffer((Buffer)this.gBR);
      localObject = new Matrix();
      ((Matrix)localObject).preScale(-1.0F, 1.0F);
      ((Matrix)localObject).preRotate(180.0F);
      localObject = Bitmap.createBitmap(paramGL10, 0, 0, this.guK, this.guL, (Matrix)localObject, false);
      paramGL10.recycle();
      paramGL10 = this.gBT;
      if (paramGL10 != null)
      {
        k.g(localObject, "bmp");
        paramGL10.aA(localObject);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.guK = paramInt1;
    this.guL = paramInt2;
    com.tencent.mm.media.i.a locala = this.gsB;
    if (locala != null) {
      locala.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.gwo = EGL14.eglGetCurrentContext();
    this.eglSurface = EGL14.eglGetCurrentSurface(12377);
    Object localObject = this.KBS;
    if (localObject != null)
    {
      EGLSurface localEGLSurface = this.eglSurface;
      if (localEGLSurface == null) {
        k.fvU();
      }
      ((d.g.a.b)localObject).aA(localEGLSurface);
    }
    this.KBS = null;
    localObject = this.gsB;
    if (localObject != null) {
      ((com.tencent.mm.media.i.a)localObject).onSurfaceCreated(paramGL10, paramEGLConfig);
    }
  }
  
  public final void release()
  {
    this.gBV.j((d.g.a.a)new b(this));
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(a parama, d.g.a.a parama1, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(a parama, com.tencent.mm.media.i.a parama1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.a
 * JD-Core Version:    0.7.0.1
 */