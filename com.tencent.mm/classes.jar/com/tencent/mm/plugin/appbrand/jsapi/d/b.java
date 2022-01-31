package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.u.n;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  public static final int CTRL_INDEX = 70;
  public static final String NAME = "hideKeyboard";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
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
    n.runOnUiThread(new b.1(this, paramc, paramJSONObject, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.b
 * JD-Core Version:    0.7.0.1
 */