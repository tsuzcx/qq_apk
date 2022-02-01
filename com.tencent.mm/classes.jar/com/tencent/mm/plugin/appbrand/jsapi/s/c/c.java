package com.tencent.mm.plugin.appbrand.jsapi.s.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.g.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.s.c
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTaskAsync";
  private a skp;
  
  public c(g.b paramb)
  {
    AppMethodBeat.i(327268);
    this.skp = new a(paramb, ctq());
    AppMethodBeat.o(327268);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179548);
    this.skp.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179548);
  }
  
  public final String aUD()
  {
    AppMethodBeat.i(327272);
    String str = this.skp.aUD();
    AppMethodBeat.o(327272);
    return str;
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179547);
    String str = this.skp.bQs();
    AppMethodBeat.o(179547);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.c.c
 * JD-Core Version:    0.7.0.1
 */