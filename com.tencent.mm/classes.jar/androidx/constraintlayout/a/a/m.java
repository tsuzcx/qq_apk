package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends o
{
  float AO;
  e Ei;
  m Ej;
  m Ek;
  public float El;
  private m Em;
  private float En;
  private n Eo = null;
  private int Ep = 1;
  private n Eq = null;
  private int Er = 1;
  float offset;
  int type = 0;
  
  public m(e parame)
  {
    this.Ei = parame;
  }
  
  private static String bd(int paramInt)
  {
    if (paramInt == 1) {
      return "DIRECT";
    }
    if (paramInt == 2) {
      return "CENTER";
    }
    if (paramInt == 3) {
      return "MATCH";
    }
    if (paramInt == 4) {
      return "CHAIN";
    }
    if (paramInt == 5) {
      return "BARRIER";
    }
    return "UNCONNECTED";
  }
  
  public final void a(m paramm, float paramFloat)
  {
    AppMethodBeat.i(229668);
    if ((this.state == 0) || ((this.Ek != paramm) && (this.El != paramFloat)))
    {
      this.Ek = paramm;
      this.El = paramFloat;
      if (this.state == 1) {
        invalidate();
      }
      fV();
    }
    AppMethodBeat.o(229668);
  }
  
  public final void a(m paramm, int paramInt)
  {
    AppMethodBeat.i(229679);
    this.type = 1;
    this.Ej = paramm;
    this.offset = paramInt;
    this.Ej.a(this);
    AppMethodBeat.o(229679);
  }
  
  public final void a(m paramm, int paramInt, n paramn)
  {
    AppMethodBeat.i(229686);
    this.Ej = paramm;
    this.Ej.a(this);
    this.Eo = paramn;
    this.Ep = paramInt;
    this.Eo.a(this);
    AppMethodBeat.o(229686);
  }
  
  public final void b(m paramm, float paramFloat)
  {
    this.Em = paramm;
    this.En = paramFloat;
  }
  
  public final void b(m paramm, int paramInt)
  {
    AppMethodBeat.i(229682);
    this.Ej = paramm;
    this.offset = paramInt;
    this.Ej.a(this);
    AppMethodBeat.o(229682);
  }
  
  public final void b(m paramm, int paramInt, n paramn)
  {
    this.Em = paramm;
    this.Eq = paramn;
    this.Er = paramInt;
  }
  
  final void c(androidx.constraintlayout.a.e parame)
  {
    AppMethodBeat.i(229687);
    h localh = this.Ei.BB;
    if (this.Ek == null)
    {
      parame.a(localh, (int)(this.El + 0.5F));
      AppMethodBeat.o(229687);
      return;
    }
    parame.c(localh, parame.s(this.Ek.Ei), (int)(this.El + 0.5F), 6);
    AppMethodBeat.o(229687);
  }
  
  public final void fs()
  {
    AppMethodBeat.i(229676);
    if (this.state == 1)
    {
      AppMethodBeat.o(229676);
      return;
    }
    if (this.type == 4)
    {
      AppMethodBeat.o(229676);
      return;
    }
    if (this.Eo != null)
    {
      if (this.Eo.state != 1)
      {
        AppMethodBeat.o(229676);
        return;
      }
      this.offset = (this.Ep * this.Eo.value);
    }
    if (this.Eq != null)
    {
      if (this.Eq.state != 1)
      {
        AppMethodBeat.o(229676);
        return;
      }
      this.En = (this.Er * this.Eq.value);
    }
    if ((this.type == 1) && ((this.Ej == null) || (this.Ej.state == 1)))
    {
      if (this.Ej == null) {
        this.Ek = this;
      }
      for (this.El = this.offset;; this.El = (this.Ej.El + this.offset))
      {
        fV();
        AppMethodBeat.o(229676);
        return;
        this.Ek = this.Ej.Ek;
      }
    }
    if ((this.type == 2) && (this.Ej != null) && (this.Ej.state == 1) && (this.Em != null) && (this.Em.Ej != null) && (this.Em.Ej.state == 1))
    {
      if (androidx.constraintlayout.a.e.fi() != null)
      {
        androidx.constraintlayout.a.e.fi();
        AppMethodBeat.o(229676);
        throw null;
      }
      this.Ek = this.Ej.Ek;
      this.Em.Ek = this.Em.Ej.Ek;
      int i;
      float f1;
      label356:
      float f2;
      label407:
      int k;
      int j;
      if ((this.Ei.Bu == e.c.BO) || (this.Ei.Bu == e.c.BP))
      {
        i = 1;
        if (i == 0) {
          break label547;
        }
        f1 = this.Ej.El - this.Em.Ej.El;
        if ((this.Ei.Bu != e.c.BM) && (this.Ei.Bu != e.c.BO)) {
          break label569;
        }
        f2 = f1 - this.Ei.Bt.getWidth();
        f1 = this.Ei.Bt.CT;
        k = this.Ei.fv();
        j = this.Em.Ei.fv();
        if (this.Ei.Bv == this.Em.Ei.Bv)
        {
          f1 = 0.5F;
          j = 0;
          k = 0;
        }
        f2 = f2 - k - j;
        if (i == 0) {
          break label597;
        }
        m localm = this.Em;
        float f3 = this.Em.Ej.El;
        localm.El = (j + f3 + f2 * f1);
      }
      for (this.El = (this.Ej.El - k - (1.0F - f1) * f2);; this.Em.El = (this.Em.Ej.El - j - (1.0F - f1) * f2))
      {
        fV();
        this.Em.fV();
        AppMethodBeat.o(229676);
        return;
        i = 0;
        break;
        label547:
        f1 = this.Em.Ej.El - this.Ej.El;
        break label356;
        label569:
        f2 = f1 - this.Ei.Bt.getHeight();
        f1 = this.Ei.Bt.CU;
        break label407;
        label597:
        this.El = (this.Ej.El + k + f2 * f1);
      }
    }
    if ((this.type == 3) && (this.Ej != null) && (this.Ej.state == 1) && (this.Em != null) && (this.Em.Ej != null) && (this.Em.Ej.state == 1))
    {
      if (androidx.constraintlayout.a.e.fi() != null)
      {
        androidx.constraintlayout.a.e.fi();
        AppMethodBeat.o(229676);
        throw null;
      }
      this.Ek = this.Ej.Ek;
      this.Em.Ek = this.Em.Ej.Ek;
      this.El = (this.Ej.El + this.offset);
      this.Em.El = (this.Em.Ej.El + this.Em.offset);
      fV();
      this.Em.fV();
      AppMethodBeat.o(229676);
      return;
    }
    if (this.type == 5) {
      this.Ei.Bt.fs();
    }
    AppMethodBeat.o(229676);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(229677);
    super.reset();
    this.Ej = null;
    this.offset = 0.0F;
    this.Eo = null;
    this.Ep = 1;
    this.Eq = null;
    this.Er = 1;
    this.Ek = null;
    this.El = 0.0F;
    this.AO = 0.0F;
    this.Em = null;
    this.En = 0.0F;
    this.type = 0;
    AppMethodBeat.o(229677);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229666);
    if (this.state == 1)
    {
      if (this.Ek == this)
      {
        str = "[" + this.Ei + ", RESOLVED: " + this.El + "]  type: " + bd(this.type);
        AppMethodBeat.o(229666);
        return str;
      }
      str = "[" + this.Ei + ", RESOLVED: " + this.Ek + ":" + this.El + "] type: " + bd(this.type);
      AppMethodBeat.o(229666);
      return str;
    }
    String str = "{ " + this.Ei + " UNRESOLVED} type: " + bd(this.type);
    AppMethodBeat.o(229666);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.m
 * JD-Core Version:    0.7.0.1
 */