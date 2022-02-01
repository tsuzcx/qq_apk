package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    if (this.mmD)
    {
      new c((byte)0).a(this, paramh, paramJSONObject, paramInt, this.mmD);
      AppMethodBeat.o(137590);
      return;
    }
    new b((byte)0).a(this, paramh, paramJSONObject, paramInt, this.mmD);
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
    private final AtomicReference<AppBrandMultiOptionsPicker.a[]> mmX;
    
    private b()
    {
      AppMethodBeat.i(193684);
      this.mmX = new AtomicReference();
      AppMethodBeat.o(193684);
    }
    
    final void ac(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(193685);
      super.ac(paramJSONObject);
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
      paramJSONObject = paramJSONObject.optJSONArray("current");
      if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
      {
        q("fail:invalid data", null);
        AppMethodBeat.o(193685);
        return;
      }
      if (localJSONArray1.length() <= 0)
      {
        q("ok", null);
        Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193680);
            g.b.this.bIo();
            AppMethodBeat.o(193680);
          }
        });
        AppMethodBeat.o(193685);
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
            break label252;
          }
          k = 1;
          break label240;
        }
        if (j != 0)
        {
          q("ok", null);
          Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
          P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193681);
              g.b.a(g.b.this);
              AppMethodBeat.o(193681);
            }
          });
          AppMethodBeat.o(193685);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
        q("fail:invalid data", null);
        AppMethodBeat.o(193685);
        return;
      }
      this.mmX.set(arrayOfa);
      P(this);
      AppMethodBeat.o(193685);
      return;
      for (;;)
      {
        label240:
        j &= k;
        i += 1;
        break;
        label252:
        k = 0;
      }
    }
    
    final void ad(JSONObject paramJSONObject) {}
    
    final void ae(JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(193686);
      AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)aK(AppBrandMultiOptionsPicker.class);
      if (localAppBrandMultiOptionsPicker == null)
      {
        q("fail cant init view", null);
        AppMethodBeat.o(193686);
        return;
      }
      AppBrandMultiOptionsPicker.a[] arrayOfa = (AppBrandMultiOptionsPicker.a[])this.mmX.get();
      if ((arrayOfa == null) || (arrayOfa.length <= 0))
      {
        q("fail error data", null);
        AppMethodBeat.o(193686);
        return;
      }
      if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
      for (;;)
      {
        this.oza.setOnResultListener(new c.a() {});
        this.oza.setOnValueUpdateListener(new c.b() {});
        this.oza.show();
        AppMethodBeat.o(193686);
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
              ((AppBrandOptionsPickerV2)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.ozu);
              ((AppBrandOptionsPickerV2)localObject).setEllipsizeType("end");
              ((AppBrandOptionsPickerV2)localObject).setDividerHeight(com.tencent.mm.cb.a.fromDPToPix(localAppBrandMultiOptionsPicker.getContext(), 1));
              ((AppBrandOptionsPickerV2)localObject).setTag(2131296857, Integer.valueOf(localAppBrandMultiOptionsPicker.ozr.getChildCount()));
              localAppBrandMultiOptionsPicker.ozr.addView((View)localObject, new LinearLayout.LayoutParams(0, -1, 1.0F));
              i -= 1;
            }
          }
        }
        else if (i > arrayOfa.length)
        {
          localAppBrandMultiOptionsPicker.Au(i - arrayOfa.length);
        }
        i = 0;
        while (i < arrayOfa.length)
        {
          localObject = localAppBrandMultiOptionsPicker.At(i);
          AppBrandMultiOptionsPicker.a locala = arrayOfa[i];
          ((AppBrandOptionsPickerV2)localObject).setOptionsArray(locala.ozw);
          ((AppBrandOptionsPickerV2)localObject).setValue(locala.selected);
          ((AppBrandOptionsPickerV2)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.ozu);
          i += 1;
        }
        localAppBrandMultiOptionsPicker.ozr.setWeightSum(localAppBrandMultiOptionsPicker.getPickersCount());
        localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
      }
    }
  }
  
  final class c
    extends e
    implements Runnable
  {
    private final AtomicReference<AppBrandMultiOptionsPickerV2.a[]> mmX;
    
    private c()
    {
      AppMethodBeat.i(137586);
      this.mmX = new AtomicReference();
      AppMethodBeat.o(137586);
    }
    
    final void ac(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(137587);
      super.ac(paramJSONObject);
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
      paramJSONObject = paramJSONObject.optJSONArray("current");
      if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
      {
        q("fail:invalid data", null);
        AppMethodBeat.o(137587);
        return;
      }
      if (localJSONArray1.length() <= 0)
      {
        q("ok", null);
        Log.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        P(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137582);
            g.c.this.bIo();
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
            break label252;
          }
          k = 1;
          break label240;
        }
        if (j != 0)
        {
          q("ok", null);
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
        q("fail:invalid data", null);
        AppMethodBeat.o(137587);
        return;
      }
      this.mmX.set(arrayOfa);
      P(this);
      AppMethodBeat.o(137587);
      return;
      for (;;)
      {
        label240:
        j &= k;
        i += 1;
        break;
        label252:
        k = 0;
      }
    }
    
    final void ad(JSONObject paramJSONObject) {}
    
    final void ae(JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(137588);
      AppBrandMultiOptionsPickerV2 localAppBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2)aK(AppBrandMultiOptionsPickerV2.class);
      if (localAppBrandMultiOptionsPickerV2 == null)
      {
        q("fail cant init view", null);
        AppMethodBeat.o(137588);
        return;
      }
      AppBrandMultiOptionsPickerV2.a[] arrayOfa = (AppBrandMultiOptionsPickerV2.a[])this.mmX.get();
      if ((arrayOfa == null) || (arrayOfa.length <= 0))
      {
        q("fail error data", null);
        AppMethodBeat.o(137588);
        return;
      }
      if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
      for (;;)
      {
        this.oza.setOnResultListener(new c.a() {});
        this.oza.setOnValueUpdateListener(new c.b() {});
        this.oza.setHeader(this.mmU);
        this.oza.show();
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
              localAppBrandOptionsPickerV3.ozF = k;
              localAppBrandOptionsPickerV3.init();
              localAppBrandOptionsPickerV3.setDividerHeight(localAppBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(2131165950));
              localAppBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(2131166801);
              localAppBrandMultiOptionsPickerV2.ozx.add(localAppBrandOptionsPickerV3);
              localAppBrandMultiOptionsPickerV2.addView(localAppBrandOptionsPickerV3.ozD.blh(), new LinearLayout.LayoutParams(-1, -2, 1.0F));
              i += 1;
            }
            localAppBrandMultiOptionsPickerV2.ccr();
          }
        }
        for (;;)
        {
          i = 0;
          while (i < arrayOfa.length)
          {
            localAppBrandOptionsPickerV3 = localAppBrandMultiOptionsPickerV2.Av(i);
            Object localObject = arrayOfa[i];
            localAppBrandOptionsPickerV3.setOptionsArray(((AppBrandMultiOptionsPickerV2.a)localObject).ozw);
            localAppBrandOptionsPickerV3.ozF = ((AppBrandMultiOptionsPickerV2.a)localObject).selected;
            localObject = new AppBrandMultiOptionsPickerV2.1(localAppBrandMultiOptionsPickerV2, i);
            localAppBrandOptionsPickerV3.ozD.a((com.tencent.mm.picker.d.b)localObject);
            i += 1;
          }
          if (i > arrayOfa.length) {
            localAppBrandMultiOptionsPickerV2.Au(i - arrayOfa.length);
          }
        }
        localAppBrandMultiOptionsPickerV2.setWeightSum(localAppBrandMultiOptionsPickerV2.getPickersCount());
        localAppBrandMultiOptionsPickerV2.setLayoutFrozen(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.g
 * JD-Core Version:    0.7.0.1
 */