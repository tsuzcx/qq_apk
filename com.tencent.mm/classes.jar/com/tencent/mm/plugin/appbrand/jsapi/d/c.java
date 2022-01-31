package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.s.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  public static final int CTRL_INDEX = 70;
  public static final String NAME = "hideKeyboard";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(123527);
    localObject = null;
    try
    {
      int i = paramJSONObject.getInt("inputId");
      paramJSONObject = Integer.valueOf(i);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject = localObject;
      }
    }
    m.runOnUiThread(new c.1(this, paramc, paramJSONObject, paramInt));
    AppMethodBeat.o(123527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.c
 * JD-Core Version:    0.7.0.1
 */