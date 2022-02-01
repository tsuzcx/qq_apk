package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class t
  extends x
{
  private s bYd;
  private s bYe;
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, s params)
  {
    AppMethodBeat.i(194845);
    int j = params.bs(paramView);
    int k = params.bw(paramView) / 2;
    if (paramLayoutManager.getClipToPadding()) {}
    for (int i = params.JE() + params.JG() / 2;; i = params.getEnd() / 2)
    {
      AppMethodBeat.o(194845);
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, s params)
  {
    Object localObject = null;
    AppMethodBeat.i(194855);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(194855);
      return null;
    }
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = params.JE() + params.JG() / 2;
      int i = 2147483647;
      k = 0;
      label51:
      if (k >= n) {
        break label120;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(params.bs(localView) + params.bw(localView) / 2 - j);
      if (m >= i) {
        break label128;
      }
      localObject = localView;
      i = m;
    }
    label128:
    for (;;)
    {
      k += 1;
      break label51;
      j = params.getEnd() / 2;
      break;
      label120:
      AppMethodBeat.o(194855);
      return localObject;
    }
  }
  
  private s b(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(194870);
    if ((this.bYd == null) || (this.bYd.bYg != paramLayoutManager)) {
      this.bYd = s.e(paramLayoutManager);
    }
    paramLayoutManager = this.bYd;
    AppMethodBeat.o(194870);
    return paramLayoutManager;
  }
  
  private static View c(RecyclerView.LayoutManager paramLayoutManager, s params)
  {
    Object localObject = null;
    AppMethodBeat.i(194863);
    int m = paramLayoutManager.getChildCount();
    if (m == 0)
    {
      AppMethodBeat.o(194863);
      return null;
    }
    int i = 2147483647;
    int j = 0;
    if (j < m)
    {
      View localView = paramLayoutManager.getChildAt(j);
      int k = params.bs(localView);
      if (k >= i) {
        break label80;
      }
      localObject = localView;
      i = k;
    }
    label80:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(194863);
      return localObject;
    }
  }
  
  private s c(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(194879);
    if ((this.bYe == null) || (this.bYe.bYg != paramLayoutManager)) {
      this.bYe = s.d(paramLayoutManager);
    }
    paramLayoutManager = this.bYe;
    AppMethodBeat.o(194879);
    return paramLayoutManager;
  }
  
  public int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(194899);
    int k = paramLayoutManager.getItemCount();
    if (k == 0)
    {
      AppMethodBeat.o(194899);
      return -1;
    }
    View localView = null;
    if (paramLayoutManager.canScrollVertically()) {
      localView = c(paramLayoutManager, b(paramLayoutManager));
    }
    while (localView == null)
    {
      AppMethodBeat.o(194899);
      return -1;
      if (paramLayoutManager.canScrollHorizontally()) {
        localView = c(paramLayoutManager, c(paramLayoutManager));
      }
    }
    int j = paramLayoutManager.getPosition(localView);
    if (j == -1)
    {
      AppMethodBeat.o(194899);
      return -1;
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      if (paramInt1 > 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if ((paramLayoutManager instanceof RecyclerView.r.b))
      {
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).fM(k - 1);
        paramInt2 = i;
        if (paramLayoutManager != null) {
          if (paramLayoutManager.x >= 0.0F)
          {
            paramInt2 = i;
            if (paramLayoutManager.y >= 0.0F) {}
          }
          else
          {
            paramInt2 = 1;
          }
        }
      }
      if (paramInt2 == 0) {
        break label213;
      }
      if (paramInt1 == 0) {
        break;
      }
      AppMethodBeat.o(194899);
      return j - 1;
      paramInt1 = 0;
      continue;
      if (paramInt2 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    AppMethodBeat.o(194899);
    return j;
    label213:
    if (paramInt1 != 0)
    {
      AppMethodBeat.o(194899);
      return j + 1;
    }
    AppMethodBeat.o(194899);
    return j;
  }
  
  public View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(194892);
    if (paramLayoutManager.canScrollVertically())
    {
      paramLayoutManager = a(paramLayoutManager, b(paramLayoutManager));
      AppMethodBeat.o(194892);
      return paramLayoutManager;
    }
    if (paramLayoutManager.canScrollHorizontally())
    {
      paramLayoutManager = a(paramLayoutManager, c(paramLayoutManager));
      AppMethodBeat.o(194892);
      return paramLayoutManager;
    }
    AppMethodBeat.o(194892);
    return null;
  }
  
  public int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    AppMethodBeat.i(194886);
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally())
    {
      arrayOfInt[0] = a(paramLayoutManager, paramView, c(paramLayoutManager));
      if (!paramLayoutManager.canScrollVertically()) {
        break label63;
      }
      arrayOfInt[1] = a(paramLayoutManager, paramView, b(paramLayoutManager));
    }
    for (;;)
    {
      AppMethodBeat.o(194886);
      return arrayOfInt;
      arrayOfInt[0] = 0;
      break;
      label63:
      arrayOfInt[1] = 0;
    }
  }
  
  protected final o f(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(194908);
    if (!(paramLayoutManager instanceof RecyclerView.r.b))
    {
      AppMethodBeat.o(194908);
      return null;
    }
    paramLayoutManager = new o(this.mRecyclerView.getContext())
    {
      protected final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(195094);
        paramAnonymousView = t.this.a(t.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = fO(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.bXY);
        }
        AppMethodBeat.o(195094);
      }
      
      protected final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      protected final int fP(int paramAnonymousInt)
      {
        AppMethodBeat.i(195104);
        paramAnonymousInt = Math.min(100, super.fP(paramAnonymousInt));
        AppMethodBeat.o(195104);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(194908);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.t
 * JD-Core Version:    0.7.0.1
 */