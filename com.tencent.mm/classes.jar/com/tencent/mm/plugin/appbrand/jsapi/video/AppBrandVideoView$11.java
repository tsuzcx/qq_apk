package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandVideoView$11
  implements e.c
{
  AppBrandVideoView$11(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194083);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (AppBrandVideoView.d(this.kOS) != null)
    {
      paramString1 = AppBrandVideoView.d(this.kOS);
      paramString1.clean();
      try
      {
        paramString2 = paramString1.bkx();
        paramString2.put("errMsg", paramString3);
        paramString1.a(new b.d((byte)0), paramString2);
        AppMethodBeat.o(194083);
        return;
      }
      catch (JSONException paramString1)
      {
        ac.e("MicroMsg.Video.JsApiVideoCallback", "onError e=%s", new Object[] { paramString1 });
      }
    }
    AppMethodBeat.o(194083);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194086);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (AppBrandVideoView.F(this.kOS) == -1)
    {
      paramString1 = this.kOS;
      if (paramInt1 >= paramInt2) {
        break label205;
      }
    }
    for (int i = 0;; i = 90)
    {
      AppBrandVideoView.b(paramString1, i);
      ac.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(AppBrandVideoView.F(this.kOS)) });
      if (AppBrandVideoView.d(this.kOS) == null) {
        break label228;
      }
      paramString1 = AppBrandVideoView.d(this.kOS);
      i = this.kOS.getDuration();
      try
      {
        ac.i("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        paramString2 = paramString1.bkx();
        paramString2.put("width", paramInt1);
        paramString2.put("height", paramInt2);
        paramString2.put("duration", i * 1.0D / 1000.0D);
        paramString1.a(new b.f((byte)0), paramString2);
        AppMethodBeat.o(194086);
        return;
      }
      catch (JSONException paramString1)
      {
        label205:
        ac.e("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", new Object[] { paramString1 });
      }
    }
    label228:
    AppMethodBeat.o(194086);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194084);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onPrepared");
    AppBrandVideoView.a(this.kOS, 0);
    AppBrandVideoView.t(this.kOS);
    AppBrandVideoView.u(this.kOS);
    if (AppBrandVideoView.v(this.kOS)) {
      this.kOS.start();
    }
    AppBrandVideoView.w(this.kOS).bkY();
    if (AppBrandVideoView.d(this.kOS) != null) {
      AppBrandVideoView.d(this.kOS);
    }
    AppMethodBeat.o(194084);
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194085);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
    AppBrandVideoView.x(this.kOS);
    AppBrandVideoView.m(this.kOS).setVisibility(8);
    AppBrandVideoView.h(this.kOS).setIsPlay(false);
    if ((AppBrandVideoView.h(this.kOS).bjw()) && (AppBrandVideoView.h(this.kOS).bjz())) {
      AppBrandVideoView.h(this.kOS).hide();
    }
    if (AppBrandVideoView.y(this.kOS).getVisibility() == 0) {
      AppBrandVideoView.y(this.kOS).setVisibility(8);
    }
    if ((AppBrandVideoView.z(this.kOS)) || (!AppBrandVideoView.A(this.kOS)))
    {
      AppBrandVideoView.B(this.kOS).setVisibility(8);
      AppBrandVideoView.g(this.kOS).setVisibility(8);
    }
    for (;;)
    {
      if (AppBrandVideoView.d(this.kOS) != null) {
        paramString1 = AppBrandVideoView.d(this.kOS);
      }
      try
      {
        paramString1.a(new b.c((byte)0), paramString1.bkx());
        paramString1.bky();
        if (AppBrandVideoView.E(this.kOS)) {
          this.kOS.d(0.0D, true);
        }
        AppMethodBeat.o(194085);
        return;
        if (AppBrandVideoView.C(this.kOS) <= 0) {
          AppBrandVideoView.D(this.kOS).setText(AppBrandVideoView.sP(AppBrandVideoView.b(this.kOS).getVideoDurationSec()));
        }
        AppBrandVideoView.B(this.kOS).setVisibility(0);
        AppBrandVideoView.g(this.kOS).setVisibility(0);
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          ac.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[] { paramString2 });
        }
      }
    }
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194087);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
    if (AppBrandVideoView.d(this.kOS) != null) {
      paramString1 = AppBrandVideoView.d(this.kOS);
    }
    try
    {
      paramString1.a(new b.g((byte)0), paramString1.bkx());
      paramString1.bky();
      AppMethodBeat.o(194087);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        ac.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPause e=%s", new Object[] { paramString2 });
      }
    }
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194088);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.z(this.kOS)) });
    if ((AppBrandVideoView.C(this.kOS) <= 0) && (!AppBrandVideoView.z(this.kOS))) {
      AppBrandVideoView.D(this.kOS).setText(AppBrandVideoView.sP(AppBrandVideoView.b(this.kOS).getVideoDurationSec()));
    }
    AppBrandVideoView.a(this.kOS, AppBrandVideoView.z(this.kOS));
    if (AppBrandVideoView.f(this.kOS)) {
      AppBrandVideoView.G(this.kOS);
    }
    if (AppBrandVideoView.d(this.kOS) != null) {
      paramString1 = AppBrandVideoView.d(this.kOS);
    }
    try
    {
      paramString1.kTl = 0;
      paramString2 = paramString1.bkx();
      paramString2.put("timeStamp", System.currentTimeMillis());
      paramString1.a(new b.h((byte)0), paramString2);
      if (paramString1.kTk == null) {
        paramString1.kTk = new au(new b.1(paramString1), true);
      }
      paramString1.kTk.au(250L, 250L);
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ac.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[] { paramString1 });
      }
    }
    if ((AppBrandVideoView.H(this.kOS) != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(AppBrandVideoView.H(this.kOS).getAppId())))
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, send play event");
      com.tencent.mm.sdk.b.a.GpY.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
    }
    AppMethodBeat.o(194088);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194089);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
    if (AppBrandVideoView.d(this.kOS) != null) {
      paramString1 = AppBrandVideoView.d(this.kOS);
    }
    try
    {
      paramString2 = paramString1.bkx();
      paramString2.put("timeStamp", System.currentTimeMillis());
      paramString1.a(new b.m((byte)0), paramString2);
      AppBrandVideoView.b(this.kOS, true);
      AppBrandVideoView.j(this.kOS);
      AppMethodBeat.o(194089);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ac.e("MicroMsg.Video.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[] { paramString1 });
      }
    }
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(194090);
    AppBrandVideoView.b(this.kOS, false);
    AppBrandVideoView.n(this.kOS);
    AppMethodBeat.o(194090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.11
 * JD-Core Version:    0.7.0.1
 */