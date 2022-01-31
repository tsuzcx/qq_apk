package com.tencent.mm.media.widget.a;

import a.f.b.j;
import a.l;
import a.l.m;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.SurfaceHolder;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.mo.b;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG_SETTING", "getTAG_SETTING", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "hasShownErrorTip", "", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "surface", "Landroid/view/SurfaceHolder;", "getSurface", "()Landroid/view/SurfaceHolder;", "setSurface", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "()Z", "setUseBackCamera", "(Z)V", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "initCamera", "useBack", "isBackCamera", "isCameraPreviewing", "release", "", "showCameraErrorTips", "startPreview", "switchCamera", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a
  implements e
{
  final String TAG;
  private SurfaceTexture bbI;
  Context context;
  final String eZH;
  private final int eZI;
  private boolean eZJ;
  boolean eZK;
  private a.a eZL;
  boolean eZM;
  p eZN;
  b eZO;
  private SurfaceHolder eZP;
  private int eZQ;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = "MicroMsg.CommonCamera1";
    this.eZH = "MicroMsg.MMSightCameraSetting";
    this.eZI = 8;
    this.eZK = true;
    this.eZL = a.a.eZR;
    this.eZM = true;
    paramContext = p.bRh();
    j.p(paramContext, "RecordParams.getBigSightDefault()");
    this.eZN = paramContext;
    this.eZO = b.eZX;
    this.eZQ = 40000;
  }
  
  protected final void WM()
  {
    if ((this.eZJ) || (this.context == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((m.I(Build.MANUFACTURER, "meizu", true)) && (!com.tencent.mm.compatible.f.b.Me()));
      localObject = new mo();
      ((mo)localObject).cCK.type = 2;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (((mo)localObject).cCL.cCJ)
      {
        this.eZJ = true;
        return;
      }
      localObject = h.h(this.context, 2131303686, 2131297087);
    } while (localObject == null);
    ((c)localObject).setCancelable(false);
    ((c)localObject).setCanceledOnTouchOutside(false);
    ((c)localObject).show();
    this.eZJ = true;
  }
  
  public final boolean WN()
  {
    boolean bool = false;
    if ((this.bbI == null) && (this.eZP == null))
    {
      ab.e(this.TAG, " do you forget override func startPreview");
      return false;
    }
    release();
    Object localObject = this.context;
    if (localObject == null) {
      j.ebi();
    }
    if (!this.eZK) {
      bool = true;
    }
    p((Context)localObject, bool);
    ab.i(this.TAG, "useCpuCrop : " + this.eZM + " , resolutionLimit: " + this.eZQ);
    if (this.bbI == null)
    {
      localObject = this.eZP;
      if (localObject == null) {
        j.ebi();
      }
      a((SurfaceHolder)localObject, this.eZM, this.eZQ);
      return this.eZK;
    }
    localObject = this.bbI;
    if (localObject == null) {
      j.ebi();
    }
    a((SurfaceTexture)localObject, this.eZM, this.eZQ);
    return this.eZK;
  }
  
  public final boolean WO()
  {
    return this.eZL == a.a.eZS;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    this.bbI = paramSurfaceTexture;
    this.eZM = paramBoolean;
    this.eZQ = paramInt;
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    this.eZP = paramSurfaceHolder;
    this.eZM = paramBoolean;
    this.eZQ = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    j.q(parama, "<set-?>");
    this.eZL = parama;
  }
  
  public boolean p(Context paramContext, boolean paramBoolean)
  {
    j.q(paramContext, "context");
    this.eZK = paramBoolean;
    return true;
  }
  
  public void release()
  {
    this.eZL = a.a.eZR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a
 * JD-Core Version:    0.7.0.1
 */