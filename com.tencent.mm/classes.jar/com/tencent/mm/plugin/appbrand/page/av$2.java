package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

final class av$2
  implements ay.a
{
  private final String izu = "page-frame.html";
  private boolean izv = false;
  private boolean izw = false;
  
  av$2(av paramav) {}
  
  private String aJR()
  {
    AppMethodBeat.i(140890);
    String str = aJQ() + "page-frame.html";
    AppMethodBeat.o(140890);
    return str;
  }
  
  private void aJS()
  {
    AppMethodBeat.i(140891);
    av localav = this.izr;
    Object localObject2 = localav.getContext();
    Object localObject1 = new JSONObject();
    localObject2 = ((Context)localObject2).getResources().getDisplayMetrics();
    localav.b((JSONObject)localObject1, "width", Integer.valueOf((int)Math.ceil(((DisplayMetrics)localObject2).widthPixels / ((DisplayMetrics)localObject2).density)));
    localav.b((JSONObject)localObject1, "pixelRatio", Float.valueOf(((DisplayMetrics)localObject2).density));
    localObject1 = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; };", new Object[] { ((JSONObject)localObject1).toString() });
    ((com.tencent.luggage.sdk.b.a.c)localav.bDN).aAO().evaluateJavascript((String)localObject1, null);
    if (!this.izv)
    {
      this.izr.cN("wxa_library/android.js", com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/android.js"));
      this.izv = true;
    }
    if (!this.izw)
    {
      this.izr.cN("WAWebview.js", ((n)av.a(this.izr, n.class)).yl("WAWebview.js"));
      this.izw = true;
    }
    AppMethodBeat.o(140891);
  }
  
  final String aJQ()
  {
    AppMethodBeat.i(140889);
    String str = "https://servicewechat.com/" + String.format(Locale.US, "%s/%d/", new Object[] { this.izr.getAppId(), Integer.valueOf(this.izr.wj().wR().hiX.gXf) });
    AppMethodBeat.o(140889);
    return str;
  }
  
  public final void aJT()
  {
    AppMethodBeat.i(140894);
    u.e((v)av.h(this.izr));
    Object localObject = this.izr;
    ((a)localObject).iuz = false;
    ((a)localObject).bX(((a)localObject).iuB);
    localObject = new l();
    v localv = (v)av.i(this.izr);
    com.tencent.luggage.sdk.b.a.c.c localc = ((com.tencent.luggage.sdk.b.a.c)av.j(this.izr)).wk();
    HashMap localHashMap = new HashMap();
    localHashMap.put("path", localv.hzM);
    ((l)localObject).w(localHashMap).a(localc, localv.hashCode()).aBz();
    AppMethodBeat.o(140894);
  }
  
  public final boolean aJU()
  {
    AppMethodBeat.i(140895);
    boolean bool = u.f((v)av.k(this.izr));
    if (bool)
    {
      this.izr.iuE.removeAll();
      this.izv = false;
      this.izw = false;
    }
    AppMethodBeat.o(140895);
    return bool;
  }
  
  public final String aJV()
  {
    AppMethodBeat.i(140896);
    String str = aJQ();
    AppMethodBeat.o(140896);
    return str;
  }
  
  public final v aJW()
  {
    AppMethodBeat.i(140897);
    v localv = (v)av.l(this.izr);
    AppMethodBeat.o(140897);
    return localv;
  }
  
  public final void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(140892);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.jsapi.i.a((com.tencent.luggage.sdk.b.a.c)av.c(this.izr), ((com.tencent.luggage.sdk.b.a.c)av.b(this.izr)).auh());
      aJS();
      AppMethodBeat.o(140892);
      return;
    }
    Object localObject = this.izr;
    String str = com.tencent.mm.plugin.appbrand.s.d.Fj("wxa_library/object_polyfill.js");
    if (!TextUtils.isEmpty(str)) {
      ((com.tencent.luggage.sdk.b.a.c)((a.a)localObject).bDN).aAO().evaluateJavascript(str, null);
    }
    while (!((com.tencent.luggage.sdk.b.a.c)((a.a)localObject).bDN).gPS)
    {
      this.izr.aJN().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { aJR() }), null);
      this.izr.aJN().d(";(function(){return window.devicePixelRatio})();", new av.2.1(this));
      localObject = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { ((com.tencent.luggage.sdk.b.a.c)av.d(this.izr)).wE().toString() });
      ((com.tencent.luggage.sdk.b.a.c)av.e(this.izr)).aAO().evaluateJavascript((String)localObject, null);
      aJS();
      if ((this.izr.wj().wR().bDj) && (!this.izr.wj().wV())) {
        this.izr.cN("WAVConsole.js", ((n)av.b(this.izr, n.class)).yl("WAVConsole.js"));
      }
      if (AppBrandPerformanceManager.d(this.izr.wj())) {
        this.izr.cN("WAPerf.js", ((n)av.c(this.izr, n.class)).yl("WAPerf.js"));
      }
      if (this.izr.wj().wV()) {
        this.izr.cN("WARemoteDebug.js", ((n)av.d(this.izr, n.class)).yl("WARemoteDebug.js"));
      }
      localObject = String.format(Locale.US, ";if(__wxConfig.preload){ %s };", new Object[] { bs.r("onWxConfigReady", "", 0) });
      ((com.tencent.luggage.sdk.b.a.c)av.f(this.izr)).aAO().evaluateJavascript((String)localObject, null);
      this.izr.aIF();
      AppMethodBeat.o(140892);
      return;
    }
    localObject = new IllegalAccessError("Cannot find object_polyfill.js");
    AppMethodBeat.o(140892);
    throw ((Throwable)localObject);
  }
  
  public final void eH(boolean paramBoolean)
  {
    AppMethodBeat.i(140893);
    if (paramBoolean) {}
    for (String str1 = "https://servicewechat.com/preload/page-frame.html";; str1 = aJR())
    {
      String str2 = ((com.tencent.luggage.sdk.b.a.c)av.g(this.izr)).asY().yl("WAPageFrame.html");
      com.tencent.luggage.g.d.i("Luggage.MPPageViewRenderer", "loadPageFrame %s", new Object[] { str1 });
      this.izr.aJN().t(str1, str2);
      AppMethodBeat.o(140893);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av.2
 * JD-Core Version:    0.7.0.1
 */