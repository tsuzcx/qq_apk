package android.support.v7.widget;

import android.graphics.PointF;
import android.view.View;

public class af
  extends at
{
  private aj aqX;
  private aj aqY;
  
  private int a(RecyclerView.LayoutManager paramLayoutManager, aj paramaj, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = aC(paramInt1, paramInt2);
    float f = b(paramLayoutManager, paramaj);
    if (f <= 0.0F) {
      return 0;
    }
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {}
    for (paramInt1 = arrayOfInt[0];; paramInt1 = arrayOfInt[1]) {
      return Math.round(paramInt1 / f);
    }
  }
  
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
  
  private static float b(RecyclerView.LayoutManager paramLayoutManager, aj paramaj)
  {
    int i = 2147483647;
    int k = -2147483648;
    int i2 = paramLayoutManager.getChildCount();
    if (i2 == 0) {
      return 1.0F;
    }
    int n = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int m;
    Object localObject3;
    int j;
    if (n < i2)
    {
      View localView = paramLayoutManager.getChildAt(n);
      int i1 = paramLayoutManager.getPosition(localView);
      m = i;
      localObject3 = localObject1;
      if (i1 == -1) {
        break label180;
      }
      j = i;
      if (i1 < i)
      {
        j = i1;
        localObject1 = localView;
      }
      m = j;
      localObject3 = localObject1;
      if (i1 <= k) {
        break label180;
      }
      localObject2 = localView;
      i = j;
      j = i1;
    }
    for (;;)
    {
      n += 1;
      k = j;
      break;
      if ((localObject1 == null) || (localObject2 == null)) {
        return 1.0F;
      }
      j = Math.min(paramaj.bo(localObject1), paramaj.bo(localObject2));
      j = Math.max(paramaj.bp(localObject1), paramaj.bp(localObject2)) - j;
      if (j == 0) {
        return 1.0F;
      }
      return j * 1.0F / (k - i + 1);
      label180:
      j = k;
      i = m;
      localObject1 = localObject3;
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
  
  public int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    if (!(paramLayoutManager instanceof RecyclerView.r.b)) {
      paramInt2 = -1;
    }
    int j;
    label152:
    label170:
    label175:
    label180:
    do
    {
      return paramInt2;
      j = paramLayoutManager.getItemCount();
      if (j == 0) {
        return -1;
      }
      Object localObject = a(paramLayoutManager);
      if (localObject == null) {
        return -1;
      }
      int k = paramLayoutManager.getPosition((View)localObject);
      if (k == -1) {
        return -1;
      }
      localObject = ((RecyclerView.r.b)paramLayoutManager).bZ(j - 1);
      if (localObject == null) {
        return -1;
      }
      if (paramLayoutManager.canScrollHorizontally())
      {
        int i = a(paramLayoutManager, c(paramLayoutManager), paramInt1, 0);
        paramInt1 = i;
        if (((PointF)localObject).x < 0.0F) {
          paramInt1 = -i;
        }
        if (!paramLayoutManager.canScrollVertically()) {
          break label170;
        }
        i = a(paramLayoutManager, b(paramLayoutManager), 0, paramInt2);
        paramInt2 = i;
        if (((PointF)localObject).y < 0.0F) {
          paramInt2 = -i;
        }
        if (!paramLayoutManager.canScrollVertically()) {
          break label175;
        }
      }
      for (;;)
      {
        if (paramInt2 != 0) {
          break label180;
        }
        return -1;
        paramInt1 = 0;
        break;
        paramInt2 = 0;
        break label152;
        paramInt2 = paramInt1;
      }
      paramInt2 = k + paramInt2;
      paramInt1 = paramInt2;
      if (paramInt2 < 0) {
        paramInt1 = 0;
      }
      paramInt2 = paramInt1;
    } while (paramInt1 < j);
    return j - 1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.af
 * JD-Core Version:    0.7.0.1
 */