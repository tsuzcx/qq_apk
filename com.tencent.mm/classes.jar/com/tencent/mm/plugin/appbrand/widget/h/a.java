package com.tencent.mm.plugin.appbrand.widget.h;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public final class a
{
  public static final void j(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {}
    label61:
    for (;;)
    {
      return;
      int j = paramViewGroup.getChildCount();
      if (j >= 0)
      {
        int i = 0;
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          j((ViewGroup)localView);
        }
        for (;;)
        {
          if (i == j) {
            break label61;
          }
          i += 1;
          break;
          if ((localView instanceof RecyclerView)) {
            localView.setAccessibilityDelegate(null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h.a
 * JD-Core Version:    0.7.0.1
 */