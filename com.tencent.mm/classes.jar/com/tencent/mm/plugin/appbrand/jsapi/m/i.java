package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.f.b;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends a
{
  private static final int CTRL_INDEX = 258;
  private static final String NAME = "updateMultiPickerView";
  
  public final void b(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137600);
    new e()
    {
      final void R(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(137597);
        super.R(paramAnonymousJSONObject);
        AppMethodBeat.o(137597);
      }
      
      final void S(final JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(137598);
        final int j = paramAnonymousJSONObject.optInt("column", -1);
        JSONArray localJSONArray = paramAnonymousJSONObject.optJSONArray("array");
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
          paramAnonymousJSONObject = new AppBrandMultiOptionsPicker.a(arrayOfString, paramAnonymousJSONObject.optInt("current", 0));
          N(new Runnable()
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
              AppBrandMultiOptionsPicker.a locala = paramAnonymousJSONObject;
              if ((i >= 0) && (i < localAppBrandMultiOptionsPicker.getPickersCount()) && (locala != null))
              {
                localAppBrandMultiOptionsPicker.setLayoutFrozen(true);
                localAppBrandMultiOptionsPicker.wb(i).setOptionsArray(locala.mKl);
                if (!bs.T(locala.mKl)) {
                  localAppBrandMultiOptionsPicker.wb(i).setValue(locala.selected);
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
        catch (Exception paramAnonymousJSONObject)
        {
          ac.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramAnonymousJSONObject, "opt params", new Object[0]);
          n("fail:invalid data", null);
          AppMethodBeat.o(137598);
        }
      }
      
      final void T(final JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(137599);
        final int j = paramAnonymousJSONObject.optInt("column", -1);
        JSONArray localJSONArray = paramAnonymousJSONObject.optJSONArray("array");
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
          paramAnonymousJSONObject = new AppBrandMultiOptionsPickerV2.a(arrayOfString, paramAnonymousJSONObject.optInt("current", 0));
          N(new Runnable()
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
              AppBrandMultiOptionsPickerV2.a locala = paramAnonymousJSONObject;
              if ((i >= 0) && (i < localAppBrandMultiOptionsPickerV2.getPickersCount()) && (locala != null))
              {
                localAppBrandMultiOptionsPickerV2.setLayoutFrozen(true);
                localAppBrandMultiOptionsPickerV2.wd(i).setOptionsArray(locala.mKl);
                if (!bs.T(locala.mKl))
                {
                  AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = localAppBrandMultiOptionsPickerV2.wd(i);
                  i = locala.selected;
                  localAppBrandOptionsPickerV3.mKs.aMS().setCurrentItem(i);
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
        catch (Exception paramAnonymousJSONObject)
        {
          ac.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramAnonymousJSONObject, "opt params", new Object[0]);
          n("fail:invalid data", null);
          AppMethodBeat.o(137599);
        }
      }
    }.a(this, parame, paramJSONObject, paramInt, this.kHd);
    AppMethodBeat.o(137600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.i
 * JD-Core Version:    0.7.0.1
 */