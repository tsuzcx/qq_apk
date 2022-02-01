package androidx.recyclerview.widget;

import androidx.core.f.e.a;
import androidx.core.f.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class a
  implements r.a
{
  private e.a<b> bUd;
  final ArrayList<b> bUe;
  final ArrayList<b> bUf;
  final a bUg;
  Runnable bUh;
  final boolean bUi;
  final r bUj;
  int bUk;
  
  a(a parama)
  {
    this(parama, (byte)0);
  }
  
  private a(a parama, byte paramByte)
  {
    AppMethodBeat.i(194767);
    this.bUd = new e.b(30);
    this.bUe = new ArrayList();
    this.bUf = new ArrayList();
    this.bUk = 0;
    this.bUg = parama;
    this.bUi = false;
    this.bUj = new r(this);
    AppMethodBeat.o(194767);
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(194786);
    if ((paramb.bUl == 1) || (paramb.bUl == 8))
    {
      paramb = new IllegalArgumentException("should not dispatch add or move for pre layout");
      AppMethodBeat.o(194786);
      throw paramb;
    }
    int i1 = aX(paramb.bUm, paramb.bUl);
    int j = paramb.bUm;
    int k;
    int m;
    int n;
    label121:
    int i2;
    switch (paramb.bUl)
    {
    case 3: 
    default: 
      paramb = new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(paramb)));
      AppMethodBeat.o(194786);
      throw paramb;
    case 4: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramb.bUo) {
        break label306;
      }
      i2 = aX(paramb.bUm + k * m, paramb.bUl);
      switch (paramb.bUl)
      {
      case 3: 
      default: 
        i = 0;
        label182:
        if (i == 0) {}
        break;
      }
      break;
    }
    for (int i = n + 1;; i = n)
    {
      m += 1;
      n = i;
      break label121;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label182;
      }
      i = 0;
      break label182;
      if (i2 == i1)
      {
        i = 1;
        break label182;
      }
      i = 0;
      break label182;
      localObject = a(paramb.bUl, i1, n, paramb.bUn);
      a((b)localObject, j);
      c((b)localObject);
      i = j;
      if (paramb.bUl == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label306:
    Object localObject = paramb.bUn;
    c(paramb);
    if (n > 0)
    {
      paramb = a(paramb.bUl, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
    AppMethodBeat.o(194786);
  }
  
  private void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(194803);
    this.bUg.d(paramb);
    switch (paramb.bUl)
    {
    case 3: 
    default: 
      paramb = new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
      AppMethodBeat.o(194803);
      throw paramb;
    case 2: 
      this.bUg.aZ(paramInt, paramb.bUo);
      AppMethodBeat.o(194803);
      return;
    }
    this.bUg.d(paramInt, paramb.bUo, paramb.bUn);
    AppMethodBeat.o(194803);
  }
  
  private int aX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194825);
    int i = this.bUf.size() - 1;
    b localb;
    if (i >= 0)
    {
      localb = (b)this.bUf.get(i);
      int k;
      int j;
      if (localb.bUl == 8) {
        if (localb.bUm < localb.bUo)
        {
          k = localb.bUm;
          j = localb.bUo;
          label69:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label200;
          }
          if (k != localb.bUm) {
            break label156;
          }
          if (paramInt2 != 1) {
            break label136;
          }
          localb.bUo += 1;
          label108:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.bUo;
        j = localb.bUm;
        break label69;
        label136:
        if (paramInt2 != 2) {
          break label108;
        }
        localb.bUo -= 1;
        break label108;
        label156:
        if (paramInt2 == 1) {
          localb.bUm += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.bUm -= 1;
          }
        }
        label200:
        if (paramInt1 < localb.bUm)
        {
          if (paramInt2 == 1)
          {
            localb.bUm += 1;
            localb.bUo += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.bUm -= 1;
            localb.bUo -= 1;
          }
        }
        continue;
        if (localb.bUm <= paramInt1)
        {
          if (localb.bUl == 1) {
            paramInt1 -= localb.bUo;
          } else if (localb.bUl == 2) {
            paramInt1 = localb.bUo + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.bUm += 1;
        } else if (paramInt2 == 2) {
          localb.bUm -= 1;
        }
      }
    }
    paramInt2 = this.bUf.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (b)this.bUf.get(paramInt2);
      if (localb.bUl == 8) {
        if ((localb.bUo == localb.bUm) || (localb.bUo < 0))
        {
          this.bUf.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.bUo <= 0)
        {
          this.bUf.remove(paramInt2);
          c(localb);
        }
      }
    }
    AppMethodBeat.o(194825);
    return paramInt1;
  }
  
  private void ad(List<b> paramList)
  {
    AppMethodBeat.i(194865);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      c((b)paramList.get(i));
      i += 1;
    }
    paramList.clear();
    AppMethodBeat.o(194865);
  }
  
  private void b(b paramb)
  {
    AppMethodBeat.i(194852);
    this.bUf.add(paramb);
    switch (paramb.bUl)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      paramb = new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(194852);
      throw paramb;
    case 1: 
      this.bUg.bb(paramb.bUm, paramb.bUo);
      AppMethodBeat.o(194852);
      return;
    case 8: 
      this.bUg.bc(paramb.bUm, paramb.bUo);
      AppMethodBeat.o(194852);
      return;
    case 2: 
      this.bUg.ba(paramb.bUm, paramb.bUo);
      AppMethodBeat.o(194852);
      return;
    }
    this.bUg.d(paramb.bUm, paramb.bUo, paramb.bUn);
    AppMethodBeat.o(194852);
  }
  
  private boolean fx(int paramInt)
  {
    AppMethodBeat.i(194840);
    int k = this.bUf.size();
    int i = 0;
    while (i < k)
    {
      b localb = (b)this.bUf.get(i);
      if (localb.bUl == 8)
      {
        if (aY(localb.bUo, i + 1) == paramInt)
        {
          AppMethodBeat.o(194840);
          return true;
        }
      }
      else if (localb.bUl == 1)
      {
        int m = localb.bUm;
        int n = localb.bUo;
        int j = localb.bUm;
        while (j < m + n)
        {
          if (aY(j, i + 1) == paramInt)
          {
            AppMethodBeat.o(194840);
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(194840);
    return false;
  }
  
  final void IN()
  {
    AppMethodBeat.i(194919);
    r localr = this.bUj;
    ArrayList localArrayList = this.bUe;
    int i;
    label29:
    label58:
    int i1;
    b localb2;
    b localb3;
    int k;
    for (;;)
    {
      j = 0;
      i = localArrayList.size() - 1;
      if (i < 0) {
        break label276;
      }
      if (((b)localArrayList.get(i)).bUl != 8) {
        break;
      }
      if (j == 0) {
        break label1853;
      }
      j = i;
      if (j == -1) {
        break label1259;
      }
      i1 = j + 1;
      localb2 = (b)localArrayList.get(j);
      localb3 = (b)localArrayList.get(i1);
      switch (localb3.bUl)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.bUo < localb3.bUm) {
          i = -1;
        }
        k = i;
        if (localb2.bUm < localb3.bUm) {
          k = i + 1;
        }
        if (localb3.bUm <= localb2.bUm) {
          localb2.bUm += localb3.bUo;
        }
        if (localb3.bUm <= localb2.bUo) {
          localb2.bUo += localb3.bUo;
        }
        localb3.bUm = (k + localb3.bUm);
        localArrayList.set(j, localb3);
        localArrayList.set(i1, localb2);
      }
    }
    int j = 1;
    label276:
    label663:
    label1466:
    label1853:
    for (;;)
    {
      i -= 1;
      break label29;
      j = -1;
      break label58;
      b localb1 = null;
      int m = 0;
      int n;
      if (localb2.bUm < localb2.bUo)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.bUm == localb2.bUm)
        {
          k = n;
          i = m;
          if (localb3.bUo == localb2.bUo - localb2.bUm)
          {
            i = 1;
            k = n;
          }
        }
        label352:
        if (localb2.bUo >= localb3.bUm) {
          break label499;
        }
        localb3.bUm -= 1;
        label377:
        if (localb2.bUm > localb3.bUm) {
          break label575;
        }
        localb3.bUm += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label663;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localr.bYf.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.bUm != localb2.bUo + 1) {
          break label352;
        }
        k = n;
        i = m;
        if (localb3.bUo != localb2.bUm - localb2.bUo) {
          break label352;
        }
        i = 1;
        k = n;
        break label352;
        label499:
        if (localb2.bUo >= localb3.bUm + localb3.bUo) {
          break label377;
        }
        localb3.bUo -= 1;
        localb2.bUl = 2;
        localb2.bUo = 1;
        if (localb3.bUo != 0) {
          break;
        }
        localArrayList.remove(i1);
        localr.bYf.c(localb3);
        break;
        label575:
        if (localb2.bUm < localb3.bUm + localb3.bUo)
        {
          m = localb3.bUm;
          n = localb3.bUo;
          i2 = localb2.bUm;
          localb1 = localr.bYf.a(2, localb2.bUm + 1, m + n - i2, null);
          localb3.bUo = (localb2.bUm - localb3.bUm);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.bUm > localb1.bUm) {
            localb2.bUm -= localb1.bUo;
          }
          if (localb2.bUo > localb1.bUm) {
            localb2.bUo -= localb1.bUo;
          }
        }
        if (localb2.bUm > localb3.bUm) {
          localb2.bUm -= localb3.bUo;
        }
        if (localb2.bUo > localb3.bUm) {
          localb2.bUo -= localb3.bUo;
        }
        localArrayList.set(j, localb3);
        if (localb2.bUm == localb2.bUo) {
          break label966;
        }
        localArrayList.set(i1, localb2);
      }
      while (localb1 != null)
      {
        localArrayList.add(j, localb1);
        break;
        if (localb1 != null)
        {
          if (localb2.bUm >= localb1.bUm) {
            localb2.bUm -= localb1.bUo;
          }
          if (localb2.bUo >= localb1.bUm) {
            localb2.bUo -= localb1.bUo;
          }
        }
        if (localb2.bUm >= localb3.bUm) {
          localb2.bUm -= localb3.bUo;
        }
        if (localb2.bUo < localb3.bUm) {
          break label788;
        }
        localb2.bUo -= localb3.bUo;
        break label788;
        label966:
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.bUo < localb3.bUm)
      {
        localb3.bUm -= 1;
        label1010:
        if (localb2.bUm > localb3.bUm) {
          break label1157;
        }
        localb3.bUm += 1;
        localArrayList.set(i1, localb2);
        if (localb3.bUo <= 0) {
          break label1235;
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
        if (localb2.bUo >= localb3.bUm + localb3.bUo) {
          break label1010;
        }
        localb3.bUo -= 1;
        localb1 = localr.bYf.a(4, localb2.bUm, 1, localb3.bUn);
        break label1010;
        if (localb2.bUm >= localb3.bUm + localb3.bUo) {
          break label1035;
        }
        i = localb3.bUm + localb3.bUo - localb2.bUm;
        localObject = localr.bYf.a(4, localb2.bUm + 1, i, localb3.bUn);
        localb3.bUo -= i;
        break label1035;
        label1235:
        localArrayList.remove(j);
        localr.bYf.c(localb3);
      }
      label1259:
      int i4 = this.bUe.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localb1 = (b)this.bUe.get(i2);
        switch (localb1.bUl)
        {
        }
        for (;;)
        {
          if (this.bUh != null) {
            this.bUh.run();
          }
          i2 += 1;
          break;
          b(localb1);
          continue;
          int i3 = localb1.bUm;
          i = localb1.bUm;
          j = localb1.bUo + i;
          i1 = -1;
          i = localb1.bUm;
          n = 0;
          if (i < j)
          {
            k = 0;
            m = 0;
            if ((this.bUg.fB(i) != null) || (fx(i)))
            {
              if (i1 == 0)
              {
                a(a(2, i3, n, null));
                m = 1;
              }
              k = 1;
              if (m == 0) {
                break label1536;
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
              break label1466;
              n += 1;
              m = i;
            }
          }
          localObject = localb1;
          if (n != localb1.bUo)
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
            j = localb1.bUm;
            k = 0;
            int i5 = localb1.bUm;
            int i6 = localb1.bUo;
            i3 = -1;
            i = localb1.bUm;
            if (i < i5 + i6)
            {
              if ((this.bUg.fB(i) != null) || (fx(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(a(4, j, k, localb1.bUn));
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
                  b(a(4, j, k, localb1.bUn));
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
            if (k != localb1.bUo)
            {
              localObject = localb1.bUn;
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
      this.bUe.clear();
      AppMethodBeat.o(194919);
      return;
    }
  }
  
  final void IO()
  {
    AppMethodBeat.i(194929);
    int j = this.bUf.size();
    int i = 0;
    while (i < j)
    {
      this.bUg.e((b)this.bUf.get(i));
      i += 1;
    }
    ad(this.bUf);
    this.bUk = 0;
    AppMethodBeat.o(194929);
  }
  
  final boolean IP()
  {
    AppMethodBeat.i(194939);
    if (this.bUe.size() > 0)
    {
      AppMethodBeat.o(194939);
      return true;
    }
    AppMethodBeat.o(194939);
    return false;
  }
  
  final void IQ()
  {
    AppMethodBeat.i(194977);
    IO();
    int j = this.bUe.size();
    int i = 0;
    if (i < j)
    {
      b localb = (b)this.bUe.get(i);
      switch (localb.bUl)
      {
      }
      for (;;)
      {
        if (this.bUh != null) {
          this.bUh.run();
        }
        i += 1;
        break;
        this.bUg.e(localb);
        this.bUg.bb(localb.bUm, localb.bUo);
        continue;
        this.bUg.e(localb);
        this.bUg.aZ(localb.bUm, localb.bUo);
        continue;
        this.bUg.e(localb);
        this.bUg.d(localb.bUm, localb.bUo, localb.bUn);
        continue;
        this.bUg.e(localb);
        this.bUg.bc(localb.bUm, localb.bUo);
      }
    }
    ad(this.bUe);
    this.bUk = 0;
    AppMethodBeat.o(194977);
  }
  
  final boolean IR()
  {
    AppMethodBeat.i(195006);
    if ((!this.bUf.isEmpty()) && (!this.bUe.isEmpty()))
    {
      AppMethodBeat.o(195006);
      return true;
    }
    AppMethodBeat.o(195006);
    return false;
  }
  
  public final b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(195017);
    b localb = (b)this.bUd.acquire();
    if (localb == null) {}
    for (paramObject = new b(paramInt1, paramInt2, paramInt3, paramObject);; paramObject = localb)
    {
      AppMethodBeat.o(195017);
      return paramObject;
      localb.bUl = paramInt1;
      localb.bUm = paramInt2;
      localb.bUo = paramInt3;
      localb.bUn = paramObject;
    }
  }
  
  final int aY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194965);
    int k = this.bUf.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    if (j < k)
    {
      b localb = (b)this.bUf.get(j);
      if (localb.bUl == 8) {
        if (localb.bUm == paramInt2) {
          paramInt1 = localb.bUo;
        }
      }
      for (;;)
      {
        j += 1;
        paramInt2 = paramInt1;
        break;
        int i = paramInt2;
        if (localb.bUm < paramInt2) {
          i = paramInt2 - 1;
        }
        paramInt1 = i;
        if (localb.bUo <= i)
        {
          paramInt1 = i + 1;
          continue;
          paramInt1 = paramInt2;
          if (localb.bUm <= paramInt2) {
            if (localb.bUl == 2)
            {
              if (paramInt2 < localb.bUm + localb.bUo)
              {
                AppMethodBeat.o(194965);
                return -1;
              }
              paramInt1 = paramInt2 - localb.bUo;
            }
            else
            {
              paramInt1 = paramInt2;
              if (localb.bUl == 1) {
                paramInt1 = paramInt2 + localb.bUo;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(194965);
    return paramInt2;
  }
  
  public final void c(b paramb)
  {
    AppMethodBeat.i(195026);
    if (!this.bUi)
    {
      paramb.bUn = null;
      this.bUd.release(paramb);
    }
    AppMethodBeat.o(195026);
  }
  
  public final int fA(int paramInt)
  {
    AppMethodBeat.i(194993);
    int m = this.bUe.size();
    int k = 0;
    int i = paramInt;
    if (k < m)
    {
      b localb = (b)this.bUe.get(k);
      switch (localb.bUl)
      {
      default: 
        paramInt = i;
      }
      for (;;)
      {
        k += 1;
        i = paramInt;
        break;
        paramInt = i;
        if (localb.bUm <= i)
        {
          paramInt = i + localb.bUo;
          continue;
          paramInt = i;
          if (localb.bUm <= i)
          {
            if (localb.bUm + localb.bUo > i)
            {
              AppMethodBeat.o(194993);
              return -1;
            }
            paramInt = i - localb.bUo;
            continue;
            if (localb.bUm == i)
            {
              paramInt = localb.bUo;
            }
            else
            {
              int j = i;
              if (localb.bUm < i) {
                j = i - 1;
              }
              paramInt = j;
              if (localb.bUo <= j) {
                paramInt = j + 1;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(194993);
    return i;
  }
  
  final boolean fy(int paramInt)
  {
    return (this.bUk & paramInt) != 0;
  }
  
  final int fz(int paramInt)
  {
    AppMethodBeat.i(194954);
    paramInt = aY(paramInt, 0);
    AppMethodBeat.o(194954);
    return paramInt;
  }
  
  final void reset()
  {
    AppMethodBeat.i(194877);
    ad(this.bUe);
    ad(this.bUf);
    this.bUk = 0;
    AppMethodBeat.o(194877);
  }
  
  static abstract interface a
  {
    public abstract void aZ(int paramInt1, int paramInt2);
    
    public abstract void ba(int paramInt1, int paramInt2);
    
    public abstract void bb(int paramInt1, int paramInt2);
    
    public abstract void bc(int paramInt1, int paramInt2);
    
    public abstract void d(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void d(a.b paramb);
    
    public abstract void e(a.b paramb);
    
    public abstract RecyclerView.v fB(int paramInt);
  }
  
  static final class b
  {
    int bUl;
    int bUm;
    Object bUn;
    int bUo;
    
    b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.bUl = paramInt1;
      this.bUm = paramInt2;
      this.bUo = paramInt3;
      this.bUn = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195042);
      if (this == paramObject)
      {
        AppMethodBeat.o(195042);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(195042);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.bUl != paramObject.bUl)
      {
        AppMethodBeat.o(195042);
        return false;
      }
      if ((this.bUl == 8) && (Math.abs(this.bUo - this.bUm) == 1) && (this.bUo == paramObject.bUm) && (this.bUm == paramObject.bUo))
      {
        AppMethodBeat.o(195042);
        return true;
      }
      if (this.bUo != paramObject.bUo)
      {
        AppMethodBeat.o(195042);
        return false;
      }
      if (this.bUm != paramObject.bUm)
      {
        AppMethodBeat.o(195042);
        return false;
      }
      if (this.bUn != null)
      {
        if (!this.bUn.equals(paramObject.bUn))
        {
          AppMethodBeat.o(195042);
          return false;
        }
      }
      else if (paramObject.bUn != null)
      {
        AppMethodBeat.o(195042);
        return false;
      }
      AppMethodBeat.o(195042);
      return true;
    }
    
    public final int hashCode()
    {
      return (this.bUl * 31 + this.bUm) * 31 + this.bUo;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195035);
      StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
      String str;
      switch (this.bUl)
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
        str = str + ",s:" + this.bUm + "c:" + this.bUo + ",p:" + this.bUn + "]";
        AppMethodBeat.o(195035);
        return str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.a
 * JD-Core Version:    0.7.0.1
 */