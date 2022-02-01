package android.support.v7.widget;

import android.graphics.PointF;
import android.view.View;

public class af
  extends at
{
  private aj aqL;
  private aj aqM;
  
  private int a(RecyclerView.i parami, aj paramaj, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = aI(paramInt1, paramInt2);
    float f = b(parami, paramaj);
    if (f <= 0.0F) {
      return 0;
    }
    if (Math.abs(arrayOfInt[0]) > Math.abs(arrayOfInt[1])) {}
    for (paramInt1 = arrayOfInt[0];; paramInt1 = arrayOfInt[1]) {
      return Math.round(paramInt1 / f);
    }
  }
  
  private static int a(RecyclerView.i parami, View paramView, aj paramaj)
  {
    int j = paramaj.bn(paramView);
    int k = paramaj.br(paramView) / 2;
    if (parami.getClipToPadding()) {}
    for (int i = paramaj.kB() + paramaj.kD() / 2;; i = paramaj.getEnd() / 2) {
      return k + j - i;
    }
  }
  
  private static View a(RecyclerView.i parami, aj paramaj)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int n = parami.getChildCount();
    if (n == 0) {}
    int j;
    int i;
    int k;
    label45:
    do
    {
      return localObject2;
      if (!parami.getClipToPadding()) {
        break;
      }
      j = paramaj.kB() + paramaj.kD() / 2;
      i = 2147483647;
      k = 0;
      localObject2 = localObject1;
    } while (k >= n);
    localObject2 = parami.getChildAt(k);
    int m = Math.abs(paramaj.bn((View)localObject2) + paramaj.br((View)localObject2) / 2 - j);
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
  
  private static float b(RecyclerView.i parami, aj paramaj)
  {
    int i = 2147483647;
    int k = -2147483648;
    int i2 = parami.getChildCount();
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
      View localView = parami.getChildAt(n);
      int i1 = RecyclerView.i.bB(localView);
      m = i;
      localObject3 = localObject1;
      if (i1 == -1) {
        break label179;
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
        break label179;
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
      j = Math.min(paramaj.bn(localObject1), paramaj.bn(localObject2));
      j = Math.max(paramaj.bo(localObject1), paramaj.bo(localObject2)) - j;
      if (j == 0) {
        return 1.0F;
      }
      return j * 1.0F / (k - i + 1);
      label179:
      j = k;
      i = m;
      localObject1 = localObject3;
    }
  }
  
  private aj b(RecyclerView.i parami)
  {
    if ((this.aqL == null) || (this.aqL.arw != parami)) {
      this.aqL = aj.e(parami);
    }
    return this.aqL;
  }
  
  private aj c(RecyclerView.i parami)
  {
    if ((this.aqM == null) || (this.aqM.arw != parami)) {
      this.aqM = aj.d(parami);
    }
    return this.aqM;
  }
  
  public int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    if (!(parami instanceof RecyclerView.s.b)) {
      paramInt2 = -1;
    }
    int j;
    label151:
    label169:
    label174:
    label179:
    do
    {
      return paramInt2;
      j = parami.getItemCount();
      if (j == 0) {
        return -1;
      }
      Object localObject = a(parami);
      if (localObject == null) {
        return -1;
      }
      int k = RecyclerView.i.bB((View)localObject);
      if (k == -1) {
        return -1;
      }
      localObject = ((RecyclerView.s.b)parami).bZ(j - 1);
      if (localObject == null) {
        return -1;
      }
      if (parami.kc())
      {
        int i = a(parami, c(parami), paramInt1, 0);
        paramInt1 = i;
        if (((PointF)localObject).x < 0.0F) {
          paramInt1 = -i;
        }
        if (!parami.kd()) {
          break label169;
        }
        i = a(parami, b(parami), 0, paramInt2);
        paramInt2 = i;
        if (((PointF)localObject).y < 0.0F) {
          paramInt2 = -i;
        }
        if (!parami.kd()) {
          break label174;
        }
      }
      for (;;)
      {
        if (paramInt2 != 0) {
          break label179;
        }
        return -1;
        paramInt1 = 0;
        break;
        paramInt2 = 0;
        break label151;
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
  
  public View a(RecyclerView.i parami)
  {
    if (parami.kd()) {
      return a(parami, b(parami));
    }
    if (parami.kc()) {
      return a(parami, c(parami));
    }
    return null;
  }
  
  public int[] a(RecyclerView.i parami, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (parami.kc()) {
      arrayOfInt[0] = a(parami, paramView, c(parami));
    }
    while (parami.kd())
    {
      arrayOfInt[1] = a(parami, paramView, b(parami));
      return arrayOfInt;
      arrayOfInt[0] = 0;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.af
 * JD-Core Version:    0.7.0.1
 */