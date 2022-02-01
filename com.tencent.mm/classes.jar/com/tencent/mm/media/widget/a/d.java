package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.plugin.mmsight.model.g;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "", "onHDRCheckerResult", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "", "stepInterval", "calculateTapArea", "Landroid/graphics/Rect;", "x", "", "y", "coefficient", "surfaceWidth", "surfaceHeight", "checkCameraOpenSucc", "scene", "configVendorTagValue", "tag", "", "value", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCurrentCameraId", "getFlashMode", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getSupportZoomRatios", "", "initCamera", "context", "Landroid/content/Context;", "useBack", "initCameraDeviceConfig", "deviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "isCameraPreviewing", "onDestroy", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewDisplayRatio", "setReturnFrameCallback", "startPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "useCpuCrop", "resolutionLimit", "surface", "Landroid/view/SurfaceHolder;", "switchCamera", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
public abstract interface d
{
  public static final d.a imA = d.a.imB;
  
  public abstract void B(String paramString, boolean paramBoolean);
  
  public abstract Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt);
  
  public abstract void a(b.a parama);
  
  public abstract void a(g paramg);
  
  public abstract boolean aPb();
  
  public abstract boolean aPc();
  
  public abstract boolean aPd();
  
  public abstract void aPe();
  
  public abstract int aPf();
  
  public abstract boolean aPg();
  
  public abstract void aPq();
  
  public abstract b aPr();
  
  public abstract int aPu();
  
  public abstract int aPv();
  
  public abstract String aPw();
  
  public abstract boolean aPx();
  
  public abstract void ad(String paramString, int paramInt);
  
  public abstract void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  public abstract void b(g paramg);
  
  public abstract boolean b(Rect paramRect1, Rect paramRect2);
  
  public abstract int df(int paramInt1, int paramInt2);
  
  public abstract Point fa(boolean paramBoolean);
  
  public abstract void fb(boolean paramBoolean);
  
  public abstract int getFlashMode();
  
  public abstract float[] getSupportZoomRatios();
  
  public abstract void i(boolean paramBoolean, int paramInt);
  
  public abstract boolean n(kotlin.g.a.b<? super Bitmap, x> paramb);
  
  public abstract void o(kotlin.g.a.b<? super Boolean, x> paramb);
  
  public abstract void onDestroy();
  
  public abstract void release();
  
  public abstract boolean rp(int paramInt);
  
  public abstract void rw(int paramInt);
  
  public abstract void setDisplayScreenSize(Size paramSize);
  
  public abstract void setFlashMode(int paramInt);
  
  public abstract void setForceZoomTargetRatio(float paramFloat);
  
  public abstract boolean v(Context paramContext, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.d
 * JD-Core Version:    0.7.0.1
 */