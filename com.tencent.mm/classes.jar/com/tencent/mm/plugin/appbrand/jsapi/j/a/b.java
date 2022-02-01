package com.tencent.mm.plugin.appbrand.jsapi.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p.b.b;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.appbrand.jsapi.j.c
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  private final a kBz;
  
  public b(b.b paramb)
  {
    AppMethodBeat.i(179512);
    this.kBz = a(paramb);
    AppMethodBeat.o(179512);
  }
  
  protected a a(b.b paramb)
  {
    AppMethodBeat.i(179513);
    paramb = new a(paramb, this.kAW);
    AppMethodBeat.o(179513);
    return paramb;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179515);
    this.kBz.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179515);
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(179514);
    String str = this.kBz.aLs();
    AppMethodBeat.o(179514);
    return str;
  }
  
  public final String acf()
  {
    return "downloadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a.b
 * JD-Core Version:    0.7.0.1
 */