package com.tencent.mm.plugin.appbrand.jsapi.o.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.d.b;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.o.b
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTask";
  private final a mgN;
  
  public b(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179528);
    this.mgN = new a(paramInt, paramb, this.mgb);
    AppMethodBeat.o(179528);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179530);
    this.mgN.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179530);
  }
  
  public final String auJ()
  {
    return "requestTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179529);
    String str = this.mgN.bjl();
    AppMethodBeat.o(179529);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b.b
 * JD-Core Version:    0.7.0.1
 */