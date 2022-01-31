package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 72;
  public static final String NAME = "chooseContact";
  private final d hKn;
  
  public c()
  {
    AppMethodBeat.i(145893);
    this.hKn = new d();
    AppMethodBeat.o(145893);
  }
  
  public static String xw(String paramString)
  {
    AppMethodBeat.i(145894);
    if (paramString == null)
    {
      AppMethodBeat.o(145894);
      return null;
    }
    String str = paramString.replaceAll("\\D", "");
    paramString = str;
    if (str.startsWith("86")) {
      paramString = str.substring(2);
    }
    AppMethodBeat.o(145894);
    return paramString;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126271);
    this.hKn.a(paramc, paramJSONObject, paramInt);
    AppMethodBeat.o(126271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.c
 * JD-Core Version:    0.7.0.1
 */