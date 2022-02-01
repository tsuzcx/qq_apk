package com.tencent.mm.plugin.appbrand.widget.k;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"traverseFixAccessibility", "", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void q(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51454);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(51454);
      return;
    }
    int j = paramViewGroup.getChildCount();
    int i;
    if (j >= 0) {
      i = 0;
    }
    for (;;)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        q((ViewGroup)localView);
      }
      while (i == j)
      {
        AppMethodBeat.o(51454);
        return;
        if ((localView instanceof RecyclerView)) {
          localView.setAccessibilityDelegate(null);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.k.a
 * JD-Core Version:    0.7.0.1
 */