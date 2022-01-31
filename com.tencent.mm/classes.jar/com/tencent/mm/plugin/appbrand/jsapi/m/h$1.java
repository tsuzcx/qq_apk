package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

final class h$1
  extends d
{
  h$1(h paramh) {}
  
  final void z(JSONObject paramJSONObject)
  {
    int j = paramJSONObject.optInt("column", -1);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    if ((j < 0) || (localJSONArray == null) || (localJSONArray.length() < 0))
    {
      j("fail:invalid data", null);
      return;
    }
    try
    {
      String[] arrayOfString = new String[localJSONArray.length()];
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = localJSONArray.getString(i);
        i += 1;
      }
      paramJSONObject = new AppBrandMultiOptionsPicker.a(arrayOfString, paramJSONObject.optInt("current", 0));
      ai.d(new h.1.1(this, j, paramJSONObject));
      return;
    }
    catch (Exception paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramJSONObject, "opt params", new Object[0]);
      j("fail:invalid data", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.h.1
 * JD-Core Version:    0.7.0.1
 */