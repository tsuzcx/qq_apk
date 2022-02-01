package com.tencent.mm.plugin.appbrand.jsapi.o.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.o.b
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTask";
  private a mgQ;
  
  public b()
  {
    AppMethodBeat.i(179543);
    this.mgQ = new a(this.mgb);
    AppMethodBeat.o(179543);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179545);
    this.mgQ.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179545);
  }
  
  public final String auJ()
  {
    return "uploadTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179544);
    String str = this.mgQ.bjl();
    AppMethodBeat.o(179544);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c.b
 * JD-Core Version:    0.7.0.1
 */