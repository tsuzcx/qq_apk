package com.tencent.mm.plugin.appbrand.jsapi.z.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 674;
  public static final String NAME = "updateXWebCanvas";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139455);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(139455);
    return i;
  }
  
  public final boolean bfu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b.a.c
 * JD-Core Version:    0.7.0.1
 */