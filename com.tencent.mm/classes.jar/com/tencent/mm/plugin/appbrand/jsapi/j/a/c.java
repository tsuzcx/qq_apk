package com.tencent.mm.plugin.appbrand.jsapi.j.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j.d;
import com.tencent.mm.plugin.appbrand.p.b.b;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 269;
  public static final String NAME = "createDownloadTaskAsync";
  private final a kBz;
  
  public c(b.b paramb)
  {
    AppMethodBeat.i(179516);
    this.kBz = new a(paramb, this.kAY);
    AppMethodBeat.o(179516);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(179518);
    this.kBz.a(paramc, paramJSONObject, paramString);
    AppMethodBeat.o(179518);
  }
  
  public final String aLs()
  {
    AppMethodBeat.i(179517);
    String str = this.kBz.aLs();
    AppMethodBeat.o(179517);
    return str;
  }
  
  public final String acf()
  {
    return "downloadTaskId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a.c
 * JD-Core Version:    0.7.0.1
 */