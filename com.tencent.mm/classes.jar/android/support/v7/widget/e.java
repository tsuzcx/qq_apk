package android.support.v7.widget;

import android.support.v4.f.k.a;
import android.support.v4.f.k.b;
import java.util.ArrayList;
import java.util.List;

final class e
  implements ai.a
{
  private k.a<e.b> Zd = new k.b(30);
  final ArrayList<e.b> Ze = new ArrayList();
  final ArrayList<e.b> Zf = new ArrayList();
  final e.a Zg;
  Runnable Zh;
  final boolean Zi;
  final ai Zj;
  int Zk = 0;
  
  e(e.a parama)
  {
    this(parama, (byte)0);
  }
  
  private e(e.a parama, byte paramByte)
  {
    this.Zg = parama;
    this.Zi = false;
    this.Zj = new ai(this);
  }
  
  private int F(int paramInt1, int paramInt2)
  {
    int i = this.Zf.size() - 1;
    e.b localb;
    if (i >= 0)
    {
      localb = (e.b)this.Zf.get(i);
      int k;
      int j;
      if (localb.uC == 8) {
        if (localb.Zl < localb.Zn)
        {
          k = localb.Zl;
          j = localb.Zn;
          label64:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label195;
          }
          if (k != localb.Zl) {
            break label151;
          }
          if (paramInt2 != 1) {
            break label131;
          }
          localb.Zn += 1;
          label103:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.Zn;
        j = localb.Zl;
        break label64;
        label131:
        if (paramInt2 != 2) {
          break label103;
        }
        localb.Zn -= 1;
        break label103;
        label151:
        if (paramInt2 == 1) {
          localb.Zl += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.Zl -= 1;
          }
        }
        label195:
        if (paramInt1 < localb.Zl)
        {
          if (paramInt2 == 1)
          {
            localb.Zl += 1;
            localb.Zn += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.Zl -= 1;
            localb.Zn -= 1;
          }
        }
        continue;
        if (localb.Zl <= paramInt1)
        {
          if (localb.uC == 1) {
            paramInt1 -= localb.Zn;
          } else if (localb.uC == 2) {
            paramInt1 = localb.Zn + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.Zl += 1;
        } else if (paramInt2 == 2) {
          localb.Zl -= 1;
        }
      }
    }
    paramInt2 = this.Zf.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (e.b)this.Zf.get(paramInt2);
      if (localb.uC == 8) {
        if ((localb.Zn == localb.Zl) || (localb.Zn < 0))
        {
          this.Zf.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.Zn <= 0)
        {
          this.Zf.remove(paramInt2);
          c(localb);
        }
      }
    }
    return paramInt1;
  }
  
  private void a(e.b paramb)
  {
    if ((paramb.uC == 1) || (paramb.uC == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = F(paramb.Zl, paramb.uC);
    int j = paramb.Zl;
    int k;
    int m;
    int n;
    label109:
    int i2;
    switch (paramb.uC)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramb);
    case 4: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramb.Zn) {
        break label294;
      }
      i2 = F(paramb.Zl + k * m, paramb.uC);
      switch (paramb.uC)
      {
      case 3: 
      default: 
        i = 0;
        label170:
        if (i == 0) {}
        break;
      }
      break;
    }
    for (int i = n + 1;; i = n)
    {
      m += 1;
      n = i;
      break label109;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label170;
      }
      i = 0;
      break label170;
      if (i2 == i1)
      {
        i = 1;
        break label170;
      }
      i = 0;
      break label170;
      localObject = a(paramb.uC, i1, n, paramb.Zm);
      a((e.b)localObject, j);
      c((e.b)localObject);
      i = j;
      if (paramb.uC == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label294:
    Object localObject = paramb.Zm;
    c(paramb);
    if (n > 0)
    {
      paramb = a(paramb.uC, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
  }
  
  private void a(e.b paramb, int paramInt)
  {
    this.Zg.d(paramb);
    switch (paramb.uC)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.Zg.H(paramInt, paramb.Zn);
      return;
    }
    this.Zg.b(paramInt, paramb.Zn, paramb.Zm);
  }
  
  private void b(e.b paramb)
  {
    this.Zf.add(paramb);
    switch (paramb.uC)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for " + paramb);
    case 1: 
      this.Zg.J(paramb.Zl, paramb.Zn);
      return;
    case 8: 
      this.Zg.K(paramb.Zl, paramb.Zn);
      return;
    case 2: 
      this.Zg.I(paramb.Zl, paramb.Zn);
      return;
    }
    this.Zg.b(paramb.Zl, paramb.Zn, paramb.Zm);
  }
  
  private boolean bl(int paramInt)
  {
    int k = this.Zf.size();
    int i = 0;
    while (i < k)
    {
      e.b localb = (e.b)this.Zf.get(i);
      if (localb.uC == 8)
      {
        if (G(localb.Zn, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localb.uC == 1)
      {
        int m = localb.Zl;
        int n = localb.Zn;
        int j = localb.Zl;
        while (j < m + n)
        {
          if (G(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void n(List<e.b> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      c((e.b)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  final int G(int paramInt1, int paramInt2)
  {
    int k = this.Zf.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    e.b localb;
    if (j < k)
    {
      localb = (e.b)this.Zf.get(j);
      if (localb.uC == 8) {
        if (localb.Zl == paramInt2) {
          paramInt1 = localb.Zn;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localb.Zl < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localb.Zn <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localb.Zl <= paramInt2) {
          if (localb.uC == 2)
          {
            if (paramInt2 < localb.Zl + localb.Zn)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localb.Zn;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localb.uC == 1) {
              paramInt1 = paramInt2 + localb.Zn;
            }
          }
        }
      }
    }
  }
  
  public final e.b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    e.b localb = (e.b)this.Zd.de();
    if (localb == null) {
      return new e.b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.uC = paramInt1;
    localb.Zl = paramInt2;
    localb.Zn = paramInt3;
    localb.Zm = paramObject;
    return localb;
  }
  
  final boolean bm(int paramInt)
  {
    return (this.Zk & paramInt) != 0;
  }
  
  final int bn(int paramInt)
  {
    return G(paramInt, 0);
  }
  
  public final void c(e.b paramb)
  {
    if (!this.Zi)
    {
      paramb.Zm = null;
      this.Zd.D(paramb);
    }
  }
  
  final void fZ()
  {
    ai localai = this.Zj;
    ArrayList localArrayList = this.Ze;
    int i;
    label24:
    label53:
    int i1;
    e.b localb2;
    e.b localb3;
    int k;
    for (;;)
    {
      j = 0;
      i = localArrayList.size() - 1;
      if (i < 0) {
        break label268;
      }
      if (((e.b)localArrayList.get(i)).uC != 8) {
        break;
      }
      if (j == 0) {
        break label1829;
      }
      j = i;
      if (j == -1) {
        break label1251;
      }
      i1 = j + 1;
      localb2 = (e.b)localArrayList.get(j);
      localb3 = (e.b)localArrayList.get(i1);
      switch (localb3.uC)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.Zn < localb3.Zl) {
          i = -1;
        }
        k = i;
        if (localb2.Zl < localb3.Zl) {
          k = i + 1;
        }
        if (localb3.Zl <= localb2.Zl) {
          localb2.Zl += localb3.Zn;
        }
        if (localb3.Zl <= localb2.Zn) {
          localb2.Zn += localb3.Zn;
        }
        localb3.Zl = (k + localb3.Zl);
        localArrayList.set(j, localb3);
        localArrayList.set(i1, localb2);
      }
    }
    int j = 1;
    label268:
    label655:
    label1829:
    for (;;)
    {
      i -= 1;
      break label24;
      j = -1;
      break label53;
      e.b localb1 = null;
      int m = 0;
      int n;
      if (localb2.Zl < localb2.Zn)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.Zl == localb2.Zl)
        {
          k = n;
          i = m;
          if (localb3.Zn == localb2.Zn - localb2.Zl)
          {
            i = 1;
            k = n;
          }
        }
        label344:
        if (localb2.Zn >= localb3.Zl) {
          break label491;
        }
        localb3.Zl -= 1;
        label369:
        if (localb2.Zl > localb3.Zl) {
          break label567;
        }
        localb3.Zl += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label655;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localai.afl.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.Zl != localb2.Zn + 1) {
          break label344;
        }
        k = n;
        i = m;
        if (localb3.Zn != localb2.Zl - localb2.Zn) {
          break label344;
        }
        i = 1;
        k = n;
        break label344;
        label491:
        if (localb2.Zn >= localb3.Zl + localb3.Zn) {
          break label369;
        }
        localb3.Zn -= 1;
        localb2.uC = 2;
        localb2.Zn = 1;
        if (localb3.Zn != 0) {
          break;
        }
        localArrayList.remove(i1);
        localai.afl.c(localb3);
        break;
        label567:
        if (localb2.Zl < localb3.Zl + localb3.Zn)
        {
          m = localb3.Zl;
          n = localb3.Zn;
          i2 = localb2.Zl;
          localb1 = localai.afl.a(2, localb2.Zl + 1, m + n - i2, null);
          localb3.Zn = (localb2.Zl - localb3.Zl);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.Zl > localb1.Zl) {
            localb2.Zl -= localb1.Zn;
          }
          if (localb2.Zn > localb1.Zl) {
            localb2.Zn -= localb1.Zn;
          }
        }
        if (localb2.Zl > localb3.Zl) {
          localb2.Zl -= localb3.Zn;
        }
        if (localb2.Zn > localb3.Zl) {
          localb2.Zn -= localb3.Zn;
        }
        localArrayList.set(j, localb3);
        if (localb2.Zl == localb2.Zn) {
          break label958;
        }
        localArrayList.set(i1, localb2);
      }
      while (localb1 != null)
      {
        localArrayList.add(j, localb1);
        break;
        if (localb1 != null)
        {
          if (localb2.Zl >= localb1.Zl) {
            localb2.Zl -= localb1.Zn;
          }
          if (localb2.Zn >= localb1.Zl) {
            localb2.Zn -= localb1.Zn;
          }
        }
        if (localb2.Zl >= localb3.Zl) {
          localb2.Zl -= localb3.Zn;
        }
        if (localb2.Zn < localb3.Zl) {
          break label780;
        }
        localb2.Zn -= localb3.Zn;
        break label780;
        label958:
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.Zn < localb3.Zl)
      {
        localb3.Zl -= 1;
        label1002:
        if (localb2.Zl > localb3.Zl) {
          break label1149;
        }
        localb3.Zl += 1;
        localArrayList.set(i1, localb2);
        if (localb3.Zn <= 0) {
          break label1227;
        }
        localArrayList.set(j, localb3);
      }
      for (;;)
      {
        if (localb1 != null) {
          localArrayList.add(j, localb1);
        }
        if (localObject == null) {
          break;
        }
        localArrayList.add(j, localObject);
        break;
        if (localb2.Zn >= localb3.Zl + localb3.Zn) {
          break label1002;
        }
        localb3.Zn -= 1;
        localb1 = localai.afl.a(4, localb2.Zl, 1, localb3.Zm);
        break label1002;
        label1149:
        if (localb2.Zl >= localb3.Zl + localb3.Zn) {
          break label1027;
        }
        i = localb3.Zl + localb3.Zn - localb2.Zl;
        localObject = localai.afl.a(4, localb2.Zl + 1, i, localb3.Zm);
        localb3.Zn -= i;
        break label1027;
        label1227:
        localArrayList.remove(j);
        localai.afl.c(localb3);
      }
      label1251:
      int i4 = this.Ze.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localb1 = (e.b)this.Ze.get(i2);
        switch (localb1.uC)
        {
        }
        for (;;)
        {
          if (this.Zh != null) {
            this.Zh.run();
          }
          i2 += 1;
          break;
          b(localb1);
          continue;
          int i3 = localb1.Zl;
          m = localb1.Zl + localb1.Zn;
          i1 = -1;
          i = localb1.Zl;
          n = 0;
          if (i < m)
          {
            j = 0;
            k = 0;
            if ((this.Zg.bo(i) != null) || (bl(i)))
            {
              if (i1 == 0)
              {
                a(a(2, i3, n, null));
                k = 1;
              }
              j = 1;
              label1456:
              if (k == 0) {
                break label1522;
              }
              k = i - n;
              i = 1;
              m -= n;
            }
            for (;;)
            {
              k += 1;
              n = i;
              i = k;
              i1 = j;
              break;
              if (i1 == 1)
              {
                b(a(2, i3, n, null));
                j = 1;
              }
              i1 = 0;
              k = j;
              j = i1;
              break label1456;
              label1522:
              n += 1;
              k = i;
              i = n;
            }
          }
          localObject = localb1;
          if (n != localb1.Zn)
          {
            c(localb1);
            localObject = a(2, i3, n, null);
          }
          if (i1 == 0)
          {
            a((e.b)localObject);
          }
          else
          {
            b((e.b)localObject);
            continue;
            k = localb1.Zl;
            j = 0;
            int i5 = localb1.Zl;
            int i6 = localb1.Zn;
            i3 = -1;
            i = localb1.Zl;
            if (i < i5 + i6)
            {
              if ((this.Zg.bo(i) != null) || (bl(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(a(4, k, j, localb1.Zm));
                  n = 0;
                  i1 = i;
                }
                m = 1;
                k = i1;
              }
              for (;;)
              {
                j = n + 1;
                i += 1;
                i3 = m;
                break;
                n = j;
                m = k;
                if (i3 == 1)
                {
                  b(a(4, k, j, localb1.Zm));
                  n = 0;
                  m = i;
                }
                j = 0;
                k = m;
                m = j;
              }
            }
            localObject = localb1;
            if (j != localb1.Zn)
            {
              localObject = localb1.Zm;
              c(localb1);
              localObject = a(4, k, j, localObject);
            }
            if (i3 == 0)
            {
              a((e.b)localObject);
            }
            else
            {
              b((e.b)localObject);
              continue;
              b(localb1);
            }
          }
        }
      }
      this.Ze.clear();
      return;
    }
  }
  
  final void ga()
  {
    int j = this.Zf.size();
    int i = 0;
    while (i < j)
    {
      this.Zg.e((e.b)this.Zf.get(i));
      i += 1;
    }
    n(this.Zf);
    this.Zk = 0;
  }
  
  final boolean gb()
  {
    return this.Ze.size() > 0;
  }
  
  final void gd()
  {
    ga();
    int j = this.Ze.size();
    int i = 0;
    if (i < j)
    {
      e.b localb = (e.b)this.Ze.get(i);
      switch (localb.uC)
      {
      }
      for (;;)
      {
        if (this.Zh != null) {
          this.Zh.run();
        }
        i += 1;
        break;
        this.Zg.e(localb);
        this.Zg.J(localb.Zl, localb.Zn);
        continue;
        this.Zg.e(localb);
        this.Zg.H(localb.Zl, localb.Zn);
        continue;
        this.Zg.e(localb);
        this.Zg.b(localb.Zl, localb.Zn, localb.Zm);
        continue;
        this.Zg.e(localb);
        this.Zg.K(localb.Zl, localb.Zn);
      }
    }
    n(this.Ze);
    this.Zk = 0;
  }
  
  final void reset()
  {
    n(this.Ze);
    n(this.Zf);
    this.Zk = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.e
 * JD-Core Version:    0.7.0.1
 */