package com.tencent.mm.media.widget.camerarecordview.preview;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.a;
import com.tencent.mm.plugin.mmsight.model.g;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/IRenderVIew;", "clearFrame", "", "getEGLContext", "Landroid/opengl/EGLContext;", "getFrameDataCallback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "ignoreRender", "ignore", "", "release", "setOnDrawListener", "frameAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "setPreviewRenderer", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "cpuCrop", "tryCameraPreview", "callback", "Landroid/graphics/SurfaceTexture;", "tryStopCameraPreview", "updateCameraConfig", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
  extends c
{
  public abstract void a(a parama, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.media.widget.a.b paramb);
  
  public abstract void bgw();
  
  public abstract void bgx();
  
  public abstract EGLContext getEGLContext();
  
  public abstract g getFrameDataCallback();
  
  public abstract d getPreviewTexture();
  
  public abstract void release();
  
  public abstract void setOnDrawListener(kotlin.g.a.b<? super d, ah> paramb);
  
  public abstract void t(kotlin.g.a.b<? super SurfaceTexture, ah> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.preview.b
 * JD-Core Version:    0.7.0.1
 */