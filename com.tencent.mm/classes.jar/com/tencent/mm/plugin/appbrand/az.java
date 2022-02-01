package com.tencent.mm.plugin.appbrand;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.c;

 enum az
{
  private static final int kFR;
  
  static
  {
    AppMethodBeat.i(219294);
    kFK = new az("AppBrandPageContainer", 0);
    kFL = new az("PipContainer", 1);
    kFM = new az("LegacyDialogContainer", 2);
    kFN = new az("GlobalNativeWidgetContainerView", 3);
    kFO = new az("RemoteDebugFloatView", 4);
    kFP = new az("AuthorizeDialogContainer", 5);
    kFQ = new az("LoadingSplash", 6);
    kFS = new az[] { kFK, kFL, kFM, kFN, kFO, kFP, kFQ };
    kFR = 2131296917;
    AppMethodBeat.o(219294);
  }
  
  private az() {}
  
  private int G(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219292);
    paramAppBrandRuntime = paramAppBrandRuntime.kAt;
    if (ordinal() >= paramAppBrandRuntime.getChildCount())
    {
      i = paramAppBrandRuntime.getChildCount() - 1;
      while (i >= 0)
      {
        int j = ((Integer)paramAppBrandRuntime.getChildAt(i).getTag(kFR)).intValue();
        if (ordinal() < j)
        {
          AppMethodBeat.o(219292);
          return i;
        }
        i -= 1;
      }
    }
    int i = Math.min(ordinal(), paramAppBrandRuntime.getChildCount());
    AppMethodBeat.o(219292);
    return i;
  }
  
  final void a(AppBrandRuntime paramAppBrandRuntime, View paramView)
  {
    AppMethodBeat.i(219293);
    Object localObject = (Integer)paramView.getTag(kFR);
    if ((localObject != null) && (ordinal() != ((Integer)localObject).intValue()))
    {
      paramAppBrandRuntime = new IllegalStateException("Child has already been added with index ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(219293);
      throw paramAppBrandRuntime;
    }
    paramView.setTag(kFR, Integer.valueOf(ordinal()));
    localObject = paramAppBrandRuntime.kAt;
    int i = G(paramAppBrandRuntime);
    if ((paramView.getParent() == localObject) && (i >= ((c)localObject).getChildCount() - 1))
    {
      ((c)localObject).bringChildToFront(paramView);
      AppMethodBeat.o(219293);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    ((c)localObject).addView(paramView, i);
    AppMethodBeat.o(219293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.az
 * JD-Core Version:    0.7.0.1
 */