package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class i
  extends f
{
  protected float DY;
  protected int DZ;
  protected int Ea;
  private e Eb;
  private boolean Ec;
  private int Ed;
  private l Ee;
  private int Ef;
  private int mOrientation;
  
  public i()
  {
    AppMethodBeat.i(229690);
    this.DY = -1.0F;
    this.DZ = -1;
    this.Ea = -1;
    this.Eb = this.Cq;
    this.mOrientation = 0;
    this.Ec = false;
    this.Ed = 0;
    this.Ee = new l();
    this.Ef = 8;
    this.Cy.clear();
    this.Cy.add(this.Eb);
    int j = this.Cx.length;
    while (i < j)
    {
      this.Cx[i] = this.Eb;
      i += 1;
    }
    AppMethodBeat.o(229690);
  }
  
  public final e a(e.c paramc)
  {
    AppMethodBeat.i(229696);
    switch (1.BC[paramc.ordinal()])
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
          AppMethodBeat.o(229696);
          throw paramc;
        } while (this.mOrientation != 1);
        paramc = this.Eb;
        AppMethodBeat.o(229696);
        return paramc;
      } while (this.mOrientation != 0);
      paramc = this.Eb;
      AppMethodBeat.o(229696);
      return paramc;
    }
    AppMethodBeat.o(229696);
    return null;
  }
  
  public final void a(androidx.constraintlayout.a.e parame)
  {
    int j = 1;
    AppMethodBeat.i(229706);
    Object localObject2 = (g)this.CA;
    if (localObject2 == null)
    {
      AppMethodBeat.o(229706);
      return;
    }
    e locale = ((g)localObject2).a(e.c.BM);
    Object localObject1 = ((g)localObject2).a(e.c.BO);
    int i;
    if (this.CA != null) {
      if (this.CA.Cz[0] == f.a.Dp)
      {
        i = 1;
        if (this.mOrientation != 0) {
          break label331;
        }
        locale = ((g)localObject2).a(e.c.BN);
        localObject1 = ((g)localObject2).a(e.c.BP);
        if (this.CA == null) {
          break label198;
        }
        if (this.CA.Cz[1] != f.a.Dp) {
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
      if (this.DZ != -1)
      {
        localObject2 = parame.s(this.Eb);
        parame.c((h)localObject2, parame.s(locale), this.DZ, 6);
        if (i != 0) {
          parame.a(parame.s(localObject1), (h)localObject2, 0, 5);
        }
        AppMethodBeat.o(229706);
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
      if (this.Ea != -1)
      {
        localObject2 = parame.s(this.Eb);
        localObject1 = parame.s(localObject1);
        parame.c((h)localObject2, (h)localObject1, -this.Ea, 6);
        if (i != 0)
        {
          parame.a((h)localObject2, parame.s(locale), 0, 5);
          parame.a((h)localObject1, (h)localObject2, 0, 5);
        }
        AppMethodBeat.o(229706);
        return;
      }
      if (this.DY != -1.0F) {
        parame.b(androidx.constraintlayout.a.e.a(parame, parame.s(this.Eb), parame.s(locale), parame.s(localObject1), this.DY, this.Ec));
      }
      AppMethodBeat.o(229706);
      return;
    }
  }
  
  public final void aU(int paramInt)
  {
    AppMethodBeat.i(229705);
    f localf = this.CA;
    if (localf == null)
    {
      AppMethodBeat.o(229705);
      return;
    }
    if (this.mOrientation == 1)
    {
      this.Cq.Bs.a(localf.Cq.Bs, 0);
      this.Cs.Bs.a(localf.Cq.Bs, 0);
      if (this.DZ != -1)
      {
        this.Cp.Bs.a(localf.Cp.Bs, this.DZ);
        this.Cr.Bs.a(localf.Cp.Bs, this.DZ);
        AppMethodBeat.o(229705);
        return;
      }
      if (this.Ea != -1)
      {
        this.Cp.Bs.a(localf.Cr.Bs, -this.Ea);
        this.Cr.Bs.a(localf.Cr.Bs, -this.Ea);
        AppMethodBeat.o(229705);
        return;
      }
      if ((this.DY != -1.0F) && (localf.fM() == f.a.Do))
      {
        paramInt = (int)(localf.mWidth * this.DY);
        this.Cp.Bs.a(localf.Cp.Bs, paramInt);
        this.Cr.Bs.a(localf.Cp.Bs, paramInt);
        AppMethodBeat.o(229705);
      }
    }
    else
    {
      this.Cp.Bs.a(localf.Cp.Bs, 0);
      this.Cr.Bs.a(localf.Cp.Bs, 0);
      if (this.DZ != -1)
      {
        this.Cq.Bs.a(localf.Cq.Bs, this.DZ);
        this.Cs.Bs.a(localf.Cq.Bs, this.DZ);
        AppMethodBeat.o(229705);
        return;
      }
      if (this.Ea != -1)
      {
        this.Cq.Bs.a(localf.Cs.Bs, -this.Ea);
        this.Cs.Bs.a(localf.Cs.Bs, -this.Ea);
        AppMethodBeat.o(229705);
        return;
      }
      if ((this.DY != -1.0F) && (localf.fN() == f.a.Do))
      {
        paramInt = (int)(localf.mHeight * this.DY);
        this.Cq.Bs.a(localf.Cq.Bs, paramInt);
        this.Cs.Bs.a(localf.Cq.Bs, paramInt);
      }
    }
    AppMethodBeat.o(229705);
  }
  
  public final void aZ(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.DY = -1.0F;
      this.DZ = paramInt;
      this.Ea = -1;
    }
  }
  
  public final void bc(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.DY = -1.0F;
      this.DZ = -1;
      this.Ea = paramInt;
    }
  }
  
  public final ArrayList<e> fJ()
  {
    return this.Cy;
  }
  
  public final void fO()
  {
    AppMethodBeat.i(229707);
    if (this.CA == null)
    {
      AppMethodBeat.o(229707);
      return;
    }
    int i = androidx.constraintlayout.a.e.t(this.Eb);
    if (this.mOrientation == 1)
    {
      setX(i);
      setY(0);
      setHeight(this.CA.getHeight());
      setWidth(0);
      AppMethodBeat.o(229707);
      return;
    }
    setX(0);
    setY(i);
    setWidth(this.CA.getWidth());
    setHeight(0);
    AppMethodBeat.o(229707);
  }
  
  public final boolean fq()
  {
    return true;
  }
  
  public final void g(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      this.DY = paramFloat;
      this.DZ = -1;
      this.Ea = -1;
    }
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(229692);
    if (this.mOrientation == paramInt)
    {
      AppMethodBeat.o(229692);
      return;
    }
    this.mOrientation = paramInt;
    this.Cy.clear();
    if (this.mOrientation == 1) {}
    for (this.Eb = this.Cp;; this.Eb = this.Cq)
    {
      this.Cy.add(this.Eb);
      int i = this.Cx.length;
      paramInt = 0;
      while (paramInt < i)
      {
        this.Cx[paramInt] = this.Eb;
        paramInt += 1;
      }
    }
    AppMethodBeat.o(229692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.i
 * JD-Core Version:    0.7.0.1
 */