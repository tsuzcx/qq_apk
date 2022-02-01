package com.tencent.mm.plugin.appbrand.jsapi.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.d.b;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.m.b
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTask";
  private final a kXN;
  
  public b(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179528);
    this.kXN = new a(paramInt, paramb, this.kXd);
    AppMethodBeat.o(179528);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179530);
    this.kXN.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179530);
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(179529);
    String str = this.kXN.aOC();
    AppMethodBeat.o(179529);
    return str;
  }
  
  public final String aeJ()
  {
    return "requestTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b.b
 * JD-Core Version:    0.7.0.1
 */