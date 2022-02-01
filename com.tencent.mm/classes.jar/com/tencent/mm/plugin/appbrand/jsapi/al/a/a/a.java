package com.tencent.mm.plugin.appbrand.jsapi.al.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import org.json.JSONObject;

public class a
  extends c
{
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327001);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(327001);
    return i;
  }
  
  public final String cog()
  {
    return "camera";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.a.a.a
 * JD-Core Version:    0.7.0.1
 */