package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.content.res.Resources;
import android.text.StaticLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.ah.c;
import java.util.HashMap;
import org.json.JSONObject;

public final class j
  extends ab<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  private static final int CTRL_INDEX = -2;
  private static final String NAME = "measureTextString";
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    int j = 2147483647;
    AppMethodBeat.i(327350);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("size");
    paramJSONObject = paramJSONObject.optJSONObject("label");
    if ((localJSONObject == null) || (paramJSONObject == null))
    {
      paramf = ZP("fail:invalid data");
      AppMethodBeat.o(327350);
      return paramf;
    }
    int k = i.a(localJSONObject, "width", 2147483647);
    int i = k;
    if (k < 0) {
      i = 2147483647;
    }
    k = i.a(localJSONObject, "height", 2147483647);
    if (k < 0) {}
    for (;;)
    {
      if (paramf.getContext() == null) {}
      float f1;
      for (paramf = Resources.getSystem();; paramf = paramf.getContext().getResources())
      {
        paramf = new a(paramf, i);
        c.a(paramf, paramJSONObject);
        paramf = paramf.rTl.bbK().mGW;
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
      paramf.put("width", Float.valueOf(i.bV(f1)));
      paramf.put("height", Float.valueOf(i.bV(f2)));
      paramf = m("ok", new j.1(this, paramf));
      AppMethodBeat.o(327350);
      return paramf;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.j
 * JD-Core Version:    0.7.0.1
 */