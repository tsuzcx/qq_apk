package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends o
{
  float bgW;
  e bkq;
  m bkr;
  m bks;
  public float bkt;
  private m bku;
  private float bkv;
  private n bkw = null;
  private int bkx = 1;
  private n bky = null;
  private int bkz = 1;
  float offset;
  int type = 0;
  
  public m(e parame)
  {
    this.bkq = parame;
  }
  
  private static String dR(int paramInt)
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
  
  public final void CB()
  {
    AppMethodBeat.i(194107);
    if (this.state == 1)
    {
      AppMethodBeat.o(194107);
      return;
    }
    if (this.type == 4)
    {
      AppMethodBeat.o(194107);
      return;
    }
    if (this.bkw != null)
    {
      if (this.bkw.state != 1)
      {
        AppMethodBeat.o(194107);
        return;
      }
      this.offset = (this.bkx * this.bkw.value);
    }
    if (this.bky != null)
    {
      if (this.bky.state != 1)
      {
        AppMethodBeat.o(194107);
        return;
      }
      this.bkv = (this.bkz * this.bky.value);
    }
    if ((this.type == 1) && ((this.bkr == null) || (this.bkr.state == 1)))
    {
      if (this.bkr == null) {
        this.bks = this;
      }
      for (this.bkt = this.offset;; this.bkt = (this.bkr.bkt + this.offset))
      {
        De();
        AppMethodBeat.o(194107);
        return;
        this.bks = this.bkr.bks;
      }
    }
    if ((this.type == 2) && (this.bkr != null) && (this.bkr.state == 1) && (this.bku != null) && (this.bku.bkr != null) && (this.bku.bkr.state == 1))
    {
      if (androidx.constraintlayout.a.e.Cs() != null)
      {
        androidx.constraintlayout.a.e.Cs();
        AppMethodBeat.o(194107);
        throw null;
      }
      this.bks = this.bkr.bks;
      this.bku.bks = this.bku.bkr.bks;
      int i;
      float f1;
      label356:
      float f2;
      label407:
      int k;
      int j;
      if ((this.bkq.bhC == e.c.bhV) || (this.bkq.bhC == e.c.bhW))
      {
        i = 1;
        if (i == 0) {
          break label547;
        }
        f1 = this.bkr.bkt - this.bku.bkr.bkt;
        if ((this.bkq.bhC != e.c.bhT) && (this.bkq.bhC != e.c.bhV)) {
          break label569;
        }
        f2 = f1 - this.bkq.bhB.getWidth();
        f1 = this.bkq.bhB.bja;
        k = this.bkq.CE();
        j = this.bku.bkq.CE();
        if (this.bkq.bhD == this.bku.bkq.bhD)
        {
          f1 = 0.5F;
          j = 0;
          k = 0;
        }
        f2 = f2 - k - j;
        if (i == 0) {
          break label597;
        }
        m localm = this.bku;
        float f3 = this.bku.bkr.bkt;
        localm.bkt = (j + f3 + f2 * f1);
      }
      for (this.bkt = (this.bkr.bkt - k - (1.0F - f1) * f2);; this.bku.bkt = (this.bku.bkr.bkt - j - (1.0F - f1) * f2))
      {
        De();
        this.bku.De();
        AppMethodBeat.o(194107);
        return;
        i = 0;
        break;
        label547:
        f1 = this.bku.bkr.bkt - this.bkr.bkt;
        break label356;
        label569:
        f2 = f1 - this.bkq.bhB.getHeight();
        f1 = this.bkq.bhB.bjb;
        break label407;
        label597:
        this.bkt = (this.bkr.bkt + k + f2 * f1);
      }
    }
    if ((this.type == 3) && (this.bkr != null) && (this.bkr.state == 1) && (this.bku != null) && (this.bku.bkr != null) && (this.bku.bkr.state == 1))
    {
      if (androidx.constraintlayout.a.e.Cs() != null)
      {
        androidx.constraintlayout.a.e.Cs();
        AppMethodBeat.o(194107);
        throw null;
      }
      this.bks = this.bkr.bks;
      this.bku.bks = this.bku.bkr.bks;
      this.bkt = (this.bkr.bkt + this.offset);
      this.bku.bkt = (this.bku.bkr.bkt + this.bku.offset);
      De();
      this.bku.De();
      AppMethodBeat.o(194107);
      return;
    }
    if (this.type == 5) {
      this.bkq.bhB.CB();
    }
    AppMethodBeat.o(194107);
  }
  
  public final void a(m paramm, float paramFloat)
  {
    AppMethodBeat.i(194091);
    if ((this.state == 0) || ((this.bks != paramm) && (this.bkt != paramFloat)))
    {
      this.bks = paramm;
      this.bkt = paramFloat;
      if (this.state == 1) {
        invalidate();
      }
      De();
    }
    AppMethodBeat.o(194091);
  }
  
  public final void a(m paramm, int paramInt)
  {
    AppMethodBeat.i(194125);
    this.type = 1;
    this.bkr = paramm;
    this.offset = paramInt;
    this.bkr.a(this);
    AppMethodBeat.o(194125);
  }
  
  public final void a(m paramm, int paramInt, n paramn)
  {
    AppMethodBeat.i(194136);
    this.bkr = paramm;
    this.bkr.a(this);
    this.bkw = paramn;
    this.bkx = paramInt;
    this.bkw.a(this);
    AppMethodBeat.o(194136);
  }
  
  public final void b(m paramm, float paramFloat)
  {
    this.bku = paramm;
    this.bkv = paramFloat;
  }
  
  public final void b(m paramm, int paramInt)
  {
    AppMethodBeat.i(194130);
    this.bkr = paramm;
    this.offset = paramInt;
    this.bkr.a(this);
    AppMethodBeat.o(194130);
  }
  
  public final void b(m paramm, int paramInt, n paramn)
  {
    this.bku = paramm;
    this.bky = paramn;
    this.bkz = paramInt;
  }
  
  final void c(androidx.constraintlayout.a.e parame)
  {
    AppMethodBeat.i(194155);
    h localh = this.bkq.bhJ;
    if (this.bks == null)
    {
      parame.a(localh, (int)(this.bkt + 0.5F));
      AppMethodBeat.o(194155);
      return;
    }
    parame.c(localh, parame.ar(this.bks.bkq), (int)(this.bkt + 0.5F), 6);
    AppMethodBeat.o(194155);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194116);
    super.reset();
    this.bkr = null;
    this.offset = 0.0F;
    this.bkw = null;
    this.bkx = 1;
    this.bky = null;
    this.bkz = 1;
    this.bks = null;
    this.bkt = 0.0F;
    this.bgW = 0.0F;
    this.bku = null;
    this.bkv = 0.0F;
    this.type = 0;
    AppMethodBeat.o(194116);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194083);
    if (this.state == 1)
    {
      if (this.bks == this)
      {
        str = "[" + this.bkq + ", RESOLVED: " + this.bkt + "]  type: " + dR(this.type);
        AppMethodBeat.o(194083);
        return str;
      }
      str = "[" + this.bkq + ", RESOLVED: " + this.bks + ":" + this.bkt + "] type: " + dR(this.type);
      AppMethodBeat.o(194083);
      return str;
    }
    String str = "{ " + this.bkq + " UNRESOLVED} type: " + dR(this.type);
    AppMethodBeat.o(194083);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.m
 * JD-Core Version:    0.7.0.1
 */