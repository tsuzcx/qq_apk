package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class i
  extends CaptureView
  implements c, f
{
  private int mViewId;
  private int osS;
  private String otp;
  private int otq;
  private h otr;
  
  public i(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(90808);
    this.mViewId = 0;
    this.otp = "";
    this.otq = -1;
    this.osS = 0;
    this.otr = new h();
    this.otq = paramb.osF;
    this.otp = paramb.openId;
    AppMethodBeat.o(90808);
  }
  
  public final void Ap(int paramInt)
  {
    AppMethodBeat.i(90812);
    if (paramInt == this.otq)
    {
      AppMethodBeat.o(90812);
      return;
    }
    ac.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:[" + this.otq + "->" + paramInt + "]");
    this.otq = paramInt;
    AppMethodBeat.o(90812);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(90813);
    int i = this.osS;
    this.osS = (i + 1);
    if (i % 50 == 0) {
      ac.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!p.otZ.oud.isStarted())
    {
      AppMethodBeat.o(90813);
      return;
    }
    p.otZ.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    AppMethodBeat.o(90813);
  }
  
  public final void al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90809);
    this.mViewId = paramJSONObject.optInt("viewId");
    boolean bool2 = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      ac.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "camera:".concat(String.valueOf(localObject)));
      bool1 = bool2;
      if (((String)localObject).equals("back")) {
        bool1 = false;
      }
    }
    this.otr.a(this, bool1);
    this.otr.a(this);
    this.otr.emo();
    ac.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq + ", data:" + paramJSONObject.toString());
    AppMethodBeat.o(90809);
  }
  
  public final void am(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90810);
    ac.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq + ", data:" + paramJSONObject.toString());
    uint();
    al(paramJSONObject);
    AppMethodBeat.o(90810);
  }
  
  public final boolean bVo()
  {
    return true;
  }
  
  public final void bVs() {}
  
  public final int getMemberId()
  {
    return this.otq;
  }
  
  public final String getOpenId()
  {
    return this.otp;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90811);
    ac.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq);
    this.otr.emp();
    AppMethodBeat.o(90811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.i
 * JD-Core Version:    0.7.0.1
 */