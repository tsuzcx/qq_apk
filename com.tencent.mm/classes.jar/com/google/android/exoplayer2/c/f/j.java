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
  private boolean aRO;
  private com.google.android.exoplayer2.c.m aSe;
  private final s baB;
  private final boolean baC;
  private final boolean baD;
  private final n baE;
  private final n baF;
  private final n baG;
  private a baH;
  private final com.google.android.exoplayer2.i.m baI;
  private String bac;
  private final boolean[] baq;
  private long bas;
  private long bau;
  
  public j(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92244);
    this.baB = params;
    this.baC = paramBoolean1;
    this.baD = paramBoolean2;
    this.baq = new boolean[3];
    this.baE = new n(7);
    this.baF = new n(8);
    this.baG = new n(6);
    this.baI = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92244);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92248);
    if ((!this.aRO) || (this.baH.baD))
    {
      this.baE.f(paramArrayOfByte, paramInt1, paramInt2);
      this.baF.f(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.baG.f(paramArrayOfByte, paramInt1, paramInt2);
    this.baH.f(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(92248);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92246);
    paramd.sR();
    this.bac = paramd.sS();
    this.aSe = paramg.ej(paramd.getTrackId());
    this.baH = new a(this.aSe, this.baC, this.baD);
    this.baB.a(paramg, paramd);
    AppMethodBeat.o(92246);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bau = paramLong;
  }
  
  public final void sF()
  {
    AppMethodBeat.i(92245);
    k.b(this.baq);
    this.baE.reset();
    this.baF.reset();
    this.baG.reset();
    this.baH.reset();
    this.bas = 0L;
    AppMethodBeat.o(92245);
  }
  
  public final void sG() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92247);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte = paramm.data;
    this.bas += paramm.vg();
    this.aSe.a(paramm, paramm.vg());
    int k = k.a(arrayOfByte, i, j, this.baq);
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
    long l1 = this.bas - n;
    label136:
    long l2;
    Object localObject1;
    label370:
    int i3;
    if (i1 < 0)
    {
      i = -i1;
      l2 = this.bau;
      Object localObject2;
      if ((!this.aRO) || (this.baH.baD))
      {
        this.baE.eH(i);
        this.baF.eH(i);
        if (this.aRO) {
          break label1060;
        }
        if ((this.baE.bby) && (this.baF.bby))
        {
          paramm = new ArrayList();
          paramm.add(Arrays.copyOf(this.baE.nalData, this.baE.bbz));
          paramm.add(Arrays.copyOf(this.baF.nalData, this.baF.bbz));
          localObject1 = k.k(this.baE.nalData, 3, this.baE.bbz);
          localObject2 = k.m(this.baF.nalData, this.baF.bbz);
          this.aSe.f(Format.a(this.bac, "video/avc", ((k.b)localObject1).width, ((k.b)localObject1).height, paramm, ((k.b)localObject1).bqU));
          this.aRO = true;
          this.baH.a((k.b)localObject1);
          this.baH.a((k.a)localObject2);
          this.baE.reset();
          this.baF.reset();
        }
      }
      if (this.baG.eH(i))
      {
        i = k.j(this.baG.nalData, this.baG.bbz);
        this.baI.n(this.baG.nalData, i);
        this.baI.setPosition(4);
        this.baB.a(l2, this.baI);
      }
      paramm = this.baH;
      if (paramm.baN != 9)
      {
        if (paramm.baD)
        {
          localObject1 = paramm.baR;
          localObject2 = paramm.baQ;
          if ((!((j.a.a)localObject1).baT) || ((((j.a.a)localObject2).baT) && (((j.a.a)localObject1).frameNum == ((j.a.a)localObject2).frameNum) && (((j.a.a)localObject1).baY == ((j.a.a)localObject2).baY) && (((j.a.a)localObject1).baZ == ((j.a.a)localObject2).baZ) && ((!((j.a.a)localObject1).bba) || (!((j.a.a)localObject2).bba) || (((j.a.a)localObject1).bbb == ((j.a.a)localObject2).bbb)) && ((((j.a.a)localObject1).baW == ((j.a.a)localObject2).baW) || ((((j.a.a)localObject1).baW != 0) && (((j.a.a)localObject2).baW != 0))) && ((((j.a.a)localObject1).baV.bqY != 0) || (((j.a.a)localObject2).baV.bqY != 0) || ((((j.a.a)localObject1).bbe == ((j.a.a)localObject2).bbe) && (((j.a.a)localObject1).bbf == ((j.a.a)localObject2).bbf))) && ((((j.a.a)localObject1).baV.bqY != 1) || (((j.a.a)localObject2).baV.bqY != 1) || ((((j.a.a)localObject1).bbg == ((j.a.a)localObject2).bbg) && (((j.a.a)localObject1).bbh == ((j.a.a)localObject2).bbh))) && (((j.a.a)localObject1).bbc == ((j.a.a)localObject2).bbc) && ((!((j.a.a)localObject1).bbc) || (!((j.a.a)localObject2).bbc) || (((j.a.a)localObject1).bbd == ((j.a.a)localObject2).bbd)))) {
            break label1153;
          }
          i = 1;
          label723:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramm.baS)
        {
          i1 = (int)(l1 - paramm.baO);
          if (!paramm.baw) {
            break label1158;
          }
          i = 1;
          label753:
          int i2 = (int)(paramm.baO - paramm.bav);
          paramm.aSe.a(paramm.bao, i, i2, n + i1, null);
        }
        paramm.bav = paramm.baO;
        paramm.bao = paramm.baP;
        paramm.baw = false;
        paramm.baS = true;
      }
      i3 = paramm.baw;
      if (paramm.baN != 5)
      {
        if ((!paramm.baC) || (paramm.baN != 1)) {
          break label1168;
        }
        localObject1 = paramm.baR;
        if ((!((j.a.a)localObject1).baU) || ((((j.a.a)localObject1).baX != 7) && (((j.a.a)localObject1).baX != 2))) {
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
      paramm.baw = (i | i3);
      l2 = this.bau;
      if ((!this.aRO) || (this.baH.baD))
      {
        this.baE.eG(m);
        this.baF.eG(m);
      }
      this.baG.eG(m);
      paramm = this.baH;
      paramm.baN = m;
      paramm.baP = l2;
      paramm.baO = l1;
      if (((paramm.baC) && (paramm.baN == 1)) || ((paramm.baD) && ((paramm.baN == 5) || (paramm.baN == 1) || (paramm.baN == 2))))
      {
        localObject1 = paramm.baQ;
        paramm.baQ = paramm.baR;
        paramm.baR = ((j.a.a)localObject1);
        paramm.baR.clear();
        paramm.baM = 0;
        paramm.baz = true;
      }
      i = k + 3;
      break;
      i = 0;
      break label136;
      label1060:
      if (this.baE.bby)
      {
        paramm = k.k(this.baE.nalData, 3, this.baE.bbz);
        this.baH.a(paramm);
        this.baE.reset();
        break label370;
      }
      if (!this.baF.bby) {
        break label370;
      }
      paramm = k.m(this.baF.nalData, this.baF.bbz);
      this.baH.a(paramm);
      this.baF.reset();
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
    final com.google.android.exoplayer2.c.m aSe;
    final boolean baC;
    final boolean baD;
    private final SparseArray<k.b> baJ;
    private final SparseArray<k.a> baK;
    private final com.google.android.exoplayer2.i.n baL;
    int baM;
    int baN;
    long baO;
    long baP;
    a baQ;
    a baR;
    boolean baS;
    long bao;
    long bav;
    boolean baw;
    boolean baz;
    private byte[] buffer;
    
    public a(com.google.android.exoplayer2.c.m paramm, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92239);
      this.aSe = paramm;
      this.baC = paramBoolean1;
      this.baD = paramBoolean2;
      this.baJ = new SparseArray();
      this.baK = new SparseArray();
      this.baQ = new a((byte)0);
      this.baR = new a((byte)0);
      this.buffer = new byte[''];
      this.baL = new com.google.android.exoplayer2.i.n(this.buffer, 0, 0);
      reset();
      AppMethodBeat.o(92239);
    }
    
    public final void a(k.a parama)
    {
      AppMethodBeat.i(92241);
      this.baK.append(parama.baY, parama);
      AppMethodBeat.o(92241);
    }
    
    public final void a(k.b paramb)
    {
      AppMethodBeat.i(92240);
      this.baJ.append(paramb.bqS, paramb);
      AppMethodBeat.o(92240);
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92243);
      if (!this.baz)
      {
        AppMethodBeat.o(92243);
        return;
      }
      paramInt2 -= paramInt1;
      if (this.buffer.length < this.baM + paramInt2) {
        this.buffer = Arrays.copyOf(this.buffer, (this.baM + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.baM, paramInt2);
      this.baM = (paramInt2 + this.baM);
      this.baL.l(this.buffer, 0, this.baM);
      if (!this.baL.fw(8))
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.baL.ve();
      int i3 = this.baL.eA(2);
      this.baL.eB(5);
      if (!this.baL.vs())
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.baL.vu();
      if (!this.baL.vs())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i4 = this.baL.vu();
      if (!this.baD)
      {
        this.baz = false;
        this.baR.eE(i4);
        AppMethodBeat.o(92243);
        return;
      }
      if (!this.baL.vs())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i5 = this.baL.vu();
      if (this.baK.indexOfKey(i5) < 0)
      {
        this.baz = false;
        AppMethodBeat.o(92243);
        return;
      }
      paramArrayOfByte = (k.a)this.baK.get(i5);
      k.b localb = (k.b)this.baJ.get(paramArrayOfByte.bqS);
      if (localb.bqV)
      {
        if (!this.baL.fw(2))
        {
          AppMethodBeat.o(92243);
          return;
        }
        this.baL.eB(2);
      }
      if (!this.baL.fw(localb.bqX))
      {
        AppMethodBeat.o(92243);
        return;
      }
      boolean bool2 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      int i6 = this.baL.eA(localb.bqX);
      boolean bool3 = bool5;
      boolean bool1 = bool6;
      if (!localb.bqW)
      {
        if (!this.baL.fw(1))
        {
          AppMethodBeat.o(92243);
          return;
        }
        bool4 = this.baL.sD();
        bool2 = bool4;
        bool3 = bool5;
        bool1 = bool6;
        if (bool4)
        {
          if (!this.baL.fw(1))
          {
            AppMethodBeat.o(92243);
            return;
          }
          bool1 = this.baL.sD();
          bool3 = true;
          bool2 = bool4;
        }
      }
      if (this.baN == 5) {}
      for (boolean bool4 = true;; bool4 = false)
      {
        paramInt1 = 0;
        if (!bool4) {
          break label508;
        }
        if (this.baL.vs()) {
          break;
        }
        AppMethodBeat.o(92243);
        return;
      }
      paramInt1 = this.baL.vu();
      label508:
      int i1 = 0;
      int m = 0;
      int i2 = 0;
      int n = 0;
      int i;
      int j;
      int k;
      if (localb.bqY == 0)
      {
        if (!this.baL.fw(localb.bqZ))
        {
          AppMethodBeat.o(92243);
          return;
        }
        i1 = this.baL.eA(localb.bqZ);
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (paramArrayOfByte.bqT)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!bool2)
          {
            if (!this.baL.vs())
            {
              AppMethodBeat.o(92243);
              return;
            }
            j = this.baL.vt();
            k = n;
            paramInt2 = i2;
            i = i1;
          }
        }
      }
      for (;;)
      {
        this.baR.a(localb, i3, i4, i6, i5, bool2, bool3, bool1, bool4, paramInt1, i, j, paramInt2, k);
        this.baz = false;
        AppMethodBeat.o(92243);
        return;
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (localb.bqY == 1)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!localb.bra)
          {
            if (!this.baL.vs())
            {
              AppMethodBeat.o(92243);
              return;
            }
            i2 = this.baL.vt();
            i = i1;
            j = m;
            paramInt2 = i2;
            k = n;
            if (paramArrayOfByte.bqT)
            {
              i = i1;
              j = m;
              paramInt2 = i2;
              k = n;
              if (!bool2)
              {
                if (!this.baL.vs())
                {
                  AppMethodBeat.o(92243);
                  return;
                }
                k = this.baL.vt();
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
      this.baz = false;
      this.baS = false;
      this.baR.clear();
      AppMethodBeat.o(92242);
    }
    
    static final class a
    {
      boolean baT;
      boolean baU;
      k.b baV;
      int baW;
      int baX;
      int baY;
      boolean baZ;
      boolean bba;
      boolean bbb;
      boolean bbc;
      int bbd;
      int bbe;
      int bbf;
      int bbg;
      int bbh;
      int frameNum;
      
      public final void a(k.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
      {
        this.baV = paramb;
        this.baW = paramInt1;
        this.baX = paramInt2;
        this.frameNum = paramInt3;
        this.baY = paramInt4;
        this.baZ = paramBoolean1;
        this.bba = paramBoolean2;
        this.bbb = paramBoolean3;
        this.bbc = paramBoolean4;
        this.bbd = paramInt5;
        this.bbe = paramInt6;
        this.bbf = paramInt7;
        this.bbg = paramInt8;
        this.bbh = paramInt9;
        this.baT = true;
        this.baU = true;
      }
      
      public final void clear()
      {
        this.baU = false;
        this.baT = false;
      }
      
      public final void eE(int paramInt)
      {
        this.baX = paramInt;
        this.baU = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.j
 * JD-Core Version:    0.7.0.1
 */