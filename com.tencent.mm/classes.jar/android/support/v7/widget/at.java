package android.support.v7.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class at
  extends RecyclerView.j
{
  private final RecyclerView.l asS = new RecyclerView.l()
  {
    boolean awK = false;
    
    public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (this.awK))
      {
        this.awK = false;
        at.this.mz();
      }
    }
    
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        this.awK = true;
      }
    }
  };
  private Scroller awJ;
  RecyclerView mRecyclerView;
  
  public abstract int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.LayoutManager paramLayoutManager);
  
  public abstract int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView);
  
  public int[] aC(int paramInt1, int paramInt2)
  {
    this.awJ.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.awJ.getFinalX(), this.awJ.getFinalY() };
  }
  
  public final boolean av(int paramInt1, int paramInt2)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    if (localLayoutManager == null) {}
    for (;;)
    {
      return false;
      if (this.mRecyclerView.getAdapter() != null)
      {
        int i = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i))
        {
          if (!(localLayoutManager instanceof RecyclerView.r.b)) {
            paramInt1 = 0;
          }
          while (paramInt1 != 0)
          {
            return true;
            RecyclerView.r localr = g(localLayoutManager);
            if (localr == null)
            {
              paramInt1 = 0;
            }
            else
            {
              paramInt1 = a(localLayoutManager, paramInt1, paramInt2);
              if (paramInt1 == -1)
              {
                paramInt1 = 0;
              }
              else
              {
                localr.atO = paramInt1;
                localLayoutManager.startSmoothScroll(localr);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  @Deprecated
  protected ae f(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.r.b)) {
      return null;
    }
    new ae(this.mRecyclerView.getContext())
    {
      protected final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      protected final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        if (at.this.mRecyclerView == null) {}
        int i;
        int j;
        int k;
        do
        {
          return;
          paramAnonymousView = at.this.a(at.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
          i = paramAnonymousView[0];
          j = paramAnonymousView[1];
          k = cc(Math.max(Math.abs(i), Math.abs(j)));
        } while (k <= 0);
        paramAnonymousa.a(i, j, k, this.VQ);
      }
    };
  }
  
  public void f(RecyclerView paramRecyclerView)
  {
    if (this.mRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.b(this.asS);
        this.mRecyclerView.setOnFlingListener(null);
      }
      this.mRecyclerView = paramRecyclerView;
    } while (this.mRecyclerView == null);
    if (this.mRecyclerView.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.mRecyclerView.a(this.asS);
    this.mRecyclerView.setOnFlingListener(this);
    this.awJ = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
    mz();
  }
  
  protected RecyclerView.r g(RecyclerView.LayoutManager paramLayoutManager)
  {
    return f(paramLayoutManager);
  }
  
  final void mz()
  {
    if (this.mRecyclerView == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.mRecyclerView.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.LayoutManager)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.LayoutManager)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.mRecyclerView.a(localObject[0], localObject[1], null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.at
 * JD-Core Version:    0.7.0.1
 */