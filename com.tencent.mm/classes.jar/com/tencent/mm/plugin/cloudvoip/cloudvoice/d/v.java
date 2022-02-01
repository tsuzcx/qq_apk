package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/SameLayerOpenVoiceOpenGlView;", "Lcom/tencent/mm/plugin/video/ObservableTextureView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/IOpenVoiceView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$ISameLayerScaleOpenVoiceView;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "ctx", "Landroid/content/Context;", "member", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/OpenVoiceMember;", "width", "", "height", "(Landroid/content/Context;Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/OpenVoiceMember;II)V", "bFace", "", "logicHeight", "logicWidth", "memberId", "openId", "", "render", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceCameraRender;", "sameLayerCallback", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "sameLayerSurfaceHeight", "sameLayerSurfaceWidth", "viewId", "draw", "", "frame", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/model/AVFrame;", "getCameraType", "data", "Lorg/json/JSONObject;", "getLogicHeight", "getLogicWidth", "getMemberId", "getOpenId", "getSameLayerSurfaceHeight", "getSameLayerSurfaceWidth", "getViewId", "init", "isCameraView", "isScreenView", "isVideoView", "notifyVideoSizeChanged", "onCameraError", "onCameraPreviewApply", "onFrameDataReady", "pBuffer", "", "lBufferSize", "", "w", "h", "cameraFrameFormat", "rotate", "dblSampleTime", "", "onSensorOrientationChanged", "orientation", "setLogicSurfaceSize", "surfaceWidth", "surfaceHeight", "setSameLayerCallback", "callback", "setSameLayerSurfaceSize", "uint", "update", "updateMemberId", "mid", "Companion", "cloudvoice_release"})
public final class v
  extends ObservableTextureView
  implements c, d, d.a, com.tencent.mm.plugin.voip.video.camera.a.c
{
  public static final v.a tUu;
  private String openId;
  private int tQm;
  private int tRA;
  private int tRB;
  private boolean tRz;
  private final i tUq;
  private d.b tUr;
  private int tUs;
  private int tUt;
  private int viewId;
  
  static
  {
    AppMethodBeat.i(203110);
    tUu = new v.a((byte)0);
    AppMethodBeat.o(203110);
  }
  
  public v(Context paramContext, b paramb, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(203108);
    this.openId = "";
    this.tQm = -1;
    this.tUq = new i(paramInt1, paramInt2);
    this.tQm = paramb.tQm;
    paramContext = paramb.openId;
    p.j(paramContext, "member.openId");
    this.openId = paramContext;
    AppMethodBeat.o(203108);
  }
  
  private static boolean aM(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(203086);
    boolean bool2 = true;
    paramJSONObject = paramJSONObject.optJSONObject("config");
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("camera", "back");
      Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(paramJSONObject)));
      bool1 = bool2;
      if (p.h(paramJSONObject, "back")) {
        bool1 = false;
      }
    }
    AppMethodBeat.o(203086);
    return bool1;
  }
  
  public final void IA(int paramInt)
  {
    AppMethodBeat.i(203100);
    com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c.ad(paramInt, this.tUq.gDP());
    AppMethodBeat.o(203100);
  }
  
  public final void Iz(int paramInt)
  {
    AppMethodBeat.i(203092);
    if (paramInt == this.tQm)
    {
      AppMethodBeat.o(203092);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:[" + this.tQm + "->" + paramInt + ']');
    this.tQm = paramInt;
    AppMethodBeat.o(203092);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(203102);
    p.k(parama, "frame");
    AppMethodBeat.o(203102);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(203097);
    p.k(paramArrayOfByte, "pBuffer");
    t localt = q.tRM.cNJ();
    p.j(localt, "OpenVoiceService.INSTANCE.videoMgr");
    if (!localt.isStarted())
    {
      AppMethodBeat.o(203097);
      return;
    }
    q.tRM.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    AppMethodBeat.o(203097);
  }
  
  public final void aK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(203082);
    p.k(paramJSONObject, "data");
    this.viewId = paramJSONObject.optInt("viewId");
    this.tRz = aM(paramJSONObject);
    this.tUq.a((com.tencent.mm.plugin.voip.video.camera.a.c)this, this.tRz);
    this.tUq.a((ObservableTextureView)this);
    this.tUq.gDB();
    ad localad = this.tUq.gDC();
    int i;
    d.b localb;
    if (localad != null)
    {
      if ((this.tUq.aYj() % 90 != 0) || (this.tUq.aYj() % 180 == 0)) {
        break label205;
      }
      i = 1;
      if (i == 0) {
        break label210;
      }
      localb = this.tUr;
      if (localb != null) {
        localb.eO(localad.height, localad.width);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.tQm + ", data:" + paramJSONObject);
      AppMethodBeat.o(203082);
      return;
      label205:
      i = 0;
      break;
      label210:
      localb = this.tUr;
      if (localb != null) {
        localb.eO(localad.width, localad.height);
      }
    }
  }
  
  public final void aL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(203084);
    p.k(paramJSONObject, "data");
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "update, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.tQm + ", data:" + paramJSONObject);
    boolean bool = aM(paramJSONObject);
    if (bool != this.tRz)
    {
      this.tRz = bool;
      this.tUq.gDD();
    }
    AppMethodBeat.o(203084);
  }
  
  public final boolean cNt()
  {
    return true;
  }
  
  public final boolean cNu()
  {
    return false;
  }
  
  public final boolean cNv()
  {
    return false;
  }
  
  public final void cNy() {}
  
  public final void fN(int paramInt1, int paramInt2)
  {
    this.tUs = paramInt1;
    this.tUt = paramInt2;
  }
  
  public final void fO(int paramInt1, int paramInt2)
  {
    this.tRA = paramInt1;
    this.tRB = paramInt2;
  }
  
  public final void fP(int paramInt1, int paramInt2) {}
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(203106);
    if (this.tRB > 0)
    {
      i = this.tRB;
      AppMethodBeat.o(203106);
      return i;
    }
    int i = getHeight();
    AppMethodBeat.o(203106);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(203103);
    if (this.tRA > 0)
    {
      i = this.tRA;
      AppMethodBeat.o(203103);
      return i;
    }
    int i = getWidth();
    AppMethodBeat.o(203103);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.tQm;
  }
  
  public final String getOpenId()
  {
    return this.openId;
  }
  
  public final int getSameLayerSurfaceHeight()
  {
    return this.tUt;
  }
  
  public final int getSameLayerSurfaceWidth()
  {
    return this.tUs;
  }
  
  public final int getViewId()
  {
    return this.viewId;
  }
  
  public final void setSameLayerCallback(d.b paramb)
  {
    this.tUr = paramb;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(203089);
    Log.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.viewId + ", openId:" + this.openId + ", memberId:" + this.tQm);
    this.tUq.eXS();
    AppMethodBeat.o(203089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.v
 * JD-Core Version:    0.7.0.1
 */