package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class k
  extends c
{
  private static final int CTRL_INDEX = 811;
  public static final String NAME = "removeImagePreviewer";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226741);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(226741);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(226740);
    Log.d("MicroMsg.JsApiRemoveImagePreviewer", "insertImagePreviewer(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    paramh.getCustomViewContainer().wC(paramInt);
    boolean bool = super.b(paramh, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(226740);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.k
 * JD-Core Version:    0.7.0.1
 */