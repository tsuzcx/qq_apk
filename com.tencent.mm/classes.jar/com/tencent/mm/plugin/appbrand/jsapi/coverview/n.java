package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import org.json.JSONObject;

public final class n
  extends c
{
  private static final int CTRL_INDEX = 255;
  public static final String NAME = "removeTextView";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137540);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137540);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137541);
    paramh.ic(paramJSONObject.optBoolean("independent", false)).Aj(paramInt);
    boolean bool = super.b(paramh, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(137541);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.n
 * JD-Core Version:    0.7.0.1
 */