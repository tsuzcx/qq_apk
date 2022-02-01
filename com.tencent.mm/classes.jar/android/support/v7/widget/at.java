package android.support.v7.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class at
  extends RecyclerView.k
{
  RecyclerView akA;
  private final RecyclerView.m apU = new RecyclerView.m()
  {
    boolean atZ = false;
    
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        this.atZ = true;
      }
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      super.b(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (this.atZ))
      {
        this.atZ = false;
        at.this.lU();
      }
    }
  };
  private Scroller atY;
  
  public abstract int a(RecyclerView.i parami, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.i parami);
  
  public abstract int[] a(RecyclerView.i parami, View paramView);
  
  public final boolean aA(int paramInt1, int paramInt2)
  {
    RecyclerView.i locali = this.akA.getLayoutManager();
    if (locali == null) {}
    for (;;)
    {
      return false;
      if (this.akA.getAdapter() != null)
      {
        int i = this.akA.getMinFlingVelocity();
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
                localr.ard = paramInt1;
                locali.a(localr);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  public final int[] aH(int paramInt1, int paramInt2)
  {
    this.atY.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.atY.getFinalX(), this.atY.getFinalY() };
  }
  
  @Deprecated
  protected ae f(RecyclerView.i parami)
  {
    if (!(parami instanceof RecyclerView.r.b)) {
      return null;
    }
    new ae(this.akA.getContext())
    {
      protected final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      protected final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        if (at.this.akA == null) {}
        int i;
        int j;
        int k;
        do
        {
          return;
          paramAnonymousView = at.this.a(at.this.akA.getLayoutManager(), paramAnonymousView);
          i = paramAnonymousView[0];
          j = paramAnonymousView[1];
          k = cd(Math.max(Math.abs(i), Math.abs(j)));
        } while (k <= 0);
        paramAnonymousa.a(i, j, k, this.SS);
      }
    };
  }
  
  protected RecyclerView.r g(RecyclerView.i parami)
  {
    return f(parami);
  }
  
  public void j(RecyclerView paramRecyclerView)
  {
    if (this.akA == paramRecyclerView) {}
    do
    {
      return;
      if (this.akA != null)
      {
        this.akA.b(this.apU);
        this.akA.setOnFlingListener(null);
      }
      this.akA = paramRecyclerView;
    } while (this.akA == null);
    if (this.akA.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.akA.a(this.apU);
    this.akA.setOnFlingListener(this);
    this.atY = new Scroller(this.akA.getContext(), new DecelerateInterpolator());
    lU();
  }
  
  final void lU()
  {
    if (this.akA == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.akA.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.i)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.i)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.akA.a(localObject[0], localObject[1], null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.at
 * JD-Core Version:    0.7.0.1
 */