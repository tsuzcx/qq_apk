package com.tencent.luggage.sdk.b.a.d;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.config.LaunchWxaAppInfoParcelized;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.AbsReader;
import com.tencent.mm.plugin.appbrand.bk;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.utils.aq;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.appbrand.y.4;
import com.tencent.mm.plugin.appbrand.y.5;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends y
  implements com.tencent.luggage.sdk.b.a.d, com.tencent.mm.plugin.appbrand.q.e
{
  public final f<? extends d> esM;
  
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
    this.esM = ((f)e.arL().a(parama, this));
    if (this.esM == null)
    {
      parama = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(str)));
      AppMethodBeat.o(146827);
      throw parama;
    }
    AppMethodBeat.o(146827);
  }
  
  public d(Class<? extends f<? extends d>> paramClass)
  {
    AppMethodBeat.i(220322);
    this.esM = ((f)org.a.a.cQ(paramClass).av(new Object[] { this }).object);
    AppMethodBeat.o(220322);
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final <T> T aa(Class<T> paramClass)
  {
    AppMethodBeat.i(146825);
    if (paramClass.isInstance(this))
    {
      paramClass = paramClass.cast(this);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    if (paramClass.isInstance(this.esM))
    {
      paramClass = paramClass.cast(this.esM);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    paramClass = paramClass.cast(this.esM.aa(paramClass));
    AppMethodBeat.o(146825);
    return paramClass;
  }
  
  public void apC()
  {
    AppMethodBeat.i(146838);
    if (asZ()) {
      bk.a(this, getJsRuntime());
    }
    this.esM.apC();
    AppMethodBeat.o(146838);
  }
  
  public void apD()
  {
    AppMethodBeat.i(146843);
    this.esM.apD();
    AppMethodBeat.o(146843);
  }
  
  public void apx()
  {
    AppMethodBeat.i(146840);
    super.apx();
    this.esM.apx();
    AppMethodBeat.o(146840);
  }
  
  public com.tencent.luggage.sdk.e.d aqZ()
  {
    AppMethodBeat.i(146831);
    com.tencent.luggage.sdk.e.d locald = (com.tencent.luggage.sdk.e.d)super.getRuntime();
    AppMethodBeat.o(146831);
    return locald;
  }
  
  public final Map<String, p> arA()
  {
    AppMethodBeat.i(146828);
    Map localMap = this.esM.aqh();
    AppMethodBeat.o(146828);
    return localMap;
  }
  
  public c arB()
  {
    AppMethodBeat.i(146829);
    c localc = (c)super.aP(c.class);
    AppMethodBeat.o(146829);
    return localc;
  }
  
  public JSONObject arC()
  {
    AppMethodBeat.i(146833);
    JSONObject localJSONObject = super.arC();
    d(localJSONObject, "appType", Integer.valueOf(aqZ().asA().appServiceType));
    d(localJSONObject, "debug", Boolean.valueOf(aqZ().asz().epz));
    g(localJSONObject);
    Object localObject = aq.d(this);
    d(localJSONObject, "screenWidth", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(localObject[0])));
    d(localJSONObject, "screenHeight", Integer.valueOf(com.tencent.mm.plugin.appbrand.af.i.DA(localObject[1])));
    d(localJSONObject, "supportAsyncGetSystemInfo", Boolean.TRUE);
    boolean bool;
    if (aqZ().asA().epm == com.tencent.luggage.sdk.launching.e.etJ) {
      bool = true;
    }
    for (;;)
    {
      d(localJSONObject, "prerender", Boolean.valueOf(bool));
      d(localJSONObject, "instanceId", aqZ().asA().eoQ);
      localObject = aqZ().asz().epC.eqk;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        d(localJSONObject, "opConfig", new JSONObject((String)localObject));
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
  
  public final boolean arD()
  {
    AppMethodBeat.i(169442);
    if ((this.esM != null) && (this.esM.arD()))
    {
      AppMethodBeat.o(169442);
      return true;
    }
    AppMethodBeat.o(169442);
    return false;
  }
  
  public final void arE()
  {
    AppMethodBeat.i(146836);
    super.arE();
    this.esM.apB();
    Log.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed, hash=%d", new Object[] { Integer.valueOf(getComponentId()) });
    String str = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { di.H("onWxConfigReady", "", 0) });
    if (getJsRuntime().Z(v.class) != null)
    {
      ((v)getJsRuntime().Z(v.class)).a(null, null, null, 0, str, new y.4(this));
      AppMethodBeat.o(146836);
      return;
    }
    long l = Util.nowMilliSecond();
    getJsRuntime().evaluateJavascript(str, new y.5(this, l));
    AppMethodBeat.o(146836);
  }
  
  public final String arF()
  {
    return "https://usr/";
  }
  
  public final String arG()
  {
    return "https://lib/";
  }
  
  public boolean arH()
  {
    return !(this.esM instanceof k);
  }
  
  protected com.tencent.mm.plugin.appbrand.ai.a arI()
  {
    AppMethodBeat.i(146844);
    com.tencent.mm.plugin.appbrand.ai.a locala = new com.tencent.mm.plugin.appbrand.ai.a(this);
    AppMethodBeat.o(146844);
    return locala;
  }
  
  protected f.c arJ()
  {
    AppMethodBeat.i(146845);
    com.tencent.mm.plugin.appbrand.f localf = new com.tencent.mm.plugin.appbrand.f(aqZ(), this, aqZ().evw);
    AppMethodBeat.o(146845);
    return localf;
  }
  
  final void arx()
  {
    AppMethodBeat.i(169441);
    super.cdl();
    AppMethodBeat.o(169441);
  }
  
  public final void ary()
  {
    AppMethodBeat.i(146823);
    this.esM.apl();
    AppMethodBeat.o(146823);
  }
  
  public com.tencent.mm.plugin.appbrand.n.i arz()
  {
    AppMethodBeat.i(146824);
    com.tencent.mm.plugin.appbrand.n.i locali2 = this.esM.apk();
    com.tencent.mm.plugin.appbrand.n.i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.arz();
    }
    AppMethodBeat.o(146824);
    return locali1;
  }
  
  public final void cP(boolean paramBoolean)
  {
    AppMethodBeat.i(146839);
    super.cP(paramBoolean);
    this.esM.apw();
    AppMethodBeat.o(146839);
  }
  
  public void callback(int paramInt, String paramString)
  {
    AppMethodBeat.i(146846);
    if (this.esM.k(paramInt, paramString))
    {
      AppMethodBeat.o(146846);
      return;
    }
    super.callback(paramInt, paramString);
    AppMethodBeat.o(146846);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(146837);
    Iterator localIterator = this.rvW.values().iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if ((localp instanceof b)) {
        ((b)localp).sjy.rJg.clear();
      }
    }
    this.esM.apm();
    super.cleanup();
    this.esM.apn();
    AppMethodBeat.o(146837);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146830);
    super.d(paramAppBrandRuntime);
    setInterceptor(arJ());
    this.esM.c(paramAppBrandRuntime);
    AppMethodBeat.o(146830);
  }
  
  public boolean eV(String paramString)
  {
    AppMethodBeat.i(220370);
    boolean bool = this.esM.eV(paramString);
    AppMethodBeat.o(220370);
    return bool;
  }
  
  public final void f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146842);
    if (("onAppEnterForeground".equals(paramString1)) || ("onAppEnterBackground".equals(paramString1))) {
      Log.i("MicroMsg.AppBrand.AppBrandServiceLU", "dispatch %s, appId:%s, instanceId:%s, sessionId:%s, data:%s", new Object[] { paramString1, getAppId(), aqZ().asA().eoQ, aqZ().asA().eoP, paramString2 });
    }
    if (this.esM.g(paramString1, paramString2, paramInt))
    {
      AppMethodBeat.o(146842);
      return;
    }
    super.f(paramString1, paramString2, paramInt);
    AppMethodBeat.o(146842);
  }
  
  public void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146832);
    super.f(paramJSONObject);
    this.esM.f(paramJSONObject);
    d(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.esM.apj()));
    d(paramJSONObject, "version", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
    d(paramJSONObject, "language", LocaleUtil.getCurrentLanguage(getContext()));
    if ((cbl() instanceof AbsReader))
    {
      com.tencent.luggage.sdk.b.a.a.a locala = ((AbsReader)cbl()).cfH();
      s.u(paramJSONObject, "wxConfig");
      if (!locala.map.isEmpty()) {
        try
        {
          paramJSONObject.put("expt", new JSONObject((Map)locala.map));
          AppMethodBeat.o(146832);
          return;
        }
        catch (JSONException paramJSONObject)
        {
          Log.e("Luggage.ExptMapping", s.X("applyToWxConfig get exception:", paramJSONObject), new Object[] { paramJSONObject });
        }
      }
    }
    AppMethodBeat.o(146832);
  }
  
  public final String ft(String paramString)
  {
    AppMethodBeat.i(146835);
    String str = this.esM.fs(paramString);
    if (Util.isNullOrNil(str))
    {
      paramString = super.ft(paramString);
      AppMethodBeat.o(146835);
      return paramString;
    }
    AppMethodBeat.o(146835);
    return str;
  }
  
  protected void g(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146834);
    this.esM.e(paramJSONObject);
    if (com.tencent.luggage.sdk.launching.e.etK == aqZ().asA().epm)
    {
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject("appLaunchInfo");
      JSONObject localJSONObject1 = localJSONObject2;
      if (localJSONObject2 == null)
      {
        localJSONObject1 = new JSONObject();
        d(paramJSONObject, "appLaunchInfo", localJSONObject1);
      }
      d(localJSONObject1, "inBackground", Boolean.TRUE);
    }
    AppMethodBeat.o(146834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.d
 * JD-Core Version:    0.7.0.1
 */