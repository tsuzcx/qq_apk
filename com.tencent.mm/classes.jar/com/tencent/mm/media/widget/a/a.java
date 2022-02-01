package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.os.b;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import d.g.b.p;
import d.l;
import d.n.n;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "TAG", "", "TAG_SETTING", "getTAG_SETTING", "()Ljava/lang/String;", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "customDisplayScreenSize", "Landroid/util/Size;", "getCustomDisplayScreenSize", "()Landroid/util/Size;", "setCustomDisplayScreenSize", "(Landroid/util/Size;)V", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "hasShownErrorTip", "", "isReturnFrameCallbackAny", "()Z", "setReturnFrameCallbackAny", "(Z)V", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "surfaceHolder", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "setUseBackCamera", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "initCamera", "useBack", "isBackCamera", "isCameraPreviewing", "onDestroy", "", "release", "setDisplayScreenSize", "screenSize", "setPreviewDisplayRatio", "ratio", "setReturnFrameCallback", "value", "showCameraErrorTips", "startPreview", "surface", "switchCamera", "switchRecordStream", "takePhoto", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a
  implements e
{
  private final String TAG;
  private SurfaceHolder bee;
  protected Context context;
  protected final String hoZ;
  private final int hpa;
  private boolean hpb;
  protected boolean hpc;
  private a.a hpd;
  protected boolean hpe;
  float hpf;
  boolean hpg;
  protected q hph;
  protected b hpi;
  private int hpj;
  protected Size hpk;
  protected SurfaceTexture surfaceTexture;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = "MicroMsg.BaseCommonCamera";
    this.hoZ = "MicroMsg.MMSightCameraSetting";
    this.hpa = 8;
    this.hpc = true;
    this.hpd = a.a.hpl;
    this.hpe = true;
    paramContext = q.dnf();
    p.g(paramContext, "RecordParams.getBigSightDefault()");
    this.hph = paramContext;
    this.hpi = b.hpt;
    this.hpj = 40000;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.hpe = paramBoolean;
    this.hpj = paramInt;
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    this.bee = paramSurfaceHolder;
    this.hpe = paramBoolean;
    this.hpj = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    p.h(parama, "<set-?>");
    this.hpd = parama;
  }
  
  protected final void avY()
  {
    if ((this.hpb) || (this.context == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((n.H(Build.MANUFACTURER, "meizu", true)) && (!com.tencent.mm.compatible.d.b.abb()));
      localObject = new os();
      ((os)localObject).dCJ.type = 2;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((os)localObject).dCK.dCI)
      {
        this.hpb = true;
        return;
      }
      localObject = h.l(this.context, 2131763668, 2131755906);
    } while (localObject == null);
    ((d)localObject).setCancelable(false);
    ((d)localObject).setCanceledOnTouchOutside(false);
    ((d)localObject).show();
    this.hpb = true;
  }
  
  public final boolean avZ()
  {
    boolean bool = false;
    if ((this.surfaceTexture == null) && (this.bee == null))
    {
      ad.e(this.TAG, " do you forget override func startPreview");
      return false;
    }
    if (!awa())
    {
      ad.e(this.TAG, " now is cpature image and refuse to switchCamera");
      return false;
    }
    release();
    Object localObject = this.context;
    if (localObject == null) {
      p.gfZ();
    }
    if (!this.hpc) {
      bool = true;
    }
    s((Context)localObject, bool);
    ad.i(this.TAG, "useCpuCrop : " + this.hpe + " , resolutionLimit: " + this.hpj);
    if (this.surfaceTexture == null)
    {
      localObject = this.bee;
      if (localObject == null) {
        p.gfZ();
      }
      a((SurfaceHolder)localObject, this.hpe, this.hpj);
      return this.hpc;
    }
    localObject = this.surfaceTexture;
    if (localObject == null) {
      p.gfZ();
    }
    a((SurfaceTexture)localObject, this.hpe, this.hpj);
    return this.hpc;
  }
  
  public final boolean awa()
  {
    return this.hpd == a.a.hpm;
  }
  
  public boolean awb()
  {
    return false;
  }
  
  public final void awc()
  {
    this.hpg = true;
  }
  
  public boolean n(d.g.a.b<? super Bitmap, z> paramb)
  {
    p.h(paramb, "dataCallback");
    return false;
  }
  
  public void onDestroy() {}
  
  public void release()
  {
    this.hpd = a.a.hpl;
  }
  
  public boolean s(Context paramContext, boolean paramBoolean)
  {
    p.h(paramContext, "context");
    this.hpc = paramBoolean;
    return true;
  }
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.hpk = paramSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a
 * JD-Core Version:    0.7.0.1
 */