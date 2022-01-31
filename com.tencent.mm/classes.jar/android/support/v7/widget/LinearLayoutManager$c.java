package android.support.v7.widget;

import android.view.View;
import java.util.List;

final class LinearLayoutManager$c
{
  int El;
  boolean adC = true;
  int adD;
  int adE;
  int adF;
  boolean adJ;
  int aer;
  int aes = 0;
  boolean aet = false;
  int aeu;
  List<RecyclerView.v> aev = null;
  int kO;
  
  final View a(RecyclerView.o paramo)
  {
    if (this.aev != null)
    {
      int j = this.aev.size();
      int i = 0;
      while (i < j)
      {
        paramo = ((RecyclerView.v)this.aev.get(i)).aie;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramo.getLayoutParams();
        if ((!localLayoutParams.ahi.isRemoved()) && (this.adE == localLayoutParams.ahi.ic()))
        {
          aW(paramo);
          return paramo;
        }
        i += 1;
      }
      return null;
    }
    paramo = paramo.bV(this.adE);
    this.adE += this.adF;
    return paramo;
  }
  
  public final void aW(View paramView)
  {
    int m = this.aev.size();
    Object localObject = null;
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = ((RecyclerView.v)this.aev.get(j)).aie;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if ((localView == paramView) || (localLayoutParams.ahi.isRemoved())) {
        break label154;
      }
      int k = (localLayoutParams.ahi.ic() - this.adE) * this.adF;
      if ((k < 0) || (k >= i)) {
        break label154;
      }
      localObject = localView;
      if (k != 0)
      {
        localObject = localView;
        i = k;
      }
    }
    label154:
    for (;;)
    {
      j += 1;
      break;
      if (localObject == null)
      {
        this.adE = -1;
        return;
      }
      this.adE = ((RecyclerView.LayoutParams)localObject.getLayoutParams()).ahi.ic();
      return;
    }
  }
  
  final boolean b(RecyclerView.s params)
  {
    return (this.adE >= 0) && (this.adE < params.getItemCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.c
 * JD-Core Version:    0.7.0.1
 */