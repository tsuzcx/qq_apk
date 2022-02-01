package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.content.res.Resources;
import android.text.StaticLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.ac.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.HashMap;
import org.json.JSONObject;

public final class j
  extends ab<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  private static final int CTRL_INDEX = -2;
  private static final String NAME = "measureTextString";
  
  public final String a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(193674);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("size");
    paramJSONObject = paramJSONObject.optJSONObject("label");
    if ((localJSONObject == null) || (paramJSONObject == null))
    {
      paramf = h("fail:invalid data", null);
      AppMethodBeat.o(193674);
      return paramf;
    }
    int i = localJSONObject.optInt("width", 2147483647);
    int j = localJSONObject.optInt("height", 2147483647);
    if (paramf.getContext() == null) {}
    float f1;
    for (paramf = Resources.getSystem();; paramf = paramf.getContext().getResources())
    {
      paramf = new a(paramf, i);
      c.a(paramf, paramJSONObject);
      paramf = paramf.lSP.aBl().huH;
      f1 = 0.0F;
      i = 0;
      while (i < paramf.getLineCount())
      {
        f1 = Math.max(f1, paramf.getLineWidth(i));
        i += 1;
      }
    }
    float f2 = Math.min(paramf.getHeight(), j);
    paramf = new HashMap(2);
    paramf.put("width", Float.valueOf(g.aS(f1)));
    paramf.put("height", Float.valueOf(g.aS(f2)));
    paramf = n("ok", new HashMap() {});
    AppMethodBeat.o(193674);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.j
 * JD-Core Version:    0.7.0.1
 */