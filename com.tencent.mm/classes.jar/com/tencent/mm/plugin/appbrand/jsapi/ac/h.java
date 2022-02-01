package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.as;
import org.json.JSONObject;

public final class h
  extends c
{
  public static final int CTRL_INDEX = 299;
  public static final String NAME = "removeHTMLWebView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47018);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47018);
    return i;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47019);
    if ((paramView instanceof a))
    {
      ((a)paramView).destroy();
      if ((parame instanceof ad)) {
        as.a((ad)parame, null);
      }
    }
    boolean bool = super.b(parame, paramInt, paramView, paramJSONObject);
    AppMethodBeat.o(47019);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.h
 * JD-Core Version:    0.7.0.1
 */