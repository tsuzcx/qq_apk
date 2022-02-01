package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.page.z;
import org.json.JSONObject;

public final class d
  extends b<z>
{
  private static final int CTRL_INDEX = 809;
  public static final String NAME = "insertImagePreviewer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222433);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(222433);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.d
 * JD-Core Version:    0.7.0.1
 */