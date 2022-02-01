package com.tencent.mm.plugin.appbrand.jsapi.p.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.p.b
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTask";
  private a peW;
  
  public b()
  {
    AppMethodBeat.i(179543);
    this.peW = new a(this.pei);
    AppMethodBeat.o(179543);
  }
  
  public final void a(e parame, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179545);
    this.peW.a(parame, paramJSONObject, paramString);
    AppMethodBeat.o(179545);
  }
  
  public final String aBF()
  {
    return "uploadTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179544);
    String str = this.peW.bsL();
    AppMethodBeat.o(179544);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.c.b
 * JD-Core Version:    0.7.0.1
 */