package com.tencent.mm.plugin.appbrand.jsapi.ag.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import org.json.JSONObject;

public class a
  extends c
{
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(215802);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(215802);
    return i;
  }
  
  public final String bCy()
  {
    return "camera";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.a
 * JD-Core Version:    0.7.0.1
 */