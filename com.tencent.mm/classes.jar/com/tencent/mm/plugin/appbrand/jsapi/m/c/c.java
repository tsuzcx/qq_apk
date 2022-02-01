package com.tencent.mm.plugin.appbrand.jsapi.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.m.c
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTaskAsync";
  private a kXQ;
  
  public c()
  {
    AppMethodBeat.i(179546);
    this.kXQ = new a(this.kXf);
    AppMethodBeat.o(179546);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179548);
    this.kXQ.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179548);
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(179547);
    String str = this.kXQ.aOC();
    AppMethodBeat.o(179547);
    return str;
  }
  
  public final String aeJ()
  {
    return "uploadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.c.c
 * JD-Core Version:    0.7.0.1
 */