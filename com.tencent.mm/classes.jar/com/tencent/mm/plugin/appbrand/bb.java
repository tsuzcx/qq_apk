package com.tencent.mm.plugin.appbrand;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d;

 enum bb
{
  private static final int nzy;
  
  static
  {
    AppMethodBeat.i(244541);
    nzr = new bb("AppBrandPageContainer", 0);
    nzs = new bb("PipContainer", 1);
    nzt = new bb("LegacyDialogContainer", 2);
    nzu = new bb("GlobalNativeWidgetContainerView", 3);
    nzv = new bb("RemoteDebugFloatView", 4);
    nzw = new bb("AuthorizeDialogContainer", 5);
    nzx = new bb("LoadingSplash", 6);
    nzz = new bb[] { nzr, nzs, nzt, nzu, nzv, nzw, nzx };
    nzy = a.d.app_brand_runtime_root_child_index_tag;
    AppMethodBeat.o(244541);
  }
  
  private bb() {}
  
  private int H(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(244537);
    paramAppBrandRuntime = paramAppBrandRuntime.ntC;
    if (ordinal() >= paramAppBrandRuntime.getChildCount())
    {
      i = paramAppBrandRuntime.getChildCount() - 1;
      while (i >= 0)
      {
        int j = ((Integer)paramAppBrandRuntime.getChildAt(i).getTag(nzy)).intValue();
        if (ordinal() < j)
        {
          AppMethodBeat.o(244537);
          return i;
        }
        i -= 1;
      }
    }
    int i = Math.min(ordinal(), paramAppBrandRuntime.getChildCount());
    AppMethodBeat.o(244537);
    return i;
  }
  
  final void a(AppBrandRuntime paramAppBrandRuntime, View paramView)
  {
    AppMethodBeat.i(244539);
    Object localObject = (Integer)paramView.getTag(nzy);
    if ((localObject != null) && (ordinal() != ((Integer)localObject).intValue()))
    {
      paramAppBrandRuntime = new IllegalStateException("Child has already been added with index ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(244539);
      throw paramAppBrandRuntime;
    }
    paramView.setTag(nzy, Integer.valueOf(ordinal()));
    localObject = paramAppBrandRuntime.ntC;
    int i = H(paramAppBrandRuntime);
    if ((paramView.getParent() == localObject) && (i >= ((d)localObject).getChildCount() - 1))
    {
      ((d)localObject).bringChildToFront(paramView);
      AppMethodBeat.o(244539);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    ((d)localObject).addView(paramView, i);
    AppMethodBeat.o(244539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bb
 * JD-Core Version:    0.7.0.1
 */