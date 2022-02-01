package android.support.v7.widget;

import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import java.util.ArrayList;
import java.util.List;

final class d
  implements ai.a
{
  private l.a<b> agT = new l.b(30);
  final ArrayList<b> agU = new ArrayList();
  final ArrayList<b> agV = new ArrayList();
  final a agW;
  Runnable agX;
  final boolean agY;
  final ai agZ;
  int aha = 0;
  
  d(a parama)
  {
    this(parama, (byte)0);
  }
  
  private d(a parama, byte paramByte)
  {
    this.agW = parama;
    this.agY = false;
    this.agZ = new ai(this);
  }
  
  private int K(int paramInt1, int paramInt2)
  {
    int i = this.agV.size() - 1;
    b localb;
    if (i >= 0)
    {
      localb = (b)this.agV.get(i);
      int k;
      int j;
      if (localb.BX == 8) {
        if (localb.ahb < localb.ahd)
        {
          k = localb.ahb;
          j = localb.ahd;
          label64:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label195;
          }
          if (k != localb.ahb) {
            break label151;
          }
          if (paramInt2 != 1) {
            break label131;
          }
          localb.ahd += 1;
          label103:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.ahd;
        j = localb.ahb;
        break label64;
        label131:
        if (paramInt2 != 2) {
          break label103;
        }
        localb.ahd -= 1;
        break label103;
        label151:
        if (paramInt2 == 1) {
          localb.ahb += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.ahb -= 1;
          }
        }
        label195:
        if (paramInt1 < localb.ahb)
        {
          if (paramInt2 == 1)
          {
            localb.ahb += 1;
            localb.ahd += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.ahb -= 1;
            localb.ahd -= 1;
          }
        }
        continue;
        if (localb.ahb <= paramInt1)
        {
          if (localb.BX == 1) {
            paramInt1 -= localb.ahd;
          } else if (localb.BX == 2) {
            paramInt1 = localb.ahd + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.ahb += 1;
        } else if (paramInt2 == 2) {
          localb.ahb -= 1;
        }
      }
    }
    paramInt2 = this.agV.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (b)this.agV.get(paramInt2);
      if (localb.BX == 8) {
        if ((localb.ahd == localb.ahb) || (localb.ahd < 0))
        {
          this.agV.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.ahd <= 0)
        {
          this.agV.remove(paramInt2);
          c(localb);
        }
      }
    }
    return paramInt1;
  }
  
  private void a(b paramb)
  {
    if ((paramb.BX == 1) || (paramb.BX == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = K(paramb.ahb, paramb.BX);
    int j = paramb.ahb;
    int k;
    int m;
    int n;
    label102:
    int i2;
    switch (paramb.BX)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(paramb)));
    case 4: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramb.ahd) {
        break label286;
      }
      i2 = K(paramb.ahb + k * m, paramb.BX);
      switch (paramb.BX)
      {
      case 3: 
      default: 
        i = 0;
        label162:
        if (i == 0) {}
        break;
      }
      break;
    }
    for (int i = n + 1;; i = n)
    {
      m += 1;
      n = i;
      break label102;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label162;
      }
      i = 0;
      break label162;
      if (i2 == i1)
      {
        i = 1;
        break label162;
      }
      i = 0;
      break label162;
      localObject = b(paramb.BX, i1, n, paramb.ahc);
      a((b)localObject, j);
      c((b)localObject);
      i = j;
      if (paramb.BX == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label286:
    Object localObject = paramb.ahc;
    c(paramb);
    if (n > 0)
    {
      paramb = b(paramb.BX, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
  }
  
  private void a(b paramb, int paramInt)
  {
    this.agW.d(paramb);
    switch (paramb.BX)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.agW.M(paramInt, paramb.ahd);
      return;
    }
    this.agW.d(paramInt, paramb.ahd, paramb.ahc);
  }
  
  private void b(b paramb)
  {
    this.agV.add(paramb);
    switch (paramb.BX)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(paramb)));
    case 1: 
      this.agW.O(paramb.ahb, paramb.ahd);
      return;
    case 8: 
      this.agW.P(paramb.ahb, paramb.ahd);
      return;
    case 2: 
      this.agW.N(paramb.ahb, paramb.ahd);
      return;
    }
    this.agW.d(paramb.ahb, paramb.ahd, paramb.ahc);
  }
  
  private boolean bB(int paramInt)
  {
    int k = this.agV.size();
    int i = 0;
    while (i < k)
    {
      b localb = (b)this.agV.get(i);
      if (localb.BX == 8)
      {
        if (L(localb.ahd, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localb.BX == 1)
      {
        int m = localb.ahb;
        int n = localb.ahd;
        int j = localb.ahb;
        while (j < m + n)
        {
          if (L(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void n(List<b> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      c((b)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  final int L(int paramInt1, int paramInt2)
  {
    int k = this.agV.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    b localb;
    if (j < k)
    {
      localb = (b)this.agV.get(j);
      if (localb.BX == 8) {
        if (localb.ahb == paramInt2) {
          paramInt1 = localb.ahd;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localb.ahb < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localb.ahd <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localb.ahb <= paramInt2) {
          if (localb.BX == 2)
          {
            if (paramInt2 < localb.ahb + localb.ahd)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localb.ahd;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localb.BX == 1) {
              paramInt1 = paramInt2 + localb.ahd;
            }
          }
        }
      }
    }
  }
  
  public final b b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    b localb = (b)this.agT.acquire();
    if (localb == null) {
      return new b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.BX = paramInt1;
    localb.ahb = paramInt2;
    localb.ahd = paramInt3;
    localb.ahc = paramObject;
    return localb;
  }
  
  final boolean bC(int paramInt)
  {
    return (this.aha & paramInt) != 0;
  }
  
  final int bD(int paramInt)
  {
    return L(paramInt, 0);
  }
  
  public final int bE(int paramInt)
  {
    int m = this.agU.size();
    int k = 0;
    int i = paramInt;
    paramInt = i;
    b localb;
    if (k < m)
    {
      localb = (b)this.agU.get(k);
      switch (localb.BX)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      k += 1;
      i = paramInt;
      break;
      paramInt = i;
      if (localb.ahb <= i)
      {
        paramInt = i + localb.ahd;
        continue;
        paramInt = i;
        if (localb.ahb <= i)
        {
          if (localb.ahb + localb.ahd > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - localb.ahd;
          continue;
          if (localb.ahb == i)
          {
            paramInt = localb.ahd;
          }
          else
          {
            int j = i;
            if (localb.ahb < i) {
              j = i - 1;
            }
            paramInt = j;
            if (localb.ahd <= j) {
              paramInt = j + 1;
            }
          }
        }
      }
    }
  }
  
  public final void c(b paramb)
  {
    if (!this.agY)
    {
      paramb.ahc = null;
      this.agT.release(paramb);
    }
  }
  
  final void it()
  {
    ai localai = this.agZ;
    ArrayList localArrayList = this.agU;
    int i;
    label24:
    label53:
    int i1;
    b localb2;
    b localb3;
    int k;
    for (;;)
    {
      j = 0;
      i = localArrayList.size() - 1;
      if (i < 0) {
        break label268;
      }
      if (((b)localArrayList.get(i)).BX != 8) {
        break;
      }
      if (j == 0) {
        break label1840;
      }
      j = i;
      if (j == -1) {
        break label1251;
      }
      i1 = j + 1;
      localb2 = (b)localArrayList.get(j);
      localb3 = (b)localArrayList.get(i1);
      switch (localb3.BX)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.ahd < localb3.ahb) {
          i = -1;
        }
        k = i;
        if (localb2.ahb < localb3.ahb) {
          k = i + 1;
        }
        if (localb3.ahb <= localb2.ahb) {
          localb2.ahb += localb3.ahd;
        }
        if (localb3.ahb <= localb2.ahd) {
          localb2.ahd += localb3.ahd;
        }
        localb3.ahb = (k + localb3.ahb);
        localArrayList.set(j, localb3);
        localArrayList.set(i1, localb2);
      }
    }
    int j = 1;
    label268:
    label655:
    label1840:
    for (;;)
    {
      i -= 1;
      break label24;
      j = -1;
      break label53;
      b localb1 = null;
      int m = 0;
      int n;
      if (localb2.ahb < localb2.ahd)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.ahb == localb2.ahb)
        {
          k = n;
          i = m;
          if (localb3.ahd == localb2.ahd - localb2.ahb)
          {
            i = 1;
            k = n;
          }
        }
        label344:
        if (localb2.ahd >= localb3.ahb) {
          break label491;
        }
        localb3.ahb -= 1;
        label369:
        if (localb2.ahb > localb3.ahb) {
          break label567;
        }
        localb3.ahb += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label655;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localai.aoH.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.ahb != localb2.ahd + 1) {
          break label344;
        }
        k = n;
        i = m;
        if (localb3.ahd != localb2.ahb - localb2.ahd) {
          break label344;
        }
        i = 1;
        k = n;
        break label344;
        label491:
        if (localb2.ahd >= localb3.ahb + localb3.ahd) {
          break label369;
        }
        localb3.ahd -= 1;
        localb2.BX = 2;
        localb2.ahd = 1;
        if (localb3.ahd != 0) {
          break;
        }
        localArrayList.remove(i1);
        localai.aoH.c(localb3);
        break;
        label567:
        if (localb2.ahb < localb3.ahb + localb3.ahd)
        {
          m = localb3.ahb;
          n = localb3.ahd;
          i2 = localb2.ahb;
          localb1 = localai.aoH.b(2, localb2.ahb + 1, m + n - i2, null);
          localb3.ahd = (localb2.ahb - localb3.ahb);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.ahb > localb1.ahb) {
            localb2.ahb -= localb1.ahd;
          }
          if (localb2.ahd > localb1.ahb) {
            localb2.ahd -= localb1.ahd;
          }
        }
        if (localb2.ahb > localb3.ahb) {
          localb2.ahb -= localb3.ahd;
        }
        if (localb2.ahd > localb3.ahb) {
          localb2.ahd -= localb3.ahd;
        }
        localArrayList.set(j, localb3);
        if (localb2.ahb == localb2.ahd) {
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
          if (localb2.ahb >= localb1.ahb) {
            localb2.ahb -= localb1.ahd;
          }
          if (localb2.ahd >= localb1.ahb) {
            localb2.ahd -= localb1.ahd;
          }
        }
        if (localb2.ahb >= localb3.ahb) {
          localb2.ahb -= localb3.ahd;
        }
        if (localb2.ahd < localb3.ahb) {
          break label780;
        }
        localb2.ahd -= localb3.ahd;
        break label780;
        label958:
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.ahd < localb3.ahb)
      {
        localb3.ahb -= 1;
        label1002:
        if (localb2.ahb > localb3.ahb) {
          break label1149;
        }
        localb3.ahb += 1;
        localArrayList.set(i1, localb2);
        if (localb3.ahd <= 0) {
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
        if (localb2.ahd >= localb3.ahb + localb3.ahd) {
          break label1002;
        }
        localb3.ahd -= 1;
        localb1 = localai.aoH.b(4, localb2.ahb, 1, localb3.ahc);
        break label1002;
        label1149:
        if (localb2.ahb >= localb3.ahb + localb3.ahd) {
          break label1027;
        }
        i = localb3.ahb + localb3.ahd - localb2.ahb;
        localObject = localai.aoH.b(4, localb2.ahb + 1, i, localb3.ahc);
        localb3.ahd -= i;
        break label1027;
        label1227:
        localArrayList.remove(j);
        localai.aoH.c(localb3);
      }
      label1251:
      int i4 = this.agU.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localb1 = (b)this.agU.get(i2);
        switch (localb1.BX)
        {
        }
        for (;;)
        {
          if (this.agX != null) {
            this.agX.run();
          }
          i2 += 1;
          break;
          b(localb1);
          continue;
          int i3 = localb1.ahb;
          i = localb1.ahb;
          j = localb1.ahd + i;
          i1 = -1;
          i = localb1.ahb;
          n = 0;
          if (i < j)
          {
            k = 0;
            m = 0;
            if ((this.agW.bF(i) != null) || (bB(i)))
            {
              if (i1 == 0)
              {
                a(b(2, i3, n, null));
                m = 1;
              }
              k = 1;
              label1458:
              if (m == 0) {
                break label1528;
              }
              m = i - n;
              j -= n;
            }
            for (i = 1;; i = n)
            {
              m += 1;
              n = i;
              i = m;
              i1 = k;
              break;
              if (i1 == 1)
              {
                b(b(2, i3, n, null));
                k = 1;
              }
              i1 = 0;
              m = k;
              k = i1;
              break label1458;
              label1528:
              n += 1;
              m = i;
            }
          }
          localObject = localb1;
          if (n != localb1.ahd)
          {
            c(localb1);
            localObject = b(2, i3, n, null);
          }
          if (i1 == 0)
          {
            a((b)localObject);
          }
          else
          {
            b((b)localObject);
            continue;
            j = localb1.ahb;
            k = 0;
            int i5 = localb1.ahb;
            int i6 = localb1.ahd;
            i3 = -1;
            i = localb1.ahb;
            if (i < i5 + i6)
            {
              if ((this.agW.bF(i) != null) || (bB(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(b(4, j, k, localb1.ahc));
                  i1 = 0;
                  n = i;
                }
                m = 1;
                j = n;
              }
              for (;;)
              {
                k = i1 + 1;
                i += 1;
                i3 = m;
                break;
                n = j;
                m = k;
                if (i3 == 1)
                {
                  b(b(4, j, k, localb1.ahc));
                  m = 0;
                  n = i;
                }
                k = 0;
                j = n;
                i1 = m;
                m = k;
              }
            }
            localObject = localb1;
            if (k != localb1.ahd)
            {
              localObject = localb1.ahc;
              c(localb1);
              localObject = b(4, j, k, localObject);
            }
            if (i3 == 0)
            {
              a((b)localObject);
            }
            else
            {
              b((b)localObject);
              continue;
              b(localb1);
            }
          }
        }
      }
      this.agU.clear();
      return;
    }
  }
  
  final void iu()
  {
    int j = this.agV.size();
    int i = 0;
    while (i < j)
    {
      this.agW.e((b)this.agV.get(i));
      i += 1;
    }
    n(this.agV);
    this.aha = 0;
  }
  
  final boolean iv()
  {
    return this.agU.size() > 0;
  }
  
  final void iw()
  {
    iu();
    int j = this.agU.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.agU.get(i);
      switch (localb.BX)
      {
      }
      for (;;)
      {
        if (this.agX != null) {
          this.agX.run();
        }
        i += 1;
        break;
        this.agW.e(localb);
        this.agW.O(localb.ahb, localb.ahd);
        continue;
        this.agW.e(localb);
        this.agW.M(localb.ahb, localb.ahd);
        continue;
        this.agW.e(localb);
        this.agW.d(localb.ahb, localb.ahd, localb.ahc);
        continue;
        this.agW.e(localb);
        this.agW.P(localb.ahb, localb.ahd);
      }
    }
    n(this.agU);
    this.aha = 0;
  }
  
  final boolean ix()
  {
    return (!this.agV.isEmpty()) && (!this.agU.isEmpty());
  }
  
  final void reset()
  {
    n(this.agU);
    n(this.agV);
    this.aha = 0;
  }
  
  static abstract interface a
  {
    public abstract void M(int paramInt1, int paramInt2);
    
    public abstract void N(int paramInt1, int paramInt2);
    
    public abstract void O(int paramInt1, int paramInt2);
    
    public abstract void P(int paramInt1, int paramInt2);
    
    public abstract RecyclerView.v bF(int paramInt);
    
    public abstract void d(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void d(d.b paramb);
    
    public abstract void e(d.b paramb);
  }
  
  static final class b
  {
    int BX;
    int ahb;
    Object ahc;
    int ahd;
    
    b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.BX = paramInt1;
      this.ahb = paramInt2;
      this.ahd = paramInt3;
      this.ahc = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
              return false;
            }
            paramObject = (b)paramObject;
            if (this.BX != paramObject.BX) {
              return false;
            }
          } while ((this.BX == 8) && (Math.abs(this.ahd - this.ahb) == 1) && (this.ahd == paramObject.ahb) && (this.ahb == paramObject.ahd));
          if (this.ahd != paramObject.ahd) {
            return false;
          }
          if (this.ahb != paramObject.ahb) {
            return false;
          }
          if (this.ahc == null) {
            break;
          }
        } while (this.ahc.equals(paramObject.ahc));
        return false;
      } while (paramObject.ahc == null);
      return false;
    }
    
    public final int hashCode()
    {
      return (this.BX * 31 + this.ahb) * 31 + this.ahd;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
      String str;
      switch (this.BX)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        str = "??";
      }
      for (;;)
      {
        return str + ",s:" + this.ahb + "c:" + this.ahd + ",p:" + this.ahc + "]";
        str = "add";
        continue;
        str = "rm";
        continue;
        str = "up";
        continue;
        str = "mv";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.d
 * JD-Core Version:    0.7.0.1
 */