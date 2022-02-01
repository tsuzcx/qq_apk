package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import org.json.JSONObject;

public final class l
  extends c
{
  private static final int CTRL_INDEX = 255;
  public static final String NAME = "removeImageView";
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137536);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137536);
    return i;
  }
  
  public final boolean b(g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137537);
    paramg.hl(paramJSONObject.optBoolean("independent", false)).zR(paramInt);
    boolean bool = super.b(paramg, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(137537);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.l
 * JD-Core Version:    0.7.0.1
 */