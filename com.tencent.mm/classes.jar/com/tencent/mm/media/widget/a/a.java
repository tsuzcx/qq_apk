package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.mm.f.a.qj;
import com.tencent.mm.f.a.qj.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.plugin.t.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "DEFAULT_UPPER_BOUND", "getDEFAULT_UPPER_BOUND", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "", "TAG_SETTING", "getTAG_SETTING", "()Ljava/lang/String;", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraDeviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "getCameraDeviceConfig", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "setCameraDeviceConfig", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "customDisplayScreenSize", "Landroid/util/Size;", "getCustomDisplayScreenSize", "()Landroid/util/Size;", "setCustomDisplayScreenSize", "(Landroid/util/Size;)V", "displayRatio", "getDisplayRatio", "setDisplayRatio", "hasShownErrorTip", "", "isCameraOpen", "()Z", "setCameraOpen", "(Z)V", "isReturnFrameCallbackAny", "setReturnFrameCallbackAny", "isZooming", "setZooming", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "ratio", "getRatio", "()Ljava/lang/Float;", "setRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "surfaceHolder", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "setUseBackCamera", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "checkCameraOpenSucc", "scene", "focusOnFace", "faceLocation", "", "isClickScreen", "getCameraPreviewFps", "getCameraSensorRotate", "getDisplaySize", "getSupportPreviewSize", "", "()[Landroid/util/Size;", "initCamera", "useBack", "initCameraDeviceConfig", "", "deviceConfig", "isBackCamera", "isCameraPreviewing", "onDestroy", "release", "selectNoCropPreviewSize", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setDisplayScreenSize", "screenSize", "setPreviewDisplayRatio", "setPreviewSize", "width", "height", "setReturnFrameCallback", "value", "showCameraErrorTips", "startPreview", "surface", "switchCamera", "switchRecordStream", "takePhoto", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a
  implements e
{
  private final String TAG;
  private boolean aHx;
  private SurfaceHolder aNC;
  private Context context;
  private b knv;
  private final String laH;
  private final int laI;
  private final int laJ;
  public final com.tencent.mm.media.widget.a.a.a laK;
  private boolean laL;
  protected boolean laM;
  private a.a laN;
  private boolean laO;
  private float laP;
  private boolean laQ;
  protected com.tencent.mm.plugin.mmsight.model.p laR;
  protected b.a laS;
  private int laT;
  public Size laU;
  private Float laV;
  protected Point laW;
  private int laX;
  private int laY;
  private boolean laZ;
  private SurfaceTexture surfaceTexture;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = "MicroMsg.BaseCommonCamera";
    this.laH = "MicroMsg.MMSightCameraSetting";
    this.laI = 2100;
    this.laJ = 8;
    paramContext = Looper.getMainLooper();
    kotlin.g.b.p.j(paramContext, "Looper.getMainLooper()");
    this.laK = new com.tencent.mm.media.widget.a.a.a(paramContext, this.context, (e)this);
    this.laM = true;
    this.laN = a.a.lba;
    this.laO = true;
    paramContext = com.tencent.mm.plugin.mmsight.model.p.eTA();
    kotlin.g.b.p.j(paramContext, "RecordParams.getBigSightDefault()");
    this.laR = paramContext;
    this.knv = b.lbh;
    this.laT = 40000;
    this.laX = -1;
    this.laY = -1;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.laO = paramBoolean;
    this.laT = paramInt;
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    this.aNC = paramSurfaceHolder;
    this.laO = paramBoolean;
    this.laT = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    kotlin.g.b.p.k(parama, "<set-?>");
    this.laN = parama;
  }
  
  public final void a(b.a parama)
  {
    kotlin.g.b.p.k(parama, "deviceConfig");
    this.laS = parama;
  }
  
  protected final void a(Float paramFloat)
  {
    this.laV = paramFloat;
  }
  
  protected final String aXE()
  {
    return this.laH;
  }
  
  protected final int aXF()
  {
    return this.laI;
  }
  
  protected final boolean aXG()
  {
    return this.laO;
  }
  
  protected final boolean aXH()
  {
    return this.laQ;
  }
  
  protected final b aXI()
  {
    return this.knv;
  }
  
  protected final Float aXJ()
  {
    return this.laV;
  }
  
  protected final int aXK()
  {
    return this.laX;
  }
  
  protected final boolean aXL()
  {
    return this.aHx;
  }
  
  protected final int aXM()
  {
    return this.laY;
  }
  
  protected final boolean aXN()
  {
    return this.laZ;
  }
  
  protected final void aXO()
  {
    if ((this.laL) || (this.context == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((n.L(Build.MANUFACTURER, "meizu", true)) && (!com.tencent.mm.compatible.e.b.avv()));
      localObject = new qj();
      ((qj)localObject).fPf.type = 2;
      EventCenter.instance.publish((IEvent)localObject);
      if (((qj)localObject).fPg.fPe)
      {
        this.laL = true;
        return;
      }
      localObject = com.tencent.mm.ui.base.h.p(this.context, a.b.short_video_no_record_video_permission, a.b.app_tip);
    } while (localObject == null);
    ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).show();
    this.laL = true;
  }
  
  public final boolean aXP()
  {
    boolean bool = false;
    if ((this.surfaceTexture == null) && (this.aNC == null))
    {
      Log.e(this.TAG, " do you forget override func startPreview");
      return false;
    }
    if (!aXQ())
    {
      Log.e(this.TAG, " now is cpature image and refuse to switchCamera");
      return false;
    }
    release();
    Object localObject = this.context;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    if (!this.laM) {
      bool = true;
    }
    y((Context)localObject, bool);
    Log.i(this.TAG, "useCpuCrop : " + this.laO + " , resolutionLimit: " + this.laT);
    if (this.surfaceTexture == null)
    {
      localObject = this.aNC;
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      a((SurfaceHolder)localObject, this.laO, this.laT);
      return this.laM;
    }
    localObject = this.surfaceTexture;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    a((SurfaceTexture)localObject, this.laO, this.laV, this.laT);
    return this.laM;
  }
  
  public final boolean aXQ()
  {
    return this.laN == a.a.lbb;
  }
  
  public boolean aXR()
  {
    return false;
  }
  
  public final void aXS()
  {
    this.laQ = true;
  }
  
  public int aXT()
  {
    return 0;
  }
  
  public boolean aXU()
  {
    return false;
  }
  
  public abstract boolean aXV();
  
  public abstract Size[] aXW();
  
  public final Point aXX()
  {
    if (this.laU == null)
    {
      localObject = com.tencent.mm.plugin.mmsight.d.hv(this.context);
      kotlin.g.b.p.j(localObject, "MMSightUtil.getDisplaySize(context)");
      return localObject;
    }
    Object localObject = this.laU;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    int i = ((Size)localObject).getWidth();
    localObject = this.laU;
    if (localObject == null) {
      kotlin.g.b.p.iCn();
    }
    return new Point(i, ((Size)localObject).getHeight());
  }
  
  public int dB(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public abstract boolean dC(int paramInt1, int paramInt2);
  
  protected final void fG(boolean paramBoolean)
  {
    this.aHx = paramBoolean;
  }
  
  protected final void fH(boolean paramBoolean)
  {
    this.laZ = paramBoolean;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final float getDisplayRatio()
  {
    return this.laP;
  }
  
  protected final SurfaceTexture getSurfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  public boolean n(kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    kotlin.g.b.p.k(paramb, "dataCallback");
    return false;
  }
  
  public final void onDestroy()
  {
    Object localObject = this.laK;
    com.tencent.mm.media.widget.b.e locale = ((com.tencent.mm.media.widget.a.a.a)localObject).lbO;
    if (locale != null) {
      locale.release();
    }
    localObject = ((com.tencent.mm.media.widget.a.a.a)localObject).lbM;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
  }
  
  public void release()
  {
    this.laN = a.a.lba;
  }
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.laU = paramSize;
  }
  
  protected final void uh(int paramInt)
  {
    this.laX = paramInt;
  }
  
  public boolean ui(int paramInt)
  {
    return false;
  }
  
  public boolean uj(int paramInt)
  {
    try
    {
      boolean bool = aXV();
      Point localPoint = aXX();
      Size[] arrayOfSize = aXW();
      if (arrayOfSize == null)
      {
        Log.e(this.TAG, "fuck, preview size null!!");
        return false;
      }
      Object localObject2 = com.tencent.mm.plugin.mmsight.model.h.b(arrayOfSize, localPoint, paramInt, bool);
      Object localObject1 = localObject2;
      if (((h.c)localObject2).EZN == null)
      {
        Log.e(this.TAG, "fuck, preview size still null!!");
        localObject1 = com.tencent.mm.plugin.mmsight.model.h.a(arrayOfSize, new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y)), this.laI, bool);
      }
      if (((h.c)localObject1).EZN == null)
      {
        Log.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject1).toString() });
        ((h.c)localObject1).EZN = ((h.c)localObject1).EZQ;
        ((h.c)localObject1).EZO = ((h.c)localObject1).EZR;
        ((h.c)localObject1).EZP = ((h.c)localObject1).EZS;
      }
      localObject2 = new Size(((h.c)localObject1).EZN.x, ((h.c)localObject1).EZN.y);
      this.laR.wAw = ((Size)localObject2).getWidth();
      this.laR.wAx = ((Size)localObject2).getHeight();
      if (((h.c)localObject1).EZP != null) {
        this.laW = ((h.c)localObject1).EZP;
      }
      dC(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight());
      Log.i(this.TAG, "final set camera preview size: " + localObject2 + ", cropSize: " + this.laW);
      return true;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localCameraAccessException, "selectNoCropPreviewSize Exception by camera access exception, %s, %s", new Object[] { Looper.myLooper(), localCameraAccessException.getMessage() });
      return false;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localException, "selectNoCropPreviewSize Exception, %s, %s", new Object[] { Looper.myLooper(), localException.getMessage() });
    }
    return false;
  }
  
  public boolean y(Context paramContext, boolean paramBoolean)
  {
    kotlin.g.b.p.k(paramContext, "context");
    this.laM = paramBoolean;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a
 * JD-Core Version:    0.7.0.1
 */