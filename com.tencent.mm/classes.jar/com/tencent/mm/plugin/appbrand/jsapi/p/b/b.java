package com.tencent.mm.plugin.appbrand.jsapi.p.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.d.b;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.p.b
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTask";
  private final a peT;
  
  public b(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179528);
    this.peT = new a(paramInt, paramb, this.pei);
    AppMethodBeat.o(179528);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179530);
    this.peT.a(parame, paramJSONObject, paramString);
    AppMethodBeat.o(179530);
  }
  
  public final String aBF()
  {
    return "requestTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179529);
    String str = this.peT.bsL();
    AppMethodBeat.o(179529);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b.b
 * JD-Core Version:    0.7.0.1
 */