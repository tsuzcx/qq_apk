package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private static final Comparator<f> bVj;
  
  static
  {
    AppMethodBeat.i(194820);
    bVj = new Comparator() {};
    AppMethodBeat.o(194820);
  }
  
  public static b a(a parama)
  {
    AppMethodBeat.i(194778);
    parama = a(parama, true);
    AppMethodBeat.o(194778);
    return parama;
  }
  
  public static b a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(194795);
    int i = parama.If();
    int j = parama.Ig();
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
      f localf = a(parama, locale2.bVu, locale2.bVv, locale2.bVw, locale2.bVx, arrayOfInt1, arrayOfInt2, i);
      if (localf != null)
      {
        if (localf.size > 0) {
          localArrayList1.add(localf);
        }
        localf.x += locale2.bVu;
        localf.y += locale2.bVw;
        e locale1;
        if (localArrayList3.isEmpty())
        {
          locale1 = new e();
          label220:
          locale1.bVu = locale2.bVu;
          locale1.bVw = locale2.bVw;
          if (!localf.reverse) {
            break label365;
          }
          locale1.bVv = localf.x;
          locale1.bVx = localf.y;
          label268:
          localArrayList2.add(locale1);
          if (!localf.reverse) {
            break label460;
          }
          if (!localf.bVt) {
            break label423;
          }
          locale2.bVu = (localf.x + localf.size + 1);
          locale2.bVw = (localf.y + localf.size);
        }
        for (;;)
        {
          localArrayList2.add(locale2);
          break;
          locale1 = (e)localArrayList3.remove(localArrayList3.size() - 1);
          break label220;
          label365:
          if (localf.bVt)
          {
            locale1.bVv = (localf.x - 1);
            locale1.bVx = localf.y;
            break label268;
          }
          locale1.bVv = localf.x;
          locale1.bVx = (localf.y - 1);
          break label268;
          label423:
          locale2.bVu = (localf.x + localf.size);
          locale2.bVw = (localf.y + localf.size + 1);
          continue;
          label460:
          locale2.bVu = (localf.x + localf.size);
          locale2.bVw = (localf.y + localf.size);
        }
      }
      localArrayList3.add(locale2);
    }
    Collections.sort(localArrayList1, bVj);
    parama = new b(parama, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
    AppMethodBeat.o(194795);
    return parama;
  }
  
  private static f a(a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    AppMethodBeat.i(194813);
    int n = paramInt2 - paramInt1;
    int i1 = paramInt4 - paramInt3;
    if ((paramInt2 - paramInt1 <= 0) || (paramInt4 - paramInt3 <= 0))
    {
      AppMethodBeat.o(194813);
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
          while ((k < n) && (paramInt2 < i1) && (parama.aU(paramInt1 + k, paramInt3 + paramInt2)))
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
          parama.bVt = bool;
          parama.reverse = false;
          AppMethodBeat.o(194813);
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
          while ((k > 0) && (paramInt2 > 0) && (parama.aU(paramInt1 + k - 1, paramInt3 + paramInt2 - 1)))
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
          parama.bVt = bool;
          parama.reverse = true;
          AppMethodBeat.o(194813);
          return parama;
        }
        j += 2;
      }
      i += 1;
    }
    label690:
    parama = new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    AppMethodBeat.o(194813);
    throw parama;
  }
  
  public static abstract class a
  {
    public abstract int If();
    
    public abstract int Ig();
    
    public Object aT(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract boolean aU(int paramInt1, int paramInt2);
    
    public abstract boolean aV(int paramInt1, int paramInt2);
  }
  
  public static final class b
  {
    private final List<g.f> bVk;
    public final int[] bVl;
    private final int[] bVm;
    private final g.a bVn;
    private final int bVo;
    private final int bVp;
    private final boolean bVq;
    
    b(g.a parama, List<g.f> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(194914);
      this.bVk = paramList;
      this.bVl = paramArrayOfInt1;
      this.bVm = paramArrayOfInt2;
      Arrays.fill(this.bVl, 0);
      Arrays.fill(this.bVm, 0);
      this.bVn = parama;
      this.bVo = parama.If();
      this.bVp = parama.Ig();
      this.bVq = paramBoolean;
      if (this.bVk.isEmpty()) {}
      for (parama = null;; parama = (g.f)this.bVk.get(0))
      {
        if ((parama == null) || (parama.x != 0) || (parama.y != 0))
        {
          parama = new g.f();
          parama.x = 0;
          parama.y = 0;
          parama.bVt = false;
          parama.size = 0;
          parama.reverse = false;
          this.bVk.add(0, parama);
        }
        IZ();
        AppMethodBeat.o(194914);
        return;
      }
    }
    
    private void IZ()
    {
      AppMethodBeat.i(194932);
      int j = this.bVo;
      int i = this.bVp;
      int k = this.bVk.size() - 1;
      while (k >= 0)
      {
        g.f localf = (g.f)this.bVk.get(k);
        int i2 = localf.x;
        int i3 = localf.size;
        int n = localf.y;
        int i1 = localf.size;
        int m;
        if (this.bVq)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + i3) {
              break;
            }
            if (this.bVl[(j - 1)] == 0) {
              a(j, i, k, false);
            }
            j -= 1;
          }
          while (m > n + i1)
          {
            if (this.bVm[(m - 1)] == 0) {
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
          if (this.bVn.aV(m, n)) {}
          for (j = 1;; j = 2)
          {
            this.bVl[m] = (n << 5 | j);
            this.bVm[n] = (j | m << 5);
            i += 1;
            break;
          }
        }
        j = localf.x;
        i = localf.y;
        k -= 1;
      }
      AppMethodBeat.o(194932);
    }
    
    private void a(List<g.d> paramList, q paramq, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(194987);
      if (!this.bVq)
      {
        paramq.aR(paramInt1, paramInt2);
        AppMethodBeat.o(194987);
        return;
      }
      paramInt2 -= 1;
      if (paramInt2 >= 0)
      {
        int i = this.bVm[(paramInt3 + paramInt2)] & 0x1F;
        Iterator localIterator;
        switch (i)
        {
        default: 
          paramList = new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
          AppMethodBeat.o(194987);
          throw paramList;
        case 0: 
          paramq.aR(paramInt1, 1);
          localIterator = paramList.iterator();
        case 4: 
        case 8: 
          while (localIterator.hasNext())
          {
            g.d locald = (g.d)localIterator.next();
            locald.bVs += 1;
            continue;
            int j = this.bVm[(paramInt3 + paramInt2)] >> 5;
            paramq.aW(b(paramList, j, true).bVs, paramInt1);
            if (i == 4) {
              paramq.c(paramInt1, 1, this.bVn.aT(j, paramInt3 + paramInt2));
            }
          }
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          paramList.add(new g.d(paramInt3 + paramInt2, paramInt1, false));
        }
      }
      AppMethodBeat.o(194987);
    }
    
    private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int k = 8;
      AppMethodBeat.i(194947);
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
        g.f localf = (g.f)this.bVk.get(paramInt3);
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
            if (this.bVn.aU(paramInt2, j))
            {
              if (this.bVn.aV(paramInt2, j)) {}
              for (paramInt1 = 8;; paramInt1 = 4)
              {
                this.bVm[j] = (paramInt2 << 5 | 0x10);
                this.bVl[paramInt2] = (paramInt1 | j << 5);
                AppMethodBeat.o(194947);
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
          if (this.bVn.aU(j, paramInt2))
          {
            if (this.bVn.aV(j, paramInt2)) {}
            for (paramInt3 = k;; paramInt3 = 4)
            {
              this.bVl[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
              this.bVm[paramInt2] = (paramInt3 | paramInt1 - 1 << 5);
              AppMethodBeat.o(194947);
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
      AppMethodBeat.o(194947);
      return false;
    }
    
    private static g.d b(List<g.d> paramList, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(194961);
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        g.d locald1 = (g.d)paramList.get(i);
        if ((locald1.bVr == paramInt) && (locald1.bVt == paramBoolean))
        {
          paramList.remove(i);
          paramInt = i;
          if (paramInt < paramList.size())
          {
            g.d locald2 = (g.d)paramList.get(paramInt);
            int j = locald2.bVs;
            if (paramBoolean) {}
            for (i = 1;; i = -1)
            {
              locald2.bVs = (i + j);
              paramInt += 1;
              break;
            }
          }
          AppMethodBeat.o(194961);
          return locald1;
        }
        i -= 1;
      }
      AppMethodBeat.o(194961);
      return null;
    }
    
    private void b(List<g.d> paramList, q paramq, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(195002);
      if (!this.bVq)
      {
        paramq.aS(paramInt1, paramInt2);
        AppMethodBeat.o(195002);
        return;
      }
      paramInt2 -= 1;
      if (paramInt2 >= 0)
      {
        int i = this.bVl[(paramInt3 + paramInt2)] & 0x1F;
        Object localObject;
        switch (i)
        {
        default: 
          paramList = new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
          AppMethodBeat.o(195002);
          throw paramList;
        case 0: 
          paramq.aS(paramInt1 + paramInt2, 1);
          localObject = paramList.iterator();
        case 4: 
        case 8: 
          while (((Iterator)localObject).hasNext())
          {
            g.d locald = (g.d)((Iterator)localObject).next();
            locald.bVs -= 1;
            continue;
            int j = this.bVl[(paramInt3 + paramInt2)] >> 5;
            localObject = b(paramList, j, false);
            paramq.aW(paramInt1 + paramInt2, ((g.d)localObject).bVs - 1);
            if (i == 4) {
              paramq.c(((g.d)localObject).bVs - 1, 1, this.bVn.aT(paramInt3 + paramInt2, j));
            }
          }
        }
        for (;;)
        {
          paramInt2 -= 1;
          break;
          paramList.add(new g.d(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
        }
      }
      AppMethodBeat.o(195002);
    }
    
    public final void a(RecyclerView.a parama)
    {
      AppMethodBeat.i(195013);
      a(new b(parama));
      AppMethodBeat.o(195013);
    }
    
    public final void a(q paramq)
    {
      AppMethodBeat.i(195025);
      ArrayList localArrayList;
      int j;
      int k;
      int i;
      if ((paramq instanceof d))
      {
        paramq = (d)paramq;
        localArrayList = new ArrayList();
        j = this.bVo;
        k = this.bVp;
        i = this.bVk.size() - 1;
      }
      for (;;)
      {
        if (i < 0) {
          break label239;
        }
        g.f localf = (g.f)this.bVk.get(i);
        int m = localf.size;
        int n = localf.x + m;
        int i1 = localf.y + m;
        if (n < j) {
          b(localArrayList, paramq, n, j - n, n);
        }
        if (i1 < k) {
          a(localArrayList, paramq, n, k - i1, i1);
        }
        j = m - 1;
        for (;;)
        {
          if (j >= 0)
          {
            if ((this.bVl[(localf.x + j)] & 0x1F) == 2) {
              paramq.c(localf.x + j, 1, this.bVn.aT(localf.x + j, localf.y + j));
            }
            j -= 1;
            continue;
            paramq = new d(paramq);
            break;
          }
        }
        j = localf.x;
        k = localf.y;
        i -= 1;
      }
      label239:
      paramq.IT();
      AppMethodBeat.o(195025);
    }
  }
  
  static final class d
  {
    int bVr;
    int bVs;
    boolean bVt;
    
    public d(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.bVr = paramInt1;
      this.bVs = paramInt2;
      this.bVt = paramBoolean;
    }
  }
  
  static final class e
  {
    int bVu;
    int bVv;
    int bVw;
    int bVx;
    
    public e() {}
    
    public e(int paramInt1, int paramInt2)
    {
      this.bVu = 0;
      this.bVv = paramInt1;
      this.bVw = 0;
      this.bVx = paramInt2;
    }
  }
  
  static final class f
  {
    boolean bVt;
    boolean reverse;
    int size;
    int x;
    int y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.g
 * JD-Core Version:    0.7.0.1
 */