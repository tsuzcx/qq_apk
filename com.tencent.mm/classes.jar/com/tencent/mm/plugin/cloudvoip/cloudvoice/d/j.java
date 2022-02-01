package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
  extends CaptureView
  implements c, com.tencent.mm.plugin.voip.video.camera.a.b
{
  private int mHeight;
  private int mViewId;
  private int mWidth;
  private int qrQ;
  private String qso;
  private int qsp;
  private i qsq;
  
  public j(Context paramContext, com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b paramb, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(186726);
    this.mViewId = 0;
    this.qso = "";
    this.qsp = -1;
    this.qrQ = 0;
    this.qsq = null;
    this.mWidth = 640;
    this.mHeight = 480;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "anlin OpenVoiceCameraView: mWidth: " + this.mWidth + ", height: " + this.mHeight);
    this.qsq = new i(this.mWidth, this.mHeight);
    this.qsp = paramb.qrD;
    this.qso = paramb.openId;
    AppMethodBeat.o(186726);
  }
  
  public final void ES(int paramInt)
  {
    AppMethodBeat.i(90812);
    if (paramInt == this.qsp)
    {
      AppMethodBeat.o(90812);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:[" + this.qsp + "->" + paramInt + "]");
    this.qsp = paramInt;
    AppMethodBeat.o(90812);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(90813);
    int i = this.qrQ;
    this.qrQ = (i + 1);
    if (i % 50 == 0) {
      Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!q.qta.qtf.isStarted())
    {
      AppMethodBeat.o(90813);
      return;
    }
    q.qta.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    AppMethodBeat.o(90813);
  }
  
  public final void aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90809);
    this.mViewId = paramJSONObject.optInt("viewId");
    boolean bool2 = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "camera:".concat(String.valueOf(localObject)));
      bool1 = bool2;
      if (((String)localObject).equals("back")) {
        bool1 = false;
      }
    }
    this.qsq.a(this, bool1);
    this.qsq.a(this);
    this.qsq.fLb();
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + paramJSONObject.toString());
    AppMethodBeat.o(90809);
  }
  
  public final void aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90810);
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp + ", data:" + paramJSONObject.toString());
    uint();
    aG(paramJSONObject);
    AppMethodBeat.o(90810);
  }
  
  public final boolean cyX()
  {
    return true;
  }
  
  public final void cza() {}
  
  public final void fs(int paramInt1, int paramInt2) {}
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(186728);
    int i = getHeight();
    AppMethodBeat.o(186728);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(186727);
    int i = getWidth();
    AppMethodBeat.o(186727);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.qsp;
  }
  
  public final String getOpenId()
  {
    return this.qso;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90811);
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:" + this.qsp);
    this.qsq.eoc();
    AppMethodBeat.o(90811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.j
 * JD-Core Version:    0.7.0.1
 */