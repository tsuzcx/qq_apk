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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "ROTATION_FIX", "", "drawHeight", "drawWidth", "eglContext", "Landroid/opengl/EGLContext;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglSurfaceCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "frameDrawCallback", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "renderOutputBuffer", "Ljava/nio/IntBuffer;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "takePicture", "", "takePictureCallback", "Landroid/graphics/Bitmap;", "bitmap", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "setView", "actualRenderRotation", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getEGLSurface", "callback", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureObject", "initRender", "createSurfaceTexture", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "input", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "needPostRenderThread", "setOnDrawListener", "frameAvailableListener", "setRender", "updateCameraConfig", "updateImageTexture", "plugin-mediaeditor_release"})
public abstract class a
{
  private EGLSurface eglSurface;
  com.tencent.mm.media.j.a kWg;
  private int ksu;
  private int ksv;
  public EGLContext lau;
  private kotlin.g.a.b<? super EGLSurface, x> lfP;
  public kotlin.g.a.b<? super d, x> lfQ;
  private IntBuffer lfR;
  private boolean lfS;
  private kotlin.g.a.b<? super Bitmap, x> lfT;
  private final int lfU;
  f lfV;
  
  public a(f paramf)
  {
    this.lfV = paramf;
    this.lfU = 360;
  }
  
  private final int aZn()
  {
    Object localObject = MMApplicationContext.getContext().getSystemService("window");
    if (localObject == null) {
      throw new t("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.j(localObject, "(MMApplicationContext.ge…owManager).defaultDisplay");
    int i;
    switch (((Display)localObject).getRotation())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      return (com.tencent.mm.media.widget.a.b.aVp() - i + this.lfU) % this.lfU;
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
    this.lfV.i((kotlin.g.a.a)new a(this, parama, paramInt));
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    p.k(paramb, "cameraConfig");
    Log.printInfoStack("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig: ".concat(String.valueOf(paramb)), new Object[0]);
    paramb = com.tencent.mm.media.widget.a.b.aYa();
    com.tencent.mm.media.j.a locala = this.kWg;
    if (locala != null) {
      locala.dv(paramb.x, paramb.y);
    }
    paramb = this.kWg;
    if (paramb != null) {
      paramb.tm(aZn());
    }
    paramb = this.kWg;
    if (paramb != null) {
      paramb.fj(com.tencent.mm.media.widget.a.b.isFrontCamera());
    }
  }
  
  public final void aMN()
  {
    com.tencent.mm.media.j.a locala = this.kWg;
    if (locala != null) {
      locala.kYe = true;
    }
  }
  
  public final d aZm()
  {
    com.tencent.mm.media.j.a locala = this.kWg;
    if (locala != null) {
      return locala.kYd;
    }
    return null;
  }
  
  public void b(final com.tencent.mm.media.j.a parama)
  {
    p.k(parama, "renderer");
    this.kWg = parama;
    com.tencent.mm.media.j.a locala = this.kWg;
    if (locala != null) {
      locala.kYk = ((kotlin.g.a.a)new c(this, parama));
    }
  }
  
  public g getFrameDataCallback()
  {
    return null;
  }
  
  public final SurfaceTexture getSurfaceTexture()
  {
    com.tencent.mm.media.j.a locala = this.kWg;
    if (locala != null) {
      return locala.getTexture();
    }
    return null;
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    Object localObject = this.kWg;
    if (localObject != null) {
      ((com.tencent.mm.media.j.a)localObject).onDrawFrame(paramGL10);
    }
    if (this.lfS)
    {
      this.lfS = false;
      this.lfR = IntBuffer.allocate(this.ksv * this.ksu);
      paramGL10 = this.lfR;
      if (paramGL10 == null) {
        p.iCn();
      }
      paramGL10.position(0);
      GLES20.glReadPixels(0, 0, this.ksu, this.ksv, 6408, 5121, (Buffer)this.lfR);
      paramGL10 = Bitmap.createBitmap(this.ksu, this.ksv, Bitmap.Config.ARGB_8888);
      paramGL10.copyPixelsFromBuffer((Buffer)this.lfR);
      localObject = new Matrix();
      ((Matrix)localObject).preScale(-1.0F, 1.0F);
      ((Matrix)localObject).preRotate(180.0F);
      localObject = Bitmap.createBitmap(paramGL10, 0, 0, this.ksu, this.ksv, (Matrix)localObject, false);
      paramGL10.recycle();
      paramGL10 = this.lfT;
      if (paramGL10 != null)
      {
        p.j(localObject, "bmp");
        paramGL10.invoke(localObject);
      }
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.ksu = paramInt1;
    this.ksv = paramInt2;
    com.tencent.mm.media.j.a locala = this.kWg;
    if (locala != null) {
      locala.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    this.lau = EGL14.eglGetCurrentContext();
    this.eglSurface = EGL14.eglGetCurrentSurface(12377);
    Object localObject = this.lfP;
    if (localObject != null)
    {
      EGLSurface localEGLSurface = this.eglSurface;
      if (localEGLSurface == null) {
        p.iCn();
      }
      ((kotlin.g.a.b)localObject).invoke(localEGLSurface);
    }
    this.lfP = null;
    localObject = this.kWg;
    if (localObject != null) {
      ((com.tencent.mm.media.j.a)localObject).onSurfaceCreated(paramGL10, paramEGLConfig);
    }
  }
  
  public final void release(boolean paramBoolean)
  {
    kotlin.g.a.a locala = (kotlin.g.a.a)new b(this);
    if (paramBoolean)
    {
      this.lfV.i(locala);
      return;
    }
    locala.invoke();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(a parama, kotlin.g.a.a parama1, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.a
 * JD-Core Version:    0.7.0.1
 */