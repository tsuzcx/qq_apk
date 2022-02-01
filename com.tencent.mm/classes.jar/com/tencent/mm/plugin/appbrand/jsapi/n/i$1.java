package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.f.b;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONObject;

final class i$1
  extends e
{
  i$1(i parami) {}
  
  final void R(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137597);
    super.R(paramJSONObject);
    AppMethodBeat.o(137597);
  }
  
  final void S(final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137598);
    final int j = paramJSONObject.optInt("column", -1);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    if ((j < 0) || (localJSONArray == null) || (localJSONArray.length() < 0))
    {
      n("fail:invalid data", null);
      AppMethodBeat.o(137598);
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
      L(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137595);
          AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)i.1.this.aL(AppBrandMultiOptionsPicker.class);
          if (localAppBrandMultiOptionsPicker == null)
          {
            i.1.this.n("fail picker not exists", null);
            AppMethodBeat.o(137595);
            return;
          }
          int i = j;
          AppBrandMultiOptionsPicker.a locala = paramJSONObject;
          if ((i >= 0) && (i < localAppBrandMultiOptionsPicker.getPickersCount()) && (locala != null))
          {
            localAppBrandMultiOptionsPicker.setLayoutFrozen(true);
            localAppBrandMultiOptionsPicker.vk(i).setOptionsArray(locala.mik);
            if (!bt.T(locala.mik)) {
              localAppBrandMultiOptionsPicker.vk(i).setValue(locala.selected);
            }
            localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
          }
          i.1.this.n("ok", null);
          AppMethodBeat.o(137595);
        }
      });
      AppMethodBeat.o(137598);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramJSONObject, "opt params", new Object[0]);
      n("fail:invalid data", null);
      AppMethodBeat.o(137598);
    }
  }
  
  final void T(final JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137599);
    final int j = paramJSONObject.optInt("column", -1);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("array");
    if ((j < 0) || (localJSONArray == null) || (localJSONArray.length() < 0))
    {
      n("fail:invalid data", null);
      AppMethodBeat.o(137599);
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
      paramJSONObject = new AppBrandMultiOptionsPickerV2.a(arrayOfString, paramJSONObject.optInt("current", 0));
      L(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(137596);
          AppBrandMultiOptionsPickerV2 localAppBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2)i.1.this.aL(AppBrandMultiOptionsPickerV2.class);
          if (localAppBrandMultiOptionsPickerV2 == null)
          {
            i.1.this.n("fail picker not exists", null);
            AppMethodBeat.o(137596);
            return;
          }
          int i = j;
          AppBrandMultiOptionsPickerV2.a locala = paramJSONObject;
          if ((i >= 0) && (i < localAppBrandMultiOptionsPickerV2.getPickersCount()) && (locala != null))
          {
            localAppBrandMultiOptionsPickerV2.setLayoutFrozen(true);
            localAppBrandMultiOptionsPickerV2.vm(i).setOptionsArray(locala.mik);
            if (!bt.T(locala.mik))
            {
              AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = localAppBrandMultiOptionsPickerV2.vm(i);
              i = locala.selected;
              localAppBrandOptionsPickerV3.mis.aGf().setCurrentItem(i);
            }
            localAppBrandMultiOptionsPickerV2.setLayoutFrozen(false);
          }
          i.1.this.n("ok", null);
          AppMethodBeat.o(137596);
        }
      });
      AppMethodBeat.o(137599);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramJSONObject, "opt params", new Object[0]);
      n("fail:invalid data", null);
      AppMethodBeat.o(137599);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.i.1
 * JD-Core Version:    0.7.0.1
 */