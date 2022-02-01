package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class b$e
{
  public final String desc;
  public final String name;
  
  public b$e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(134757);
    this.name = paramString;
    this.desc = paramJSONObject.getString("desc");
    AppMethodBeat.o(134757);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(134758);
    String str = "Permission{name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + '}';
    AppMethodBeat.o(134758);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.b.e
 * JD-Core Version:    0.7.0.1
 */