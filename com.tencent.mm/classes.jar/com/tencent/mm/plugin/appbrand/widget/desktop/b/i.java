package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class i<T extends RecyclerView.v>
  implements j<T>
{
  public static float Q(RecyclerView.v paramv)
  {
    if ((paramv != null) && (paramv.arI != null))
    {
      paramv = paramv.arI;
      int[] arrayOfInt = new int[2];
      paramv.getLocationOnScreen(arrayOfInt);
      return arrayOfInt[1];
    }
    return 0.0F;
  }
  
  public static float f(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    if (paramv != null) {
      try
      {
        if (paramv.arI != null)
        {
          float f2 = paramv.arI.getLeft();
          paramv = paramv.arI;
          ViewParent localViewParent2 = paramv.getParent();
          ViewParent localViewParent1 = localViewParent2;
          float f1 = f2;
          if ((localViewParent2 instanceof View))
          {
            paramv = (View)localViewParent2;
            f1 = f2 + paramv.getLeft();
            localViewParent1 = localViewParent2;
          }
          while ((paramv != paramRecyclerView) && (localViewParent1 != null))
          {
            localViewParent2 = paramv.getParent();
            localViewParent1 = localViewParent2;
            if ((localViewParent2 instanceof View))
            {
              paramv = (View)localViewParent2;
              int i = paramv.getLeft();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.i
 * JD-Core Version:    0.7.0.1
 */