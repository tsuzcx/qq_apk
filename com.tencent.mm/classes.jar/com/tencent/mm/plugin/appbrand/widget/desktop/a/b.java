package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class b<T extends RecyclerView.v>
  implements c<T>
{
  public static float Q(RecyclerView.v paramv)
  {
    if ((paramv != null) && (paramv.aku != null))
    {
      paramv = paramv.aku;
      int[] arrayOfInt = new int[2];
      paramv.getLocationOnScreen(arrayOfInt);
      return arrayOfInt[1];
    }
    return 0.0F;
  }
  
  public static float c(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    if (paramv != null) {
      try
      {
        if (paramv.aku != null)
        {
          float f2 = paramv.aku.getLeft();
          paramv = paramv.aku;
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
        ab.printErrStackTrace("alvinluo", paramRecyclerView, "alvinluo getTransX exception", new Object[0]);
        return 0.0F;
      }
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.b
 * JD-Core Version:    0.7.0.1
 */