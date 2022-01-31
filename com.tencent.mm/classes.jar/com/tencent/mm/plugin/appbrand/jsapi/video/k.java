package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;
import org.json.JSONObject;

public final class k
  implements f.c
{
  AppBrandVideoView idQ;
  private e idR;
  ap idS;
  int idT;
  int idU;
  ap idl;
  
  public k(AppBrandVideoView paramAppBrandVideoView, e parame)
  {
    AppMethodBeat.i(126572);
    this.idU = 0;
    this.idQ = paramAppBrandVideoView;
    this.idR = parame;
    this.idR.a(this);
    AppMethodBeat.o(126572);
  }
  
  final void a(ai paramai, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126576);
    if ((!(paramai instanceof k.l)) && (!(paramai instanceof k.i))) {
      ab.i("MicroMsg.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { paramai.getName() });
    }
    this.idR.b(paramai.BN(paramJSONObject.toString()));
    AppMethodBeat.o(126576);
  }
  
  final JSONObject aFD()
  {
    AppMethodBeat.i(126577);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.idQ.getCookieData());
    AppMethodBeat.o(126577);
    return localJSONObject;
  }
  
  final void aFE()
  {
    AppMethodBeat.i(126578);
    if (this.idS != null) {
      this.idS.stopTimer();
    }
    AppMethodBeat.o(126578);
  }
  
  final void aFF()
  {
    AppMethodBeat.i(126579);
    if (this.idl != null) {
      this.idl.stopTimer();
    }
    AppMethodBeat.o(126579);
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(126575);
    try
    {
      ab.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = aFD();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new k.e((byte)0), localJSONObject);
      AppMethodBeat.o(126575);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
      AppMethodBeat.o(126575);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(126574);
    this.idR.b(this);
    aFE();
    aFF();
    AppMethodBeat.o(126574);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126573);
    ab.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.idQ.setCallback(null);
    AppMethodBeat.o(126573);
  }
  
  static final class b
    extends ai
  {
    private static final int CTRL_INDEX = 131;
    private static final String NAME = "onVideoClickDanmuBtn";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.k
 * JD-Core Version:    0.7.0.1
 */