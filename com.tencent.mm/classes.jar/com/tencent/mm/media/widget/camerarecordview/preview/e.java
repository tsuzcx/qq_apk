package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.a;
import com.tencent.mm.plugin.mmsight.model.g;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "clearFrame", "", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "ignoreRender", "ignore", "", "release", "setOnDrawListener", "frameAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"})
public abstract interface e
  extends f
{
  public abstract void a(a parama, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.media.widget.a.b paramb);
  
  public abstract void aMM();
  
  public abstract void aMN();
  
  public abstract void d(kotlin.g.a.b<? super SurfaceTexture, x> paramb);
  
  public abstract EGLContext getEGLContext();
  
  public abstract g getFrameDataCallback();
  
  public abstract d getPreviewTexture();
  
  public abstract void release();
  
  public abstract void setOnDrawListener(kotlin.g.a.b<? super d, x> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.e
 * JD-Core Version:    0.7.0.1
 */