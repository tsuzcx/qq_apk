package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.4;
import com.tencent.mm.plugin.appbrand.q.5;
import com.tencent.mm.plugin.appbrand.utils.af;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends q
  implements com.tencent.luggage.sdk.b.a.d, f
{
  public e coU;
  
  public c()
  {
    this(new b.a());
    AppMethodBeat.i(146826);
    AppMethodBeat.o(146826);
  }
  
  public c(com.tencent.luggage.sdk.b.a.b.a parama)
  {
    AppMethodBeat.i(146827);
    String str = parama.getClass().getSimpleName();
    ad.d("MicroMsg.AppBrand.AppBrandServiceLU", "hy: using %s as logic imp", new Object[] { str });
    this.coU = ((e)d.EU().a(parama, this));
    if (this.coU == null)
    {
      parama = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(str)));
      AppMethodBeat.o(146827);
      throw parama;
    }
    AppMethodBeat.o(146827);
  }
  
  public void CY()
  {
    AppMethodBeat.i(146840);
    super.CY();
    this.coU.CY();
    AppMethodBeat.o(146840);
  }
  
  public void Dd()
  {
    AppMethodBeat.i(146838);
    if (aXv()) {
      aq.a(this, aYh());
    }
    this.coU.Dd();
    AppMethodBeat.o(146838);
  }
  
  public final void De()
  {
    AppMethodBeat.i(146843);
    this.coU.De();
    AppMethodBeat.o(146843);
  }
  
  final void EI()
  {
    AppMethodBeat.i(169441);
    super.aXy();
    AppMethodBeat.o(169441);
  }
  
  public final void EJ()
  {
    AppMethodBeat.i(146823);
    this.coU.CM();
    AppMethodBeat.o(146823);
  }
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i EK()
  {
    AppMethodBeat.i(146824);
    com.tencent.mm.plugin.appbrand.jsruntime.i locali2 = this.coU.CL();
    com.tencent.mm.plugin.appbrand.jsruntime.i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.EK();
    }
    AppMethodBeat.o(146824);
    return locali1;
  }
  
  public final Map<String, m> EL()
  {
    AppMethodBeat.i(146828);
    Map localMap = this.coU.DG();
    AppMethodBeat.o(146828);
    return localMap;
  }
  
  public com.tencent.luggage.sdk.b.a.c EM()
  {
    AppMethodBeat.i(146829);
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)super.at(com.tencent.luggage.sdk.b.a.c.class);
    AppMethodBeat.o(146829);
    return localc;
  }
  
  public JSONObject EN()
  {
    AppMethodBeat.i(146833);
    JSONObject localJSONObject = super.EN();
    c(localJSONObject, "appType", Integer.valueOf(En().Fb().cmr));
    c(localJSONObject, "debug", Boolean.valueOf(En().Fa().cmE));
    e(localJSONObject);
    int[] arrayOfInt = af.f(this);
    c(localJSONObject, "screenWidth", Integer.valueOf(g.vH(arrayOfInt[0])));
    c(localJSONObject, "screenHeight", Integer.valueOf(g.vH(arrayOfInt[1])));
    AppMethodBeat.o(146833);
    return localJSONObject;
  }
  
  public final void EO()
  {
    AppMethodBeat.i(146836);
    super.EO();
    this.coU.Dc();
    ad.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed, hash=%d", new Object[] { Integer.valueOf(aXC()) });
    String str = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { cj.z("onWxConfigReady", "", 0) });
    if (aYh().P(v.class) != null)
    {
      ((v)aYh().P(v.class)).a(null, null, null, 0, str, new q.4(this));
      AppMethodBeat.o(146836);
      return;
    }
    long l = bt.flT();
    aYh().evaluateJavascript(str, new q.5(this, l));
    AppMethodBeat.o(146836);
  }
  
  public final String EP()
  {
    return "https://usr/";
  }
  
  public final String EQ()
  {
    return "https://lib/";
  }
  
  protected a ER()
  {
    AppMethodBeat.i(146844);
    a locala = new a(this);
    AppMethodBeat.o(146844);
    return locala;
  }
  
  protected c.b ES()
  {
    AppMethodBeat.i(146845);
    com.tencent.mm.plugin.appbrand.c localc = new com.tencent.mm.plugin.appbrand.c(En(), this, En().cpr);
    AppMethodBeat.o(146845);
    return localc;
  }
  
  public com.tencent.luggage.sdk.d.c En()
  {
    AppMethodBeat.i(146831);
    com.tencent.luggage.sdk.d.c localc = (com.tencent.luggage.sdk.d.c)super.getRuntime();
    AppMethodBeat.o(146831);
    return localc;
  }
  
  public final <T> T Q(Class<T> paramClass)
  {
    AppMethodBeat.i(146825);
    if (paramClass.isInstance(this))
    {
      paramClass = paramClass.cast(this);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    if (paramClass.isInstance(this.coU))
    {
      paramClass = paramClass.cast(this.coU);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    paramClass = paramClass.cast(this.coU.Q(paramClass));
    AppMethodBeat.o(146825);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final void a(String paramString1, String paramString2, int paramInt, o paramo)
  {
    AppMethodBeat.i(192195);
    if (((paramo == null) || (paramo == aYh())) && (this.coU.d(paramString1, paramString2, paramInt)))
    {
      AppMethodBeat.o(192195);
      return;
    }
    super.a(paramString1, paramString2, paramInt, paramo);
    AppMethodBeat.o(192195);
  }
  
  public final void bw(boolean paramBoolean)
  {
    AppMethodBeat.i(146839);
    super.bw(paramBoolean);
    this.coU.CX();
    AppMethodBeat.o(146839);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146842);
    if (this.coU.d(paramString1, paramString2, paramInt))
    {
      AppMethodBeat.o(146842);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(146842);
  }
  
  public boolean cS(String paramString)
  {
    AppMethodBeat.i(192194);
    boolean bool = this.coU.cS(paramString);
    AppMethodBeat.o(192194);
    return bool;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(146837);
    this.coU.CN();
    super.cleanup();
    this.coU.CO();
    AppMethodBeat.o(146837);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146830);
    super.d(paramAppBrandRuntime);
    this.kqm = ES();
    this.coU.c(paramAppBrandRuntime);
    AppMethodBeat.o(146830);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146832);
    super.d(paramJSONObject);
    c(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.coU.CK()));
    c(paramJSONObject, "version", j.aD(null, com.tencent.mm.sdk.platformtools.i.Ics));
    c(paramJSONObject, "language", ac.iM(getContext()));
    AppMethodBeat.o(146832);
  }
  
  public final String dm(String paramString)
  {
    AppMethodBeat.i(146835);
    String str = this.coU.dn(paramString);
    if (bt.isNullOrNil(str))
    {
      paramString = super.dm(paramString);
      AppMethodBeat.o(146835);
      return paramString;
    }
    AppMethodBeat.o(146835);
    return str;
  }
  
  protected void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146834);
    this.coU.c(paramJSONObject);
    AppMethodBeat.o(146834);
  }
  
  public void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(146846);
    if (this.coU.i(paramInt, paramString))
    {
      AppMethodBeat.o(146846);
      return;
    }
    super.h(paramInt, paramString);
    AppMethodBeat.o(146846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.c
 * JD-Core Version:    0.7.0.1
 */