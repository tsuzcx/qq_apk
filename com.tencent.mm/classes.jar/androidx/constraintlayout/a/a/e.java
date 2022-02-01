package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;
import androidx.constraintlayout.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  int BA;
  public h BB;
  public m Bs;
  final f Bt;
  final c Bu;
  public e Bv;
  public int Bw;
  int Bx;
  e.b By;
  private e.a Bz;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(229607);
    this.Bs = new m(this);
    this.Bw = 0;
    this.Bx = -1;
    this.By = e.b.BH;
    this.Bz = e.a.BD;
    this.BA = 0;
    this.Bt = paramf;
    this.Bu = paramc;
    AppMethodBeat.o(229607);
  }
  
  public final boolean a(e parame, int paramInt1, int paramInt2, e.b paramb, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(229610);
    if (parame == null)
    {
      this.Bv = null;
      this.Bw = 0;
      this.Bx = -1;
      this.By = e.b.BH;
      this.BA = 2;
      AppMethodBeat.o(229610);
      return true;
    }
    if (!paramBoolean)
    {
      int i;
      if (parame == null) {
        i = 0;
      }
      while (i == 0)
      {
        AppMethodBeat.o(229610);
        return false;
        c localc = parame.Bu;
        if (localc == this.Bu)
        {
          if ((this.Bu == c.BQ) && ((!parame.Bt.fI()) || (!this.Bt.fI()))) {
            i = 0;
          } else {
            i = 1;
          }
        }
        else
        {
          int j;
          switch (1.BC[this.Bu.ordinal()])
          {
          default: 
            parame = new AssertionError(this.Bu.name());
            AppMethodBeat.o(229610);
            throw parame;
          case 1: 
            if ((localc != c.BQ) && (localc != c.BS) && (localc != c.BT)) {
              i = 1;
            } else {
              i = 0;
            }
            break;
          case 2: 
          case 3: 
            if ((localc == c.BM) || (localc == c.BO)) {}
            for (j = 1;; j = 0)
            {
              i = j;
              if (!(parame.Bt instanceof i)) {
                break;
              }
              if ((j == 0) && (localc != c.BS)) {
                break label300;
              }
              i = 1;
              break;
            }
            i = 0;
            break;
          case 4: 
          case 5: 
            if ((localc == c.BN) || (localc == c.BP)) {}
            for (j = 1;; j = 0)
            {
              i = j;
              if (!(parame.Bt instanceof i)) {
                break;
              }
              if ((j == 0) && (localc != c.BT)) {
                break label364;
              }
              i = 1;
              break;
            }
            i = 0;
            break;
          case 6: 
          case 7: 
          case 8: 
          case 9: 
            label300:
            label364:
            i = 0;
          }
        }
      }
    }
    this.Bv = parame;
    if (paramInt1 > 0) {}
    for (this.Bw = paramInt1;; this.Bw = 0)
    {
      this.Bx = paramInt2;
      this.By = paramb;
      this.BA = paramInt3;
      AppMethodBeat.o(229610);
      return true;
    }
  }
  
  public final void fu()
  {
    AppMethodBeat.i(229608);
    if (this.BB == null)
    {
      this.BB = new h(h.a.AU);
      AppMethodBeat.o(229608);
      return;
    }
    this.BB.reset();
    AppMethodBeat.o(229608);
  }
  
  public final int fv()
  {
    if (this.Bt.CX == 8) {
      return 0;
    }
    if ((this.Bx >= 0) && (this.Bv != null) && (this.Bv.Bt.CX == 8)) {
      return this.Bx;
    }
    return this.Bw;
  }
  
  public final boolean isConnected()
  {
    return this.Bv != null;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(229609);
    this.Bv = null;
    this.Bw = 0;
    this.Bx = -1;
    this.By = e.b.BI;
    this.BA = 0;
    this.Bz = e.a.BD;
    this.Bs.reset();
    AppMethodBeat.o(229609);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229612);
    String str = this.Bt.CY + ":" + this.Bu.toString();
    AppMethodBeat.o(229612);
    return str;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(229105);
      BL = new c("NONE", 0);
      BM = new c("LEFT", 1);
      BN = new c("TOP", 2);
      BO = new c("RIGHT", 3);
      BP = new c("BOTTOM", 4);
      BQ = new c("BASELINE", 5);
      BR = new c("CENTER", 6);
      BS = new c("CENTER_X", 7);
      BT = new c("CENTER_Y", 8);
      BU = new c[] { BL, BM, BN, BO, BP, BQ, BR, BS, BT };
      AppMethodBeat.o(229105);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.e
 * JD-Core Version:    0.7.0.1
 */