package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.oj.b;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import d.g.b.k;
import d.l;
import d.n.n;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "TAG", "", "TAG_SETTING", "getTAG_SETTING", "()Ljava/lang/String;", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "customDisplayScreenSize", "Landroid/util/Size;", "getCustomDisplayScreenSize", "()Landroid/util/Size;", "setCustomDisplayScreenSize", "(Landroid/util/Size;)V", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "hasShownErrorTip", "", "isReturnFrameCallbackAny", "()Z", "setReturnFrameCallbackAny", "(Z)V", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "surfaceHolder", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "setUseBackCamera", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "initCamera", "useBack", "isBackCamera", "isCameraPreviewing", "onDestroy", "", "release", "setDisplayScreenSize", "screenSize", "setPreviewDisplayRatio", "ratio", "setReturnFrameCallback", "value", "showCameraErrorTips", "startPreview", "surface", "switchCamera", "switchRecordStream", "takePhoto", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a
  implements e
{
  private final String TAG;
  private SurfaceHolder aTK;
  protected Context context;
  protected final String gWT;
  private final int gWU;
  private boolean gWV;
  protected boolean gWW;
  private a.a gWX;
  protected boolean gWY;
  float gWZ;
  boolean gXa;
  protected q gXb;
  protected b gXc;
  private int gXd;
  protected Size gXe;
  protected SurfaceTexture surfaceTexture;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = "MicroMsg.BaseCommonCamera";
    this.gWT = "MicroMsg.MMSightCameraSetting";
    this.gWU = 8;
    this.gWW = true;
    this.gWX = a.a.gXf;
    this.gWY = true;
    paramContext = q.ddJ();
    k.g(paramContext, "RecordParams.getBigSightDefault()");
    this.gXb = paramContext;
    this.gXc = b.gXn;
    this.gXd = 40000;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.gWY = paramBoolean;
    this.gXd = paramInt;
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    this.aTK = paramSurfaceHolder;
    this.gWY = paramBoolean;
    this.gXd = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    k.h(parama, "<set-?>");
    this.gWX = parama;
  }
  
  protected final void atl()
  {
    if ((this.gWV) || (this.context == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((n.I(Build.MANUFACTURER, "meizu", true)) && (!com.tencent.mm.compatible.d.b.Yz()));
      localObject = new oj();
      ((oj)localObject).dqS.type = 2;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if (((oj)localObject).dqT.dqR)
      {
        this.gWV = true;
        return;
      }
      localObject = h.l(this.context, 2131763668, 2131755906);
    } while (localObject == null);
    ((d)localObject).setCancelable(false);
    ((d)localObject).setCanceledOnTouchOutside(false);
    ((d)localObject).show();
    this.gWV = true;
  }
  
  public final boolean atm()
  {
    boolean bool = false;
    if ((this.surfaceTexture == null) && (this.aTK == null))
    {
      ac.e(this.TAG, " do you forget override func startPreview");
      return false;
    }
    if (!atn())
    {
      ac.e(this.TAG, " now is cpature image and refuse to switchCamera");
      return false;
    }
    release();
    Object localObject = this.context;
    if (localObject == null) {
      k.fOy();
    }
    if (!this.gWW) {
      bool = true;
    }
    q((Context)localObject, bool);
    ac.i(this.TAG, "useCpuCrop : " + this.gWY + " , resolutionLimit: " + this.gXd);
    if (this.surfaceTexture == null)
    {
      localObject = this.aTK;
      if (localObject == null) {
        k.fOy();
      }
      a((SurfaceHolder)localObject, this.gWY, this.gXd);
      return this.gWW;
    }
    localObject = this.surfaceTexture;
    if (localObject == null) {
      k.fOy();
    }
    a((SurfaceTexture)localObject, this.gWY, this.gXd);
    return this.gWW;
  }
  
  public final boolean atn()
  {
    return this.gWX == a.a.gXg;
  }
  
  public boolean ato()
  {
    return false;
  }
  
  public final void atp()
  {
    this.gXa = true;
  }
  
  public boolean m(d.g.a.b<? super Bitmap, y> paramb)
  {
    k.h(paramb, "dataCallback");
    return false;
  }
  
  public void onDestroy() {}
  
  public boolean q(Context paramContext, boolean paramBoolean)
  {
    k.h(paramContext, "context");
    this.gWW = paramBoolean;
    return true;
  }
  
  public void release()
  {
    this.gWX = a.a.gXf;
  }
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.gXe = paramSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a
 * JD-Core Version:    0.7.0.1
 */