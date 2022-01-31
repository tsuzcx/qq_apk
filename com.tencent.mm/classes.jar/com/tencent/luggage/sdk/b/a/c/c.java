package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ag;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.k.f;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import org.json.JSONObject;

public class c
  extends r
  implements com.tencent.luggage.sdk.b.a.d, f
{
  public e bEO;
  
  public c()
  {
    this(new b.a());
    AppMethodBeat.i(140754);
    AppMethodBeat.o(140754);
  }
  
  public c(com.tencent.luggage.sdk.b.a.b.a parama)
  {
    AppMethodBeat.i(140755);
    String str = parama.getClass().getSimpleName();
    com.tencent.luggage.g.d.d("MicroMsg.AppBrand.AppBrandServiceLU", "hy: using %s as logic imp", new Object[] { str });
    this.bEO = ((e)d.wL().a(parama, this));
    if (this.bEO == null)
    {
      parama = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(str)));
      AppMethodBeat.o(140755);
      throw parama;
    }
    AppMethodBeat.o(140755);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void b(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(140758);
    super.b(parami);
    this.hwJ = wJ();
    this.bEO.a(parami);
    AppMethodBeat.o(140758);
  }
  
  public final void bT(String paramString)
  {
    AppMethodBeat.i(140769);
    this.bEO.bT(paramString);
    AppMethodBeat.o(140769);
  }
  
  public void be(boolean paramBoolean)
  {
    AppMethodBeat.i(140767);
    super.be(paramBoolean);
    this.bEO.vb();
    AppMethodBeat.o(140767);
  }
  
  public final void c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(140771);
    if (this.bEO.d(paramString1, paramString2, paramInt))
    {
      AppMethodBeat.o(140771);
      return;
    }
    super.c(paramString1, paramString2, paramInt);
    AppMethodBeat.o(140771);
  }
  
  public final String ce(String paramString)
  {
    AppMethodBeat.i(140763);
    String str = this.bEO.cf(paramString);
    if (bo.isNullOrNil(str))
    {
      paramString = super.ce(paramString);
      AppMethodBeat.o(140763);
      return paramString;
    }
    AppMethodBeat.o(140763);
    return str;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(140765);
    this.bEO.uT();
    super.cleanup();
    this.bEO.uU();
    AppMethodBeat.o(140765);
  }
  
  public void e(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140760);
    super.e(paramJSONObject);
    b(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.bEO.uQ()));
    AppMethodBeat.o(140760);
  }
  
  protected void f(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140762);
    this.bEO.d(paramJSONObject);
    AppMethodBeat.o(140762);
  }
  
  public void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(140770);
    if (this.bEO.i(paramInt, paramString))
    {
      AppMethodBeat.o(140770);
      return;
    }
    super.h(paramInt, paramString);
    AppMethodBeat.o(140770);
  }
  
  public void tW()
  {
    AppMethodBeat.i(140766);
    this.bEO.tW();
    AppMethodBeat.o(140766);
  }
  
  public void vc()
  {
    AppMethodBeat.i(140768);
    super.vc();
    this.bEO.vc();
    AppMethodBeat.o(140768);
  }
  
  public final void vj()
  {
    AppMethodBeat.i(140772);
    this.bEO.vj();
    AppMethodBeat.o(140772);
  }
  
  public final void wA()
  {
    AppMethodBeat.i(140751);
    this.bEO.uS();
    AppMethodBeat.o(140751);
  }
  
  public com.tencent.mm.plugin.appbrand.i.i wB()
  {
    AppMethodBeat.i(140752);
    com.tencent.mm.plugin.appbrand.i.i locali2 = this.bEO.uR();
    com.tencent.mm.plugin.appbrand.i.i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.wB();
    }
    AppMethodBeat.o(140752);
    return locali1;
  }
  
  public final Map<String, m> wC()
  {
    AppMethodBeat.i(140756);
    Map localMap = this.bEO.wM();
    if (localMap != null)
    {
      AppMethodBeat.o(140756);
      return localMap;
    }
    localMap = new com.tencent.luggage.sdk.a().vS();
    AppMethodBeat.o(140756);
    return localMap;
  }
  
  public com.tencent.luggage.sdk.b.a.c wD()
  {
    AppMethodBeat.i(140757);
    com.tencent.luggage.sdk.b.a.c localc = (com.tencent.luggage.sdk.b.a.c)super.W(com.tencent.luggage.sdk.b.a.c.class);
    AppMethodBeat.o(140757);
    return localc;
  }
  
  public final JSONObject wE()
  {
    AppMethodBeat.i(140761);
    JSONObject localJSONObject = super.wE();
    b(localJSONObject, "appType", Integer.valueOf(wj().wS().bCV));
    b(localJSONObject, "debug", Boolean.valueOf(wj().wR().bDj));
    f(localJSONObject);
    AppMethodBeat.o(140761);
    return localJSONObject;
  }
  
  public final void wF()
  {
    AppMethodBeat.i(140764);
    super.wF();
    ag.a(wj(), aAO());
    this.bEO.vi();
    if (this.gRF) {
      super.br("onWxConfigReady", "");
    }
    AppMethodBeat.o(140764);
  }
  
  public final String wG()
  {
    return "https://usr/";
  }
  
  public final String wH()
  {
    return "https://lib/";
  }
  
  protected com.tencent.mm.plugin.appbrand.v.a wI()
  {
    AppMethodBeat.i(140773);
    com.tencent.mm.plugin.appbrand.v.a locala = new com.tencent.mm.plugin.appbrand.v.a(this);
    AppMethodBeat.o(140773);
    return locala;
  }
  
  protected c.b wJ()
  {
    AppMethodBeat.i(140774);
    com.tencent.mm.plugin.appbrand.c localc = new com.tencent.mm.plugin.appbrand.c(wj(), this, wj().wO());
    AppMethodBeat.o(140774);
    return localc;
  }
  
  public b wj()
  {
    AppMethodBeat.i(140759);
    b localb = (b)super.getRuntime();
    AppMethodBeat.o(140759);
    return localb;
  }
  
  public final <T> T x(Class<T> paramClass)
  {
    AppMethodBeat.i(140753);
    if (paramClass.isInstance(this))
    {
      paramClass = paramClass.cast(this);
      AppMethodBeat.o(140753);
      return paramClass;
    }
    if (paramClass.isInstance(this.bEO))
    {
      paramClass = paramClass.cast(this.bEO);
      AppMethodBeat.o(140753);
      return paramClass;
    }
    paramClass = paramClass.cast(this.bEO.x(paramClass));
    AppMethodBeat.o(140753);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.c
 * JD-Core Version:    0.7.0.1
 */