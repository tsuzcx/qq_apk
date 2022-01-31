package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;
import org.json.JSONObject;

final class AppBrandVideoView$11
  implements d.b
{
  AppBrandVideoView$11(AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145897);
    ab.i("MicroMsg.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (AppBrandVideoView.d(this.icX) != null)
    {
      paramString1 = AppBrandVideoView.d(this.icX);
      paramString1.clean();
      try
      {
        paramString2 = paramString1.aFD();
        paramString2.put("errMsg", paramString3);
        paramString1.a(new k.d((byte)0), paramString2);
        AppMethodBeat.o(145897);
        return;
      }
      catch (JSONException paramString1)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "onError e=%s", new Object[] { paramString1 });
      }
    }
    AppMethodBeat.o(145897);
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145898);
    ab.i("MicroMsg.AppBrandVideoView", "onPrepared");
    AppBrandVideoView.t(this.icX).aFG();
    AppMethodBeat.o(145898);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145899);
    ab.i("MicroMsg.AppBrandVideoView", "onVideoEnded");
    AppBrandVideoView.m(this.icX).setVisibility(8);
    AppBrandVideoView.g(this.icX).setVisibility(0);
    if (AppBrandVideoView.h(this.icX).Pk()) {
      AppBrandVideoView.h(this.icX).hide();
    }
    if (AppBrandVideoView.u(this.icX).getVisibility() == 0) {
      AppBrandVideoView.u(this.icX).setVisibility(8);
    }
    if ((AppBrandVideoView.v(this.icX)) || (!AppBrandVideoView.w(this.icX))) {
      AppBrandVideoView.x(this.icX).setVisibility(8);
    }
    for (;;)
    {
      if (AppBrandVideoView.d(this.icX) != null) {
        paramString1 = AppBrandVideoView.d(this.icX);
      }
      try
      {
        paramString1.a(new k.c((byte)0), paramString1.aFD());
        paramString1.aFE();
        paramString1.aFF();
        if (AppBrandVideoView.A(this.icX)) {
          this.icX.e(0.0D, true);
        }
        AppMethodBeat.o(145899);
        return;
        if (AppBrandVideoView.y(this.icX) <= 0) {
          AppBrandVideoView.z(this.icX).setText(AppBrandVideoView.om(AppBrandVideoView.b(this.icX).getVideoDurationSec()));
        }
        AppBrandVideoView.x(this.icX).setVisibility(0);
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          ab.e("MicroMsg.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[] { paramString2 });
        }
      }
    }
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145901);
    ab.i("MicroMsg.AppBrandVideoView", "onVideoPause");
    if (AppBrandVideoView.d(this.icX) != null) {
      paramString1 = AppBrandVideoView.d(this.icX);
    }
    try
    {
      paramString1.a(new k.g((byte)0), paramString1.aFD());
      paramString1.aFE();
      AppMethodBeat.o(145901);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "OnVideoPause e=%s", new Object[] { paramString2 });
      }
    }
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145902);
    ab.i("MicroMsg.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.v(this.icX)) });
    if ((AppBrandVideoView.y(this.icX) <= 0) && (!AppBrandVideoView.v(this.icX))) {
      AppBrandVideoView.z(this.icX).setText(AppBrandVideoView.om(AppBrandVideoView.b(this.icX).getVideoDurationSec()));
    }
    AppBrandVideoView.a(this.icX, AppBrandVideoView.v(this.icX));
    if (AppBrandVideoView.f(this.icX)) {
      AppBrandVideoView.C(this.icX);
    }
    if (AppBrandVideoView.d(this.icX) != null)
    {
      paramString1 = AppBrandVideoView.d(this.icX);
      try
      {
        paramString1.idT = 0;
        paramString2 = paramString1.aFD();
        paramString2.put("timeStamp", System.currentTimeMillis());
        paramString1.a(new k.h((byte)0), paramString2);
        if (paramString1.idS == null) {
          paramString1.idS = new ap(new k.1(paramString1), true);
        }
        paramString1.idS.ag(250L, 250L);
        if (paramString1.idl == null) {
          paramString1.idl = new ap(new k.2(paramString1), true);
        }
        paramString1.idl.ag(500L, 500L);
        AppMethodBeat.o(145902);
        return;
      }
      catch (JSONException paramString1)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[] { paramString1 });
      }
    }
    AppMethodBeat.o(145902);
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145903);
    ab.i("MicroMsg.AppBrandVideoView", "onVideoWaiting");
    if (AppBrandVideoView.d(this.icX) != null) {
      paramString1 = AppBrandVideoView.d(this.icX);
    }
    try
    {
      paramString2 = paramString1.aFD();
      paramString2.put("timeStamp", System.currentTimeMillis());
      paramString1.a(new k.m((byte)0), paramString2);
      AppBrandVideoView.b(this.icX, true);
      AppBrandVideoView.j(this.icX);
      AppMethodBeat.o(145903);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ab.e("MicroMsg.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[] { paramString1 });
      }
    }
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145904);
    AppBrandVideoView.b(this.icX, false);
    AppBrandVideoView.n(this.icX);
    AppMethodBeat.o(145904);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145900);
    ab.i("MicroMsg.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (AppBrandVideoView.B(this.icX) == -1)
    {
      paramString1 = this.icX;
      if (paramInt1 >= paramInt2) {
        break label213;
      }
    }
    for (int i = 0;; i = 90)
    {
      AppBrandVideoView.a(paramString1, i);
      ab.i("MicroMsg.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(AppBrandVideoView.B(this.icX)) });
      if (AppBrandVideoView.d(this.icX) == null) {
        break label237;
      }
      paramString1 = AppBrandVideoView.d(this.icX);
      i = this.icX.getDuration();
      try
      {
        ab.i("MicroMsg.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
        paramString2 = paramString1.aFD();
        paramString2.put("width", paramInt1);
        paramString2.put("height", paramInt2);
        paramString2.put("duration", i * 1.0D / 1000.0D);
        paramString1.a(new k.f((byte)0), paramString2);
        AppMethodBeat.o(145900);
        return;
      }
      catch (JSONException paramString1)
      {
        label213:
        ab.e("MicroMsg.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", new Object[] { paramString1 });
      }
    }
    label237:
    AppMethodBeat.o(145900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.11
 * JD-Core Version:    0.7.0.1
 */