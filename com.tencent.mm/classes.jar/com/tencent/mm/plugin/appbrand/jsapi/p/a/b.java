package com.tencent.mm.plugin.appbrand.jsapi.p.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.s.b.b;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.appbrand.jsapi.p.b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  private final a peL;
  
  public b(b.b paramb)
  {
    AppMethodBeat.i(179512);
    this.peL = a(paramb);
    AppMethodBeat.o(179512);
  }
  
  protected a a(b.b paramb)
  {
    AppMethodBeat.i(179513);
    paramb = new a(paramb, this.pei);
    AppMethodBeat.o(179513);
    return paramb;
  }
  
  public final void a(e parame, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179515);
    this.peL.a(parame, paramJSONObject, paramString);
    AppMethodBeat.o(179515);
  }
  
  public final String aBF()
  {
    return "downloadTaskId";
  }
  
  public final String bsL()
  {
    AppMethodBeat.i(179514);
    String str = this.peL.bsL();
    AppMethodBeat.o(179514);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a.b
 * JD-Core Version:    0.7.0.1
 */