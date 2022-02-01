package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.l.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public class bc
  extends e
{
  private f eqB;
  private String rya;
  private Map<String, Object> ryb;
  private int ryc;
  
  public bc L(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140645);
    if (paramMap == null)
    {
      AppMethodBeat.o(140645);
      return this;
    }
    d.k(paramMap);
    this.ryb = paramMap;
    AppMethodBeat.o(140645);
    return this;
  }
  
  public bc ZR(String paramString)
  {
    this.rya = paramString;
    return this;
  }
  
  public bc b(f paramf, int paramInt)
  {
    AppMethodBeat.i(140643);
    i(paramf);
    this.ryc = paramInt;
    AppMethodBeat.o(140643);
    return this;
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(325600);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      Objects.requireNonNull(this.eqB);
      Objects.requireNonNull(paramo);
    }
    if (this.eqB == null)
    {
      AppMethodBeat.o(325600);
      return;
    }
    Object localObject = paramo;
    if (paramo == null) {
      localObject = this.eqB.getJsRuntime();
    }
    if (!this.eqB.a(getName(), (o)localObject))
    {
      AppMethodBeat.o(325600);
      return;
    }
    paramo = this.eqB.getInterceptor();
    if (paramo == null)
    {
      c((o)localObject);
      AppMethodBeat.o(325600);
      return;
    }
    paramo.a(this, (o)localObject, new f.b()
    {
      public final void ZJ(String paramAnonymousString) {}
      
      public final void proceed()
      {
        AppMethodBeat.i(325683);
        bc.this.c(this.ryd);
        AppMethodBeat.o(325683);
      }
    });
    AppMethodBeat.o(325600);
  }
  
  final void c(o paramo)
  {
    AppMethodBeat.i(325604);
    if (paramo == this.eqB.getJsRuntime())
    {
      this.eqB.f(getName(), getData(), this.ryc);
      AppMethodBeat.o(325604);
      return;
    }
    di.a(paramo, getName(), getData(), this.ryc);
    AppMethodBeat.o(325604);
  }
  
  public void cpV()
  {
    AppMethodBeat.i(140647);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
      Objects.requireNonNull(this.eqB);
    }
    if ((this.eqB != null) && (this.eqB.isRunning())) {
      b(this.eqB.getJsRuntime());
    }
    AppMethodBeat.o(140647);
  }
  
  public final String getData()
  {
    AppMethodBeat.i(140646);
    String str;
    if (this.rya != null)
    {
      str = this.rya;
      AppMethodBeat.o(140646);
      return str;
    }
    if (this.ryb != null)
    {
      d.k(this.ryb);
      str = new JSONObject(this.ryb).toString();
      AppMethodBeat.o(140646);
      return str;
    }
    AppMethodBeat.o(140646);
    return null;
  }
  
  public bc i(f paramf)
  {
    if (paramf == null) {
      return this;
    }
    this.eqB = paramf;
    this.ryc = 0;
    return this;
  }
  
  public final bc w(String paramString, Object paramObject)
  {
    AppMethodBeat.i(140644);
    if (this.ryb == null) {
      this.ryb = new HashMap();
    }
    this.ryb.put(paramString, paramObject);
    AppMethodBeat.o(140644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bc
 * JD-Core Version:    0.7.0.1
 */