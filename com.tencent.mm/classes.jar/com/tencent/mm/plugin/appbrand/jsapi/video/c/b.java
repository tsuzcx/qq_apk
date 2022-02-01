package com.tencent.mm.plugin.appbrand.jsapi.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements h.c
{
  private AppBrandVideoView pzg;
  private g pzh;
  public MTimerHandler pzi;
  public int pzj;
  
  public b(AppBrandVideoView paramAppBrandVideoView, g paramg)
  {
    AppMethodBeat.i(228492);
    this.pzg = paramAppBrandVideoView;
    this.pzh = paramg;
    this.pzh.a(this);
    AppMethodBeat.o(228492);
  }
  
  public final void a(az paramaz, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(228503);
    if ((!(paramaz instanceof l)) && (!(paramaz instanceof i))) {
      Log.i("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { paramaz.getName() });
    }
    this.pzh.a(paramaz.agU(paramJSONObject.toString()), null);
    AppMethodBeat.o(228503);
  }
  
  public final JSONObject bWg()
  {
    AppMethodBeat.i(228505);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.pzg.getCookieData());
    AppMethodBeat.o(228505);
    return localJSONObject;
  }
  
  public final void bWh()
  {
    AppMethodBeat.i(228506);
    if (this.pzi != null) {
      this.pzi.stopTimer();
    }
    AppMethodBeat.o(228506);
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(228497);
    try
    {
      Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = bWg();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new b.e((byte)0), localJSONObject);
      AppMethodBeat.o(228497);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
      AppMethodBeat.o(228497);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(228496);
    this.pzh.b(this);
    bWh();
    AppMethodBeat.o(228496);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(228494);
    Log.d("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.pzg.setCallback(null);
    AppMethodBeat.o(228494);
  }
  
  public static final class i
    extends az
  {
    private static final int CTRL_INDEX = 548;
    private static final String NAME = "onVideoProgress";
  }
  
  public static final class j
    extends az
  {
    private static final int CTRL_INDEX = 484;
    private static final String NAME = "onVideoResourceError";
  }
  
  public static final class k
    extends az
  {
    private static final int CTRL_INDEX = 483;
    private static final String NAME = "onVideoResourceLoad";
  }
  
  static final class l
    extends az
  {
    private static final int CTRL_INDEX = 138;
    private static final String NAME = "onVideoTimeUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c.b
 * JD-Core Version:    0.7.0.1
 */