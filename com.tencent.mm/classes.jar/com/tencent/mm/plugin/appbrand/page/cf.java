package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class cf
{
  public static void a(ap paramap, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(325037);
    Object localObject;
    if ((BuildInfo.DEBUG) && (TextUtils.isEmpty(paramViewGroup.getContentDescription())))
    {
      localObject = (AccessibilityManager)a.a(MMApplicationContext.getContext(), AccessibilityManager.class);
      if ((localObject != null) && (!((AccessibilityManager)localObject).isTouchExplorationEnabled())) {
        paramViewGroup.setContentDescription("ScreenCanvasContainer");
      }
    }
    paramap = paramap.tth;
    if ((paramap.getParent() instanceof ViewGroup))
    {
      localObject = (ViewGroup)paramap.getParent();
      int i = ((ViewGroup)localObject).getChildCount() - 1;
      while (i >= 0)
      {
        if (((ViewGroup)localObject).getChildAt(i) == paramap)
        {
          ((ViewGroup)localObject).addView(paramViewGroup, i, new ViewGroup.LayoutParams(-1, -1));
          AppMethodBeat.o(325037);
          return;
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(325037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cf
 * JD-Core Version:    0.7.0.1
 */