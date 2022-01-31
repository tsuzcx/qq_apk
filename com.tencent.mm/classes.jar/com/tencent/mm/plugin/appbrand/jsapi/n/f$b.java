package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

final class f$b
  extends d
  implements Runnable
{
  private final AtomicReference<AppBrandMultiOptionsPicker.a[]> hWM;
  
  private f$b(f paramf)
  {
    AppMethodBeat.i(126350);
    this.hWM = new AtomicReference();
    AppMethodBeat.o(126350);
  }
  
  final void H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126351);
    JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
    paramJSONObject = paramJSONObject.optJSONArray("current");
    if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
    {
      l("fail:invalid data", null);
      AppMethodBeat.o(126351);
      return;
    }
    if (localJSONArray1.length() <= 0)
    {
      l("ok", null);
      ab.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
      m.runOnUiThread(new f.b.1(this));
      AppMethodBeat.o(126351);
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
          break label294;
        }
        k = 1;
        break label282;
      }
      if (j != 0)
      {
        l("ok", null);
        ab.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
        m.runOnUiThread(new f.b.2(this));
        AppMethodBeat.o(126351);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
      l("fail:invalid data", null);
      AppMethodBeat.o(126351);
      return;
    }
    this.hWM.set(arrayOfa);
    al.d(this);
    AppMethodBeat.o(126351);
    return;
    for (;;)
    {
      label282:
      j &= k;
      i += 1;
      break;
      label294:
      k = 0;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(126352);
    AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)ah(AppBrandMultiOptionsPicker.class);
    if (localAppBrandMultiOptionsPicker == null)
    {
      l("fail cant init view", null);
      AppMethodBeat.o(126352);
      return;
    }
    AppBrandMultiOptionsPicker.a[] arrayOfa = (AppBrandMultiOptionsPicker.a[])this.hWM.get();
    if ((arrayOfa == null) || (arrayOfa.length <= 0))
    {
      l("fail error data", null);
      AppMethodBeat.o(126352);
      return;
    }
    if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
    for (;;)
    {
      this.jrY.setOnResultListener(new f.b.3(this));
      this.jrY.setOnValueUpdateListener(new f.b.4(this));
      this.jrY.show();
      AppMethodBeat.o(126352);
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
            ((c)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.jso);
            ((c)localObject).setEllipsizeType("end");
            ((c)localObject).setDividerHeight(com.tencent.mm.cb.a.fromDPToPix(localAppBrandMultiOptionsPicker.getContext(), 1));
            ((c)localObject).setTag(2131820564, Integer.valueOf(localAppBrandMultiOptionsPicker.jsl.getChildCount()));
            localAppBrandMultiOptionsPicker.jsl.addView((View)localObject, new LinearLayout.LayoutParams(0, -1, 1.0F));
            i -= 1;
          }
        }
      }
      else if (i > arrayOfa.length)
      {
        localAppBrandMultiOptionsPicker.qJ(i - arrayOfa.length);
      }
      i = 0;
      while (i < arrayOfa.length)
      {
        localObject = localAppBrandMultiOptionsPicker.qI(i);
        AppBrandMultiOptionsPicker.a locala = arrayOfa[i];
        ((c)localObject).setOptionsArray(locala.jsq);
        ((c)localObject).setValue(locala.selected);
        ((c)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.jso);
        i += 1;
      }
      localAppBrandMultiOptionsPicker.jsl.setWeightSum(localAppBrandMultiOptionsPicker.getPickersCount());
      localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.f.b
 * JD-Core Version:    0.7.0.1
 */