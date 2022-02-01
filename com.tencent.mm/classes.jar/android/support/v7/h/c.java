package android.support.v7.h;

import android.support.v7.widget.RecyclerView.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class c
{
  private static final Comparator<e> abl = new Comparator() {};
  
  public static b a(a parama, boolean paramBoolean)
  {
    int i = parama.gZ();
    int j = parama.ha();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new d(i, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      d locald2 = (d)localArrayList2.remove(localArrayList2.size() - 1);
      e locale = a(parama, locald2.abw, locald2.abx, locald2.aby, locald2.abz, arrayOfInt1, arrayOfInt2, i);
      if (locale != null)
      {
        if (locale.size > 0) {
          localArrayList1.add(locale);
        }
        locale.x += locald2.abw;
        locale.y += locald2.aby;
        d locald1;
        if (localArrayList3.isEmpty())
        {
          locald1 = new d();
          label215:
          locald1.abw = locald2.abw;
          locald1.aby = locald2.aby;
          if (!locale.reverse) {
            break label360;
          }
          locald1.abx = locale.x;
          locald1.abz = locale.y;
          label263:
          localArrayList2.add(locald1);
          if (!locale.reverse) {
            break label455;
          }
          if (!locale.abv) {
            break label418;
          }
          locald2.abw = (locale.x + locale.size + 1);
          locald2.aby = (locale.y + locale.size);
        }
        for (;;)
        {
          localArrayList2.add(locald2);
          break;
          locald1 = (d)localArrayList3.remove(localArrayList3.size() - 1);
          break label215;
          label360:
          if (locale.abv)
          {
            locald1.abx = (locale.x - 1);
            locald1.abz = locale.y;
            break label263;
          }
          locald1.abx = locale.x;
          locald1.abz = (locale.y - 1);
          break label263;
          label418:
          locald2.abw = (locale.x + locale.size);
          locald2.aby = (locale.y + locale.size + 1);
          continue;
          label455:
          locald2.abw = (locale.x + locale.size);
          locald2.aby = (locale.y + locale.size);
        }
      }
      localArrayList3.add(locald2);
    }
    Collections.sort(localArrayList1, abl);
    return new b(parama, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static e a(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    int n = paramInt2 - paramInt1;
    int i1 = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 <= 0) || (paramInt4 - paramInt3 <= 0)) {
      return null;
    }
    int i2 = n - i1;
    int i3 = (n + i1 + 1) / 2;
    Arrays.fill(paramArrayOfInt1, paramInt5 - i3 - 1, paramInt5 + i3 + 1, 0);
    Arrays.fill(paramArrayOfInt2, paramInt5 - i3 - 1 + i2, paramInt5 + i3 + 1 + i2, n);
    int i;
    if (i2 % 2 != 0)
    {
      paramInt4 = 1;
      i = 0;
    }
    for (;;)
    {
      if (i > i3) {
        break label670;
      }
      int j = -i;
      boolean bool;
      int m;
      int k;
      for (;;)
      {
        if (j > i) {
          break label384;
        }
        if ((j == -i) || ((j != i) && (paramArrayOfInt1[(paramInt5 + j - 1)] < paramArrayOfInt1[(paramInt5 + j + 1)]))) {
          paramInt2 = paramArrayOfInt1[(paramInt5 + j + 1)];
        }
        for (bool = false;; bool = true)
        {
          m = paramInt2 - j;
          k = paramInt2;
          paramInt2 = m;
          while ((k < n) && (paramInt2 < i1) && (parama.H(paramInt1 + k, paramInt3 + paramInt2)))
          {
            k += 1;
            paramInt2 += 1;
          }
          paramInt4 = 0;
          break;
          paramInt2 = paramArrayOfInt1[(paramInt5 + j - 1)] + 1;
        }
        paramArrayOfInt1[(paramInt5 + j)] = k;
        if ((paramInt4 != 0) && (j >= i2 - i + 1) && (j <= i2 + i - 1) && (paramArrayOfInt1[(paramInt5 + j)] >= paramArrayOfInt2[(paramInt5 + j)]))
        {
          parama = new e();
          parama.x = paramArrayOfInt2[(paramInt5 + j)];
          parama.y = (parama.x - j);
          parama.size = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          parama.abv = bool;
          parama.reverse = false;
          return parama;
        }
        j += 2;
      }
      label384:
      j = -i;
      while (j <= i)
      {
        int i4 = j + i2;
        if ((i4 == i + i2) || ((i4 != -i + i2) && (paramArrayOfInt2[(paramInt5 + i4 - 1)] < paramArrayOfInt2[(paramInt5 + i4 + 1)]))) {
          paramInt2 = paramArrayOfInt2[(paramInt5 + i4 - 1)];
        }
        for (bool = false;; bool = true)
        {
          m = paramInt2 - i4;
          k = paramInt2;
          paramInt2 = m;
          while ((k > 0) && (paramInt2 > 0) && (parama.H(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i4 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i4)] = k;
        if ((paramInt4 == 0) && (j + i2 >= -i) && (j + i2 <= i) && (paramArrayOfInt1[(paramInt5 + i4)] >= paramArrayOfInt2[(paramInt5 + i4)]))
        {
          parama = new e();
          parama.x = paramArrayOfInt2[(paramInt5 + i4)];
          parama.y = (parama.x - i4);
          parama.size = (paramArrayOfInt1[(paramInt5 + i4)] - paramArrayOfInt2[(paramInt5 + i4)]);
          parama.abv = bool;
          parama.reverse = true;
          return parama;
        }
        j += 2;
      }
      i += 1;
    }
    label670:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
  
  public static abstract class a
  {
    public abstract boolean H(int paramInt1, int paramInt2);
    
    public abstract boolean I(int paramInt1, int paramInt2);
    
    public Object J(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract int gZ();
    
    public abstract int ha();
  }
  
  public static final class b
  {
    private final List<c.e> abm;
    private final int[] abn;
    private final int[] abo;
    private final c.a abp;
    private final int abq;
    private final int abr;
    private final boolean abs;
    
    b(c.a parama, List<c.e> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      this.abm = paramList;
      this.abn = paramArrayOfInt1;
      this.abo = paramArrayOfInt2;
      Arrays.fill(this.abn, 0);
      Arrays.fill(this.abo, 0);
      this.abp = parama;
      this.abq = parama.gZ();
      this.abr = parama.ha();
      this.abs = paramBoolean;
      if (this.abm.isEmpty()) {}
      for (parama = null;; parama = (c.e)this.abm.get(0))
      {
        if ((parama == null) || (parama.x != 0) || (parama.y != 0))
        {
          parama = new c.e();
          parama.x = 0;
          parama.y = 0;
          parama.abv = false;
          parama.size = 0;
          parama.reverse = false;
          this.abm.add(0, parama);
        }
        hb();
        return;
      }
    }
    
    private static c.c a(List<c.c> paramList, int paramInt, boolean paramBoolean)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        c.c localc2 = (c.c)paramList.get(i);
        if ((localc2.abt == paramInt) && (localc2.abv == paramBoolean))
        {
          paramList.remove(i);
          paramInt = i;
          localc1 = localc2;
          if (paramInt >= paramList.size()) {
            break label123;
          }
          localc1 = (c.c)paramList.get(paramInt);
          int j = localc1.abu;
          if (paramBoolean) {}
          for (i = 1;; i = -1)
          {
            localc1.abu = (i + j);
            paramInt += 1;
            break;
          }
        }
        i -= 1;
      }
      c.c localc1 = null;
      label123:
      return localc1;
    }
    
    private void a(List<c.c> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.abs) {
        paramd.E(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = this.abo[(paramInt3 + paramInt2)] & 0x1F;
      Iterator localIterator;
      switch (i)
      {
      default: 
        throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
      case 0: 
        paramd.E(paramInt1, 1);
        localIterator = paramList.iterator();
      case 4: 
      case 8: 
        while (localIterator.hasNext())
        {
          c.c localc = (c.c)localIterator.next();
          localc.abu += 1;
          continue;
          int j = this.abo[(paramInt3 + paramInt2)] >> 5;
          paramd.G(a(paramList, j, true).abu, paramInt1);
          if (i == 4) {
            paramd.c(paramInt1, 1, this.abp.J(j, paramInt3 + paramInt2));
          }
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        paramList.add(new c.c(paramInt3 + paramInt2, paramInt1, false));
      }
    }
    
    private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int k = 8;
      int j;
      int i;
      int m;
      if (paramBoolean)
      {
        j = paramInt2 - 1;
        i = paramInt1;
        m = paramInt2 - 1;
        paramInt2 = j;
        j = m;
      }
      while (paramInt3 >= 0)
      {
        c.e locale = (c.e)this.abm.get(paramInt3);
        m = locale.x;
        int n = locale.size;
        int i1 = locale.y;
        int i2 = locale.size;
        if (paramBoolean)
        {
          paramInt2 = i - 1;
          for (;;)
          {
            if (paramInt2 < m + n) {
              break label259;
            }
            if (this.abp.H(paramInt2, j))
            {
              if (this.abp.I(paramInt2, j)) {}
              for (paramInt1 = 8;; paramInt1 = 4)
              {
                this.abo[j] = (paramInt2 << 5 | 0x10);
                this.abn[paramInt2] = (paramInt1 | j << 5);
                return true;
                j = paramInt1 - 1;
                i = paramInt1 - 1;
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
        paramInt2 -= 1;
        while (paramInt2 >= i1 + i2)
        {
          if (this.abp.H(j, paramInt2))
          {
            if (this.abp.I(j, paramInt2)) {}
            for (paramInt3 = k;; paramInt3 = 4)
            {
              this.abn[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
              this.abo[paramInt2] = (paramInt3 | paramInt1 - 1 << 5);
              return true;
            }
          }
          paramInt2 -= 1;
        }
        label259:
        i = locale.x;
        paramInt2 = locale.y;
        paramInt3 -= 1;
      }
      return false;
    }
    
    private void b(List<c.c> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.abs) {
        paramd.F(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = this.abn[(paramInt3 + paramInt2)] & 0x1F;
      Object localObject;
      switch (i)
      {
      default: 
        throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
      case 0: 
        paramd.F(paramInt1 + paramInt2, 1);
        localObject = paramList.iterator();
      case 4: 
      case 8: 
        while (((Iterator)localObject).hasNext())
        {
          c.c localc = (c.c)((Iterator)localObject).next();
          localc.abu -= 1;
          continue;
          int j = this.abn[(paramInt3 + paramInt2)] >> 5;
          localObject = a(paramList, j, false);
          paramd.G(paramInt1 + paramInt2, ((c.c)localObject).abu - 1);
          if (i == 4) {
            paramd.c(((c.c)localObject).abu - 1, 1, this.abp.J(paramInt3 + paramInt2, j));
          }
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        paramList.add(new c.c(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
      }
    }
    
    private void hb()
    {
      int j = this.abq;
      int i = this.abr;
      int k = this.abm.size() - 1;
      while (k >= 0)
      {
        c.e locale = (c.e)this.abm.get(k);
        int i2 = locale.x;
        int i3 = locale.size;
        int n = locale.y;
        int i1 = locale.size;
        int m;
        if (this.abs)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + i3) {
              break;
            }
            if (this.abn[(j - 1)] == 0) {
              a(j, i, k, false);
            }
            j -= 1;
          }
          while (m > n + i1)
          {
            if (this.abo[(m - 1)] == 0) {
              a(j, m, k, true);
            }
            m -= 1;
          }
        }
        i = 0;
        if (i < locale.size)
        {
          m = locale.x + i;
          n = locale.y + i;
          if (this.abp.I(m, n)) {}
          for (j = 1;; j = 2)
          {
            this.abn[m] = (n << 5 | j);
            this.abo[n] = (j | m << 5);
            i += 1;
            break;
          }
        }
        j = locale.x;
        i = locale.y;
        k -= 1;
      }
    }
    
    public final void a(d paramd)
    {
      ArrayList localArrayList;
      int j;
      int k;
      int i;
      if ((paramd instanceof b))
      {
        paramd = (b)paramd;
        localArrayList = new ArrayList();
        j = this.abq;
        k = this.abr;
        i = this.abm.size() - 1;
      }
      for (;;)
      {
        if (i < 0) {
          break label234;
        }
        c.e locale = (c.e)this.abm.get(i);
        int m = locale.size;
        int n = locale.x + m;
        int i1 = locale.y + m;
        if (n < j) {
          b(localArrayList, paramd, n, j - n, n);
        }
        if (i1 < k) {
          a(localArrayList, paramd, n, k - i1, i1);
        }
        j = m - 1;
        for (;;)
        {
          if (j >= 0)
          {
            if ((this.abn[(locale.x + j)] & 0x1F) == 2) {
              paramd.c(locale.x + j, 1, this.abp.J(locale.x + j, locale.y + j));
            }
            j -= 1;
            continue;
            paramd = new b(paramd);
            break;
          }
        }
        j = locale.x;
        k = locale.y;
        i -= 1;
      }
      label234:
      paramd.gY();
    }
    
    public final void a(RecyclerView.a parama)
    {
      a(new a(parama));
    }
  }
  
  static final class c
  {
    int abt;
    int abu;
    boolean abv;
    
    public c(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.abt = paramInt1;
      this.abu = paramInt2;
      this.abv = paramBoolean;
    }
  }
  
  static final class d
  {
    int abw;
    int abx;
    int aby;
    int abz;
    
    public d() {}
    
    public d(int paramInt1, int paramInt2)
    {
      this.abw = 0;
      this.abx = paramInt1;
      this.aby = 0;
      this.abz = paramInt2;
    }
  }
  
  static final class e
  {
    boolean abv;
    boolean reverse;
    int size;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.h.c
 * JD-Core Version:    0.7.0.1
 */