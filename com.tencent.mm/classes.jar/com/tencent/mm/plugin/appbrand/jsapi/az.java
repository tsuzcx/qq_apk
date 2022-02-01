package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class az
  extends d
{
  private e cyi;
  private String ouK;
  private Map<String, Object> ouL;
  private int ouM;
  
  public az E(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140645);
    if (paramMap == null)
    {
      AppMethodBeat.o(140645);
      return this;
    }
    com.tencent.luggage.k.e.e(paramMap);
    this.ouL = paramMap;
    AppMethodBeat.o(140645);
    return this;
  }
  
  public az agU(String paramString)
  {
    this.ouK = paramString;
    return this;
  }
  
  public az b(e parame, int paramInt)
  {
    AppMethodBeat.i(140643);
    j(parame);
    this.ouM = paramInt;
    AppMethodBeat.o(140643);
    return this;
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(208436);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      Objects.requireNonNull(this.cyi);
      Objects.requireNonNull(paramo);
    }
    if (this.cyi == null)
    {
      AppMethodBeat.o(208436);
      return;
    }
    Object localObject = paramo;
    if (paramo == null) {
      localObject = this.cyi.getJsRuntime();
    }
    if (!this.cyi.a(getName(), (o)localObject))
    {
      AppMethodBeat.o(208436);
      return;
    }
    paramo = this.cyi.getInterceptor();
    if (paramo == null)
    {
      c((o)localObject);
      AppMethodBeat.o(208436);
      return;
    }
    paramo.a(this, (o)localObject, new e.b()
    {
      public final void agN(String paramAnonymousString) {}
      
      public final void proceed()
      {
        AppMethodBeat.i(209097);
        az.this.c(this.ouN);
        AppMethodBeat.o(209097);
      }
    });
    AppMethodBeat.o(208436);
  }
  
  public void bPO()
  {
    AppMethodBeat.i(140647);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
      Objects.requireNonNull(this.cyi);
    }
    if (this.cyi != null) {
      b(this.cyi.getJsRuntime());
    }
    AppMethodBeat.o(140647);
  }
  
  final void c(o paramo)
  {
    AppMethodBeat.i(208438);
    if (paramo == this.cyi.getJsRuntime())
    {
      this.cyi.c(getName(), getData(), this.ouM);
      AppMethodBeat.o(208438);
      return;
    }
    cy.a(paramo, getName(), getData(), this.ouM);
    AppMethodBeat.o(208438);
  }
  
  public final String getData()
  {
    AppMethodBeat.i(140646);
    String str;
    if (this.ouK != null)
    {
      str = this.ouK;
      AppMethodBeat.o(140646);
      return str;
    }
    if (this.ouL != null)
    {
      com.tencent.luggage.k.e.e(this.ouL);
      str = new JSONObject(this.ouL).toString();
      AppMethodBeat.o(140646);
      return str;
    }
    AppMethodBeat.o(140646);
    return null;
  }
  
  public az j(e parame)
  {
    if (parame == null) {
      return this;
    }
    this.cyi = parame;
    this.ouM = 0;
    return this;
  }
  
  public final az o(String paramString, Object paramObject)
  {
    AppMethodBeat.i(140644);
    if (this.ouL == null) {
      this.ouL = new HashMap();
    }
    this.ouL.put(paramString, paramObject);
    AppMethodBeat.o(140644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.az
 * JD-Core Version:    0.7.0.1
 */