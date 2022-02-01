package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.luggage.b.a.a.c;
import com.tencent.luggage.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
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
  
  public final void b(com.tencent.mm.plugin.appbrand.jsapi.g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137590);
    if (bTV())
    {
      new c((byte)0).a(this, paramg, paramJSONObject, paramInt, bTV());
      AppMethodBeat.o(137590);
      return;
    }
    new b((byte)0).a(this, paramg, paramJSONObject, paramInt, bTV());
    AppMethodBeat.o(137590);
  }
  
  static final class a
    extends az
  {
    private static final int CTRL_INDEX = 259;
    private static final String NAME = "onMultiPickerViewChange";
  }
  
  final class b
    extends e
    implements Runnable
  {
    private final AtomicReference<AppBrandMultiOptionsPicker.a[]> ple;
    
    private b()
    {
      AppMethodBeat.i(205556);
      this.ple = new AtomicReference();
      AppMethodBeat.o(205556);
    }
    
    final void ag(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(205557);
      super.ag(paramJSONObject);
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
      paramJSONObject = paramJSONObject.optJSONArray("current");
      if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
      {
        aho("fail:invalid data");
        AppMethodBeat.o(205557);
        return;
      }
      if (localJSONArray1.length() <= 0)
      {
        aho("ok");
        Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205585);
            g.b.this.bTY();
            AppMethodBeat.o(205585);
          }
        });
        AppMethodBeat.o(205557);
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
          aho("ok");
          Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
          P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(206247);
              g.b.a(g.b.this);
              AppMethodBeat.o(206247);
            }
          });
          AppMethodBeat.o(205557);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
        aho("fail:invalid data");
        AppMethodBeat.o(205557);
        return;
      }
      this.ple.set(arrayOfa);
      P(this);
      AppMethodBeat.o(205557);
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
    
    final void ah(JSONObject paramJSONObject) {}
    
    final void ai(JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(205562);
      AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)aH(AppBrandMultiOptionsPicker.class);
      if (localAppBrandMultiOptionsPicker == null)
      {
        aho("fail cant init view");
        AppMethodBeat.o(205562);
        return;
      }
      AppBrandMultiOptionsPicker.a[] arrayOfa = (AppBrandMultiOptionsPicker.a[])this.ple.get();
      if ((arrayOfa == null) || (arrayOfa.length <= 0))
      {
        aho("fail error data");
        AppMethodBeat.o(205562);
        return;
      }
      if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
      for (;;)
      {
        cpG().setOnResultListener(new c.a() {});
        cpG().setOnValueUpdateListener(new c.b() {});
        cpG().show();
        AppMethodBeat.o(205562);
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
              ((AppBrandOptionsPickerV2)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.rCb);
              ((AppBrandOptionsPickerV2)localObject).setEllipsizeType("end");
              ((AppBrandOptionsPickerV2)localObject).setDividerHeight(com.tencent.mm.ci.a.fromDPToPix(localAppBrandMultiOptionsPicker.getContext(), 1));
              ((AppBrandOptionsPickerV2)localObject).setTag(a.e.app_brand_multi_options_picker_view_index_tag, Integer.valueOf(localAppBrandMultiOptionsPicker.rBY.getChildCount()));
              localAppBrandMultiOptionsPicker.rBY.addView((View)localObject, new LinearLayout.LayoutParams(0, -1, 1.0F));
              i -= 1;
            }
          }
        }
        else if (i > arrayOfa.length)
        {
          localAppBrandMultiOptionsPicker.Eb(i - arrayOfa.length);
        }
        i = 0;
        while (i < arrayOfa.length)
        {
          localObject = localAppBrandMultiOptionsPicker.Ea(i);
          AppBrandMultiOptionsPicker.a locala = arrayOfa[i];
          ((AppBrandOptionsPickerV2)localObject).setOptionsArray(locala.rCd);
          ((AppBrandOptionsPickerV2)localObject).setValue(locala.selected);
          ((AppBrandOptionsPickerV2)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.rCb);
          i += 1;
        }
        localAppBrandMultiOptionsPicker.rBY.setWeightSum(localAppBrandMultiOptionsPicker.getPickersCount());
        localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
      }
    }
  }
  
  final class c
    extends e
    implements Runnable
  {
    private final AtomicReference<AppBrandMultiOptionsPickerV2.a[]> ple;
    
    private c()
    {
      AppMethodBeat.i(137586);
      this.ple = new AtomicReference();
      AppMethodBeat.o(137586);
    }
    
    final void ag(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(137587);
      super.ag(paramJSONObject);
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
      paramJSONObject = paramJSONObject.optJSONArray("current");
      if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
      {
        aho("fail:invalid data");
        AppMethodBeat.o(137587);
        return;
      }
      if (localJSONArray1.length() <= 0)
      {
        aho("ok");
        Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137582);
            g.c.this.bTY();
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
          aho("ok");
          Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
          P(new Runnable()
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
        aho("fail:invalid data");
        AppMethodBeat.o(137587);
        return;
      }
      this.ple.set(arrayOfa);
      P(this);
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
    
    final void ah(JSONObject paramJSONObject) {}
    
    final void ai(JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(137588);
      AppBrandMultiOptionsPickerV2 localAppBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2)aH(AppBrandMultiOptionsPickerV2.class);
      if (localAppBrandMultiOptionsPickerV2 == null)
      {
        aho("fail cant init view");
        AppMethodBeat.o(137588);
        return;
      }
      AppBrandMultiOptionsPickerV2.a[] arrayOfa = (AppBrandMultiOptionsPickerV2.a[])this.ple.get();
      if ((arrayOfa == null) || (arrayOfa.length <= 0))
      {
        aho("fail error data");
        AppMethodBeat.o(137588);
        return;
      }
      if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
      for (;;)
      {
        cpG().setOnResultListener(new c.a() {});
        cpG().setOnValueUpdateListener(new c.b() {});
        cpG().setHeader(this.plb);
        cpG().show();
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
              localAppBrandOptionsPickerV3.rCm = k;
              localAppBrandOptionsPickerV3.init();
              localAppBrandOptionsPickerV3.setDividerHeight(localAppBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(a.c.bottomsheet_dividing_line_height));
              localAppBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(a.c.picker_item_height);
              localAppBrandMultiOptionsPickerV2.rCe.add(localAppBrandOptionsPickerV3);
              localAppBrandMultiOptionsPickerV2.addView(localAppBrandOptionsPickerV3.rCk.buW(), new LinearLayout.LayoutParams(-1, -2, 1.0F));
              i += 1;
            }
            localAppBrandMultiOptionsPickerV2.cpI();
          }
        }
        for (;;)
        {
          i = 0;
          while (i < arrayOfa.length)
          {
            localAppBrandOptionsPickerV3 = localAppBrandMultiOptionsPickerV2.Ec(i);
            Object localObject = arrayOfa[i];
            localAppBrandOptionsPickerV3.setOptionsArray(((AppBrandMultiOptionsPickerV2.a)localObject).rCd);
            localAppBrandOptionsPickerV3.rCm = ((AppBrandMultiOptionsPickerV2.a)localObject).selected;
            localObject = new AppBrandMultiOptionsPickerV2.1(localAppBrandMultiOptionsPickerV2, i);
            localAppBrandOptionsPickerV3.rCk.setOnValueChangedListener((com.tencent.mm.picker.d.b)localObject);
            i += 1;
          }
          if (i > arrayOfa.length) {
            localAppBrandMultiOptionsPickerV2.Eb(i - arrayOfa.length);
          }
        }
        localAppBrandMultiOptionsPickerV2.setWeightSum(localAppBrandMultiOptionsPickerV2.getPickersCount());
        localAppBrandMultiOptionsPickerV2.setLayoutFrozen(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.g
 * JD-Core Version:    0.7.0.1
 */