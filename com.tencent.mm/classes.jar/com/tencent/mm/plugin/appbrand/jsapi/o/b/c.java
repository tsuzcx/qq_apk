package com.tencent.mm.plugin.appbrand.jsapi.o.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.d.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.o.c
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTaskAsync";
  private final a mgN;
  
  public c(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179531);
    this.mgN = new a(paramInt, paramb, this.mgd);
    AppMethodBeat.o(179531);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179533);
    this.mgN.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179533);
  }
  
  public final String auJ()
  {
    return "requestTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179532);
    String str = this.mgN.bjl();
    AppMethodBeat.o(179532);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b.c
 * JD-Core Version:    0.7.0.1
 */