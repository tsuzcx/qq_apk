package com.tencent.mm.media.widget.camerarecordview.preview.a;

import a.f.b.j;
import a.l;
import a.y;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.mm.media.widget.camerarecordview.preview.d;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.IntBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/preview/controller/AbsPreviewController;", "", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;)V", "drawHeight", "", "drawWidth", "eglContext", "Landroid/opengl/EGLContext;", "frameDrawCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "renderOutputBuffer", "Ljava/nio/IntBuffer;", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "takePicture", "", "takePictureCallback", "Landroid/graphics/Bitmap;", "bitmap", "getView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "setView", "clearFrame", "drawFrame", "data", "", "getEGLContext", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getTextureId", "initRender", "createSurfaceTexture", "frameRotate", "afterInitRender", "Lkotlin/Function0;", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "setOnDrawListener", "frameAvailableListener", "setRender", "callback", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"})
public abstract class a
{
  public com.tencent.mm.media.h.a eWh;
  public int eYl;
  public int eYm;
  public IntBuffer eYy;
  public EGLContext eZz;
  public a.f.a.b<? super Integer, y> fbN;
  public boolean fbO;
  public a.f.a.b<? super Bitmap, y> fbP;
  public d fbQ;
  
  public a(d paramd)
  {
    this.fbQ = paramd;
  }
  
  public final void Xl()
  {
    com.tencent.mm.media.h.a locala = this.eWh;
    if (locala != null) {
      locala.eYb = true;
    }
  }
  
  public final void a(com.tencent.mm.media.widget.a.b paramb)
  {
    j.q(paramb, "cameraConfig");
    ab.b("MicroMsg.CameraPreviewGLSurfaceView", "updateCameraConfig: ".concat(String.valueOf(paramb)), new Object[0]);
    paramb = com.tencent.mm.media.widget.a.b.WT();
    com.tencent.mm.media.h.a locala = this.eWh;
    if (locala != null) {
      locala.cm(paramb.x, paramb.y);
    }
    paramb = this.eWh;
    if (paramb != null) {
      paramb.jX(com.tencent.mm.media.widget.a.b.WP());
    }
    paramb = this.eWh;
    if (paramb != null) {
      paramb.cE(com.tencent.mm.media.widget.a.b.WS());
    }
  }
  
  public void b(com.tencent.mm.media.h.a parama)
  {
    j.q(parama, "renderer");
    this.eWh = parama;
    com.tencent.mm.media.h.a locala = this.eWh;
    if (locala != null) {
      locala.eYh = ((a.f.a.a)new a.c(this, parama));
    }
  }
  
  public f getFrameDataCallback()
  {
    return null;
  }
  
  public final SurfaceTexture getSurfaceTexture()
  {
    com.tencent.mm.media.h.a locala = this.eWh;
    if (locala != null) {
      return locala.Vh();
    }
    return null;
  }
  
  public final int getTextureId()
  {
    com.tencent.mm.media.h.a locala = this.eWh;
    if (locala != null) {
      return locala.eYa;
    }
    return -1;
  }
  
  public final void release()
  {
    this.fbQ.e((a.f.a.a)new a.b(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.a.a
 * JD-Core Version:    0.7.0.1
 */