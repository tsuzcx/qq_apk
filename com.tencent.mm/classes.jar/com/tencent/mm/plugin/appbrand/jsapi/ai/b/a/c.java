package com.tencent.mm.plugin.appbrand.jsapi.ai.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import org.json.JSONObject;

public final class c
  extends d
{
  private static final int CTRL_INDEX = 674;
  public static final String NAME = "updateXWebCanvas";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139455);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(139455);
    return i;
  }
  
  public final boolean bQA()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.b.a.c
 * JD-Core Version:    0.7.0.1
 */