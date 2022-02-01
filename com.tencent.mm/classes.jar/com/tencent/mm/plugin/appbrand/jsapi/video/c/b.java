package com.tencent.mm.plugin.appbrand.jsapi.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements f.c
{
  AppBrandVideoView kTi;
  private e kTj;
  public au kTk;
  public int kTl;
  
  public b(AppBrandVideoView paramAppBrandVideoView, e parame)
  {
    AppMethodBeat.i(194398);
    this.kTi = paramAppBrandVideoView;
    this.kTj = parame;
    this.kTj.a(this);
    AppMethodBeat.o(194398);
  }
  
  public final void a(ar paramar, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(194402);
    if ((!(paramar instanceof l)) && (!(paramar instanceof i))) {
      ac.i("MicroMsg.Video.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { paramar.getName() });
    }
    this.kTj.b(paramar.LO(paramJSONObject.toString()));
    AppMethodBeat.o(194402);
  }
  
  public final JSONObject bkx()
  {
    AppMethodBeat.i(194403);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.kTi.getCookieData());
    AppMethodBeat.o(194403);
    return localJSONObject;
  }
  
  public final void bky()
  {
    AppMethodBeat.i(194404);
    if (this.kTk != null) {
      this.kTk.stopTimer();
    }
    AppMethodBeat.o(194404);
  }
  
  public final void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(194401);
    try
    {
      ac.i("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
      JSONObject localJSONObject = bkx();
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("videoPlayerId", paramInt1);
      localJSONObject.put("direction", paramInt2);
      a(new e((byte)0), localJSONObject);
      AppMethodBeat.o(194401);
      return;
    }
    catch (JSONException localJSONException)
    {
      ac.e("MicroMsg.Video.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[] { localJSONException });
      AppMethodBeat.o(194401);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(194400);
    this.kTj.b(this);
    bky();
    AppMethodBeat.o(194400);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(194399);
    ac.d("MicroMsg.Video.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.kTi.setCallback(null);
    AppMethodBeat.o(194399);
  }
  
  public static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 480;
    private static final String NAME = "onVideoCanPlay";
  }
  
  public static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 131;
    private static final String NAME = "onVideoClickDanmuBtn";
  }
  
  public static final class c
    extends ar
  {
    private static final int CTRL_INDEX = 129;
    private static final String NAME = "onVideoEnded";
  }
  
  public static final class d
    extends ar
  {
    private static final int CTRL_INDEX = 349;
    private static final String NAME = "onVideoError";
  }
  
  static final class e
    extends ar
  {
    private static final int CTRL_INDEX = 130;
    private static final String NAME = "onVideoFullScreenChange";
  }
  
  public static final class f
    extends ar
  {
    private static final int CTRL_INDEX = 628;
    private static final String NAME = "onVideoLoadedMetaData";
  }
  
  public static final class g
    extends ar
  {
    private static final int CTRL_INDEX = 128;
    private static final String NAME = "onVideoPause";
  }
  
  public static final class h
    extends ar
  {
    private static final int CTRL_INDEX = 127;
    private static final String NAME = "onVideoPlay";
  }
  
  public static final class i
    extends ar
  {
    private static final int CTRL_INDEX = 548;
    private static final String NAME = "onVideoProgress";
  }
  
  public static final class j
    extends ar
  {
    private static final int CTRL_INDEX = 484;
    private static final String NAME = "onVideoResourceError";
  }
  
  public static final class k
    extends ar
  {
    private static final int CTRL_INDEX = 483;
    private static final String NAME = "onVideoResourceLoad";
  }
  
  static final class l
    extends ar
  {
    private static final int CTRL_INDEX = 138;
    private static final String NAME = "onVideoTimeUpdate";
  }
  
  public static final class m
    extends ar
  {
    private static final int CTRL_INDEX = 350;
    private static final String NAME = "onVideoWaiting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.c.b
 * JD-Core Version:    0.7.0.1
 */