package com.tencent.mm.plugin.appbrand.widget.i;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"traverseFixAccessibility", "", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final void m(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51454);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(51454);
      return;
    }
    int j = paramViewGroup.getChildCount();
    if (j >= 0)
    {
      int i = 0;
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        m((ViewGroup)localView);
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
    AppMethodBeat.o(51454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.a
 * JD-Core Version:    0.7.0.1
 */