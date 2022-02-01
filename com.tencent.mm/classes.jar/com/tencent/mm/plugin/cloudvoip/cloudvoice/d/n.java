package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.appbrand.z.g;
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
import com.tencent.mm.sdk.platformtools.ad;
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
  private String oWL;
  private int oWM;
  private h oWN;
  private int oWo;
  private CaptureView oXg;
  OpenGlRender oXh;
  private OpenGlView oXi;
  boolean oXj;
  private boolean oXk;
  
  public n(Context paramContext, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(190912);
    this.mViewId = 0;
    this.oWL = "";
    this.oWM = -1;
    this.oWo = 0;
    this.oWN = new h();
    this.oXk = false;
    this.oWM = paramb.oWb;
    this.oWL = paramb.openId;
    this.oXi = new OpenGlView(paramContext);
    this.oXh = new OpenGlRender(this.oXi, OpenGlRender.RenderLocal);
    this.oXj = true;
    this.oXi.setRenderer(this.oXh);
    this.oXi.setRenderMode(0);
    addView(this.oXi);
    this.oXg = new CaptureView(paramContext);
    addView(this.oXg, new RelativeLayout.LayoutParams(1, 1));
    this.oXg.setVisibility(0);
    this.oXg.setAlpha(0.0F);
    AppMethodBeat.o(190912);
  }
  
  private static float[] E(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190918);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("position"));
      float f1 = g.a(localJSONObject, "left", 0.0F);
      float f2 = g.a(localJSONObject, "top", 0.0F);
      float f3 = g.a(localJSONObject, "width", 0.0F);
      float f4 = g.a(localJSONObject, "height", 0.0F);
      float f5 = paramJSONObject.optInt("zIndex", 0);
      AppMethodBeat.o(190918);
      return new float[] { f1, f2, f3, f4, f5 };
    }
    catch (Exception paramJSONObject)
    {
      AppMethodBeat.o(190918);
    }
    return null;
  }
  
  public final void AY(int paramInt)
  {
    AppMethodBeat.i(190916);
    if (paramInt == this.oWM)
    {
      AppMethodBeat.o(190916);
      return;
    }
    ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.oWL + ", memberId:[" + this.oWM + "->" + paramInt + "]");
    this.oWM = paramInt;
    AppMethodBeat.o(190916);
  }
  
  public final void a(a parama) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190917);
    int i = this.oWo;
    this.oWo = (i + 1);
    if (i % 50 == 0) {
      ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "onFrameDataReady, w:" + paramInt1 + ",h:" + paramInt2 + ",format:" + paramInt3 + ",len:" + paramArrayOfByte.length + ",size:" + paramLong + ",rotate:" + paramInt4 + ",time:0.0");
    }
    if (!p.oXv.oXz.isStarted())
    {
      AppMethodBeat.o(190917);
      return;
    }
    OpenGlRender localOpenGlRender = this.oXh;
    i = OpenGlRender.FLAG_NV21;
    CountDownLatch localCountDownLatch;
    if ((localOpenGlRender.CnI) && (localOpenGlRender.CnE != null) && (paramArrayOfByte.length >= paramInt1 * paramInt2) && (i == OpenGlRender.FLAG_NV21))
    {
      localCountDownLatch = new CountDownLatch(1);
      localOpenGlRender.CnF = paramArrayOfByte;
      if (localOpenGlRender.Cnr != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)localOpenGlRender.Cnr.get();
        if (localOpenGlView != null) {
          localOpenGlView.queueEvent(new OpenGlRender.2(localOpenGlRender, paramInt1, paramInt2, localCountDownLatch));
        }
      }
    }
    try
    {
      localCountDownLatch.await(2L, TimeUnit.SECONDS);
      label240:
      p.oXv.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + paramInt4);
      if (this.oWN.eAm())
      {
        paramInt3 = OpenGlRender.FLAG_Mirror;
        if (!this.oWN.eAn()) {
          break label321;
        }
      }
      label321:
      for (paramInt4 = OpenGlRender.FLAG_Angle270;; paramInt4 = OpenGlRender.FLAG_Angle90)
      {
        this.oXh.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3 + OpenGlRender.FLAG_NV21 + paramInt4, true, 3);
        AppMethodBeat.o(190917);
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
    AppMethodBeat.i(190913);
    this.mViewId = paramJSONObject.optInt("viewId");
    this.oXk = true;
    Object localObject = paramJSONObject.optJSONObject("config");
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optString("camera", "back");
      ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(localObject)));
      if (((String)localObject).equals("back")) {
        this.oXk = false;
      }
    }
    this.oWN.a(this, this.oXk);
    this.oWN.a(this.oXg);
    this.oWN.eAk();
    ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "init, viewId:" + this.mViewId + ", openId:" + this.oWL + ", memberId:" + this.oWM + ", data:" + paramJSONObject.toString());
    e.eAV().Cql = new e.a()
    {
      public final void Dd()
      {
        AppMethodBeat.i(190911);
        n localn = n.this;
        SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
        d locald = v2protocal.Chn;
        if ((localSurfaceTexture == null) || (locald == null))
        {
          ad.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture error, videoTexture:%s, videoTexture:%s", new Object[] { localSurfaceTexture, locald });
          AppMethodBeat.o(190911);
          return;
        }
        if ((!localn.oXj) || (localn.oXh == null))
        {
          ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture failed , texId:%d,mInitDone:%b", new Object[] { Integer.valueOf(locald.hko), Boolean.valueOf(localn.oXj) });
          AppMethodBeat.o(190911);
          return;
        }
        localn.oXh.a(localSurfaceTexture, locald);
        ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "setSurfaceTexture OK , videoTexture:%d", new Object[] { Integer.valueOf(locald.hko) });
        AppMethodBeat.o(190911);
      }
    };
    try
    {
      paramJSONObject = E(paramJSONObject);
      if (paramJSONObject != null) {
        this.oXi.ix((int)paramJSONObject[2], (int)paramJSONObject[3]);
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        ad.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", new Object[] { paramJSONObject });
      }
    }
    this.oXh.onStarted();
    AppMethodBeat.o(190913);
  }
  
  public final void ap(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190914);
    ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "update, viewId:" + this.mViewId + ", openId:" + this.oWL + ", memberId:" + this.oWM + ", data:" + paramJSONObject.toString());
    for (;;)
    {
      try
      {
        float[] arrayOfFloat = E(paramJSONObject);
        if (arrayOfFloat != null) {
          this.oXi.onSurfaceTextureSizeChanged(v2protocal.mSurfaceTexture, (int)arrayOfFloat[2], (int)arrayOfFloat[3]);
        }
        paramJSONObject = paramJSONObject.optJSONObject("config");
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.optString("camera", "back");
          ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "camera:".concat(String.valueOf(paramJSONObject)));
          if (paramJSONObject.equals("back"))
          {
            bool = false;
            if (bool != this.oXk)
            {
              this.oXk = bool;
              this.oWN.eAi();
            }
            AppMethodBeat.o(190914);
            return;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        ad.e("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "parse position error. Exception :%s", new Object[] { paramJSONObject });
        AppMethodBeat.o(190914);
        return;
      }
      boolean bool = true;
    }
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
    AppMethodBeat.i(190915);
    ad.i("MicroMsg.OpenVoice.OpenVoiceOpenGlView", "uint, viewId:" + this.mViewId + ", openId:" + this.oWL + ", memberId:" + this.oWM);
    this.oWN.eAl();
    this.oXh.releaseSurfaceTexture();
    this.oXh.eAw();
    AppMethodBeat.o(190915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.n
 * JD-Core Version:    0.7.0.1
 */