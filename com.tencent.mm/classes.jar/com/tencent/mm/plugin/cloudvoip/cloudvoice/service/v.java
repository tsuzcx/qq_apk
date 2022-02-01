package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/SameLayerOpenVoiceOpenGlView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/IOpenVoiceView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$ISameLayerScaleOpenVoiceView;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "ctx", "Landroid/content/Context;", "member", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/OpenVoiceMember;", "width", "", "height", "(Landroid/content/Context;Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/OpenVoiceMember;II)V", "bFace", "", "logicHeight", "logicWidth", "memberId", "openId", "", "render", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceCameraRender;", "sameLayerCallback", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "sameLayerSurfaceHeight", "sameLayerSurfaceWidth", "viewId", "draw", "", "frame", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/AVFrame;", "getCameraType", "data", "Lorg/json/JSONObject;", "getLogicHeight", "getLogicWidth", "getMemberId", "getOpenId", "getSameLayerSurfaceHeight", "getSameLayerSurfaceWidth", "getViewId", "init", "isCameraView", "isScreenView", "isVideoView", "notifyVideoSizeChanged", "onCameraError", "onCameraPreviewApply", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "onSensorOrientationChanged", "orientation", "setLogicSurfaceSize", "surfaceWidth", "surfaceHeight", "setSameLayerCallback", "callback", "setSameLayerSurfaceSize", "uint", "update", "updateMemberId", "mid", "Companion", "cloudvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends ObservableTextureView
  implements c, d, d.a, com.tencent.mm.plugin.voip.video.camera.a.c
{
  public static final v.a wXL;
  private String openId;
  private int viewId;
  private int wTC;
  private boolean wUP;
  private int wUQ;
  private int wUR;
  private final i wXM;
  private d.b wXN;
  private int wXO;
  private int wXP;
  
  static
  {
    AppMethodBeat.i(268292);
    wXL = new v.a((byte)0);
    AppMethodBeat.o(268292);
  }
  
  public v(Context paramContext, b paramb, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(268287);
    this.openId = "";
    this.wTC = -1;
    this.wXM = new i(paramInt1, paramInt2);
    this.wTC = paramb.wTC;
    paramContext = paramb.openId;
    s.s(paramContext, "member.openId");
    this.openId = paramContext;
    AppMethodBeat.o(268287);
  }
  
  private static boolean aX(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(268289);
    boolean bool2 = true;
    paramJSONObject = paramJSONObject.optJSONObject("config");
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("camera", "back");
      Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", s.X("camera:", paramJSONObject));
      bool1 = bool2;
      if (s.p(paramJSONObject, "back")) {
        bool1 = false;
      }
    }
    AppMethodBeat.o(268289);
    return bool1;
  }
  
  public final void Jc(int paramInt)
  {
    AppMethodBeat.i(268303);
    if (paramInt == this.wTC)
    {
      AppMethodBeat.o(268303);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:[" + this.wTC + "->" + paramInt + ']');
    this.wTC = paramInt;
    AppMethodBeat.o(268303);
  }
  
  public final void Jd(int paramInt)
  {
    AppMethodBeat.i(268335);
    com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c.au(paramInt, this.wXM.icJ());
    AppMethodBeat.o(268335);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(268338);
    s.u(parama, "frame");
    AppMethodBeat.o(268338);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(268325);
    s.u(paramArrayOfByte, "pBuffer");
    if (!q.wVc.wVh.isStarted())
    {
      AppMethodBeat.o(268325);
      return;
    }
    q.wVc.f(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    AppMethodBeat.o(268325);
  }
  
  public final void aV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(268295);
    s.u(paramJSONObject, "data");
    this.viewId = paramJSONObject.optInt("viewId");
    this.wUP = aX(paramJSONObject);
    this.wXM.a((com.tencent.mm.plugin.voip.video.camera.a.c)this, this.wUP);
    this.wXM.a((ObservableTextureView)this);
    this.wXM.icx();
    ad localad = this.wXM.icK();
    int i;
    d.b localb;
    if (localad != null)
    {
      if ((this.wXM.boh() % 90 != 0) || (this.wXM.boh() % 180 == 0)) {
        break label205;
      }
      i = 1;
      if (i == 0) {
        break label210;
      }
      localb = this.wXN;
      if (localb != null) {
        localb.fH(localad.height, localad.width);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.wTC + ", data:" + paramJSONObject);
      AppMethodBeat.o(268295);
      return;
      label205:
      i = 0;
      break;
      label210:
      localb = this.wXN;
      if (localb != null) {
        localb.fH(localad.width, localad.height);
      }
    }
  }
  
  public final void aW(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(268298);
    s.u(paramJSONObject, "data");
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "update, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.wTC + ", data:" + paramJSONObject);
    boolean bool = aX(paramJSONObject);
    if (bool != this.wUP)
    {
      this.wUP = bool;
      this.wXM.icy();
    }
    AppMethodBeat.o(268298);
  }
  
  public final boolean dqZ()
  {
    return true;
  }
  
  public final boolean dra()
  {
    return false;
  }
  
  public final boolean drb()
  {
    return false;
  }
  
  public final void dre() {}
  
  public final void gE(int paramInt1, int paramInt2)
  {
    this.wXO = paramInt1;
    this.wXP = paramInt2;
  }
  
  public final void gF(int paramInt1, int paramInt2)
  {
    this.wUQ = paramInt1;
    this.wUR = paramInt2;
  }
  
  public final void gG(int paramInt1, int paramInt2) {}
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(268355);
    if (this.wUR > 0)
    {
      i = this.wUR;
      AppMethodBeat.o(268355);
      return i;
    }
    int i = getHeight();
    AppMethodBeat.o(268355);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(268348);
    if (this.wUQ > 0)
    {
      i = this.wUQ;
      AppMethodBeat.o(268348);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(268348);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.wTC;
  }
  
  public final String getOpenId()
  {
    return this.openId;
  }
  
  public final int getSameLayerSurfaceHeight()
  {
    return this.wXP;
  }
  
  public final int getSameLayerSurfaceWidth()
  {
    return this.wXO;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  public final void setSameLayerCallback(d.b paramb)
  {
    this.wXN = paramb;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(268299);
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.wTC);
    this.wXM.ggH();
    AppMethodBeat.o(268299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.v
 * JD-Core Version:    0.7.0.1
 */