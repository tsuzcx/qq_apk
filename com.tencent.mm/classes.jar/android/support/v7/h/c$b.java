package android.support.v7.h;

import android.support.v7.widget.RecyclerView.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class c$b
{
  private final List<c.e> Tn;
  private final int[] To;
  private final int[] Tp;
  private final c.a Tq;
  private final int Tr;
  private final int Ts;
  private final boolean Tt;
  
  c$b(c.a parama, List<c.e> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.Tn = paramList;
    this.To = paramArrayOfInt1;
    this.Tp = paramArrayOfInt2;
    Arrays.fill(this.To, 0);
    Arrays.fill(this.Tp, 0);
    this.Tq = parama;
    this.Tr = parama.fv();
    this.Ts = parama.fw();
    this.Tt = paramBoolean;
    if (this.Tn.isEmpty()) {}
    for (parama = null;; parama = (c.e)this.Tn.get(0))
    {
      if ((parama == null) || (parama.x != 0) || (parama.y != 0))
      {
        parama = new c.e();
        parama.x = 0;
        parama.y = 0;
        parama.Tw = false;
        parama.size = 0;
        parama.TB = false;
        this.Tn.add(0, parama);
      }
      fx();
      return;
    }
  }
  
  private void a(List<c.c> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.Tt) {
      paramd.C(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.Tp[(paramInt3 + paramInt2)] & 0x1F;
    Iterator localIterator;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramd.C(paramInt1, 1);
      localIterator = paramList.iterator();
    case 4: 
    case 8: 
      while (localIterator.hasNext())
      {
        c.c localc = (c.c)localIterator.next();
        localc.Tv += 1;
        continue;
        int j = this.Tp[(paramInt3 + paramInt2)] >> 5;
        paramd.E(b(paramList, j, true).Tv, paramInt1);
        if (i == 4) {
          paramd.c(paramInt1, 1, this.Tq.H(j, paramInt3 + paramInt2));
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
      c.e locale = (c.e)this.Tn.get(paramInt3);
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
          if (this.Tq.F(paramInt2, j))
          {
            if (this.Tq.G(paramInt2, j)) {}
            for (paramInt1 = 8;; paramInt1 = 4)
            {
              this.Tp[j] = (paramInt2 << 5 | 0x10);
              this.To[paramInt2] = (paramInt1 | j << 5);
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
        if (this.Tq.F(j, paramInt2))
        {
          if (this.Tq.G(j, paramInt2)) {}
          for (paramInt3 = k;; paramInt3 = 4)
          {
            this.To[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
            this.Tp[paramInt2] = (paramInt3 | paramInt1 - 1 << 5);
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
  
  private static c.c b(List<c.c> paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      c.c localc2 = (c.c)paramList.get(i);
      if ((localc2.Tu == paramInt) && (localc2.Tw == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localc1 = localc2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localc1 = (c.c)paramList.get(paramInt);
        int j = localc1.Tv;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localc1.Tv = (i + j);
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
  
  private void b(List<c.c> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.Tt) {
      paramd.D(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.To[(paramInt3 + paramInt2)] & 0x1F;
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramd.D(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        c.c localc = (c.c)((Iterator)localObject).next();
        localc.Tv -= 1;
        continue;
        int j = this.To[(paramInt3 + paramInt2)] >> 5;
        localObject = b(paramList, j, false);
        paramd.E(paramInt1 + paramInt2, ((c.c)localObject).Tv - 1);
        if (i == 4) {
          paramd.c(((c.c)localObject).Tv - 1, 1, this.Tq.H(paramInt3 + paramInt2, j));
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
  
  private void fx()
  {
    int j = this.Tr;
    int i = this.Ts;
    int k = this.Tn.size() - 1;
    while (k >= 0)
    {
      c.e locale = (c.e)this.Tn.get(k);
      int i2 = locale.x;
      int i3 = locale.size;
      int n = locale.y;
      int i1 = locale.size;
      int m;
      if (this.Tt)
      {
        for (;;)
        {
          m = i;
          if (j <= i2 + i3) {
            break;
          }
          if (this.To[(j - 1)] == 0) {
            a(j, i, k, false);
          }
          j -= 1;
        }
        while (m > n + i1)
        {
          if (this.Tp[(m - 1)] == 0) {
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
        if (this.Tq.G(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.To[m] = (n << 5 | j);
          this.Tp[n] = (j | m << 5);
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
      j = this.Tr;
      k = this.Ts;
      i = this.Tn.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label234;
      }
      c.e locale = (c.e)this.Tn.get(i);
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
          if ((this.To[(locale.x + j)] & 0x1F) == 2) {
            paramd.c(locale.x + j, 1, this.Tq.H(locale.x + j, locale.y + j));
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
    paramd.fu();
  }
  
  public final void a(RecyclerView.a parama)
  {
    a(new a(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.h.c.b
 * JD-Core Version:    0.7.0.1
 */