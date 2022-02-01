package android.support.v7.widget;

import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import java.util.ArrayList;
import java.util.List;

final class d
  implements ai.a
{
  private l.a<b> ajR = new l.b(30);
  final ArrayList<b> ajS = new ArrayList();
  final ArrayList<b> ajT = new ArrayList();
  final a ajU;
  Runnable ajV;
  final boolean ajW;
  final ai ajX;
  int ajY = 0;
  
  d(a parama)
  {
    this(parama, (byte)0);
  }
  
  private d(a parama, byte paramByte)
  {
    this.ajU = parama;
    this.ajW = false;
    this.ajX = new ai(this);
  }
  
  private int L(int paramInt1, int paramInt2)
  {
    int i = this.ajT.size() - 1;
    b localb;
    if (i >= 0)
    {
      localb = (b)this.ajT.get(i);
      int k;
      int j;
      if (localb.EX == 8) {
        if (localb.ajZ < localb.akb)
        {
          k = localb.ajZ;
          j = localb.akb;
          label64:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label195;
          }
          if (k != localb.ajZ) {
            break label151;
          }
          if (paramInt2 != 1) {
            break label131;
          }
          localb.akb += 1;
          label103:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.akb;
        j = localb.ajZ;
        break label64;
        label131:
        if (paramInt2 != 2) {
          break label103;
        }
        localb.akb -= 1;
        break label103;
        label151:
        if (paramInt2 == 1) {
          localb.ajZ += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.ajZ -= 1;
          }
        }
        label195:
        if (paramInt1 < localb.ajZ)
        {
          if (paramInt2 == 1)
          {
            localb.ajZ += 1;
            localb.akb += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.ajZ -= 1;
            localb.akb -= 1;
          }
        }
        continue;
        if (localb.ajZ <= paramInt1)
        {
          if (localb.EX == 1) {
            paramInt1 -= localb.akb;
          } else if (localb.EX == 2) {
            paramInt1 = localb.akb + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.ajZ += 1;
        } else if (paramInt2 == 2) {
          localb.ajZ -= 1;
        }
      }
    }
    paramInt2 = this.ajT.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (b)this.ajT.get(paramInt2);
      if (localb.EX == 8) {
        if ((localb.akb == localb.ajZ) || (localb.akb < 0))
        {
          this.ajT.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.akb <= 0)
        {
          this.ajT.remove(paramInt2);
          c(localb);
        }
      }
    }
    return paramInt1;
  }
  
  private void a(b paramb)
  {
    if ((paramb.EX == 1) || (paramb.EX == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = L(paramb.ajZ, paramb.EX);
    int j = paramb.ajZ;
    int k;
    int m;
    int n;
    label102:
    int i2;
    switch (paramb.EX)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(paramb)));
    case 4: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramb.akb) {
        break label286;
      }
      i2 = L(paramb.ajZ + k * m, paramb.EX);
      switch (paramb.EX)
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
      localObject = a(paramb.EX, i1, n, paramb.aka);
      a((b)localObject, j);
      c((b)localObject);
      i = j;
      if (paramb.EX == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label286:
    Object localObject = paramb.aka;
    c(paramb);
    if (n > 0)
    {
      paramb = a(paramb.EX, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
  }
  
  private void a(b paramb, int paramInt)
  {
    this.ajU.d(paramb);
    switch (paramb.EX)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.ajU.N(paramInt, paramb.akb);
      return;
    }
    this.ajU.d(paramInt, paramb.akb, paramb.aka);
  }
  
  private void b(b paramb)
  {
    this.ajT.add(paramb);
    switch (paramb.EX)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(paramb)));
    case 1: 
      this.ajU.P(paramb.ajZ, paramb.akb);
      return;
    case 8: 
      this.ajU.Q(paramb.ajZ, paramb.akb);
      return;
    case 2: 
      this.ajU.O(paramb.ajZ, paramb.akb);
      return;
    }
    this.ajU.d(paramb.ajZ, paramb.akb, paramb.aka);
  }
  
  private boolean bC(int paramInt)
  {
    int k = this.ajT.size();
    int i = 0;
    while (i < k)
    {
      b localb = (b)this.ajT.get(i);
      if (localb.EX == 8)
      {
        if (M(localb.akb, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localb.EX == 1)
      {
        int m = localb.ajZ;
        int n = localb.akb;
        int j = localb.ajZ;
        while (j < m + n)
        {
          if (M(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void m(List<b> paramList)
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
  
  final int M(int paramInt1, int paramInt2)
  {
    int k = this.ajT.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    b localb;
    if (j < k)
    {
      localb = (b)this.ajT.get(j);
      if (localb.EX == 8) {
        if (localb.ajZ == paramInt2) {
          paramInt1 = localb.akb;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localb.ajZ < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localb.akb <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localb.ajZ <= paramInt2) {
          if (localb.EX == 2)
          {
            if (paramInt2 < localb.ajZ + localb.akb)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localb.akb;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localb.EX == 1) {
              paramInt1 = paramInt2 + localb.akb;
            }
          }
        }
      }
    }
  }
  
  public final b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    b localb = (b)this.ajR.acquire();
    if (localb == null) {
      return new b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.EX = paramInt1;
    localb.ajZ = paramInt2;
    localb.akb = paramInt3;
    localb.aka = paramObject;
    return localb;
  }
  
  final boolean bD(int paramInt)
  {
    return (this.ajY & paramInt) != 0;
  }
  
  final int bE(int paramInt)
  {
    return M(paramInt, 0);
  }
  
  public final int bF(int paramInt)
  {
    int m = this.ajS.size();
    int k = 0;
    int i = paramInt;
    paramInt = i;
    b localb;
    if (k < m)
    {
      localb = (b)this.ajS.get(k);
      switch (localb.EX)
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
      if (localb.ajZ <= i)
      {
        paramInt = i + localb.akb;
        continue;
        paramInt = i;
        if (localb.ajZ <= i)
        {
          if (localb.ajZ + localb.akb > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - localb.akb;
          continue;
          if (localb.ajZ == i)
          {
            paramInt = localb.akb;
          }
          else
          {
            int j = i;
            if (localb.ajZ < i) {
              j = i - 1;
            }
            paramInt = j;
            if (localb.akb <= j) {
              paramInt = j + 1;
            }
          }
        }
      }
    }
  }
  
  public final void c(b paramb)
  {
    if (!this.ajW)
    {
      paramb.aka = null;
      this.ajR.release(paramb);
    }
  }
  
  final void ja()
  {
    ai localai = this.ajX;
    ArrayList localArrayList = this.ajS;
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
      if (((b)localArrayList.get(i)).EX != 8) {
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
      switch (localb3.EX)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.akb < localb3.ajZ) {
          i = -1;
        }
        k = i;
        if (localb2.ajZ < localb3.ajZ) {
          k = i + 1;
        }
        if (localb3.ajZ <= localb2.ajZ) {
          localb2.ajZ += localb3.akb;
        }
        if (localb3.ajZ <= localb2.akb) {
          localb2.akb += localb3.akb;
        }
        localb3.ajZ = (k + localb3.ajZ);
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
      if (localb2.ajZ < localb2.akb)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.ajZ == localb2.ajZ)
        {
          k = n;
          i = m;
          if (localb3.akb == localb2.akb - localb2.ajZ)
          {
            i = 1;
            k = n;
          }
        }
        label344:
        if (localb2.akb >= localb3.ajZ) {
          break label491;
        }
        localb3.ajZ -= 1;
        label369:
        if (localb2.ajZ > localb3.ajZ) {
          break label567;
        }
        localb3.ajZ += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label655;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localai.arH.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.ajZ != localb2.akb + 1) {
          break label344;
        }
        k = n;
        i = m;
        if (localb3.akb != localb2.ajZ - localb2.akb) {
          break label344;
        }
        i = 1;
        k = n;
        break label344;
        label491:
        if (localb2.akb >= localb3.ajZ + localb3.akb) {
          break label369;
        }
        localb3.akb -= 1;
        localb2.EX = 2;
        localb2.akb = 1;
        if (localb3.akb != 0) {
          break;
        }
        localArrayList.remove(i1);
        localai.arH.c(localb3);
        break;
        label567:
        if (localb2.ajZ < localb3.ajZ + localb3.akb)
        {
          m = localb3.ajZ;
          n = localb3.akb;
          i2 = localb2.ajZ;
          localb1 = localai.arH.a(2, localb2.ajZ + 1, m + n - i2, null);
          localb3.akb = (localb2.ajZ - localb3.ajZ);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.ajZ > localb1.ajZ) {
            localb2.ajZ -= localb1.akb;
          }
          if (localb2.akb > localb1.ajZ) {
            localb2.akb -= localb1.akb;
          }
        }
        if (localb2.ajZ > localb3.ajZ) {
          localb2.ajZ -= localb3.akb;
        }
        if (localb2.akb > localb3.ajZ) {
          localb2.akb -= localb3.akb;
        }
        localArrayList.set(j, localb3);
        if (localb2.ajZ == localb2.akb) {
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
          if (localb2.ajZ >= localb1.ajZ) {
            localb2.ajZ -= localb1.akb;
          }
          if (localb2.akb >= localb1.ajZ) {
            localb2.akb -= localb1.akb;
          }
        }
        if (localb2.ajZ >= localb3.ajZ) {
          localb2.ajZ -= localb3.akb;
        }
        if (localb2.akb < localb3.ajZ) {
          break label780;
        }
        localb2.akb -= localb3.akb;
        break label780;
        label958:
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.akb < localb3.ajZ)
      {
        localb3.ajZ -= 1;
        label1002:
        if (localb2.ajZ > localb3.ajZ) {
          break label1149;
        }
        localb3.ajZ += 1;
        localArrayList.set(i1, localb2);
        if (localb3.akb <= 0) {
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
        if (localb2.akb >= localb3.ajZ + localb3.akb) {
          break label1002;
        }
        localb3.akb -= 1;
        localb1 = localai.arH.a(4, localb2.ajZ, 1, localb3.aka);
        break label1002;
        label1149:
        if (localb2.ajZ >= localb3.ajZ + localb3.akb) {
          break label1027;
        }
        i = localb3.ajZ + localb3.akb - localb2.ajZ;
        localObject = localai.arH.a(4, localb2.ajZ + 1, i, localb3.aka);
        localb3.akb -= i;
        break label1027;
        label1227:
        localArrayList.remove(j);
        localai.arH.c(localb3);
      }
      label1251:
      int i4 = this.ajS.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localb1 = (b)this.ajS.get(i2);
        switch (localb1.EX)
        {
        }
        for (;;)
        {
          if (this.ajV != null) {
            this.ajV.run();
          }
          i2 += 1;
          break;
          b(localb1);
          continue;
          int i3 = localb1.ajZ;
          i = localb1.ajZ;
          j = localb1.akb + i;
          i1 = -1;
          i = localb1.ajZ;
          n = 0;
          if (i < j)
          {
            k = 0;
            m = 0;
            if ((this.ajU.bG(i) != null) || (bC(i)))
            {
              if (i1 == 0)
              {
                a(a(2, i3, n, null));
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
                b(a(2, i3, n, null));
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
          if (n != localb1.akb)
          {
            c(localb1);
            localObject = a(2, i3, n, null);
          }
          if (i1 == 0)
          {
            a((b)localObject);
          }
          else
          {
            b((b)localObject);
            continue;
            j = localb1.ajZ;
            k = 0;
            int i5 = localb1.ajZ;
            int i6 = localb1.akb;
            i3 = -1;
            i = localb1.ajZ;
            if (i < i5 + i6)
            {
              if ((this.ajU.bG(i) != null) || (bC(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(a(4, j, k, localb1.aka));
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
                  b(a(4, j, k, localb1.aka));
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
            if (k != localb1.akb)
            {
              localObject = localb1.aka;
              c(localb1);
              localObject = a(4, j, k, localObject);
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
      this.ajS.clear();
      return;
    }
  }
  
  final void jb()
  {
    int j = this.ajT.size();
    int i = 0;
    while (i < j)
    {
      this.ajU.e((b)this.ajT.get(i));
      i += 1;
    }
    m(this.ajT);
    this.ajY = 0;
  }
  
  final boolean jc()
  {
    return this.ajS.size() > 0;
  }
  
  final void jd()
  {
    jb();
    int j = this.ajS.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.ajS.get(i);
      switch (localb.EX)
      {
      }
      for (;;)
      {
        if (this.ajV != null) {
          this.ajV.run();
        }
        i += 1;
        break;
        this.ajU.e(localb);
        this.ajU.P(localb.ajZ, localb.akb);
        continue;
        this.ajU.e(localb);
        this.ajU.N(localb.ajZ, localb.akb);
        continue;
        this.ajU.e(localb);
        this.ajU.d(localb.ajZ, localb.akb, localb.aka);
        continue;
        this.ajU.e(localb);
        this.ajU.Q(localb.ajZ, localb.akb);
      }
    }
    m(this.ajS);
    this.ajY = 0;
  }
  
  final boolean je()
  {
    return (!this.ajT.isEmpty()) && (!this.ajS.isEmpty());
  }
  
  final void reset()
  {
    m(this.ajS);
    m(this.ajT);
    this.ajY = 0;
  }
  
  static abstract interface a
  {
    public abstract void N(int paramInt1, int paramInt2);
    
    public abstract void O(int paramInt1, int paramInt2);
    
    public abstract void P(int paramInt1, int paramInt2);
    
    public abstract void Q(int paramInt1, int paramInt2);
    
    public abstract RecyclerView.v bG(int paramInt);
    
    public abstract void d(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void d(d.b paramb);
    
    public abstract void e(d.b paramb);
  }
  
  static final class b
  {
    int EX;
    int ajZ;
    Object aka;
    int akb;
    
    b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.EX = paramInt1;
      this.ajZ = paramInt2;
      this.akb = paramInt3;
      this.aka = paramObject;
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
            if (this.EX != paramObject.EX) {
              return false;
            }
          } while ((this.EX == 8) && (Math.abs(this.akb - this.ajZ) == 1) && (this.akb == paramObject.ajZ) && (this.ajZ == paramObject.akb));
          if (this.akb != paramObject.akb) {
            return false;
          }
          if (this.ajZ != paramObject.ajZ) {
            return false;
          }
          if (this.aka == null) {
            break;
          }
        } while (this.aka.equals(paramObject.aka));
        return false;
      } while (paramObject.aka == null);
      return false;
    }
    
    public final int hashCode()
    {
      return (this.EX * 31 + this.ajZ) * 31 + this.akb;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
      String str;
      switch (this.EX)
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
        return str + ",s:" + this.ajZ + "c:" + this.akb + ",p:" + this.aka + "]";
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