package com.tencent.mm.plugin.appbrand.jsapi.s.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s.c;
import com.tencent.mm.plugin.appbrand.t.d.b;
import org.json.JSONObject;

public class d
  extends c
{
  public static final int CTRL_INDEX = 242;
  public static final String NAME = "createRequestTaskAsync";
  protected final a skk;
  
  public d(int paramInt, d.b paramb)
  {
    AppMethodBeat.i(179531);
    this.skk = new a(paramInt, paramb, ctq());
    AppMethodBeat.o(179531);
  }
  
  public void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179533);
    this.skk.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179533);
  }
  
  public final String aUD()
  {
    AppMethodBeat.i(327291);
    String str = this.skk.aUD();
    AppMethodBeat.o(327291);
    return str;
  }
  
  public final String bQs()
  {
    AppMethodBeat.i(179532);
    String str = this.skk.bQs();
    AppMethodBeat.o(179532);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b.d
 * JD-Core Version:    0.7.0.1
 */