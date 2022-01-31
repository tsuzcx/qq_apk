package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.luggage.c.a.a.c;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

final class f$b
  extends d
  implements Runnable
{
  private final AtomicReference<AppBrandMultiOptionsPicker.a[]> gzL = new AtomicReference();
  
  private f$b(f paramf) {}
  
  public final void run()
  {
    AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)N(AppBrandMultiOptionsPicker.class);
    if (localAppBrandMultiOptionsPicker == null)
    {
      j("fail cant init view", null);
      return;
    }
    AppBrandMultiOptionsPicker.a[] arrayOfa = (AppBrandMultiOptionsPicker.a[])this.gzL.get();
    if ((arrayOfa == null) || (arrayOfa.length <= 0))
    {
      j("fail error data", null);
      return;
    }
    if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
    for (;;)
    {
      this.hzI.setOnResultListener(new f.b.3(this));
      this.hzI.setOnValueUpdateListener(new f.b.4(this));
      this.hzI.show();
      return;
      int i = localAppBrandMultiOptionsPicker.getPickersCount();
      localAppBrandMultiOptionsPicker.setLayoutFrozen(true);
      Object localObject;
      if (i < arrayOfa.length)
      {
        i = arrayOfa.length - i;
        if (i > 0) {
          while (i > 0)
          {
            localObject = new AppBrandMultiOptionsPicker.2(localAppBrandMultiOptionsPicker, localAppBrandMultiOptionsPicker.getContext());
            ((c)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.hzY);
            ((c)localObject).setEllipsizeType("end");
            ((c)localObject).setDividerHeight(com.tencent.mm.cb.a.fromDPToPix(localAppBrandMultiOptionsPicker.getContext(), 1));
            ((c)localObject).setTag(a.c.app_brand_multi_options_picker_view_index_tag, Integer.valueOf(localAppBrandMultiOptionsPicker.hzV.getChildCount()));
            localAppBrandMultiOptionsPicker.hzV.addView((View)localObject, new LinearLayout.LayoutParams(0, -1, 1.0F));
            i -= 1;
          }
        }
      }
      else if (i > arrayOfa.length)
      {
        localAppBrandMultiOptionsPicker.nc(i - arrayOfa.length);
      }
      i = 0;
      while (i < arrayOfa.length)
      {
        localObject = localAppBrandMultiOptionsPicker.nb(i);
        AppBrandMultiOptionsPicker.a locala = arrayOfa[i];
        ((c)localObject).setOptionsArray(locala.hAa);
        ((c)localObject).setValue(locala.hAb);
        ((c)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.hzY);
        i += 1;
      }
      localAppBrandMultiOptionsPicker.hzV.setWeightSum(localAppBrandMultiOptionsPicker.getPickersCount());
      localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
    }
  }
  
  final void z(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
    paramJSONObject = paramJSONObject.optJSONArray("current");
    if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
    {
      j("fail:invalid data", null);
      return;
    }
    if (localJSONArray1.length() <= 0)
    {
      j("ok", null);
      y.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
      n.runOnUiThread(new f.b.1(this));
      return;
    }
    AppBrandMultiOptionsPicker.a[] arrayOfa;
    int i;
    int j;
    int k;
    try
    {
      arrayOfa = new AppBrandMultiOptionsPicker.a[localJSONArray1.length()];
      i = 0;
      j = 1;
      if (i < localJSONArray1.length())
      {
        JSONArray localJSONArray2 = localJSONArray1.getJSONArray(i);
        int m = paramJSONObject.getInt(i);
        String[] arrayOfString = new String[localJSONArray2.length()];
        k = 0;
        while (k < arrayOfString.length)
        {
          arrayOfString[k] = localJSONArray2.getString(k);
          k += 1;
        }
        arrayOfa[i] = new AppBrandMultiOptionsPicker.a(arrayOfString, m);
        if (localJSONArray2.length() > 0) {
          break label264;
        }
        k = 1;
        break label252;
      }
      if (j != 0)
      {
        j("ok", null);
        y.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
        n.runOnUiThread(new f.b.2(this));
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
      j("fail:invalid data", null);
      return;
    }
    this.gzL.set(arrayOfa);
    ai.d(this);
    return;
    for (;;)
    {
      label252:
      j &= k;
      i += 1;
      break;
      label264:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.f.b
 * JD-Core Version:    0.7.0.1
 */