package com.tencent.mm.plugin.appbrand.jsapi.p.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.b.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.p.c
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTaskAsync";
  private final a peL;
  
  public c(b.b paramb)
  {
    AppMethodBeat.i(179516);
    this.peL = new a(paramb, bTl());
    AppMethodBeat.o(179516);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179518);
    this.peL.a(parame, paramJSONObject, paramString);
    AppMethodBeat.o(179518);
  }
  
  public final String aBF()
  {
    return "downloadTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179517);
    String str = this.peL.bsL();
    AppMethodBeat.o(179517);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a.c
 * JD-Core Version:    0.7.0.1
 */