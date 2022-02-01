package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 72;
  public static final String NAME = "chooseContact";
  private final d oOD;
  
  public c()
  {
    AppMethodBeat.i(137497);
    this.oOD = new d();
    AppMethodBeat.o(137497);
  }
  
  public static String aaY(String paramString)
  {
    AppMethodBeat.i(137499);
    if (paramString == null)
    {
      AppMethodBeat.o(137499);
      return null;
    }
    String str = paramString.replaceAll("\\D", "");
    paramString = str;
    if (str.startsWith("86")) {
      paramString = str.substring(2);
    }
    AppMethodBeat.o(137499);
    return paramString;
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137498);
    this.oOD.a(parame, paramJSONObject, paramInt);
    AppMethodBeat.o(137498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.c
 * JD-Core Version:    0.7.0.1
 */