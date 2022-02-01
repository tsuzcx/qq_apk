package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.b.a;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ag.a;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.4;
import com.tencent.mm.plugin.appbrand.s.5;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends s
  implements com.tencent.luggage.sdk.b.a.d, com.tencent.mm.plugin.appbrand.p.f
{
  public f cBj;
  
  public d()
  {
    this(new c.a());
    AppMethodBeat.i(146826);
    AppMethodBeat.o(146826);
  }
  
  public d(b.a parama)
  {
    AppMethodBeat.i(146827);
    String str = parama.getClass().getSimpleName();
    Log.d("MicroMsg.AppBrand.AppBrandServiceLU", "hy: using %s as logic imp", new Object[] { str });
    this.cBj = ((f)e.Oy().a(parama, this));
    if (this.cBj == null)
    {
      parama = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(str)));
      AppMethodBeat.o(146827);
      throw parama;
    }
    AppMethodBeat.o(146827);
  }
  
  public void MC()
  {
    AppMethodBeat.i(146838);
    if (bsX()) {
      bc.a(this, getJsRuntime());
    }
    this.cBj.MC();
    AppMethodBeat.o(146838);
  }
  
  public final void MD()
  {
    AppMethodBeat.i(146843);
    this.cBj.MD();
    AppMethodBeat.o(146843);
  }
  
  public void Mx()
  {
    AppMethodBeat.i(146840);
    super.Mx();
    this.cBj.Mx();
    AppMethodBeat.o(146840);
  }
  
  public com.tencent.luggage.sdk.d.d NP()
  {
    AppMethodBeat.i(146831);
    com.tencent.luggage.sdk.d.d locald = (com.tencent.luggage.sdk.d.d)super.getRuntime();
    AppMethodBeat.o(146831);
    return locald;
  }
  
  public final f Ol()
  {
    return this.cBj;
  }
  
  final void Om()
  {
    AppMethodBeat.i(169441);
    super.bta();
    AppMethodBeat.o(169441);
  }
  
  public final void On()
  {
    AppMethodBeat.i(146823);
    this.cBj.Ml();
    AppMethodBeat.o(146823);
  }
  
  public i Oo()
  {
    AppMethodBeat.i(146824);
    i locali2 = this.cBj.Mk();
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.Oo();
    }
    AppMethodBeat.o(146824);
    return locali1;
  }
  
  public final Map<String, p> Op()
  {
    AppMethodBeat.i(146828);
    Map localMap = this.cBj.Nf();
    AppMethodBeat.o(146828);
    return localMap;
  }
  
  public com.tencent.luggage.sdk.b.a.c Oq()
  {
    AppMethodBeat.i(146829);
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)super.ax(com.tencent.luggage.sdk.b.a.c.class);
    AppMethodBeat.o(146829);
    return localc;
  }
  
  public JSONObject Or()
  {
    AppMethodBeat.i(146833);
    JSONObject localJSONObject = super.Or();
    c(localJSONObject, "appType", Integer.valueOf(NP().ON().cyo));
    c(localJSONObject, "debug", Boolean.valueOf(NP().OM().cyC));
    e(localJSONObject);
    int[] arrayOfInt = ai.f(this);
    c(localJSONObject, "screenWidth", Integer.valueOf(g.zB(arrayOfInt[0])));
    c(localJSONObject, "screenHeight", Integer.valueOf(g.zB(arrayOfInt[1])));
    c(localJSONObject, "supportAsyncGetSystemInfo", Boolean.TRUE);
    if (NP().ON().cyz == b.cBC) {}
    for (boolean bool = true;; bool = false)
    {
      c(localJSONObject, "prerender", Boolean.valueOf(bool));
      c(localJSONObject, "instanceId", NP().ON().cyn);
      localJSONObject.remove("permission");
      localJSONObject.remove("navigateToMiniProgramAppIdList");
      Log.i("MicroMsg.AppBrand.AppBrandServiceLU", "generateWxConfig(%s): %s", new Object[] { getAppId(), localJSONObject.toString() });
      AppMethodBeat.o(146833);
      return localJSONObject;
    }
  }
  
  public final void Os()
  {
    AppMethodBeat.i(146836);
    super.Os();
    this.cBj.MB();
    Log.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed, hash=%d", new Object[] { Integer.valueOf(getComponentId()) });
    String str = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { cx.z("onWxConfigReady", "", 0) });
    if (getJsRuntime().R(v.class) != null)
    {
      ((v)getJsRuntime().R(v.class)).a(null, null, null, 0, str, new s.4(this));
      AppMethodBeat.o(146836);
      return;
    }
    long l = Util.nowMilliSecond();
    getJsRuntime().evaluateJavascript(str, new s.5(this, l));
    AppMethodBeat.o(146836);
  }
  
  public final String Ot()
  {
    return "https://usr/";
  }
  
  public final String Ou()
  {
    return "https://lib/";
  }
  
  protected a Ov()
  {
    AppMethodBeat.i(146844);
    a locala = new a(this);
    AppMethodBeat.o(146844);
    return locala;
  }
  
  protected f.b Ow()
  {
    AppMethodBeat.i(146845);
    com.tencent.mm.plugin.appbrand.c localc = new com.tencent.mm.plugin.appbrand.c(NP(), this, NP().cCn);
    AppMethodBeat.o(146845);
    return localc;
  }
  
  public final <T> T S(Class<T> paramClass)
  {
    AppMethodBeat.i(146825);
    if (paramClass.isInstance(this))
    {
      paramClass = paramClass.cast(this);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    if (paramClass.isInstance(this.cBj))
    {
      paramClass = paramClass.cast(this.cBj);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    paramClass = paramClass.cast(this.cBj.S(paramClass));
    AppMethodBeat.o(146825);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final void a(String paramString1, String paramString2, int paramInt, o paramo)
  {
    AppMethodBeat.i(229853);
    if (("onAppEnterForeground".equals(paramString1)) || ("onAppEnterBackground".equals(paramString1))) {
      Log.i("MicroMsg.AppBrand.AppBrandServiceLU", "dispatch %s, appId:%s, instanceId:%s, sessionId:%s, data:%s", new Object[] { paramString1, getAppId(), NP().ON().cyn, NP().ON().cym, paramString2 });
    }
    if (((paramo == null) || (paramo == getJsRuntime())) && (this.cBj.d(paramString1, paramString2, paramInt)))
    {
      AppMethodBeat.o(229853);
      return;
    }
    super.a(paramString1, paramString2, paramInt, paramo);
    AppMethodBeat.o(229853);
  }
  
  public final void bX(boolean paramBoolean)
  {
    AppMethodBeat.i(146839);
    super.bX(paramBoolean);
    this.cBj.Mw();
    AppMethodBeat.o(146839);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146842);
    if (this.cBj.d(paramString1, paramString2, paramInt))
    {
      AppMethodBeat.o(146842);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(146842);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(146837);
    this.cBj.Mm();
    super.cleanup();
    this.cBj.Mn();
    AppMethodBeat.o(146837);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146830);
    super.d(paramAppBrandRuntime);
    this.lxr = Ow();
    this.cBj.c(paramAppBrandRuntime);
    AppMethodBeat.o(146830);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146832);
    super.d(paramJSONObject);
    this.cBj.d(paramJSONObject);
    c(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.cBj.Mj()));
    c(paramJSONObject, "version", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
    c(paramJSONObject, "language", LocaleUtil.getCurrentLanguage(getContext()));
    AppMethodBeat.o(146832);
  }
  
  public final String dG(String paramString)
  {
    AppMethodBeat.i(146835);
    String str = this.cBj.dH(paramString);
    if (Util.isNullOrNil(str))
    {
      paramString = super.dG(paramString);
      AppMethodBeat.o(146835);
      return paramString;
    }
    AppMethodBeat.o(146835);
    return str;
  }
  
  public boolean dt(String paramString)
  {
    AppMethodBeat.i(229852);
    boolean bool = this.cBj.dt(paramString);
    AppMethodBeat.o(229852);
    return bool;
  }
  
  protected void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146834);
    this.cBj.c(paramJSONObject);
    AppMethodBeat.o(146834);
  }
  
  public void i(int paramInt, String paramString)
  {
    AppMethodBeat.i(146846);
    if (this.cBj.j(paramInt, paramString))
    {
      AppMethodBeat.o(146846);
      return;
    }
    super.i(paramInt, paramString);
    AppMethodBeat.o(146846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.d
 * JD-Core Version:    0.7.0.1
 */