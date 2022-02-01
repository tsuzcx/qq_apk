package com.tencent.mm.plugin.appbrand.jsapi.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.b.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.m.c
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTaskAsync";
  private final a lbp;
  
  public c(b.b paramb)
  {
    AppMethodBeat.i(179516);
    this.lbp = new a(paramb, this.laO);
    AppMethodBeat.o(179516);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179518);
    this.lbp.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179518);
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(179517);
    String str = this.lbp.aOZ();
    AppMethodBeat.o(179517);
    return str;
  }
  
  public final String aeV()
  {
    return "downloadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.c
 * JD-Core Version:    0.7.0.1
 */