package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends a
{
  private static final int CTRL_INDEX = 258;
  private static final String NAME = "updateMultiPickerView";
  
  public final void b(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137600);
    new e()
    {
      final void ag(JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(137597);
        super.ag(paramAnonymousJSONObject);
        AppMethodBeat.o(137597);
      }
      
      final void ah(final JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(137598);
        final int j = paramAnonymousJSONObject.optInt("column", -1);
        JSONArray localJSONArray = paramAnonymousJSONObject.optJSONArray("array");
        if ((j < 0) || (localJSONArray == null) || (localJSONArray.length() < 0))
        {
          aho("fail:invalid data");
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
          P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(137595);
              AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)i.1.a(i.1.this, AppBrandMultiOptionsPicker.class);
              if (localAppBrandMultiOptionsPicker == null)
              {
                i.1.this.p("fail picker not exists", null);
                AppMethodBeat.o(137595);
                return;
              }
              int i = j;
              AppBrandMultiOptionsPicker.a locala = paramAnonymousJSONObject;
              if ((i >= 0) && (i < localAppBrandMultiOptionsPicker.getPickersCount()) && (locala != null))
              {
                localAppBrandMultiOptionsPicker.setLayoutFrozen(true);
                localAppBrandMultiOptionsPicker.Ea(i).setOptionsArray(locala.rCd);
                if (!Util.isNullOrNil(locala.rCd)) {
                  localAppBrandMultiOptionsPicker.Ea(i).setValue(locala.selected);
                }
                localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
              }
              i.1.this.p("ok", null);
              AppMethodBeat.o(137595);
            }
          });
          AppMethodBeat.o(137598);
          return;
        }
        catch (Exception paramAnonymousJSONObject)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramAnonymousJSONObject, "opt params", new Object[0]);
          aho("fail:invalid data");
          AppMethodBeat.o(137598);
        }
      }
      
      final void ai(final JSONObject paramAnonymousJSONObject)
      {
        AppMethodBeat.i(137599);
        final int j = paramAnonymousJSONObject.optInt("column", -1);
        JSONArray localJSONArray = paramAnonymousJSONObject.optJSONArray("array");
        if ((j < 0) || (localJSONArray == null) || (localJSONArray.length() < 0))
        {
          aho("fail:invalid data");
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
          P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(137596);
              AppBrandMultiOptionsPickerV2 localAppBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2)i.1.b(i.1.this, AppBrandMultiOptionsPickerV2.class);
              if (localAppBrandMultiOptionsPickerV2 == null)
              {
                i.1.this.p("fail picker not exists", null);
                AppMethodBeat.o(137596);
                return;
              }
              int i = j;
              AppBrandMultiOptionsPickerV2.a locala = paramAnonymousJSONObject;
              if ((i >= 0) && (i < localAppBrandMultiOptionsPickerV2.getPickersCount()) && (locala != null))
              {
                localAppBrandMultiOptionsPickerV2.setLayoutFrozen(true);
                localAppBrandMultiOptionsPickerV2.Ec(i).setOptionsArray(locala.rCd);
                if (!Util.isNullOrNil(locala.rCd))
                {
                  AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = localAppBrandMultiOptionsPickerV2.Ec(i);
                  i = locala.selected;
                  localAppBrandOptionsPickerV3.rCk.buW().setCurrentItem(i);
                }
                localAppBrandMultiOptionsPickerV2.setLayoutFrozen(false);
              }
              i.1.this.p("ok", null);
              AppMethodBeat.o(137596);
            }
          });
          AppMethodBeat.o(137599);
          return;
        }
        catch (Exception paramAnonymousJSONObject)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", paramAnonymousJSONObject, "opt params", new Object[0]);
          aho("fail:invalid data");
          AppMethodBeat.o(137599);
        }
      }
    }.a(this, paramg, paramJSONObject, paramInt, bTV());
    AppMethodBeat.o(137600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.i
 * JD-Core Version:    0.7.0.1
 */