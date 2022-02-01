package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class j
  extends CaptureView
  implements c, com.tencent.mm.plugin.voip.video.camera.a.c
{
  private int bms;
  private int mHeight;
  private int mWidth;
  private int wTP;
  private String wUn;
  private int wUo;
  private i wUp;
  
  public j(Context paramContext, b paramb, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(268302);
    this.bms = 0;
    this.wUn = "";
    this.wUo = -1;
    this.wTP = 0;
    this.wUp = null;
    this.mWidth = 640;
    this.mHeight = 480;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "anlin OpenVoiceCameraView: mWidth: " + this.mWidth + ", height: " + this.mHeight);
    this.wUp = new i(this.mWidth, this.mHeight);
    this.wUo = paramb.wTC;
    this.wUn = paramb.openId;
    AppMethodBeat.o(268302);
  }
  
  public final void Jc(int paramInt)
  {
    AppMethodBeat.i(90812);
    if (paramInt == this.wUo)
    {
      AppMethodBeat.o(90812);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.bms + ", openId:" + this.wUn + ", memberId:[" + this.wUo + "->" + paramInt + "]");
    this.wUo = paramInt;
    AppMethodBeat.o(90812);
  }
  
  public final void Jd(int paramInt)
  {
    AppMethodBeat.i(268345);
    com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c.au(paramInt, this.wUp.icJ());
    AppMethodBeat.o(268345);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(90813);
    int i = this.wTP;
    this.wTP = (i + 1);
    if (i % 50 == 0) {
      Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!q.wVc.wVh.isStarted())
    {
      AppMethodBeat.o(90813);
      return;
    }
    q.wVc.f(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    AppMethodBeat.o(90813);
  }
  
  public final void aV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90809);
    this.bms = paramJSONObject.optInt("viewId");
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
    this.wUp.a(this, bool1);
    this.wUp.a(this);
    this.wUp.icx();
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.bms + ", openId:" + this.wUn + ", memberId:" + this.wUo + ", data:" + paramJSONObject.toString());
    AppMethodBeat.o(90809);
  }
  
  public final void aW(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90810);
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.bms + ", openId:" + this.wUn + ", memberId:" + this.wUo + ", data:" + paramJSONObject.toString());
    uint();
    aV(paramJSONObject);
    AppMethodBeat.o(90810);
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
  
  public final void gG(int paramInt1, int paramInt2) {}
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(268357);
    int i = getHeight();
    AppMethodBeat.o(268357);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(268354);
    int i = getWidth();
    AppMethodBeat.o(268354);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.wUo;
  }
  
  public final String getOpenId()
  {
    return this.wUn;
  }
  
  public final int getViewId()
  {
    return this.bms;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90811);
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.bms + ", openId:" + this.wUn + ", memberId:" + this.wUo);
    this.wUp.ggH();
    AppMethodBeat.o(90811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.j
 * JD-Core Version:    0.7.0.1
 */