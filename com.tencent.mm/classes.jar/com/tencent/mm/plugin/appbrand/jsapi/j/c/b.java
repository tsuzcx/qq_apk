package com.tencent.mm.plugin.appbrand.jsapi.j.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.j.c
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTask";
  private a kBJ;
  
  public b()
  {
    AppMethodBeat.i(179543);
    this.kBJ = new a(this.kAW);
    AppMethodBeat.o(179543);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179545);
    this.kBJ.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179545);
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(179544);
    String str = this.kBJ.aLs();
    AppMethodBeat.o(179544);
    return str;
  }
  
  public final String acf()
  {
    return "uploadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.c.b
 * JD-Core Version:    0.7.0.1
 */