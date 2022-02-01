package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.n.f;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends q
  implements com.tencent.luggage.sdk.b.a.d, f
{
  public e ceD;
  
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
    ac.d("MicroMsg.AppBrand.AppBrandServiceLU", "hy: using %s as logic imp", new Object[] { str });
    this.ceD = ((e)d.Dv().a(parama, this));
    if (this.ceD == null)
    {
      parama = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(str)));
      AppMethodBeat.o(146827);
      throw parama;
    }
    AppMethodBeat.o(146827);
  }
  
  public void BE()
  {
    AppMethodBeat.i(146838);
    if (aUm()) {
      ap.a(this, aUV());
    }
    this.ceD.BE();
    AppMethodBeat.o(146838);
  }
  
  public final void BF()
  {
    AppMethodBeat.i(146843);
    this.ceD.BF();
    AppMethodBeat.o(146843);
  }
  
  public void Bz()
  {
    AppMethodBeat.i(146840);
    super.Bz();
    this.ceD.Bz();
    AppMethodBeat.o(146840);
  }
  
  public com.tencent.luggage.sdk.d.c CO()
  {
    AppMethodBeat.i(146831);
    com.tencent.luggage.sdk.d.c localc = (com.tencent.luggage.sdk.d.c)super.getRuntime();
    AppMethodBeat.o(146831);
    return localc;
  }
  
  final void Dj()
  {
    AppMethodBeat.i(169441);
    super.aUp();
    AppMethodBeat.o(169441);
  }
  
  public final void Dk()
  {
    AppMethodBeat.i(146823);
    this.ceD.Bn();
    AppMethodBeat.o(146823);
  }
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i Dl()
  {
    AppMethodBeat.i(146824);
    com.tencent.mm.plugin.appbrand.jsruntime.i locali2 = this.ceD.Bm();
    com.tencent.mm.plugin.appbrand.jsruntime.i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.Dl();
    }
    AppMethodBeat.o(146824);
    return locali1;
  }
  
  public final Map<String, m> Dm()
  {
    AppMethodBeat.i(146828);
    Map localMap = this.ceD.Ch();
    AppMethodBeat.o(146828);
    return localMap;
  }
  
  public com.tencent.luggage.sdk.b.a.c Dn()
  {
    AppMethodBeat.i(146829);
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)super.at(com.tencent.luggage.sdk.b.a.c.class);
    AppMethodBeat.o(146829);
    return localc;
  }
  
  public JSONObject Do()
  {
    AppMethodBeat.i(146833);
    JSONObject localJSONObject = super.Do();
    c(localJSONObject, "appType", Integer.valueOf(CO().DC().cca));
    c(localJSONObject, "debug", Boolean.valueOf(CO().DB().ccn));
    e(localJSONObject);
    int[] arrayOfInt = ad.g(this);
    c(localJSONObject, "screenWidth", Integer.valueOf(g.vc(arrayOfInt[0])));
    c(localJSONObject, "screenHeight", Integer.valueOf(g.vc(arrayOfInt[1])));
    AppMethodBeat.o(146833);
    return localJSONObject;
  }
  
  public final void Dp()
  {
    AppMethodBeat.i(146836);
    super.Dp();
    this.ceD.BD();
    String str = String.format(Locale.US, ";if(__wxConfig.preload){ %s };", new Object[] { cg.y("onWxConfigReady", "", 0) });
    aUV().evaluateJavascript(str, null);
    AppMethodBeat.o(146836);
  }
  
  public final String Dq()
  {
    return "https://usr/";
  }
  
  public final String Dr()
  {
    return "https://lib/";
  }
  
  protected a Ds()
  {
    AppMethodBeat.i(146844);
    a locala = new a(this);
    AppMethodBeat.o(146844);
    return locala;
  }
  
  protected c.b Dt()
  {
    AppMethodBeat.i(146845);
    com.tencent.mm.plugin.appbrand.c localc = new com.tencent.mm.plugin.appbrand.c(CO(), this, CO().cfa);
    AppMethodBeat.o(146845);
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
    if (paramClass.isInstance(this.ceD))
    {
      paramClass = paramClass.cast(this.ceD);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    paramClass = paramClass.cast(this.ceD.Q(paramClass));
    AppMethodBeat.o(146825);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final void a(String paramString1, String paramString2, int paramInt, o paramo)
  {
    AppMethodBeat.i(206125);
    if (((paramo == null) || (paramo == aUV())) && (this.ceD.d(paramString1, paramString2, paramInt)))
    {
      AppMethodBeat.o(206125);
      return;
    }
    super.a(paramString1, paramString2, paramInt, paramo);
    AppMethodBeat.o(206125);
  }
  
  public void bY(String paramString)
  {
    AppMethodBeat.i(146841);
    this.ceD.bY(paramString);
    AppMethodBeat.o(146841);
  }
  
  public final void bw(boolean paramBoolean)
  {
    AppMethodBeat.i(146839);
    super.bw(paramBoolean);
    this.ceD.By();
    AppMethodBeat.o(146839);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146842);
    if (this.ceD.d(paramString1, paramString2, paramInt))
    {
      AppMethodBeat.o(146842);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(146842);
  }
  
  public final String ck(String paramString)
  {
    AppMethodBeat.i(146835);
    String str = this.ceD.cl(paramString);
    if (bs.isNullOrNil(str))
    {
      paramString = super.ck(paramString);
      AppMethodBeat.o(146835);
      return paramString;
    }
    AppMethodBeat.o(146835);
    return str;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(146837);
    this.ceD.Bo();
    super.cleanup();
    this.ceD.Bp();
    AppMethodBeat.o(146837);
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146830);
    super.d(paramAppBrandRuntime);
    this.jVY = Dt();
    this.ceD.c(paramAppBrandRuntime);
    AppMethodBeat.o(146830);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146832);
    super.d(paramJSONObject);
    c(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.ceD.Bl()));
    c(paramJSONObject, "version", com.tencent.mm.sdk.platformtools.i.aA(null, h.GqE));
    c(paramJSONObject, "language", ab.iC(getContext()));
    AppMethodBeat.o(146832);
  }
  
  protected void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146834);
    this.ceD.c(paramJSONObject);
    AppMethodBeat.o(146834);
  }
  
  public void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(146846);
    if (this.ceD.i(paramInt, paramString))
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