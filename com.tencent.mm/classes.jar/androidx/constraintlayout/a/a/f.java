package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class f
{
  public static float CS = 0.5F;
  public int BV;
  public int BW;
  n BX;
  n BY;
  public int BZ;
  f CA;
  protected float CB;
  protected int CC;
  protected int CD;
  protected int CE;
  int CF;
  int CG;
  private int CH;
  private int CI;
  private int CJ;
  private int CK;
  protected int CL;
  protected int CM;
  public int CN;
  protected int CO;
  public int CQ;
  public int CR;
  public float CT;
  public float CU;
  public Object CV;
  private int CW;
  public int CX;
  public String CY;
  boolean CZ;
  public int Ca;
  int[] Cb;
  public int Cc;
  public int Cd;
  public float Ce;
  public int Cf;
  public int Cg;
  public float Ch;
  public boolean Ci;
  public boolean Cj;
  int Ck;
  float Cl;
  h Cm;
  public int[] Cn;
  public float Co;
  e Cp;
  e Cq;
  e Cr;
  e Cs;
  e Ct;
  e Cu;
  e Cv;
  e Cw;
  protected e[] Cx;
  protected ArrayList<e> Cy;
  protected a[] Cz;
  boolean Da;
  boolean Db;
  boolean Dc;
  boolean Dd;
  public int De;
  public int Df;
  boolean Dg;
  boolean Dh;
  public float[] Di;
  protected f[] Dj;
  protected f[] Dk;
  f Dl;
  f Dm;
  protected int lj;
  int mHeight;
  private String mType;
  int mWidth;
  
  public f()
  {
    AppMethodBeat.i(229350);
    this.BV = -1;
    this.BW = -1;
    this.BZ = 0;
    this.Ca = 0;
    this.Cb = new int[2];
    this.Cc = 0;
    this.Cd = 0;
    this.Ce = 1.0F;
    this.Cf = 0;
    this.Cg = 0;
    this.Ch = 1.0F;
    this.Ck = -1;
    this.Cl = 1.0F;
    this.Cm = null;
    this.Cn = new int[] { 2147483647, 2147483647 };
    this.Co = 0.0F;
    this.Cp = new e(this, e.c.BM);
    this.Cq = new e(this, e.c.BN);
    this.Cr = new e(this, e.c.BO);
    this.Cs = new e(this, e.c.BP);
    this.Ct = new e(this, e.c.BQ);
    this.Cu = new e(this, e.c.BS);
    this.Cv = new e(this, e.c.BT);
    this.Cw = new e(this, e.c.BR);
    this.Cx = new e[] { this.Cp, this.Cr, this.Cq, this.Cs, this.Ct, this.Cw };
    this.Cy = new ArrayList();
    this.Cz = new a[] { a.Do, a.Do };
    this.CA = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.CB = 0.0F;
    this.CC = -1;
    this.CD = 0;
    this.CE = 0;
    this.CF = 0;
    this.CG = 0;
    this.CH = 0;
    this.CI = 0;
    this.CJ = 0;
    this.CK = 0;
    this.CL = 0;
    this.CM = 0;
    this.CN = 0;
    this.CT = CS;
    this.CU = CS;
    this.CW = 0;
    this.CX = 0;
    this.CY = null;
    this.mType = null;
    this.Db = false;
    this.Dc = false;
    this.Dd = false;
    this.De = 0;
    this.Df = 0;
    this.Di = new float[] { -1.0F, -1.0F };
    this.Dj = new f[] { null, null };
    this.Dk = new f[] { null, null };
    this.Dl = null;
    this.Dm = null;
    this.Cy.add(this.Cp);
    this.Cy.add(this.Cq);
    this.Cy.add(this.Cr);
    this.Cy.add(this.Cs);
    this.Cy.add(this.Cu);
    this.Cy.add(this.Cv);
    this.Cy.add(this.Cw);
    this.Cy.add(this.Ct);
    AppMethodBeat.o(229350);
  }
  
  private void a(androidx.constraintlayout.a.e parame, boolean paramBoolean1, androidx.constraintlayout.a.h paramh1, androidx.constraintlayout.a.h paramh2, a parama, boolean paramBoolean2, e parame1, e parame2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, float paramFloat2, boolean paramBoolean5)
  {
    AppMethodBeat.i(229468);
    androidx.constraintlayout.a.h localh2 = parame.s(parame1);
    androidx.constraintlayout.a.h localh3 = parame.s(parame2);
    androidx.constraintlayout.a.h localh4 = parame.s(parame1.Bv);
    androidx.constraintlayout.a.h localh5 = parame.s(parame2.Bv);
    if ((parame.Ay) && (parame1.Bs.state == 1) && (parame2.Bs.state == 1))
    {
      if (androidx.constraintlayout.a.e.fi() != null)
      {
        androidx.constraintlayout.a.e.fi();
        AppMethodBeat.o(229468);
        throw null;
      }
      parame1.Bs.c(parame);
      parame2.Bs.c(parame);
      if ((!paramBoolean4) && (paramBoolean1)) {
        parame.a(paramh2, localh3, 0, 6);
      }
      AppMethodBeat.o(229468);
      return;
    }
    if (androidx.constraintlayout.a.e.fi() != null)
    {
      androidx.constraintlayout.a.e.fi();
      AppMethodBeat.o(229468);
      throw null;
    }
    boolean bool1 = parame1.isConnected();
    boolean bool2 = parame2.isConnected();
    boolean bool3 = this.Cw.isConnected();
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
      switch (1.Dn[parama.ordinal()])
      {
      default: 
        paramInt5 = n;
        if (this.CX == 8)
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
          AppMethodBeat.o(229468);
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
          parame.c(localh2, localh4, parame1.fv(), 6);
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
          if ((parame1.Bu == e.c.BN) || (parame1.Bu == e.c.BP)) {
            localh1 = parame.s(this.CA.a(e.c.BN));
          }
          for (parama = parame.s(this.CA.a(e.c.BP));; parama = parame.s(this.CA.a(e.c.BO)))
          {
            parame.b(parame.fm().a(localh3, localh2, parama, localh1, paramFloat2));
            paramInt5 = 0;
            break;
            localh1 = parame.s(this.CA.a(e.c.BM));
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
              AppMethodBeat.o(229468);
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
                parame.c(localh3, localh5, -parame2.fv(), 6);
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
              parame.c(localh2, localh4, parame1.fv(), paramInt3);
              parame.c(localh3, localh5, -parame2.fv(), paramInt3);
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
                parame.a(localh2, localh4, parame1.fv(), paramFloat1, localh5, localh3, parame2.fv(), paramInt3);
                paramBoolean2 = parame1.Bv.Bt instanceof b;
                paramBoolean3 = parame2.Bv.Bt instanceof b;
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
                  parame.a(localh2, localh4, parame1.fv(), paramInt2);
                }
                if (((paramInt4 == 0) && (paramBoolean2)) || (paramInt1 != 0)) {
                  parame.b(localh3, localh5, -parame2.fv(), paramInt3);
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
                  if (this.Ck != -1)
                  {
                    paramInt1 = paramInt3;
                    if (paramInt7 <= 0) {
                      paramInt1 = 6;
                    }
                  }
                }
                parame.c(localh2, localh4, parame1.fv(), paramInt1);
                parame.c(localh3, localh5, -parame2.fv(), paramInt1);
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
  
  private boolean aX(int paramInt)
  {
    paramInt *= 2;
    return (this.Cx[paramInt].Bv != null) && (this.Cx[paramInt].Bv.Bv != this.Cx[paramInt]) && (this.Cx[(paramInt + 1)].Bv != null) && (this.Cx[(paramInt + 1)].Bv.Bv == this.Cx[(paramInt + 1)]);
  }
  
  public e a(e.c paramc)
  {
    AppMethodBeat.i(229434);
    switch (1.BC[paramc.ordinal()])
    {
    default: 
      paramc = new AssertionError(paramc.name());
      AppMethodBeat.o(229434);
      throw paramc;
    case 1: 
      paramc = this.Cp;
      AppMethodBeat.o(229434);
      return paramc;
    case 2: 
      paramc = this.Cq;
      AppMethodBeat.o(229434);
      return paramc;
    case 3: 
      paramc = this.Cr;
      AppMethodBeat.o(229434);
      return paramc;
    case 4: 
      paramc = this.Cs;
      AppMethodBeat.o(229434);
      return paramc;
    case 5: 
      paramc = this.Ct;
      AppMethodBeat.o(229434);
      return paramc;
    case 7: 
      paramc = this.Cu;
      AppMethodBeat.o(229434);
      return paramc;
    case 8: 
      paramc = this.Cv;
      AppMethodBeat.o(229434);
      return paramc;
    case 6: 
      paramc = this.Cw;
      AppMethodBeat.o(229434);
      return paramc;
    }
    AppMethodBeat.o(229434);
    return null;
  }
  
  public final void a(e.c paramc1, f paramf, e.c paramc2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229425);
    a(paramc1).a(paramf.a(paramc2), paramInt1, paramInt2, e.b.BI, 0, true);
    AppMethodBeat.o(229425);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(229437);
    this.Cz[0] = parama;
    if (parama == a.Dp) {
      setWidth(this.CQ);
    }
    AppMethodBeat.o(229437);
  }
  
  public void a(c paramc)
  {
    AppMethodBeat.i(229351);
    this.Cp.fu();
    this.Cq.fu();
    this.Cr.fu();
    this.Cs.fu();
    this.Ct.fu();
    this.Cw.fu();
    this.Cu.fu();
    this.Cv.fu();
    AppMethodBeat.o(229351);
  }
  
  public void a(androidx.constraintlayout.a.e parame)
  {
    AppMethodBeat.i(229460);
    androidx.constraintlayout.a.h localh3 = parame.s(this.Cp);
    androidx.constraintlayout.a.h localh4 = parame.s(this.Cr);
    Object localObject1 = parame.s(this.Cq);
    androidx.constraintlayout.a.h localh5 = parame.s(this.Cs);
    androidx.constraintlayout.a.h localh6 = parame.s(this.Ct);
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
    if (this.CA != null)
    {
      if (this.CA == null) {
        break label1048;
      }
      if (this.CA.Cz[0] != a.Dp) {
        break label1042;
      }
      bool1 = true;
      if (this.CA == null) {
        break label1060;
      }
      if (this.CA.Cz[1] != a.Dp) {
        break label1054;
      }
      bool2 = true;
      if (!aX(0)) {
        break label1066;
      }
      ((g)this.CA).b(this, 0);
      bool3 = true;
      if (!aX(1)) {
        break label1132;
      }
      ((g)this.CA).b(this, 1);
      bool4 = true;
      label171:
      if ((bool1) && (this.CX != 8) && (this.Cp.Bv == null) && (this.Cr.Bv == null)) {
        parame.a(parame.s(this.CA.Cr), localh4, 0, 1);
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
        if (this.CX != 8)
        {
          bool5 = bool4;
          bool7 = bool1;
          bool6 = bool2;
          bool8 = bool3;
          if (this.Cq.Bv == null)
          {
            bool5 = bool4;
            bool7 = bool1;
            bool6 = bool2;
            bool8 = bool3;
            if (this.Cs.Bv == null)
            {
              bool5 = bool4;
              bool7 = bool1;
              bool6 = bool2;
              bool8 = bool3;
              if (this.Ct == null)
              {
                parame.a(parame.s(this.CA.Cs), localh5, 0, 1);
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
    if (i < this.lj) {
      k = this.lj;
    }
    i = this.mHeight;
    int m = i;
    if (i < this.CO) {
      m = this.CO;
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
    if (this.Cz[0] != a.Dq)
    {
      i3 = 1;
      if (this.Cz[1] == a.Dq) {
        break label1204;
      }
      i4 = 1;
      i = 0;
      this.Ck = this.CC;
      this.Cl = this.CB;
      j = this.BZ;
      int i5 = this.Ca;
      i1 = j;
      i2 = i5;
      n = i;
      if (this.CB <= 0.0F) {
        break label2128;
      }
      i1 = j;
      i2 = i5;
      n = i;
      if (this.CX == 8) {
        break label2128;
      }
      i6 = 1;
      i = j;
      if (this.Cz[0] == a.Dq)
      {
        i = j;
        if (j == 0) {
          i = 3;
        }
      }
      j = i5;
      if (this.Cz[1] == a.Dq)
      {
        j = i5;
        if (i5 == 0) {
          j = 3;
        }
      }
      if ((this.Cz[0] != a.Dq) || (this.Cz[1] != a.Dq) || (i != 3) || (j != 3)) {
        break label1380;
      }
      if (this.Ck == -1)
      {
        if ((i3 == 0) || (i4 != 0)) {
          break label1210;
        }
        this.Ck = 0;
      }
      label638:
      if ((this.Ck != 0) || ((this.Cq.isConnected()) && (this.Cs.isConnected()))) {
        break label1246;
      }
      this.Ck = 1;
      label670:
      if ((this.Ck == -1) && ((!this.Cq.isConnected()) || (!this.Cs.isConnected()) || (!this.Cp.isConnected()) || (!this.Cr.isConnected())))
      {
        if ((!this.Cq.isConnected()) || (!this.Cs.isConnected())) {
          break label1282;
        }
        this.Ck = 0;
      }
      label743:
      if (this.Ck == -1)
      {
        if ((!bool7) || (bool6)) {
          break label1320;
        }
        this.Ck = 0;
      }
      label766:
      if (this.Ck == -1)
      {
        if ((this.Cc <= 0) || (this.Cf != 0)) {
          break label1348;
        }
        this.Ck = 0;
      }
      label793:
      if ((this.Ck == -1) && (bool7) && (bool6))
      {
        this.Cl = (1.0F / this.Cl);
        this.Ck = 1;
      }
      i1 = 1;
      n = k;
      k = i1;
    }
    for (;;)
    {
      label837:
      this.Cb[0] = i;
      this.Cb[1] = j;
      label875:
      androidx.constraintlayout.a.h localh1;
      if ((k != 0) && ((this.Ck == 0) || (this.Ck == -1)))
      {
        bool2 = true;
        if ((this.Cz[0] != a.Dp) || (!(this instanceof g))) {
          break label1546;
        }
        bool3 = true;
        label897:
        bool1 = true;
        if (this.Cw.isConnected()) {
          bool1 = false;
        }
        if (this.BV != 2)
        {
          if (this.CA == null) {
            break label1552;
          }
          localh1 = parame.s(this.CA.Cr);
          label941:
          if (this.CA == null) {
            break label1558;
          }
        }
      }
      label1042:
      label1558:
      for (androidx.constraintlayout.a.h localh2 = parame.s(this.CA.Cp);; localh2 = null)
      {
        a(parame, bool7, localh2, localh1, this.Cz[0], bool3, this.Cp, this.Cr, this.CD, n, this.lj, this.Cn[0], this.CT, bool2, bool8, i, this.Cc, this.Cd, this.Ce, bool1);
        if (this.BW != 2) {
          break label1564;
        }
        AppMethodBeat.o(229460);
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
        if (((this.Cp.Bv != null) && (this.Cp.Bv.Bv == this.Cp)) || ((this.Cr.Bv != null) && (this.Cr.Bv.Bv == this.Cr)))
        {
          bool3 = true;
          break label148;
        }
        bool3 = false;
        break label148;
        label1132:
        if (((this.Cq.Bv != null) && (this.Cq.Bv.Bv == this.Cq)) || ((this.Cs.Bv != null) && (this.Cs.Bv.Bv == this.Cs)))
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
        this.Ck = 1;
        if (this.CC != -1) {
          break label638;
        }
        this.Cl = (1.0F / this.Cl);
        break label638;
        label1246:
        if ((this.Ck != 1) || ((this.Cp.isConnected()) && (this.Cr.isConnected()))) {
          break label670;
        }
        this.Ck = 0;
        break label670;
        if ((!this.Cp.isConnected()) || (!this.Cr.isConnected())) {
          break label743;
        }
        this.Cl = (1.0F / this.Cl);
        this.Ck = 1;
        break label743;
        label1320:
        if ((bool7) || (!bool6)) {
          break label766;
        }
        this.Cl = (1.0F / this.Cl);
        this.Ck = 1;
        break label766;
        label1348:
        if ((this.Cc != 0) || (this.Cf <= 0)) {
          break label793;
        }
        this.Cl = (1.0F / this.Cl);
        this.Ck = 1;
        break label793;
        label1380:
        if ((this.Cz[0] == a.Dq) && (i == 3))
        {
          this.Ck = 0;
          n = (int)(this.Cl * this.mHeight);
          if (this.Cz[1] == a.Dq) {
            break label2150;
          }
          i = 4;
          k = 0;
          break label837;
        }
        i1 = i;
        i2 = j;
        n = i6;
        if (this.Cz[1] != a.Dq) {
          break label2128;
        }
        i1 = i;
        i2 = j;
        n = i6;
        if (j != 3) {
          break label2128;
        }
        this.Ck = 1;
        if (this.CC == -1) {
          this.Cl = (1.0F / this.Cl);
        }
        m = (int)(this.Cl * this.mWidth);
        if (this.Cz[0] == a.Dq) {
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
      if ((this.Cz[1] == a.Dp) && ((this instanceof g)))
      {
        bool2 = true;
        if ((k == 0) || ((this.Ck != 1) && (this.Ck != -1))) {
          break label2021;
        }
        bool3 = true;
        label1610:
        bool4 = bool1;
        if (this.CN > 0)
        {
          if (this.Ct.Bs.state != 1) {
            break label2027;
          }
          this.Ct.Bs.c(parame);
          bool4 = bool1;
        }
        label1650:
        if (this.CA == null) {
          break label2083;
        }
        localh1 = parame.s(this.CA.Cs);
        if (this.CA == null) {
          break label2089;
        }
        localh2 = parame.s(this.CA.Cq);
        a(parame, bool6, localh2, localh1, this.Cz[1], bool2, this.Cq, this.Cs, this.CE, m, this.CO, this.Cn[1], this.CU, bool3, bool5, j, this.Cf, this.Cg, this.Ch, bool4);
        if (k != 0)
        {
          if (this.Ck != 1) {
            break label2095;
          }
          parame.c(localh5, (androidx.constraintlayout.a.h)localObject1, localh4, localh3, this.Cl);
        }
      }
      for (;;)
      {
        label1670:
        label1690:
        if (this.Cw.isConnected())
        {
          Object localObject2 = this.Cw.Bv.Bt;
          float f = (float)Math.toRadians(this.Co + 90.0F);
          i = this.Cw.fv();
          localh1 = parame.s(a(e.c.BM));
          localObject1 = parame.s(a(e.c.BN));
          localh2 = parame.s(a(e.c.BO));
          localh5 = parame.s(a(e.c.BP));
          localh3 = parame.s(((f)localObject2).a(e.c.BM));
          localh6 = parame.s(((f)localObject2).a(e.c.BN));
          localh4 = parame.s(((f)localObject2).a(e.c.BO));
          localObject2 = parame.s(((f)localObject2).a(e.c.BP));
          androidx.constraintlayout.a.b localb = parame.fm();
          localb.b((androidx.constraintlayout.a.h)localObject1, localh5, localh6, (androidx.constraintlayout.a.h)localObject2, (float)(Math.sin(f) * i));
          parame.b(localb);
          localObject1 = parame.fm();
          ((androidx.constraintlayout.a.b)localObject1).b(localh1, localh2, localh3, localh4, (float)(Math.cos(f) * i));
          parame.b((androidx.constraintlayout.a.b)localObject1);
        }
        AppMethodBeat.o(229460);
        return;
        bool2 = false;
        break;
        label2021:
        bool3 = false;
        break label1610;
        label2027:
        parame.c(localh6, (androidx.constraintlayout.a.h)localObject1, this.CN, 6);
        bool4 = bool1;
        if (this.Ct.Bv == null) {
          break label1650;
        }
        parame.c(localh6, parame.s(this.Ct.Bv), 0, 6);
        bool4 = false;
        break label1650;
        label2083:
        localh1 = null;
        break label1670;
        label2089:
        localh2 = null;
        break label1690;
        label2095:
        parame.c(localh4, localh3, localh5, (androidx.constraintlayout.a.h)localObject1, this.Cl);
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
  
  public void aU(int paramInt)
  {
    AppMethodBeat.i(229316);
    k.a(paramInt, this);
    AppMethodBeat.o(229316);
  }
  
  public final int aV(int paramInt)
  {
    AppMethodBeat.i(229365);
    if (paramInt == 0)
    {
      paramInt = getWidth();
      AppMethodBeat.o(229365);
      return paramInt;
    }
    if (paramInt == 1)
    {
      paramInt = getHeight();
      AppMethodBeat.o(229365);
      return paramInt;
    }
    AppMethodBeat.o(229365);
    return 0;
  }
  
  public final a aW(int paramInt)
  {
    if (paramInt == 0) {
      return this.Cz[0];
    }
    if (paramInt == 1) {
      return this.Cz[1];
    }
    return null;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(229439);
    this.Cz[1] = parama;
    if (parama == a.Dp) {
      setHeight(this.CR);
    }
    AppMethodBeat.o(229439);
  }
  
  public final void b(androidx.constraintlayout.a.e parame)
  {
    AppMethodBeat.i(229353);
    parame.s(this.Cp);
    parame.s(this.Cq);
    parame.s(this.Cr);
    parame.s(this.Cs);
    if (this.CN > 0) {
      parame.s(this.Ct);
    }
    AppMethodBeat.o(229353);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229410);
    if (paramInt3 == 0) {
      w(paramInt1, paramInt2);
    }
    for (;;)
    {
      this.Dc = true;
      AppMethodBeat.o(229410);
      return;
      if (paramInt3 == 1) {
        x(paramInt1, paramInt2);
      }
    }
  }
  
  public final n fA()
  {
    AppMethodBeat.i(229323);
    if (this.BX == null) {
      this.BX = new n();
    }
    n localn = this.BX;
    AppMethodBeat.o(229323);
    return localn;
  }
  
  public final n fB()
  {
    AppMethodBeat.i(229324);
    if (this.BY == null) {
      this.BY = new n();
    }
    n localn = this.BY;
    AppMethodBeat.o(229324);
    return localn;
  }
  
  public final int fC()
  {
    return this.CH + this.CL;
  }
  
  public final int fD()
  {
    return this.CI + this.CM;
  }
  
  protected final int fE()
  {
    return this.CD + this.CL;
  }
  
  protected final int fF()
  {
    return this.CE + this.CM;
  }
  
  public final int fG()
  {
    return this.CD + this.mWidth;
  }
  
  public final int fH()
  {
    return this.CE + this.mHeight;
  }
  
  public final boolean fI()
  {
    return this.CN > 0;
  }
  
  public ArrayList<e> fJ()
  {
    return this.Cy;
  }
  
  public void fK()
  {
    int i = this.CD;
    int j = this.CE;
    int k = this.CD;
    int m = this.mWidth;
    int n = this.CE;
    int i1 = this.mHeight;
    this.CH = i;
    this.CI = j;
    this.CJ = (k + m - i);
    this.CK = (n + i1 - j);
  }
  
  public final void fL()
  {
    AppMethodBeat.i(229432);
    int j = this.Cy.size();
    int i = 0;
    while (i < j)
    {
      ((e)this.Cy.get(i)).reset();
      i += 1;
    }
    AppMethodBeat.o(229432);
  }
  
  public final a fM()
  {
    return this.Cz[0];
  }
  
  public final a fN()
  {
    return this.Cz[1];
  }
  
  public void fO()
  {
    AppMethodBeat.i(229471);
    int j = androidx.constraintlayout.a.e.t(this.Cp);
    int i = androidx.constraintlayout.a.e.t(this.Cq);
    int m = androidx.constraintlayout.a.e.t(this.Cr);
    int n = androidx.constraintlayout.a.e.t(this.Cs);
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
    this.CD = j;
    this.CE = i;
    if (this.CX == 8)
    {
      this.mWidth = 0;
      this.mHeight = 0;
      AppMethodBeat.o(229471);
      return;
    }
    if ((this.Cz[0] == a.Do) && (m < this.mWidth)) {}
    for (i = this.mWidth;; i = m)
    {
      if ((this.Cz[1] == a.Do) && (k < this.mHeight)) {}
      for (j = this.mHeight;; j = k)
      {
        this.mWidth = i;
        this.mHeight = j;
        if (this.mHeight < this.CO) {
          this.mHeight = this.CO;
        }
        if (this.mWidth < this.lj) {
          this.mWidth = this.lj;
        }
        this.Dc = true;
        AppMethodBeat.o(229471);
        return;
      }
    }
  }
  
  public boolean fq()
  {
    return this.CX != 8;
  }
  
  public void fr()
  {
    AppMethodBeat.i(229304);
    int i = 0;
    while (i < 6)
    {
      this.Cx[i].Bs.reset();
      i += 1;
    }
    AppMethodBeat.o(229304);
  }
  
  public void fs() {}
  
  public final boolean fw()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.BZ == 0)
    {
      bool1 = bool2;
      if (this.CB == 0.0F)
      {
        bool1 = bool2;
        if (this.Cc == 0)
        {
          bool1 = bool2;
          if (this.Cd == 0)
          {
            bool1 = bool2;
            if (this.Cz[0] == a.Dq) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public final boolean fx()
  {
    return (this.Ca == 0) && (this.CB == 0.0F) && (this.Cf == 0) && (this.Cg == 0) && (this.Cz[1] == a.Dq);
  }
  
  public final void fy()
  {
    AppMethodBeat.i(229314);
    int i = 0;
    while (i < 6)
    {
      m localm = this.Cx[i].Bs;
      e locale = localm.Ei.Bv;
      if (locale != null)
      {
        if (locale.Bv == localm.Ei)
        {
          localm.type = 4;
          locale.Bs.type = 4;
        }
        int k = localm.Ei.fv();
        int j;
        if (localm.Ei.Bu != e.c.BO)
        {
          j = k;
          if (localm.Ei.Bu != e.c.BP) {}
        }
        else
        {
          j = -k;
        }
        localm.b(locale.Bs, j);
      }
      i += 1;
    }
    AppMethodBeat.o(229314);
  }
  
  public final boolean fz()
  {
    return (this.Cp.Bs.state == 1) && (this.Cr.Bs.state == 1) && (this.Cq.Bs.state == 1) && (this.Cs.Bs.state == 1);
  }
  
  public final int getHeight()
  {
    if (this.CX == 8) {
      return 0;
    }
    return this.mHeight;
  }
  
  public final int getWidth()
  {
    if (this.CX == 8) {
      return 0;
    }
    return this.mWidth;
  }
  
  public final int getX()
  {
    return this.CD;
  }
  
  public final int getY()
  {
    return this.CE;
  }
  
  public void reset()
  {
    AppMethodBeat.i(229302);
    this.Cp.reset();
    this.Cq.reset();
    this.Cr.reset();
    this.Cs.reset();
    this.Ct.reset();
    this.Cu.reset();
    this.Cv.reset();
    this.Cw.reset();
    this.CA = null;
    this.Co = 0.0F;
    this.mWidth = 0;
    this.mHeight = 0;
    this.CB = 0.0F;
    this.CC = -1;
    this.CD = 0;
    this.CE = 0;
    this.CH = 0;
    this.CI = 0;
    this.CJ = 0;
    this.CK = 0;
    this.CL = 0;
    this.CM = 0;
    this.CN = 0;
    this.lj = 0;
    this.CO = 0;
    this.CQ = 0;
    this.CR = 0;
    this.CT = CS;
    this.CU = CS;
    this.Cz[0] = a.Do;
    this.Cz[1] = a.Do;
    this.CV = null;
    this.CW = 0;
    this.CX = 0;
    this.mType = null;
    this.CZ = false;
    this.Da = false;
    this.De = 0;
    this.Df = 0;
    this.Dg = false;
    this.Dh = false;
    this.Di[0] = -1.0F;
    this.Di[1] = -1.0F;
    this.BV = -1;
    this.BW = -1;
    this.Cn[0] = 2147483647;
    this.Cn[1] = 2147483647;
    this.BZ = 0;
    this.Ca = 0;
    this.Ce = 1.0F;
    this.Ch = 1.0F;
    this.Cd = 2147483647;
    this.Cg = 2147483647;
    this.Cc = 0;
    this.Cf = 0;
    this.Ck = -1;
    this.Cl = 1.0F;
    if (this.BX != null) {
      this.BX.reset();
    }
    if (this.BY != null) {
      this.BY.reset();
    }
    this.Cm = null;
    this.Db = false;
    this.Dc = false;
    this.Dd = false;
    AppMethodBeat.o(229302);
  }
  
  public final void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
    if (this.mHeight < this.CO) {
      this.mHeight = this.CO;
    }
  }
  
  public final void setMinHeight(int paramInt)
  {
    if (paramInt < 0)
    {
      this.CO = 0;
      return;
    }
    this.CO = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    if (paramInt < 0)
    {
      this.lj = 0;
      return;
    }
    this.lj = paramInt;
  }
  
  public final void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
    if (this.mWidth < this.lj) {
      this.mWidth = this.lj;
    }
  }
  
  public final void setX(int paramInt)
  {
    this.CD = paramInt;
  }
  
  public final void setY(int paramInt)
  {
    this.CE = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(229356);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.mType != null)
    {
      str = "type: " + this.mType + " ";
      localStringBuilder = localStringBuilder.append(str);
      if (this.CY == null) {
        break label196;
      }
    }
    label196:
    for (String str = "id: " + this.CY + " ";; str = "")
    {
      str = str + "(" + this.CD + ", " + this.CE + ") - (" + this.mWidth + " x " + this.mHeight + ") wrap: (" + this.CQ + " x " + this.CR + ")";
      AppMethodBeat.o(229356);
      return str;
      str = "";
      break;
    }
  }
  
  public final void u(int paramInt1, int paramInt2)
  {
    this.CD = paramInt1;
    this.CE = paramInt2;
  }
  
  public void v(int paramInt1, int paramInt2)
  {
    this.CL = paramInt1;
    this.CM = paramInt2;
  }
  
  public final void w(int paramInt1, int paramInt2)
  {
    this.CD = paramInt1;
    this.mWidth = (paramInt2 - paramInt1);
    if (this.mWidth < this.lj) {
      this.mWidth = this.lj;
    }
  }
  
  public final void x(int paramInt1, int paramInt2)
  {
    this.CE = paramInt1;
    this.mHeight = (paramInt2 - paramInt1);
    if (this.mHeight < this.CO) {
      this.mHeight = this.CO;
    }
  }
  
  public final void x(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(229408);
    if ((paramString == null) || (paramString.length() == 0))
    {
      this.CB = 0.0F;
      AppMethodBeat.o(229408);
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
              this.CB = f1;
              this.CC = j;
            }
            AppMethodBeat.o(229408);
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
  
  final void y(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      this.CF = paramInt1;
    }
    while (paramInt2 != 1) {
      return;
    }
    this.CG = paramInt1;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(229783);
      Do = new a("FIXED", 0);
      Dp = new a("WRAP_CONTENT", 1);
      Dq = new a("MATCH_CONSTRAINT", 2);
      Dr = new a("MATCH_PARENT", 3);
      Ds = new a[] { Do, Dp, Dq, Dr };
      AppMethodBeat.o(229783);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.a.a.f
 * JD-Core Version:    0.7.0.1
 */