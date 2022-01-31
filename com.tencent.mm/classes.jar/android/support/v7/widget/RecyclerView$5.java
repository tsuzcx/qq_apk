package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

final class RecyclerView$5
  implements u.b
{
  RecyclerView$5(RecyclerView paramRecyclerView) {}
  
  public final RecyclerView.v aT(View paramView)
  {
    return RecyclerView.bf(paramView);
  }
  
  public final void aU(View paramView)
  {
    paramView = RecyclerView.bf(paramView);
    if (paramView != null) {
      RecyclerView.v.a(paramView, this.agK);
    }
  }
  
  public final void aV(View paramView)
  {
    paramView = RecyclerView.bf(paramView);
    if (paramView != null) {
      RecyclerView.v.b(paramView, this.agK);
    }
  }
  
  public final void addView(View paramView, int paramInt)
  {
    this.agK.addView(paramView, paramInt);
    RecyclerView localRecyclerView = this.agK;
    RecyclerView.bf(paramView);
    if (localRecyclerView.afV != null)
    {
      paramInt = localRecyclerView.afV.size() - 1;
      while (paramInt >= 0)
      {
        localRecyclerView.afV.get(paramInt);
        paramInt -= 1;
      }
    }
  }
  
  public final void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.v localv = RecyclerView.bf(paramView);
    if (localv != null)
    {
      if ((!localv.il()) && (!localv.ib())) {
        throw new IllegalArgumentException("Called attach on a child which is not detached: " + localv + this.agK.hl());
      }
      localv.ii();
    }
    RecyclerView.a(this.agK, paramView, paramInt, paramLayoutParams);
  }
  
  public final void detachViewFromParent(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (localObject != null)
    {
      localObject = RecyclerView.bf((View)localObject);
      if (localObject != null)
      {
        if ((((RecyclerView.v)localObject).il()) && (!((RecyclerView.v)localObject).ib())) {
          throw new IllegalArgumentException("called detach on an already detached child " + localObject + this.agK.hl());
        }
        ((RecyclerView.v)localObject).addFlags(256);
      }
    }
    RecyclerView.b(this.agK, paramInt);
  }
  
  public final View getChildAt(int paramInt)
  {
    return this.agK.getChildAt(paramInt);
  }
  
  public final int getChildCount()
  {
    return this.agK.getChildCount();
  }
  
  public final int indexOfChild(View paramView)
  {
    return this.agK.indexOfChild(paramView);
  }
  
  public final void removeAllViews()
  {
    int j = this.agK.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      this.agK.bk(localView);
      localView.clearAnimation();
      i += 1;
    }
    this.agK.removeAllViews();
  }
  
  public final void removeViewAt(int paramInt)
  {
    View localView = this.agK.getChildAt(paramInt);
    if (localView != null)
    {
      this.agK.bk(localView);
      localView.clearAnimation();
    }
    this.agK.removeViewAt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.5
 * JD-Core Version:    0.7.0.1
 */