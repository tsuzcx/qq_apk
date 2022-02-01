package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.k;
import com.google.android.exoplayer2.i.k.a;
import com.google.android.exoplayer2.i.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class j
  implements h
{
  private boolean cLK;
  private com.google.android.exoplayer2.c.m cMa;
  private String cTX;
  private final n cUA;
  private final n cUB;
  private a cUC;
  private final com.google.android.exoplayer2.i.m cUD;
  private final boolean[] cUl;
  private long cUn;
  private long cUp;
  private final s cUw;
  private final boolean cUx;
  private final boolean cUy;
  private final n cUz;
  
  public j(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92244);
    this.cUw = params;
    this.cUx = paramBoolean1;
    this.cUy = paramBoolean2;
    this.cUl = new boolean[3];
    this.cUz = new n(7);
    this.cUA = new n(8);
    this.cUB = new n(6);
    this.cUD = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92244);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92248);
    if ((!this.cLK) || (this.cUC.cUy))
    {
      this.cUz.f(paramArrayOfByte, paramInt1, paramInt2);
      this.cUA.f(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.cUB.f(paramArrayOfByte, paramInt1, paramInt2);
    this.cUC.f(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(92248);
  }
  
  public final void Si()
  {
    AppMethodBeat.i(92245);
    k.c(this.cUl);
    this.cUz.reset();
    this.cUA.reset();
    this.cUB.reset();
    this.cUC.reset();
    this.cUn = 0L;
    AppMethodBeat.o(92245);
  }
  
  public final void Sj() {}
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92246);
    paramd.Sv();
    this.cTX = paramd.Sw();
    this.cMa = paramg.hz(paramd.getTrackId());
    this.cUC = new a(this.cMa, this.cUx, this.cUy);
    this.cUw.a(paramg, paramd);
    AppMethodBeat.o(92246);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    this.cUp = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92247);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte = paramm.data;
    this.cUn += paramm.UF();
    this.cMa.a(paramm, paramm.UF());
    int k = k.a(arrayOfByte, i, j, this.cUl);
    if (k == j)
    {
      e(arrayOfByte, i, j);
      AppMethodBeat.o(92247);
      return;
    }
    int m = k.k(arrayOfByte, k);
    int i1 = k - i;
    if (i1 > 0) {
      e(arrayOfByte, i, k);
    }
    int n = j - k;
    long l1 = this.cUn - n;
    label136:
    long l2;
    Object localObject1;
    label370:
    int i3;
    if (i1 < 0)
    {
      i = -i1;
      l2 = this.cUp;
      Object localObject2;
      if ((!this.cLK) || (this.cUC.cUy))
      {
        this.cUz.hX(i);
        this.cUA.hX(i);
        if (this.cLK) {
          break label1060;
        }
        if ((this.cUz.cVt) && (this.cUA.cVt))
        {
          paramm = new ArrayList();
          paramm.add(Arrays.copyOf(this.cUz.nalData, this.cUz.cVu));
          paramm.add(Arrays.copyOf(this.cUA.nalData, this.cUA.cVu));
          localObject1 = k.k(this.cUz.nalData, 3, this.cUz.cVu);
          localObject2 = k.m(this.cUA.nalData, this.cUA.cVu);
          this.cMa.f(Format.a(this.cTX, "video/avc", ((k.b)localObject1).width, ((k.b)localObject1).height, paramm, ((k.b)localObject1).dky));
          this.cLK = true;
          this.cUC.a((k.b)localObject1);
          this.cUC.a((k.a)localObject2);
          this.cUz.reset();
          this.cUA.reset();
        }
      }
      if (this.cUB.hX(i))
      {
        i = k.j(this.cUB.nalData, this.cUB.cVu);
        this.cUD.n(this.cUB.nalData, i);
        this.cUD.setPosition(4);
        this.cUw.a(l2, this.cUD);
      }
      paramm = this.cUC;
      if (paramm.cUI != 9)
      {
        if (paramm.cUy)
        {
          localObject1 = paramm.cUM;
          localObject2 = paramm.cUL;
          if ((!((j.a.a)localObject1).cUO) || ((((j.a.a)localObject2).cUO) && (((j.a.a)localObject1).frameNum == ((j.a.a)localObject2).frameNum) && (((j.a.a)localObject1).cUT == ((j.a.a)localObject2).cUT) && (((j.a.a)localObject1).cUU == ((j.a.a)localObject2).cUU) && ((!((j.a.a)localObject1).cUV) || (!((j.a.a)localObject2).cUV) || (((j.a.a)localObject1).cUW == ((j.a.a)localObject2).cUW)) && ((((j.a.a)localObject1).cUR == ((j.a.a)localObject2).cUR) || ((((j.a.a)localObject1).cUR != 0) && (((j.a.a)localObject2).cUR != 0))) && ((((j.a.a)localObject1).cUQ.dkC != 0) || (((j.a.a)localObject2).cUQ.dkC != 0) || ((((j.a.a)localObject1).cUZ == ((j.a.a)localObject2).cUZ) && (((j.a.a)localObject1).cVa == ((j.a.a)localObject2).cVa))) && ((((j.a.a)localObject1).cUQ.dkC != 1) || (((j.a.a)localObject2).cUQ.dkC != 1) || ((((j.a.a)localObject1).cVb == ((j.a.a)localObject2).cVb) && (((j.a.a)localObject1).cVc == ((j.a.a)localObject2).cVc))) && (((j.a.a)localObject1).cUX == ((j.a.a)localObject2).cUX) && ((!((j.a.a)localObject1).cUX) || (!((j.a.a)localObject2).cUX) || (((j.a.a)localObject1).cUY == ((j.a.a)localObject2).cUY)))) {
            break label1153;
          }
          i = 1;
          label723:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramm.cUN)
        {
          i1 = (int)(l1 - paramm.cUJ);
          if (!paramm.cUr) {
            break label1158;
          }
          i = 1;
          label753:
          int i2 = (int)(paramm.cUJ - paramm.cUq);
          paramm.cMa.a(paramm.cUj, i, i2, n + i1, null);
        }
        paramm.cUq = paramm.cUJ;
        paramm.cUj = paramm.cUK;
        paramm.cUr = false;
        paramm.cUN = true;
      }
      i3 = paramm.cUr;
      if (paramm.cUI != 5)
      {
        if ((!paramm.cUx) || (paramm.cUI != 1)) {
          break label1168;
        }
        localObject1 = paramm.cUM;
        if ((!((j.a.a)localObject1).cUP) || ((((j.a.a)localObject1).cUS != 7) && (((j.a.a)localObject1).cUS != 2))) {
          break label1163;
        }
        i = 1;
        label877:
        if (i == 0) {
          break label1168;
        }
      }
    }
    label1153:
    label1158:
    label1163:
    label1168:
    for (i = 1;; i = 0)
    {
      paramm.cUr = (i | i3);
      l2 = this.cUp;
      if ((!this.cLK) || (this.cUC.cUy))
      {
        this.cUz.hW(m);
        this.cUA.hW(m);
      }
      this.cUB.hW(m);
      paramm = this.cUC;
      paramm.cUI = m;
      paramm.cUK = l2;
      paramm.cUJ = l1;
      if (((paramm.cUx) && (paramm.cUI == 1)) || ((paramm.cUy) && ((paramm.cUI == 5) || (paramm.cUI == 1) || (paramm.cUI == 2))))
      {
        localObject1 = paramm.cUL;
        paramm.cUL = paramm.cUM;
        paramm.cUM = ((j.a.a)localObject1);
        paramm.cUM.clear();
        paramm.cUH = 0;
        paramm.cUu = true;
      }
      i = k + 3;
      break;
      i = 0;
      break label136;
      label1060:
      if (this.cUz.cVt)
      {
        paramm = k.k(this.cUz.nalData, 3, this.cUz.cVu);
        this.cUC.a(paramm);
        this.cUz.reset();
        break label370;
      }
      if (!this.cUA.cVt) {
        break label370;
      }
      paramm = k.m(this.cUA.nalData, this.cUA.cVu);
      this.cUC.a(paramm);
      this.cUA.reset();
      break label370;
      i = 0;
      break label723;
      i = 0;
      break label753;
      i = 0;
      break label877;
    }
  }
  
  static final class a
  {
    private byte[] buffer;
    final com.google.android.exoplayer2.c.m cMa;
    private final SparseArray<k.b> cUE;
    private final SparseArray<k.a> cUF;
    private final com.google.android.exoplayer2.i.n cUG;
    int cUH;
    int cUI;
    long cUJ;
    long cUK;
    a cUL;
    a cUM;
    boolean cUN;
    long cUj;
    long cUq;
    boolean cUr;
    boolean cUu;
    final boolean cUx;
    final boolean cUy;
    
    public a(com.google.android.exoplayer2.c.m paramm, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92239);
      this.cMa = paramm;
      this.cUx = paramBoolean1;
      this.cUy = paramBoolean2;
      this.cUE = new SparseArray();
      this.cUF = new SparseArray();
      this.cUL = new a((byte)0);
      this.cUM = new a((byte)0);
      this.buffer = new byte[''];
      this.cUG = new com.google.android.exoplayer2.i.n(this.buffer, 0, 0);
      reset();
      AppMethodBeat.o(92239);
    }
    
    public final void a(k.a parama)
    {
      AppMethodBeat.i(92241);
      this.cUF.append(parama.cUT, parama);
      AppMethodBeat.o(92241);
    }
    
    public final void a(k.b paramb)
    {
      AppMethodBeat.i(92240);
      this.cUE.append(paramb.dkw, paramb);
      AppMethodBeat.o(92240);
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92243);
      if (!this.cUu)
      {
        AppMethodBeat.o(92243);
        return;
      }
      paramInt2 -= paramInt1;
      if (this.buffer.length < this.cUH + paramInt2) {
        this.buffer = Arrays.copyOf(this.buffer, (this.cUH + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.cUH, paramInt2);
      this.cUH = (paramInt2 + this.cUH);
      this.cUG.l(this.buffer, 0, this.cUH);
      if (!this.cUG.iJ(8))
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.cUG.UD();
      int i3 = this.cUG.hQ(2);
      this.cUG.hR(5);
      if (!this.cUG.UR())
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.cUG.UT();
      if (!this.cUG.UR())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i4 = this.cUG.UT();
      if (!this.cUy)
      {
        this.cUu = false;
        this.cUM.hU(i4);
        AppMethodBeat.o(92243);
        return;
      }
      if (!this.cUG.UR())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i5 = this.cUG.UT();
      if (this.cUF.indexOfKey(i5) < 0)
      {
        this.cUu = false;
        AppMethodBeat.o(92243);
        return;
      }
      paramArrayOfByte = (k.a)this.cUF.get(i5);
      k.b localb = (k.b)this.cUE.get(paramArrayOfByte.dkw);
      if (localb.dkz)
      {
        if (!this.cUG.iJ(2))
        {
          AppMethodBeat.o(92243);
          return;
        }
        this.cUG.hR(2);
      }
      if (!this.cUG.iJ(localb.dkB))
      {
        AppMethodBeat.o(92243);
        return;
      }
      boolean bool2 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      int i6 = this.cUG.hQ(localb.dkB);
      boolean bool3 = bool5;
      boolean bool1 = bool6;
      if (!localb.dkA)
      {
        if (!this.cUG.iJ(1))
        {
          AppMethodBeat.o(92243);
          return;
        }
        bool4 = this.cUG.Sg();
        bool2 = bool4;
        bool3 = bool5;
        bool1 = bool6;
        if (bool4)
        {
          if (!this.cUG.iJ(1))
          {
            AppMethodBeat.o(92243);
            return;
          }
          bool1 = this.cUG.Sg();
          bool3 = true;
          bool2 = bool4;
        }
      }
      if (this.cUI == 5) {}
      for (boolean bool4 = true;; bool4 = false)
      {
        paramInt1 = 0;
        if (!bool4) {
          break label508;
        }
        if (this.cUG.UR()) {
          break;
        }
        AppMethodBeat.o(92243);
        return;
      }
      paramInt1 = this.cUG.UT();
      label508:
      int i1 = 0;
      int m = 0;
      int i2 = 0;
      int n = 0;
      int i;
      int j;
      int k;
      if (localb.dkC == 0)
      {
        if (!this.cUG.iJ(localb.dkD))
        {
          AppMethodBeat.o(92243);
          return;
        }
        i1 = this.cUG.hQ(localb.dkD);
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (paramArrayOfByte.dkx)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!bool2)
          {
            if (!this.cUG.UR())
            {
              AppMethodBeat.o(92243);
              return;
            }
            j = this.cUG.US();
            k = n;
            paramInt2 = i2;
            i = i1;
          }
        }
      }
      for (;;)
      {
        this.cUM.a(localb, i3, i4, i6, i5, bool2, bool3, bool1, bool4, paramInt1, i, j, paramInt2, k);
        this.cUu = false;
        AppMethodBeat.o(92243);
        return;
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (localb.dkC == 1)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!localb.dkE)
          {
            if (!this.cUG.UR())
            {
              AppMethodBeat.o(92243);
              return;
            }
            i2 = this.cUG.US();
            i = i1;
            j = m;
            paramInt2 = i2;
            k = n;
            if (paramArrayOfByte.dkx)
            {
              i = i1;
              j = m;
              paramInt2 = i2;
              k = n;
              if (!bool2)
              {
                if (!this.cUG.UR())
                {
                  AppMethodBeat.o(92243);
                  return;
                }
                k = this.cUG.US();
                i = i1;
                j = m;
                paramInt2 = i2;
              }
            }
          }
        }
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92242);
      this.cUu = false;
      this.cUN = false;
      this.cUM.clear();
      AppMethodBeat.o(92242);
    }
    
    static final class a
    {
      boolean cUO;
      boolean cUP;
      k.b cUQ;
      int cUR;
      int cUS;
      int cUT;
      boolean cUU;
      boolean cUV;
      boolean cUW;
      boolean cUX;
      int cUY;
      int cUZ;
      int cVa;
      int cVb;
      int cVc;
      int frameNum;
      
      public final void a(k.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
      {
        this.cUQ = paramb;
        this.cUR = paramInt1;
        this.cUS = paramInt2;
        this.frameNum = paramInt3;
        this.cUT = paramInt4;
        this.cUU = paramBoolean1;
        this.cUV = paramBoolean2;
        this.cUW = paramBoolean3;
        this.cUX = paramBoolean4;
        this.cUY = paramInt5;
        this.cUZ = paramInt6;
        this.cVa = paramInt7;
        this.cVb = paramInt8;
        this.cVc = paramInt9;
        this.cUO = true;
        this.cUP = true;
      }
      
      public final void clear()
      {
        this.cUP = false;
        this.cUO = false;
      }
      
      public final void hU(int paramInt)
      {
        this.cUS = paramInt;
        this.cUP = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.j
 * JD-Core Version:    0.7.0.1
 */