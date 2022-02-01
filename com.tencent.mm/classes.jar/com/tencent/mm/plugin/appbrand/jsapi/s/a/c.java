package com.tencent.mm.plugin.appbrand.jsapi.s.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.b.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.s.c
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTaskAsync";
  private final a skc;
  
  public c(b.b paramb)
  {
    AppMethodBeat.i(179516);
    this.skc = new a(paramb, ctq());
    AppMethodBeat.o(179516);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179518);
    this.skc.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179518);
  }
  
  public final String aUD()
  {
    AppMethodBeat.i(327285);
    String str = this.skc.aUD();
    AppMethodBeat.o(327285);
    return str;
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179517);
    String str = this.skc.bQs();
    AppMethodBeat.o(179517);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.a.c
 * JD-Core Version:    0.7.0.1
 */