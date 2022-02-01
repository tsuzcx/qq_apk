package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class f
{
  public static float biZ = 0.5F;
  e biA;
  e biB;
  e biC;
  e biD;
  e biE;
  protected e[] biF;
  protected ArrayList<e> biG;
  protected a[] biH;
  f biI;
  protected float biJ;
  protected int biK;
  protected int biL;
  protected int biM;
  int biN;
  int biO;
  private int biP;
  private int biQ;
  private int biR;
  private int biS;
  protected int biT;
  protected int biU;
  public int biV;
  protected int biW;
  public int biX;
  public int biY;
  public int bic;
  public int bid;
  n bie;
  n bif;
  public int big;
  public int bih;
  int[] bii;
  public int bij;
  public int bik;
  public float bil;
  public int bim;
  public int bin;
  public float bio;
  public boolean bip;
  public boolean biq;
  int bir;
  float bis;
  h bit;
  public int[] biu;
  public float biv;
  e biw;
  e bix;
  e biy;
  public float bja;
  public float bjb;
  public Object bjc;
  private int bjd;
  public int bje;
  public String bjf;
  private String bjg;
  boolean bjh;
  boolean bji;
  boolean bjj;
  boolean bjk;
  boolean bjl;
  public int bjm;
  public int bjn;
  boolean bjo;
  boolean bjp;
  public float[] bjq;
  protected f[] bjr;
  protected f[] bjs;
  f bjt;
  f bju;
  int mHeight;
  int mWidth;
  protected int mf;
  
  public f()
  {
    AppMethodBeat.i(194036);
    this.bic = -1;
    this.bid = -1;
    this.big = 0;
    this.bih = 0;
    this.bii = new int[2];
    this.bij = 0;
    this.bik = 0;
    this.bil = 1.0F;
    this.bim = 0;
    this.bin = 0;
    this.bio = 1.0F;
    this.bir = -1;
    this.bis = 1.0F;
    this.bit = null;
    this.biu = new int[] { 2147483647, 2147483647 };
    this.biv = 0.0F;
    this.biw = new e(this, e.c.bhT);
    this.bix = new e(this, e.c.bhU);
    this.biy = new e(this, e.c.bhV);
    this.biA = new e(this, e.c.bhW);
    this.biB = new e(this, e.c.bhX);
    this.biC = new e(this, e.c.bhZ);
    this.biD = new e(this, e.c.bia);
    this.biE = new e(this, e.c.bhY);
    this.biF = new e[] { this.biw, this.biy, this.bix, this.biA, this.biB, this.biE };
    this.biG = new ArrayList();
    this.biH = new a[] { a.bjw, a.bjw };
    this.biI = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.biJ = 0.0F;
    this.biK = -1;
    this.biL = 0;
    this.biM = 0;
    this.biN = 0;
    this.biO = 0;
    this.biP = 0;
    this.biQ = 0;
    this.biR = 0;
    this.biS = 0;
    this.biT = 0;
    this.biU = 0;
    this.biV = 0;
    this.bja = biZ;
    this.bjb = biZ;
    this.bjd = 0;
    this.bje = 0;
    this.bjf = null;
    this.bjg = null;
    this.bjj = false;
    this.bjk = false;
    this.bjl = false;
    this.bjm = 0;
    this.bjn = 0;
    this.bjq = new float[] { -1.0F, -1.0F };
    this.bjr = new f[] { null, null };
    this.bjs = new f[] { null, null };
    this.bjt = null;
    this.bju = null;
    this.biG.add(this.biw);
    this.biG.add(this.bix);
    this.biG.add(this.biy);
    this.biG.add(this.biA);
    this.biG.add(this.biC);
    this.biG.add(this.biD);
    this.biG.add(this.biE);
    this.biG.add(this.biB);
    AppMethodBeat.o(194036);
  }
  
  private void a(androidx.constraintlayout.a.e parame, boolean paramBoolean1, androidx.constraintlayout.a.h paramh1, androidx.constraintlayout.a.h paramh2, a parama, boolean paramBoolean2, e parame1, e parame2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, float paramFloat2, boolean paramBoolean5)
  {
    AppMethodBeat.i(194073);
    androidx.constraintlayout.a.h localh2 = parame.ar(parame1);
    androidx.constraintlayout.a.h localh3 = parame.ar(parame2);
    androidx.constraintlayout.a.h localh4 = parame.ar(parame1.bhD);
    androidx.constraintlayout.a.h localh5 = parame.ar(parame2.bhD);
    if ((parame.bgG) && (parame1.bhA.state == 1) && (parame2.bhA.state == 1))
    {
      if (androidx.constraintlayout.a.e.Cs() != null)
      {
        androidx.constraintlayout.a.e.Cs();
        AppMethodBeat.o(194073);
        throw null;
      }
      parame1.bhA.c(parame);
      parame2.bhA.c(parame);
      if ((!paramBoolean4) && (paramBoolean1)) {
        parame.a(paramh2, localh3, 0, 6);
      }
      AppMethodBeat.o(194073);
      return;
    }
    if (androidx.constraintlayout.a.e.Cs() != null)
    {
      androidx.constraintlayout.a.e.Cs();
      AppMethodBeat.o(194073);
      throw null;
    }
    boolean bool1 = parame1.isConnected();
    boolean bool2 = parame2.isConnected();
    boolean bool3 = this.biE.isConnected();
    int n = 0;
    int i = 0;
    if (bool1) {
      i = 1;
    }
    int j = i;
    if (bool2) {
      j = i + 1;
    }
    if (bool3) {}
    for (int m = j + 1;; m = j)
    {
      int k = paramInt5;
      if (paramBoolean3) {
        k = 3;
      }
      switch (1.bjv[parama.ordinal()])
      {
      default: 
        paramInt5 = n;
        if (this.bje == 8)
        {
          paramInt2 = 0;
          paramInt5 = 0;
        }
        break;
      }
      for (;;)
      {
        if (paramBoolean5)
        {
          if ((!bool1) && (!bool2) && (!bool3)) {
            parame.a(localh2, paramInt1);
          }
        }
        else
        {
          label319:
          if (paramInt5 != 0) {
            break label530;
          }
          if (!paramBoolean2) {
            break label506;
          }
          parame.c(localh3, localh2, 0, 3);
          if (paramInt3 > 0) {
            parame.a(localh3, localh2, paramInt3, 6);
          }
          j = paramInt5;
          i = paramInt6;
          paramInt2 = paramInt7;
          if (paramInt4 >= 2147483647) {
            break label1508;
          }
          parame.b(localh3, localh2, paramInt4, 6);
          paramInt4 = paramInt5;
        }
        for (paramInt1 = paramInt6;; paramInt1 = paramInt6)
        {
          if ((paramBoolean5) && (!paramBoolean4)) {
            break label898;
          }
          if ((m < 2) && (paramBoolean1))
          {
            parame.a(localh2, paramh1, 0, 6);
            parame.a(paramh2, localh3, 0, 6);
          }
          AppMethodBeat.o(194073);
          return;
          paramInt5 = 0;
          break;
          paramInt5 = 0;
          break;
          paramInt5 = 0;
          break;
          paramInt5 = 1;
          if (k != 4) {
            break;
          }
          paramInt5 = 0;
          break;
          if ((!bool1) || (bool2)) {
            break label319;
          }
          parame.c(localh2, localh4, parame1.CE(), 6);
          break label319;
          label506:
          parame.c(localh3, localh2, paramInt2, 6);
          paramInt4 = paramInt5;
        }
        label530:
        paramInt1 = paramInt6;
        if (paramInt6 == -2) {
          paramInt1 = paramInt2;
        }
        paramInt6 = paramInt7;
        if (paramInt7 == -2) {
          paramInt6 = paramInt2;
        }
        paramInt4 = paramInt2;
        if (paramInt1 > 0)
        {
          parame.a(localh3, localh2, paramInt1, 6);
          paramInt4 = Math.max(paramInt2, paramInt1);
        }
        if (paramInt6 > 0)
        {
          parame.b(localh3, localh2, paramInt6, 6);
          paramInt4 = Math.min(paramInt4, paramInt6);
        }
        for (;;)
        {
          if (k == 1) {
            if (paramBoolean1) {
              parame.c(localh3, localh2, paramInt4, 6);
            }
          }
          while (k != 2) {
            for (;;)
            {
              j = paramInt5;
              i = paramInt1;
              paramInt2 = paramInt6;
              if (paramInt5 == 0) {
                break label1508;
              }
              j = paramInt5;
              i = paramInt1;
              paramInt2 = paramInt6;
              if (m == 2) {
                break label1508;
              }
              j = paramInt5;
              i = paramInt1;
              paramInt2 = paramInt6;
              if (paramBoolean3) {
                break label1508;
              }
              paramInt4 = Math.max(paramInt1, paramInt4);
              paramInt2 = paramInt4;
              if (paramInt6 > 0) {
                paramInt2 = Math.min(paramInt6, paramInt4);
              }
              parame.c(localh3, localh2, paramInt2, 6);
              paramInt4 = 0;
              paramInt7 = paramInt6;
              break;
              if (paramBoolean4) {
                parame.c(localh3, localh2, paramInt4, 4);
              } else {
                parame.c(localh3, localh2, paramInt4, 1);
              }
            }
          }
          androidx.constraintlayout.a.h localh1;
          if ((parame1.bhC == e.c.bhU) || (parame1.bhC == e.c.bhW)) {
            localh1 = parame.ar(this.biI.a(e.c.bhU));
          }
          for (parama = parame.ar(this.biI.a(e.c.bhW));; parama = parame.ar(this.biI.a(e.c.bhV)))
          {
            parame.b(parame.Cv().a(localh3, localh2, parama, localh1, paramFloat2));
            paramInt5 = 0;
            break;
            localh1 = parame.ar(this.biI.a(e.c.bhT));
          }
          label898:
          if ((!bool1) && (!bool2) && (!bool3)) {
            if (paramBoolean1) {
              parame.a(paramh2, localh3, 0, 5);
            }
          }
          do
          {
            for (;;)
            {
              if (paramBoolean1) {
                parame.a(paramh2, localh3, 0, 6);
              }
              AppMethodBeat.o(194073);
              return;
              if ((bool1) && (!bool2))
              {
                if (paramBoolean1) {
                  parame.a(paramh2, localh3, 0, 5);
                }
              }
              else
              {
                if ((bool1) || (!bool2)) {
                  break;
                }
                parame.c(localh3, localh5, -parame2.CE(), 6);
                if (paramBoolean1) {
                  parame.a(localh2, paramh1, 0, 5);
                }
              }
            }
          } while ((!bool1) || (!bool2));
          paramInt2 = 0;
          paramInt5 = 0;
          paramInt6 = 5;
          if (paramInt4 != 0)
          {
            if ((paramBoolean1) && (paramInt3 == 0)) {
              parame.a(localh3, localh2, 0, 6);
            }
            if (k == 0)
            {
              paramInt3 = 6;
              if ((paramInt7 > 0) || (paramInt1 > 0))
              {
                paramInt3 = 4;
                paramInt2 = 1;
              }
              parame.c(localh2, localh4, parame1.CE(), paramInt3);
              parame.c(localh3, localh5, -parame2.CE(), paramInt3);
              if ((paramInt7 <= 0) && (paramInt1 <= 0)) {
                break label1502;
              }
            }
          }
          label1488:
          label1502:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            paramInt5 = paramInt1;
            paramInt1 = paramInt2;
            paramInt3 = paramInt6;
            paramInt2 = paramInt5;
            for (;;)
            {
              label1150:
              paramInt5 = 5;
              if (paramInt2 != 0)
              {
                parame.a(localh2, localh4, parame1.CE(), paramFloat1, localh5, localh3, parame2.CE(), paramInt3);
                paramBoolean2 = parame1.bhD.bhB instanceof b;
                paramBoolean3 = parame2.bhD.bhB instanceof b;
                if ((paramBoolean2) && (!paramBoolean3))
                {
                  paramInt3 = 6;
                  paramBoolean2 = true;
                  paramBoolean3 = paramBoolean1;
                  paramInt2 = 5;
                }
              }
              for (;;)
              {
                if (paramInt1 != 0)
                {
                  paramInt2 = 6;
                  paramInt3 = 6;
                }
                if (((paramInt4 == 0) && (paramBoolean3)) || (paramInt1 != 0)) {
                  parame.a(localh2, localh4, parame1.CE(), paramInt2);
                }
                if (((paramInt4 == 0) && (paramBoolean2)) || (paramInt1 != 0)) {
                  parame.b(localh3, localh5, -parame2.CE(), paramInt3);
                }
                if (!paramBoolean1) {
                  break;
                }
                parame.a(localh2, paramh1, 0, 6);
                break;
                if (k == 1)
                {
                  paramInt3 = 6;
                  paramInt2 = 1;
                  paramInt1 = 1;
                  break label1150;
                }
                if (k != 3) {
                  break label1488;
                }
                paramInt2 = 1;
                paramInt3 = 4;
                paramInt1 = paramInt3;
                if (!paramBoolean3)
                {
                  paramInt1 = paramInt3;
                  if (this.bir != -1)
                  {
                    paramInt1 = paramInt3;
                    if (paramInt7 <= 0) {
                      paramInt1 = 6;
                    }
                  }
                }
                parame.c(localh2, localh4, parame1.CE(), paramInt1);
                parame.c(localh3, localh5, -parame2.CE(), paramInt1);
                paramInt1 = 1;
                paramInt3 = paramInt6;
                break label1150;
                paramInt2 = 1;
                paramInt1 = 0;
                paramInt3 = paramInt6;
                break label1150;
                if ((!paramBoolean2) && (paramBoolean3))
                {
                  paramInt2 = 6;
                  paramBoolean3 = true;
                  paramBoolean2 = paramBoolean1;
                  paramInt3 = paramInt5;
                }
                else
                {
                  paramBoolean2 = paramBoolean1;
                  paramBoolean3 = paramBoolean1;
                  paramInt2 = 5;
                  paramInt3 = paramInt5;
                }
              }
              paramInt1 = 0;
              paramInt2 = paramInt5;
              paramInt3 = paramInt6;
            }
          }
          label1508:
          paramInt4 = j;
          paramInt1 = i;
          paramInt7 = paramInt2;
          break;
        }
      }
    }
  }
  
  private boolean dN(int paramInt)
  {
    paramInt *= 2;
    return (this.biF[paramInt].bhD != null) && (this.biF[paramInt].bhD.bhD != this.biF[paramInt]) && (this.biF[(paramInt + 1)].bhD != null) && (this.biF[(paramInt + 1)].bhD.bhD == this.biF[(paramInt + 1)]);
  }
  
  public void CA()
  {
    AppMethodBeat.i(194108);
    int i = 0;
    while (i < 6)
    {
      this.biF[i].bhA.reset();
      i += 1;
    }
    AppMethodBeat.o(194108);
  }
  
  public void CB() {}
  
  public final boolean CF()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.big == 0)
    {
      bool1 = bool2;
      if (this.biJ == 0.0F)
      {
        bool1 = bool2;
        if (this.bij == 0)
        {
          bool1 = bool2;
          if (this.bik == 0)
          {
            bool1 = bool2;
            if (this.biH[0] == a.bjy) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final boolean CG()
  {
    return (this.bih == 0) && (this.biJ == 0.0F) && (this.bim == 0) && (this.bin == 0) && (this.biH[1] == a.bjy);
  }
  
  public final void CH()
  {
    AppMethodBeat.i(194117);
    int i = 0;
    while (i < 6)
    {
      m localm = this.biF[i].bhA;
      e locale = localm.bkq.bhD;
      if (locale != null)
      {
        if (locale.bhD == localm.bkq)
        {
          localm.type = 4;
          locale.bhA.type = 4;
        }
        int k = localm.bkq.CE();
        int j;
        if (localm.bkq.bhC != e.c.bhV)
        {
          j = k;
          if (localm.bkq.bhC != e.c.bhW) {}
        }
        else
        {
          j = -k;
        }
        localm.b(locale.bhA, j);
      }
      i += 1;
    }
    AppMethodBeat.o(194117);
  }
  
  public final boolean CI()
  {
    return (this.biw.bhA.state == 1) && (this.biy.bhA.state == 1) && (this.bix.bhA.state == 1) && (this.biA.bhA.state == 1);
  }
  
  public final n CJ()
  {
    AppMethodBeat.i(194142);
    if (this.bie == null) {
      this.bie = new n();
    }
    n localn = this.bie;
    AppMethodBeat.o(194142);
    return localn;
  }
  
  public final n CK()
  {
    AppMethodBeat.i(194149);
    if (this.bif == null) {
      this.bif = new n();
    }
    n localn = this.bif;
    AppMethodBeat.o(194149);
    return localn;
  }
  
  public final int CL()
  {
    return this.biP + this.biT;
  }
  
  public final int CM()
  {
    return this.biQ + this.biU;
  }
  
  protected final int CN()
  {
    return this.biL + this.biT;
  }
  
  protected final int CO()
  {
    return this.biM + this.biU;
  }
  
  public final int CP()
  {
    return this.biL + this.mWidth;
  }
  
  public final int CQ()
  {
    return this.biM + this.mHeight;
  }
  
  public final boolean CR()
  {
    return this.biV > 0;
  }
  
  public ArrayList<e> CS()
  {
    return this.biG;
  }
  
  public void CT()
  {
    int i = this.biL;
    int j = this.biM;
    int k = this.biL;
    int m = this.mWidth;
    int n = this.biM;
    int i1 = this.mHeight;
    this.biP = i;
    this.biQ = j;
    this.biR = (k + m - i);
    this.biS = (n + i1 - j);
  }
  
  public final void CU()
  {
    AppMethodBeat.i(194332);
    int j = this.biG.size();
    int i = 0;
    while (i < j)
    {
      ((e)this.biG.get(i)).reset();
      i += 1;
    }
    AppMethodBeat.o(194332);
  }
  
  public final a CV()
  {
    return this.biH[0];
  }
  
  public final a CW()
  {
    return this.biH[1];
  }
  
  public void CX()
  {
    AppMethodBeat.i(194392);
    int j = androidx.constraintlayout.a.e.as(this.biw);
    int i = androidx.constraintlayout.a.e.as(this.bix);
    int m = androidx.constraintlayout.a.e.as(this.biy);
    int n = androidx.constraintlayout.a.e.as(this.biA);
    int k;
    if ((m - j >= 0) && (n - i >= 0) && (j != -2147483648) && (j != 2147483647) && (i != -2147483648) && (i != 2147483647) && (m != -2147483648) && (m != 2147483647) && (n != -2147483648))
    {
      k = n;
      if (n != 2147483647) {}
    }
    else
    {
      k = 0;
      m = 0;
      i = 0;
      j = 0;
    }
    m -= j;
    k -= i;
    this.biL = j;
    this.biM = i;
    if (this.bje == 8)
    {
      this.mWidth = 0;
      this.mHeight = 0;
      AppMethodBeat.o(194392);
      return;
    }
    if ((this.biH[0] == a.bjw) && (m < this.mWidth)) {}
    for (i = this.mWidth;; i = m)
    {
      if ((this.biH[1] == a.bjw) && (k < this.mHeight)) {}
      for (j = this.mHeight;; j = k)
      {
        this.mWidth = i;
        this.mHeight = j;
        if (this.mHeight < this.biW) {
          this.mHeight = this.biW;
        }
        if (this.mWidth < this.mf) {
          this.mWidth = this.mf;
        }
        this.bjk = true;
        AppMethodBeat.o(194392);
        return;
      }
    }
  }
  
  public boolean Cz()
  {
    return this.bje != 8;
  }
  
  public e a(e.c paramc)
  {
    AppMethodBeat.i(194337);
    switch (1.bhK[paramc.ordinal()])
    {
    default: 
      paramc = new AssertionError(paramc.name());
      AppMethodBeat.o(194337);
      throw paramc;
    case 1: 
      paramc = this.biw;
      AppMethodBeat.o(194337);
      return paramc;
    case 2: 
      paramc = this.bix;
      AppMethodBeat.o(194337);
      return paramc;
    case 3: 
      paramc = this.biy;
      AppMethodBeat.o(194337);
      return paramc;
    case 4: 
      paramc = this.biA;
      AppMethodBeat.o(194337);
      return paramc;
    case 5: 
      paramc = this.biB;
      AppMethodBeat.o(194337);
      return paramc;
    case 7: 
      paramc = this.biC;
      AppMethodBeat.o(194337);
      return paramc;
    case 8: 
      paramc = this.biD;
      AppMethodBeat.o(194337);
      return paramc;
    case 6: 
      paramc = this.biE;
      AppMethodBeat.o(194337);
      return paramc;
    }
    AppMethodBeat.o(194337);
    return null;
  }
  
  public final void a(e.c paramc1, f paramf, e.c paramc2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194324);
    a(paramc1).a(paramf.a(paramc2), paramInt1, paramInt2, e.b.bhP, 0, true);
    AppMethodBeat.o(194324);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(194355);
    this.biH[0] = parama;
    if (parama == a.bjx) {
      setWidth(this.biX);
    }
    AppMethodBeat.o(194355);
  }
  
  public void a(c paramc)
  {
    AppMethodBeat.i(194157);
    this.biw.CD();
    this.bix.CD();
    this.biy.CD();
    this.biA.CD();
    this.biB.CD();
    this.biE.CD();
    this.biC.CD();
    this.biD.CD();
    AppMethodBeat.o(194157);
  }
  
  public void a(androidx.constraintlayout.a.e parame)
  {
    AppMethodBeat.i(194384);
    androidx.constraintlayout.a.h localh3 = parame.ar(this.biw);
    androidx.constraintlayout.a.h localh4 = parame.ar(this.biy);
    Object localObject1 = parame.ar(this.bix);
    androidx.constraintlayout.a.h localh5 = parame.ar(this.biA);
    androidx.constraintlayout.a.h localh6 = parame.ar(this.biB);
    boolean bool8 = false;
    boolean bool5 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool1;
    boolean bool2;
    label125:
    boolean bool3;
    label148:
    boolean bool4;
    if (this.biI != null)
    {
      if (this.biI == null) {
        break label1048;
      }
      if (this.biI.biH[0] != a.bjx) {
        break label1042;
      }
      bool1 = true;
      if (this.biI == null) {
        break label1060;
      }
      if (this.biI.biH[1] != a.bjx) {
        break label1054;
      }
      bool2 = true;
      if (!dN(0)) {
        break label1066;
      }
      ((g)this.biI).b(this, 0);
      bool3 = true;
      if (!dN(1)) {
        break label1132;
      }
      ((g)this.biI).b(this, 1);
      bool4 = true;
      label171:
      if ((bool1) && (this.bje != 8) && (this.biw.bhD == null) && (this.biy.bhD == null)) {
        parame.a(parame.ar(this.biI.biy), localh4, 0, 1);
      }
      bool5 = bool4;
      bool7 = bool1;
      bool6 = bool2;
      bool8 = bool3;
      if (bool2)
      {
        bool5 = bool4;
        bool7 = bool1;
        bool6 = bool2;
        bool8 = bool3;
        if (this.bje != 8)
        {
          bool5 = bool4;
          bool7 = bool1;
          bool6 = bool2;
          bool8 = bool3;
          if (this.bix.bhD == null)
          {
            bool5 = bool4;
            bool7 = bool1;
            bool6 = bool2;
            bool8 = bool3;
            if (this.biA.bhD == null)
            {
              bool5 = bool4;
              bool7 = bool1;
              bool6 = bool2;
              bool8 = bool3;
              if (this.biB == null)
              {
                parame.a(parame.ar(this.biI.biA), localh5, 0, 1);
                bool8 = bool3;
                bool6 = bool2;
                bool7 = bool1;
                bool5 = bool4;
              }
            }
          }
        }
      }
    }
    int i = this.mWidth;
    int k = i;
    if (i < this.mf) {
      k = this.mf;
    }
    i = this.mHeight;
    int m = i;
    if (i < this.biW) {
      m = this.biW;
    }
    int i3;
    label439:
    int i4;
    label454:
    int j;
    int i1;
    int i2;
    int n;
    int i6;
    if (this.biH[0] != a.bjy)
    {
      i3 = 1;
      if (this.biH[1] == a.bjy) {
        break label1204;
      }
      i4 = 1;
      i = 0;
      this.bir = this.biK;
      this.bis = this.biJ;
      j = this.big;
      int i5 = this.bih;
      i1 = j;
      i2 = i5;
      n = i;
      if (this.biJ <= 0.0F) {
        break label2128;
      }
      i1 = j;
      i2 = i5;
      n = i;
      if (this.bje == 8) {
        break label2128;
      }
      i6 = 1;
      i = j;
      if (this.biH[0] == a.bjy)
      {
        i = j;
        if (j == 0) {
          i = 3;
        }
      }
      j = i5;
      if (this.biH[1] == a.bjy)
      {
        j = i5;
        if (i5 == 0) {
          j = 3;
        }
      }
      if ((this.biH[0] != a.bjy) || (this.biH[1] != a.bjy) || (i != 3) || (j != 3)) {
        break label1380;
      }
      if (this.bir == -1)
      {
        if ((i3 == 0) || (i4 != 0)) {
          break label1210;
        }
        this.bir = 0;
      }
      label638:
      if ((this.bir != 0) || ((this.bix.isConnected()) && (this.biA.isConnected()))) {
        break label1246;
      }
      this.bir = 1;
      label670:
      if ((this.bir == -1) && ((!this.bix.isConnected()) || (!this.biA.isConnected()) || (!this.biw.isConnected()) || (!this.biy.isConnected())))
      {
        if ((!this.bix.isConnected()) || (!this.biA.isConnected())) {
          break label1282;
        }
        this.bir = 0;
      }
      label743:
      if (this.bir == -1)
      {
        if ((!bool7) || (bool6)) {
          break label1320;
        }
        this.bir = 0;
      }
      label766:
      if (this.bir == -1)
      {
        if ((this.bij <= 0) || (this.bim != 0)) {
          break label1348;
        }
        this.bir = 0;
      }
      label793:
      if ((this.bir == -1) && (bool7) && (bool6))
      {
        this.bis = (1.0F / this.bis);
        this.bir = 1;
      }
      i1 = 1;
      n = k;
      k = i1;
    }
    for (;;)
    {
      label837:
      this.bii[0] = i;
      this.bii[1] = j;
      label875:
      androidx.constraintlayout.a.h localh1;
      if ((k != 0) && ((this.bir == 0) || (this.bir == -1)))
      {
        bool2 = true;
        if ((this.biH[0] != a.bjx) || (!(this instanceof g))) {
          break label1546;
        }
        bool3 = true;
        label897:
        bool1 = true;
        if (this.biE.isConnected()) {
          bool1 = false;
        }
        if (this.bic != 2)
        {
          if (this.biI == null) {
            break label1552;
          }
          localh1 = parame.ar(this.biI.biy);
          label941:
          if (this.biI == null) {
            break label1558;
          }
        }
      }
      label1042:
      label1558:
      for (androidx.constraintlayout.a.h localh2 = parame.ar(this.biI.biw);; localh2 = null)
      {
        a(parame, bool7, localh2, localh1, this.biH[0], bool3, this.biw, this.biy, this.biL, n, this.mf, this.biu[0], this.bja, bool2, bool8, i, this.bij, this.bik, this.bil, bool1);
        if (this.bid != 2) {
          break label1564;
        }
        AppMethodBeat.o(194384);
        return;
        bool1 = false;
        break;
        label1048:
        bool1 = false;
        break;
        label1054:
        bool2 = false;
        break label125;
        label1060:
        bool2 = false;
        break label125;
        label1066:
        if (((this.biw.bhD != null) && (this.biw.bhD.bhD == this.biw)) || ((this.biy.bhD != null) && (this.biy.bhD.bhD == this.biy)))
        {
          bool3 = true;
          break label148;
        }
        bool3 = false;
        break label148;
        label1132:
        if (((this.bix.bhD != null) && (this.bix.bhD.bhD == this.bix)) || ((this.biA.bhD != null) && (this.biA.bhD.bhD == this.biA)))
        {
          bool4 = true;
          break label171;
        }
        bool4 = false;
        break label171;
        i3 = 0;
        break label439;
        label1204:
        i4 = 0;
        break label454;
        label1210:
        if ((i3 != 0) || (i4 == 0)) {
          break label638;
        }
        this.bir = 1;
        if (this.biK != -1) {
          break label638;
        }
        this.bis = (1.0F / this.bis);
        break label638;
        label1246:
        if ((this.bir != 1) || ((this.biw.isConnected()) && (this.biy.isConnected()))) {
          break label670;
        }
        this.bir = 0;
        break label670;
        if ((!this.biw.isConnected()) || (!this.biy.isConnected())) {
          break label743;
        }
        this.bis = (1.0F / this.bis);
        this.bir = 1;
        break label743;
        label1320:
        if ((bool7) || (!bool6)) {
          break label766;
        }
        this.bis = (1.0F / this.bis);
        this.bir = 1;
        break label766;
        label1348:
        if ((this.bij != 0) || (this.bim <= 0)) {
          break label793;
        }
        this.bis = (1.0F / this.bis);
        this.bir = 1;
        break label793;
        label1380:
        if ((this.biH[0] == a.bjy) && (i == 3))
        {
          this.bir = 0;
          n = (int)(this.bis * this.mHeight);
          if (this.biH[1] == a.bjy) {
            break label2150;
          }
          i = 4;
          k = 0;
          break label837;
        }
        i1 = i;
        i2 = j;
        n = i6;
        if (this.biH[1] != a.bjy) {
          break label2128;
        }
        i1 = i;
        i2 = j;
        n = i6;
        if (j != 3) {
          break label2128;
        }
        this.bir = 1;
        if (this.biK == -1) {
          this.bis = (1.0F / this.bis);
        }
        m = (int)(this.bis * this.mWidth);
        if (this.biH[0] == a.bjy) {
          break label2114;
        }
        j = 4;
        i1 = 0;
        n = k;
        k = i1;
        break label837;
        bool2 = false;
        break label875;
        bool3 = false;
        break label897;
        localh1 = null;
        break label941;
      }
      label1282:
      label1546:
      label1552:
      label1564:
      if ((this.biH[1] == a.bjx) && ((this instanceof g)))
      {
        bool2 = true;
        if ((k == 0) || ((this.bir != 1) && (this.bir != -1))) {
          break label2021;
        }
        bool3 = true;
        label1610:
        bool4 = bool1;
        if (this.biV > 0)
        {
          if (this.biB.bhA.state != 1) {
            break label2027;
          }
          this.biB.bhA.c(parame);
          bool4 = bool1;
        }
        label1650:
        if (this.biI == null) {
          break label2083;
        }
        localh1 = parame.ar(this.biI.biA);
        if (this.biI == null) {
          break label2089;
        }
        localh2 = parame.ar(this.biI.bix);
        a(parame, bool6, localh2, localh1, this.biH[1], bool2, this.bix, this.biA, this.biM, m, this.biW, this.biu[1], this.bjb, bool3, bool5, j, this.bim, this.bin, this.bio, bool4);
        if (k != 0)
        {
          if (this.bir != 1) {
            break label2095;
          }
          parame.c(localh5, (androidx.constraintlayout.a.h)localObject1, localh4, localh3, this.bis);
        }
      }
      for (;;)
      {
        label1670:
        label1690:
        if (this.biE.isConnected())
        {
          Object localObject2 = this.biE.bhD.bhB;
          float f = (float)Math.toRadians(this.biv + 90.0F);
          i = this.biE.CE();
          localh1 = parame.ar(a(e.c.bhT));
          localObject1 = parame.ar(a(e.c.bhU));
          localh2 = parame.ar(a(e.c.bhV));
          localh5 = parame.ar(a(e.c.bhW));
          localh3 = parame.ar(((f)localObject2).a(e.c.bhT));
          localh6 = parame.ar(((f)localObject2).a(e.c.bhU));
          localh4 = parame.ar(((f)localObject2).a(e.c.bhV));
          localObject2 = parame.ar(((f)localObject2).a(e.c.bhW));
          androidx.constraintlayout.a.b localb = parame.Cv();
          localb.b((androidx.constraintlayout.a.h)localObject1, localh5, localh6, (androidx.constraintlayout.a.h)localObject2, (float)(Math.sin(f) * i));
          parame.b(localb);
          localObject1 = parame.Cv();
          ((androidx.constraintlayout.a.b)localObject1).b(localh1, localh2, localh3, localh4, (float)(Math.cos(f) * i));
          parame.b((androidx.constraintlayout.a.b)localObject1);
        }
        AppMethodBeat.o(194384);
        return;
        bool2 = false;
        break;
        label2021:
        bool3 = false;
        break label1610;
        label2027:
        parame.c(localh6, (androidx.constraintlayout.a.h)localObject1, this.biV, 6);
        bool4 = bool1;
        if (this.biB.bhD == null) {
          break label1650;
        }
        parame.c(localh6, parame.ar(this.biB.bhD), 0, 6);
        bool4 = false;
        break label1650;
        label2083:
        localh1 = null;
        break label1670;
        label2089:
        localh2 = null;
        break label1690;
        label2095:
        parame.c(localh4, localh3, localh5, (androidx.constraintlayout.a.h)localObject1, this.bis);
      }
      label2114:
      i1 = 1;
      n = k;
      k = i1;
      continue;
      label2128:
      j = i2;
      i = i1;
      i1 = n;
      n = k;
      k = i1;
      continue;
      label2150:
      k = 1;
    }
  }
  
  public final void ao(int paramInt1, int paramInt2)
  {
    this.biL = paramInt1;
    this.biM = paramInt2;
  }
  
  public void ap(int paramInt1, int paramInt2)
  {
    this.biT = paramInt1;
    this.biU = paramInt2;
  }
  
  public final void ap(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(194288);
    if ((paramString == null) || (paramString.length() == 0))
    {
      this.biJ = 0.0F;
      AppMethodBeat.o(194288);
      return;
    }
    int m = paramString.length();
    int j = paramString.indexOf(',');
    String str;
    if ((j > 0) && (j < m - 1))
    {
      str = paramString.substring(0, j);
      if (!str.equalsIgnoreCase("W")) {}
    }
    for (;;)
    {
      int k = j + 1;
      j = i;
      i = k;
      label94:
      k = paramString.indexOf(':');
      if ((k >= 0) && (k < m - 1))
      {
        str = paramString.substring(i, k);
        paramString = paramString.substring(k + 1);
        if ((str.length() <= 0) || (paramString.length() <= 0)) {}
      }
      for (;;)
      {
        float f1;
        try
        {
          f1 = Float.parseFloat(str);
          float f2 = Float.parseFloat(paramString);
          if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
            break label277;
          }
          if (j == 1)
          {
            f1 = Math.abs(f2 / f1);
            if (f1 > 0.0F)
            {
              this.biJ = f1;
              this.biK = j;
            }
            AppMethodBeat.o(194288);
            return;
            if (!str.equalsIgnoreCase("H")) {
              break label282;
            }
            i = 1;
            break;
            i = 0;
            j = -1;
            break label94;
          }
          f1 /= f2;
          f1 = Math.abs(f1);
          continue;
          f1 = 0.0F;
        }
        catch (NumberFormatException paramString) {}
        continue;
        paramString = paramString.substring(i);
        if (paramString.length() > 0) {
          try
          {
            f1 = Float.parseFloat(paramString);
          }
          catch (NumberFormatException paramString) {}
        } else {
          label277:
          f1 = 0.0F;
        }
      }
      label282:
      i = -1;
    }
  }
  
  public final void aq(int paramInt1, int paramInt2)
  {
    this.biL = paramInt1;
    this.mWidth = (paramInt2 - paramInt1);
    if (this.mWidth < this.mf) {
      this.mWidth = this.mf;
    }
  }
  
  public final void ar(int paramInt1, int paramInt2)
  {
    this.biM = paramInt1;
    this.mHeight = (paramInt2 - paramInt1);
    if (this.mHeight < this.biW) {
      this.mHeight = this.biW;
    }
  }
  
  final void as(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      this.biN = paramInt1;
    }
    while (paramInt2 != 1) {
      return;
    }
    this.biO = paramInt1;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(194360);
    this.biH[1] = parama;
    if (parama == a.bjx) {
      setHeight(this.biY);
    }
    AppMethodBeat.o(194360);
  }
  
  public final void b(androidx.constraintlayout.a.e parame)
  {
    AppMethodBeat.i(194163);
    parame.ar(this.biw);
    parame.ar(this.bix);
    parame.ar(this.biy);
    parame.ar(this.biA);
    if (this.biV > 0) {
      parame.ar(this.biB);
    }
    AppMethodBeat.o(194163);
  }
  
  public void dK(int paramInt)
  {
    AppMethodBeat.i(194127);
    k.a(paramInt, this);
    AppMethodBeat.o(194127);
  }
  
  public final int dL(int paramInt)
  {
    AppMethodBeat.i(194196);
    if (paramInt == 0)
    {
      paramInt = getWidth();
      AppMethodBeat.o(194196);
      return paramInt;
    }
    if (paramInt == 1)
    {
      paramInt = getHeight();
      AppMethodBeat.o(194196);
      return paramInt;
    }
    AppMethodBeat.o(194196);
    return 0;
  }
  
  public final a dM(int paramInt)
  {
    if (paramInt == 0) {
      return this.biH[0];
    }
    if (paramInt == 1) {
      return this.biH[1];
    }
    return null;
  }
  
  public final int getHeight()
  {
    if (this.bje == 8) {
      return 0;
    }
    return this.mHeight;
  }
  
  public final int getWidth()
  {
    if (this.bje == 8) {
      return 0;
    }
    return this.mWidth;
  }
  
  public final int getX()
  {
    return this.biL;
  }
  
  public final int getY()
  {
    return this.biM;
  }
  
  public final void q(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194300);
    if (paramInt3 == 0) {
      aq(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.bjk = true;
      AppMethodBeat.o(194300);
      return;
      if (paramInt3 == 1) {
        ar(paramInt1, paramInt2);
      }
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(194100);
    this.biw.reset();
    this.bix.reset();
    this.biy.reset();
    this.biA.reset();
    this.biB.reset();
    this.biC.reset();
    this.biD.reset();
    this.biE.reset();
    this.biI = null;
    this.biv = 0.0F;
    this.mWidth = 0;
    this.mHeight = 0;
    this.biJ = 0.0F;
    this.biK = -1;
    this.biL = 0;
    this.biM = 0;
    this.biP = 0;
    this.biQ = 0;
    this.biR = 0;
    this.biS = 0;
    this.biT = 0;
    this.biU = 0;
    this.biV = 0;
    this.mf = 0;
    this.biW = 0;
    this.biX = 0;
    this.biY = 0;
    this.bja = biZ;
    this.bjb = biZ;
    this.biH[0] = a.bjw;
    this.biH[1] = a.bjw;
    this.bjc = null;
    this.bjd = 0;
    this.bje = 0;
    this.bjg = null;
    this.bjh = false;
    this.bji = false;
    this.bjm = 0;
    this.bjn = 0;
    this.bjo = false;
    this.bjp = false;
    this.bjq[0] = -1.0F;
    this.bjq[1] = -1.0F;
    this.bic = -1;
    this.bid = -1;
    this.biu[0] = 2147483647;
    this.biu[1] = 2147483647;
    this.big = 0;
    this.bih = 0;
    this.bil = 1.0F;
    this.bio = 1.0F;
    this.bik = 2147483647;
    this.bin = 2147483647;
    this.bij = 0;
    this.bim = 0;
    this.bir = -1;
    this.bis = 1.0F;
    if (this.bie != null) {
      this.bie.reset();
    }
    if (this.bif != null) {
      this.bif.reset();
    }
    this.bit = null;
    this.bjj = false;
    this.bjk = false;
    this.bjl = false;
    AppMethodBeat.o(194100);
  }
  
  public final void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
    if (this.mHeight < this.biW) {
      this.mHeight = this.biW;
    }
  }
  
  public final void setMinHeight(int paramInt)
  {
    if (paramInt < 0)
    {
      this.biW = 0;
      return;
    }
    this.biW = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    if (paramInt < 0)
    {
      this.mf = 0;
      return;
    }
    this.mf = paramInt;
  }
  
  public final void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
    if (this.mWidth < this.mf) {
      this.mWidth = this.mf;
    }
  }
  
  public final void setX(int paramInt)
  {
    this.biL = paramInt;
  }
  
  public final void setY(int paramInt)
  {
    this.biM = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194174);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.bjg != null)
    {
      str = "type: " + this.bjg + " ";
      localStringBuilder = localStringBuilder.append(str);
      if (this.bjf == null) {
        break label196;
      }
    }
    label196:
    for (String str = "id: " + this.bjf + " ";; str = "")
    {
      str = str + "(" + this.biL + ", " + this.biM + ") - (" + this.mWidth + " x " + this.mHeight + ") wrap: (" + this.biX + " x " + this.biY + ")";
      AppMethodBeat.o(194174);
      return str;
      str = "";
      break;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(194126);
      bjw = new a("FIXED", 0);
      bjx = new a("WRAP_CONTENT", 1);
      bjy = new a("MATCH_CONSTRAINT", 2);
      bjz = new a("MATCH_PARENT", 3);
      bjA = new a[] { bjw, bjx, bjy, bjz };
      AppMethodBeat.o(194126);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.a.a.f
 * JD-Core Version:    0.7.0.1
 */