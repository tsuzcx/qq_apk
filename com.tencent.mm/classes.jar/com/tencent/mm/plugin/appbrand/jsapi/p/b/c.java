package com.tencent.mm.plugin.appbrand.jsapi.p.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.d.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.p.c
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTaskAsync";
  private final a peT;
  
  public c(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179531);
    this.peT = new a(paramInt, paramb, bTl());
    AppMethodBeat.o(179531);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179533);
    this.peT.a(parame, paramJSONObject, paramString);
    AppMethodBeat.o(179533);
  }
  
  public final String aBF()
  {
    return "requestTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179532);
    String str = this.peT.bsL();
    AppMethodBeat.o(179532);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b.c
 * JD-Core Version:    0.7.0.1
 */