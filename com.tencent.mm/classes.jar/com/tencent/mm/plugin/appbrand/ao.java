package com.tencent.mm.plugin.appbrand;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d;

 enum ao
{
  private static int jEi;
  
  static
  {
    AppMethodBeat.i(207743);
    jEb = new ao("AppBrandPageContainer", 0);
    jEc = new ao("PipContainer", 1);
    jEd = new ao("LegacyDialogContainer", 2);
    jEe = new ao("GlobalNativeWidgetContainerView", 3);
    jEf = new ao("RemoteDebugFloatView", 4);
    jEg = new ao("AuthorizeDialogContainer", 5);
    jEh = new ao("LoadingSplash", 6);
    jEj = new ao[] { jEb, jEc, jEd, jEe, jEf, jEg, jEh };
    jEi = 2131308472;
    AppMethodBeat.o(207743);
  }
  
  private ao() {}
  
  private int G(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207741);
    paramAppBrandRuntime = paramAppBrandRuntime.jzF;
    if (ordinal() >= paramAppBrandRuntime.getChildCount())
    {
      i = paramAppBrandRuntime.getChildCount() - 1;
      while (i >= 0)
      {
        int j = ((Integer)paramAppBrandRuntime.getChildAt(i).getTag(jEi)).intValue();
        if (ordinal() < j)
        {
          AppMethodBeat.o(207741);
          return i;
        }
        i -= 1;
      }
    }
    int i = Math.min(ordinal(), paramAppBrandRuntime.getChildCount());
    AppMethodBeat.o(207741);
    return i;
  }
  
  final void a(AppBrandRuntime paramAppBrandRuntime, View paramView)
  {
    AppMethodBeat.i(207742);
    Object localObject = (Integer)paramView.getTag(jEi);
    if ((localObject != null) && (ordinal() != ((Integer)localObject).intValue()))
    {
      paramAppBrandRuntime = new IllegalStateException("Child has already been added with index ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(207742);
      throw paramAppBrandRuntime;
    }
    paramView.setTag(jEi, Integer.valueOf(ordinal()));
    localObject = paramAppBrandRuntime.jzF;
    int i = G(paramAppBrandRuntime);
    if ((paramView.getParent() == localObject) && (i >= ((d)localObject).getChildCount() - 1))
    {
      ((d)localObject).bringChildToFront(paramView);
      AppMethodBeat.o(207742);
      return;
    }
    if (paramView.getParent() != null) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    ((d)localObject).addView(paramView, i);
    AppMethodBeat.o(207742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ao
 * JD-Core Version:    0.7.0.1
 */