package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a;
import androidx.constraintlayout.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class b
  extends j
{
  public int Ba;
  private ArrayList<m> Bb;
  public boolean Bc;
  
  public b()
  {
    AppMethodBeat.i(229228);
    this.Ba = 0;
    this.Bb = new ArrayList(4);
    this.Bc = true;
    AppMethodBeat.o(229228);
  }
  
  public final void a(androidx.constraintlayout.a.e parame)
  {
    AppMethodBeat.i(229258);
    this.Cx[0] = this.Cp;
    this.Cx[2] = this.Cq;
    this.Cx[1] = this.Cr;
    this.Cx[3] = this.Cs;
    int i = 0;
    while (i < this.Cx.length)
    {
      this.Cx[i].BB = parame.s(this.Cx[i]);
      i += 1;
    }
    e locale;
    Object localObject1;
    if ((this.Ba >= 0) && (this.Ba < 4))
    {
      locale = this.Cx[this.Ba];
      i = 0;
      if (i >= this.Bl) {
        break label744;
      }
      localObject1 = this.Eg[i];
      if ((!this.Bc) && (!((f)localObject1).fq())) {
        break label392;
      }
      if (((this.Ba != 0) && (this.Ba != 1)) || (((f)localObject1).fM() != f.a.Dq)) {
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
      if ((this.Ba == 0) || (this.Ba == 1))
      {
        if (this.CA.fM() == f.a.Dp) {
          i = 0;
        }
        j = 0;
        if (j >= this.Bl) {
          break label489;
        }
        localObject2 = this.Eg[j];
        if ((this.Bc) || (((f)localObject2).fq()))
        {
          localObject1 = parame.s(localObject2.Cx[this.Ba]);
          localObject2.Cx[this.Ba].BB = ((h)localObject1);
          if ((this.Ba != 0) && (this.Ba != 2)) {
            break label417;
          }
          localObject2 = locale.BB;
          localb = parame.fm();
          localh = parame.fn();
          localh.AN = 0;
          localb.b((h)localObject2, (h)localObject1, localh, 0);
          if (i != 0) {
            parame.a(localb, (int)(localb.Am.b(localh) * -1.0F), 1);
          }
          parame.b(localb);
        }
      }
      for (;;)
      {
        j += 1;
        break label201;
        AppMethodBeat.o(229258);
        return;
        label360:
        if (((this.Ba == 2) || (this.Ba == 3)) && (((f)localObject1).fN() == f.a.Dq))
        {
          i = 1;
          break label169;
        }
        label392:
        i += 1;
        break;
        if (this.CA.fN() != f.a.Dp) {
          break label199;
        }
        i = 0;
        break label199;
        label417:
        localObject2 = locale.BB;
        localb = parame.fm();
        localh = parame.fn();
        localh.AN = 0;
        localb.a((h)localObject2, (h)localObject1, localh, 0);
        if (i != 0) {
          parame.a(localb, (int)(localb.Am.b(localh) * -1.0F), 1);
        }
        parame.b(localb);
      }
      label489:
      if (this.Ba == 0)
      {
        parame.c(this.Cr.BB, this.Cp.BB, 0, 6);
        if (i == 0)
        {
          parame.c(this.Cp.BB, this.CA.Cr.BB, 0, 5);
          AppMethodBeat.o(229258);
        }
      }
      else if (this.Ba == 1)
      {
        parame.c(this.Cp.BB, this.Cr.BB, 0, 6);
        if (i == 0)
        {
          parame.c(this.Cp.BB, this.CA.Cp.BB, 0, 5);
          AppMethodBeat.o(229258);
        }
      }
      else if (this.Ba == 2)
      {
        parame.c(this.Cs.BB, this.Cq.BB, 0, 6);
        if (i == 0)
        {
          parame.c(this.Cq.BB, this.CA.Cs.BB, 0, 5);
          AppMethodBeat.o(229258);
        }
      }
      else if (this.Ba == 3)
      {
        parame.c(this.Cq.BB, this.Cs.BB, 0, 6);
        if (i == 0) {
          parame.c(this.Cq.BB, this.CA.Cq.BB, 0, 5);
        }
      }
      AppMethodBeat.o(229258);
      return;
      label744:
      i = 0;
    }
  }
  
  public final void aU(int paramInt)
  {
    AppMethodBeat.i(229240);
    if (this.CA == null)
    {
      AppMethodBeat.o(229240);
      return;
    }
    if (!((g)this.CA).aY(2))
    {
      AppMethodBeat.o(229240);
      return;
    }
    m localm;
    label130:
    label139:
    Object localObject;
    switch (this.Ba)
    {
    default: 
      AppMethodBeat.o(229240);
      return;
    case 0: 
      localm = this.Cp.Bs;
      localm.type = 5;
      if ((this.Ba == 0) || (this.Ba == 1))
      {
        this.Cq.Bs.a(null, 0.0F);
        this.Cs.Bs.a(null, 0.0F);
        this.Bb.clear();
        paramInt = 0;
        if (paramInt >= this.Bl) {
          break label335;
        }
        localObject = this.Eg[paramInt];
        if ((this.Bc) || (((f)localObject).fq())) {
          switch (this.Ba)
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
        this.Bb.add(localObject);
        ((m)localObject).a(localm);
      }
      paramInt += 1;
      break label139;
      localm = this.Cr.Bs;
      break;
      localm = this.Cq.Bs;
      break;
      localm = this.Cs.Bs;
      break;
      this.Cp.Bs.a(null, 0.0F);
      this.Cr.Bs.a(null, 0.0F);
      break label130;
      localObject = ((f)localObject).Cp.Bs;
      continue;
      localObject = ((f)localObject).Cr.Bs;
      continue;
      localObject = ((f)localObject).Cq.Bs;
      continue;
      localObject = ((f)localObject).Cs.Bs;
    }
    label335:
    AppMethodBeat.o(229240);
  }
  
  public final boolean fq()
  {
    return true;
  }
  
  public final void fr()
  {
    AppMethodBeat.i(229230);
    super.fr();
    this.Bb.clear();
    AppMethodBeat.o(229230);
  }
  
  public final void fs()
  {
    float f = 3.4028235E+38F;
    AppMethodBeat.i(229244);
    m localm1;
    switch (this.Ba)
    {
    default: 
      AppMethodBeat.o(229244);
      return;
    case 0: 
      localm1 = this.Cp.Bs;
    }
    int i;
    m localm2;
    m localm3;
    for (;;)
    {
      int j = this.Bb.size();
      i = 0;
      localm2 = null;
      if (i >= j) {
        break label216;
      }
      localm3 = (m)this.Bb.get(i);
      if (localm3.state == 1) {
        break;
      }
      AppMethodBeat.o(229244);
      return;
      localm1 = this.Cr.Bs;
      f = 0.0F;
      continue;
      localm1 = this.Cq.Bs;
      continue;
      localm1 = this.Cs.Bs;
      f = 0.0F;
    }
    if ((this.Ba == 0) || (this.Ba == 2))
    {
      if (localm3.El >= f) {
        break label366;
      }
      f = localm3.El;
      localm2 = localm3.Ek;
    }
    label216:
    label366:
    for (;;)
    {
      i += 1;
      break;
      if (localm3.El > f)
      {
        f = localm3.El;
        localm2 = localm3.Ek;
        continue;
        if (androidx.constraintlayout.a.e.fi() != null)
        {
          androidx.constraintlayout.a.e.fi();
          AppMethodBeat.o(229244);
          throw null;
        }
        localm1.Ek = localm2;
        localm1.El = f;
        localm1.fV();
        switch (this.Ba)
        {
        default: 
          AppMethodBeat.o(229244);
          return;
        case 0: 
          this.Cr.Bs.a(localm2, f);
          AppMethodBeat.o(229244);
          return;
        case 1: 
          this.Cp.Bs.a(localm2, f);
          AppMethodBeat.o(229244);
          return;
        case 2: 
          this.Cs.Bs.a(localm2, f);
          AppMethodBeat.o(229244);
          return;
        }
        this.Cq.Bs.a(localm2, f);
        AppMethodBeat.o(229244);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.b
 * JD-Core Version:    0.7.0.1
 */