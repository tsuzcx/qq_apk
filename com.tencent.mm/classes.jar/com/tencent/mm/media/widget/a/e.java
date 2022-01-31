package com.tencent.mm.media.widget.a;

import a.l;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.mmsight.model.f;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "", "addFrameDataCallback", "", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "", "stepInterval", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "", "initCamera", "context", "Landroid/content/Context;", "useBack", "isCameraPreviewing", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "startPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "useCpuCrop", "resolutionLimit", "surface", "Landroid/view/SurfaceHolder;", "switchCamera", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public abstract interface e
{
  public static final e.a faI = e.a.faJ;
  
  public abstract boolean WN();
  
  public abstract boolean WO();
  
  public abstract void WW();
  
  public abstract b WX();
  
  public abstract Point WY();
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt);
  
  public abstract void a(f paramf);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  public abstract void b(f paramf);
  
  public abstract void kh(int paramInt);
  
  public abstract boolean p(Context paramContext, boolean paramBoolean);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.e
 * JD-Core Version:    0.7.0.1
 */