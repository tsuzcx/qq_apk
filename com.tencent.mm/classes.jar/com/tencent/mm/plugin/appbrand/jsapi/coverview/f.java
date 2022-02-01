package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.ad;
import org.json.JSONObject;

public final class f
  extends b<ad>
{
  private static final int CTRL_INDEX = 809;
  public static final String NAME = "insertImagePreviewer";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327317);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(327317);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.f
 * JD-Core Version:    0.7.0.1
 */