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
  private c cfX;
  private String jxn;
  private Map<String, Object> jxo;
  int jxp;
  
  public ar C(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(140645);
    if (paramMap == null)
    {
      AppMethodBeat.o(140645);
      return this;
    }
    d.e(paramMap);
    this.jxo = paramMap;
    AppMethodBeat.o(140645);
    return this;
  }
  
  public ar HK(String paramString)
  {
    this.jxn = paramString;
    return this;
  }
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(194798);
    if (this.cfX == null)
    {
      AppMethodBeat.o(194798);
      return;
    }
    this.cfX.a(this, paramo);
    AppMethodBeat.o(194798);
  }
  
  public void aXQ()
  {
    AppMethodBeat.i(140647);
    a(null);
    AppMethodBeat.o(140647);
  }
  
  public ar b(c paramc, int paramInt)
  {
    AppMethodBeat.i(140643);
    h(paramc);
    this.jxp = paramInt;
    AppMethodBeat.o(140643);
    return this;
  }
  
  public final String getData()
  {
    AppMethodBeat.i(140646);
    String str;
    if (this.jxn != null)
    {
      str = this.jxn;
      AppMethodBeat.o(140646);
      return str;
    }
    if (this.jxo != null)
    {
      d.e(this.jxo);
      str = new JSONObject(this.jxo).toString();
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
    this.cfX = paramc;
    this.jxp = 0;
    return this;
  }
  
  public final ar r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(140644);
    if (this.jxo == null) {
      this.jxo = new HashMap();
    }
    this.jxo.put(paramString, paramObject);
    AppMethodBeat.o(140644);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */