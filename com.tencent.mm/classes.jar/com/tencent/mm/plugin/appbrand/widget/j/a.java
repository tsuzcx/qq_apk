package com.tencent.mm.plugin.appbrand.widget.j;

import a.l;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"traverseFixAccessibility", "", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final void k(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(135269);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(135269);
      return;
    }
    int j = paramViewGroup.getChildCount();
    if (j >= 0)
    {
      int i = 0;
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        k((ViewGroup)localView);
      }
      for (;;)
      {
        if (i == j) {
          break label73;
        }
        i += 1;
        break;
        if ((localView instanceof RecyclerView)) {
          localView.setAccessibilityDelegate(null);
        }
      }
    }
    label73:
    AppMethodBeat.o(135269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.j.a
 * JD-Core Version:    0.7.0.1
 */