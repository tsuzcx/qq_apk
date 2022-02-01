package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.ae.a;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.cg;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.o.f;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends q
  implements com.tencent.luggage.sdk.b.a.d, f
{
  public e chI;
  
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
    this.chI = ((e)d.DS().a(parama, this));
    if (this.chI == null)
    {
      parama = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(str)));
      AppMethodBeat.o(146827);
      throw parama;
    }
    AppMethodBeat.o(146827);
  }
  
  public void BV()
  {
    AppMethodBeat.i(146840);
    super.BV();
    this.chI.BV();
    AppMethodBeat.o(146840);
  }
  
  public void Ca()
  {
    AppMethodBeat.i(146838);
    if (aNw()) {
      ap.a(this, aOf());
    }
    this.chI.Ca();
    AppMethodBeat.o(146838);
  }
  
  public final void Cb()
  {
    AppMethodBeat.i(146843);
    this.chI.Cb();
    AppMethodBeat.o(146843);
  }
  
  final void DG()
  {
    AppMethodBeat.i(169441);
    super.aNz();
    AppMethodBeat.o(169441);
  }
  
  public final void DH()
  {
    AppMethodBeat.i(146823);
    this.chI.BJ();
    AppMethodBeat.o(146823);
  }
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i DI()
  {
    AppMethodBeat.i(146824);
    com.tencent.mm.plugin.appbrand.jsruntime.i locali2 = this.chI.BI();
    com.tencent.mm.plugin.appbrand.jsruntime.i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.DI();
    }
    AppMethodBeat.o(146824);
    return locali1;
  }
  
  public final Map<String, m> DJ()
  {
    AppMethodBeat.i(146828);
    Map localMap = this.chI.CD();
    AppMethodBeat.o(146828);
    return localMap;
  }
  
  public com.tencent.luggage.sdk.b.a.c DK()
  {
    AppMethodBeat.i(146829);
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)super.at(com.tencent.luggage.sdk.b.a.c.class);
    AppMethodBeat.o(146829);
    return localc;
  }
  
  public JSONObject DL()
  {
    AppMethodBeat.i(146833);
    JSONObject localJSONObject = super.DL();
    c(localJSONObject, "appType", Integer.valueOf(Dl().DZ().cfd));
    c(localJSONObject, "debug", Boolean.valueOf(Dl().DY().cfq));
    e(localJSONObject);
    int[] arrayOfInt = com.tencent.mm.plugin.appbrand.utils.ac.g(this);
    c(localJSONObject, "screenWidth", Integer.valueOf(g.uk(arrayOfInt[0])));
    c(localJSONObject, "screenHeight", Integer.valueOf(g.uk(arrayOfInt[1])));
    AppMethodBeat.o(146833);
    return localJSONObject;
  }
  
  public final void DM()
  {
    AppMethodBeat.i(146836);
    super.DM();
    this.chI.BZ();
    String str = String.format(Locale.US, ";if(__wxConfig.preload){ %s };", new Object[] { cg.x("onWxConfigReady", "", 0) });
    aOf().evaluateJavascript(str, null);
    AppMethodBeat.o(146836);
  }
  
  public final String DN()
  {
    return "https://usr/";
  }
  
  public final String DO()
  {
    return "https://lib/";
  }
  
  protected a DP()
  {
    AppMethodBeat.i(146844);
    a locala = new a(this);
    AppMethodBeat.o(146844);
    return locala;
  }
  
  protected c.b DQ()
  {
    AppMethodBeat.i(146845);
    com.tencent.mm.plugin.appbrand.c localc = new com.tencent.mm.plugin.appbrand.c(Dl(), this, Dl().cif);
    AppMethodBeat.o(146845);
    return localc;
  }
  
  public com.tencent.luggage.sdk.d.c Dl()
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
    if (paramClass.isInstance(this.chI))
    {
      paramClass = paramClass.cast(this.chI);
      AppMethodBeat.o(146825);
      return paramClass;
    }
    paramClass = paramClass.cast(this.chI.Q(paramClass));
    AppMethodBeat.o(146825);
    return paramClass;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  public final void a(String paramString1, String paramString2, int paramInt, o paramo)
  {
    AppMethodBeat.i(186873);
    if (((paramo == null) || (paramo == aOf())) && (this.chI.d(paramString1, paramString2, paramInt)))
    {
      AppMethodBeat.o(186873);
      return;
    }
    super.a(paramString1, paramString2, paramInt, paramo);
    AppMethodBeat.o(186873);
  }
  
  public final void bx(boolean paramBoolean)
  {
    AppMethodBeat.i(146839);
    super.bx(paramBoolean);
    this.chI.BU();
    AppMethodBeat.o(146839);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(146842);
    if (this.chI.d(paramString1, paramString2, paramInt))
    {
      AppMethodBeat.o(146842);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(146842);
  }
  
  public void ci(String paramString)
  {
    AppMethodBeat.i(146841);
    this.chI.ci(paramString);
    AppMethodBeat.o(146841);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(146837);
    this.chI.BK();
    super.cleanup();
    this.chI.BL();
    AppMethodBeat.o(146837);
  }
  
  public final String cv(String paramString)
  {
    AppMethodBeat.i(146835);
    String str = this.chI.cw(paramString);
    if (bt.isNullOrNil(str))
    {
      paramString = super.cv(paramString);
      AppMethodBeat.o(146835);
      return paramString;
    }
    AppMethodBeat.o(146835);
    return str;
  }
  
  public void d(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(146830);
    super.d(paramAppBrandRuntime);
    this.jvC = DQ();
    this.chI.c(paramAppBrandRuntime);
    AppMethodBeat.o(146830);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146832);
    super.d(paramJSONObject);
    c(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.chI.BH()));
    c(paramJSONObject, "version", com.tencent.mm.sdk.platformtools.i.au(null, h.ETr));
    c(paramJSONObject, "language", com.tencent.mm.sdk.platformtools.ac.ir(getContext()));
    AppMethodBeat.o(146832);
  }
  
  protected void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(146834);
    this.chI.c(paramJSONObject);
    AppMethodBeat.o(146834);
  }
  
  public void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(146846);
    if (this.chI.i(paramInt, paramString))
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