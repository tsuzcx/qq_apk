package android.support.v7.widget;

import android.view.View;
import java.util.List;

final class LinearLayoutManager$c
{
  int Fb;
  boolean afR = true;
  int afS;
  int afT;
  int afU;
  boolean afY;
  int agE;
  int agF = 0;
  boolean agG = false;
  int agH;
  List<RecyclerView.v> agI = null;
  int mLayoutDirection;
  
  private View bg(View paramView)
  {
    int m = this.agI.size();
    Object localObject = null;
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = ((RecyclerView.v)this.agI.get(j)).aku;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if ((localView == paramView) || (localLayoutParams.ajy.isRemoved())) {
        break label127;
      }
      int k = (localLayoutParams.ajy.jM() - this.afT) * this.afU;
      if ((k < 0) || (k >= i)) {
        break label127;
      }
      localObject = localView;
      if (k != 0)
      {
        localObject = localView;
        i = k;
      }
    }
    label127:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  private View iy()
  {
    int j = this.agI.size();
    int i = 0;
    while (i < j)
    {
      View localView = ((RecyclerView.v)this.agI.get(i)).aku;
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      if ((!localLayoutParams.ajy.isRemoved()) && (this.afT == localLayoutParams.ajy.jM()))
      {
        bf(localView);
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  final View a(RecyclerView.o paramo)
  {
    if (this.agI != null) {
      return iy();
    }
    paramo = paramo.cc(this.afT);
    this.afT += this.afU;
    return paramo;
  }
  
  final boolean b(RecyclerView.s params)
  {
    return (this.afT >= 0) && (this.afT < params.getItemCount());
  }
  
  public final void bf(View paramView)
  {
    paramView = bg(paramView);
    if (paramView == null)
    {
      this.afT = -1;
      return;
    }
    this.afT = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).ajy.jM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.c
 * JD-Core Version:    0.7.0.1
 */