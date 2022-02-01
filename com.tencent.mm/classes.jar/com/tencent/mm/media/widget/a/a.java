package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Size;
import android.view.SurfaceHolder;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.plugin.mmsight.model.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import d.g.b.k;
import d.l;
import d.n.n;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "TAG", "", "TAG_SETTING", "getTAG_SETTING", "()Ljava/lang/String;", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "customDisplayScreenSize", "Landroid/util/Size;", "getCustomDisplayScreenSize", "()Landroid/util/Size;", "setCustomDisplayScreenSize", "(Landroid/util/Size;)V", "displayRatio", "", "getDisplayRatio", "()F", "setDisplayRatio", "(F)V", "hasShownErrorTip", "", "isReturnFrameCallbackAny", "()Z", "setReturnFrameCallbackAny", "(Z)V", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "surfaceHolder", "Landroid/view/SurfaceHolder;", "getSurfaceHolder", "()Landroid/view/SurfaceHolder;", "setSurfaceHolder", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "setUseBackCamera", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "initCamera", "useBack", "isBackCamera", "isCameraPreviewing", "onDestroy", "", "release", "setDisplayScreenSize", "screenSize", "setPreviewDisplayRatio", "ratio", "setReturnFrameCallback", "value", "showCameraErrorTips", "startPreview", "surface", "switchCamera", "switchRecordStream", "takePhoto", "dataCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", "bitmap", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a
  implements e
{
  private final String TAG;
  private SurfaceHolder aSS;
  protected Context context;
  private a.a gwA;
  protected boolean gwB;
  float gwC;
  boolean gwD;
  protected q gwE;
  protected b gwF;
  private int gwG;
  protected Size gwH;
  protected final String gww;
  private final int gwx;
  private boolean gwy;
  protected boolean gwz;
  protected SurfaceTexture surfaceTexture;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.TAG = "MicroMsg.BaseCommonCamera";
    this.gww = "MicroMsg.MMSightCameraSetting";
    this.gwx = 8;
    this.gwz = true;
    this.gwA = a.a.gwI;
    this.gwB = true;
    paramContext = q.cQb();
    k.g(paramContext, "RecordParams.getBigSightDefault()");
    this.gwE = paramContext;
    this.gwF = b.gwQ;
    this.gwG = 40000;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, boolean paramBoolean, int paramInt)
  {
    this.surfaceTexture = paramSurfaceTexture;
    this.gwB = paramBoolean;
    this.gwG = paramInt;
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, boolean paramBoolean, int paramInt)
  {
    this.aSS = paramSurfaceHolder;
    this.gwB = paramBoolean;
    this.gwG = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    k.h(parama, "<set-?>");
    this.gwA = parama;
  }
  
  protected final void amt()
  {
    if ((this.gwy) || (this.context == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((n.I(Build.MANUFACTURER, "meizu", true)) && (!com.tencent.mm.compatible.d.b.XC()));
      localObject = new oa();
      ((oa)localObject).dti.type = 2;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if (((oa)localObject).dtj.dth)
      {
        this.gwy = true;
        return;
      }
      localObject = h.j(this.context, 2131763668, 2131755906);
    } while (localObject == null);
    ((d)localObject).setCancelable(false);
    ((d)localObject).setCanceledOnTouchOutside(false);
    ((d)localObject).show();
    this.gwy = true;
  }
  
  public final boolean amu()
  {
    boolean bool = false;
    if ((this.surfaceTexture == null) && (this.aSS == null))
    {
      ad.e(this.TAG, " do you forget override func startPreview");
      return false;
    }
    if (!amv())
    {
      ad.e(this.TAG, " now is cpature image and refuse to switchCamera");
      return false;
    }
    release();
    Object localObject = this.context;
    if (localObject == null) {
      k.fvU();
    }
    if (!this.gwz) {
      bool = true;
    }
    q((Context)localObject, bool);
    ad.i(this.TAG, "useCpuCrop : " + this.gwB + " , resolutionLimit: " + this.gwG);
    if (this.surfaceTexture == null)
    {
      localObject = this.aSS;
      if (localObject == null) {
        k.fvU();
      }
      a((SurfaceHolder)localObject, this.gwB, this.gwG);
      return this.gwz;
    }
    localObject = this.surfaceTexture;
    if (localObject == null) {
      k.fvU();
    }
    a((SurfaceTexture)localObject, this.gwB, this.gwG);
    return this.gwz;
  }
  
  public final boolean amv()
  {
    return this.gwA == a.a.gwJ;
  }
  
  public boolean amw()
  {
    return false;
  }
  
  public final void amx()
  {
    this.gwD = true;
  }
  
  public boolean h(d.g.a.b<? super Bitmap, y> paramb)
  {
    k.h(paramb, "dataCallback");
    return false;
  }
  
  public void onDestroy() {}
  
  public boolean q(Context paramContext, boolean paramBoolean)
  {
    k.h(paramContext, "context");
    this.gwz = paramBoolean;
    return true;
  }
  
  public void release()
  {
    this.gwA = a.a.gwI;
  }
  
  public final void setDisplayScreenSize(Size paramSize)
  {
    this.gwH = paramSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.a
 * JD-Core Version:    0.7.0.1
 */