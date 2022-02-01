package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlRender.2;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  extends RelativeLayout
  implements c, f
{
  private int mViewId;
  private int pcR;
  private CaptureView pdJ;
  OpenGlRender pdK;
  private OpenGlView pdL;
  boolean pdM;
  private boolean pdN;
  private String pdo;
  private int pdp;
  private h pdq;
  
  public n(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(211567);
    this.mViewId = 0;
    this.pdo = "";
    this.pdp = -1;
    this.pcR = 0;
    this.pdq = new h();
    this.pdN = false;
    this.pdp = paramb.pcE;
    this.pdo = paramb.openId;
    this.pdL = new OpenGlView(paramContext);
    this.pdK = new OpenGlRender(this.pdL, OpenGlRender.RenderLocal);
    this.pdM = true;
    this.pdL.setRenderer(this.pdK);
    this.pdL.setRenderMode(0);
    addView(this.pdL);
    this.pdJ = new CaptureView(paramContext);
    addView(this.pdJ, new RelativeLayout.LayoutParams(1, 1));
    this.pdJ.setVisibility(0);
    this.pdJ.setAlpha(0.0F);
    AppMethodBeat.o(211567);
  }
  
  private static float[] E(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211573);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("position"));
      float f1 = g.a(localJSONObject, "left", 0.0F);
      float f2 = g.a(localJSONObject, "top", 0.0F);
      float f3 = g.a(localJSONObject, "width", 0.0F);
      float f4 = g.a(localJSONObject, "height", 0.0F);
      float f5 = paramJSONObject.optInt("zIndex", 0);
      AppMethodBeat.o(211573);
      return new float[] { f1, f2, f3, f4, f5 };
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(211573);
    }
    return null;
  }
  
  public final void Bk(int paramInt)
  {
    AppMethodBeat.i(211571);
    if (paramInt == this.pdp)
    {
      AppMethodBeat.o(211571);
      return;
    }
    ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:[" + this.pdp + "->" + paramInt + "]");
    this.pdp = paramInt;
    AppMethodBeat.o(211571);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(211572);
    int i = this.pcR;
    this.pcR = (i + 1);
    if (i % 50 == 0) {
      ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!p.pdY.pec.isStarted())
    {
      AppMethodBeat.o(211572);
      return;
    }
    OpenGlRender localOpenGlRender = this.pdK;
    i = OpenGlRender.FLAG_NV21;
    CountDownLatch localCountDownLatch;
    if ((localOpenGlRender.CFm) && (localOpenGlRender.CFi != null) && (paramArrayOfByte.length >= paramInt1 * paramInt2) && (i == OpenGlRender.FLAG_NV21))
    {
      localCountDownLatch = new CountDownLatch(1);
      localOpenGlRender.CFj = paramArrayOfByte;
      if (localOpenGlRender.CEV != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.CEV.get();
        if (localOpenGlView != null) {
          localOpenGlView.queueEvent(new OpenGlRender.2(localOpenGlRender, paramInt1, paramInt2, localCountDownLatch));
        }
      }
    }
    try
    {
      localCountDownLatch.await(2L, TimeUnit.SECONDS);
      label240:
      p.pdY.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
      if (this.pdq.eDU())
      {
        paramInt3 = OpenGlRender.FLAG_Mirror;
        if (!this.pdq.eDV()) {
          break label321;
        }
      }
      label321:
      for (paramInt4 = OpenGlRender.FLAG_Angle270;; paramInt4 = OpenGlRender.FLAG_Angle90)
      {
        this.pdK.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + OpenGlRender.FLAG_NV21 + paramInt4, true, 3);
        AppMethodBeat.o(211572);
        return;
        paramInt3 = 0;
        break;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label240;
    }
  }
  
  public final void ao(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211568);
    this.mViewId = paramJSONObject.optInt("viewId");
    this.pdN = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(localObject)));
      if (((String)localObject).equals("back")) {
        this.pdN = false;
      }
    }
    this.pdq.a(this, this.pdN);
    this.pdq.a(this.pdJ);
    this.pdq.eDS();
    ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:" + this.pdp + ", data:" + paramJSONObject.toString());
    e.eED().CHP = new e.a()
    {
      public final void Dg()
      {
        AppMethodBeat.i(211566);
        n localn = n.this;
        SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
        d locald = v2protocal.CyO;
        if ((localSurfaceTexture == null) || (locald == null))
        {
          ae.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", new Object[] { localSurfaceTexture, locald });
          AppMethodBeat.o(211566);
          return;
        }
        if ((!localn.pdM) || (localn.pdK == null))
        {
          ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(locald.hnc), Boolean.valueOf(localn.pdM) });
          AppMethodBeat.o(211566);
          return;
        }
        localn.pdK.a(localSurfaceTexture, locald);
        ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(locald.hnc) });
        AppMethodBeat.o(211566);
      }
    };
    try
    {
      paramJSONObject = E(paramJSONObject);
      if (paramJSONObject != null) {
        this.pdL.iB((int)paramJSONObject[2], (int)paramJSONObject[3]);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ae.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", new Object[] { paramJSONObject });
      }
    }
    this.pdK.onStarted();
    AppMethodBeat.o(211568);
  }
  
  public final void ap(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211569);
    ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "update, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:" + this.pdp + ", data:" + paramJSONObject.toString());
    for (;;)
    {
      try
      {
        float[] arrayOfFloat = E(paramJSONObject);
        if (arrayOfFloat != null) {
          this.pdL.onSurfaceTextureSizeChanged(v2protocal.mSurfaceTexture, (int)arrayOfFloat[2], (int)arrayOfFloat[3]);
        }
        paramJSONObject = paramJSONObject.optJSONObject("config");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optString("camera", "back");
          ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(paramJSONObject)));
          if (paramJSONObject.equals("back"))
          {
            bool = false;
            if (bool != this.pdN)
            {
              this.pdN = bool;
              this.pdq.eDQ();
            }
            AppMethodBeat.o(211569);
            return;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ae.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", new Object[] { paramJSONObject });
        AppMethodBeat.o(211569);
        return;
      }
      boolean bool = true;
    }
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
    AppMethodBeat.i(211570);
    ae.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:" + this.pdp);
    this.pdq.eDT();
    this.pdK.releaseSurfaceTexture();
    this.pdK.eEe();
    AppMethodBeat.o(211570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.n
 * JD-Core Version:    0.7.0.1
 */