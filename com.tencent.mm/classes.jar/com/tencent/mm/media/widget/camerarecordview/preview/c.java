package com.tencent.mm.media.widget.camerarecordview.preview;

import a.l;
import a.y;
import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.mm.media.h.a;
import com.tencent.mm.plugin.mmsight.model.f;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "clearFrame", "", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTextureId", "", "release", "setOnDrawListener", "frameAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"})
public abstract interface c
  extends d
{
  public abstract void Xk();
  
  public abstract void Xl();
  
  public abstract void a(a parama, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.media.widget.a.b paramb);
  
  public abstract void e(a.f.a.b<? super SurfaceTexture, y> paramb);
  
  public abstract EGLContext getEGLContext();
  
  public abstract f getFrameDataCallback();
  
  public abstract int getPreviewTextureId();
  
  public abstract void release();
  
  public abstract void setOnDrawListener(a.f.a.b<? super Integer, y> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.c
 * JD-Core Version:    0.7.0.1
 */