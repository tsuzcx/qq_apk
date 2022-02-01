package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ot.b;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import d.g.b.p;
import d.l;
import d.n.n;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "TAG", "", "TAG_SETTING", "getTAG_SETTING", "()Ljava/lang/String;", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "customDisplayScreenSize", "Landroid/util/Size;", "getCustomDisplayScreenSize", "()Landroid/util/Size;", "setCustomDisplayScreenSize", "(Landroid/util/Size;)V", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "hasShownErrorTip", "", "isReturnFrameCallbackAny", "()Z", "setReturnFrameCallbackAny", "(Z)V", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "surfaceHolder", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "setUseBackCamera", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "initCamera", "useBack", "isBackCamera", "isCameraPreviewing", "onDestroy", "", "release", "setDisplayScreenSize", "screenSize", "setPreviewDisplayRatio", "ratio", "setReturnFrameCallback", "value", "showCameraErrorTips", "startPreview", "surface", "switchCamera", "switchRecordStream", "takePhoto", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a
  implements e
{
  private final String TAG;
  private SurfaceHolder bee;
  protected Context context;
  protected final String hrN;
  private final int hrO;
  private boolean hrP;
  protected boolean hrQ;
  private a.a hrR;
  protected boolean hrS;
  float hrT;
  boolean hrU;
  protected q hrV;
  protected b hrW;
  private int hrX;
  protected Size hrY;
  protected SurfaceTexture surfaceTexture;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = "MicroMsg.BaseCommonCamera";
    this.hrN = "MicroMsg.MMSightCameraSetting";
    this.hrO = 8;
    this.hrQ = true;
    this.hrR = a.a.hrZ;
    this.hrS = true;
    paramContext = q.dqd();
    p.g(paramContext, "RecordParams.getBigSightDefault()");
    this.hrV = paramContext;
    this.hrW = b.hsh;
    this.hrX = 40000;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.hrS = paramBoolean;
    this.hrX = paramInt;
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    this.bee = paramSurfaceHolder;
    this.hrS = paramBoolean;
    this.hrX = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    p.h(parama, "<set-?>");
    this.hrR = parama;
  }
  
  protected final void awn()
  {
    if ((this.hrP) || (this.context == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((n.H(Build.MANUFACTURER, "meizu", true)) && (!com.tencent.mm.compatible.d.b.abk()));
      localObject = new ot();
      ((ot)localObject).dDO.type = 2;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if (((ot)localObject).dDP.dDN)
      {
        this.hrP = true;
        return;
      }
      localObject = h.l(this.context, 2131763668, 2131755906);
    } while (localObject == null);
    ((d)localObject).setCancelable(false);
    ((d)localObject).setCanceledOnTouchOutside(false);
    ((d)localObject).show();
    this.hrP = true;
  }
  
  public final boolean awo()
  {
    boolean bool = false;
    if ((this.surfaceTexture == null) && (this.bee == null))
    {
      ae.e(this.TAG, " do you forget override func startPreview");
      return false;
    }
    if (!awp())
    {
      ae.e(this.TAG, " now is cpature image and refuse to switchCamera");
      return false;
    }
    release();
    Object localObject = this.context;
    if (localObject == null) {
      p.gkB();
    }
    if (!this.hrQ) {
      bool = true;
    }
    s((Context)localObject, bool);
    ae.i(this.TAG, "useCpuCrop : " + this.hrS + " , resolutionLimit: " + this.hrX);
    if (this.surfaceTexture == null)
    {
      localObject = this.bee;
      if (localObject == null) {
        p.gkB();
      }
      a((SurfaceHolder)localObject, this.hrS, this.hrX);
      return this.hrQ;
    }
    localObject = this.surfaceTexture;
    if (localObject == null) {
      p.gkB();
    }
    a((SurfaceTexture)localObject, this.hrS, this.hrX);
    return this.hrQ;
  }
  
  public final boolean awp()
  {
    return this.hrR == a.a.hsa;
  }
  
  public boolean awq()
  {
    return false;
  }
  
  public final void awr()
  {
    this.hrU = true;
  }
  
  public boolean n(d.g.a.b<? super Bitmap, z> paramb)
  {
    p.h(paramb, "dataCallback");
    return false;
  }
  
  public void onDestroy() {}
  
  public void release()
  {
    this.hrR = a.a.hrZ;
  }
  
  public boolean s(Context paramContext, boolean paramBoolean)
  {
    p.h(paramContext, "context");
    this.hrQ = paramBoolean;
    return true;
  }
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.hrY = paramSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a
 * JD-Core Version:    0.7.0.1
 */