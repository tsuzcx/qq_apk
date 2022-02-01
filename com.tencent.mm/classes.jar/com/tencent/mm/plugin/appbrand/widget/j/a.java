package com.tencent.mm.plugin.appbrand.widget.j;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"traverseFixAccessibility", "", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final void n(ViewGroup paramViewGroup)
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
        n((ViewGroup)localView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.j.a
 * JD-Core Version:    0.7.0.1
 */