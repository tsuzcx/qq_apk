package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.c;
import com.tencent.mm.plugin.appbrand.jsapi.aa.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class m
  extends d
{
  private static final int CTRL_INDEX = 254;
  public static final String NAME = "updateImageView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137542);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(137542);
    return i;
  }
  
  public final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137543);
    ae.d("MicroMsg.JsApiUpdateImageView", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      ae.w("MicroMsg.JsApiUpdateImageView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137543);
      return false;
    }
    a locala = (a)((CoverViewContainer)paramView).ax(a.class);
    if (locala == null)
    {
      ae.w("MicroMsg.JsApiUpdateImageView", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137543);
      return false;
    }
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    c.a(parame, locala, paramJSONObject);
    boolean bool = super.c(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(137543);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.m
 * JD-Core Version:    0.7.0.1
 */