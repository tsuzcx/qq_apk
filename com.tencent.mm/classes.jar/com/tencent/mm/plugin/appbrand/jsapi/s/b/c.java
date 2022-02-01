package com.tencent.mm.plugin.appbrand.jsapi.s.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.t.d.b;
import org.json.JSONObject;

public final class c
  extends b
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTask";
  private final a skk;
  
  public c(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179528);
    this.skk = new a(paramInt, paramb, this.sjy);
    AppMethodBeat.o(179528);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179530);
    this.skk.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179530);
  }
  
  public final String aUD()
  {
    AppMethodBeat.i(327292);
    String str = this.skk.aUD();
    AppMethodBeat.o(327292);
    return str;
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179529);
    String str = this.skk.bQs();
    AppMethodBeat.o(179529);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.c
 * JD-Core Version:    0.7.0.1
 */