package com.tencent.mm.plugin.appbrand.jsapi.p.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.p.c
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTaskAsync";
  private a peW;
  
  public c()
  {
    AppMethodBeat.i(179546);
    this.peW = new a(bTl());
    AppMethodBeat.o(179546);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179548);
    this.peW.a(parame, paramJSONObject, paramString);
    AppMethodBeat.o(179548);
  }
  
  public final String aBF()
  {
    return "uploadTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179547);
    String str = this.peW.bsL();
    AppMethodBeat.o(179547);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.c.c
 * JD-Core Version:    0.7.0.1
 */