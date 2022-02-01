package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import org.json.JSONObject;

public final class m
  extends c
{
  private static final int CTRL_INDEX = 448;
  public static final String NAME = "removeScrollView";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137538);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137538);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137539);
    paramh.gA(paramJSONObject.optBoolean("independent", false)).wC(paramInt);
    boolean bool = super.b(paramh, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(137539);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.m
 * JD-Core Version:    0.7.0.1
 */