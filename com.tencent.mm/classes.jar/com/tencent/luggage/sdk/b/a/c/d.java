package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.be;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.v.4;
import com.tencent.mm.plugin.appbrand.v.5;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class d
  extends com.tencent.mm.plugin.appbrand.v
  implements com.tencent.luggage.sdk.b.a.d, com.tencent.mm.plugin.appbrand.p.e
{
  public final f<? extends d> cAr;
  
  public d()
  {
    this(new c.a());
    AppMethodBeat.i(146826);
    AppMethodBeat.o(146826);
  }
  
  public d(b.a parama)
  {
    AppMethodBeat.i(146827);
    String str = parama.getClass().getName();
    Log.d("MicroMsg.AppBrand.AppBrandServiceLU", "hy: using %s as logic imp", new Object[] { str });
    this.cAr = ((f)e.Rx().a(parama, this));
    if (this.cAr == null)
    {
      parama = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(str)));
      AppMethodBeat.o(146827);
      throw parama;
    }
    AppMethodBeat.o(146827);
  }
  
  public void Pp()
  {
    AppMethodBeat.i(146840);
    super.Pp();
    this.cAr.Pp();
    AppMethodBeat.o(146840);
  }
  
  public void Pu()
  {
    AppMethodBeat.i(146838);
    if (bDV()) {
      be.a(this, getJsRuntime());
    }
    this.cAr.Pu();
    AppMethodBeat.o(146838);
  }
  
  public void Pv()
  {
    AppMethodBeat.i(146843);
    this.cAr.Pv();
    AppMethodBeat.o(146843);
  }
  
  public com.tencent.luggage.sdk.e.d QM()
  {
    AppMethodBeat.i(146831);
    com.tencent.luggage.sdk.e.d locald = (com.tencent.luggage.sdk.e.d)super.getRuntime();
    AppMethodBeat.o(146831);
    return locald;
  }
  
  public final <T> T R(Class<T> paramClass)
  {
    AppMethodBeat.i(146825);
    if (paramClass.isInstance(this))
    {
      paramClass = paramClass.cast(this);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    if (paramClass.isInstance(this.cAr))
    {
      paramClass = paramClass.cast(this.cAr);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    paramClass = paramClass.cast(this.cAr.R(paramClass));
    AppMethodBeat.o(146825);
    return paramClass;
  }
  
  public final f<? extends d> Ri()
  {
    return this.cAr;
  }
  
  final void Rj()
  {
    AppMethodBeat.i(169441);
    super.bDY();
    AppMethodBeat.o(169441);
  }
  
  public final void Rk()
  {
    AppMethodBeat.i(146823);
    this.cAr.Pd();
    AppMethodBeat.o(146823);
  }
  
  public i Rl()
  {
    AppMethodBeat.i(146824);
    i locali2 = this.cAr.Pc();
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.Rl();
    }
    AppMethodBeat.o(146824);
    return locali1;
  }
  
  public final Map<String, o> Rm()
  {
    AppMethodBeat.i(146828);
    Map localMap = this.cAr.PX();
    AppMethodBeat.o(146828);
    return localMap;
  }
  
  public c Rn()
  {
    AppMethodBeat.i(146829);
    c localc = (c)super.aw(c.class);
    AppMethodBeat.o(146829);
    return localc;
  }
  
  public JSONObject Ro()
  {
    AppMethodBeat.i(146833);
    JSONObject localJSONObject = super.Ro();
    c(localJSONObject, "appType", Integer.valueOf(QM().Sk().cwR));
    c(localJSONObject, "debug", Boolean.valueOf(QM().Sj().cxh));
    h(localJSONObject);
    Object localObject = ak.f(this);
    c(localJSONObject, "screenWidth", Integer.valueOf(g.Dg(localObject[0])));
    c(localJSONObject, "screenHeight", Integer.valueOf(g.Dg(localObject[1])));
    c(localJSONObject, "supportAsyncGetSystemInfo", Boolean.TRUE);
    boolean bool;
    if (QM().Sk().cxe == com.tencent.luggage.sdk.launching.b.cBf) {
      bool = true;
    }
    for (;;)
    {
      c(localJSONObject, "prerender", Boolean.valueOf(bool));
      c(localJSONObject, "instanceId", QM().Sk().cwQ);
      localObject = QM().Sj().cxk.cxQ;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        c(localJSONObject, "opConfig", new JSONObject((String)localObject));
        localJSONObject.remove("permission");
        localJSONObject.remove("navigateToMiniProgramAppIdList");
        Log.i("MicroMsg.AppBrand.AppBrandServiceLU", "generateWxConfig(%s): %s", new Object[] { getAppId(), localJSONObject.toString() });
        AppMethodBeat.o(146833);
        return localJSONObject;
        bool = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppBrand.AppBrandServiceLU", "generateWxConfig() put wxConfig.opConfig, exception=%s", new Object[] { localException });
        }
      }
    }
  }
  
  public final boolean Rp()
  {
    AppMethodBeat.i(169442);
    if ((this.cAr != null) && (this.cAr.Rp()))
    {
      AppMethodBeat.o(169442);
      return true;
    }
    AppMethodBeat.o(169442);
    return false;
  }
  
  public final void Rq()
  {
    AppMethodBeat.i(146836);
    super.Rq();
    this.cAr.Pt();
    Log.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed, hash=%d", new Object[] { Integer.valueOf(getComponentId()) });
    String str = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { cy.C("onWxConfigReady", "", 0) });
    if (getJsRuntime().Q(com.tencent.mm.plugin.appbrand.m.v.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.m.v)getJsRuntime().Q(com.tencent.mm.plugin.appbrand.m.v.class)).a(null, null, null, 0, str, new v.4(this));
      AppMethodBeat.o(146836);
      return;
    }
    long l = Util.nowMilliSecond();
    getJsRuntime().evaluateJavascript(str, new v.5(this, l));
    AppMethodBeat.o(146836);
  }
  
  public final String Rr()
  {
    return "https://usr/";
  }
  
  public final String Rs()
  {
    return "https://lib/";
  }
  
  public boolean Rt()
  {
    return !(this.cAr instanceof k);
  }
  
  protected com.tencent.mm.plugin.appbrand.ah.a Ru()
  {
    AppMethodBeat.i(146844);
    com.tencent.mm.plugin.appbrand.ah.a locala = new com.tencent.mm.plugin.appbrand.ah.a(this);
    AppMethodBeat.o(146844);
    return locala;
  }
  
  protected e.c Rv()
  {
    AppMethodBeat.i(146845);
    com.tencent.mm.plugin.appbrand.f localf = new com.tencent.mm.plugin.appbrand.f(QM(), this, QM().cCQ);
    AppMethodBeat.o(146845);
    return localf;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146842);
    if (("onAppEnterForeground".equals(paramString1)) || ("onAppEnterBackground".equals(paramString1))) {
      Log.i("MicroMsg.AppBrand.AppBrandServiceLU", "dispatch %s, appId:%s, instanceId:%s, sessionId:%s, data:%s", new Object[] { paramString1, getAppId(), QM().Sk().cwQ, QM().Sk().cwP, paramString2 });
    }
    if (this.cAr.d(paramString1, paramString2, paramInt))
    {
      AppMethodBeat.o(146842);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(146842);
  }
  
  public final void ci(boolean paramBoolean)
  {
    AppMethodBeat.i(146839);
    super.ci(paramBoolean);
    this.cAr.Po();
    AppMethodBeat.o(146839);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(146837);
    Iterator localIterator = this.osc.values().iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      if ((localo instanceof com.tencent.mm.plugin.appbrand.jsapi.p.b)) {
        ((com.tencent.mm.plugin.appbrand.jsapi.p.b)localo).pei.oGh.clear();
      }
    }
    this.cAr.Pe();
    super.cleanup();
    this.cAr.Pf();
    AppMethodBeat.o(146837);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146830);
    super.d(paramAppBrandRuntime);
    setInterceptor(Rv());
    this.cAr.c(paramAppBrandRuntime);
    AppMethodBeat.o(146830);
  }
  
  public boolean dK(String paramString)
  {
    AppMethodBeat.i(247935);
    boolean bool = this.cAr.dK(paramString);
    AppMethodBeat.o(247935);
    return bool;
  }
  
  public final String ea(String paramString)
  {
    AppMethodBeat.i(146835);
    String str = this.cAr.dZ(paramString);
    if (Util.isNullOrNil(str))
    {
      paramString = super.ea(paramString);
      AppMethodBeat.o(146835);
      return paramString;
    }
    AppMethodBeat.o(146835);
    return str;
  }
  
  public void g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146832);
    super.g(paramJSONObject);
    this.cAr.g(paramJSONObject);
    c(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.cAr.Pb()));
    c(paramJSONObject, "version", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
    c(paramJSONObject, "language", LocaleUtil.getCurrentLanguage(getContext()));
    AppMethodBeat.o(146832);
  }
  
  protected void h(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146834);
    this.cAr.f(paramJSONObject);
    AppMethodBeat.o(146834);
  }
  
  public void j(int paramInt, String paramString)
  {
    AppMethodBeat.i(146846);
    if (this.cAr.k(paramInt, paramString))
    {
      AppMethodBeat.o(146846);
      return;
    }
    super.j(paramInt, paramString);
    AppMethodBeat.o(146846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */