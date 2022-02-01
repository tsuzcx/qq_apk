package com.tencent.mm.plugin.appbrand.jsapi.ad.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import org.json.JSONObject;

public class a
  extends c
{
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220588);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(220588);
    return i;
  }
  
  public final String bhf()
  {
    return "camera";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a.a.a
 * JD-Core Version:    0.7.0.1
 */