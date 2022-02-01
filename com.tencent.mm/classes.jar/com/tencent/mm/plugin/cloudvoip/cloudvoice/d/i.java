package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class i
  extends CaptureView
  implements c, f
{
  private int mViewId;
  private String oWL;
  private int oWM;
  private h oWN;
  private int oWo;
  
  public i(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(90808);
    this.mViewId = 0;
    this.oWL = "";
    this.oWM = -1;
    this.oWo = 0;
    this.oWN = new h();
    this.oWM = paramb.oWb;
    this.oWL = paramb.openId;
    AppMethodBeat.o(90808);
  }
  
  public final void AY(int paramInt)
  {
    AppMethodBeat.i(90812);
    if (paramInt == this.oWM)
    {
      AppMethodBeat.o(90812);
      return;
    }
    ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.oWL + ", memberId:[" + this.oWM + "->" + paramInt + "]");
    this.oWM = paramInt;
    AppMethodBeat.o(90812);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(90813);
    int i = this.oWo;
    this.oWo = (i + 1);
    if (i % 50 == 0) {
      ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!p.oXv.oXz.isStarted())
    {
      AppMethodBeat.o(90813);
      return;
    }
    p.oXv.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    AppMethodBeat.o(90813);
  }
  
  public final void ao(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90809);
    this.mViewId = paramJSONObject.optInt("viewId");
    boolean bool2 = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "camera:".concat(String.valueOf(localObject)));
      bool1 = bool2;
      if (((String)localObject).equals("back")) {
        bool1 = false;
      }
    }
    this.oWN.a(this, bool1);
    this.oWN.a(this);
    this.oWN.eAk();
    ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.mViewId + ", openId:" + this.oWL + ", memberId:" + this.oWM + ", data:" + paramJSONObject.toString());
    AppMethodBeat.o(90809);
  }
  
  public final void ap(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90810);
    ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.mViewId + ", openId:" + this.oWL + ", memberId:" + this.oWM + ", data:" + paramJSONObject.toString());
    uint();
    ao(paramJSONObject);
    AppMethodBeat.o(90810);
  }
  
  public final boolean bZT()
  {
    return true;
  }
  
  public final void bZW() {}
  
  public final int getMemberId()
  {
    return this.oWM;
  }
  
  public final String getOpenId()
  {
    return this.oWL;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90811);
    ad.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.mViewId + ", openId:" + this.oWL + ", memberId:" + this.oWM);
    this.oWN.eAl();
    AppMethodBeat.o(90811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.i
 * JD-Core Version:    0.7.0.1
 */