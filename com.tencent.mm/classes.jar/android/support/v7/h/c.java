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
  private static final Comparator<f> adc = new Comparator() {};
  
  public static b a(a parama)
  {
    return a(parama, true);
  }
  
  public static b a(a parama, boolean paramBoolean)
  {
    int i = parama.az();
    int j = parama.aA();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new e(i, j));
    i = i + j + Math.abs(i - j);
    int[] arrayOfInt1 = new int[i * 2];
    int[] arrayOfInt2 = new int[i * 2];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      e locale2 = (e)localArrayList2.remove(localArrayList2.size() - 1);
      f localf = a(parama, locale2.adn, locale2.ado, locale2.adp, locale2.adq, arrayOfInt1, arrayOfInt2, i);
      if (localf != null)
      {
        if (localf.size > 0) {
          localArrayList1.add(localf);
        }
        localf.x += locale2.adn;
        localf.y += locale2.adp;
        e locale1;
        if (localArrayList3.isEmpty())
        {
          locale1 = new e();
          label215:
          locale1.adn = locale2.adn;
          locale1.adp = locale2.adp;
          if (!localf.reverse) {
            break label360;
          }
          locale1.ado = localf.x;
          locale1.adq = localf.y;
          label263:
          localArrayList2.add(locale1);
          if (!localf.reverse) {
            break label455;
          }
          if (!localf.adm) {
            break label418;
          }
          locale2.adn = (localf.x + localf.size + 1);
          locale2.adp = (localf.y + localf.size);
        }
        for (;;)
        {
          localArrayList2.add(locale2);
          break;
          locale1 = (e)localArrayList3.remove(localArrayList3.size() - 1);
          break label215;
          label360:
          if (localf.adm)
          {
            locale1.ado = (localf.x - 1);
            locale1.adq = localf.y;
            break label263;
          }
          locale1.ado = localf.x;
          locale1.adq = (localf.y - 1);
          break label263;
          label418:
          locale2.adn = (localf.x + localf.size);
          locale2.adp = (localf.y + localf.size + 1);
          continue;
          label455:
          locale2.adn = (localf.x + localf.size);
          locale2.adp = (localf.y + localf.size);
        }
      }
      localArrayList3.add(locale2);
    }
    Collections.sort(localArrayList1, adc);
    return new b(parama, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static f a(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
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
          while ((k < n) && (paramInt2 < i1) && (parama.i(paramInt1 + k, paramInt3 + paramInt2)))
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
          parama = new f();
          parama.x = paramArrayOfInt2[(paramInt5 + j)];
          parama.y = (parama.x - j);
          parama.size = (paramArrayOfInt1[(paramInt5 + j)] - paramArrayOfInt2[(paramInt5 + j)]);
          parama.adm = bool;
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
          while ((k > 0) && (paramInt2 > 0) && (parama.i(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
          {
            k -= 1;
            paramInt2 -= 1;
          }
          paramInt2 = paramArrayOfInt2[(paramInt5 + i4 + 1)] - 1;
        }
        paramArrayOfInt2[(paramInt5 + i4)] = k;
        if ((paramInt4 == 0) && (j + i2 >= -i) && (j + i2 <= i) && (paramArrayOfInt1[(paramInt5 + i4)] >= paramArrayOfInt2[(paramInt5 + i4)]))
        {
          parama = new f();
          parama.x = paramArrayOfInt2[(paramInt5 + i4)];
          parama.y = (parama.x - i4);
          parama.size = (paramArrayOfInt1[(paramInt5 + i4)] - paramArrayOfInt2[(paramInt5 + i4)]);
          parama.adm = bool;
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
    public abstract int aA();
    
    public abstract int az();
    
    public Object h(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract boolean i(int paramInt1, int paramInt2);
    
    public abstract boolean j(int paramInt1, int paramInt2);
  }
  
  public static final class b
  {
    private final List<c.f> add;
    private final int[] ade;
    private final int[] adf;
    private final c.a adg;
    private final int adh;
    private final int adi;
    private final boolean adj;
    
    b(c.a parama, List<c.f> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      this.add = paramList;
      this.ade = paramArrayOfInt1;
      this.adf = paramArrayOfInt2;
      Arrays.fill(this.ade, 0);
      Arrays.fill(this.adf, 0);
      this.adg = parama;
      this.adh = parama.az();
      this.adi = parama.aA();
      this.adj = paramBoolean;
      if (this.add.isEmpty()) {}
      for (parama = null;; parama = (c.f)this.add.get(0))
      {
        if ((parama == null) || (parama.x != 0) || (parama.y != 0))
        {
          parama = new c.f();
          parama.x = 0;
          parama.y = 0;
          parama.adm = false;
          parama.size = 0;
          parama.reverse = false;
          this.add.add(0, parama);
        }
        hr();
        return;
      }
    }
    
    private static c.d a(List<c.d> paramList, int paramInt, boolean paramBoolean)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        c.d locald2 = (c.d)paramList.get(i);
        if ((locald2.adk == paramInt) && (locald2.adm == paramBoolean))
        {
          paramList.remove(i);
          paramInt = i;
          locald1 = locald2;
          if (paramInt >= paramList.size()) {
            break label123;
          }
          locald1 = (c.d)paramList.get(paramInt);
          int j = locald1.adl;
          if (paramBoolean) {}
          for (i = 1;; i = -1)
          {
            locald1.adl = (i + j);
            paramInt += 1;
            break;
          }
        }
        i -= 1;
      }
      c.d locald1 = null;
      label123:
      return locald1;
    }
    
    private void a(List<c.d> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.adj) {
        paramd.f(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = this.adf[(paramInt3 + paramInt2)] & 0x1F;
      Iterator localIterator;
      switch (i)
      {
      default: 
        throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
      case 0: 
        paramd.f(paramInt1, 1);
        localIterator = paramList.iterator();
      case 4: 
      case 8: 
        while (localIterator.hasNext())
        {
          c.d locald = (c.d)localIterator.next();
          locald.adl += 1;
          continue;
          int j = this.adf[(paramInt3 + paramInt2)] >> 5;
          paramd.l(a(paramList, j, true).adl, paramInt1);
          if (i == 4) {
            paramd.c(paramInt1, 1, this.adg.h(j, paramInt3 + paramInt2));
          }
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        paramList.add(new c.d(paramInt3 + paramInt2, paramInt1, false));
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
        c.f localf = (c.f)this.add.get(paramInt3);
        m = localf.x;
        int n = localf.size;
        int i1 = localf.y;
        int i2 = localf.size;
        if (paramBoolean)
        {
          paramInt2 = i - 1;
          for (;;)
          {
            if (paramInt2 < m + n) {
              break label259;
            }
            if (this.adg.i(paramInt2, j))
            {
              if (this.adg.j(paramInt2, j)) {}
              for (paramInt1 = 8;; paramInt1 = 4)
              {
                this.adf[j] = (paramInt2 << 5 | 0x10);
                this.ade[paramInt2] = (paramInt1 | j << 5);
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
          if (this.adg.i(j, paramInt2))
          {
            if (this.adg.j(j, paramInt2)) {}
            for (paramInt3 = k;; paramInt3 = 4)
            {
              this.ade[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
              this.adf[paramInt2] = (paramInt3 | paramInt1 - 1 << 5);
              return true;
            }
          }
          paramInt2 -= 1;
        }
        label259:
        i = localf.x;
        paramInt2 = localf.y;
        paramInt3 -= 1;
      }
      return false;
    }
    
    private void b(List<c.d> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.adj) {
        paramd.k(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = this.ade[(paramInt3 + paramInt2)] & 0x1F;
      Object localObject;
      switch (i)
      {
      default: 
        throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
      case 0: 
        paramd.k(paramInt1 + paramInt2, 1);
        localObject = paramList.iterator();
      case 4: 
      case 8: 
        while (((Iterator)localObject).hasNext())
        {
          c.d locald = (c.d)((Iterator)localObject).next();
          locald.adl -= 1;
          continue;
          int j = this.ade[(paramInt3 + paramInt2)] >> 5;
          localObject = a(paramList, j, false);
          paramd.l(paramInt1 + paramInt2, ((c.d)localObject).adl - 1);
          if (i == 4) {
            paramd.c(((c.d)localObject).adl - 1, 1, this.adg.h(paramInt3 + paramInt2, j));
          }
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        paramList.add(new c.d(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
      }
    }
    
    private void hr()
    {
      int j = this.adh;
      int i = this.adi;
      int k = this.add.size() - 1;
      while (k >= 0)
      {
        c.f localf = (c.f)this.add.get(k);
        int i2 = localf.x;
        int i3 = localf.size;
        int n = localf.y;
        int i1 = localf.size;
        int m;
        if (this.adj)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + i3) {
              break;
            }
            if (this.ade[(j - 1)] == 0) {
              a(j, i, k, false);
            }
            j -= 1;
          }
          while (m > n + i1)
          {
            if (this.adf[(m - 1)] == 0) {
              a(j, m, k, true);
            }
            m -= 1;
          }
        }
        i = 0;
        if (i < localf.size)
        {
          m = localf.x + i;
          n = localf.y + i;
          if (this.adg.j(m, n)) {}
          for (j = 1;; j = 2)
          {
            this.ade[m] = (n << 5 | j);
            this.adf[n] = (j | m << 5);
            i += 1;
            break;
          }
        }
        j = localf.x;
        i = localf.y;
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
        j = this.adh;
        k = this.adi;
        i = this.add.size() - 1;
      }
      for (;;)
      {
        if (i < 0) {
          break label234;
        }
        c.f localf = (c.f)this.add.get(i);
        int m = localf.size;
        int n = localf.x + m;
        int i1 = localf.y + m;
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
            if ((this.ade[(localf.x + j)] & 0x1F) == 2) {
              paramd.c(localf.x + j, 1, this.adg.h(localf.x + j, localf.y + j));
            }
            j -= 1;
            continue;
            paramd = new b(paramd);
            break;
          }
        }
        j = localf.x;
        k = localf.y;
        i -= 1;
      }
      label234:
      paramd.hq();
    }
    
    public final void a(RecyclerView.a parama)
    {
      a(new a(parama));
    }
  }
  
  static final class d
  {
    int adk;
    int adl;
    boolean adm;
    
    public d(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.adk = paramInt1;
      this.adl = paramInt2;
      this.adm = paramBoolean;
    }
  }
  
  static final class e
  {
    int adn;
    int ado;
    int adp;
    int adq;
    
    public e() {}
    
    public e(int paramInt1, int paramInt2)
    {
      this.adn = 0;
      this.ado = paramInt1;
      this.adp = 0;
      this.adq = paramInt2;
    }
  }
  
  static final class f
  {
    boolean adm;
    boolean reverse;
    int size;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.h.c
 * JD-Core Version:    0.7.0.1
 */