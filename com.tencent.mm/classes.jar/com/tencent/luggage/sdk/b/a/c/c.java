package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ab.a;
import com.tencent.mm.plugin.appbrand.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.m.f;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.r.4;
import com.tencent.mm.plugin.appbrand.r.5;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends r
  implements com.tencent.luggage.sdk.b.a.d, f
{
  public e coW;
  
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
    ae.d("MicroMsg.AppBrand.AppBrandServiceLU", "hy: using %s as logic imp", new Object[] { str });
    this.coW = ((e)d.EW().a(parama, this));
    if (this.coW == null)
    {
      parama = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(str)));
      AppMethodBeat.o(146827);
      throw parama;
    }
    AppMethodBeat.o(146827);
  }
  
  public void Db()
  {
    AppMethodBeat.i(146840);
    super.Db();
    this.coW.Db();
    AppMethodBeat.o(146840);
  }
  
  public void Dg()
  {
    AppMethodBeat.i(146838);
    if (aXQ()) {
      ar.a(this, aYB());
    }
    this.coW.Dg();
    AppMethodBeat.o(146838);
  }
  
  public final void Dh()
  {
    AppMethodBeat.i(146843);
    this.coW.Dh();
    AppMethodBeat.o(146843);
  }
  
  final void EK()
  {
    AppMethodBeat.i(169441);
    super.aXT();
    AppMethodBeat.o(169441);
  }
  
  public final void EL()
  {
    AppMethodBeat.i(146823);
    this.coW.CP();
    AppMethodBeat.o(146823);
  }
  
  public i EM()
  {
    AppMethodBeat.i(146824);
    i locali2 = this.coW.CO();
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.EM();
    }
    AppMethodBeat.o(146824);
    return locali1;
  }
  
  public final Map<String, m> EN()
  {
    AppMethodBeat.i(146828);
    Map localMap = this.coW.DJ();
    AppMethodBeat.o(146828);
    return localMap;
  }
  
  public com.tencent.luggage.sdk.b.a.c EO()
  {
    AppMethodBeat.i(146829);
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)super.at(com.tencent.luggage.sdk.b.a.c.class);
    AppMethodBeat.o(146829);
    return localc;
  }
  
  public JSONObject EP()
  {
    AppMethodBeat.i(146833);
    JSONObject localJSONObject = super.EP();
    c(localJSONObject, "appType", Integer.valueOf(Eq().Fg().cmt));
    c(localJSONObject, "debug", Boolean.valueOf(Eq().Ff().cmG));
    e(localJSONObject);
    int[] arrayOfInt = ai.f(this);
    c(localJSONObject, "screenWidth", Integer.valueOf(g.vM(arrayOfInt[0])));
    c(localJSONObject, "screenHeight", Integer.valueOf(g.vM(arrayOfInt[1])));
    AppMethodBeat.o(146833);
    return localJSONObject;
  }
  
  public final void EQ()
  {
    AppMethodBeat.i(146836);
    super.EQ();
    this.coW.Df();
    ae.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed, hash=%d", new Object[] { Integer.valueOf(aXX()) });
    String str = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { cj.z("onWxConfigReady", "", 0) });
    if (aYB().P(v.class) != null)
    {
      ((v)aYB().P(v.class)).a(null, null, null, 0, str, new r.4(this));
      AppMethodBeat.o(146836);
      return;
    }
    long l = bu.fpO();
    aYB().evaluateJavascript(str, new r.5(this, l));
    AppMethodBeat.o(146836);
  }
  
  public final String ER()
  {
    return "https://usr/";
  }
  
  public final String ES()
  {
    return "https://lib/";
  }
  
  protected a ET()
  {
    AppMethodBeat.i(146844);
    a locala = new a(this);
    AppMethodBeat.o(146844);
    return locala;
  }
  
  protected c.b EU()
  {
    AppMethodBeat.i(146845);
    com.tencent.mm.plugin.appbrand.c localc = new com.tencent.mm.plugin.appbrand.c(Eq(), this, Eq().cpU);
    AppMethodBeat.o(146845);
    return localc;
  }
  
  public com.tencent.luggage.sdk.d.d Eq()
  {
    AppMethodBeat.i(146831);
    com.tencent.luggage.sdk.d.d locald = (com.tencent.luggage.sdk.d.d)super.getRuntime();
    AppMethodBeat.o(146831);
    return locald;
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
    if (paramClass.isInstance(this.coW))
    {
      paramClass = paramClass.cast(this.coW);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    paramClass = paramClass.cast(this.coW.Q(paramClass));
    AppMethodBeat.o(146825);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final void a(String paramString1, String paramString2, int paramInt, o paramo)
  {
    AppMethodBeat.i(220764);
    if (((paramo == null) || (paramo == aYB())) && (this.coW.d(paramString1, paramString2, paramInt)))
    {
      AppMethodBeat.o(220764);
      return;
    }
    super.a(paramString1, paramString2, paramInt, paramo);
    AppMethodBeat.o(220764);
  }
  
  public final void bw(boolean paramBoolean)
  {
    AppMethodBeat.i(146839);
    super.bw(paramBoolean);
    this.coW.Da();
    AppMethodBeat.o(146839);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146842);
    if (this.coW.d(paramString1, paramString2, paramInt))
    {
      AppMethodBeat.o(146842);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(146842);
  }
  
  public boolean cU(String paramString)
  {
    AppMethodBeat.i(220763);
    boolean bool = this.coW.cU(paramString);
    AppMethodBeat.o(220763);
    return bool;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(146837);
    this.coW.CQ();
    super.cleanup();
    this.coW.CR();
    AppMethodBeat.o(146837);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146830);
    super.d(paramAppBrandRuntime);
    this.ktB = EU();
    this.coW.c(paramAppBrandRuntime);
    AppMethodBeat.o(146830);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146832);
    super.d(paramJSONObject);
    c(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.coW.CN()));
    c(paramJSONObject, "version", k.aD(null, j.IwD));
    c(paramJSONObject, "language", ad.iR(getContext()));
    AppMethodBeat.o(146832);
  }
  
  public final String jdMethod_do(String paramString)
  {
    AppMethodBeat.i(146835);
    String str = this.coW.dp(paramString);
    if (bu.isNullOrNil(str))
    {
      paramString = super.jdMethod_do(paramString);
      AppMethodBeat.o(146835);
      return paramString;
    }
    AppMethodBeat.o(146835);
    return str;
  }
  
  protected void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146834);
    this.coW.c(paramJSONObject);
    AppMethodBeat.o(146834);
  }
  
  public void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(146846);
    if (this.coW.i(paramInt, paramString))
    {
      AppMethodBeat.o(146846);
      return;
    }
    super.h(paramInt, paramString);
    AppMethodBeat.o(146846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.c
 * JD-Core Version:    0.7.0.1
 */