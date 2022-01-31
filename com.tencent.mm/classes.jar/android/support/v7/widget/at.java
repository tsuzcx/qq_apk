package android.support.v7.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class at
  extends RecyclerView.k
{
  RecyclerView adt;
  private final RecyclerView.m aiL = new at.1(this);
  private Scroller amz;
  
  public abstract int a(RecyclerView.i parami, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.i parami);
  
  public abstract int[] a(RecyclerView.i parami, View paramView);
  
  public final boolean aA(int paramInt1, int paramInt2)
  {
    RecyclerView.i locali = this.adt.getLayoutManager();
    if (locali == null) {}
    for (;;)
    {
      return false;
      if (this.adt.getAdapter() != null)
      {
        int i = this.adt.getMinFlingVelocity();
        if ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i))
        {
          if (!(locali instanceof RecyclerView.r.b)) {
            paramInt1 = 0;
          }
          while (paramInt1 != 0)
          {
            return true;
            RecyclerView.r localr = g(locali);
            if (localr == null)
            {
              paramInt1 = 0;
            }
            else
            {
              paramInt1 = a(locali, paramInt1, paramInt2);
              if (paramInt1 == -1)
              {
                paramInt1 = 0;
              }
              else
              {
                localr.ajQ = paramInt1;
                locali.a(localr);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  public final int[] aG(int paramInt1, int paramInt2)
  {
    this.amz.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.amz.getFinalX(), this.amz.getFinalY() };
  }
  
  @Deprecated
  protected ae f(RecyclerView.i parami)
  {
    if (!(parami instanceof RecyclerView.r.b)) {
      return null;
    }
    return new at.2(this, this.adt.getContext());
  }
  
  protected RecyclerView.r g(RecyclerView.i parami)
  {
    return f(parami);
  }
  
  public final void i(RecyclerView paramRecyclerView)
  {
    if (this.adt == paramRecyclerView) {}
    do
    {
      return;
      if (this.adt != null)
      {
        this.adt.b(this.aiL);
        this.adt.setOnFlingListener(null);
      }
      this.adt = paramRecyclerView;
    } while (this.adt == null);
    if (this.adt.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.adt.a(this.aiL);
    this.adt.setOnFlingListener(this);
    this.amz = new Scroller(this.adt.getContext(), new DecelerateInterpolator());
    kt();
  }
  
  final void kt()
  {
    if (this.adt == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.adt.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.i)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.i)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.adt.a(localObject[0], localObject[1], null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.at
 * JD-Core Version:    0.7.0.1
 */