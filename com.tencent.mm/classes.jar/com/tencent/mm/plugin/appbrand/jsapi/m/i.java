package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.View;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

final class i
  extends d
{
  final void z(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    int j = paramJSONObject.optInt("current", 0);
    if ((localJSONArray == null) || (localJSONArray.length() <= 0))
    {
      y.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
      j("ok", null);
      n.runOnUiThread(new i.1(this));
      return;
    }
    paramJSONObject = new String[localJSONArray.length()];
    int i = 0;
    try
    {
      while (i < localJSONArray.length())
      {
        paramJSONObject[i] = localJSONArray.getString(i);
        i += 1;
      }
      ai.d(new i.2(this, paramJSONObject, j));
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[] { bk.j(paramJSONObject) });
      j("fail", null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.i
 * JD-Core Version:    0.7.0.1
 */