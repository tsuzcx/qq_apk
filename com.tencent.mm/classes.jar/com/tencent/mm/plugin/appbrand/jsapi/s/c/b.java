package com.tencent.mm.plugin.appbrand.jsapi.s.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.g.b;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.s.b
{
  public static final int CTRL_INDEX = 272;
  public static final String NAME = "createUploadTask";
  private a skp;
  
  public b(g.b paramb)
  {
    AppMethodBeat.i(327267);
    this.skp = new a(paramb, this.sjy);
    AppMethodBeat.o(327267);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179545);
    this.skp.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179545);
  }
  
  public final String aUD()
  {
    AppMethodBeat.i(327271);
    String str = this.skp.aUD();
    AppMethodBeat.o(327271);
    return str;
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179544);
    String str = this.skp.bQs();
    AppMethodBeat.o(179544);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.c.b
 * JD-Core Version:    0.7.0.1
 */