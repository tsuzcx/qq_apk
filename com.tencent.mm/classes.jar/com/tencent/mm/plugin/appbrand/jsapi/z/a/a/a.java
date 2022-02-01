package com.tencent.mm.plugin.appbrand.jsapi.z.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.c;
import org.json.JSONObject;

public class a
  extends c
{
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(206713);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(206713);
    return i;
  }
  
  public final String bcT()
  {
    return "camera";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a.a.a
 * JD-Core Version:    0.7.0.1
 */