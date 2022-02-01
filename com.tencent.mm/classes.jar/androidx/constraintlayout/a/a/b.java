package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a;
import androidx.constraintlayout.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends j
{
  public int bhi;
  private ArrayList<m> bhj;
  public boolean bhk;
  
  public b()
  {
    AppMethodBeat.i(194089);
    this.bhi = 0;
    this.bhj = new ArrayList(4);
    this.bhk = true;
    AppMethodBeat.o(194089);
  }
  
  public final void CA()
  {
    AppMethodBeat.i(194104);
    super.CA();
    this.bhj.clear();
    AppMethodBeat.o(194104);
  }
  
  public final void CB()
  {
    float f = 3.4028235E+38F;
    AppMethodBeat.i(194132);
    m localm1;
    switch (this.bhi)
    {
    default: 
      AppMethodBeat.o(194132);
      return;
    case 0: 
      localm1 = this.biw.bhA;
    }
    int i;
    m localm2;
    m localm3;
    for (;;)
    {
      int j = this.bhj.size();
      i = 0;
      localm2 = null;
      if (i >= j) {
        break label216;
      }
      localm3 = (m)this.bhj.get(i);
      if (localm3.state == 1) {
        break;
      }
      AppMethodBeat.o(194132);
      return;
      localm1 = this.biy.bhA;
      f = 0.0F;
      continue;
      localm1 = this.bix.bhA;
      continue;
      localm1 = this.biA.bhA;
      f = 0.0F;
    }
    if ((this.bhi == 0) || (this.bhi == 2))
    {
      if (localm3.bkt >= f) {
        break label366;
      }
      f = localm3.bkt;
      localm2 = localm3.bks;
    }
    label216:
    label366:
    for (;;)
    {
      i += 1;
      break;
      if (localm3.bkt > f)
      {
        f = localm3.bkt;
        localm2 = localm3.bks;
        continue;
        if (androidx.constraintlayout.a.e.Cs() != null)
        {
          androidx.constraintlayout.a.e.Cs();
          AppMethodBeat.o(194132);
          throw null;
        }
        localm1.bks = localm2;
        localm1.bkt = f;
        localm1.De();
        switch (this.bhi)
        {
        default: 
          AppMethodBeat.o(194132);
          return;
        case 0: 
          this.biy.bhA.a(localm2, f);
          AppMethodBeat.o(194132);
          return;
        case 1: 
          this.biw.bhA.a(localm2, f);
          AppMethodBeat.o(194132);
          return;
        case 2: 
          this.biA.bhA.a(localm2, f);
          AppMethodBeat.o(194132);
          return;
        }
        this.bix.bhA.a(localm2, f);
        AppMethodBeat.o(194132);
        return;
      }
    }
  }
  
  public final boolean Cz()
  {
    return true;
  }
  
  public final void a(androidx.constraintlayout.a.e parame)
  {
    AppMethodBeat.i(194143);
    this.biF[0] = this.biw;
    this.biF[2] = this.bix;
    this.biF[1] = this.biy;
    this.biF[3] = this.biA;
    int i = 0;
    while (i < this.biF.length)
    {
      this.biF[i].bhJ = parame.ar(this.biF[i]);
      i += 1;
    }
    e locale;
    Object localObject1;
    if ((this.bhi >= 0) && (this.bhi < 4))
    {
      locale = this.biF[this.bhi];
      i = 0;
      if (i >= this.bht) {
        break label744;
      }
      localObject1 = this.bko[i];
      if ((!this.bhk) && (!((f)localObject1).Cz())) {
        break label392;
      }
      if (((this.bhi != 0) && (this.bhi != 1)) || (((f)localObject1).CV() != f.a.bjy)) {
        break label360;
      }
      i = 1;
    }
    for (;;)
    {
      label169:
      label199:
      int j;
      label201:
      Object localObject2;
      androidx.constraintlayout.a.b localb;
      h localh;
      if ((this.bhi == 0) || (this.bhi == 1))
      {
        if (this.biI.CV() == f.a.bjx) {
          i = 0;
        }
        j = 0;
        if (j >= this.bht) {
          break label489;
        }
        localObject2 = this.bko[j];
        if ((this.bhk) || (((f)localObject2).Cz()))
        {
          localObject1 = parame.ar(localObject2.biF[this.bhi]);
          localObject2.biF[this.bhi].bhJ = ((h)localObject1);
          if ((this.bhi != 0) && (this.bhi != 2)) {
            break label417;
          }
          localObject2 = locale.bhJ;
          localb = parame.Cv();
          localh = parame.Cw();
          localh.bgV = 0;
          localb.b((h)localObject2, (h)localObject1, localh, 0);
          if (i != 0) {
            parame.a(localb, (int)(localb.bgu.b(localh) * -1.0F), 1);
          }
          parame.b(localb);
        }
      }
      for (;;)
      {
        j += 1;
        break label201;
        AppMethodBeat.o(194143);
        return;
        label360:
        if (((this.bhi == 2) || (this.bhi == 3)) && (((f)localObject1).CW() == f.a.bjy))
        {
          i = 1;
          break label169;
        }
        label392:
        i += 1;
        break;
        if (this.biI.CW() != f.a.bjx) {
          break label199;
        }
        i = 0;
        break label199;
        label417:
        localObject2 = locale.bhJ;
        localb = parame.Cv();
        localh = parame.Cw();
        localh.bgV = 0;
        localb.a((h)localObject2, (h)localObject1, localh, 0);
        if (i != 0) {
          parame.a(localb, (int)(localb.bgu.b(localh) * -1.0F), 1);
        }
        parame.b(localb);
      }
      label489:
      if (this.bhi == 0)
      {
        parame.c(this.biy.bhJ, this.biw.bhJ, 0, 6);
        if (i == 0)
        {
          parame.c(this.biw.bhJ, this.biI.biy.bhJ, 0, 5);
          AppMethodBeat.o(194143);
        }
      }
      else if (this.bhi == 1)
      {
        parame.c(this.biw.bhJ, this.biy.bhJ, 0, 6);
        if (i == 0)
        {
          parame.c(this.biw.bhJ, this.biI.biw.bhJ, 0, 5);
          AppMethodBeat.o(194143);
        }
      }
      else if (this.bhi == 2)
      {
        parame.c(this.biA.bhJ, this.bix.bhJ, 0, 6);
        if (i == 0)
        {
          parame.c(this.bix.bhJ, this.biI.biA.bhJ, 0, 5);
          AppMethodBeat.o(194143);
        }
      }
      else if (this.bhi == 3)
      {
        parame.c(this.bix.bhJ, this.biA.bhJ, 0, 6);
        if (i == 0) {
          parame.c(this.bix.bhJ, this.biI.bix.bhJ, 0, 5);
        }
      }
      AppMethodBeat.o(194143);
      return;
      label744:
      i = 0;
    }
  }
  
  public final void dK(int paramInt)
  {
    AppMethodBeat.i(194119);
    if (this.biI == null)
    {
      AppMethodBeat.o(194119);
      return;
    }
    if (!((g)this.biI).dO(2))
    {
      AppMethodBeat.o(194119);
      return;
    }
    m localm;
    label130:
    label139:
    Object localObject;
    switch (this.bhi)
    {
    default: 
      AppMethodBeat.o(194119);
      return;
    case 0: 
      localm = this.biw.bhA;
      localm.type = 5;
      if ((this.bhi == 0) || (this.bhi == 1))
      {
        this.bix.bhA.a(null, 0.0F);
        this.biA.bhA.a(null, 0.0F);
        this.bhj.clear();
        paramInt = 0;
        if (paramInt >= this.bht) {
          break label335;
        }
        localObject = this.bko[paramInt];
        if ((this.bhk) || (((f)localObject).Cz())) {
          switch (this.bhi)
          {
          default: 
            localObject = null;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject != null)
      {
        this.bhj.add(localObject);
        ((m)localObject).a(localm);
      }
      paramInt += 1;
      break label139;
      localm = this.biy.bhA;
      break;
      localm = this.bix.bhA;
      break;
      localm = this.biA.bhA;
      break;
      this.biw.bhA.a(null, 0.0F);
      this.biy.bhA.a(null, 0.0F);
      break label130;
      localObject = ((f)localObject).biw.bhA;
      continue;
      localObject = ((f)localObject).biy.bhA;
      continue;
      localObject = ((f)localObject).bix.bhA;
      continue;
      localObject = ((f)localObject).biA.bhA;
    }
    label335:
    AppMethodBeat.o(194119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.b
 * JD-Core Version:    0.7.0.1
 */