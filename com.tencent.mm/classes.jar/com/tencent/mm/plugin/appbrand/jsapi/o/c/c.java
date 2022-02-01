package com.tencent.mm.plugin.appbrand.jsapi.o.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.o.c
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTaskAsync";
  private a mgQ;
  
  public c()
  {
    AppMethodBeat.i(179546);
    this.mgQ = new a(this.mgd);
    AppMethodBeat.o(179546);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179548);
    this.mgQ.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179548);
  }
  
  public final String auJ()
  {
    return "uploadTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179547);
    String str = this.mgQ.bjl();
    AppMethodBeat.o(179547);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c.c
 * JD-Core Version:    0.7.0.1
 */