package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.plugin.mmsight.model.g;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "", "onHDRCheckerResult", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ret", "", "getOnHDRCheckerResult", "()Lkotlin/jvm/functions/Function1;", "setOnHDRCheckerResult", "(Lkotlin/jvm/functions/Function1;)V", "addFrameDataCallback", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "", "stepInterval", "calculateTapArea", "Landroid/graphics/Rect;", "x", "", "y", "coefficient", "surfaceWidth", "surfaceHeight", "checkCameraOpenSucc", "scene", "configVendorTagValue", "tag", "", "value", "focusOnArea", "focusArea", "meteringArea", "focusOnFace", "faceLocation", "", "isClickScreen", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraCurrentFocusMode", "getCameraOrientation", "getCameraPreviewFps", "getCurrentCameraId", "getFlashMode", "getPreviewSize", "Landroid/graphics/Point;", "cropSizeIfCan", "getSupportZoomRatios", "", "initCamera", "context", "Landroid/content/Context;", "useBack", "initCameraDeviceConfig", "deviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "isCameraPreviewing", "onDestroy", "postFocusOnTouch", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setCameraPreviewFps", "fpsValue", "setDisplayScreenSize", "screenSize", "Landroid/util/Size;", "setFlashMode", "mode", "setFlashOn", "isOn", "setForceZoomTargetRatio", "ratio", "setPreviewDisplayRatio", "setReturnFrameCallback", "startPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "useCpuCrop", "longSideLimit", "(Landroid/graphics/SurfaceTexture;ZLjava/lang/Float;I)V", "resolutionLimit", "surface", "Landroid/view/SurfaceHolder;", "switchCamera", "switchRecordStream", "switchVendorTag", "isChecked", "takePhoto", "dataCallback", "Landroid/graphics/Bitmap;", "bitmap", "triggerAutoFocus", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
{
  public static final f.a nGE = f.a.nGF;
  
  public abstract boolean A(Context paramContext, boolean paramBoolean);
  
  public abstract void G(String paramString, boolean paramBoolean);
  
  public abstract boolean H(kotlin.g.a.b<? super Bitmap, ah> paramb);
  
  public abstract void I(kotlin.g.a.b<? super Boolean, ah> paramb);
  
  public abstract Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt);
  
  public abstract void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, Float paramFloat, int paramInt);
  
  public abstract void a(b.a parama);
  
  public abstract void a(g paramg);
  
  public abstract void aE(String paramString, int paramInt);
  
  public abstract void b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2);
  
  public abstract void b(g paramg);
  
  public abstract int boh();
  
  public abstract boolean bsC();
  
  public abstract boolean bsD();
  
  public abstract boolean bsE();
  
  public abstract void bsF();
  
  public abstract int bsG();
  
  public abstract boolean bsH();
  
  public abstract void btb();
  
  public abstract b btc();
  
  public abstract int btf();
  
  public abstract String btg();
  
  public abstract boolean bth();
  
  public abstract int ev(int paramInt1, int paramInt2);
  
  public abstract boolean f(Rect paramRect1, Rect paramRect2);
  
  public abstract int getFlashMode();
  
  public abstract float[] getSupportZoomRatios();
  
  public abstract Point gx(boolean paramBoolean);
  
  public abstract void gy(boolean paramBoolean);
  
  public abstract void h(boolean paramBoolean, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract void release();
  
  public abstract void setDisplayScreenSize(Size paramSize);
  
  public abstract void setFlashMode(int paramInt);
  
  public abstract void setForceZoomTargetRatio(float paramFloat);
  
  public abstract boolean uh(int paramInt);
  
  public abstract void up(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.f
 * JD-Core Version:    0.7.0.1
 */