package com.tencent.mm.plugin.appbrand.jsapi.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.c;
import org.json.JSONObject;

public class a
  extends c
{
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195073);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(195073);
    return i;
  }
  
  public final String aVV()
  {
    return "camera";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.a.a.a
 * JD-Core Version:    0.7.0.1
 */