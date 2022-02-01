package android.support.v7.widget;

import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import java.util.ArrayList;
import java.util.List;

final class d
  implements ai.a
{
  private l.a<b> ahN = new l.b(30);
  final ArrayList<b> ahO = new ArrayList();
  final ArrayList<b> ahP = new ArrayList();
  final a ahQ;
  Runnable ahR;
  final boolean ahS;
  final ai ahT;
  int ahU = 0;
  
  d(a parama)
  {
    this(parama, (byte)0);
  }
  
  private d(a parama, byte paramByte)
  {
    this.ahQ = parama;
    this.ahS = false;
    this.ahT = new ai(this);
  }
  
  private int K(int paramInt1, int paramInt2)
  {
    int i = this.ahP.size() - 1;
    b localb;
    if (i >= 0)
    {
      localb = (b)this.ahP.get(i);
      int k;
      int j;
      if (localb.CW == 8) {
        if (localb.ahV < localb.ahX)
        {
          k = localb.ahV;
          j = localb.ahX;
          label64:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label195;
          }
          if (k != localb.ahV) {
            break label151;
          }
          if (paramInt2 != 1) {
            break label131;
          }
          localb.ahX += 1;
          label103:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.ahX;
        j = localb.ahV;
        break label64;
        label131:
        if (paramInt2 != 2) {
          break label103;
        }
        localb.ahX -= 1;
        break label103;
        label151:
        if (paramInt2 == 1) {
          localb.ahV += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.ahV -= 1;
          }
        }
        label195:
        if (paramInt1 < localb.ahV)
        {
          if (paramInt2 == 1)
          {
            localb.ahV += 1;
            localb.ahX += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.ahV -= 1;
            localb.ahX -= 1;
          }
        }
        continue;
        if (localb.ahV <= paramInt1)
        {
          if (localb.CW == 1) {
            paramInt1 -= localb.ahX;
          } else if (localb.CW == 2) {
            paramInt1 = localb.ahX + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.ahV += 1;
        } else if (paramInt2 == 2) {
          localb.ahV -= 1;
        }
      }
    }
    paramInt2 = this.ahP.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (b)this.ahP.get(paramInt2);
      if (localb.CW == 8) {
        if ((localb.ahX == localb.ahV) || (localb.ahX < 0))
        {
          this.ahP.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.ahX <= 0)
        {
          this.ahP.remove(paramInt2);
          c(localb);
        }
      }
    }
    return paramInt1;
  }
  
  private void a(b paramb)
  {
    if ((paramb.CW == 1) || (paramb.CW == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = K(paramb.ahV, paramb.CW);
    int j = paramb.ahV;
    int k;
    int m;
    int n;
    label102:
    int i2;
    switch (paramb.CW)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(paramb)));
    case 4: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramb.ahX) {
        break label286;
      }
      i2 = K(paramb.ahV + k * m, paramb.CW);
      switch (paramb.CW)
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
      localObject = b(paramb.CW, i1, n, paramb.ahW);
      a((b)localObject, j);
      c((b)localObject);
      i = j;
      if (paramb.CW == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label286:
    Object localObject = paramb.ahW;
    c(paramb);
    if (n > 0)
    {
      paramb = b(paramb.CW, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
  }
  
  private void a(b paramb, int paramInt)
  {
    this.ahQ.d(paramb);
    switch (paramb.CW)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.ahQ.M(paramInt, paramb.ahX);
      return;
    }
    this.ahQ.d(paramInt, paramb.ahX, paramb.ahW);
  }
  
  private void b(b paramb)
  {
    this.ahP.add(paramb);
    switch (paramb.CW)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(paramb)));
    case 1: 
      this.ahQ.O(paramb.ahV, paramb.ahX);
      return;
    case 8: 
      this.ahQ.P(paramb.ahV, paramb.ahX);
      return;
    case 2: 
      this.ahQ.N(paramb.ahV, paramb.ahX);
      return;
    }
    this.ahQ.d(paramb.ahV, paramb.ahX, paramb.ahW);
  }
  
  private boolean bB(int paramInt)
  {
    int k = this.ahP.size();
    int i = 0;
    while (i < k)
    {
      b localb = (b)this.ahP.get(i);
      if (localb.CW == 8)
      {
        if (L(localb.ahX, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localb.CW == 1)
      {
        int m = localb.ahV;
        int n = localb.ahX;
        int j = localb.ahV;
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
  
  final int L(int paramInt1, int paramInt2)
  {
    int k = this.ahP.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    b localb;
    if (j < k)
    {
      localb = (b)this.ahP.get(j);
      if (localb.CW == 8) {
        if (localb.ahV == paramInt2) {
          paramInt1 = localb.ahX;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localb.ahV < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localb.ahX <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localb.ahV <= paramInt2) {
          if (localb.CW == 2)
          {
            if (paramInt2 < localb.ahV + localb.ahX)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localb.ahX;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localb.CW == 1) {
              paramInt1 = paramInt2 + localb.ahX;
            }
          }
        }
      }
    }
  }
  
  public final b b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    b localb = (b)this.ahN.acquire();
    if (localb == null) {
      return new b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.CW = paramInt1;
    localb.ahV = paramInt2;
    localb.ahX = paramInt3;
    localb.ahW = paramObject;
    return localb;
  }
  
  final boolean bC(int paramInt)
  {
    return (this.ahU & paramInt) != 0;
  }
  
  final int bD(int paramInt)
  {
    return L(paramInt, 0);
  }
  
  public final int bE(int paramInt)
  {
    int m = this.ahO.size();
    int k = 0;
    int i = paramInt;
    paramInt = i;
    b localb;
    if (k < m)
    {
      localb = (b)this.ahO.get(k);
      switch (localb.CW)
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
      if (localb.ahV <= i)
      {
        paramInt = i + localb.ahX;
        continue;
        paramInt = i;
        if (localb.ahV <= i)
        {
          if (localb.ahV + localb.ahX > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - localb.ahX;
          continue;
          if (localb.ahV == i)
          {
            paramInt = localb.ahX;
          }
          else
          {
            int j = i;
            if (localb.ahV < i) {
              j = i - 1;
            }
            paramInt = j;
            if (localb.ahX <= j) {
              paramInt = j + 1;
            }
          }
        }
      }
    }
  }
  
  public final void c(b paramb)
  {
    if (!this.ahS)
    {
      paramb.ahW = null;
      this.ahN.release(paramb);
    }
  }
  
  final void iB()
  {
    ai localai = this.ahT;
    ArrayList localArrayList = this.ahO;
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
      if (((b)localArrayList.get(i)).CW != 8) {
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
      switch (localb3.CW)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.ahX < localb3.ahV) {
          i = -1;
        }
        k = i;
        if (localb2.ahV < localb3.ahV) {
          k = i + 1;
        }
        if (localb3.ahV <= localb2.ahV) {
          localb2.ahV += localb3.ahX;
        }
        if (localb3.ahV <= localb2.ahX) {
          localb2.ahX += localb3.ahX;
        }
        localb3.ahV = (k + localb3.ahV);
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
      if (localb2.ahV < localb2.ahX)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.ahV == localb2.ahV)
        {
          k = n;
          i = m;
          if (localb3.ahX == localb2.ahX - localb2.ahV)
          {
            i = 1;
            k = n;
          }
        }
        label344:
        if (localb2.ahX >= localb3.ahV) {
          break label491;
        }
        localb3.ahV -= 1;
        label369:
        if (localb2.ahV > localb3.ahV) {
          break label567;
        }
        localb3.ahV += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label655;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localai.apD.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.ahV != localb2.ahX + 1) {
          break label344;
        }
        k = n;
        i = m;
        if (localb3.ahX != localb2.ahV - localb2.ahX) {
          break label344;
        }
        i = 1;
        k = n;
        break label344;
        label491:
        if (localb2.ahX >= localb3.ahV + localb3.ahX) {
          break label369;
        }
        localb3.ahX -= 1;
        localb2.CW = 2;
        localb2.ahX = 1;
        if (localb3.ahX != 0) {
          break;
        }
        localArrayList.remove(i1);
        localai.apD.c(localb3);
        break;
        label567:
        if (localb2.ahV < localb3.ahV + localb3.ahX)
        {
          m = localb3.ahV;
          n = localb3.ahX;
          i2 = localb2.ahV;
          localb1 = localai.apD.b(2, localb2.ahV + 1, m + n - i2, null);
          localb3.ahX = (localb2.ahV - localb3.ahV);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.ahV > localb1.ahV) {
            localb2.ahV -= localb1.ahX;
          }
          if (localb2.ahX > localb1.ahV) {
            localb2.ahX -= localb1.ahX;
          }
        }
        if (localb2.ahV > localb3.ahV) {
          localb2.ahV -= localb3.ahX;
        }
        if (localb2.ahX > localb3.ahV) {
          localb2.ahX -= localb3.ahX;
        }
        localArrayList.set(j, localb3);
        if (localb2.ahV == localb2.ahX) {
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
          if (localb2.ahV >= localb1.ahV) {
            localb2.ahV -= localb1.ahX;
          }
          if (localb2.ahX >= localb1.ahV) {
            localb2.ahX -= localb1.ahX;
          }
        }
        if (localb2.ahV >= localb3.ahV) {
          localb2.ahV -= localb3.ahX;
        }
        if (localb2.ahX < localb3.ahV) {
          break label780;
        }
        localb2.ahX -= localb3.ahX;
        break label780;
        label958:
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.ahX < localb3.ahV)
      {
        localb3.ahV -= 1;
        label1002:
        if (localb2.ahV > localb3.ahV) {
          break label1149;
        }
        localb3.ahV += 1;
        localArrayList.set(i1, localb2);
        if (localb3.ahX <= 0) {
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
        if (localb2.ahX >= localb3.ahV + localb3.ahX) {
          break label1002;
        }
        localb3.ahX -= 1;
        localb1 = localai.apD.b(4, localb2.ahV, 1, localb3.ahW);
        break label1002;
        label1149:
        if (localb2.ahV >= localb3.ahV + localb3.ahX) {
          break label1027;
        }
        i = localb3.ahV + localb3.ahX - localb2.ahV;
        localObject = localai.apD.b(4, localb2.ahV + 1, i, localb3.ahW);
        localb3.ahX -= i;
        break label1027;
        label1227:
        localArrayList.remove(j);
        localai.apD.c(localb3);
      }
      label1251:
      int i4 = this.ahO.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localb1 = (b)this.ahO.get(i2);
        switch (localb1.CW)
        {
        }
        for (;;)
        {
          if (this.ahR != null) {
            this.ahR.run();
          }
          i2 += 1;
          break;
          b(localb1);
          continue;
          int i3 = localb1.ahV;
          i = localb1.ahV;
          j = localb1.ahX + i;
          i1 = -1;
          i = localb1.ahV;
          n = 0;
          if (i < j)
          {
            k = 0;
            m = 0;
            if ((this.ahQ.bF(i) != null) || (bB(i)))
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
          if (n != localb1.ahX)
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
            j = localb1.ahV;
            k = 0;
            int i5 = localb1.ahV;
            int i6 = localb1.ahX;
            i3 = -1;
            i = localb1.ahV;
            if (i < i5 + i6)
            {
              if ((this.ahQ.bF(i) != null) || (bB(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(b(4, j, k, localb1.ahW));
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
                  b(b(4, j, k, localb1.ahW));
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
            if (k != localb1.ahX)
            {
              localObject = localb1.ahW;
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
      this.ahO.clear();
      return;
    }
  }
  
  final void iC()
  {
    int j = this.ahP.size();
    int i = 0;
    while (i < j)
    {
      this.ahQ.e((b)this.ahP.get(i));
      i += 1;
    }
    m(this.ahP);
    this.ahU = 0;
  }
  
  final boolean iD()
  {
    return this.ahO.size() > 0;
  }
  
  final void iE()
  {
    iC();
    int j = this.ahO.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.ahO.get(i);
      switch (localb.CW)
      {
      }
      for (;;)
      {
        if (this.ahR != null) {
          this.ahR.run();
        }
        i += 1;
        break;
        this.ahQ.e(localb);
        this.ahQ.O(localb.ahV, localb.ahX);
        continue;
        this.ahQ.e(localb);
        this.ahQ.M(localb.ahV, localb.ahX);
        continue;
        this.ahQ.e(localb);
        this.ahQ.d(localb.ahV, localb.ahX, localb.ahW);
        continue;
        this.ahQ.e(localb);
        this.ahQ.P(localb.ahV, localb.ahX);
      }
    }
    m(this.ahO);
    this.ahU = 0;
  }
  
  final boolean iF()
  {
    return (!this.ahP.isEmpty()) && (!this.ahO.isEmpty());
  }
  
  final void reset()
  {
    m(this.ahO);
    m(this.ahP);
    this.ahU = 0;
  }
  
  static abstract interface a
  {
    public abstract void M(int paramInt1, int paramInt2);
    
    public abstract void N(int paramInt1, int paramInt2);
    
    public abstract void O(int paramInt1, int paramInt2);
    
    public abstract void P(int paramInt1, int paramInt2);
    
    public abstract RecyclerView.w bF(int paramInt);
    
    public abstract void d(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void d(d.b paramb);
    
    public abstract void e(d.b paramb);
  }
  
  static final class b
  {
    int CW;
    int ahV;
    Object ahW;
    int ahX;
    
    b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.CW = paramInt1;
      this.ahV = paramInt2;
      this.ahX = paramInt3;
      this.ahW = paramObject;
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
            if (this.CW != paramObject.CW) {
              return false;
            }
          } while ((this.CW == 8) && (Math.abs(this.ahX - this.ahV) == 1) && (this.ahX == paramObject.ahV) && (this.ahV == paramObject.ahX));
          if (this.ahX != paramObject.ahX) {
            return false;
          }
          if (this.ahV != paramObject.ahV) {
            return false;
          }
          if (this.ahW == null) {
            break;
          }
        } while (this.ahW.equals(paramObject.ahW));
        return false;
      } while (paramObject.ahW == null);
      return false;
    }
    
    public final int hashCode()
    {
      return (this.CW * 31 + this.ahV) * 31 + this.ahX;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
      String str;
      switch (this.CW)
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
        return str + ",s:" + this.ahV + "c:" + this.ahX + ",p:" + this.ahW + "]";
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