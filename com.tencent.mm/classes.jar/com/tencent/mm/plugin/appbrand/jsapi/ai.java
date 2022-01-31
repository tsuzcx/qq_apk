package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ai
  extends b
{
  private c bDN;
  private String hxE;
  private Map<String, Object> hxF;
  int hxG;
  
  public ai BN(String paramString)
  {
    this.hxE = paramString;
    return this;
  }
  
  public final void aBz()
  {
    AppMethodBeat.i(91040);
    if (this.bDN == null)
    {
      AppMethodBeat.o(91040);
      return;
    }
    this.bDN.a(this);
    AppMethodBeat.o(91040);
  }
  
  public ai b(c paramc, int paramInt)
  {
    AppMethodBeat.i(91036);
    j(paramc);
    this.hxG = paramInt;
    AppMethodBeat.o(91036);
    return this;
  }
  
  public final String getData()
  {
    AppMethodBeat.i(91039);
    String str;
    if (this.hxE != null)
    {
      str = this.hxE;
      AppMethodBeat.o(91039);
      return str;
    }
    if (this.hxF != null)
    {
      i.d(this.hxF);
      str = new JSONObject(this.hxF).toString();
      AppMethodBeat.o(91039);
      return str;
    }
    AppMethodBeat.o(91039);
    return null;
  }
  
  public ai j(c paramc)
  {
    if (paramc == null) {
      return this;
    }
    this.bDN = paramc;
    this.hxG = 0;
    return this;
  }
  
  public final ai m(String paramString, Object paramObject)
  {
    AppMethodBeat.i(91037);
    if (this.hxF == null) {
      this.hxF = new HashMap();
    }
    this.hxF.put(paramString, paramObject);
    AppMethodBeat.o(91037);
    return this;
  }
  
  public ai x(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(91038);
    if (paramMap == null)
    {
      AppMethodBeat.o(91038);
      return this;
    }
    i.d(paramMap);
    this.hxF = paramMap;
    AppMethodBeat.o(91038);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai
 * JD-Core Version:    0.7.0.1
 */