package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class x
  extends RecyclerView.j
{
  private final RecyclerView.l bZo = new RecyclerView.l()
  {
    boolean cbf = false;
    
    public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      AppMethodBeat.i(195065);
      super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
      if ((paramAnonymousInt == 0) && (this.cbf))
      {
        this.cbf = false;
        x.this.KX();
      }
      AppMethodBeat.o(195065);
    }
    
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
        this.cbf = true;
      }
    }
  };
  private Scroller cbe;
  RecyclerView mRecyclerView;
  
  final void KX()
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
    this.mRecyclerView.br(localObject[0], localObject[1]);
  }
  
  public abstract int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2);
  
  public abstract View a(RecyclerView.LayoutManager paramLayoutManager);
  
  public void a(RecyclerView paramRecyclerView)
  {
    if (this.mRecyclerView == paramRecyclerView) {}
    do
    {
      return;
      if (this.mRecyclerView != null)
      {
        this.mRecyclerView.b(this.bZo);
        this.mRecyclerView.setOnFlingListener(null);
      }
      this.mRecyclerView = paramRecyclerView;
    } while (this.mRecyclerView == null);
    if (this.mRecyclerView.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.mRecyclerView.a(this.bZo);
    this.mRecyclerView.setOnFlingListener(this);
    this.cbe = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
    KX();
  }
  
  public abstract int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView);
  
  public final boolean bC(int paramInt1, int paramInt2)
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
                localr.cag = paramInt1;
                localLayoutManager.startSmoothScroll(localr);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  public final int[] bI(int paramInt1, int paramInt2)
  {
    this.cbe.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    return new int[] { this.cbe.getFinalX(), this.cbe.getFinalY() };
  }
  
  @Deprecated
  protected o f(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.r.b)) {
      return null;
    }
    new o(this.mRecyclerView.getContext())
    {
      protected final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(195069);
        if (x.this.mRecyclerView == null)
        {
          AppMethodBeat.o(195069);
          return;
        }
        paramAnonymousView = x.this.a(x.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = fO(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.bXY);
        }
        AppMethodBeat.o(195069);
      }
      
      protected final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
    };
  }
  
  protected RecyclerView.r g(RecyclerView.LayoutManager paramLayoutManager)
  {
    return f(paramLayoutManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.x
 * JD-Core Version:    0.7.0.1
 */