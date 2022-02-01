package com.tencent.mm.plugin.appbrand.jsapi.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements i.c
{
  private AppBrandVideoView sEl;
  private h sEm;
  public MTimerHandler sEn;
  public int sEo;
  
  public b(AppBrandVideoView paramAppBrandVideoView, h paramh)
  {
    AppMethodBeat.i(328279);
    this.sEl = paramAppBrandVideoView;
    this.sEm = paramh;
    this.sEm.a(this);
    AppMethodBeat.o(328279);
  }
  
  public final void a(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(328346);
    if ((!(parambc instanceof b.l)) && (!(parambc instanceof b.i))) {
      Log.i("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { parambc.getName() });
    }
    this.sEm.a(parambc.ZR(paramJSONObject.toString()), null);
    AppMethodBeat.o(328346);
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(328334);
    try
    {
      Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = cws();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new b.e((byte)0), localJSONObject);
      AppMethodBeat.o(328334);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
      AppMethodBeat.o(328334);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(328328);
    this.sEm.b(this);
    cwt();
    AppMethodBeat.o(328328);
  }
  
  public final JSONObject cws()
  {
    AppMethodBeat.i(328356);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.sEl.getCookieData());
    AppMethodBeat.o(328356);
    return localJSONObject;
  }
  
  public final void cwt()
  {
    AppMethodBeat.i(328363);
    if (this.sEn != null) {
      this.sEn.stopTimer();
    }
    AppMethodBeat.o(328363);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(328320);
    Log.d("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.sEl.setCallback(null);
    AppMethodBeat.o(328320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c.b
 * JD-Core Version:    0.7.0.1
 */