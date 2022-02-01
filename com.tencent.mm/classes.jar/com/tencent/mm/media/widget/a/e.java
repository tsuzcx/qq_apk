package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.tencent.mm.plugin.mmsight.model.g;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "", "onHDRCheckerResult", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "", "stepInterval", "configVendorTagValue", "tag", "", "value", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraOrientation", "getCurrentCameraId", "getFlashMode", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getSupportZoomRatios", "", "initCamera", "context", "Landroid/content/Context;", "useBack", "isCameraPreviewing", "onDestroy", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "setCameraPreviewFps", "fpsValue", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewDisplayRatio", "setReturnFrameCallback", "startPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "useCpuCrop", "resolutionLimit", "surface", "Landroid/view/SurfaceHolder;", "switchCamera", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public abstract interface e
{
  public static final e.a hqh = e.a.hqi;
  
  public abstract void A(String paramString, boolean paramBoolean);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt);
  
  public abstract void a(g paramg);
  
  public abstract void aa(String paramString, int paramInt);
  
  public abstract boolean avZ();
  
  public abstract boolean awa();
  
  public abstract boolean awb();
  
  public abstract void awc();
  
  public abstract void awk();
  
  public abstract b awl();
  
  public abstract int awp();
  
  public abstract int awq();
  
  public abstract void awr();
  
  public abstract void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  public abstract void b(g paramg);
  
  public abstract Point ei(boolean paramBoolean);
  
  public abstract void ej(boolean paramBoolean);
  
  public abstract int getFlashMode();
  
  public abstract float[] getSupportZoomRatios();
  
  public abstract void j(boolean paramBoolean, int paramInt);
  
  public abstract boolean n(d.g.a.b<? super Bitmap, z> paramb);
  
  public abstract void nW(int paramInt);
  
  public abstract void o(d.g.a.b<? super Boolean, z> paramb);
  
  public abstract void onDestroy();
  
  public abstract void release();
  
  public abstract boolean s(Context paramContext, boolean paramBoolean);
  
  public abstract void setDisplayScreenSize(Size paramSize);
  
  public abstract void setFlashMode(int paramInt);
  
  public abstract void setForceZoomTargetRatio(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.e
 * JD-Core Version:    0.7.0.1
 */