package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class i
  extends CaptureView
  implements c, f
{
  private int mViewId;
  private int pcR;
  private String pdo;
  private int pdp;
  private h pdq;
  
  public i(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(90808);
    this.mViewId = 0;
    this.pdo = "";
    this.pdp = -1;
    this.pcR = 0;
    this.pdq = new h();
    this.pdp = paramb.pcE;
    this.pdo = paramb.openId;
    AppMethodBeat.o(90808);
  }
  
  public final void Bk(int paramInt)
  {
    AppMethodBeat.i(90812);
    if (paramInt == this.pdp)
    {
      AppMethodBeat.o(90812);
      return;
    }
    ae.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:[" + this.pdp + "->" + paramInt + "]");
    this.pdp = paramInt;
    AppMethodBeat.o(90812);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(90813);
    int i = this.pcR;
    this.pcR = (i + 1);
    if (i % 50 == 0) {
      ae.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!p.pdY.pec.isStarted())
    {
      AppMethodBeat.o(90813);
      return;
    }
    p.pdY.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
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
      ae.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "camera:".concat(String.valueOf(localObject)));
      bool1 = bool2;
      if (((String)localObject).equals("back")) {
        bool1 = false;
      }
    }
    this.pdq.a(this, bool1);
    this.pdq.a(this);
    this.pdq.eDS();
    ae.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:" + this.pdp + ", data:" + paramJSONObject.toString());
    AppMethodBeat.o(90809);
  }
  
  public final void ap(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90810);
    ae.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:" + this.pdp + ", data:" + paramJSONObject.toString());
    uint();
    ao(paramJSONObject);
    AppMethodBeat.o(90810);
  }
  
  public final boolean cbi()
  {
    return true;
  }
  
  public final void cbl() {}
  
  public final int getMemberId()
  {
    return this.pdp;
  }
  
  public final String getOpenId()
  {
    return this.pdo;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90811);
    ae.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:" + this.pdp);
    this.pdq.eDT();
    AppMethodBeat.o(90811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.i
 * JD-Core Version:    0.7.0.1
 */