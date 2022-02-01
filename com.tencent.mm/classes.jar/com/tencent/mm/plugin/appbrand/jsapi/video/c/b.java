package com.tencent.mm.plugin.appbrand.jsapi.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
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
  AppBrandVideoView lpL;
  private e lpM;
  public av lpN;
  public int lpO;
  
  public b(AppBrandVideoView paramAppBrandVideoView, e parame)
  {
    AppMethodBeat.i(206210);
    this.lpL = paramAppBrandVideoView;
    this.lpM = parame;
    this.lpM.a(this);
    AppMethodBeat.o(206210);
  }
  
  public final void a(at paramat, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(206214);
    if ((!(paramat instanceof b.l)) && (!(paramat instanceof b.i))) {
      ad.i("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { paramat.getName() });
    }
    this.lpM.b(paramat.Pi(paramJSONObject.toString()));
    AppMethodBeat.o(206214);
  }
  
  public final JSONObject boi()
  {
    AppMethodBeat.i(206215);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.lpL.getCookieData());
    AppMethodBeat.o(206215);
    return localJSONObject;
  }
  
  public final void boj()
  {
    AppMethodBeat.i(206216);
    if (this.lpN != null) {
      this.lpN.stopTimer();
    }
    AppMethodBeat.o(206216);
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(206213);
    try
    {
      ad.i("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = boi();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new b.e((byte)0), localJSONObject);
      AppMethodBeat.o(206213);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
      AppMethodBeat.o(206213);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(206212);
    this.lpM.b(this);
    boj();
    AppMethodBeat.o(206212);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206211);
    ad.d("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.lpL.setCallback(null);
    AppMethodBeat.o(206211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c.b
 * JD-Core Version:    0.7.0.1
 */