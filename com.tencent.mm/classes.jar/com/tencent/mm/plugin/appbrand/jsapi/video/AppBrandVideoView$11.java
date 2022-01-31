package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandVideoView$11
  implements c.b
{
  AppBrandVideoView$11(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void F(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    j localj;
    if (AppBrandVideoView.d(this.gDS) != null)
    {
      localj = AppBrandVideoView.d(this.gDS);
      localj.clean();
    }
    try
    {
      JSONObject localJSONObject = localj.akU();
      localJSONObject.put("errMsg", paramString);
      localj.a(new j.d((byte)0), localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      y.e("MicroMsg.JsApiVideoCallback", "onError e=%s", new Object[] { paramString });
    }
  }
  
  public final void akt()
  {
    y.i("MicroMsg.AppBrandVideoView", "onPrepared");
    k localk = AppBrandVideoView.t(this.gDS);
    localk.gEX = -1;
    localk.gEY = 0;
    localk.gEW = 0.0F;
  }
  
  public final void aku()
  {
    y.i("MicroMsg.AppBrandVideoView", "onVideoEnded");
    AppBrandVideoView.m(this.gDS).setVisibility(8);
    AppBrandVideoView.g(this.gDS).setVisibility(0);
    if (AppBrandVideoView.h(this.gDS).akH()) {
      AppBrandVideoView.h(this.gDS).hide();
    }
    if (AppBrandVideoView.u(this.gDS).getVisibility() == 0) {
      AppBrandVideoView.u(this.gDS).setVisibility(8);
    }
    if ((AppBrandVideoView.v(this.gDS)) || (!AppBrandVideoView.w(this.gDS))) {
      AppBrandVideoView.x(this.gDS).setVisibility(8);
    }
    for (;;)
    {
      j localj;
      if (AppBrandVideoView.d(this.gDS) != null) {
        localj = AppBrandVideoView.d(this.gDS);
      }
      try
      {
        localj.a(new j.c((byte)0), localj.akU());
        localj.akV();
        localj.akW();
        if (AppBrandVideoView.A(this.gDS)) {
          this.gDS.D(0, true);
        }
        return;
        if (AppBrandVideoView.y(this.gDS) <= 0) {
          AppBrandVideoView.z(this.gDS).setText(AppBrandVideoView.lD(AppBrandVideoView.b(this.gDS).getVideoDurationSec()));
        }
        AppBrandVideoView.x(this.gDS).setVisibility(0);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[] { localJSONException });
        }
      }
    }
  }
  
  public final void akv()
  {
    y.i("MicroMsg.AppBrandVideoView", "onVideoPause");
    j localj;
    if (AppBrandVideoView.d(this.gDS) != null) {
      localj = AppBrandVideoView.d(this.gDS);
    }
    try
    {
      localj.a(new j.f((byte)0), localj.akU());
      localj.akV();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiVideoCallback", "OnVideoPause e=%s", new Object[] { localJSONException });
      }
    }
  }
  
  public final void akw()
  {
    y.i("MicroMsg.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.v(this.gDS)) });
    if ((AppBrandVideoView.y(this.gDS) <= 0) && (!AppBrandVideoView.v(this.gDS))) {
      AppBrandVideoView.z(this.gDS).setText(AppBrandVideoView.lD(AppBrandVideoView.b(this.gDS).getVideoDurationSec()));
    }
    AppBrandVideoView.a(this.gDS, AppBrandVideoView.v(this.gDS));
    if (AppBrandVideoView.f(this.gDS)) {
      AppBrandVideoView.F(this.gDS);
    }
    j localj;
    if (AppBrandVideoView.d(this.gDS) != null) {
      localj = AppBrandVideoView.d(this.gDS);
    }
    try
    {
      localj.gEP = 0;
      JSONObject localJSONObject = localj.akU();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localj.a(new j.g((byte)0), localJSONObject);
      if (localj.gEO == null) {
        localj.gEO = new am(new j.1(localj), true);
      }
      localj.gEO.S(250L, 250L);
      if (localj.gEg == null) {
        localj.gEg = new am(new j.2(localj), true);
      }
      localj.gEg.S(500L, 500L);
      return;
    }
    catch (JSONException localJSONException)
    {
      y.e("MicroMsg.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[] { localJSONException });
    }
  }
  
  public final void akx()
  {
    y.i("MicroMsg.AppBrandVideoView", "onVideoWaiting");
    j localj;
    if (AppBrandVideoView.d(this.gDS) != null) {
      localj = AppBrandVideoView.d(this.gDS);
    }
    try
    {
      JSONObject localJSONObject = localj.akU();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localj.a(new j.l((byte)0), localJSONObject);
      AppBrandVideoView.c(this.gDS, true);
      AppBrandVideoView.j(this.gDS);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.e("MicroMsg.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[] { localJSONException });
      }
    }
  }
  
  public final void aky()
  {
    AppBrandVideoView.c(this.gDS, false);
    AppBrandVideoView.n(this.gDS);
  }
  
  public final void bY(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppBrandVideoView localAppBrandVideoView;
    if (AppBrandVideoView.B(this.gDS) == -1)
    {
      localAppBrandVideoView = this.gDS;
      if (paramInt1 >= paramInt2) {
        break label81;
      }
    }
    label81:
    for (paramInt1 = 0;; paramInt1 = 90)
    {
      AppBrandVideoView.a(localAppBrandVideoView, paramInt1);
      y.i("MicroMsg.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(AppBrandVideoView.B(this.gDS)) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.11
 * JD-Core Version:    0.7.0.1
 */