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
  private static final Comparator<e> aap = new Comparator() {};
  
  public static b a(a parama, boolean paramBoolean)
  {
    int i = parama.gR();
    int j = parama.gS();
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
      e locale = a(parama, locald2.aaA, locald2.aaB, locald2.aaC, locald2.aaD, arrayOfInt1, arrayOfInt2, i);
      if (locale != null)
      {
        if (locale.size > 0) {
          localArrayList1.add(locale);
        }
        locale.x += locald2.aaA;
        locale.y += locald2.aaC;
        d locald1;
        if (localArrayList3.isEmpty())
        {
          locald1 = new d();
          label215:
          locald1.aaA = locald2.aaA;
          locald1.aaC = locald2.aaC;
          if (!locale.reverse) {
            break label360;
          }
          locald1.aaB = locale.x;
          locald1.aaD = locale.y;
          label263:
          localArrayList2.add(locald1);
          if (!locale.reverse) {
            break label455;
          }
          if (!locale.aaz) {
            break label418;
          }
          locald2.aaA = (locale.x + locale.size + 1);
          locald2.aaC = (locale.y + locale.size);
        }
        for (;;)
        {
          localArrayList2.add(locald2);
          break;
          locald1 = (d)localArrayList3.remove(localArrayList3.size() - 1);
          break label215;
          label360:
          if (locale.aaz)
          {
            locald1.aaB = (locale.x - 1);
            locald1.aaD = locale.y;
            break label263;
          }
          locald1.aaB = locale.x;
          locald1.aaD = (locale.y - 1);
          break label263;
          label418:
          locald2.aaA = (locale.x + locale.size);
          locald2.aaC = (locale.y + locale.size + 1);
          continue;
          label455:
          locald2.aaA = (locale.x + locale.size);
          locald2.aaC = (locale.y + locale.size);
        }
      }
      localArrayList3.add(locald2);
    }
    Collections.sort(localArrayList1, aap);
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
          parama.aaz = bool;
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
          parama.aaz = bool;
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
    
    public abstract int gR();
    
    public abstract int gS();
  }
  
  public static final class b
  {
    private final List<c.e> aaq;
    private final int[] aar;
    private final int[] aas;
    private final c.a aat;
    private final int aau;
    private final int aav;
    private final boolean aaw;
    
    b(c.a parama, List<c.e> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      this.aaq = paramList;
      this.aar = paramArrayOfInt1;
      this.aas = paramArrayOfInt2;
      Arrays.fill(this.aar, 0);
      Arrays.fill(this.aas, 0);
      this.aat = parama;
      this.aau = parama.gR();
      this.aav = parama.gS();
      this.aaw = paramBoolean;
      if (this.aaq.isEmpty()) {}
      for (parama = null;; parama = (c.e)this.aaq.get(0))
      {
        if ((parama == null) || (parama.x != 0) || (parama.y != 0))
        {
          parama = new c.e();
          parama.x = 0;
          parama.y = 0;
          parama.aaz = false;
          parama.size = 0;
          parama.reverse = false;
          this.aaq.add(0, parama);
        }
        gT();
        return;
      }
    }
    
    private static c.c a(List<c.c> paramList, int paramInt, boolean paramBoolean)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        c.c localc2 = (c.c)paramList.get(i);
        if ((localc2.aax == paramInt) && (localc2.aaz == paramBoolean))
        {
          paramList.remove(i);
          paramInt = i;
          localc1 = localc2;
          if (paramInt >= paramList.size()) {
            break label123;
          }
          localc1 = (c.c)paramList.get(paramInt);
          int j = localc1.aay;
          if (paramBoolean) {}
          for (i = 1;; i = -1)
          {
            localc1.aay = (i + j);
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
      if (!this.aaw) {
        paramd.E(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = this.aas[(paramInt3 + paramInt2)] & 0x1F;
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
          localc.aay += 1;
          continue;
          int j = this.aas[(paramInt3 + paramInt2)] >> 5;
          paramd.G(a(paramList, j, true).aay, paramInt1);
          if (i == 4) {
            paramd.c(paramInt1, 1, this.aat.J(j, paramInt3 + paramInt2));
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
        c.e locale = (c.e)this.aaq.get(paramInt3);
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
            if (this.aat.H(paramInt2, j))
            {
              if (this.aat.I(paramInt2, j)) {}
              for (paramInt1 = 8;; paramInt1 = 4)
              {
                this.aas[j] = (paramInt2 << 5 | 0x10);
                this.aar[paramInt2] = (paramInt1 | j << 5);
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
          if (this.aat.H(j, paramInt2))
          {
            if (this.aat.I(j, paramInt2)) {}
            for (paramInt3 = k;; paramInt3 = 4)
            {
              this.aar[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
              this.aas[paramInt2] = (paramInt3 | paramInt1 - 1 << 5);
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
      if (!this.aaw) {
        paramd.F(paramInt1, paramInt2);
      }
      do
      {
        return;
        paramInt2 -= 1;
      } while (paramInt2 < 0);
      int i = this.aar[(paramInt3 + paramInt2)] & 0x1F;
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
          localc.aay -= 1;
          continue;
          int j = this.aar[(paramInt3 + paramInt2)] >> 5;
          localObject = a(paramList, j, false);
          paramd.G(paramInt1 + paramInt2, ((c.c)localObject).aay - 1);
          if (i == 4) {
            paramd.c(((c.c)localObject).aay - 1, 1, this.aat.J(paramInt3 + paramInt2, j));
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
    
    private void gT()
    {
      int j = this.aau;
      int i = this.aav;
      int k = this.aaq.size() - 1;
      while (k >= 0)
      {
        c.e locale = (c.e)this.aaq.get(k);
        int i2 = locale.x;
        int i3 = locale.size;
        int n = locale.y;
        int i1 = locale.size;
        int m;
        if (this.aaw)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + i3) {
              break;
            }
            if (this.aar[(j - 1)] == 0) {
              a(j, i, k, false);
            }
            j -= 1;
          }
          while (m > n + i1)
          {
            if (this.aas[(m - 1)] == 0) {
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
          if (this.aat.I(m, n)) {}
          for (j = 1;; j = 2)
          {
            this.aar[m] = (n << 5 | j);
            this.aas[n] = (j | m << 5);
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
        j = this.aau;
        k = this.aav;
        i = this.aaq.size() - 1;
      }
      for (;;)
      {
        if (i < 0) {
          break label234;
        }
        c.e locale = (c.e)this.aaq.get(i);
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
            if ((this.aar[(locale.x + j)] & 0x1F) == 2) {
              paramd.c(locale.x + j, 1, this.aat.J(locale.x + j, locale.y + j));
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
      paramd.gQ();
    }
    
    public final void a(RecyclerView.a parama)
    {
      a(new a(parama));
    }
  }
  
  static final class c
  {
    int aax;
    int aay;
    boolean aaz;
    
    public c(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.aax = paramInt1;
      this.aay = paramInt2;
      this.aaz = paramBoolean;
    }
  }
  
  static final class d
  {
    int aaA;
    int aaB;
    int aaC;
    int aaD;
    
    public d() {}
    
    public d(int paramInt1, int paramInt2)
    {
      this.aaA = 0;
      this.aaB = paramInt1;
      this.aaC = 0;
      this.aaD = paramInt2;
    }
  }
  
  static final class e
  {
    boolean aaz;
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