package com.tencent.mm.plugin.appbrand.jsapi.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements f.c
{
  AppBrandVideoView krQ;
  private e krR;
  public av krS;
  public int krT;
  public av krU;
  public int krV;
  
  public b(AppBrandVideoView paramAppBrandVideoView, e parame)
  {
    AppMethodBeat.i(194052);
    this.krV = 0;
    this.krQ = paramAppBrandVideoView;
    this.krR = parame;
    this.krR.a(this);
    AppMethodBeat.o(194052);
  }
  
  public final void a(ar paramar, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194056);
    if ((!(paramar instanceof b.l)) && (!(paramar instanceof b.i))) {
      ad.i("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { paramar.getName() });
    }
    this.krR.b(paramar.HK(paramJSONObject.toString()));
    AppMethodBeat.o(194056);
  }
  
  public final JSONObject bdC()
  {
    AppMethodBeat.i(194057);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.krQ.getCookieData());
    AppMethodBeat.o(194057);
    return localJSONObject;
  }
  
  public final void bdD()
  {
    AppMethodBeat.i(194058);
    if (this.krS != null) {
      this.krS.stopTimer();
    }
    AppMethodBeat.o(194058);
  }
  
  public final void bdE()
  {
    AppMethodBeat.i(194059);
    if (this.krU != null) {
      this.krU.stopTimer();
    }
    AppMethodBeat.o(194059);
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(194055);
    try
    {
      ad.i("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = bdC();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new b.e((byte)0), localJSONObject);
      AppMethodBeat.o(194055);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
      AppMethodBeat.o(194055);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(194054);
    this.krR.b(this);
    bdD();
    bdE();
    AppMethodBeat.o(194054);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(194053);
    ad.d("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.krQ.setCallback(null);
    AppMethodBeat.o(194053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c.b
 * JD-Core Version:    0.7.0.1
 */