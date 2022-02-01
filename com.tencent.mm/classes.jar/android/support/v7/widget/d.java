package android.support.v7.widget;

import android.support.v4.e.l.a;
import android.support.v4.e.l.b;
import java.util.ArrayList;
import java.util.List;

final class d
  implements ai.a
{
  private l.a<b> ajE = new l.b(30);
  final ArrayList<b> ajF = new ArrayList();
  final ArrayList<b> ajG = new ArrayList();
  final a ajH;
  Runnable ajI;
  final boolean ajJ;
  final ai ajK;
  int ajL = 0;
  
  d(a parama)
  {
    this(parama, (byte)0);
  }
  
  private d(a parama, byte paramByte)
  {
    this.ajH = parama;
    this.ajJ = false;
    this.ajK = new ai(this);
  }
  
  private int L(int paramInt1, int paramInt2)
  {
    int i = this.ajG.size() - 1;
    b localb;
    if (i >= 0)
    {
      localb = (b)this.ajG.get(i);
      int k;
      int j;
      if (localb.EN == 8) {
        if (localb.ajM < localb.ajO)
        {
          k = localb.ajM;
          j = localb.ajO;
          label64:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label195;
          }
          if (k != localb.ajM) {
            break label151;
          }
          if (paramInt2 != 1) {
            break label131;
          }
          localb.ajO += 1;
          label103:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.ajO;
        j = localb.ajM;
        break label64;
        label131:
        if (paramInt2 != 2) {
          break label103;
        }
        localb.ajO -= 1;
        break label103;
        label151:
        if (paramInt2 == 1) {
          localb.ajM += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.ajM -= 1;
          }
        }
        label195:
        if (paramInt1 < localb.ajM)
        {
          if (paramInt2 == 1)
          {
            localb.ajM += 1;
            localb.ajO += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.ajM -= 1;
            localb.ajO -= 1;
          }
        }
        continue;
        if (localb.ajM <= paramInt1)
        {
          if (localb.EN == 1) {
            paramInt1 -= localb.ajO;
          } else if (localb.EN == 2) {
            paramInt1 = localb.ajO + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.ajM += 1;
        } else if (paramInt2 == 2) {
          localb.ajM -= 1;
        }
      }
    }
    paramInt2 = this.ajG.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (b)this.ajG.get(paramInt2);
      if (localb.EN == 8) {
        if ((localb.ajO == localb.ajM) || (localb.ajO < 0))
        {
          this.ajG.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.ajO <= 0)
        {
          this.ajG.remove(paramInt2);
          c(localb);
        }
      }
    }
    return paramInt1;
  }
  
  private void a(b paramb)
  {
    if ((paramb.EN == 1) || (paramb.EN == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = L(paramb.ajM, paramb.EN);
    int j = paramb.ajM;
    int k;
    int m;
    int n;
    label102:
    int i2;
    switch (paramb.EN)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(paramb)));
    case 4: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramb.ajO) {
        break label286;
      }
      i2 = L(paramb.ajM + k * m, paramb.EN);
      switch (paramb.EN)
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
      localObject = b(paramb.EN, i1, n, paramb.ajN);
      a((b)localObject, j);
      c((b)localObject);
      i = j;
      if (paramb.EN == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label286:
    Object localObject = paramb.ajN;
    c(paramb);
    if (n > 0)
    {
      paramb = b(paramb.EN, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
  }
  
  private void a(b paramb, int paramInt)
  {
    this.ajH.d(paramb);
    switch (paramb.EN)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.ajH.N(paramInt, paramb.ajO);
      return;
    }
    this.ajH.d(paramInt, paramb.ajO, paramb.ajN);
  }
  
  private void b(b paramb)
  {
    this.ajG.add(paramb);
    switch (paramb.EN)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(paramb)));
    case 1: 
      this.ajH.P(paramb.ajM, paramb.ajO);
      return;
    case 8: 
      this.ajH.Q(paramb.ajM, paramb.ajO);
      return;
    case 2: 
      this.ajH.O(paramb.ajM, paramb.ajO);
      return;
    }
    this.ajH.d(paramb.ajM, paramb.ajO, paramb.ajN);
  }
  
  private boolean bB(int paramInt)
  {
    int k = this.ajG.size();
    int i = 0;
    while (i < k)
    {
      b localb = (b)this.ajG.get(i);
      if (localb.EN == 8)
      {
        if (M(localb.ajO, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localb.EN == 1)
      {
        int m = localb.ajM;
        int n = localb.ajO;
        int j = localb.ajM;
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
    int k = this.ajG.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    b localb;
    if (j < k)
    {
      localb = (b)this.ajG.get(j);
      if (localb.EN == 8) {
        if (localb.ajM == paramInt2) {
          paramInt1 = localb.ajO;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localb.ajM < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localb.ajO <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localb.ajM <= paramInt2) {
          if (localb.EN == 2)
          {
            if (paramInt2 < localb.ajM + localb.ajO)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localb.ajO;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localb.EN == 1) {
              paramInt1 = paramInt2 + localb.ajO;
            }
          }
        }
      }
    }
  }
  
  public final b b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    b localb = (b)this.ajE.acquire();
    if (localb == null) {
      return new b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.EN = paramInt1;
    localb.ajM = paramInt2;
    localb.ajO = paramInt3;
    localb.ajN = paramObject;
    return localb;
  }
  
  final boolean bC(int paramInt)
  {
    return (this.ajL & paramInt) != 0;
  }
  
  final int bD(int paramInt)
  {
    return M(paramInt, 0);
  }
  
  public final int bE(int paramInt)
  {
    int m = this.ajF.size();
    int k = 0;
    int i = paramInt;
    paramInt = i;
    b localb;
    if (k < m)
    {
      localb = (b)this.ajF.get(k);
      switch (localb.EN)
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
      if (localb.ajM <= i)
      {
        paramInt = i + localb.ajO;
        continue;
        paramInt = i;
        if (localb.ajM <= i)
        {
          if (localb.ajM + localb.ajO > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - localb.ajO;
          continue;
          if (localb.ajM == i)
          {
            paramInt = localb.ajO;
          }
          else
          {
            int j = i;
            if (localb.ajM < i) {
              j = i - 1;
            }
            paramInt = j;
            if (localb.ajO <= j) {
              paramInt = j + 1;
            }
          }
        }
      }
    }
  }
  
  public final void c(b paramb)
  {
    if (!this.ajJ)
    {
      paramb.ajN = null;
      this.ajE.release(paramb);
    }
  }
  
  final void iR()
  {
    ai localai = this.ajK;
    ArrayList localArrayList = this.ajF;
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
      if (((b)localArrayList.get(i)).EN != 8) {
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
      switch (localb3.EN)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.ajO < localb3.ajM) {
          i = -1;
        }
        k = i;
        if (localb2.ajM < localb3.ajM) {
          k = i + 1;
        }
        if (localb3.ajM <= localb2.ajM) {
          localb2.ajM += localb3.ajO;
        }
        if (localb3.ajM <= localb2.ajO) {
          localb2.ajO += localb3.ajO;
        }
        localb3.ajM = (k + localb3.ajM);
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
      if (localb2.ajM < localb2.ajO)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.ajM == localb2.ajM)
        {
          k = n;
          i = m;
          if (localb3.ajO == localb2.ajO - localb2.ajM)
          {
            i = 1;
            k = n;
          }
        }
        label344:
        if (localb2.ajO >= localb3.ajM) {
          break label491;
        }
        localb3.ajM -= 1;
        label369:
        if (localb2.ajM > localb3.ajM) {
          break label567;
        }
        localb3.ajM += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label655;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localai.arv.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.ajM != localb2.ajO + 1) {
          break label344;
        }
        k = n;
        i = m;
        if (localb3.ajO != localb2.ajM - localb2.ajO) {
          break label344;
        }
        i = 1;
        k = n;
        break label344;
        label491:
        if (localb2.ajO >= localb3.ajM + localb3.ajO) {
          break label369;
        }
        localb3.ajO -= 1;
        localb2.EN = 2;
        localb2.ajO = 1;
        if (localb3.ajO != 0) {
          break;
        }
        localArrayList.remove(i1);
        localai.arv.c(localb3);
        break;
        label567:
        if (localb2.ajM < localb3.ajM + localb3.ajO)
        {
          m = localb3.ajM;
          n = localb3.ajO;
          i2 = localb2.ajM;
          localb1 = localai.arv.b(2, localb2.ajM + 1, m + n - i2, null);
          localb3.ajO = (localb2.ajM - localb3.ajM);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.ajM > localb1.ajM) {
            localb2.ajM -= localb1.ajO;
          }
          if (localb2.ajO > localb1.ajM) {
            localb2.ajO -= localb1.ajO;
          }
        }
        if (localb2.ajM > localb3.ajM) {
          localb2.ajM -= localb3.ajO;
        }
        if (localb2.ajO > localb3.ajM) {
          localb2.ajO -= localb3.ajO;
        }
        localArrayList.set(j, localb3);
        if (localb2.ajM == localb2.ajO) {
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
          if (localb2.ajM >= localb1.ajM) {
            localb2.ajM -= localb1.ajO;
          }
          if (localb2.ajO >= localb1.ajM) {
            localb2.ajO -= localb1.ajO;
          }
        }
        if (localb2.ajM >= localb3.ajM) {
          localb2.ajM -= localb3.ajO;
        }
        if (localb2.ajO < localb3.ajM) {
          break label780;
        }
        localb2.ajO -= localb3.ajO;
        break label780;
        label958:
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.ajO < localb3.ajM)
      {
        localb3.ajM -= 1;
        label1002:
        if (localb2.ajM > localb3.ajM) {
          break label1149;
        }
        localb3.ajM += 1;
        localArrayList.set(i1, localb2);
        if (localb3.ajO <= 0) {
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
        if (localb2.ajO >= localb3.ajM + localb3.ajO) {
          break label1002;
        }
        localb3.ajO -= 1;
        localb1 = localai.arv.b(4, localb2.ajM, 1, localb3.ajN);
        break label1002;
        label1149:
        if (localb2.ajM >= localb3.ajM + localb3.ajO) {
          break label1027;
        }
        i = localb3.ajM + localb3.ajO - localb2.ajM;
        localObject = localai.arv.b(4, localb2.ajM + 1, i, localb3.ajN);
        localb3.ajO -= i;
        break label1027;
        label1227:
        localArrayList.remove(j);
        localai.arv.c(localb3);
      }
      label1251:
      int i4 = this.ajF.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localb1 = (b)this.ajF.get(i2);
        switch (localb1.EN)
        {
        }
        for (;;)
        {
          if (this.ajI != null) {
            this.ajI.run();
          }
          i2 += 1;
          break;
          b(localb1);
          continue;
          int i3 = localb1.ajM;
          i = localb1.ajM;
          j = localb1.ajO + i;
          i1 = -1;
          i = localb1.ajM;
          n = 0;
          if (i < j)
          {
            k = 0;
            m = 0;
            if ((this.ajH.bF(i) != null) || (bB(i)))
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
          if (n != localb1.ajO)
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
            j = localb1.ajM;
            k = 0;
            int i5 = localb1.ajM;
            int i6 = localb1.ajO;
            i3 = -1;
            i = localb1.ajM;
            if (i < i5 + i6)
            {
              if ((this.ajH.bF(i) != null) || (bB(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(b(4, j, k, localb1.ajN));
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
                  b(b(4, j, k, localb1.ajN));
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
            if (k != localb1.ajO)
            {
              localObject = localb1.ajN;
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
      this.ajF.clear();
      return;
    }
  }
  
  final void iS()
  {
    int j = this.ajG.size();
    int i = 0;
    while (i < j)
    {
      this.ajH.e((b)this.ajG.get(i));
      i += 1;
    }
    m(this.ajG);
    this.ajL = 0;
  }
  
  final boolean iT()
  {
    return this.ajF.size() > 0;
  }
  
  final void iU()
  {
    iS();
    int j = this.ajF.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.ajF.get(i);
      switch (localb.EN)
      {
      }
      for (;;)
      {
        if (this.ajI != null) {
          this.ajI.run();
        }
        i += 1;
        break;
        this.ajH.e(localb);
        this.ajH.P(localb.ajM, localb.ajO);
        continue;
        this.ajH.e(localb);
        this.ajH.N(localb.ajM, localb.ajO);
        continue;
        this.ajH.e(localb);
        this.ajH.d(localb.ajM, localb.ajO, localb.ajN);
        continue;
        this.ajH.e(localb);
        this.ajH.Q(localb.ajM, localb.ajO);
      }
    }
    m(this.ajF);
    this.ajL = 0;
  }
  
  final boolean iV()
  {
    return (!this.ajG.isEmpty()) && (!this.ajF.isEmpty());
  }
  
  final void reset()
  {
    m(this.ajF);
    m(this.ajG);
    this.ajL = 0;
  }
  
  static abstract interface a
  {
    public abstract void N(int paramInt1, int paramInt2);
    
    public abstract void O(int paramInt1, int paramInt2);
    
    public abstract void P(int paramInt1, int paramInt2);
    
    public abstract void Q(int paramInt1, int paramInt2);
    
    public abstract RecyclerView.w bF(int paramInt);
    
    public abstract void d(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void d(d.b paramb);
    
    public abstract void e(d.b paramb);
  }
  
  static final class b
  {
    int EN;
    int ajM;
    Object ajN;
    int ajO;
    
    b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.EN = paramInt1;
      this.ajM = paramInt2;
      this.ajO = paramInt3;
      this.ajN = paramObject;
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
            if (this.EN != paramObject.EN) {
              return false;
            }
          } while ((this.EN == 8) && (Math.abs(this.ajO - this.ajM) == 1) && (this.ajO == paramObject.ajM) && (this.ajM == paramObject.ajO));
          if (this.ajO != paramObject.ajO) {
            return false;
          }
          if (this.ajM != paramObject.ajM) {
            return false;
          }
          if (this.ajN == null) {
            break;
          }
        } while (this.ajN.equals(paramObject.ajN));
        return false;
      } while (paramObject.ajN == null);
      return false;
    }
    
    public final int hashCode()
    {
      return (this.EN * 31 + this.ajM) * 31 + this.ajO;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
      String str;
      switch (this.EN)
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
        return str + ",s:" + this.ajM + "c:" + this.ajO + ",p:" + this.ajN + "]";
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