package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ar
  extends b
{
  private c ccU;
  private String jXJ;
  private Map<String, Object> jXK;
  int jXL;
  
  public ar B(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140645);
    if (paramMap == null)
    {
      AppMethodBeat.o(140645);
      return this;
    }
    d.d(paramMap);
    this.jXK = paramMap;
    AppMethodBeat.o(140645);
    return this;
  }
  
  public ar LO(String paramString)
  {
    this.jXJ = paramString;
    return this;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(200936);
    if (this.ccU == null)
    {
      AppMethodBeat.o(200936);
      return;
    }
    this.ccU.a(this, paramo);
    AppMethodBeat.o(200936);
  }
  
  public ar b(c paramc, int paramInt)
  {
    AppMethodBeat.i(140643);
    h(paramc);
    this.jXL = paramInt;
    AppMethodBeat.o(140643);
    return this;
  }
  
  public void beN()
  {
    AppMethodBeat.i(140647);
    a(null);
    AppMethodBeat.o(140647);
  }
  
  public final String getData()
  {
    AppMethodBeat.i(140646);
    String str;
    if (this.jXJ != null)
    {
      str = this.jXJ;
      AppMethodBeat.o(140646);
      return str;
    }
    if (this.jXK != null)
    {
      d.d(this.jXK);
      str = new JSONObject(this.jXK).toString();
      AppMethodBeat.o(140646);
      return str;
    }
    AppMethodBeat.o(140646);
    return null;
  }
  
  public ar h(c paramc)
  {
    if (paramc == null) {
      return this;
    }
    this.ccU = paramc;
    this.jXL = 0;
    return this;
  }
  
  public final ar q(String paramString, Object paramObject)
  {
    AppMethodBeat.i(140644);
    if (this.jXK == null) {
      this.jXK = new HashMap();
    }
    this.jXK.put(paramString, paramObject);
    AppMethodBeat.o(140644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */