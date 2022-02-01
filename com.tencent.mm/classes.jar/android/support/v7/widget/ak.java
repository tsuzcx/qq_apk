package android.support.v7.widget;

import android.graphics.PointF;
import android.view.View;

public class ak
  extends at
{
  private aj anY;
  private aj anZ;
  
  private static int a(RecyclerView.i parami, View paramView, aj paramaj)
  {
    int j = paramaj.bn(paramView);
    int k = paramaj.br(paramView) / 2;
    if (parami.getClipToPadding()) {}
    for (int i = paramaj.kd() + paramaj.kf() / 2;; i = paramaj.getEnd() / 2) {
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
      j = paramaj.kd() + paramaj.kf() / 2;
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
  
  private aj b(RecyclerView.i parami)
  {
    if ((this.anY == null) || (this.anY.aoI != parami)) {
      this.anY = aj.e(parami);
    }
    return this.anY;
  }
  
  private aj c(RecyclerView.i parami)
  {
    if ((this.anZ == null) || (this.anZ.aoI != parami)) {
      this.anZ = aj.d(parami);
    }
    return this.anZ;
  }
  
  private static View c(RecyclerView.i parami, aj paramaj)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int m = parami.getChildCount();
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
    localObject2 = parami.getChildAt(j);
    int k = paramaj.bn((View)localObject2);
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
  
  public int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = parami.getItemCount();
    if (k == 0) {}
    View localView;
    label37:
    int j;
    do
    {
      return -1;
      localView = null;
      if (!parami.jF()) {
        break;
      }
      localView = c(parami, b(parami));
      if (localView == null) {
        break label154;
      }
      j = RecyclerView.i.bB(localView);
    } while (j == -1);
    if (parami.jE()) {
      if (paramInt1 > 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      paramInt2 = i;
      if ((parami instanceof RecyclerView.r.b))
      {
        parami = ((RecyclerView.r.b)parami).bZ(k - 1);
        paramInt2 = i;
        if (parami != null) {
          if (parami.x >= 0.0F)
          {
            paramInt2 = i;
            if (parami.y >= 0.0F) {}
          }
          else
          {
            paramInt2 = 1;
          }
        }
      }
      if (paramInt2 == 0) {
        break label178;
      }
      if (paramInt1 == 0) {
        break label175;
      }
      return j - 1;
      if (!parami.jE()) {
        break label37;
      }
      localView = c(parami, c(parami));
      break label37;
      label154:
      break;
      paramInt1 = 0;
      continue;
      if (paramInt2 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    label175:
    return j;
    label178:
    if (paramInt1 != 0) {
      return j + 1;
    }
    return j;
  }
  
  public View a(RecyclerView.i parami)
  {
    if (parami.jF()) {
      return a(parami, b(parami));
    }
    if (parami.jE()) {
      return a(parami, c(parami));
    }
    return null;
  }
  
  public int[] a(RecyclerView.i parami, View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (parami.jE()) {
      arrayOfInt[0] = a(parami, paramView, c(parami));
    }
    while (parami.jF())
    {
      arrayOfInt[1] = a(parami, paramView, b(parami));
      return arrayOfInt;
      arrayOfInt[0] = 0;
    }
    arrayOfInt[1] = 0;
    return arrayOfInt;
  }
  
  protected final ae f(RecyclerView.i parami)
  {
    if (!(parami instanceof RecyclerView.r.b)) {
      return null;
    }
    return new ak.1(this, this.akA.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.ak
 * JD-Core Version:    0.7.0.1
 */