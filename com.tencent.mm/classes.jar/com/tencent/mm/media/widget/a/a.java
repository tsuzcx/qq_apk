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
import com.tencent.mm.autogen.a.rw;
import com.tencent.mm.autogen.a.rw.b;
import com.tencent.mm.media.widget.camerarecordview.d.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.mmsight.model.h.c;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.t.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "DEFAULT_UPPER_BOUND", "getDEFAULT_UPPER_BOUND", "SMALL_ZOOM_STEP_VAL", "", "getSMALL_ZOOM_STEP_VAL", "()F", "setSMALL_ZOOM_STEP_VAL", "(F)V", "TAG", "", "TAG_SETTING", "getTAG_SETTING", "()Ljava/lang/String;", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraDeviceConfig", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "getCameraDeviceConfig", "()Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;", "setCameraDeviceConfig", "(Lcom/tencent/mm/media/widget/camerarecordview/process/ICommonCameraContainer$CameraDeviceConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "cropSize", "Landroid/graphics/Point;", "getCropSize", "()Landroid/graphics/Point;", "setCropSize", "(Landroid/graphics/Point;)V", "customDisplayScreenSize", "Landroid/util/Size;", "getCustomDisplayScreenSize", "()Landroid/util/Size;", "setCustomDisplayScreenSize", "(Landroid/util/Size;)V", "displayRatio", "getDisplayRatio", "setDisplayRatio", "hasShownErrorTip", "", "isCameraOpen", "()Z", "setCameraOpen", "(Z)V", "isReturnFrameCallbackAny", "setReturnFrameCallbackAny", "isZooming", "setZooming", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "ratio", "getRatio", "()Ljava/lang/Float;", "setRatio", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "scrollSmallZoomStep", "getScrollSmallZoomStep", "setScrollSmallZoomStep", "sightHandler", "Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "getSightHandler", "()Lcom/tencent/mm/media/widget/camera/common/CameraHandler;", "smallZoomStep", "getSmallZoomStep", "setSmallZoomStep", "surfaceHolder", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "setUseBackCamera", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "checkCameraOpenSucc", "scene", "focusOnFace", "faceLocation", "", "isClickScreen", "getCameraPreviewFps", "getCameraSensorRotate", "getDisplaySize", "getSupportPreviewSize", "", "()[Landroid/util/Size;", "initCamera", "useBack", "initCameraDeviceConfig", "", "deviceConfig", "isBackCamera", "isCameraPreviewing", "onDestroy", "release", "selectNoCropPreviewSize", "setCameraDisplayOrientation", "cameraId", "mScreenRotation", "setDisplayScreenSize", "screenSize", "setPreviewDisplayRatio", "setPreviewSize", "width", "height", "setReturnFrameCallback", "value", "showCameraErrorTips", "startPreview", "surface", "switchCamera", "switchRecordStream", "takePhoto", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "CameraStatus", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements f
{
  private final String TAG;
  private SurfaceHolder cHy;
  private Context context;
  private boolean isZooming;
  private b mRv;
  private final String nFM;
  private final int nFN;
  private final int nFO;
  private final com.tencent.mm.media.widget.a.a.a nFP;
  private boolean nFQ;
  private boolean nFR;
  private a.a nFS;
  private boolean nFT;
  private float nFU;
  private boolean nFV;
  private p nFW;
  private b.a nFX;
  private int nFY;
  public Size nFZ;
  private Float nGa;
  private Point nGb;
  private int nGc;
  private int nGd;
  private boolean nGe;
  private SurfaceTexture surfaceTexture;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = "MicroMsg.BaseCommonCamera";
    this.nFM = "MicroMsg.MMSightCameraSetting";
    this.nFN = 2100;
    this.nFO = 8;
    paramContext = Looper.getMainLooper();
    s.s(paramContext, "getMainLooper()");
    this.nFP = new com.tencent.mm.media.widget.a.a.a(paramContext, this.context, (f)this);
    this.nFR = true;
    this.nFS = a.a.nGf;
    this.nFT = true;
    paramContext = p.gct();
    s.s(paramContext, "getBigSightDefault()");
    this.nFW = paramContext;
    this.mRv = b.nGj;
    this.nFY = 40000;
    this.nGc = -1;
    this.nGd = -1;
  }
  
  public boolean A(Context paramContext, boolean paramBoolean)
  {
    s.u(paramContext, "context");
    this.nFR = paramBoolean;
    return true;
  }
  
  public boolean H(kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    s.u(paramb, "dataCallback");
    return false;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.nFT = paramBoolean;
    this.nFY = paramInt;
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    this.cHy = paramSurfaceHolder;
    this.nFT = paramBoolean;
    this.nFY = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    s.u(parama, "<set-?>");
    this.nFS = parama;
  }
  
  public final void a(b.a parama)
  {
    s.u(parama, "deviceConfig");
    this.nFX = parama;
  }
  
  protected final void a(Float paramFloat)
  {
    this.nGa = paramFloat;
  }
  
  public final boolean boi()
  {
    return this.nFR;
  }
  
  protected final boolean bsA()
  {
    return this.nGe;
  }
  
  protected final void bsB()
  {
    if ((this.nFQ) || (this.context == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((n.T(Build.MANUFACTURER, "meizu", true)) && (!com.tencent.mm.compatible.e.b.aPP()));
      localObject = new rw();
      ((rw)localObject).hUY.type = 2;
      ((rw)localObject).publish();
      if (((rw)localObject).hUZ.hUX)
      {
        this.nFQ = true;
        return;
      }
      localObject = k.s(this.context, a.b.short_video_no_record_video_permission, a.b.app_tip);
    } while (localObject == null);
    ((com.tencent.mm.ui.widget.a.e)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.e)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.e)localObject).show();
    this.nFQ = true;
  }
  
  public final boolean bsC()
  {
    boolean bool = false;
    if ((this.surfaceTexture == null) && (this.cHy == null))
    {
      Log.e(this.TAG, " do you forget override func startPreview");
      return false;
    }
    if (!bsD())
    {
      Log.e(this.TAG, " now is cpature image and refuse to switchCamera");
      return false;
    }
    release();
    Object localObject = this.context;
    s.checkNotNull(localObject);
    if (!this.nFR) {
      bool = true;
    }
    A((Context)localObject, bool);
    Log.i(this.TAG, "useCpuCrop : " + this.nFT + " , resolutionLimit: " + this.nFY);
    if (this.surfaceTexture == null)
    {
      localObject = this.cHy;
      s.checkNotNull(localObject);
      a((SurfaceHolder)localObject, this.nFT, this.nFY);
      return this.nFR;
    }
    localObject = this.surfaceTexture;
    s.checkNotNull(localObject);
    a((SurfaceTexture)localObject, this.nFT, this.nGa, this.nFY);
    return this.nFR;
  }
  
  public final boolean bsD()
  {
    return this.nFS == a.a.nGg;
  }
  
  public boolean bsE()
  {
    return false;
  }
  
  public final void bsF()
  {
    this.nFV = true;
  }
  
  public int bsG()
  {
    return 0;
  }
  
  public boolean bsH()
  {
    return false;
  }
  
  public abstract boolean bsI();
  
  public abstract Size[] bsJ();
  
  public final Point bsK()
  {
    if (this.nFZ == null)
    {
      localObject = d.iQ(this.context);
      s.s(localObject, "getDisplaySize(context)");
      return localObject;
    }
    Object localObject = this.nFZ;
    s.checkNotNull(localObject);
    int i = ((Size)localObject).getWidth();
    localObject = this.nFZ;
    s.checkNotNull(localObject);
    return new Point(i, ((Size)localObject).getHeight());
  }
  
  protected final String bsm()
  {
    return this.nFM;
  }
  
  protected final int bsn()
  {
    return this.nFN;
  }
  
  public final com.tencent.mm.media.widget.a.a.a bso()
  {
    return this.nFP;
  }
  
  protected final boolean bsp()
  {
    return this.nFR;
  }
  
  protected final boolean bsq()
  {
    return this.nFT;
  }
  
  protected final boolean bsr()
  {
    return this.nFV;
  }
  
  protected final p bss()
  {
    return this.nFW;
  }
  
  protected final b bst()
  {
    return this.mRv;
  }
  
  protected final b.a bsu()
  {
    return this.nFX;
  }
  
  protected final Float bsv()
  {
    return this.nGa;
  }
  
  protected final Point bsw()
  {
    return this.nGb;
  }
  
  protected final int bsx()
  {
    return this.nGc;
  }
  
  protected final boolean bsy()
  {
    return this.isZooming;
  }
  
  protected final int bsz()
  {
    return this.nGd;
  }
  
  protected final void d(Point paramPoint)
  {
    this.nGb = paramPoint;
  }
  
  public int ev(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public abstract boolean ew(int paramInt1, int paramInt2);
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final float getDisplayRatio()
  {
    return this.nFU;
  }
  
  protected final SurfaceTexture getSurfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  protected final void gu(boolean paramBoolean)
  {
    this.isZooming = paramBoolean;
  }
  
  protected final void gv(boolean paramBoolean)
  {
    this.nGe = paramBoolean;
  }
  
  public final void onDestroy()
  {
    Object localObject = this.nFP;
    com.tencent.mm.media.widget.b.e locale = ((com.tencent.mm.media.widget.a.a.a)localObject).nGL;
    if (locale != null) {
      locale.release();
    }
    localObject = ((com.tencent.mm.media.widget.a.a.a)localObject).nGJ;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
  }
  
  public void release()
  {
    this.nFS = a.a.nGf;
  }
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.nFZ = paramSize;
  }
  
  protected final void ug(int paramInt)
  {
    this.nGc = paramInt;
  }
  
  public boolean uh(int paramInt)
  {
    return false;
  }
  
  public boolean ui(int paramInt)
  {
    try
    {
      boolean bool = bsI();
      Point localPoint = bsK();
      Size[] arrayOfSize = bsJ();
      if (arrayOfSize == null)
      {
        Log.e(this.TAG, "fuck, preview size null!!");
        return false;
      }
      Object localObject2 = h.b(arrayOfSize, localPoint, paramInt, bool);
      Object localObject1 = localObject2;
      if (((h.c)localObject2).KVz == null)
      {
        Log.e(this.TAG, "fuck, preview size still null!!");
        localObject1 = h.a(arrayOfSize, new Point(Math.min(localPoint.x, localPoint.y), Math.max(localPoint.x, localPoint.y)), this.nFN, bool);
      }
      if (((h.c)localObject1).KVz == null)
      {
        Log.i(this.TAG, "checkMore start %s", new Object[] { ((h.c)localObject1).toString() });
        ((h.c)localObject1).KVz = ((h.c)localObject1).KVC;
        ((h.c)localObject1).KVA = ((h.c)localObject1).KVD;
        ((h.c)localObject1).KVB = ((h.c)localObject1).KVE;
      }
      localObject2 = new Size(((h.c)localObject1).KVz.x, ((h.c)localObject1).KVz.y);
      this.nFW.zWH = ((Size)localObject2).getWidth();
      this.nFW.zWI = ((Size)localObject2).getHeight();
      if (((h.c)localObject1).KVB != null) {
        this.nGb = ((h.c)localObject1).KVB;
      }
      ew(((Size)localObject2).getWidth(), ((Size)localObject2).getHeight());
      Log.i(this.TAG, "final set camera preview size: " + localObject2 + ", cropSize: " + this.nGb);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a
 * JD-Core Version:    0.7.0.1
 */