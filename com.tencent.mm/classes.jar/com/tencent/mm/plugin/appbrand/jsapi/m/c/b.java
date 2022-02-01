package com.tencent.mm.plugin.appbrand.jsapi.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.m.b
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTask";
  private a kXQ;
  
  public b()
  {
    AppMethodBeat.i(179543);
    this.kXQ = new a(this.kXd);
    AppMethodBeat.o(179543);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179545);
    this.kXQ.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179545);
  }
  
  public final String aOC()
  {
    AppMethodBeat.i(179544);
    String str = this.kXQ.aOC();
    AppMethodBeat.o(179544);
    return str;
  }
  
  public final String aeJ()
  {
    return "uploadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.c.b
 * JD-Core Version:    0.7.0.1
 */