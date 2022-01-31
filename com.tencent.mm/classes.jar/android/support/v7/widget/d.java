package android.support.v7.widget;

import android.support.v4.e.k.a;
import android.support.v4.e.k.b;
import java.util.ArrayList;
import java.util.List;

final class d
  implements ai.a
{
  private k.a<d.b> ZO = new k.b(30);
  final ArrayList<d.b> ZP = new ArrayList();
  final ArrayList<d.b> ZQ = new ArrayList();
  final d.a ZR;
  Runnable ZS;
  final boolean ZT;
  final ai ZU;
  int ZV = 0;
  
  d(d.a parama)
  {
    this(parama, (byte)0);
  }
  
  private d(d.a parama, byte paramByte)
  {
    this.ZR = parama;
    this.ZT = false;
    this.ZU = new ai(this);
  }
  
  private int I(int paramInt1, int paramInt2)
  {
    int i = this.ZQ.size() - 1;
    d.b localb;
    if (i >= 0)
    {
      localb = (d.b)this.ZQ.get(i);
      int k;
      int j;
      if (localb.vA == 8) {
        if (localb.ZW < localb.ZY)
        {
          k = localb.ZW;
          j = localb.ZY;
          label64:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label195;
          }
          if (k != localb.ZW) {
            break label151;
          }
          if (paramInt2 != 1) {
            break label131;
          }
          localb.ZY += 1;
          label103:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.ZY;
        j = localb.ZW;
        break label64;
        label131:
        if (paramInt2 != 2) {
          break label103;
        }
        localb.ZY -= 1;
        break label103;
        label151:
        if (paramInt2 == 1) {
          localb.ZW += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.ZW -= 1;
          }
        }
        label195:
        if (paramInt1 < localb.ZW)
        {
          if (paramInt2 == 1)
          {
            localb.ZW += 1;
            localb.ZY += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.ZW -= 1;
            localb.ZY -= 1;
          }
        }
        continue;
        if (localb.ZW <= paramInt1)
        {
          if (localb.vA == 1) {
            paramInt1 -= localb.ZY;
          } else if (localb.vA == 2) {
            paramInt1 = localb.ZY + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.ZW += 1;
        } else if (paramInt2 == 2) {
          localb.ZW -= 1;
        }
      }
    }
    paramInt2 = this.ZQ.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (d.b)this.ZQ.get(paramInt2);
      if (localb.vA == 8) {
        if ((localb.ZY == localb.ZW) || (localb.ZY < 0))
        {
          this.ZQ.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.ZY <= 0)
        {
          this.ZQ.remove(paramInt2);
          c(localb);
        }
      }
    }
    return paramInt1;
  }
  
  private void a(d.b paramb)
  {
    if ((paramb.vA == 1) || (paramb.vA == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = I(paramb.ZW, paramb.vA);
    int j = paramb.ZW;
    int k;
    int m;
    int n;
    label102:
    int i2;
    switch (paramb.vA)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(paramb)));
    case 4: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramb.ZY) {
        break label286;
      }
      i2 = I(paramb.ZW + k * m, paramb.vA);
      switch (paramb.vA)
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
      localObject = b(paramb.vA, i1, n, paramb.ZX);
      a((d.b)localObject, j);
      c((d.b)localObject);
      i = j;
      if (paramb.vA == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label286:
    Object localObject = paramb.ZX;
    c(paramb);
    if (n > 0)
    {
      paramb = b(paramb.vA, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
  }
  
  private void a(d.b paramb, int paramInt)
  {
    this.ZR.d(paramb);
    switch (paramb.vA)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.ZR.K(paramInt, paramb.ZY);
      return;
    }
    this.ZR.d(paramInt, paramb.ZY, paramb.ZX);
  }
  
  private void b(d.b paramb)
  {
    this.ZQ.add(paramb);
    switch (paramb.vA)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(paramb)));
    case 1: 
      this.ZR.M(paramb.ZW, paramb.ZY);
      return;
    case 8: 
      this.ZR.N(paramb.ZW, paramb.ZY);
      return;
    case 2: 
      this.ZR.L(paramb.ZW, paramb.ZY);
      return;
    }
    this.ZR.d(paramb.ZW, paramb.ZY, paramb.ZX);
  }
  
  private boolean bj(int paramInt)
  {
    int k = this.ZQ.size();
    int i = 0;
    while (i < k)
    {
      d.b localb = (d.b)this.ZQ.get(i);
      if (localb.vA == 8)
      {
        if (J(localb.ZY, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localb.vA == 1)
      {
        int m = localb.ZW;
        int n = localb.ZY;
        int j = localb.ZW;
        while (j < m + n)
        {
          if (J(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void n(List<d.b> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      c((d.b)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  final int J(int paramInt1, int paramInt2)
  {
    int k = this.ZQ.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    d.b localb;
    if (j < k)
    {
      localb = (d.b)this.ZQ.get(j);
      if (localb.vA == 8) {
        if (localb.ZW == paramInt2) {
          paramInt1 = localb.ZY;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localb.ZW < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localb.ZY <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localb.ZW <= paramInt2) {
          if (localb.vA == 2)
          {
            if (paramInt2 < localb.ZW + localb.ZY)
            {
              paramInt1 = -1;
              return paramInt1;
            }
            paramInt1 = paramInt2 - localb.ZY;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localb.vA == 1) {
              paramInt1 = paramInt2 + localb.ZY;
            }
          }
        }
      }
    }
  }
  
  public final d.b b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    d.b localb = (d.b)this.ZO.acquire();
    if (localb == null) {
      return new d.b(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localb.vA = paramInt1;
    localb.ZW = paramInt2;
    localb.ZY = paramInt3;
    localb.ZX = paramObject;
    return localb;
  }
  
  final boolean bk(int paramInt)
  {
    return (this.ZV & paramInt) != 0;
  }
  
  final int bl(int paramInt)
  {
    return J(paramInt, 0);
  }
  
  public final int bm(int paramInt)
  {
    int m = this.ZP.size();
    int k = 0;
    int i = paramInt;
    paramInt = i;
    d.b localb;
    if (k < m)
    {
      localb = (d.b)this.ZP.get(k);
      switch (localb.vA)
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
      if (localb.ZW <= i)
      {
        paramInt = i + localb.ZY;
        continue;
        paramInt = i;
        if (localb.ZW <= i)
        {
          if (localb.ZW + localb.ZY > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - localb.ZY;
          continue;
          if (localb.ZW == i)
          {
            paramInt = localb.ZY;
          }
          else
          {
            int j = i;
            if (localb.ZW < i) {
              j = i - 1;
            }
            paramInt = j;
            if (localb.ZY <= j) {
              paramInt = j + 1;
            }
          }
        }
      }
    }
  }
  
  public final void c(d.b paramb)
  {
    if (!this.ZT)
    {
      paramb.ZX = null;
      this.ZO.release(paramb);
    }
  }
  
  final void gW()
  {
    ai localai = this.ZU;
    ArrayList localArrayList = this.ZP;
    int i;
    label24:
    label53:
    int i1;
    d.b localb2;
    d.b localb3;
    int k;
    for (;;)
    {
      j = 0;
      i = localArrayList.size() - 1;
      if (i < 0) {
        break label268;
      }
      if (((d.b)localArrayList.get(i)).vA != 8) {
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
      localb2 = (d.b)localArrayList.get(j);
      localb3 = (d.b)localArrayList.get(i1);
      switch (localb3.vA)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.ZY < localb3.ZW) {
          i = -1;
        }
        k = i;
        if (localb2.ZW < localb3.ZW) {
          k = i + 1;
        }
        if (localb3.ZW <= localb2.ZW) {
          localb2.ZW += localb3.ZY;
        }
        if (localb3.ZW <= localb2.ZY) {
          localb2.ZY += localb3.ZY;
        }
        localb3.ZW = (k + localb3.ZW);
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
      d.b localb1 = null;
      int m = 0;
      int n;
      if (localb2.ZW < localb2.ZY)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.ZW == localb2.ZW)
        {
          k = n;
          i = m;
          if (localb3.ZY == localb2.ZY - localb2.ZW)
          {
            i = 1;
            k = n;
          }
        }
        label344:
        if (localb2.ZY >= localb3.ZW) {
          break label491;
        }
        localb3.ZW -= 1;
        label369:
        if (localb2.ZW > localb3.ZW) {
          break label567;
        }
        localb3.ZW += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label655;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localai.ahA.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.ZW != localb2.ZY + 1) {
          break label344;
        }
        k = n;
        i = m;
        if (localb3.ZY != localb2.ZW - localb2.ZY) {
          break label344;
        }
        i = 1;
        k = n;
        break label344;
        label491:
        if (localb2.ZY >= localb3.ZW + localb3.ZY) {
          break label369;
        }
        localb3.ZY -= 1;
        localb2.vA = 2;
        localb2.ZY = 1;
        if (localb3.ZY != 0) {
          break;
        }
        localArrayList.remove(i1);
        localai.ahA.c(localb3);
        break;
        label567:
        if (localb2.ZW < localb3.ZW + localb3.ZY)
        {
          m = localb3.ZW;
          n = localb3.ZY;
          i2 = localb2.ZW;
          localb1 = localai.ahA.b(2, localb2.ZW + 1, m + n - i2, null);
          localb3.ZY = (localb2.ZW - localb3.ZW);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.ZW > localb1.ZW) {
            localb2.ZW -= localb1.ZY;
          }
          if (localb2.ZY > localb1.ZW) {
            localb2.ZY -= localb1.ZY;
          }
        }
        if (localb2.ZW > localb3.ZW) {
          localb2.ZW -= localb3.ZY;
        }
        if (localb2.ZY > localb3.ZW) {
          localb2.ZY -= localb3.ZY;
        }
        localArrayList.set(j, localb3);
        if (localb2.ZW == localb2.ZY) {
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
          if (localb2.ZW >= localb1.ZW) {
            localb2.ZW -= localb1.ZY;
          }
          if (localb2.ZY >= localb1.ZW) {
            localb2.ZY -= localb1.ZY;
          }
        }
        if (localb2.ZW >= localb3.ZW) {
          localb2.ZW -= localb3.ZY;
        }
        if (localb2.ZY < localb3.ZW) {
          break label780;
        }
        localb2.ZY -= localb3.ZY;
        break label780;
        label958:
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.ZY < localb3.ZW)
      {
        localb3.ZW -= 1;
        label1002:
        if (localb2.ZW > localb3.ZW) {
          break label1149;
        }
        localb3.ZW += 1;
        localArrayList.set(i1, localb2);
        if (localb3.ZY <= 0) {
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
        if (localb2.ZY >= localb3.ZW + localb3.ZY) {
          break label1002;
        }
        localb3.ZY -= 1;
        localb1 = localai.ahA.b(4, localb2.ZW, 1, localb3.ZX);
        break label1002;
        label1149:
        if (localb2.ZW >= localb3.ZW + localb3.ZY) {
          break label1027;
        }
        i = localb3.ZW + localb3.ZY - localb2.ZW;
        localObject = localai.ahA.b(4, localb2.ZW + 1, i, localb3.ZX);
        localb3.ZY -= i;
        break label1027;
        label1227:
        localArrayList.remove(j);
        localai.ahA.c(localb3);
      }
      label1251:
      int i4 = this.ZP.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localb1 = (d.b)this.ZP.get(i2);
        switch (localb1.vA)
        {
        }
        for (;;)
        {
          if (this.ZS != null) {
            this.ZS.run();
          }
          i2 += 1;
          break;
          b(localb1);
          continue;
          int i3 = localb1.ZW;
          i = localb1.ZW;
          j = localb1.ZY + i;
          i1 = -1;
          i = localb1.ZW;
          n = 0;
          if (i < j)
          {
            k = 0;
            m = 0;
            if ((this.ZR.bn(i) != null) || (bj(i)))
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
          if (n != localb1.ZY)
          {
            c(localb1);
            localObject = b(2, i3, n, null);
          }
          if (i1 == 0)
          {
            a((d.b)localObject);
          }
          else
          {
            b((d.b)localObject);
            continue;
            j = localb1.ZW;
            k = 0;
            int i5 = localb1.ZW;
            int i6 = localb1.ZY;
            i3 = -1;
            i = localb1.ZW;
            if (i < i5 + i6)
            {
              if ((this.ZR.bn(i) != null) || (bj(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(b(4, j, k, localb1.ZX));
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
                  b(b(4, j, k, localb1.ZX));
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
            if (k != localb1.ZY)
            {
              localObject = localb1.ZX;
              c(localb1);
              localObject = b(4, j, k, localObject);
            }
            if (i3 == 0)
            {
              a((d.b)localObject);
            }
            else
            {
              b((d.b)localObject);
              continue;
              b(localb1);
            }
          }
        }
      }
      this.ZP.clear();
      return;
    }
  }
  
  final void gX()
  {
    int j = this.ZQ.size();
    int i = 0;
    while (i < j)
    {
      this.ZR.e((d.b)this.ZQ.get(i));
      i += 1;
    }
    n(this.ZQ);
    this.ZV = 0;
  }
  
  final boolean gY()
  {
    return this.ZP.size() > 0;
  }
  
  final void gZ()
  {
    gX();
    int j = this.ZP.size();
    int i = 0;
    if (i < j)
    {
      d.b localb = (d.b)this.ZP.get(i);
      switch (localb.vA)
      {
      }
      for (;;)
      {
        if (this.ZS != null) {
          this.ZS.run();
        }
        i += 1;
        break;
        this.ZR.e(localb);
        this.ZR.M(localb.ZW, localb.ZY);
        continue;
        this.ZR.e(localb);
        this.ZR.K(localb.ZW, localb.ZY);
        continue;
        this.ZR.e(localb);
        this.ZR.d(localb.ZW, localb.ZY, localb.ZX);
        continue;
        this.ZR.e(localb);
        this.ZR.N(localb.ZW, localb.ZY);
      }
    }
    n(this.ZP);
    this.ZV = 0;
  }
  
  final boolean ha()
  {
    return (!this.ZQ.isEmpty()) && (!this.ZP.isEmpty());
  }
  
  final void reset()
  {
    n(this.ZP);
    n(this.ZQ);
    this.ZV = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.d
 * JD-Core Version:    0.7.0.1
 */