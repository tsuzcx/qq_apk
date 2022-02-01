package com.tencent.mm.plugin.appbrand.jsapi.ac.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import org.json.JSONObject;

public class a
  extends c
{
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186896);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(186896);
    return i;
  }
  
  public final String bgx()
  {
    return "camera";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.a.a.a
 * JD-Core Version:    0.7.0.1
 */