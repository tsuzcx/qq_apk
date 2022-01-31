package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

final class i
  extends d
{
  final void H(final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126364);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    final int j = paramJSONObject.optInt("current", 0);
    if ((localJSONArray == null) || (localJSONArray.length() <= 0))
    {
      ab.i("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "showPickerView as selector, empty range");
      l("ok", null);
      m.runOnUiThread(new i.1(this));
      AppMethodBeat.o(126364);
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
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126361);
          i locali = i.this;
          String[] arrayOfString = paramJSONObject;
          int i = j;
          AppBrandOptionsPicker localAppBrandOptionsPicker = (AppBrandOptionsPicker)locali.ah(AppBrandOptionsPicker.class);
          if (localAppBrandOptionsPicker == null)
          {
            locali.l("fail cant init view", null);
            AppMethodBeat.o(126361);
            return;
          }
          a locala = locali.jrY;
          locala.post(new i.3(locali, locala));
          localAppBrandOptionsPicker.setOptionsArray(arrayOfString);
          localAppBrandOptionsPicker.setValue(i);
          locala.setOnResultListener(new i.4(locali, locala, localAppBrandOptionsPicker));
          locala.show();
          AppMethodBeat.o(126361);
        }
      });
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", new Object[] { bo.l(paramJSONObject) });
      l("fail", null);
      AppMethodBeat.o(126364);
      return;
    }
    AppMethodBeat.o(126364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.i
 * JD-Core Version:    0.7.0.1
 */