package androidx.recyclerview.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$b
{
  final SparseIntArray ahO = new SparseIntArray();
  private boolean ahP = false;
  
  public int am(int paramInt1, int paramInt2)
  {
    int n = cx(paramInt1);
    if (n == paramInt2) {
      return 0;
    }
    int j;
    int i;
    int k;
    if ((this.ahP) && (this.ahO.size() > 0))
    {
      j = this.ahO.size() - 1;
      i = 0;
      while (i <= j)
      {
        k = i + j >>> 1;
        if (this.ahO.keyAt(k) < paramInt1) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      i -= 1;
      if ((i >= 0) && (i < this.ahO.size()))
      {
        i = this.ahO.keyAt(i);
        if (i < 0) {
          break label216;
        }
        j = this.ahO.get(i) + cx(i);
        k = i + 1;
        i = j;
        j = k;
      }
    }
    for (;;)
    {
      label149:
      if (j < paramInt1)
      {
        k = cx(j);
        int m = i + k;
        if (m == paramInt2) {
          i = 0;
        }
        for (;;)
        {
          j += 1;
          break label149;
          i = -1;
          break;
          i = k;
          if (m <= paramInt2) {
            i = m;
          }
        }
      }
      if (i + n > paramInt2) {
        break;
      }
      return i;
      label216:
      j = 0;
      i = 0;
    }
  }
  
  final int an(int paramInt1, int paramInt2)
  {
    int i;
    if (!this.ahP) {
      i = am(paramInt1, paramInt2);
    }
    int j;
    do
    {
      return i;
      j = this.ahO.get(paramInt1, -1);
      i = j;
    } while (j != -1);
    paramInt2 = am(paramInt1, paramInt2);
    this.ahO.put(paramInt1, paramInt2);
    return paramInt2;
  }
  
  public final int ao(int paramInt1, int paramInt2)
  {
    int n = cx(paramInt1);
    int k = 0;
    int i = 0;
    int j = 0;
    int m;
    if (k < paramInt1)
    {
      m = cx(k);
      j += m;
      if (j == paramInt2)
      {
        j = i + 1;
        i = 0;
      }
    }
    for (;;)
    {
      k += 1;
      m = i;
      i = j;
      j = m;
      break;
      if (j > paramInt2)
      {
        j = i + 1;
        i = m;
        continue;
        paramInt1 = i;
        if (j + n > paramInt2) {
          paramInt1 = i + 1;
        }
        return paramInt1;
      }
      else
      {
        m = j;
        j = i;
        i = m;
      }
    }
  }
  
  public abstract int cx(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.recyclerview.widget.GridLayoutManager.b
 * JD-Core Version:    0.7.0.1
 */