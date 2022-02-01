package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.a;
import com.tencent.mm.plugin.mmsight.model.g;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "clearFrame", "", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "ignoreRender", "ignore", "", "release", "setOnDrawListener", "frameAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"})
public abstract interface e
  extends f
{
  public abstract void a(a parama, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.media.widget.a.b paramb);
  
  public abstract void amB();
  
  public abstract void amC();
  
  public abstract void d(d.g.a.b<? super SurfaceTexture, z> paramb);
  
  public abstract EGLContext getEGLContext();
  
  public abstract g getFrameDataCallback();
  
  public abstract d getPreviewTexture();
  
  public abstract void release();
  
  public abstract void setOnDrawListener(d.g.a.b<? super d, z> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.e
 * JD-Core Version:    0.7.0.1
 */