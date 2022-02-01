package com.tencent.mm.plugin.appbrand.jsapi.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q.b.b;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.appbrand.jsapi.j.c
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  private final a kaM;
  
  public b(b.b paramb)
  {
    AppMethodBeat.i(179512);
    this.kaM = a(paramb);
    AppMethodBeat.o(179512);
  }
  
  protected a a(b.b paramb)
  {
    AppMethodBeat.i(179513);
    paramb = new a(paramb, this.kaj);
    AppMethodBeat.o(179513);
    return paramb;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179515);
    this.kaM.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179515);
  }
  
  public final String aEB()
  {
    AppMethodBeat.i(179514);
    String str = this.kaM.aEB();
    AppMethodBeat.o(179514);
    return str;
  }
  
  public final String abh()
  {
    return "downloadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a.b
 * JD-Core Version:    0.7.0.1
 */