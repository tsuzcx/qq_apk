package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/SameLayerOpenVoiceOpenGlView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/IOpenVoiceView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$ISameLayerScaleOpenVoiceView;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "ctx", "Landroid/content/Context;", "member", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/OpenVoiceMember;", "width", "", "height", "(Landroid/content/Context;Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/OpenVoiceMember;II)V", "bFace", "", "logicHeight", "logicWidth", "memberId", "openId", "", "render", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceCameraRender;", "sameLayerCallback", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "sameLayerSurfaceHeight", "sameLayerSurfaceWidth", "viewId", "draw", "", "frame", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/AVFrame;", "getCameraType", "data", "Lorg/json/JSONObject;", "getLogicHeight", "getLogicWidth", "getMemberId", "getOpenId", "getSameLayerSurfaceHeight", "getSameLayerSurfaceWidth", "getViewId", "init", "isCameraView", "notifyVideoSizeChanged", "onCameraError", "onCameraPreviewApply", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "setLogicSurfaceSize", "surfaceWidth", "surfaceHeight", "setSameLayerCallback", "callback", "setSameLayerSurfaceSize", "uint", "update", "updateMemberId", "mid", "Companion", "cloudvoice_release"})
public final class v
  extends ObservableTextureView
  implements c, d, d.a, com.tencent.mm.plugin.voip.video.camera.a.b
{
  public static final v.a qvv;
  private String openId;
  private int qrD;
  private boolean qsN;
  private int qsO;
  private int qsP;
  private final i qvr;
  private d.b qvs;
  private int qvt;
  private int qvu;
  private int viewId;
  
  static
  {
    AppMethodBeat.i(186823);
    qvv = new v.a((byte)0);
    AppMethodBeat.o(186823);
  }
  
  public v(Context paramContext, com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b paramb, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(186822);
    this.openId = "";
    this.qrD = -1;
    this.qvr = new i(paramInt1, paramInt2);
    this.qrD = paramb.qrD;
    paramContext = paramb.openId;
    p.g(paramContext, "member.openId");
    this.openId = paramContext;
    AppMethodBeat.o(186822);
  }
  
  private static boolean aI(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186815);
    boolean bool2 = true;
    paramJSONObject = paramJSONObject.optJSONObject("config");
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("camera", "back");
      Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(paramJSONObject)));
      bool1 = bool2;
      if (p.j(paramJSONObject, "back")) {
        bool1 = false;
      }
    }
    AppMethodBeat.o(186815);
    return bool1;
  }
  
  public final void ES(int paramInt)
  {
    AppMethodBeat.i(186817);
    if (paramInt == this.qrD)
    {
      AppMethodBeat.o(186817);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:[" + this.qrD + "->" + paramInt + ']');
    this.qrD = paramInt;
    AppMethodBeat.o(186817);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(186819);
    p.h(parama, "frame");
    AppMethodBeat.o(186819);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186818);
    p.h(paramArrayOfByte, "pBuffer");
    t localt = q.qta.czk();
    p.g(localt, "OpenVoiceService.INSTANCE.videoMgr");
    if (!localt.isStarted())
    {
      AppMethodBeat.o(186818);
      return;
    }
    q.qta.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    AppMethodBeat.o(186818);
  }
  
  public final void aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186813);
    p.h(paramJSONObject, "data");
    this.viewId = paramJSONObject.optInt("viewId");
    this.qsN = aI(paramJSONObject);
    this.qvr.a((com.tencent.mm.plugin.voip.video.camera.a.b)this, this.qsN);
    this.qvr.a((ObservableTextureView)this);
    this.qvr.fLb();
    ac localac = this.qvr.fLc();
    int i;
    d.b localb;
    if (localac != null)
    {
      if ((this.qvr.aPv() % 90 != 0) || (this.qvr.aPv() % 180 == 0)) {
        break label205;
      }
      i = 1;
      if (i == 0) {
        break label210;
      }
      localb = this.qvs;
      if (localb != null) {
        localb.eq(localac.height, localac.width);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.qrD + ", data:" + paramJSONObject);
      AppMethodBeat.o(186813);
      return;
      label205:
      i = 0;
      break;
      label210:
      localb = this.qvs;
      if (localb != null) {
        localb.eq(localac.width, localac.height);
      }
    }
  }
  
  public final void aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186814);
    p.h(paramJSONObject, "data");
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "update, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.qrD + ", data:" + paramJSONObject);
    boolean bool = aI(paramJSONObject);
    if (bool != this.qsN)
    {
      this.qsN = bool;
      this.qvr.fLd();
    }
    AppMethodBeat.o(186814);
  }
  
  public final boolean cyX()
  {
    return true;
  }
  
  public final void cza() {}
  
  public final void fq(int paramInt1, int paramInt2)
  {
    this.qvt = paramInt1;
    this.qvu = paramInt2;
  }
  
  public final void fr(int paramInt1, int paramInt2)
  {
    this.qsO = paramInt1;
    this.qsP = paramInt2;
  }
  
  public final void fs(int paramInt1, int paramInt2) {}
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(186821);
    if (this.qsP > 0)
    {
      i = this.qsP;
      AppMethodBeat.o(186821);
      return i;
    }
    int i = getHeight();
    AppMethodBeat.o(186821);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(186820);
    if (this.qsO > 0)
    {
      i = this.qsO;
      AppMethodBeat.o(186820);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(186820);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.qrD;
  }
  
  public final String getOpenId()
  {
    return this.openId;
  }
  
  public final int getSameLayerSurfaceHeight()
  {
    return this.qvu;
  }
  
  public final int getSameLayerSurfaceWidth()
  {
    return this.qvt;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  public final void setSameLayerCallback(d.b paramb)
  {
    this.qvs = paramb;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(186816);
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.qrD);
    this.qvr.eoc();
    AppMethodBeat.o(186816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.v
 * JD-Core Version:    0.7.0.1
 */