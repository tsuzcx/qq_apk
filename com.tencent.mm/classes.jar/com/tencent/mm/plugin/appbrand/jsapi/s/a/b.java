package com.tencent.mm.plugin.appbrand.jsapi.s.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.t.b.b;
import org.json.JSONObject;

public class b
  extends com.tencent.mm.plugin.appbrand.jsapi.s.b
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTask";
  private final a skc;
  
  public b(b.b paramb)
  {
    AppMethodBeat.i(179512);
    this.skc = a(paramb);
    AppMethodBeat.o(179512);
  }
  
  protected a a(b.b paramb)
  {
    AppMethodBeat.i(179513);
    paramb = new a(paramb, this.sjy);
    AppMethodBeat.o(179513);
    return paramb;
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179515);
    this.skc.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179515);
  }
  
  public final String aUD()
  {
    AppMethodBeat.i(327288);
    String str = this.skc.aUD();
    AppMethodBeat.o(327288);
    return str;
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179514);
    String str = this.skc.bQs();
    AppMethodBeat.o(179514);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.a.b
 * JD-Core Version:    0.7.0.1
 */