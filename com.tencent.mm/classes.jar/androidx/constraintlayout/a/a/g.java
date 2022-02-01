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
  protected androidx.constraintlayout.a.e bjB;
  private p bjC;
  int bjD;
  int bjE;
  int bjF;
  int bjG;
  int bjH;
  int bjI;
  d[] bjJ;
  d[] bjK;
  public List<h> bjL;
  public boolean bjM;
  public boolean bjN;
  public boolean bjO;
  public int bjP;
  public int bjQ;
  public int bjR;
  public boolean bjS;
  public boolean bjT;
  public boolean bjU;
  int bjV;
  public boolean uK;
  
  public g()
  {
    AppMethodBeat.i(193976);
    this.uK = false;
    this.bjB = new androidx.constraintlayout.a.e();
    this.bjH = 0;
    this.bjI = 0;
    this.bjJ = new d[4];
    this.bjK = new d[4];
    this.bjL = new ArrayList();
    this.bjM = false;
    this.bjN = false;
    this.bjO = false;
    this.bjP = 0;
    this.bjQ = 0;
    this.bjR = 7;
    this.bjS = false;
    this.bjT = false;
    this.bjU = false;
    this.bjV = 0;
    AppMethodBeat.o(193976);
  }
  
  private void Db()
  {
    AppMethodBeat.i(193986);
    int j = this.bkE.size();
    CA();
    int i = 0;
    while (i < j)
    {
      ((f)this.bkE.get(i)).CA();
      i += 1;
    }
    AppMethodBeat.o(193986);
  }
  
  private void Dc()
  {
    this.bjH = 0;
    this.bjI = 0;
  }
  
  private void b(f paramf)
  {
    AppMethodBeat.i(194002);
    if (this.bjH + 1 >= this.bjK.length) {
      this.bjK = ((d[])Arrays.copyOf(this.bjK, this.bjK.length * 2));
    }
    this.bjK[this.bjH] = new d(paramf, 0, this.uK);
    this.bjH += 1;
    AppMethodBeat.o(194002);
  }
  
  private void c(f paramf)
  {
    AppMethodBeat.i(194011);
    if (this.bjI + 1 >= this.bjJ.length) {
      this.bjJ = ((d[])Arrays.copyOf(this.bjJ, this.bjJ.length * 2));
    }
    this.bjJ[this.bjI] = new d(paramf, 1, this.uK);
    this.bjI += 1;
    AppMethodBeat.o(194011);
  }
  
  public final void CY()
  {
    AppMethodBeat.i(194079);
    int i5 = this.biL;
    int i6 = this.biM;
    int i7 = Math.max(0, getWidth());
    int i8 = Math.max(0, getHeight());
    this.bjT = false;
    this.bjU = false;
    Object localObject1;
    int i;
    Object localObject3;
    label347:
    Object localObject4;
    Object localObject5;
    int n;
    label451:
    int i1;
    if (this.biI != null)
    {
      if (this.bjC == null) {
        this.bjC = new p(this);
      }
      localObject1 = this.bjC;
      ((p)localObject1).biL = getX();
      ((p)localObject1).biM = getY();
      ((p)localObject1).mWidth = getWidth();
      ((p)localObject1).mHeight = getHeight();
      j = ((p)localObject1).bkB.size();
      i = 0;
      if (i < j)
      {
        localObject3 = (p.a)((p)localObject1).bkB.get(i);
        ((p.a)localObject3).bkj = a(((p.a)localObject3).bkj.bhC);
        if (((p.a)localObject3).bkj != null)
        {
          ((p.a)localObject3).bhD = ((p.a)localObject3).bkj.bhD;
          ((p.a)localObject3).bhE = ((p.a)localObject3).bkj.CE();
          ((p.a)localObject3).bkC = ((p.a)localObject3).bkj.bhG;
        }
        for (((p.a)localObject3).bkD = ((p.a)localObject3).bkj.bhI;; ((p.a)localObject3).bkD = 0)
        {
          i += 1;
          break;
          ((p.a)localObject3).bhD = null;
          ((p.a)localObject3).bhE = 0;
          ((p.a)localObject3).bkC = e.b.bhP;
        }
      }
      setX(this.bjD);
      setY(this.bjE);
      CU();
      a(this.bjB.bgi);
      if (this.bjR == 0) {
        break label632;
      }
      if (!dO(8)) {
        Db();
      }
      if (!dO(32))
      {
        if (!dO(8)) {
          dK(this.bjR);
        }
        Da();
      }
      this.bjB.bgG = true;
      i = 0;
      localObject3 = this.biH[1];
      localObject4 = this.biH[0];
      Dc();
      if (this.bjL.size() == 0)
      {
        this.bjL.clear();
        this.bjL.add(0, new h(this.bkE));
      }
      int i9 = this.bjL.size();
      localObject5 = this.bkE;
      if ((CV() != f.a.bjx) && (CW() != f.a.bjx)) {
        break label643;
      }
      n = 1;
      i1 = 0;
      if ((i1 >= i9) || (this.bjS)) {
        break label1907;
      }
      if (((h)this.bjL.get(i1)).bjS) {
        break label1894;
      }
      if (dO(32))
      {
        if ((CV() != f.a.bjw) || (CW() != f.a.bjw)) {
          break label765;
        }
        localObject1 = (h)this.bjL.get(i1);
        if (((h)localObject1).bke.isEmpty()) {
          break label649;
        }
        localObject1 = ((h)localObject1).bke;
      }
    }
    label553:
    int i10;
    label632:
    f localf;
    label643:
    label649:
    label765:
    for (this.bkE = ((ArrayList)localObject1);; this.bkE = ((ArrayList)((h)this.bjL.get(i1)).bjW))
    {
      Dc();
      i10 = this.bkE.size();
      j = 0;
      while (j < i10)
      {
        localObject1 = (f)this.bkE.get(j);
        if ((localObject1 instanceof q)) {
          ((q)localObject1).CY();
        }
        j += 1;
      }
      this.biL = 0;
      this.biM = 0;
      break;
      this.bjB.bgG = false;
      break label347;
      n = 0;
      break label451;
      k = ((h)localObject1).bjW.size();
      j = 0;
      while (j < k)
      {
        localf = (f)((h)localObject1).bjW.get(j);
        if (!localf.bjj) {
          ((h)localObject1).a((ArrayList)((h)localObject1).bke, localf);
        }
        j += 1;
      }
      ((h)localObject1).bkf.clear();
      ((h)localObject1).bkf.addAll(((h)localObject1).bjW);
      ((h)localObject1).bkf.removeAll(((h)localObject1).bke);
      localObject1 = ((h)localObject1).bke;
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
        this.bjB.reset();
        Dc();
        b(this.bjB);
        k = 0;
        while (k < i10)
        {
          ((f)this.bkE.get(k)).b(this.bjB);
          k += 1;
        }
        localObject1 = this.bjB;
        a((androidx.constraintlayout.a.e)localObject1);
        m = this.bkE.size();
        k = 0;
        if (k >= m) {
          break label1154;
        }
        localf = (f)this.bkE.get(k);
        if ((localf instanceof g))
        {
          f.a locala1 = localf.biH[0];
          f.a locala2 = localf.biH[1];
          if (locala1 == f.a.bjx) {
            localf.a(f.a.bjw);
          }
          if (locala2 == f.a.bjx) {
            localf.b(f.a.bjw);
          }
          localf.a((androidx.constraintlayout.a.e)localObject1);
          if (locala1 == f.a.bjx) {
            localf.a(locala1);
          }
          if (locala2 == f.a.bjx) {
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
        localObject2 = k.bkp;
        localObject2[2] = 0;
        CX();
        k = this.bkE.size();
        j = 0;
        while (j < k)
        {
          localf = (f)this.bkE.get(j);
          localf.CX();
          if ((localf.biH[0] == f.a.bjy) && (localf.getWidth() < localf.biX)) {
            localObject2[2] = 1;
          }
          if ((localf.biH[1] == f.a.bjy) && (localf.getHeight() < localf.biY)) {
            localObject2[2] = 1;
          }
          j += 1;
          continue;
          label1154:
          if (this.bjH > 0) {
            c.a(this, (androidx.constraintlayout.a.e)localObject2, 0);
          }
          if (this.bjI > 0) {
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
        localObject2 = this.bjB;
        if (androidx.constraintlayout.a.e.bgN != null)
        {
          localObject2 = androidx.constraintlayout.a.e.bgN;
          AppMethodBeat.o(194079);
          throw null;
        }
        if (((androidx.constraintlayout.a.e)localObject2).bgG)
        {
          if (androidx.constraintlayout.a.e.bgN == null) {
            break label2262;
          }
          localObject2 = androidx.constraintlayout.a.e.bgN;
          AppMethodBeat.o(194079);
          throw null;
          k = i4;
          if (j < ((androidx.constraintlayout.a.e)localObject2).bgI)
          {
            if (localObject2.bgF[j].bgv) {
              break label2270;
            }
            k = 0;
          }
          if (k == 0)
          {
            ((androidx.constraintlayout.a.e)localObject2).b(((androidx.constraintlayout.a.e)localObject2).bgC);
            j = i3;
            break label1034;
          }
          if (androidx.constraintlayout.a.e.bgN != null)
          {
            localObject2 = androidx.constraintlayout.a.e.bgN;
            AppMethodBeat.o(194079);
            throw null;
          }
          ((androidx.constraintlayout.a.e)localObject2).Cx();
          j = i3;
          break label1034;
        }
        ((androidx.constraintlayout.a.e)localObject2).b(((androidx.constraintlayout.a.e)localObject2).bgC);
        j = i3;
      }
      catch (Exception localException2)
      {
        j = m;
      }
      CX();
      j = 0;
      if (j < i10)
      {
        localObject2 = (f)this.bkE.get(j);
        if ((localObject2.biH[0] == f.a.bjy) && (((f)localObject2).getWidth() < ((f)localObject2).biX)) {
          k.bkp[2] = true;
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
        if (k.bkp[2] == 0) {
          continue;
        }
        m = 0;
        j = 0;
        k = 0;
        if (k >= i10) {
          continue;
        }
        localObject2 = (f)this.bkE.get(k);
        m = Math.max(m, ((f)localObject2).biL + ((f)localObject2).getWidth());
        i3 = ((f)localObject2).biM;
        j = Math.max(j, ((f)localObject2).getHeight() + i3);
        k += 1;
        continue;
      }
      if ((localObject2.biH[1] == f.a.bjy) && (((f)localObject2).getHeight() < ((f)localObject2).biY))
      {
        k.bkp[2] = true;
      }
      else
      {
        j += 1;
        continue;
        m = Math.max(this.mf, m);
        k = Math.max(this.biW, j);
        if ((localObject4 == f.a.bjx) && (getWidth() < m))
        {
          setWidth(m);
          this.biH[0] = f.a.bjx;
          j = 1;
          i = 1;
          if ((localObject3 == f.a.bjx) && (getHeight() < k))
          {
            setHeight(k);
            this.biH[1] = f.a.bjx;
            j = 1;
            k = 1;
            i = Math.max(this.mf, getWidth());
            if (i > getWidth())
            {
              setWidth(i);
              this.biH[0] = f.a.bjw;
              j = 1;
              k = 1;
            }
            i = Math.max(this.biW, getHeight());
            if (i > getHeight())
            {
              setHeight(i);
              this.biH[1] = f.a.bjw;
              j = 1;
              i = 1;
              if (j == 0)
              {
                if ((this.biH[0] == f.a.bjx) && (i7 > 0) && (getWidth() > i7))
                {
                  this.bjT = true;
                  m = 1;
                  this.biH[0] = f.a.bjw;
                  setWidth(i7);
                  k = 1;
                  j = k;
                  i = m;
                  if (this.biH[1] == f.a.bjx)
                  {
                    j = k;
                    i = m;
                    if (i8 > 0)
                    {
                      j = k;
                      i = m;
                      if (getHeight() > i8)
                      {
                        this.bjU = true;
                        i = 1;
                        this.biH[1] = f.a.bjw;
                        setHeight(i8);
                        j = 1;
                      }
                    }
                  }
                  k = i2;
                  break label796;
                  localObject2 = (h)this.bjL.get(i1);
                  m = ((h)localObject2).bkf.size();
                  k = 0;
                  j = i;
                  if (k < m)
                  {
                    ((h)localObject2).d((f)((h)localObject2).bkf.get(k));
                    k += 1;
                    continue;
                    label1894:
                    j = i;
                  }
                  i1 += 1;
                  i = j;
                  break;
                  label1907:
                  this.bkE = ((ArrayList)localObject5);
                  if (this.biI != null)
                  {
                    k = Math.max(this.mf, getWidth());
                    m = Math.max(this.biW, getHeight());
                    localObject2 = this.bjC;
                    setX(((p)localObject2).biL);
                    setY(((p)localObject2).biM);
                    setWidth(((p)localObject2).mWidth);
                    setHeight(((p)localObject2).mHeight);
                    n = ((p)localObject2).bkB.size();
                    j = 0;
                    if (j < n)
                    {
                      localObject5 = (p.a)((p)localObject2).bkB.get(j);
                      a(((p.a)localObject5).bkj.bhC).a(((p.a)localObject5).bhD, ((p.a)localObject5).bhE, -1, ((p.a)localObject5).bkC, ((p.a)localObject5).bkD, false);
                      j += 1;
                      continue;
                    }
                    setWidth(this.bjD + k + this.bjF);
                    setHeight(this.bjE + m + this.bjG);
                    if (i != 0)
                    {
                      this.biH[0] = localObject4;
                      this.biH[1] = localObject3;
                    }
                    a(this.bjB.bgi);
                    localObject2 = this.biI;
                    localObject3 = (g)this;
                    if (localObject2 != null)
                    {
                      localObject4 = ((f)localObject2).biI;
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
                    this.biL = i5;
                    this.biM = i6;
                    continue;
                  }
                  if (this == localObject3) {
                    CT();
                  }
                  AppMethodBeat.o(194079);
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
  
  public final void CZ()
  {
    AppMethodBeat.i(194085);
    Db();
    dK(this.bjR);
    AppMethodBeat.o(194085);
  }
  
  public final void Da()
  {
    AppMethodBeat.i(194096);
    m localm1 = a(e.c.bhT).bhA;
    m localm2 = a(e.c.bhU).bhA;
    localm1.a(null, 0.0F);
    localm2.a(null, 0.0F);
    AppMethodBeat.o(194096);
  }
  
  public final void at(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194102);
    if ((this.biH[0] != f.a.bjx) && (this.bie != null)) {
      this.bie.dS(paramInt1);
    }
    if ((this.biH[1] != f.a.bjx) && (this.bif != null)) {
      this.bif.dS(paramInt2);
    }
    AppMethodBeat.o(194102);
  }
  
  final void b(f paramf, int paramInt)
  {
    AppMethodBeat.i(194112);
    if (paramInt == 0)
    {
      b(paramf);
      AppMethodBeat.o(194112);
      return;
    }
    if (paramInt == 1) {
      c(paramf);
    }
    AppMethodBeat.o(194112);
  }
  
  public final void dK(int paramInt)
  {
    AppMethodBeat.i(194035);
    super.dK(paramInt);
    int j = this.bkE.size();
    int i = 0;
    while (i < j)
    {
      ((f)this.bkE.get(i)).dK(paramInt);
      i += 1;
    }
    AppMethodBeat.o(194035);
  }
  
  public final boolean dO(int paramInt)
  {
    return (this.bjR & paramInt) == paramInt;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(194024);
    this.bjB.reset();
    this.bjD = 0;
    this.bjF = 0;
    this.bjE = 0;
    this.bjG = 0;
    this.bjL.clear();
    this.bjS = false;
    super.reset();
    AppMethodBeat.o(194024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.g
 * JD-Core Version:    0.7.0.1
 */