package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends a
{
  private static final int CTRL_INDEX = 257;
  private static final String NAME = "showMultiPickerView";
  
  public final void b(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137590);
    if (this.lhh)
    {
      new c((byte)0).a(this, parame, paramJSONObject, paramInt, this.lhh);
      AppMethodBeat.o(137590);
      return;
    }
    new b((byte)0).a(this, parame, paramJSONObject, paramInt, this.lhh);
    AppMethodBeat.o(137590);
  }
  
  final class b
    extends e
    implements Runnable
  {
    private final AtomicReference<AppBrandMultiOptionsPicker.a[]> lhA;
    
    private b()
    {
      AppMethodBeat.i(197240);
      this.lhA = new AtomicReference();
      AppMethodBeat.o(197240);
    }
    
    final void T(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(197241);
      super.T(paramJSONObject);
      JSONArray localJSONArray1 = paramJSONObject.optJSONArray("array");
      paramJSONObject = paramJSONObject.optJSONArray("current");
      if ((localJSONArray1 == null) || (paramJSONObject == null) || (localJSONArray1.length() != paramJSONObject.length()))
      {
        q("fail:invalid data", null);
        AppMethodBeat.o(197241);
        return;
      }
      if (localJSONArray1.length() <= 0)
      {
        q("ok", null);
        ae.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        K(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197236);
            g.b.this.bmP();
            AppMethodBeat.o(197236);
          }
        });
        AppMethodBeat.o(197241);
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
          ae.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
          K(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197237);
              g.b.a(g.b.this);
              AppMethodBeat.o(197237);
            }
          });
          AppMethodBeat.o(197241);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ae.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
        q("fail:invalid data", null);
        AppMethodBeat.o(197241);
        return;
      }
      this.lhA.set(arrayOfa);
      K(this);
      AppMethodBeat.o(197241);
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
    
    final void U(JSONObject paramJSONObject) {}
    
    final void V(JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(197242);
      AppBrandMultiOptionsPicker localAppBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker)aK(AppBrandMultiOptionsPicker.class);
      if (localAppBrandMultiOptionsPicker == null)
      {
        q("fail cant init view", null);
        AppMethodBeat.o(197242);
        return;
      }
      AppBrandMultiOptionsPicker.a[] arrayOfa = (AppBrandMultiOptionsPicker.a[])this.lhA.get();
      if ((arrayOfa == null) || (arrayOfa.length <= 0))
      {
        q("fail error data", null);
        AppMethodBeat.o(197242);
        return;
      }
      if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
      for (;;)
      {
        this.npt.setOnResultListener(new c.a() {});
        this.npt.setOnValueUpdateListener(new c.b() {});
        this.npt.show();
        AppMethodBeat.o(197242);
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
              ((AppBrandOptionsPickerV2)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.npN);
              ((AppBrandOptionsPickerV2)localObject).setEllipsizeType("end");
              ((AppBrandOptionsPickerV2)localObject).setDividerHeight(com.tencent.mm.cb.a.fromDPToPix(localAppBrandMultiOptionsPicker.getContext(), 1));
              ((AppBrandOptionsPickerV2)localObject).setTag(2131296775, Integer.valueOf(localAppBrandMultiOptionsPicker.npK.getChildCount()));
              localAppBrandMultiOptionsPicker.npK.addView((View)localObject, new LinearLayout.LayoutParams(0, -1, 1.0F));
              i -= 1;
            }
          }
        }
        else if (i > arrayOfa.length)
        {
          localAppBrandMultiOptionsPicker.wM(i - arrayOfa.length);
        }
        i = 0;
        while (i < arrayOfa.length)
        {
          localObject = localAppBrandMultiOptionsPicker.wL(i);
          AppBrandMultiOptionsPicker.a locala = arrayOfa[i];
          ((AppBrandOptionsPickerV2)localObject).setOptionsArray(locala.npP);
          ((AppBrandOptionsPickerV2)localObject).setValue(locala.selected);
          ((AppBrandOptionsPickerV2)localObject).setOnValueChangedListener(localAppBrandMultiOptionsPicker.npN);
          i += 1;
        }
        localAppBrandMultiOptionsPicker.npK.setWeightSum(localAppBrandMultiOptionsPicker.getPickersCount());
        localAppBrandMultiOptionsPicker.setLayoutFrozen(false);
      }
    }
  }
  
  final class c
    extends e
    implements Runnable
  {
    private final AtomicReference<AppBrandMultiOptionsPickerV2.a[]> lhA;
    
    private c()
    {
      AppMethodBeat.i(137586);
      this.lhA = new AtomicReference();
      AppMethodBeat.o(137586);
    }
    
    final void T(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(137587);
      super.T(paramJSONObject);
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
        ae.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (one-dimensional)");
        K(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(137582);
            g.c.this.bmP();
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
          ae.i("MicroMsg.JsApiShowMultiPickerView", "showMultiPickerView , empty range (multi-dimensional)");
          K(new Runnable()
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
        ae.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", paramJSONObject, "opt params", new Object[0]);
        q("fail:invalid data", null);
        AppMethodBeat.o(137587);
        return;
      }
      this.lhA.set(arrayOfa);
      K(this);
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
    
    final void U(JSONObject paramJSONObject) {}
    
    final void V(JSONObject paramJSONObject) {}
    
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
      AppBrandMultiOptionsPickerV2.a[] arrayOfa = (AppBrandMultiOptionsPickerV2.a[])this.lhA.get();
      if ((arrayOfa == null) || (arrayOfa.length <= 0))
      {
        q("fail error data", null);
        AppMethodBeat.o(137588);
        return;
      }
      if ((arrayOfa == null) || (arrayOfa.length <= 0)) {}
      for (;;)
      {
        this.npt.setOnResultListener(new c.a() {});
        this.npt.setOnValueUpdateListener(new c.b() {});
        this.npt.setHeader(this.lhx);
        this.npt.show();
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
              localAppBrandOptionsPickerV3.npY = k;
              localAppBrandOptionsPickerV3.init();
              localAppBrandOptionsPickerV3.setDividerHeight(localAppBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(2131165923));
              localAppBrandMultiOptionsPickerV2.getContext().getResources().getDimensionPixelSize(2131166681);
              localAppBrandMultiOptionsPickerV2.npQ.add(localAppBrandOptionsPickerV3);
              localAppBrandMultiOptionsPickerV2.addView(localAppBrandOptionsPickerV3.npW.aQC(), new LinearLayout.LayoutParams(-1, -2, 1.0F));
              i += 1;
            }
            localAppBrandMultiOptionsPickerV2.bGb();
          }
        }
        for (;;)
        {
          i = 0;
          while (i < arrayOfa.length)
          {
            localAppBrandOptionsPickerV3 = localAppBrandMultiOptionsPickerV2.wN(i);
            Object localObject = arrayOfa[i];
            localAppBrandOptionsPickerV3.setOptionsArray(((AppBrandMultiOptionsPickerV2.a)localObject).npP);
            localAppBrandOptionsPickerV3.npY = ((AppBrandMultiOptionsPickerV2.a)localObject).selected;
            localObject = new AppBrandMultiOptionsPickerV2.1(localAppBrandMultiOptionsPickerV2, i);
            localAppBrandOptionsPickerV3.npW.a((com.tencent.mm.picker.d.b)localObject);
            i += 1;
          }
          if (i > arrayOfa.length) {
            localAppBrandMultiOptionsPickerV2.wM(i - arrayOfa.length);
          }
        }
        localAppBrandMultiOptionsPickerV2.setWeightSum(localAppBrandMultiOptionsPickerV2.getPickersCount());
        localAppBrandMultiOptionsPickerV2.setLayoutFrozen(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.g
 * JD-Core Version:    0.7.0.1
 */