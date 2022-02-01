package com.tencent.mm.plugin.appbrand;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.e;

 enum bh
{
  private static final int qyy;
  
  static
  {
    AppMethodBeat.i(316598);
    qyr = new bh("AppBrandPageContainer", 0);
    qys = new bh("PipContainer", 1);
    qyt = new bh("LegacyDialogContainer", 2);
    qyu = new bh("GlobalNativeWidgetContainerView", 3);
    qyv = new bh("RemoteDebugFloatView", 4);
    qyw = new bh("AuthorizeDialogContainer", 5);
    qyx = new bh("LoadingSplash", 6);
    qyz = new bh[] { qyr, qys, qyt, qyu, qyv, qyw, qyx };
    qyy = a.d.app_brand_runtime_root_child_index_tag;
    AppMethodBeat.o(316598);
  }
  
  private bh() {}
  
  private int K(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(316592);
    paramAppBrandRuntime = paramAppBrandRuntime.qsk;
    if (paramAppBrandRuntime.getChildCount() == 0)
    {
      AppMethodBeat.o(316592);
      return 0;
    }
    int j = paramAppBrandRuntime.getChildCount() - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = ((Integer)paramAppBrandRuntime.getChildAt(k).getTag(qyy)).intValue();
      if (m < ordinal())
      {
        i = k + 1;
      }
      else if (m > ordinal())
      {
        j = k - 1;
      }
      else
      {
        AppMethodBeat.o(316592);
        return k;
      }
    }
    i ^= 0xFFFFFFFF;
    if (i >= 0)
    {
      AppMethodBeat.o(316592);
      return i;
    }
    AppMethodBeat.o(316592);
    return i ^ 0xFFFFFFFF;
  }
  
  final void a(AppBrandRuntime paramAppBrandRuntime, View paramView)
  {
    AppMethodBeat.i(316606);
    Object localObject = (Integer)paramView.getTag(qyy);
    if ((localObject != null) && (ordinal() != ((Integer)localObject).intValue()))
    {
      paramAppBrandRuntime = new IllegalStateException("Child has already been added with index ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(316606);
      throw paramAppBrandRuntime;
    }
    paramView.setTag(qyy, Integer.valueOf(ordinal()));
    localObject = paramAppBrandRuntime.qsk;
    int i = K(paramAppBrandRuntime);
    if ((paramView.getParent() == localObject) && (i >= ((e)localObject).getChildCount() - 1))
    {
      ((e)localObject).bringChildToFront(paramView);
      AppMethodBeat.o(316606);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    ((e)localObject).addView(paramView, i);
    AppMethodBeat.o(316606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bh
 * JD-Core Version:    0.7.0.1
 */