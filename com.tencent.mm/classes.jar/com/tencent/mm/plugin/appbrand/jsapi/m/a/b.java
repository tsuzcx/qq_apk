package com.tencent.mm.plugin.appbrand.jsapi.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.o.b.b;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.appbrand.jsapi.m.b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  private final a lbp;
  
  public b(b.b paramb)
  {
    AppMethodBeat.i(179512);
    this.lbp = a(paramb);
    AppMethodBeat.o(179512);
  }
  
  protected a a(b.b paramb)
  {
    AppMethodBeat.i(179513);
    paramb = new a(paramb, this.laM);
    AppMethodBeat.o(179513);
    return paramb;
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179515);
    this.lbp.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179515);
  }
  
  public final String aOZ()
  {
    AppMethodBeat.i(179514);
    String str = this.lbp.aOZ();
    AppMethodBeat.o(179514);
    return str;
  }
  
  public final String aeV()
  {
    return "downloadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a.b
 * JD-Core Version:    0.7.0.1
 */