package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class at
  extends b
{
  private c cnl;
  private String kse;
  private Map<String, Object> ksf;
  int ksg;
  
  public at B(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140645);
    if (paramMap == null)
    {
      AppMethodBeat.o(140645);
      return this;
    }
    d.d(paramMap);
    this.ksf = paramMap;
    AppMethodBeat.o(140645);
    return this;
  }
  
  public at Pi(String paramString)
  {
    this.kse = paramString;
    return this;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(187611);
    if (this.cnl == null)
    {
      AppMethodBeat.o(187611);
      return;
    }
    this.cnl.a(this, paramo);
    AppMethodBeat.o(187611);
  }
  
  public at b(c paramc, int paramInt)
  {
    AppMethodBeat.i(140643);
    h(paramc);
    this.ksg = paramInt;
    AppMethodBeat.o(140643);
    return this;
  }
  
  public void bir()
  {
    AppMethodBeat.i(140647);
    a(null);
    AppMethodBeat.o(140647);
  }
  
  public final String getData()
  {
    AppMethodBeat.i(140646);
    String str;
    if (this.kse != null)
    {
      str = this.kse;
      AppMethodBeat.o(140646);
      return str;
    }
    if (this.ksf != null)
    {
      d.d(this.ksf);
      str = new JSONObject(this.ksf).toString();
      AppMethodBeat.o(140646);
      return str;
    }
    AppMethodBeat.o(140646);
    return null;
  }
  
  public at h(c paramc)
  {
    if (paramc == null) {
      return this;
    }
    this.cnl = paramc;
    this.ksg = 0;
    return this;
  }
  
  public final at p(String paramString, Object paramObject)
  {
    AppMethodBeat.i(140644);
    if (this.ksf == null) {
      this.ksf = new HashMap();
    }
    this.ksf.put(paramString, paramObject);
    AppMethodBeat.o(140644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.at
 * JD-Core Version:    0.7.0.1
 */