package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class h
  extends b
{
  private static final int CTRL_INDEX = 811;
  public static final String NAME = "removeImagePreviewer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186591);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(186591);
    return i;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(186590);
    ac.d("MicroMsg.JsApiRemoveImagePreviewer", "insertImagePreviewer(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    parame.aUW().sb(paramInt);
    boolean bool = super.b(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(186590);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.h
 * JD-Core Version:    0.7.0.1
 */