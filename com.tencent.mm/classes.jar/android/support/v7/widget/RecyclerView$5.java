package android.support.v7.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

final class RecyclerView$5
  implements s.b
{
  RecyclerView$5(RecyclerView paramRecyclerView) {}
  
  public final void addView(View paramView, int paramInt)
  {
    this.aja.addView(paramView, paramInt);
    RecyclerView localRecyclerView = this.aja;
    paramView = RecyclerView.bp(paramView);
    if ((localRecyclerView.Tg != null) && (paramView != null)) {
      localRecyclerView.Tg.k(paramView);
    }
    if (localRecyclerView.ail != null)
    {
      paramInt = localRecyclerView.ail.size() - 1;
      while (paramInt >= 0)
      {
        localRecyclerView.ail.get(paramInt);
        paramInt -= 1;
      }
    }
  }
  
  public final void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    RecyclerView.v localv = RecyclerView.bp(paramView);
    if (localv != null)
    {
      if ((!localv.jW()) && (!localv.jL())) {
        throw new IllegalArgumentException("Called attach on a child which is not detached: " + localv + this.aja.iM());
      }
      localv.jT();
    }
    RecyclerView.a(this.aja, paramView, paramInt, paramLayoutParams);
  }
  
  public final RecyclerView.v bb(View paramView)
  {
    return RecyclerView.bp(paramView);
  }
  
  public final void bc(View paramView)
  {
    paramView = RecyclerView.bp(paramView);
    if (paramView != null) {
      RecyclerView.v.a(paramView, this.aja);
    }
  }
  
  public final void bd(View paramView)
  {
    paramView = RecyclerView.bp(paramView);
    if (paramView != null) {
      RecyclerView.v.b(paramView, this.aja);
    }
  }
  
  public final void detachViewFromParent(int paramInt)
  {
    Object localObject = getChildAt(paramInt);
    if (localObject != null)
    {
      localObject = RecyclerView.bp((View)localObject);
      if (localObject != null)
      {
        if ((((RecyclerView.v)localObject).jW()) && (!((RecyclerView.v)localObject).jL())) {
          throw new IllegalArgumentException("called detach on an already detached child " + localObject + this.aja.iM());
        }
        ((RecyclerView.v)localObject).addFlags(256);
      }
    }
    RecyclerView.b(this.aja, paramInt);
  }
  
  public final View getChildAt(int paramInt)
  {
    return this.aja.getChildAt(paramInt);
  }
  
  public final int getChildCount()
  {
    return this.aja.getChildCount();
  }
  
  public final int indexOfChild(View paramView)
  {
    return this.aja.indexOfChild(paramView);
  }
  
  public final void removeAllViews()
  {
    int j = this.aja.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      this.aja.bu(localView);
      localView.clearAnimation();
      i += 1;
    }
    this.aja.removeAllViews();
  }
  
  public final void removeViewAt(int paramInt)
  {
    View localView = this.aja.getChildAt(paramInt);
    if (localView != null)
    {
      this.aja.bu(localView);
      localView.clearAnimation();
    }
    this.aja.removeViewAt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.5
 * JD-Core Version:    0.7.0.1
 */