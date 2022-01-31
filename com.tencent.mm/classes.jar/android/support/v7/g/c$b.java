package android.support.v7.g;

import android.support.v7.widget.RecyclerView.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class c$b
{
  private final List<c.e> SD;
  private final int[] SE;
  private final int[] SF;
  private final c.a SG;
  private final int SH;
  private final int SI;
  private final boolean SJ;
  
  c$b(c.a parama, List<c.e> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.SD = paramList;
    this.SE = paramArrayOfInt1;
    this.SF = paramArrayOfInt2;
    Arrays.fill(this.SE, 0);
    Arrays.fill(this.SF, 0);
    this.SG = parama;
    this.SH = parama.eI();
    this.SI = parama.eJ();
    this.SJ = paramBoolean;
    if (this.SD.isEmpty()) {}
    for (parama = null;; parama = (c.e)this.SD.get(0))
    {
      if ((parama == null) || (parama.x != 0) || (parama.y != 0))
      {
        parama = new c.e();
        parama.x = 0;
        parama.y = 0;
        parama.SM = false;
        parama.size = 0;
        parama.SR = false;
        this.SD.add(0, parama);
      }
      eK();
      return;
    }
  }
  
  private void a(List<c.c> paramList, d paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.SJ) {
      paramd.z(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.SF[(paramInt3 + paramInt2)] & 0x1F;
    Iterator localIterator;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramd.z(paramInt1, 1);
      localIterator = paramList.iterator();
    case 4: 
    case 8: 
      while (localIterator.hasNext())
      {
        c.c localc = (c.c)localIterator.next();
        localc.SL += 1;
        continue;
        int j = this.SF[(paramInt3 + paramInt2)] >> 5;
        paramd.B(b(paramList, j, true).SL, paramInt1);
        if (i == 4) {
          paramd.a(paramInt1, 1, this.SG.E(j, paramInt3 + paramInt2));
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
      c.e locale = (c.e)this.SD.get(paramInt3);
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
          if (this.SG.C(paramInt2, j))
          {
            if (this.SG.D(paramInt2, j)) {}
            for (paramInt1 = 8;; paramInt1 = 4)
            {
              this.SF[j] = (paramInt2 << 5 | 0x10);
              this.SE[paramInt2] = (paramInt1 | j << 5);
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
        if (this.SG.C(j, paramInt2))
        {
          if (this.SG.D(j, paramInt2)) {}
          for (paramInt3 = k;; paramInt3 = 4)
          {
            this.SE[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
            this.SF[paramInt2] = (paramInt3 | paramInt1 - 1 << 5);
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
      if ((localc2.SK == paramInt) && (localc2.SM == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localc1 = localc2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localc1 = (c.c)paramList.get(paramInt);
        int j = localc1.SL;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localc1.SL = (i + j);
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
    if (!this.SJ) {
      paramd.A(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.SE[(paramInt3 + paramInt2)] & 0x1F;
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramd.A(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        c.c localc = (c.c)((Iterator)localObject).next();
        localc.SL -= 1;
        continue;
        int j = this.SE[(paramInt3 + paramInt2)] >> 5;
        localObject = b(paramList, j, false);
        paramd.B(paramInt1 + paramInt2, ((c.c)localObject).SL - 1);
        if (i == 4) {
          paramd.a(((c.c)localObject).SL - 1, 1, this.SG.E(paramInt3 + paramInt2, j));
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
  
  private void eK()
  {
    int j = this.SH;
    int i = this.SI;
    int k = this.SD.size() - 1;
    while (k >= 0)
    {
      c.e locale = (c.e)this.SD.get(k);
      int i2 = locale.x;
      int i3 = locale.size;
      int n = locale.y;
      int i1 = locale.size;
      int m;
      if (this.SJ)
      {
        for (;;)
        {
          m = i;
          if (j <= i2 + i3) {
            break;
          }
          if (this.SE[(j - 1)] == 0) {
            a(j, i, k, false);
          }
          j -= 1;
        }
        while (m > n + i1)
        {
          if (this.SF[(m - 1)] == 0) {
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
        if (this.SG.D(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.SE[m] = (n << 5 | j);
          this.SF[n] = (j | m << 5);
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
      j = this.SH;
      k = this.SI;
      i = this.SD.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label234;
      }
      c.e locale = (c.e)this.SD.get(i);
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
          if ((this.SE[(locale.x + j)] & 0x1F) == 2) {
            paramd.a(locale.x + j, 1, this.SG.E(locale.x + j, locale.y + j));
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
    paramd.eH();
  }
  
  public final void a(RecyclerView.a parama)
  {
    a(new a(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.g.c.b
 * JD-Core Version:    0.7.0.1
 */