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
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pl.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "DEFAULT_UPPER_BOUND", "getDEFAULT_UPPER_BOUND", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "", "TAG_SETTING", "getTAG_SETTING", "()Ljava/lang/String;", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraDeviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "getCameraDeviceConfig", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "setCameraDeviceConfig", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "customDisplayScreenSize", "Landroid/util/Size;", "getCustomDisplayScreenSize", "()Landroid/util/Size;", "setCustomDisplayScreenSize", "(Landroid/util/Size;)V", "displayRatio", "getDisplayRatio", "setDisplayRatio", "hasShownErrorTip", "", "isCameraOpen", "()Z", "setCameraOpen", "(Z)V", "isReturnFrameCallbackAny", "setReturnFrameCallbackAny", "isZooming", "setZooming", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "surfaceHolder", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "setUseBackCamera", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "checkCameraOpenSucc", "scene", "focusOnFace", "faceLocation", "", "isClickScreen", "getCameraPreviewFps", "getCameraSensorRotate", "getDisplaySize", "getSupportPreviewSize", "", "()[Landroid/util/Size;", "initCamera", "useBack", "initCameraDeviceConfig", "", "deviceConfig", "isBackCamera", "isCameraPreviewing", "onDestroy", "release", "selectNoCropPreviewSize", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setDisplayScreenSize", "screenSize", "setPreviewDisplayRatio", "ratio", "setPreviewSize", "width", "height", "setReturnFrameCallback", "value", "showCameraErrorTips", "startPreview", "surface", "switchCamera", "switchRecordStream", "takePhoto", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a
  implements d
{
  private final String TAG;
  protected boolean aYc;
  private SurfaceHolder beb;
  protected Context context;
  protected b hAu;
  protected final String ilH;
  protected final int ilI;
  private final int ilJ;
  public final com.tencent.mm.media.widget.a.a.a ilK;
  private boolean ilL;
  protected boolean ilM;
  private a.a ilN;
  protected boolean ilO;
  float ilP;
  boolean ilQ;
  protected q ilR;
  protected b.a ilS;
  private int ilT;
  Size ilU;
  protected Point ilV;
  protected int ilW;
  int ilX;
  protected boolean ilY;
  protected SurfaceTexture surfaceTexture;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = "MicroMsg.BaseCommonCamera";
    this.ilH = "MicroMsg.MMSightCameraSetting";
    this.ilI = 2100;
    this.ilJ = 8;
    paramContext = Looper.getMainLooper();
    p.g(paramContext, "Looper.getMainLooper()");
    this.ilK = new com.tencent.mm.media.widget.a.a.a(paramContext, this.context, (d)this);
    this.ilM = true;
    this.ilN = a.a.ilZ;
    this.ilO = true;
    paramContext = q.ejT();
    p.g(paramContext, "RecordParams.getBigSightDefault()");
    this.ilR = paramContext;
    this.hAu = b.imh;
    this.ilT = 40000;
    this.ilW = -1;
    this.ilX = -1;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.ilO = paramBoolean;
    this.ilT = paramInt;
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    this.beb = paramSurfaceHolder;
    this.ilO = paramBoolean;
    this.ilT = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    p.h(parama, "<set-?>");
    this.ilN = parama;
  }
  
  public final void a(b.a parama)
  {
    p.h(parama, "deviceConfig");
    this.ilS = parama;
  }
  
  protected final void aPa()
  {
    if ((this.ilL) || (this.context == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((n.I(Build.MANUFACTURER, "meizu", true)) && (!com.tencent.mm.compatible.e.b.apj()));
      localObject = new pl();
      ((pl)localObject).dVC.type = 2;
      EventCenter.instance.publish((IEvent)localObject);
      if (((pl)localObject).dVD.dVB)
      {
        this.ilL = true;
        return;
      }
      localObject = com.tencent.mm.ui.base.h.n(this.context, 2131765857, 2131755998);
    } while (localObject == null);
    ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).show();
    this.ilL = true;
  }
  
  public final boolean aPb()
  {
    boolean bool = false;
    if ((this.surfaceTexture == null) && (this.beb == null))
    {
      Log.e(this.TAG, " do you forget override func startPreview");
      return false;
    }
    if (!aPc())
    {
      Log.e(this.TAG, " now is cpature image and refuse to switchCamera");
      return false;
    }
    release();
    Object localObject = this.context;
    if (localObject == null) {
      p.hyc();
    }
    if (!this.ilM) {
      bool = true;
    }
    v((Context)localObject, bool);
    Log.i(this.TAG, "useCpuCrop : " + this.ilO + " , resolutionLimit: " + this.ilT);
    if (this.surfaceTexture == null)
    {
      localObject = this.beb;
      if (localObject == null) {
        p.hyc();
      }
      a((SurfaceHolder)localObject, this.ilO, this.ilT);
      return this.ilM;
    }
    localObject = this.surfaceTexture;
    if (localObject == null) {
      p.hyc();
    }
    a((SurfaceTexture)localObject, this.ilO, this.ilT);
    return this.ilM;
  }
  
  public final boolean aPc()
  {
    return this.ilN == a.a.ima;
  }
  
  public boolean aPd()
  {
    return false;
  }
  
  public final void aPe()
  {
    this.ilQ = true;
  }
  
  public int aPf()
  {
    return 0;
  }
  
  public boolean aPg()
  {
    return false;
  }
  
  public abstract boolean aPh();
  
  public abstract Size[] aPi();
  
  public final Point aPj()
  {
    if (this.ilU == null)
    {
      localObject = com.tencent.mm.plugin.mmsight.d.gx(this.context);
      p.g(localObject, "MMSightUtil.getDisplaySize(context)");
      return localObject;
    }
    Object localObject = this.ilU;
    if (localObject == null) {
      p.hyc();
    }
    int i = ((Size)localObject).getWidth();
    localObject = this.ilU;
    if (localObject == null) {
      p.hyc();
    }
    return new Point(i, ((Size)localObject).getHeight());
  }
  
  public int df(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public abstract boolean dg(int paramInt1, int paramInt2);
  
  public boolean n(kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    p.h(paramb, "dataCallback");
    return false;
  }
  
  public final void onDestroy()
  {
    Object localObject = this.ilK;
    com.tencent.mm.media.widget.b.d locald = ((com.tencent.mm.media.widget.a.a.a)localObject).imN;
    if (locald != null) {
      locald.release();
    }
    localObject = ((com.tencent.mm.media.widget.a.a.a)localObject).imL;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
  }
  
  public void release()
  {
    this.ilN = a.a.ilZ;
  }
  
  public boolean rp(int paramInt)
  {
    return false;
  }
  
  public boolean rq(int paramInt)
  {
    try
    {
      boolean bool = aPh();
      Point localPoint = aPj();
      Size[] arrayOfSize = aPi();
      if (arrayOfSize == null)
      {
        Log.e(this.TAG, "fuck, preview size null!!");
        return false;
      }
      Object localObject2 = com.tencent.mm.plugin.mmsight.model.h.b(arrayOfSize, localPoint, paramInt, bool);
      Object localObject1 = localObject2;
      if (((h.c)localObject2).zum == null)
      {
        Log.e(this.TAG, "fuck, preview size still null!!");
        localObject1 = com.tencent.mm.plugin.mmsight.model.h.a(arrayOfSize, new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y)), this.ilI, bool);
      }
      if (((h.c)localObject1).zum == null)
      {
        Log.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject1).toString() });
        ((h.c)localObject1).zum = ((h.c)localObject1).zup;
        ((h.c)localObject1).zun = ((h.c)localObject1).zuq;
        ((h.c)localObject1).zuo = ((h.c)localObject1).zur;
      }
      localObject2 = new Size(((h.c)localObject1).zum.x, ((h.c)localObject1).zum.y);
      this.ilR.sUz = ((Size)localObject2).getWidth();
      this.ilR.sUA = ((Size)localObject2).getHeight();
      if (((h.c)localObject1).zuo != null) {
        this.ilV = ((h.c)localObject1).zuo;
      }
      dg(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight());
      Log.i(this.TAG, "final set camera preview size: " + localObject2 + ", cropSize: " + this.ilV);
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
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.ilU = paramSize;
  }
  
  public boolean v(Context paramContext, boolean paramBoolean)
  {
    p.h(paramContext, "context");
    this.ilM = paramBoolean;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a
 * JD-Core Version:    0.7.0.1
 */