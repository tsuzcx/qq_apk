package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.b.b;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.o.c
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTaskAsync";
  private final a mgF;
  
  public c(b.b paramb)
  {
    AppMethodBeat.i(179516);
    this.mgF = new a(paramb, this.mgd);
    AppMethodBeat.o(179516);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179518);
    this.mgF.a(paramf, paramJSONObject, paramString);
    AppMethodBeat.o(179518);
  }
  
  public final String auJ()
  {
    return "downloadTaskId";
  }
  
  public final String bjl()
  {
    AppMethodBeat.i(179517);
    String str = this.mgF.bjl();
    AppMethodBeat.o(179517);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.c
 * JD-Core Version:    0.7.0.1
 */