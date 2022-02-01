package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;

public abstract class b<T extends RecyclerView.v>
  implements c<T>
{
  public static float e(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    if (!(paramv instanceof d)) {
      return 0.0F;
    }
    paramv = ((d)paramv).nnL;
    int[] arrayOfInt = new int[2];
    paramv.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1] + com.tencent.mm.plugin.appbrand.widget.desktop.b.ey(paramRecyclerView.getContext()) / 2.0F;
  }
  
  public static float f(RecyclerView paramRecyclerView, RecyclerView.v paramv)
  {
    if (!(paramv instanceof d)) {
      return 0.0F;
    }
    paramv = ((d)paramv).nnL;
    int[] arrayOfInt = new int[2];
    paramv.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[0] + com.tencent.mm.plugin.appbrand.widget.desktop.b.ey(paramRecyclerView.getContext()) / 2.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.b
 * JD-Core Version:    0.7.0.1
 */