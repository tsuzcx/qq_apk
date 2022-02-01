package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import org.json.JSONObject;

public final class k
  extends c
{
  private static final int CTRL_INDEX = 255;
  public static final String NAME = "removeTextView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137540);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137540);
    return i;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137541);
    parame.fG(paramJSONObject.optBoolean("independent", false)).sD(paramInt);
    boolean bool = super.b(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(137541);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.k
 * JD-Core Version:    0.7.0.1
 */