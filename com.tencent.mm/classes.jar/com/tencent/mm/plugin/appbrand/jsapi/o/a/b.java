package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.b.b;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.appbrand.jsapi.o.b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  private final a mgF;
  
  public b(b.b paramb)
  {
    AppMethodBeat.i(179512);
    this.mgF = a(paramb);
    AppMethodBeat.o(179512);
  }
  
  protected a a(b.b paramb)
  {
    AppMethodBeat.i(179513);
    paramb = new a(paramb, this.mgb);
    AppMethodBeat.o(179513);
    return paramb;
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179515);
    this.mgF.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179515);
  }
  
  public final String auJ()
  {
    return "downloadTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179514);
    String str = this.mgF.bjl();
    AppMethodBeat.o(179514);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.b
 * JD-Core Version:    0.7.0.1
 */