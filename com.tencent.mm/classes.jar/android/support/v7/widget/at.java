package android.support.v7.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class at
  extends RecyclerView.k
{
  RecyclerView alu;
  private final RecyclerView.m aqP = new RecyclerView.m()
  {
    boolean auU = false;
    
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        this.auU = true;
      }
    }
    
    public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      super.b(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (this.auU))
      {
        this.auU = false;
        at.this.md();
      }
    }
  };
  private Scroller auT;
  
  public abstract int a(RecyclerView.i parami, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.i parami);
  
  public abstract int[] a(RecyclerView.i parami, View paramView);
  
  public final boolean aA(int paramInt1, int paramInt2)
  {
    RecyclerView.i locali = this.alu.getLayoutManager();
    if (locali == null) {}
    for (;;)
    {
      return false;
      if (this.alu.getAdapter() != null)
      {
        int i = this.alu.getMinFlingVelocity();
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
                locals.arZ = paramInt1;
                locali.a(locals);
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
    this.auT.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.auT.getFinalX(), this.auT.getFinalY() };
  }
  
  @Deprecated
  protected ae f(RecyclerView.i parami)
  {
    if (!(parami instanceof RecyclerView.s.b)) {
      return null;
    }
    new ae(this.alu.getContext())
    {
      protected final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      protected final void a(View paramAnonymousView, RecyclerView.t paramAnonymoust, RecyclerView.s.a paramAnonymousa)
      {
        if (at.this.alu == null) {}
        int i;
        int j;
        int k;
        do
        {
          return;
          paramAnonymousView = at.this.a(at.this.alu.getLayoutManager(), paramAnonymousView);
          i = paramAnonymousView[0];
          j = paramAnonymousView[1];
          k = cd(Math.max(Math.abs(i), Math.abs(j)));
        } while (k <= 0);
        paramAnonymousa.a(i, j, k, this.TN);
      }
    };
  }
  
  protected RecyclerView.s g(RecyclerView.i parami)
  {
    return f(parami);
  }
  
  public void j(RecyclerView paramRecyclerView)
  {
    if (this.alu == paramRecyclerView) {}
    do
    {
      return;
      if (this.alu != null)
      {
        this.alu.b(this.aqP);
        this.alu.setOnFlingListener(null);
      }
      this.alu = paramRecyclerView;
    } while (this.alu == null);
    if (this.alu.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.alu.a(this.aqP);
    this.alu.setOnFlingListener(this);
    this.auT = new Scroller(this.alu.getContext(), new DecelerateInterpolator());
    md();
  }
  
  final void md()
  {
    if (this.alu == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.alu.getLayoutManager();
        } while (localObject == null);
        localView = a((RecyclerView.i)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.i)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.alu.a(localObject[0], localObject[1], null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.at
 * JD-Core Version:    0.7.0.1
 */