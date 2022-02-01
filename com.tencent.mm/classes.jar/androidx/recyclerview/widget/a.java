package androidx.recyclerview.widget;

import androidx.core.f.f.a;
import androidx.core.f.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class a
  implements t.a
{
  final ArrayList<a.b> afA;
  final a afB;
  Runnable afC;
  final boolean afD;
  final t afE;
  int afF;
  private f.a<a.b> afy;
  final ArrayList<a.b> afz;
  
  a(a parama)
  {
    this(parama, (byte)0);
  }
  
  private a(a parama, byte paramByte)
  {
    AppMethodBeat.i(260668);
    this.afy = new f.b(30);
    this.afz = new ArrayList();
    this.afA = new ArrayList();
    this.afF = 0;
    this.afB = parama;
    this.afD = false;
    this.afE = new t(this);
    AppMethodBeat.o(260668);
  }
  
  private void a(a.b paramb)
  {
    AppMethodBeat.i(260686);
    if ((paramb.Vh == 1) || (paramb.Vh == 8))
    {
      paramb = new IllegalArgumentException("should not dispatch add or move for pre layout");
      AppMethodBeat.o(260686);
      throw paramb;
    }
    int i1 = ae(paramb.afG, paramb.Vh);
    int j = paramb.afG;
    int k;
    int m;
    int n;
    label121:
    int i2;
    switch (paramb.Vh)
    {
    case 3: 
    default: 
      paramb = new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(paramb)));
      AppMethodBeat.o(260686);
      throw paramb;
    case 4: 
      k = 1;
      m = 1;
      n = 1;
      if (m >= paramb.afI) {
        break label306;
      }
      i2 = ae(paramb.afG + k * m, paramb.Vh);
      switch (paramb.Vh)
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
      localObject = a(paramb.Vh, i1, n, paramb.afH);
      a((a.b)localObject, j);
      c((a.b)localObject);
      i = j;
      if (paramb.Vh == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label306:
    Object localObject = paramb.afH;
    c(paramb);
    if (n > 0)
    {
      paramb = a(paramb.Vh, i1, n, localObject);
      a(paramb, j);
      c(paramb);
    }
    AppMethodBeat.o(260686);
  }
  
  private void a(a.b paramb, int paramInt)
  {
    AppMethodBeat.i(260690);
    this.afB.d(paramb);
    switch (paramb.Vh)
    {
    case 3: 
    default: 
      paramb = new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
      AppMethodBeat.o(260690);
      throw paramb;
    case 2: 
      this.afB.ag(paramInt, paramb.afI);
      AppMethodBeat.o(260690);
      return;
    }
    this.afB.d(paramInt, paramb.afI, paramb.afH);
    AppMethodBeat.o(260690);
  }
  
  private int ae(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260695);
    int i = this.afA.size() - 1;
    a.b localb;
    if (i >= 0)
    {
      localb = (a.b)this.afA.get(i);
      int k;
      int j;
      if (localb.Vh == 8) {
        if (localb.afG < localb.afI)
        {
          k = localb.afG;
          j = localb.afI;
          label69:
          if ((paramInt1 < k) || (paramInt1 > j)) {
            break label200;
          }
          if (k != localb.afG) {
            break label156;
          }
          if (paramInt2 != 1) {
            break label136;
          }
          localb.afI += 1;
          label108:
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        k = localb.afI;
        j = localb.afG;
        break label69;
        label136:
        if (paramInt2 != 2) {
          break label108;
        }
        localb.afI -= 1;
        break label108;
        label156:
        if (paramInt2 == 1) {
          localb.afG += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localb.afG -= 1;
          }
        }
        label200:
        if (paramInt1 < localb.afG)
        {
          if (paramInt2 == 1)
          {
            localb.afG += 1;
            localb.afI += 1;
            continue;
          }
          if (paramInt2 == 2)
          {
            localb.afG -= 1;
            localb.afI -= 1;
          }
        }
        continue;
        if (localb.afG <= paramInt1)
        {
          if (localb.Vh == 1) {
            paramInt1 -= localb.afI;
          } else if (localb.Vh == 2) {
            paramInt1 = localb.afI + paramInt1;
          }
        }
        else if (paramInt2 == 1) {
          localb.afG += 1;
        } else if (paramInt2 == 2) {
          localb.afG -= 1;
        }
      }
    }
    paramInt2 = this.afA.size() - 1;
    if (paramInt2 >= 0)
    {
      localb = (a.b)this.afA.get(paramInt2);
      if (localb.Vh == 8) {
        if ((localb.afI == localb.afG) || (localb.afI < 0))
        {
          this.afA.remove(paramInt2);
          c(localb);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localb.afI <= 0)
        {
          this.afA.remove(paramInt2);
          c(localb);
        }
      }
    }
    AppMethodBeat.o(260695);
    return paramInt1;
  }
  
  private void b(a.b paramb)
  {
    AppMethodBeat.i(260703);
    this.afA.add(paramb);
    switch (paramb.Vh)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      paramb = new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(260703);
      throw paramb;
    case 1: 
      this.afB.ai(paramb.afG, paramb.afI);
      AppMethodBeat.o(260703);
      return;
    case 8: 
      this.afB.aj(paramb.afG, paramb.afI);
      AppMethodBeat.o(260703);
      return;
    case 2: 
      this.afB.ah(paramb.afG, paramb.afI);
      AppMethodBeat.o(260703);
      return;
    }
    this.afB.d(paramb.afG, paramb.afI, paramb.afH);
    AppMethodBeat.o(260703);
  }
  
  private boolean ck(int paramInt)
  {
    AppMethodBeat.i(260700);
    int k = this.afA.size();
    int i = 0;
    while (i < k)
    {
      a.b localb = (a.b)this.afA.get(i);
      if (localb.Vh == 8)
      {
        if (af(localb.afI, i + 1) == paramInt)
        {
          AppMethodBeat.o(260700);
          return true;
        }
      }
      else if (localb.Vh == 1)
      {
        int m = localb.afG;
        int n = localb.afI;
        int j = localb.afG;
        while (j < m + n)
        {
          if (af(j, i + 1) == paramInt)
          {
            AppMethodBeat.o(260700);
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(260700);
    return false;
  }
  
  private void k(List<a.b> paramList)
  {
    AppMethodBeat.i(260729);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      c((a.b)paramList.get(i));
      i += 1;
    }
    paramList.clear();
    AppMethodBeat.o(260729);
  }
  
  public final a.b a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(260726);
    a.b localb = (a.b)this.afy.acquire();
    if (localb == null) {}
    for (paramObject = new a.b(paramInt1, paramInt2, paramInt3, paramObject);; paramObject = localb)
    {
      AppMethodBeat.o(260726);
      return paramObject;
      localb.Vh = paramInt1;
      localb.afG = paramInt2;
      localb.afI = paramInt3;
      localb.afH = paramObject;
    }
  }
  
  final int af(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260719);
    int k = this.afA.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    if (j < k)
    {
      a.b localb = (a.b)this.afA.get(j);
      if (localb.Vh == 8) {
        if (localb.afG == paramInt2) {
          paramInt1 = localb.afI;
        }
      }
      for (;;)
      {
        j += 1;
        paramInt2 = paramInt1;
        break;
        int i = paramInt2;
        if (localb.afG < paramInt2) {
          i = paramInt2 - 1;
        }
        paramInt1 = i;
        if (localb.afI <= i)
        {
          paramInt1 = i + 1;
          continue;
          paramInt1 = paramInt2;
          if (localb.afG <= paramInt2) {
            if (localb.Vh == 2)
            {
              if (paramInt2 < localb.afG + localb.afI)
              {
                AppMethodBeat.o(260719);
                return -1;
              }
              paramInt1 = paramInt2 - localb.afI;
            }
            else
            {
              paramInt1 = paramInt2;
              if (localb.Vh == 1) {
                paramInt1 = paramInt2 + localb.afI;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(260719);
    return paramInt2;
  }
  
  public final void c(a.b paramb)
  {
    AppMethodBeat.i(260727);
    if (!this.afD)
    {
      paramb.afH = null;
      this.afy.release(paramb);
    }
    AppMethodBeat.o(260727);
  }
  
  final boolean cl(int paramInt)
  {
    return (this.afF & paramInt) != 0;
  }
  
  final int cm(int paramInt)
  {
    AppMethodBeat.i(260713);
    paramInt = af(paramInt, 0);
    AppMethodBeat.o(260713);
    return paramInt;
  }
  
  public final int cn(int paramInt)
  {
    AppMethodBeat.i(260723);
    int m = this.afz.size();
    int k = 0;
    int i = paramInt;
    if (k < m)
    {
      a.b localb = (a.b)this.afz.get(k);
      switch (localb.Vh)
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
        if (localb.afG <= i)
        {
          paramInt = i + localb.afI;
          continue;
          paramInt = i;
          if (localb.afG <= i)
          {
            if (localb.afG + localb.afI > i)
            {
              AppMethodBeat.o(260723);
              return -1;
            }
            paramInt = i - localb.afI;
            continue;
            if (localb.afG == i)
            {
              paramInt = localb.afI;
            }
            else
            {
              int j = i;
              if (localb.afG < i) {
                j = i - 1;
              }
              paramInt = j;
              if (localb.afI <= j) {
                paramInt = j + 1;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(260723);
    return i;
  }
  
  final void kc()
  {
    AppMethodBeat.i(260679);
    t localt = this.afE;
    ArrayList localArrayList = this.afz;
    int i;
    label29:
    label58:
    int i1;
    a.b localb2;
    a.b localb3;
    int k;
    for (;;)
    {
      j = 0;
      i = localArrayList.size() - 1;
      if (i < 0) {
        break label276;
      }
      if (((a.b)localArrayList.get(i)).Vh != 8) {
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
      localb2 = (a.b)localArrayList.get(j);
      localb3 = (a.b)localArrayList.get(i1);
      switch (localb3.Vh)
      {
      case 3: 
      default: 
        break;
      case 1: 
        i = 0;
        if (localb2.afI < localb3.afG) {
          i = -1;
        }
        k = i;
        if (localb2.afG < localb3.afG) {
          k = i + 1;
        }
        if (localb3.afG <= localb2.afG) {
          localb2.afG += localb3.afI;
        }
        if (localb3.afG <= localb2.afI) {
          localb2.afI += localb3.afI;
        }
        localb3.afG = (k + localb3.afG);
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
      a.b localb1 = null;
      int m = 0;
      int n;
      if (localb2.afG < localb2.afI)
      {
        n = 0;
        k = n;
        i = m;
        if (localb3.afG == localb2.afG)
        {
          k = n;
          i = m;
          if (localb3.afI == localb2.afI - localb2.afG)
          {
            i = 1;
            k = n;
          }
        }
        label352:
        if (localb2.afI >= localb3.afG) {
          break label499;
        }
        localb3.afG -= 1;
        label377:
        if (localb2.afG > localb3.afG) {
          break label575;
        }
        localb3.afG += 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label663;
        }
        localArrayList.set(j, localb3);
        localArrayList.remove(i1);
        localt.ajC.c(localb2);
        break;
        n = 1;
        k = n;
        i = m;
        if (localb3.afG != localb2.afI + 1) {
          break label352;
        }
        k = n;
        i = m;
        if (localb3.afI != localb2.afG - localb2.afI) {
          break label352;
        }
        i = 1;
        k = n;
        break label352;
        label499:
        if (localb2.afI >= localb3.afG + localb3.afI) {
          break label377;
        }
        localb3.afI -= 1;
        localb2.Vh = 2;
        localb2.afI = 1;
        if (localb3.afI != 0) {
          break;
        }
        localArrayList.remove(i1);
        localt.ajC.c(localb3);
        break;
        label575:
        if (localb2.afG < localb3.afG + localb3.afI)
        {
          m = localb3.afG;
          n = localb3.afI;
          i2 = localb2.afG;
          localb1 = localt.ajC.a(2, localb2.afG + 1, m + n - i2, null);
          localb3.afI = (localb2.afG - localb3.afG);
        }
      }
      if (k != 0)
      {
        if (localb1 != null)
        {
          if (localb2.afG > localb1.afG) {
            localb2.afG -= localb1.afI;
          }
          if (localb2.afI > localb1.afG) {
            localb2.afI -= localb1.afI;
          }
        }
        if (localb2.afG > localb3.afG) {
          localb2.afG -= localb3.afI;
        }
        if (localb2.afI > localb3.afG) {
          localb2.afI -= localb3.afI;
        }
        localArrayList.set(j, localb3);
        if (localb2.afG == localb2.afI) {
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
          if (localb2.afG >= localb1.afG) {
            localb2.afG -= localb1.afI;
          }
          if (localb2.afI >= localb1.afG) {
            localb2.afI -= localb1.afI;
          }
        }
        if (localb2.afG >= localb3.afG) {
          localb2.afG -= localb3.afI;
        }
        if (localb2.afI < localb3.afG) {
          break label788;
        }
        localb2.afI -= localb3.afI;
        break label788;
        label966:
        localArrayList.remove(i1);
      }
      localb1 = null;
      Object localObject = null;
      if (localb2.afI < localb3.afG)
      {
        localb3.afG -= 1;
        label1010:
        if (localb2.afG > localb3.afG) {
          break label1157;
        }
        localb3.afG += 1;
        localArrayList.set(i1, localb2);
        if (localb3.afI <= 0) {
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
        if (localb2.afI >= localb3.afG + localb3.afI) {
          break label1010;
        }
        localb3.afI -= 1;
        localb1 = localt.ajC.a(4, localb2.afG, 1, localb3.afH);
        break label1010;
        if (localb2.afG >= localb3.afG + localb3.afI) {
          break label1035;
        }
        i = localb3.afG + localb3.afI - localb2.afG;
        localObject = localt.ajC.a(4, localb2.afG + 1, i, localb3.afH);
        localb3.afI -= i;
        break label1035;
        label1235:
        localArrayList.remove(j);
        localt.ajC.c(localb3);
      }
      label1259:
      int i4 = this.afz.size();
      int i2 = 0;
      if (i2 < i4)
      {
        localb1 = (a.b)this.afz.get(i2);
        switch (localb1.Vh)
        {
        }
        for (;;)
        {
          if (this.afC != null) {
            this.afC.run();
          }
          i2 += 1;
          break;
          b(localb1);
          continue;
          int i3 = localb1.afG;
          i = localb1.afG;
          j = localb1.afI + i;
          i1 = -1;
          i = localb1.afG;
          n = 0;
          if (i < j)
          {
            k = 0;
            m = 0;
            if ((this.afB.co(i) != null) || (ck(i)))
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
          if (n != localb1.afI)
          {
            c(localb1);
            localObject = a(2, i3, n, null);
          }
          if (i1 == 0)
          {
            a((a.b)localObject);
          }
          else
          {
            b((a.b)localObject);
            continue;
            j = localb1.afG;
            k = 0;
            int i5 = localb1.afG;
            int i6 = localb1.afI;
            i3 = -1;
            i = localb1.afG;
            if (i < i5 + i6)
            {
              if ((this.afB.co(i) != null) || (ck(i)))
              {
                n = j;
                i1 = k;
                if (i3 == 0)
                {
                  a(a(4, j, k, localb1.afH));
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
                  b(a(4, j, k, localb1.afH));
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
            if (k != localb1.afI)
            {
              localObject = localb1.afH;
              c(localb1);
              localObject = a(4, j, k, localObject);
            }
            if (i3 == 0)
            {
              a((a.b)localObject);
            }
            else
            {
              b((a.b)localObject);
              continue;
              b(localb1);
            }
          }
        }
      }
      this.afz.clear();
      AppMethodBeat.o(260679);
      return;
    }
  }
  
  final void kd()
  {
    AppMethodBeat.i(260681);
    int j = this.afA.size();
    int i = 0;
    while (i < j)
    {
      this.afB.e((a.b)this.afA.get(i));
      i += 1;
    }
    k(this.afA);
    this.afF = 0;
    AppMethodBeat.o(260681);
  }
  
  final boolean ke()
  {
    AppMethodBeat.i(260706);
    if (this.afz.size() > 0)
    {
      AppMethodBeat.o(260706);
      return true;
    }
    AppMethodBeat.o(260706);
    return false;
  }
  
  final void kf()
  {
    AppMethodBeat.i(260721);
    kd();
    int j = this.afz.size();
    int i = 0;
    if (i < j)
    {
      a.b localb = (a.b)this.afz.get(i);
      switch (localb.Vh)
      {
      }
      for (;;)
      {
        if (this.afC != null) {
          this.afC.run();
        }
        i += 1;
        break;
        this.afB.e(localb);
        this.afB.ai(localb.afG, localb.afI);
        continue;
        this.afB.e(localb);
        this.afB.ag(localb.afG, localb.afI);
        continue;
        this.afB.e(localb);
        this.afB.d(localb.afG, localb.afI, localb.afH);
        continue;
        this.afB.e(localb);
        this.afB.aj(localb.afG, localb.afI);
      }
    }
    k(this.afz);
    this.afF = 0;
    AppMethodBeat.o(260721);
  }
  
  final boolean kg()
  {
    AppMethodBeat.i(260725);
    if ((!this.afA.isEmpty()) && (!this.afz.isEmpty()))
    {
      AppMethodBeat.o(260725);
      return true;
    }
    AppMethodBeat.o(260725);
    return false;
  }
  
  final void reset()
  {
    AppMethodBeat.i(260670);
    k(this.afz);
    k(this.afA);
    this.afF = 0;
    AppMethodBeat.o(260670);
  }
  
  static abstract interface a
  {
    public abstract void ag(int paramInt1, int paramInt2);
    
    public abstract void ah(int paramInt1, int paramInt2);
    
    public abstract void ai(int paramInt1, int paramInt2);
    
    public abstract void aj(int paramInt1, int paramInt2);
    
    public abstract RecyclerView.v co(int paramInt);
    
    public abstract void d(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void d(a.b paramb);
    
    public abstract void e(a.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.a
 * JD-Core Version:    0.7.0.1
 */