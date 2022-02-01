package com.tencent.mm.plugin.appbrand.jsapi.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.m.c
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTaskAsync";
  private a lbz;
  
  public c()
  {
    AppMethodBeat.i(179546);
    this.lbz = new a(this.laO);
    AppMethodBeat.o(179546);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179548);
    this.lbz.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179548);
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(179547);
    String str = this.lbz.aOZ();
    AppMethodBeat.o(179547);
    return str;
  }
  
  public final String aeV()
  {
    return "uploadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.c.c
 * JD-Core Version:    0.7.0.1
 */