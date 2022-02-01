package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class i
  extends f
{
  protected float bkg;
  protected int bkh;
  protected int bki;
  private e bkj;
  private boolean bkk;
  private int bkl;
  private l bkm;
  private int bkn;
  private int mOrientation;
  
  public i()
  {
    AppMethodBeat.i(193967);
    this.bkg = -1.0F;
    this.bkh = -1;
    this.bki = -1;
    this.bkj = this.bix;
    this.mOrientation = 0;
    this.bkk = false;
    this.bkl = 0;
    this.bkm = new l();
    this.bkn = 8;
    this.biG.clear();
    this.biG.add(this.bkj);
    int j = this.biF.length;
    while (i < j)
    {
      this.biF[i] = this.bkj;
      i += 1;
    }
    AppMethodBeat.o(193967);
  }
  
  public final ArrayList<e> CS()
  {
    return this.biG;
  }
  
  public final void CX()
  {
    AppMethodBeat.i(194065);
    if (this.biI == null)
    {
      AppMethodBeat.o(194065);
      return;
    }
    int i = androidx.constraintlayout.a.e.as(this.bkj);
    if (this.mOrientation == 1)
    {
      setX(i);
      setY(0);
      setHeight(this.biI.getHeight());
      setWidth(0);
      AppMethodBeat.o(194065);
      return;
    }
    setX(0);
    setY(i);
    setWidth(this.biI.getWidth());
    setHeight(0);
    AppMethodBeat.o(194065);
  }
  
  public final boolean Cz()
  {
    return true;
  }
  
  public final e a(e.c paramc)
  {
    AppMethodBeat.i(193993);
    switch (1.bhK[paramc.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          paramc = new AssertionError(paramc.name());
          AppMethodBeat.o(193993);
          throw paramc;
        } while (this.mOrientation != 1);
        paramc = this.bkj;
        AppMethodBeat.o(193993);
        return paramc;
      } while (this.mOrientation != 0);
      paramc = this.bkj;
      AppMethodBeat.o(193993);
      return paramc;
    }
    AppMethodBeat.o(193993);
    return null;
  }
  
  public final void a(androidx.constraintlayout.a.e parame)
  {
    int j = 1;
    AppMethodBeat.i(194053);
    Object localObject2 = (g)this.biI;
    if (localObject2 == null)
    {
      AppMethodBeat.o(194053);
      return;
    }
    e locale = ((g)localObject2).a(e.c.bhT);
    Object localObject1 = ((g)localObject2).a(e.c.bhV);
    int i;
    if (this.biI != null) {
      if (this.biI.biH[0] == f.a.bjx)
      {
        i = 1;
        if (this.mOrientation != 0) {
          break label331;
        }
        locale = ((g)localObject2).a(e.c.bhU);
        localObject1 = ((g)localObject2).a(e.c.bhW);
        if (this.biI == null) {
          break label198;
        }
        if (this.biI.biH[1] != f.a.bjx) {
          break label193;
        }
        i = j;
      }
    }
    label193:
    label198:
    label331:
    for (;;)
    {
      if (this.bkh != -1)
      {
        localObject2 = parame.ar(this.bkj);
        parame.c((h)localObject2, parame.ar(locale), this.bkh, 6);
        if (i != 0) {
          parame.a(parame.ar(localObject1), (h)localObject2, 0, 5);
        }
        AppMethodBeat.o(194053);
        return;
        i = 0;
        break;
        i = 0;
        break;
        i = 0;
        continue;
        i = 0;
        continue;
      }
      if (this.bki != -1)
      {
        localObject2 = parame.ar(this.bkj);
        localObject1 = parame.ar(localObject1);
        parame.c((h)localObject2, (h)localObject1, -this.bki, 6);
        if (i != 0)
        {
          parame.a((h)localObject2, parame.ar(locale), 0, 5);
          parame.a((h)localObject1, (h)localObject2, 0, 5);
        }
        AppMethodBeat.o(194053);
        return;
      }
      if (this.bkg != -1.0F) {
        parame.b(androidx.constraintlayout.a.e.a(parame, parame.ar(this.bkj), parame.ar(locale), parame.ar(localObject1), this.bkg, this.bkk));
      }
      AppMethodBeat.o(194053);
      return;
    }
  }
  
  public final void am(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.bkg = paramFloat;
      this.bkh = -1;
      this.bki = -1;
    }
  }
  
  public final void dK(int paramInt)
  {
    AppMethodBeat.i(194043);
    f localf = this.biI;
    if (localf == null)
    {
      AppMethodBeat.o(194043);
      return;
    }
    if (this.mOrientation == 1)
    {
      this.bix.bhA.a(localf.bix.bhA, 0);
      this.biA.bhA.a(localf.bix.bhA, 0);
      if (this.bkh != -1)
      {
        this.biw.bhA.a(localf.biw.bhA, this.bkh);
        this.biy.bhA.a(localf.biw.bhA, this.bkh);
        AppMethodBeat.o(194043);
        return;
      }
      if (this.bki != -1)
      {
        this.biw.bhA.a(localf.biy.bhA, -this.bki);
        this.biy.bhA.a(localf.biy.bhA, -this.bki);
        AppMethodBeat.o(194043);
        return;
      }
      if ((this.bkg != -1.0F) && (localf.CV() == f.a.bjw))
      {
        paramInt = (int)(localf.mWidth * this.bkg);
        this.biw.bhA.a(localf.biw.bhA, paramInt);
        this.biy.bhA.a(localf.biw.bhA, paramInt);
        AppMethodBeat.o(194043);
      }
    }
    else
    {
      this.biw.bhA.a(localf.biw.bhA, 0);
      this.biy.bhA.a(localf.biw.bhA, 0);
      if (this.bkh != -1)
      {
        this.bix.bhA.a(localf.bix.bhA, this.bkh);
        this.biA.bhA.a(localf.bix.bhA, this.bkh);
        AppMethodBeat.o(194043);
        return;
      }
      if (this.bki != -1)
      {
        this.bix.bhA.a(localf.biA.bhA, -this.bki);
        this.biA.bhA.a(localf.biA.bhA, -this.bki);
        AppMethodBeat.o(194043);
        return;
      }
      if ((this.bkg != -1.0F) && (localf.CW() == f.a.bjw))
      {
        paramInt = (int)(localf.mHeight * this.bkg);
        this.bix.bhA.a(localf.bix.bhA, paramInt);
        this.biA.bhA.a(localf.bix.bhA, paramInt);
      }
    }
    AppMethodBeat.o(194043);
  }
  
  public final void dP(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.bkg = -1.0F;
      this.bkh = paramInt;
      this.bki = -1;
    }
  }
  
  public final void dQ(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.bkg = -1.0F;
      this.bkh = -1;
      this.bki = paramInt;
    }
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(193982);
    if (this.mOrientation == paramInt)
    {
      AppMethodBeat.o(193982);
      return;
    }
    this.mOrientation = paramInt;
    this.biG.clear();
    if (this.mOrientation == 1) {}
    for (this.bkj = this.biw;; this.bkj = this.bix)
    {
      this.biG.add(this.bkj);
      int i = this.biF.length;
      paramInt = 0;
      while (paramInt < i)
      {
        this.biF[paramInt] = this.bkj;
        paramInt += 1;
      }
    }
    AppMethodBeat.o(193982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.i
 * JD-Core Version:    0.7.0.1
 */