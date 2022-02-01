package com.tencent.mm.plugin.appbrand.jsapi.m.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.m.b
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTask";
  private a lbz;
  
  public b()
  {
    AppMethodBeat.i(179543);
    this.lbz = new a(this.laM);
    AppMethodBeat.o(179543);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179545);
    this.lbz.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179545);
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(179544);
    String str = this.lbz.aOZ();
    AppMethodBeat.o(179544);
    return str;
  }
  
  public final String aeV()
  {
    return "uploadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.c.b
 * JD-Core Version:    0.7.0.1
 */