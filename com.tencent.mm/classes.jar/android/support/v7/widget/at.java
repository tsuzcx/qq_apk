package android.support.v7.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class at
  extends RecyclerView.k
{
  RecyclerView anl;
  private final RecyclerView.m asH = new RecyclerView.m()
  {
    boolean awM = false;
    
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        this.awM = true;
      }
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      super.b(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (this.awM))
      {
        this.awM = false;
        at.this.mv();
      }
    }
  };
  private Scroller awL;
  
  public abstract int a(RecyclerView.i parami, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.i parami);
  
  public abstract int[] a(RecyclerView.i parami, View paramView);
  
  public final boolean aB(int paramInt1, int paramInt2)
  {
    RecyclerView.i locali = this.anl.getLayoutManager();
    if (locali == null) {}
    for (;;)
    {
      return false;
      if (this.anl.getAdapter() != null)
      {
        int i = this.anl.getMinFlingVelocity();
        if ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i))
        {
          if (!(locali instanceof RecyclerView.s.b)) {
            paramInt1 = 0;
          }
          while (paramInt1 != 0)
          {
            return true;
            RecyclerView.s locals = g(locali);
            if (locals == null)
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
                locals.atQ = paramInt1;
                locali.a(locals);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  public final int[] aI(int paramInt1, int paramInt2)
  {
    this.awL.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.awL.getFinalX(), this.awL.getFinalY() };
  }
  
  @Deprecated
  protected ae f(RecyclerView.i parami)
  {
    if (!(parami instanceof RecyclerView.s.b)) {
      return null;
    }
    new ae(this.anl.getContext())
    {
      protected final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      protected final void a(View paramAnonymousView, RecyclerView.t paramAnonymoust, RecyclerView.s.a paramAnonymousa)
      {
        if (at.this.anl == null) {}
        int i;
        int j;
        int k;
        do
        {
          return;
          paramAnonymousView = at.this.a(at.this.anl.getLayoutManager(), paramAnonymousView);
          i = paramAnonymousView[0];
          j = paramAnonymousView[1];
          k = cd(Math.max(Math.abs(i), Math.abs(j)));
        } while (k <= 0);
        paramAnonymousa.a(i, j, k, this.VD);
      }
    };
  }
  
  protected RecyclerView.s g(RecyclerView.i parami)
  {
    return f(parami);
  }
  
  public void j(RecyclerView paramRecyclerView)
  {
    if (this.anl == paramRecyclerView) {}
    do
    {
      return;
      if (this.anl != null)
      {
        this.anl.b(this.asH);
        this.anl.setOnFlingListener(null);
      }
      this.anl = paramRecyclerView;
    } while (this.anl == null);
    if (this.anl.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.anl.a(this.asH);
    this.anl.setOnFlingListener(this);
    this.awL = new Scroller(this.anl.getContext(), new DecelerateInterpolator());
    mv();
  }
  
  final void mv()
  {
    if (this.anl == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.anl.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.i)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.i)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.anl.a(localObject[0], localObject[1], null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.at
 * JD-Core Version:    0.7.0.1
 */