package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

public class ak
  extends at
{
  private aj aqX;
  private aj aqY;
  
  private static int a(RecyclerView.LayoutManager paramLayoutManager, View paramView, aj paramaj)
  {
    int j = paramaj.bo(paramView);
    int k = paramaj.bs(paramView) / 2;
    if (paramLayoutManager.getClipToPadding()) {}
    for (int i = paramaj.kH() + paramaj.kJ() / 2;; i = paramaj.getEnd() / 2) {
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.LayoutManager paramLayoutManager, aj paramaj)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int n = paramLayoutManager.getChildCount();
    if (n == 0) {}
    int j;
    int i;
    int k;
    label45:
    do
    {
      return localObject2;
      if (!paramLayoutManager.getClipToPadding()) {
        break;
      }
      j = paramaj.kH() + paramaj.kJ() / 2;
      i = 2147483647;
      k = 0;
      localObject2 = localObject1;
    } while (k >= n);
    localObject2 = paramLayoutManager.getChildAt(k);
    int m = Math.abs(paramaj.bo((View)localObject2) + paramaj.bs((View)localObject2) / 2 - j);
    if (m < i)
    {
      localObject1 = localObject2;
      i = m;
    }
    for (;;)
    {
      k += 1;
      break label45;
      j = paramaj.getEnd() / 2;
      break;
    }
  }
  
  private aj b(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((this.aqX == null) || (this.aqX.arI != paramLayoutManager)) {
      this.aqX = aj.e(paramLayoutManager);
    }
    return this.aqX;
  }
  
  private aj c(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((this.aqY == null) || (this.aqY.arI != paramLayoutManager)) {
      this.aqY = aj.d(paramLayoutManager);
    }
    return this.aqY;
  }
  
  private static View c(RecyclerView.LayoutManager paramLayoutManager, aj paramaj)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = paramLayoutManager.getChildCount();
    if (m == 0) {}
    int i;
    int j;
    do
    {
      return localObject2;
      i = 2147483647;
      j = 0;
      localObject2 = localObject1;
    } while (j >= m);
    localObject2 = paramLayoutManager.getChildAt(j);
    int k = paramaj.bo((View)localObject2);
    if (k < i)
    {
      localObject1 = localObject2;
      i = k;
    }
    for (;;)
    {
      j += 1;
      break;
    }
  }
  
  public int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = paramLayoutManager.getItemCount();
    if (k == 0) {}
    View localView;
    label37:
    int j;
    do
    {
      return -1;
      localView = null;
      if (!paramLayoutManager.canScrollVertically()) {
        break;
      }
      localView = c(paramLayoutManager, b(paramLayoutManager));
      if (localView == null) {
        break label155;
      }
      j = paramLayoutManager.getPosition(localView);
    } while (j == -1);
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
        paramLayoutManager = ((RecyclerView.r.b)paramLayoutManager).bZ(k - 1);
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
        break label179;
      }
      if (paramInt1 == 0) {
        break label176;
      }
      return j - 1;
      if (!paramLayoutManager.canScrollHorizontally()) {
        break label37;
      }
      localView = c(paramLayoutManager, c(paramLayoutManager));
      break label37;
      label155:
      break;
      paramInt1 = 0;
      continue;
      if (paramInt2 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    label176:
    return j;
    label179:
    if (paramInt1 != 0) {
      return j + 1;
    }
    return j;
  }
  
  public View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically()) {
      return a(paramLayoutManager, b(paramLayoutManager));
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      return a(paramLayoutManager, c(paramLayoutManager));
    }
    return null;
  }
  
  public int[] a(RecyclerView.LayoutManager paramLayoutManager, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = a(paramLayoutManager, paramView, c(paramLayoutManager));
    }
    while (paramLayoutManager.canScrollVertically())
    {
      arrayOfInt[1] = a(paramLayoutManager, paramView, b(paramLayoutManager));
      return arrayOfInt;
      arrayOfInt[0] = 0;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  protected final ae f(RecyclerView.LayoutManager paramLayoutManager)
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
        paramAnonymousView = ak.this.a(ak.this.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cc(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.VQ);
        }
      }
      
      protected final int cd(int paramAnonymousInt)
      {
        return Math.min(100, super.cd(paramAnonymousInt));
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.ak
 * JD-Core Version:    0.7.0.1
 */