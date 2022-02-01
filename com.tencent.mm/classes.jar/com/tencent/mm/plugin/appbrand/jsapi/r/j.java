package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

final class j
  extends e
{
  final void ac(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137610);
    super.ac(paramJSONObject);
    AppMethodBeat.o(137610);
  }
  
  final void ad(final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137611);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    final int j = paramJSONObject.optInt("current", 0);
    if ((localJSONArray == null) || (localJSONArray.length() <= 0))
    {
      Log.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
      q("ok", null);
      P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137602);
          j.a(j.this);
          AppMethodBeat.o(137602);
        }
      });
      AppMethodBeat.o(137611);
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
      P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137603);
          j.a(j.this, paramJSONObject, j);
          AppMethodBeat.o(137603);
        }
      });
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[] { Util.stackTraceToString(paramJSONObject) });
      q("fail", null);
      AppMethodBeat.o(137611);
      return;
    }
    AppMethodBeat.o(137611);
  }
  
  final void ae(final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137612);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    final int j = paramJSONObject.optInt("current", 0);
    if ((localJSONArray == null) || (localJSONArray.length() <= 0))
    {
      Log.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
      q("ok", null);
      P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137604);
          j.b(j.this);
          AppMethodBeat.o(137604);
        }
      });
      AppMethodBeat.o(137612);
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
      P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137605);
          j.b(j.this, paramJSONObject, j);
          AppMethodBeat.o(137605);
        }
      });
    }
    catch (Exception paramJSONObject)
    {
      Log.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[] { Util.stackTraceToString(paramJSONObject) });
      q("fail", null);
      AppMethodBeat.o(137612);
      return;
    }
    AppMethodBeat.o(137612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.j
 * JD-Core Version:    0.7.0.1
 */