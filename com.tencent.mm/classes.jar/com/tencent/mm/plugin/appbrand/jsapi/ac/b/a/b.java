package com.tencent.mm.plugin.appbrand.jsapi.ac.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class b
  extends c
{
  private static final int CTRL_INDEX = 673;
  public static final String NAME = "removeXWebCanvas";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139454);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(139454);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b.a.b
 * JD-Core Version:    0.7.0.1
 */