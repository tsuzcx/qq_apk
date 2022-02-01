package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;
import androidx.constraintlayout.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public m bhA;
  final f bhB;
  final c bhC;
  public e bhD;
  public int bhE;
  int bhF;
  e.b bhG;
  private e.a bhH;
  int bhI;
  public h bhJ;
  
  public e(f paramf, c paramc)
  {
    AppMethodBeat.i(193999);
    this.bhA = new m(this);
    this.bhE = 0;
    this.bhF = -1;
    this.bhG = e.b.bhO;
    this.bhH = e.a.bhL;
    this.bhI = 0;
    this.bhB = paramf;
    this.bhC = paramc;
    AppMethodBeat.o(193999);
  }
  
  public final void CD()
  {
    AppMethodBeat.i(194009);
    if (this.bhJ == null)
    {
      this.bhJ = new h(h.a.bhc);
      AppMethodBeat.o(194009);
      return;
    }
    this.bhJ.reset();
    AppMethodBeat.o(194009);
  }
  
  public final int CE()
  {
    if (this.bhB.bje == 8) {
      return 0;
    }
    if ((this.bhF >= 0) && (this.bhD != null) && (this.bhD.bhB.bje == 8)) {
      return this.bhF;
    }
    return this.bhE;
  }
  
  public final boolean a(e parame, int paramInt1, int paramInt2, e.b paramb, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(194033);
    if (parame == null)
    {
      this.bhD = null;
      this.bhE = 0;
      this.bhF = -1;
      this.bhG = e.b.bhO;
      this.bhI = 2;
      AppMethodBeat.o(194033);
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
        AppMethodBeat.o(194033);
        return false;
        c localc = parame.bhC;
        if (localc == this.bhC)
        {
          if ((this.bhC == c.bhX) && ((!parame.bhB.CR()) || (!this.bhB.CR()))) {
            i = 0;
          } else {
            i = 1;
          }
        }
        else
        {
          int j;
          switch (1.bhK[this.bhC.ordinal()])
          {
          default: 
            parame = new AssertionError(this.bhC.name());
            AppMethodBeat.o(194033);
            throw parame;
          case 1: 
            if ((localc != c.bhX) && (localc != c.bhZ) && (localc != c.bia)) {
              i = 1;
            } else {
              i = 0;
            }
            break;
          case 2: 
          case 3: 
            if ((localc == c.bhT) || (localc == c.bhV)) {}
            for (j = 1;; j = 0)
            {
              i = j;
              if (!(parame.bhB instanceof i)) {
                break;
              }
              if ((j == 0) && (localc != c.bhZ)) {
                break label300;
              }
              i = 1;
              break;
            }
            i = 0;
            break;
          case 4: 
          case 5: 
            if ((localc == c.bhU) || (localc == c.bhW)) {}
            for (j = 1;; j = 0)
            {
              i = j;
              if (!(parame.bhB instanceof i)) {
                break;
              }
              if ((j == 0) && (localc != c.bia)) {
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
    this.bhD = parame;
    if (paramInt1 > 0) {}
    for (this.bhE = paramInt1;; this.bhE = 0)
    {
      this.bhF = paramInt2;
      this.bhG = paramb;
      this.bhI = paramInt3;
      AppMethodBeat.o(194033);
      return true;
    }
  }
  
  public final boolean isConnected()
  {
    return this.bhD != null;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194022);
    this.bhD = null;
    this.bhE = 0;
    this.bhF = -1;
    this.bhG = e.b.bhP;
    this.bhI = 0;
    this.bhH = e.a.bhL;
    this.bhA.reset();
    AppMethodBeat.o(194022);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194050);
    String str = this.bhB.bjf + ":" + this.bhC.toString();
    AppMethodBeat.o(194050);
    return str;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(194153);
      bhS = new c("NONE", 0);
      bhT = new c("LEFT", 1);
      bhU = new c("TOP", 2);
      bhV = new c("RIGHT", 3);
      bhW = new c("BOTTOM", 4);
      bhX = new c("BASELINE", 5);
      bhY = new c("CENTER", 6);
      bhZ = new c("CENTER_X", 7);
      bia = new c("CENTER_Y", 8);
      bib = new c[] { bhS, bhT, bhU, bhV, bhW, bhX, bhY, bhZ, bia };
      AppMethodBeat.o(194153);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.e
 * JD-Core Version:    0.7.0.1
 */