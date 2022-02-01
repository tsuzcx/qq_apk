package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static final Comparator<f> agD;
  
  static
  {
    AppMethodBeat.i(261056);
    agD = new Comparator() {};
    AppMethodBeat.o(261056);
  }
  
  public static b a(a parama)
  {
    AppMethodBeat.i(261046);
    parama = a(parama, true);
    AppMethodBeat.o(261046);
    return parama;
  }
  
  public static b a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(261048);
    int i = parama.jL();
    int j = parama.jM();
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
      f localf = a(parama, locale2.agO, locale2.agP, locale2.agQ, locale2.agR, arrayOfInt1, arrayOfInt2, i);
      if (localf != null)
      {
        if (localf.size > 0) {
          localArrayList1.add(localf);
        }
        localf.x += locale2.agO;
        localf.y += locale2.agQ;
        e locale1;
        if (localArrayList3.isEmpty())
        {
          locale1 = new e();
          label220:
          locale1.agO = locale2.agO;
          locale1.agQ = locale2.agQ;
          if (!localf.reverse) {
            break label365;
          }
          locale1.agP = localf.x;
          locale1.agR = localf.y;
          label268:
          localArrayList2.add(locale1);
          if (!localf.reverse) {
            break label460;
          }
          if (!localf.agN) {
            break label423;
          }
          locale2.agO = (localf.x + localf.size + 1);
          locale2.agQ = (localf.y + localf.size);
        }
        for (;;)
        {
          localArrayList2.add(locale2);
          break;
          locale1 = (e)localArrayList3.remove(localArrayList3.size() - 1);
          break label220;
          label365:
          if (localf.agN)
          {
            locale1.agP = (localf.x - 1);
            locale1.agR = localf.y;
            break label268;
          }
          locale1.agP = localf.x;
          locale1.agR = (localf.y - 1);
          break label268;
          label423:
          locale2.agO = (localf.x + localf.size);
          locale2.agQ = (localf.y + localf.size + 1);
          continue;
          label460:
          locale2.agO = (localf.x + localf.size);
          locale2.agQ = (localf.y + localf.size);
        }
      }
      localArrayList3.add(locale2);
    }
    Collections.sort(localArrayList1, agD);
    parama = new b(parama, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
    AppMethodBeat.o(261048);
    return parama;
  }
  
  private static f a(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    AppMethodBeat.i(261053);
    int n = paramInt2 - paramInt1;
    int i1 = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 <= 0) || (paramInt4 - paramInt3 <= 0))
    {
      AppMethodBeat.o(261053);
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
        break label690;
      }
      int j = -i;
      boolean bool;
      int m;
      int k;
      for (;;)
      {
        if (j > i) {
          break label399;
        }
        if ((j == -i) || ((j != i) && (paramArrayOfInt1[(paramInt5 + j - 1)] < paramArrayOfInt1[(paramInt5 + j + 1)]))) {
          paramInt2 = paramArrayOfInt1[(paramInt5 + j + 1)];
        }
        for (bool = false;; bool = true)
        {
          m = paramInt2 - j;
          k = paramInt2;
          paramInt2 = m;
          while ((k < n) && (paramInt2 < i1) && (parama.Z(paramInt1 + k, paramInt3 + paramInt2)))
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
          parama.agN = bool;
          parama.reverse = false;
          AppMethodBeat.o(261053);
          return parama;
        }
        j += 2;
      }
      label399:
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
          while ((k > 0) && (paramInt2 > 0) && (parama.Z(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
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
          parama.agN = bool;
          parama.reverse = true;
          AppMethodBeat.o(261053);
          return parama;
        }
        j += 2;
      }
      i += 1;
    }
    label690:
    parama = new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    AppMethodBeat.o(261053);
    throw parama;
  }
  
  public static abstract class a
  {
    public Object Y(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract boolean Z(int paramInt1, int paramInt2);
    
    public abstract boolean ab(int paramInt1, int paramInt2);
    
    public abstract int jL();
    
    public abstract int jM();
  }
  
  public static final class b
  {
    private final List<h.f> agE;
    public final int[] agF;
    private final int[] agG;
    private final h.a agH;
    private final int agI;
    private final int agJ;
    private final boolean agK;
    
    b(h.a parama, List<h.f> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(261011);
      this.agE = paramList;
      this.agF = paramArrayOfInt1;
      this.agG = paramArrayOfInt2;
      Arrays.fill(this.agF, 0);
      Arrays.fill(this.agG, 0);
      this.agH = parama;
      this.agI = parama.jL();
      this.agJ = parama.jM();
      this.agK = paramBoolean;
      if (this.agE.isEmpty()) {}
      for (parama = null;; parama = (h.f)this.agE.get(0))
      {
        if ((parama == null) || (parama.x != 0) || (parama.y != 0))
        {
          parama = new h.f();
          parama.x = 0;
          parama.y = 0;
          parama.agN = false;
          parama.size = 0;
          parama.reverse = false;
          this.agE.add(0, parama);
        }
        ko();
        AppMethodBeat.o(261011);
        return;
      }
    }
    
    private static h.d a(List<h.d> paramList, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(261026);
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        h.d locald1 = (h.d)paramList.get(i);
        if ((locald1.agL == paramInt) && (locald1.agN == paramBoolean))
        {
          paramList.remove(i);
          paramInt = i;
          if (paramInt < paramList.size())
          {
            h.d locald2 = (h.d)paramList.get(paramInt);
            int j = locald2.agM;
            if (paramBoolean) {}
            for (i = 1;; i = -1)
            {
              locald2.agM = (i + j);
              paramInt += 1;
              break;
            }
          }
          AppMethodBeat.o(261026);
          return locald1;
        }
        i -= 1;
      }
      AppMethodBeat.o(261026);
      return null;
    }
    
    private void a(List<h.d> paramList, s params, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(261030);
      if (!this.agK)
      {
        params.W(paramInt1, paramInt2);
        AppMethodBeat.o(261030);
        return;
      }
      paramInt2 -= 1;
      if (paramInt2 >= 0)
      {
        int i = this.agG[(paramInt3 + paramInt2)] & 0x1F;
        Iterator localIterator;
        switch (i)
        {
        default: 
          paramList = new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
          AppMethodBeat.o(261030);
          throw paramList;
        case 0: 
          params.W(paramInt1, 1);
          localIterator = paramList.iterator();
        case 4: 
        case 8: 
          while (localIterator.hasNext())
          {
            h.d locald = (h.d)localIterator.next();
            locald.agM += 1;
            continue;
            int j = this.agG[(paramInt3 + paramInt2)] >> 5;
            params.ad(a(paramList, j, true).agM, paramInt1);
            if (i == 4) {
              params.c(paramInt1, 1, this.agH.Y(j, paramInt3 + paramInt2));
            }
          }
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          paramList.add(new h.d(paramInt3 + paramInt2, paramInt1, false));
        }
      }
      AppMethodBeat.o(261030);
    }
    
    private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int k = 8;
      AppMethodBeat.i(261015);
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
        h.f localf = (h.f)this.agE.get(paramInt3);
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
              break label274;
            }
            if (this.agH.Z(paramInt2, j))
            {
              if (this.agH.ab(paramInt2, j)) {}
              for (paramInt1 = 8;; paramInt1 = 4)
              {
                this.agG[j] = (paramInt2 << 5 | 0x10);
                this.agF[paramInt2] = (paramInt1 | j << 5);
                AppMethodBeat.o(261015);
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
          if (this.agH.Z(j, paramInt2))
          {
            if (this.agH.ab(j, paramInt2)) {}
            for (paramInt3 = k;; paramInt3 = 4)
            {
              this.agF[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
              this.agG[paramInt2] = (paramInt3 | paramInt1 - 1 << 5);
              AppMethodBeat.o(261015);
              return true;
            }
          }
          paramInt2 -= 1;
        }
        label274:
        i = localf.x;
        paramInt2 = localf.y;
        paramInt3 -= 1;
      }
      AppMethodBeat.o(261015);
      return false;
    }
    
    private void b(List<h.d> paramList, s params, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(261033);
      if (!this.agK)
      {
        params.ac(paramInt1, paramInt2);
        AppMethodBeat.o(261033);
        return;
      }
      paramInt2 -= 1;
      if (paramInt2 >= 0)
      {
        int i = this.agF[(paramInt3 + paramInt2)] & 0x1F;
        Object localObject;
        switch (i)
        {
        default: 
          paramList = new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
          AppMethodBeat.o(261033);
          throw paramList;
        case 0: 
          params.ac(paramInt1 + paramInt2, 1);
          localObject = paramList.iterator();
        case 4: 
        case 8: 
          while (((Iterator)localObject).hasNext())
          {
            h.d locald = (h.d)((Iterator)localObject).next();
            locald.agM -= 1;
            continue;
            int j = this.agF[(paramInt3 + paramInt2)] >> 5;
            localObject = a(paramList, j, false);
            params.ad(paramInt1 + paramInt2, ((h.d)localObject).agM - 1);
            if (i == 4) {
              params.c(((h.d)localObject).agM - 1, 1, this.agH.Y(paramInt3 + paramInt2, j));
            }
          }
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          paramList.add(new h.d(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
        }
      }
      AppMethodBeat.o(261033);
    }
    
    private void ko()
    {
      AppMethodBeat.i(261012);
      int j = this.agI;
      int i = this.agJ;
      int k = this.agE.size() - 1;
      while (k >= 0)
      {
        h.f localf = (h.f)this.agE.get(k);
        int i2 = localf.x;
        int i3 = localf.size;
        int n = localf.y;
        int i1 = localf.size;
        int m;
        if (this.agK)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + i3) {
              break;
            }
            if (this.agF[(j - 1)] == 0) {
              a(j, i, k, false);
            }
            j -= 1;
          }
          while (m > n + i1)
          {
            if (this.agG[(m - 1)] == 0) {
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
          if (this.agH.ab(m, n)) {}
          for (j = 1;; j = 2)
          {
            this.agF[m] = (n << 5 | j);
            this.agG[n] = (j | m << 5);
            i += 1;
            break;
          }
        }
        j = localf.x;
        i = localf.y;
        k -= 1;
      }
      AppMethodBeat.o(261012);
    }
    
    public final void a(RecyclerView.a parama)
    {
      AppMethodBeat.i(261020);
      a(new b(parama));
      AppMethodBeat.o(261020);
    }
    
    public final void a(s params)
    {
      AppMethodBeat.i(261023);
      ArrayList localArrayList;
      int j;
      int k;
      int i;
      if ((params instanceof e))
      {
        params = (e)params;
        localArrayList = new ArrayList();
        j = this.agI;
        k = this.agJ;
        i = this.agE.size() - 1;
      }
      for (;;)
      {
        if (i < 0) {
          break label239;
        }
        h.f localf = (h.f)this.agE.get(i);
        int m = localf.size;
        int n = localf.x + m;
        int i1 = localf.y + m;
        if (n < j) {
          b(localArrayList, params, n, j - n, n);
        }
        if (i1 < k) {
          a(localArrayList, params, n, k - i1, i1);
        }
        j = m - 1;
        for (;;)
        {
          if (j >= 0)
          {
            if ((this.agF[(localf.x + j)] & 0x1F) == 2) {
              params.c(localf.x + j, 1, this.agH.Y(localf.x + j, localf.y + j));
            }
            j -= 1;
            continue;
            params = new e(params);
            break;
          }
        }
        j = localf.x;
        k = localf.y;
        i -= 1;
      }
      label239:
      params.ki();
      AppMethodBeat.o(261023);
    }
  }
  
  static final class d
  {
    int agL;
    int agM;
    boolean agN;
    
    public d(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.agL = paramInt1;
      this.agM = paramInt2;
      this.agN = paramBoolean;
    }
  }
  
  static final class e
  {
    int agO;
    int agP;
    int agQ;
    int agR;
    
    public e() {}
    
    public e(int paramInt1, int paramInt2)
    {
      this.agO = 0;
      this.agP = paramInt1;
      this.agQ = 0;
      this.agR = paramInt2;
    }
  }
  
  static final class f
  {
    boolean agN;
    boolean reverse;
    int size;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.h
 * JD-Core Version:    0.7.0.1
 */