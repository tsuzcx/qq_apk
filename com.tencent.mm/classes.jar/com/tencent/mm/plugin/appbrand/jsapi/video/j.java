package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class j
  implements e.c
{
  AppBrandVideoView gEM;
  private e gEN;
  am gEO;
  int gEP;
  int gEQ = 0;
  am gEg;
  
  public j(AppBrandVideoView paramAppBrandVideoView, e parame)
  {
    this.gEM = paramAppBrandVideoView;
    this.gEN = parame;
    this.gEN.a(this);
  }
  
  final void a(ac paramac, JSONObject paramJSONObject)
  {
    if ((!(paramac instanceof k)) && (!(paramac instanceof j.h))) {
      y.i("MicroMsg.JsApiVideoCallback", "dispatchEvent event %s", new Object[] { paramac.getName() });
    }
    this.gEN.b(paramac.tM(paramJSONObject.toString()));
  }
  
  final JSONObject akU()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.gEM.getCookieData());
    return localJSONObject;
  }
  
  final void akV()
  {
    if (this.gEO != null) {
      this.gEO.stopTimer();
    }
  }
  
  final void akW()
  {
    if (this.gEg != null) {
      this.gEg.stopTimer();
    }
  }
  
  public final void clean()
  {
    this.gEN.b(this);
    akV();
    akW();
  }
  
  public final void onDestroy()
  {
    y.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
    clean();
    this.gEM.setCallback(null);
  }
  
  private static final class k
    extends ac
  {
    private static final int CTRL_INDEX = 138;
    private static final String NAME = "onVideoTimeUpdate";
  }
  
  private static final class l
    extends ac
  {
    private static final int CTRL_INDEX = 350;
    private static final String NAME = "onVideoWaiting";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.j
 * JD-Core Version:    0.7.0.1
 */