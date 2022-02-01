package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class i<T extends RecyclerView.w>
  implements j<T>
{
  public static float Q(RecyclerView.w paramw)
  {
    if ((paramw != null) && (paramw.auu != null))
    {
      paramw = paramw.auu;
      int[] arrayOfInt = new int[2];
      paramw.getLocationOnScreen(arrayOfInt);
      return arrayOfInt[1];
    }
    return 0.0F;
  }
  
  public static float f(RecyclerView paramRecyclerView, RecyclerView.w paramw)
  {
    if (paramw != null) {
      try
      {
        if (paramw.auu != null)
        {
          float f2 = paramw.auu.getLeft();
          paramw = paramw.auu;
          ViewParent localViewParent2 = paramw.getParent();
          ViewParent localViewParent1 = localViewParent2;
          float f1 = f2;
          if ((localViewParent2 instanceof View))
          {
            paramw = (View)localViewParent2;
            f1 = f2 + paramw.getLeft();
            localViewParent1 = localViewParent2;
          }
          while ((paramw != paramRecyclerView) && (localViewParent1 != null))
          {
            localViewParent2 = paramw.getParent();
            localViewParent1 = localViewParent2;
            if ((localViewParent2 instanceof View))
            {
              paramw = (View)localViewParent2;
              int i = paramw.getLeft();
              f1 += i;
              localViewParent1 = localViewParent2;
            }
          }
          return f1;
        }
      }
      catch (Exception paramRecyclerView)
      {
        ad.printErrStackTrace("alvinluo", paramRecyclerView, "alvinluo getTransX exception", new Object[0]);
        return 0.0F;
      }
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.i
 * JD-Core Version:    0.7.0.1
 */