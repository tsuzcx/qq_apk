package com.tencent.mm.plugin.appbrand.jsapi.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements f.c
{
  AppBrandVideoView lui;
  private e luj;
  public aw luk;
  public int lul;
  
  public b(AppBrandVideoView paramAppBrandVideoView, e parame)
  {
    AppMethodBeat.i(211238);
    this.lui = paramAppBrandVideoView;
    this.luj = parame;
    this.luj.a(this);
    AppMethodBeat.o(211238);
  }
  
  public final void a(at paramat, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(211242);
    if ((!(paramat instanceof b.l)) && (!(paramat instanceof b.i))) {
      ae.i("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { paramat.getName() });
    }
    this.luj.b(paramat.PQ(paramJSONObject.toString()));
    AppMethodBeat.o(211242);
  }
  
  public final JSONObject boS()
  {
    AppMethodBeat.i(211243);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.lui.getCookieData());
    AppMethodBeat.o(211243);
    return localJSONObject;
  }
  
  public final void boT()
  {
    AppMethodBeat.i(211244);
    if (this.luk != null) {
      this.luk.stopTimer();
    }
    AppMethodBeat.o(211244);
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(211241);
    try
    {
      ae.i("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = boS();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new b.e((byte)0), localJSONObject);
      AppMethodBeat.o(211241);
      return;
    }
    catch (JSONException localJSONException)
    {
      ae.e("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
      AppMethodBeat.o(211241);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(211240);
    this.luj.b(this);
    boT();
    AppMethodBeat.o(211240);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(211239);
    ae.d("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.lui.setCallback(null);
    AppMethodBeat.o(211239);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c.b
 * JD-Core Version:    0.7.0.1
 */