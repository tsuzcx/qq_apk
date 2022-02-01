package com.tencent.mm.plugin.appbrand.jsapi.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p.d.b;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.j.c
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTask";
  private final a kBG;
  
  public b(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179528);
    this.kBG = new a(paramInt, paramb, this.kAW);
    AppMethodBeat.o(179528);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179530);
    this.kBG.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179530);
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(179529);
    String str = this.kBG.aLs();
    AppMethodBeat.o(179529);
    return str;
  }
  
  public final String acf()
  {
    return "requestTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.b.b
 * JD-Core Version:    0.7.0.1
 */