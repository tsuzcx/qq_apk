package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONArray;
import org.json.JSONObject;

final class h$1
  extends d
{
  h$1(h paramh) {}
  
  final void H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126357);
    int j = paramJSONObject.optInt("column", -1);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    if ((j < 0) || (localJSONArray == null) || (localJSONArray.length() < 0))
    {
      l("fail:invalid data", null);
      AppMethodBeat.o(126357);
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
      al.d(new h.1.1(this, j, paramJSONObject));
      AppMethodBeat.o(126357);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramJSONObject, "opt params", new Object[0]);
      l("fail:invalid data", null);
      AppMethodBeat.o(126357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.h.1
 * JD-Core Version:    0.7.0.1
 */