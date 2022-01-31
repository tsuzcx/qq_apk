package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class i
  extends c
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateImageView";
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126315);
    ab.d("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126315);
      return false;
    }
    a locala = (a)((CoverViewContainer)paramView).aa(a.class);
    if (locala == null)
    {
      ab.w("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(126315);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.s.e.b(paramView, paramJSONObject.optJSONObject("style"));
    b.a(parame, locala, paramJSONObject);
    boolean bool = super.c(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(126315);
    return bool;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126314);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(126314);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.i
 * JD-Core Version:    0.7.0.1
 */