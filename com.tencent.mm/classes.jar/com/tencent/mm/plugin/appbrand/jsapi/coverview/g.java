package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.af;
import org.json.JSONObject;

public final class g
  extends b
{
  private static final int CTRL_INDEX = 448;
  public static final String NAME = "removeScrollView";
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126311);
    parame.vC().pj(paramInt);
    boolean bool = super.b(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(126311);
    return bool;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126310);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(126310);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.g
 * JD-Core Version:    0.7.0.1
 */