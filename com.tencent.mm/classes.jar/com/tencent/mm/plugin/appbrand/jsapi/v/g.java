package com.tencent.mm.plugin.appbrand.jsapi.v;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.luggage.b.a.a.c;
import com.tencent.luggage.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.picker.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.1;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV2;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPickerV3;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends a
{
  private static final int CTRL_INDEX = 257;
  private static final String NAME = "showMultiPickerView";
  
  public final void b(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137590);
    if (cui())
    {
      new c((byte)0).a(this, paramh, paramJSONObject, paramInt, cui());
      AppMethodBeat.o(137590);
      return;
    }
    new b((byte)0).a(this, paramh, paramJSONObject, paramInt, cui());
    AppMethodBeat.o(137590);
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 259;
    private static final String NAME = "onMultiPickerViewChange";
  }
  
  final class b
    extends e
    implements Runnable
  {
    private final AtomicReference<AppBrandMultiOptionsPicker.a[]> sqf;
    
    private b()
    {
      AppMethodBeat.i(328012);
      this.sqf = new AtomicReference();
      AppMethodBeat.o(328012);
    }
    
    final void aq(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(328025);
      super.aq(paramJSONObject);
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
      paramJSONObject = paramJSONObject.optJSONArray("current");
      if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
      {
        aal("fail:invalid data");
        AppMethodBeat.o(328025);
        return;
      }
      if (localJSONArray1.length() <= 0)
      {
        aal("ok");
        Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        V(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(327994);
            g.b.this.cul();
            AppMethodBeat.o(327994);
          }
        });
        AppMethodBeat.o(328025);
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
          arrayOfa[i] = g.b(localJSONArray2, paramJSONObject.getInt(i));
          if (localJSONArray2.length() > 0) {
            break label248;
          }
          k = 1;
          break label236;
        }
        if (j != 0)
        {
          aal("ok");
          Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
          V(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(327993);
              g.b.a(g.b.this);
              AppMethodBeat.o(327993);
            }
          });
          AppMethodBeat.o(328025);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
        aal("fail:invalid data");
        AppMethodBeat.o(328025);
        return;
      }
      this.sqf.set(arrayOfa);
      V(this);
      AppMethodBeat.o(328025);
      return;
      for (;;)
      {
        label236:
        j &= k;
        i += 1;
        break;
        label248:
        k = 0;
      }
    }
    
    final void ar(JSONObject paramJSONObject) {}
    
    final void as(JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(328032);
      AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)bb(AppBrandMultiOptionsPicker.class);
      if (localAppBrandMultiOptionsPicker == null)
      {
        aal("fail cant init view");
        AppMethodBeat.o(328032);
        return;
      }
      AppBrandMultiOptionsPicker.a[] arrayOfa = (AppBrandMultiOptionsPicker.a[])this.sqf.get();
      if ((arrayOfa == null) || (arrayOfa.length <= 0))
      {
        aal("fail error data");
        AppMethodBeat.o(328032);
        return;
      }
      if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
      for (;;)
      {
        cSl().setOnResultListener(new c.a() {});
        cSl().setOnValueUpdateListener(new c.b() {});
        cSl().show();
        AppMethodBeat.o(328032);
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
              ((AppBrandOptionsPickerV2)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.uNq);
              ((AppBrandOptionsPickerV2)localObject).setEllipsizeType("end");
              ((AppBrandOptionsPickerV2)localObject).setDividerHeight(com.tencent.mm.cd.a.fromDPToPix(localAppBrandMultiOptionsPicker.getContext(), 1));
              ((AppBrandOptionsPickerV2)localObject).setTag(a.e.app_brand_multi_options_picker_view_index_tag, Integer.valueOf(localAppBrandMultiOptionsPicker.uNn.getChildCount()));
              localAppBrandMultiOptionsPicker.uNn.addView((View)localObject, new LinearLayout.LayoutParams(0, -1, 1.0F));
              i -= 1;
            }
          }
        }
        else if (i > arrayOfa.length)
        {
          localAppBrandMultiOptionsPicker.EB(i - arrayOfa.length);
        }
        i = 0;
        while (i < arrayOfa.length)
        {
          localObject = localAppBrandMultiOptionsPicker.EA(i);
          AppBrandMultiOptionsPicker.a locala = arrayOfa[i];
          ((AppBrandOptionsPickerV2)localObject).setOptionsArray(locala.uNs);
          ((AppBrandOptionsPickerV2)localObject).setValue(locala.selected);
          ((AppBrandOptionsPickerV2)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.uNq);
          i += 1;
        }
        localAppBrandMultiOptionsPicker.uNn.setWeightSum(localAppBrandMultiOptionsPicker.getPickersCount());
        localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
      }
    }
  }
  
  final class c
    extends e
    implements Runnable
  {
    private final AtomicReference<AppBrandMultiOptionsPickerV2.a[]> sqf;
    
    private c()
    {
      AppMethodBeat.i(137586);
      this.sqf = new AtomicReference();
      AppMethodBeat.o(137586);
    }
    
    final void aq(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(137587);
      super.aq(paramJSONObject);
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
      paramJSONObject = paramJSONObject.optJSONArray("current");
      if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
      {
        aal("fail:invalid data");
        AppMethodBeat.o(137587);
        return;
      }
      if (localJSONArray1.length() <= 0)
      {
        aal("ok");
        Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        V(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137582);
            g.c.this.cul();
            AppMethodBeat.o(137582);
          }
        });
        AppMethodBeat.o(137587);
        return;
      }
      AppBrandMultiOptionsPickerV2.a[] arrayOfa;
      int i;
      int j;
      int k;
      try
      {
        arrayOfa = new AppBrandMultiOptionsPickerV2.a[localJSONArray1.length()];
        i = 0;
        j = 1;
        if (i < localJSONArray1.length())
        {
          JSONArray localJSONArray2 = localJSONArray1.getJSONArray(i);
          arrayOfa[i] = g.a(localJSONArray2, paramJSONObject.getInt(i));
          if (localJSONArray2.length() > 0) {
            break label248;
          }
          k = 1;
          break label236;
        }
        if (j != 0)
        {
          aal("ok");
          Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
          V(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(137583);
              g.c.a(g.c.this);
              AppMethodBeat.o(137583);
            }
          });
          AppMethodBeat.o(137587);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
        aal("fail:invalid data");
        AppMethodBeat.o(137587);
        return;
      }
      this.sqf.set(arrayOfa);
      V(this);
      AppMethodBeat.o(137587);
      return;
      for (;;)
      {
        label236:
        j &= k;
        i += 1;
        break;
        label248:
        k = 0;
      }
    }
    
    final void ar(JSONObject paramJSONObject) {}
    
    final void as(JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(137588);
      AppBrandMultiOptionsPickerV2 localAppBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2)bb(AppBrandMultiOptionsPickerV2.class);
      if (localAppBrandMultiOptionsPickerV2 == null)
      {
        aal("fail cant init view");
        AppMethodBeat.o(137588);
        return;
      }
      AppBrandMultiOptionsPickerV2.a[] arrayOfa = (AppBrandMultiOptionsPickerV2.a[])this.sqf.get();
      if ((arrayOfa == null) || (arrayOfa.length <= 0))
      {
        aal("fail error data");
        AppMethodBeat.o(137588);
        return;
      }
      if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
      for (;;)
      {
        cSl().setOnResultListener(new c.a() {});
        cSl().setOnValueUpdateListener(new c.b() {});
        cSl().setHeader(this.sqc);
        cSl().show();
        AppMethodBeat.o(137588);
        return;
        int i = localAppBrandMultiOptionsPickerV2.getPickersCount();
        localAppBrandMultiOptionsPickerV2.setLayoutFrozen(true);
        AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3;
        if (i < arrayOfa.length)
        {
          int j = arrayOfa.length - i;
          if (j > 0)
          {
            i = 0;
            while (i < j)
            {
              int k = arrayOfa[i].selected;
              localAppBrandOptionsPickerV3 = new AppBrandOptionsPickerV3(localAppBrandMultiOptionsPickerV2.getContext());
              localAppBrandOptionsPickerV3.uNB = k;
              localAppBrandOptionsPickerV3.init();
              localAppBrandOptionsPickerV3.setDividerHeight(localAppBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(a.c.bottomsheet_dividing_line_height));
              localAppBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(a.c.picker_item_height);
              localAppBrandMultiOptionsPickerV2.uNt.add(localAppBrandOptionsPickerV3);
              localAppBrandMultiOptionsPickerV2.addView(localAppBrandOptionsPickerV3.uNz.bTf(), new LinearLayout.LayoutParams(-1, -2, 1.0F));
              i += 1;
            }
            localAppBrandMultiOptionsPickerV2.cSn();
          }
        }
        for (;;)
        {
          i = 0;
          while (i < arrayOfa.length)
          {
            localAppBrandOptionsPickerV3 = localAppBrandMultiOptionsPickerV2.EC(i);
            Object localObject = arrayOfa[i];
            localAppBrandOptionsPickerV3.setOptionsArray(((AppBrandMultiOptionsPickerV2.a)localObject).uNs);
            localAppBrandOptionsPickerV3.uNB = ((AppBrandMultiOptionsPickerV2.a)localObject).selected;
            localObject = new AppBrandMultiOptionsPickerV2.1(localAppBrandMultiOptionsPickerV2, i);
            localAppBrandOptionsPickerV3.uNz.setOnValueChangedListener((c)localObject);
            i += 1;
          }
          if (i > arrayOfa.length) {
            localAppBrandMultiOptionsPickerV2.EB(i - arrayOfa.length);
          }
        }
        localAppBrandMultiOptionsPickerV2.setWeightSum(localAppBrandMultiOptionsPickerV2.getPickersCount());
        localAppBrandMultiOptionsPickerV2.setLayoutFrozen(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.g
 * JD-Core Version:    0.7.0.1
 */