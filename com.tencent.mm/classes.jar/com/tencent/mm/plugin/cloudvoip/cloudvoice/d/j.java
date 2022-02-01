package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

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
  private int Go;
  private int mHeight;
  private int mWidth;
  private String tQX;
  private int tQY;
  private i tQZ;
  private int tQz;
  
  public j(Context paramContext, b paramb, int paramInt1, int paramInt2)
  {
    super(paramContext);
    AppMethodBeat.i(203611);
    this.Go = 0;
    this.tQX = "";
    this.tQY = -1;
    this.tQz = 0;
    this.tQZ = null;
    this.mWidth = 640;
    this.mHeight = 480;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "anlin OpenVoiceCameraView: mWidth: " + this.mWidth + ", height: " + this.mHeight);
    this.tQZ = new i(this.mWidth, this.mHeight);
    this.tQY = paramb.tQm;
    this.tQX = paramb.openId;
    AppMethodBeat.o(203611);
  }
  
  public final void IA(int paramInt)
  {
    AppMethodBeat.i(203616);
    com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c.ad(paramInt, this.tQZ.gDP());
    AppMethodBeat.o(203616);
  }
  
  public final void Iz(int paramInt)
  {
    AppMethodBeat.i(90812);
    if (paramInt == this.tQY)
    {
      AppMethodBeat.o(90812);
      return;
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "updateMemberId, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:[" + this.tQY + "->" + paramInt + "]");
    this.tQY = paramInt;
    AppMethodBeat.o(90812);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(90813);
    int i = this.tQz;
    this.tQz = (i + 1);
    if (i % 50 == 0) {
      Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!q.tRM.tRR.isStarted())
    {
      AppMethodBeat.o(90813);
      return;
    }
    q.tRM.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    AppMethodBeat.o(90813);
  }
  
  public final void aK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90809);
    this.Go = paramJSONObject.optInt("viewId");
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
    this.tQZ.a(this, bool1);
    this.tQZ.a(this);
    this.tQZ.gDB();
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "init, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY + ", data:" + paramJSONObject.toString());
    AppMethodBeat.o(90809);
  }
  
  public final void aL(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(90810);
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "update, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY + ", data:" + paramJSONObject.toString());
    uint();
    aK(paramJSONObject);
    AppMethodBeat.o(90810);
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
  
  public final void fP(int paramInt1, int paramInt2) {}
  
  public final int getLogicHeight()
  {
    AppMethodBeat.i(203618);
    int i = getHeight();
    AppMethodBeat.o(203618);
    return i;
  }
  
  public final int getLogicWidth()
  {
    AppMethodBeat.i(203617);
    int i = getWidth();
    AppMethodBeat.o(203617);
    return i;
  }
  
  public final int getMemberId()
  {
    return this.tQY;
  }
  
  public final String getOpenId()
  {
    return this.tQX;
  }
  
  public final int getViewId()
  {
    return this.Go;
  }
  
  public final void uint()
  {
    AppMethodBeat.i(90811);
    Log.i("MicroMsg.OpenVoice.OpenVoiceCameraView", "uint, viewId:" + this.Go + ", openId:" + this.tQX + ", memberId:" + this.tQY);
    this.tQZ.eXS();
    AppMethodBeat.o(90811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.j
 * JD-Core Version:    0.7.0.1
 */