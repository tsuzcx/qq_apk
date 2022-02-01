package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.content.res.Resources;
import android.text.StaticLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.ae.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import java.util.HashMap;
import org.json.JSONObject;

public final class j
  extends aa<e>
{
  private static final int CTRL_INDEX = -2;
  private static final String NAME = "measureTextString";
  
  public final String a(e parame, JSONObject paramJSONObject)
  {
    int j = 2147483647;
    AppMethodBeat.i(206097);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("size");
    paramJSONObject = paramJSONObject.optJSONObject("label");
    if ((localJSONObject == null) || (paramJSONObject == null))
    {
      parame = h("fail:invalid data", null);
      AppMethodBeat.o(206097);
      return parame;
    }
    int k = g.a(localJSONObject, "width", 2147483647);
    int i = k;
    if (k < 0) {
      i = 2147483647;
    }
    k = g.a(localJSONObject, "height", 2147483647);
    if (k < 0) {}
    for (;;)
    {
      if (parame.getContext() == null) {}
      float f1;
      for (parame = Resources.getSystem();; parame = parame.getContext().getResources())
      {
        parame = new a(parame, i);
        c.a(parame, paramJSONObject);
        parame = parame.oPy.aIO().kgD;
        f1 = 0.0F;
        i = 0;
        while (i < parame.getLineCount())
        {
          f1 = Math.max(f1, parame.getLineWidth(i));
          i += 1;
        }
      }
      float f2 = Math.min(parame.getHeight(), j);
      parame = new HashMap(2);
      parame.put("width", Float.valueOf(g.aT(f1)));
      parame.put("height", Float.valueOf(g.aT(f2)));
      parame = m("ok", new j.1(this, parame));
      AppMethodBeat.o(206097);
      return parame;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.j
 * JD-Core Version:    0.7.0.1
 */