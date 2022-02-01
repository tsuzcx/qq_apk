package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.tencent.mm.plugin.mmsight.model.g;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "", "onHDRCheckerResult", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "", "stepInterval", "configVendorTagValue", "tag", "", "value", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraOrientation", "getCurrentCameraId", "getFlashMode", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getSupportZoomRatios", "", "initCamera", "context", "Landroid/content/Context;", "useBack", "isCameraPreviewing", "onDestroy", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "setCameraPreviewFps", "fpsValue", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewDisplayRatio", "setReturnFrameCallback", "startPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "useCpuCrop", "resolutionLimit", "surface", "Landroid/view/SurfaceHolder;", "switchCamera", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public abstract interface e
{
  public static final e.a gxD = e.a.gxE;
  
  public abstract void R(String paramString, int paramInt);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt);
  
  public abstract void a(g paramg);
  
  public abstract void amF();
  
  public abstract b amG();
  
  public abstract int amK();
  
  public abstract int amL();
  
  public abstract boolean amu();
  
  public abstract boolean amv();
  
  public abstract boolean amw();
  
  public abstract void amx();
  
  public abstract void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  public abstract void b(g paramg);
  
  public abstract Point dL(boolean paramBoolean);
  
  public abstract void dM(boolean paramBoolean);
  
  public abstract void fQG();
  
  public abstract int getFlashMode();
  
  public abstract float[] getSupportZoomRatios();
  
  public abstract boolean h(d.g.a.b<? super Bitmap, y> paramb);
  
  public abstract void i(d.g.a.b<? super Boolean, y> paramb);
  
  public abstract void i(boolean paramBoolean, int paramInt);
  
  public abstract void mJ(int paramInt);
  
  public abstract void onDestroy();
  
  public abstract boolean q(Context paramContext, boolean paramBoolean);
  
  public abstract void release();
  
  public abstract void setDisplayScreenSize(Size paramSize);
  
  public abstract void setFlashMode(int paramInt);
  
  public abstract void setForceZoomTargetRatio(float paramFloat);
  
  public abstract void z(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.e
 * JD-Core Version:    0.7.0.1
 */