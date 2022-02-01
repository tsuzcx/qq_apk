package com.tencent.mm.plugin.appbrand.jsapi.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.d.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.m.c
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTaskAsync";
  private final a kXN;
  
  public c(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179531);
    this.kXN = new a(paramInt, paramb, this.kXf);
    AppMethodBeat.o(179531);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179533);
    this.kXN.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179533);
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(179532);
    String str = this.kXN.aOC();
    AppMethodBeat.o(179532);
    return str;
  }
  
  public final String aeJ()
  {
    return "requestTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b.c
 * JD-Core Version:    0.7.0.1
 */