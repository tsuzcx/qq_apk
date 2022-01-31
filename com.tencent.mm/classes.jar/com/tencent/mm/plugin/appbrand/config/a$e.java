package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class a$e
{
  public final String desc;
  public final String name;
  
  public a$e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(86876);
    this.name = paramString;
    this.desc = paramJSONObject.getString("desc");
    AppMethodBeat.o(86876);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(86877);
    String str = "Permission{name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + '}';
    AppMethodBeat.o(86877);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.e
 * JD-Core Version:    0.7.0.1
 */