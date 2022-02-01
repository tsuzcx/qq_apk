package com.tencent.mm.plugin.appbrand.jsapi.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.b.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.m.c
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTaskAsync";
  private final a kXG;
  
  public c(b.b paramb)
  {
    AppMethodBeat.i(179516);
    this.kXG = new a(paramb, this.kXf);
    AppMethodBeat.o(179516);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179518);
    this.kXG.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179518);
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(179517);
    String str = this.kXG.aOC();
    AppMethodBeat.o(179517);
    return str;
  }
  
  public final String aeJ()
  {
    return "downloadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.c
 * JD-Core Version:    0.7.0.1
 */