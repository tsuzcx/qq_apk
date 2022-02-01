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
  private final a lbw;
  
  public b(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179528);
    this.lbw = new a(paramInt, paramb, this.laM);
    AppMethodBeat.o(179528);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179530);
    this.lbw.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179530);
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(179529);
    String str = this.lbw.aOZ();
    AppMethodBeat.o(179529);
    return str;
  }
  
  public final String aeV()
  {
    return "requestTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.b.b
 * JD-Core Version:    0.7.0.1
 */