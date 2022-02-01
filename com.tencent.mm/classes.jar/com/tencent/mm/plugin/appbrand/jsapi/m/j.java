package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONArray;
import org.json.JSONObject;

final class j
  extends e
{
  final void R(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137610);
    super.R(paramJSONObject);
    AppMethodBeat.o(137610);
  }
  
  final void S(final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137611);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    final int j = paramJSONObject.optInt("current", 0);
    if ((localJSONArray == null) || (localJSONArray.length() <= 0))
    {
      ac.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
      n("ok", null);
      N(new Runnable()
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
      N(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137603);
          j localj = j.this;
          String[] arrayOfString = paramJSONObject;
          int i = j;
          AppBrandOptionsPicker localAppBrandOptionsPicker = (AppBrandOptionsPicker)localj.aK(AppBrandOptionsPicker.class);
          if (localAppBrandOptionsPicker == null)
          {
            localj.n("fail cant init view", null);
            AppMethodBeat.o(137603);
            return;
          }
          a locala = localj.mJP;
          locala.post(new j.7(localj, locala));
          localAppBrandOptionsPicker.setOptionsArray(arrayOfString);
          localAppBrandOptionsPicker.setValue(i);
          locala.setOnResultListener(new j.8(localj, locala, localAppBrandOptionsPicker));
          locala.show();
          AppMethodBeat.o(137603);
        }
      });
    }
    catch (Exception paramJSONObject)
    {
      ac.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[] { bs.m(paramJSONObject) });
      n("fail", null);
      AppMethodBeat.o(137611);
      return;
    }
    AppMethodBeat.o(137611);
  }
  
  final void T(final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137612);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    final int j = paramJSONObject.optInt("current", 0);
    if ((localJSONArray == null) || (localJSONArray.length() <= 0))
    {
      ac.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
      n("ok", null);
      N(new Runnable()
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
      N(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137605);
          j localj = j.this;
          String[] arrayOfString = paramJSONObject;
          int i = j;
          AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = (AppBrandOptionsPickerV3)localj.aK(AppBrandOptionsPickerV3.class);
          if (localAppBrandOptionsPickerV3 == null)
          {
            localj.n("fail cant init view", null);
            AppMethodBeat.o(137605);
            return;
          }
          a locala = localj.mJP;
          locala.post(new j.5(localj, locala));
          localAppBrandOptionsPickerV3.mKu = i;
          localAppBrandOptionsPickerV3.init();
          localAppBrandOptionsPickerV3.setOptionsArray(arrayOfString);
          locala.setOnResultListener(new j.6(localj, locala, localAppBrandOptionsPickerV3));
          locala.setHeader(localj.kHt);
          locala.show();
          AppMethodBeat.o(137605);
        }
      });
    }
    catch (Exception paramJSONObject)
    {
      ac.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[] { bs.m(paramJSONObject) });
      n("fail", null);
      AppMethodBeat.o(137612);
      return;
    }
    AppMethodBeat.o(137612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.j
 * JD-Core Version:    0.7.0.1
 */