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

public final class b
  implements i.c
{
  AppBrandVideoView mAK;
  private h mAL;
  public MTimerHandler mAM;
  public int mAN;
  
  public b(AppBrandVideoView paramAppBrandVideoView, h paramh)
  {
    AppMethodBeat.i(234907);
    this.mAK = paramAppBrandVideoView;
    this.mAL = paramh;
    this.mAL.a(this);
    AppMethodBeat.o(234907);
  }
  
  public final void a(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(234911);
    if ((!(parambc instanceof l)) && (!(parambc instanceof i))) {
      Log.i("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { parambc.getName() });
    }
    this.mAL.a(parambc.Zh(paramJSONObject.toString()), null);
    AppMethodBeat.o(234911);
  }
  
  public final JSONObject bKv()
  {
    AppMethodBeat.i(234912);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.mAK.getCookieData());
    AppMethodBeat.o(234912);
    return localJSONObject;
  }
  
  public final void bKw()
  {
    AppMethodBeat.i(234913);
    if (this.mAM != null) {
      this.mAM.stopTimer();
    }
    AppMethodBeat.o(234913);
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(234910);
    try
    {
      Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = bKv();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new b.e((byte)0), localJSONObject);
      AppMethodBeat.o(234910);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
      AppMethodBeat.o(234910);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(234909);
    this.mAL.b(this);
    bKw();
    AppMethodBeat.o(234909);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(234908);
    Log.d("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.mAK.setCallback(null);
    AppMethodBeat.o(234908);
  }
  
  public static final class i
    extends bc
  {
    private static final int CTRL_INDEX = 548;
    private static final String NAME = "onVideoProgress";
  }
  
  public static final class j
    extends bc
  {
    private static final int CTRL_INDEX = 484;
    private static final String NAME = "onVideoResourceError";
  }
  
  public static final class k
    extends bc
  {
    private static final int CTRL_INDEX = 483;
    private static final String NAME = "onVideoResourceLoad";
  }
  
  static final class l
    extends bc
  {
    private static final int CTRL_INDEX = 138;
    private static final String NAME = "onVideoTimeUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c.b
 * JD-Core Version:    0.7.0.1
 */