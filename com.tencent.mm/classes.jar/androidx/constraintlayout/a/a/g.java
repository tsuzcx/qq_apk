package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class g
  extends q
{
  int DA;
  d[] DB;
  d[] DC;
  public List<h> DD;
  public boolean DE;
  public boolean DF;
  public boolean DG;
  public int DH;
  public int DI;
  public int DJ;
  public boolean DK;
  public boolean DL;
  public boolean DM;
  int DN;
  protected androidx.constraintlayout.a.e Dt;
  private p Du;
  int Dv;
  int Dw;
  int Dx;
  int Dy;
  int Dz;
  public boolean tL;
  
  public g()
  {
    AppMethodBeat.i(229734);
    this.tL = false;
    this.Dt = new androidx.constraintlayout.a.e();
    this.Dz = 0;
    this.DA = 0;
    this.DB = new d[4];
    this.DC = new d[4];
    this.DD = new ArrayList();
    this.DE = false;
    this.DF = false;
    this.DG = false;
    this.DH = 0;
    this.DI = 0;
    this.DJ = 7;
    this.DK = false;
    this.DL = false;
    this.DM = false;
    this.DN = 0;
    AppMethodBeat.o(229734);
  }
  
  private void b(f paramf)
  {
    AppMethodBeat.i(229763);
    if (this.Dz + 1 >= this.DC.length) {
      this.DC = ((d[])Arrays.copyOf(this.DC, this.DC.length * 2));
    }
    this.DC[this.Dz] = new d(paramf, 0, this.tL);
    this.Dz += 1;
    AppMethodBeat.o(229763);
  }
  
  private void c(f paramf)
  {
    AppMethodBeat.i(229766);
    if (this.DA + 1 >= this.DB.length) {
      this.DB = ((d[])Arrays.copyOf(this.DB, this.DB.length * 2));
    }
    this.DB[this.DA] = new d(paramf, 1, this.tL);
    this.DA += 1;
    AppMethodBeat.o(229766);
  }
  
  private void fS()
  {
    AppMethodBeat.i(229757);
    int j = this.Ew.size();
    fr();
    int i = 0;
    while (i < j)
    {
      ((f)this.Ew.get(i)).fr();
      i += 1;
    }
    AppMethodBeat.o(229757);
  }
  
  private void fT()
  {
    this.Dz = 0;
    this.DA = 0;
  }
  
  public final void aU(int paramInt)
  {
    AppMethodBeat.i(229741);
    super.aU(paramInt);
    int j = this.Ew.size();
    int i = 0;
    while (i < j)
    {
      ((f)this.Ew.get(i)).aU(paramInt);
      i += 1;
    }
    AppMethodBeat.o(229741);
  }
  
  public final boolean aY(int paramInt)
  {
    return (this.DJ & paramInt) == paramInt;
  }
  
  final void b(f paramf, int paramInt)
  {
    AppMethodBeat.i(229760);
    if (paramInt == 0)
    {
      b(paramf);
      AppMethodBeat.o(229760);
      return;
    }
    if (paramInt == 1) {
      c(paramf);
    }
    AppMethodBeat.o(229760);
  }
  
  public final void fP()
  {
    AppMethodBeat.i(229749);
    int i5 = this.CD;
    int i6 = this.CE;
    int i7 = Math.max(0, getWidth());
    int i8 = Math.max(0, getHeight());
    this.DL = false;
    this.DM = false;
    Object localObject1;
    int i;
    Object localObject3;
    label347:
    Object localObject4;
    Object localObject5;
    int n;
    label451:
    int i1;
    if (this.CA != null)
    {
      if (this.Du == null) {
        this.Du = new p(this);
      }
      localObject1 = this.Du;
      ((p)localObject1).CD = getX();
      ((p)localObject1).CE = getY();
      ((p)localObject1).mWidth = getWidth();
      ((p)localObject1).mHeight = getHeight();
      j = ((p)localObject1).Et.size();
      i = 0;
      if (i < j)
      {
        localObject3 = (p.a)((p)localObject1).Et.get(i);
        ((p.a)localObject3).Eb = a(((p.a)localObject3).Eb.Bu);
        if (((p.a)localObject3).Eb != null)
        {
          ((p.a)localObject3).Bv = ((p.a)localObject3).Eb.Bv;
          ((p.a)localObject3).Bw = ((p.a)localObject3).Eb.fv();
          ((p.a)localObject3).Eu = ((p.a)localObject3).Eb.By;
        }
        for (((p.a)localObject3).Ev = ((p.a)localObject3).Eb.BA;; ((p.a)localObject3).Ev = 0)
        {
          i += 1;
          break;
          ((p.a)localObject3).Bv = null;
          ((p.a)localObject3).Bw = 0;
          ((p.a)localObject3).Eu = e.b.BI;
        }
      }
      setX(this.Dv);
      setY(this.Dw);
      fL();
      a(this.Dt.Aa);
      if (this.DJ == 0) {
        break label632;
      }
      if (!aY(8)) {
        fS();
      }
      if (!aY(32))
      {
        if (!aY(8)) {
          aU(this.DJ);
        }
        fR();
      }
      this.Dt.Ay = true;
      i = 0;
      localObject3 = this.Cz[1];
      localObject4 = this.Cz[0];
      fT();
      if (this.DD.size() == 0)
      {
        this.DD.clear();
        this.DD.add(0, new h(this.Ew));
      }
      int i9 = this.DD.size();
      localObject5 = this.Ew;
      if ((fM() != f.a.Dp) && (fN() != f.a.Dp)) {
        break label643;
      }
      n = 1;
      i1 = 0;
      if ((i1 >= i9) || (this.DK)) {
        break label1907;
      }
      if (((h)this.DD.get(i1)).DK) {
        break label1894;
      }
      if (aY(32))
      {
        if ((fM() != f.a.Do) || (fN() != f.a.Do)) {
          break label765;
        }
        localObject1 = (h)this.DD.get(i1);
        if (((h)localObject1).DW.isEmpty()) {
          break label649;
        }
        localObject1 = ((h)localObject1).DW;
      }
    }
    label553:
    int i10;
    label632:
    f localf;
    label643:
    label649:
    label765:
    for (this.Ew = ((ArrayList)localObject1);; this.Ew = ((ArrayList)((h)this.DD.get(i1)).DO))
    {
      fT();
      i10 = this.Ew.size();
      j = 0;
      while (j < i10)
      {
        localObject1 = (f)this.Ew.get(j);
        if ((localObject1 instanceof q)) {
          ((q)localObject1).fP();
        }
        j += 1;
      }
      this.CD = 0;
      this.CE = 0;
      break;
      this.Dt.Ay = false;
      break label347;
      n = 0;
      break label451;
      k = ((h)localObject1).DO.size();
      j = 0;
      while (j < k)
      {
        localf = (f)((h)localObject1).DO.get(j);
        if (!localf.Db) {
          ((h)localObject1).a((ArrayList)((h)localObject1).DW, localf);
        }
        j += 1;
      }
      ((h)localObject1).DX.clear();
      ((h)localObject1).DX.addAll(((h)localObject1).DO);
      ((h)localObject1).DX.removeAll(((h)localObject1).DW);
      localObject1 = ((h)localObject1).DW;
      break label553;
    }
    int j = 1;
    int k = 0;
    label796:
    int i2;
    int m;
    label880:
    label1017:
    Object localObject2;
    label1034:
    int i3;
    if (j != 0)
    {
      i2 = k + 1;
      try
      {
        this.Dt.reset();
        fT();
        b(this.Dt);
        k = 0;
        while (k < i10)
        {
          ((f)this.Ew.get(k)).b(this.Dt);
          k += 1;
        }
        localObject1 = this.Dt;
        a((androidx.constraintlayout.a.e)localObject1);
        m = this.Ew.size();
        k = 0;
        if (k >= m) {
          break label1154;
        }
        localf = (f)this.Ew.get(k);
        if ((localf instanceof g))
        {
          f.a locala1 = localf.Cz[0];
          f.a locala2 = localf.Cz[1];
          if (locala1 == f.a.Dp) {
            localf.a(f.a.Do);
          }
          if (locala2 == f.a.Dp) {
            localf.b(f.a.Do);
          }
          localf.a((androidx.constraintlayout.a.e)localObject1);
          if (locala1 == f.a.Dp) {
            localf.a(locala1);
          }
          if (locala2 == f.a.Dp) {
            localf.b(locala2);
          }
        }
        else
        {
          k.a(this, (androidx.constraintlayout.a.e)localObject1, localf);
          localf.a((androidx.constraintlayout.a.e)localObject1);
        }
      }
      catch (Exception localException1) {}
      System.out.println("EXCEPTION : ".concat(String.valueOf(localException1)));
      if (j != 0)
      {
        localObject2 = k.Eh;
        localObject2[2] = 0;
        fO();
        k = this.Ew.size();
        j = 0;
        while (j < k)
        {
          localf = (f)this.Ew.get(j);
          localf.fO();
          if ((localf.Cz[0] == f.a.Dq) && (localf.getWidth() < localf.CQ)) {
            localObject2[2] = 1;
          }
          if ((localf.Cz[1] == f.a.Dq) && (localf.getHeight() < localf.CR)) {
            localObject2[2] = 1;
          }
          j += 1;
          continue;
          label1154:
          if (this.Dz > 0) {
            c.a(this, (androidx.constraintlayout.a.e)localObject2, 0);
          }
          if (this.DA > 0) {
            c.a(this, (androidx.constraintlayout.a.e)localObject2, 1);
          }
          i3 = 1;
          m = 1;
        }
      }
    }
    for (;;)
    {
      int i4;
      try
      {
        localObject2 = this.Dt;
        if (androidx.constraintlayout.a.e.AF != null)
        {
          localObject2 = androidx.constraintlayout.a.e.AF;
          AppMethodBeat.o(229749);
          throw null;
        }
        if (((androidx.constraintlayout.a.e)localObject2).Ay)
        {
          if (androidx.constraintlayout.a.e.AF == null) {
            break label2262;
          }
          localObject2 = androidx.constraintlayout.a.e.AF;
          AppMethodBeat.o(229749);
          throw null;
          k = i4;
          if (j < ((androidx.constraintlayout.a.e)localObject2).AA)
          {
            if (localObject2.Ax[j].An) {
              break label2270;
            }
            k = 0;
          }
          if (k == 0)
          {
            ((androidx.constraintlayout.a.e)localObject2).b(((androidx.constraintlayout.a.e)localObject2).Au);
            j = i3;
            break label1034;
          }
          if (androidx.constraintlayout.a.e.AF != null)
          {
            localObject2 = androidx.constraintlayout.a.e.AF;
            AppMethodBeat.o(229749);
            throw null;
          }
          ((androidx.constraintlayout.a.e)localObject2).fo();
          j = i3;
          break label1034;
        }
        ((androidx.constraintlayout.a.e)localObject2).b(((androidx.constraintlayout.a.e)localObject2).Au);
        j = i3;
      }
      catch (Exception localException2)
      {
        j = m;
      }
      fO();
      j = 0;
      if (j < i10)
      {
        localObject2 = (f)this.Ew.get(j);
        if ((localObject2.Cz[0] == f.a.Dq) && (((f)localObject2).getWidth() < ((f)localObject2).CQ)) {
          k.Eh[2] = true;
        }
      }
      else
      {
        m = 0;
        k = m;
        j = i;
        if (n == 0) {
          continue;
        }
        k = m;
        j = i;
        if (i2 >= 8) {
          continue;
        }
        k = m;
        j = i;
        if (k.Eh[2] == 0) {
          continue;
        }
        m = 0;
        j = 0;
        k = 0;
        if (k >= i10) {
          continue;
        }
        localObject2 = (f)this.Ew.get(k);
        m = Math.max(m, ((f)localObject2).CD + ((f)localObject2).getWidth());
        i3 = ((f)localObject2).CE;
        j = Math.max(j, ((f)localObject2).getHeight() + i3);
        k += 1;
        continue;
      }
      if ((localObject2.Cz[1] == f.a.Dq) && (((f)localObject2).getHeight() < ((f)localObject2).CR))
      {
        k.Eh[2] = true;
      }
      else
      {
        j += 1;
        continue;
        m = Math.max(this.lj, m);
        k = Math.max(this.CO, j);
        if ((localObject4 == f.a.Dp) && (getWidth() < m))
        {
          setWidth(m);
          this.Cz[0] = f.a.Dp;
          j = 1;
          i = 1;
          if ((localObject3 == f.a.Dp) && (getHeight() < k))
          {
            setHeight(k);
            this.Cz[1] = f.a.Dp;
            j = 1;
            k = 1;
            i = Math.max(this.lj, getWidth());
            if (i > getWidth())
            {
              setWidth(i);
              this.Cz[0] = f.a.Do;
              j = 1;
              k = 1;
            }
            i = Math.max(this.CO, getHeight());
            if (i > getHeight())
            {
              setHeight(i);
              this.Cz[1] = f.a.Do;
              j = 1;
              i = 1;
              if (j == 0)
              {
                if ((this.Cz[0] == f.a.Dp) && (i7 > 0) && (getWidth() > i7))
                {
                  this.DL = true;
                  m = 1;
                  this.Cz[0] = f.a.Do;
                  setWidth(i7);
                  k = 1;
                  j = k;
                  i = m;
                  if (this.Cz[1] == f.a.Dp)
                  {
                    j = k;
                    i = m;
                    if (i8 > 0)
                    {
                      j = k;
                      i = m;
                      if (getHeight() > i8)
                      {
                        this.DM = true;
                        i = 1;
                        this.Cz[1] = f.a.Do;
                        setHeight(i8);
                        j = 1;
                      }
                    }
                  }
                  k = i2;
                  break label796;
                  localObject2 = (h)this.DD.get(i1);
                  m = ((h)localObject2).DX.size();
                  k = 0;
                  j = i;
                  if (k < m)
                  {
                    ((h)localObject2).d((f)((h)localObject2).DX.get(k));
                    k += 1;
                    continue;
                    label1894:
                    j = i;
                  }
                  i1 += 1;
                  i = j;
                  break;
                  label1907:
                  this.Ew = ((ArrayList)localObject5);
                  if (this.CA != null)
                  {
                    k = Math.max(this.lj, getWidth());
                    m = Math.max(this.CO, getHeight());
                    localObject2 = this.Du;
                    setX(((p)localObject2).CD);
                    setY(((p)localObject2).CE);
                    setWidth(((p)localObject2).mWidth);
                    setHeight(((p)localObject2).mHeight);
                    n = ((p)localObject2).Et.size();
                    j = 0;
                    if (j < n)
                    {
                      localObject5 = (p.a)((p)localObject2).Et.get(j);
                      a(((p.a)localObject5).Eb.Bu).a(((p.a)localObject5).Bv, ((p.a)localObject5).Bw, -1, ((p.a)localObject5).Eu, ((p.a)localObject5).Ev, false);
                      j += 1;
                      continue;
                    }
                    setWidth(this.Dv + k + this.Dx);
                    setHeight(this.Dw + m + this.Dy);
                    if (i != 0)
                    {
                      this.Cz[0] = localObject4;
                      this.Cz[1] = localObject3;
                    }
                    a(this.Dt.Aa);
                    localObject2 = this.CA;
                    localObject3 = (g)this;
                    if (localObject2 != null)
                    {
                      localObject4 = ((f)localObject2).CA;
                      if (!(localObject2 instanceof g)) {
                        continue;
                      }
                      localObject3 = (g)localObject2;
                      localObject2 = localObject4;
                      continue;
                    }
                  }
                  else
                  {
                    this.CD = i5;
                    this.CE = i6;
                    continue;
                  }
                  if (this == localObject3) {
                    fK();
                  }
                  AppMethodBeat.o(229749);
                  return;
                  localObject2 = localObject4;
                  continue;
                }
                k = i;
                m = j;
                continue;
              }
              k = j;
              j = i;
              i = k;
              continue;
            }
            i = k;
            continue;
          }
          k = j;
          j = i;
          continue;
        }
        j = 0;
        continue;
        k += 1;
        break label880;
        break label1017;
        label2262:
        i4 = 1;
        j = 0;
        continue;
        label2270:
        j += 1;
      }
    }
  }
  
  public final void fQ()
  {
    AppMethodBeat.i(229750);
    fS();
    aU(this.DJ);
    AppMethodBeat.o(229750);
  }
  
  public final void fR()
  {
    AppMethodBeat.i(229751);
    m localm1 = a(e.c.BM).Bs;
    m localm2 = a(e.c.BN).Bs;
    localm1.a(null, 0.0F);
    localm2.a(null, 0.0F);
    AppMethodBeat.o(229751);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(229739);
    this.Dt.reset();
    this.Dv = 0;
    this.Dx = 0;
    this.Dw = 0;
    this.Dy = 0;
    this.DD.clear();
    this.DK = false;
    super.reset();
    AppMethodBeat.o(229739);
  }
  
  public final void z(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229753);
    if ((this.Cz[0] != f.a.Dp) && (this.BX != null)) {
      this.BX.be(paramInt1);
    }
    if ((this.Cz[1] != f.a.Dp) && (this.BY != null)) {
      this.BY.be(paramInt2);
    }
    AppMethodBeat.o(229753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.g
 * JD-Core Version:    0.7.0.1
 */