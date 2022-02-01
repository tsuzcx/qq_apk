package com.tencent.mm.plugin.appbrand.jsapi.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j.d;
import com.tencent.mm.plugin.appbrand.q.d.b;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTaskAsync";
  private final a kaT;
  
  public c(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179531);
    this.kaT = new a(paramInt, paramb, this.kal);
    AppMethodBeat.o(179531);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179533);
    this.kaT.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179533);
  }
  
  public final String aEB()
  {
    AppMethodBeat.i(179532);
    String str = this.kaT.aEB();
    AppMethodBeat.o(179532);
    return str;
  }
  
  public final String abh()
  {
    return "requestTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.b.c
 * JD-Core Version:    0.7.0.1
 */