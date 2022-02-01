package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  extends RelativeLayout
  implements c, f
{
  private int mViewId;
  private int osS;
  private CaptureView otK;
  OpenGlRender otL;
  private OpenGlView otM;
  boolean otN;
  private boolean otO;
  private String otp;
  private int otq;
  private h otr;
  
  public n(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(200743);
    this.mViewId = 0;
    this.otp = "";
    this.otq = -1;
    this.osS = 0;
    this.otr = new h();
    this.otO = false;
    this.otq = paramb.osF;
    this.otp = paramb.openId;
    this.otM = new OpenGlView(paramContext);
    this.otL = new OpenGlRender(this.otM, OpenGlRender.RenderLocal);
    this.otN = true;
    this.otM.setRenderer(this.otL);
    this.otM.setRenderMode(0);
    addView(this.otM);
    this.otK = new CaptureView(paramContext);
    addView(this.otK, new RelativeLayout.LayoutParams(1, 1));
    this.otK.setVisibility(0);
    this.otK.setAlpha(0.0F);
    AppMethodBeat.o(200743);
  }
  
  private static float[] E(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(200749);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("position"));
      float f1 = g.a(localJSONObject, "left", 0.0F);
      float f2 = g.a(localJSONObject, "top", 0.0F);
      float f3 = g.a(localJSONObject, "width", 0.0F);
      float f4 = g.a(localJSONObject, "height", 0.0F);
      float f5 = paramJSONObject.optInt("zIndex", 0);
      AppMethodBeat.o(200749);
      return new float[] { f1, f2, f3, f4, f5 };
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(200749);
    }
    return null;
  }
  
  public final void Ap(int paramInt)
  {
    AppMethodBeat.i(200747);
    if (paramInt == this.otq)
    {
      AppMethodBeat.o(200747);
      return;
    }
    ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:[" + this.otq + "->" + paramInt + "]");
    this.otq = paramInt;
    AppMethodBeat.o(200747);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200748);
    int i = this.osS;
    this.osS = (i + 1);
    if (i % 50 == 0) {
      ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!p.otZ.oud.isStarted())
    {
      AppMethodBeat.o(200748);
      return;
    }
    p.otZ.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
    if (this.otr.emq())
    {
      paramInt3 = OpenGlRender.FLAG_Mirror;
      if (!this.otr.emr()) {
        break label202;
      }
    }
    label202:
    for (paramInt4 = OpenGlRender.FLAG_Angle270;; paramInt4 = OpenGlRender.FLAG_Angle90)
    {
      this.otL.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + OpenGlRender.FLAG_NV21 + paramInt4, true, 3);
      AppMethodBeat.o(200748);
      return;
      paramInt3 = 0;
      break;
    }
  }
  
  public final void al(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(200744);
    this.mViewId = paramJSONObject.optInt("viewId");
    this.otO = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(localObject)));
      if (((String)localObject).equals("back")) {
        this.otO = false;
      }
    }
    this.otr.a(this, this.otO);
    this.otr.a(this.otK);
    this.otr.emo();
    ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq + ", data:" + paramJSONObject.toString());
    e.emX().AQT = new n.1(this);
    try
    {
      paramJSONObject = E(paramJSONObject);
      if (paramJSONObject != null) {
        this.otM.ik((int)paramJSONObject[2], (int)paramJSONObject[3]);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ac.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", new Object[] { paramJSONObject });
      }
    }
    this.otL.onStarted();
    AppMethodBeat.o(200744);
  }
  
  public final void am(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(200745);
    ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "update, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq + ", data:" + paramJSONObject.toString());
    for (;;)
    {
      try
      {
        float[] arrayOfFloat = E(paramJSONObject);
        if (arrayOfFloat != null) {
          this.otM.onSurfaceTextureSizeChanged(v2protocal.mSurfaceTexture, (int)arrayOfFloat[2], (int)arrayOfFloat[3]);
        }
        paramJSONObject = paramJSONObject.optJSONObject("config");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optString("camera", "back");
          ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(paramJSONObject)));
          if (paramJSONObject.equals("back"))
          {
            bool = false;
            if (bool != this.otO)
            {
              this.otO = bool;
              this.otr.emn();
            }
            AppMethodBeat.o(200745);
            return;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ac.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", new Object[] { paramJSONObject });
        AppMethodBeat.o(200745);
        return;
      }
      boolean bool = true;
    }
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
    AppMethodBeat.i(200746);
    ac.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.mViewId + ", openId:" + this.otp + ", memberId:" + this.otq);
    this.otr.emp();
    this.otL.releaseSurfaceTexture();
    this.otL.emA();
    AppMethodBeat.o(200746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.n
 * JD-Core Version:    0.7.0.1
 */