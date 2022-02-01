package com.tencent.mm.plugin.appbrand.jsapi.j.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j.d;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTaskAsync";
  private a kaW;
  
  public c()
  {
    AppMethodBeat.i(179546);
    this.kaW = new a(this.kal);
    AppMethodBeat.o(179546);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179548);
    this.kaW.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179548);
  }
  
  public final String aEB()
  {
    AppMethodBeat.i(179547);
    String str = this.kaW.aEB();
    AppMethodBeat.o(179547);
    return str;
  }
  
  public final String abh()
  {
    return "uploadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.c.c
 * JD-Core Version:    0.7.0.1
 */