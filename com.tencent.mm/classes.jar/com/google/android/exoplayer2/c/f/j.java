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
  private com.google.android.exoplayer2.c.m biA;
  private boolean bik;
  private String bqA;
  private final boolean[] bqO;
  private long bqQ;
  private long bqS;
  private final s bqZ;
  private final boolean bra;
  private final boolean brb;
  private final n brc;
  private final n brd;
  private final n bre;
  private a brf;
  private final com.google.android.exoplayer2.i.m brg;
  
  public j(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92244);
    this.bqZ = params;
    this.bra = paramBoolean1;
    this.brb = paramBoolean2;
    this.bqO = new boolean[3];
    this.brc = new n(7);
    this.brd = new n(8);
    this.bre = new n(6);
    this.brg = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92244);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92248);
    if ((!this.bik) || (this.brf.brb))
    {
      this.brc.f(paramArrayOfByte, paramInt1, paramInt2);
      this.brd.f(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.bre.f(paramArrayOfByte, paramInt1, paramInt2);
    this.brf.f(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(92248);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92246);
    paramd.uW();
    this.bqA = paramd.uX();
    this.biA = paramg.dV(paramd.getTrackId());
    this.brf = new a(this.biA, this.bra, this.brb);
    this.bqZ.a(paramg, paramd);
    AppMethodBeat.o(92246);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bqS = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92247);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte = paramm.data;
    this.bqQ += paramm.xd();
    this.biA.a(paramm, paramm.xd());
    int k = k.a(arrayOfByte, i, j, this.bqO);
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
    long l1 = this.bqQ - n;
    label136:
    long l2;
    Object localObject1;
    label370:
    int i3;
    if (i1 < 0)
    {
      i = -i1;
      l2 = this.bqS;
      Object localObject2;
      if ((!this.bik) || (this.brf.brb))
      {
        this.brc.es(i);
        this.brd.es(i);
        if (this.bik) {
          break label1060;
        }
        if ((this.brc.brW) && (this.brd.brW))
        {
          paramm = new ArrayList();
          paramm.add(Arrays.copyOf(this.brc.nalData, this.brc.brX));
          paramm.add(Arrays.copyOf(this.brd.nalData, this.brd.brX));
          localObject1 = k.k(this.brc.nalData, 3, this.brc.brX);
          localObject2 = k.m(this.brd.nalData, this.brd.brX);
          this.biA.f(Format.a(this.bqA, "video/avc", ((k.b)localObject1).width, ((k.b)localObject1).height, paramm, ((k.b)localObject1).bHl));
          this.bik = true;
          this.brf.a((k.b)localObject1);
          this.brf.a((k.a)localObject2);
          this.brc.reset();
          this.brd.reset();
        }
      }
      if (this.bre.es(i))
      {
        i = k.j(this.bre.nalData, this.bre.brX);
        this.brg.n(this.bre.nalData, i);
        this.brg.setPosition(4);
        this.bqZ.a(l2, this.brg);
      }
      paramm = this.brf;
      if (paramm.brl != 9)
      {
        if (paramm.brb)
        {
          localObject1 = paramm.brp;
          localObject2 = paramm.bro;
          if ((!((j.a.a)localObject1).brr) || ((((j.a.a)localObject2).brr) && (((j.a.a)localObject1).frameNum == ((j.a.a)localObject2).frameNum) && (((j.a.a)localObject1).brw == ((j.a.a)localObject2).brw) && (((j.a.a)localObject1).brx == ((j.a.a)localObject2).brx) && ((!((j.a.a)localObject1).bry) || (!((j.a.a)localObject2).bry) || (((j.a.a)localObject1).brz == ((j.a.a)localObject2).brz)) && ((((j.a.a)localObject1).bru == ((j.a.a)localObject2).bru) || ((((j.a.a)localObject1).bru != 0) && (((j.a.a)localObject2).bru != 0))) && ((((j.a.a)localObject1).brt.bHp != 0) || (((j.a.a)localObject2).brt.bHp != 0) || ((((j.a.a)localObject1).brC == ((j.a.a)localObject2).brC) && (((j.a.a)localObject1).brD == ((j.a.a)localObject2).brD))) && ((((j.a.a)localObject1).brt.bHp != 1) || (((j.a.a)localObject2).brt.bHp != 1) || ((((j.a.a)localObject1).brE == ((j.a.a)localObject2).brE) && (((j.a.a)localObject1).brF == ((j.a.a)localObject2).brF))) && (((j.a.a)localObject1).brA == ((j.a.a)localObject2).brA) && ((!((j.a.a)localObject1).brA) || (!((j.a.a)localObject2).brA) || (((j.a.a)localObject1).brB == ((j.a.a)localObject2).brB)))) {
            break label1153;
          }
          i = 1;
          label723:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramm.brq)
        {
          i1 = (int)(l1 - paramm.brm);
          if (!paramm.bqU) {
            break label1158;
          }
          i = 1;
          label753:
          int i2 = (int)(paramm.brm - paramm.bqT);
          paramm.biA.a(paramm.bqM, i, i2, n + i1, null);
        }
        paramm.bqT = paramm.brm;
        paramm.bqM = paramm.brn;
        paramm.bqU = false;
        paramm.brq = true;
      }
      i3 = paramm.bqU;
      if (paramm.brl != 5)
      {
        if ((!paramm.bra) || (paramm.brl != 1)) {
          break label1168;
        }
        localObject1 = paramm.brp;
        if ((!((j.a.a)localObject1).brs) || ((((j.a.a)localObject1).brv != 7) && (((j.a.a)localObject1).brv != 2))) {
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
      paramm.bqU = (i | i3);
      l2 = this.bqS;
      if ((!this.bik) || (this.brf.brb))
      {
        this.brc.er(m);
        this.brd.er(m);
      }
      this.bre.er(m);
      paramm = this.brf;
      paramm.brl = m;
      paramm.brn = l2;
      paramm.brm = l1;
      if (((paramm.bra) && (paramm.brl == 1)) || ((paramm.brb) && ((paramm.brl == 5) || (paramm.brl == 1) || (paramm.brl == 2))))
      {
        localObject1 = paramm.bro;
        paramm.bro = paramm.brp;
        paramm.brp = ((j.a.a)localObject1);
        paramm.brp.clear();
        paramm.brk = 0;
        paramm.bqX = true;
      }
      i = k + 3;
      break;
      i = 0;
      break label136;
      label1060:
      if (this.brc.brW)
      {
        paramm = k.k(this.brc.nalData, 3, this.brc.brX);
        this.brf.a(paramm);
        this.brc.reset();
        break label370;
      }
      if (!this.brd.brW) {
        break label370;
      }
      paramm = k.m(this.brd.nalData, this.brd.brX);
      this.brf.a(paramm);
      this.brd.reset();
      break label370;
      i = 0;
      break label723;
      i = 0;
      break label753;
      i = 0;
      break label877;
    }
  }
  
  public final void uK()
  {
    AppMethodBeat.i(92245);
    k.a(this.bqO);
    this.brc.reset();
    this.brd.reset();
    this.bre.reset();
    this.brf.reset();
    this.bqQ = 0L;
    AppMethodBeat.o(92245);
  }
  
  public final void uL() {}
  
  static final class a
  {
    final com.google.android.exoplayer2.c.m biA;
    long bqM;
    long bqT;
    boolean bqU;
    boolean bqX;
    final boolean bra;
    final boolean brb;
    private final SparseArray<k.b> brh;
    private final SparseArray<k.a> bri;
    private final com.google.android.exoplayer2.i.n brj;
    int brk;
    int brl;
    long brm;
    long brn;
    a bro;
    a brp;
    boolean brq;
    private byte[] buffer;
    
    public a(com.google.android.exoplayer2.c.m paramm, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92239);
      this.biA = paramm;
      this.bra = paramBoolean1;
      this.brb = paramBoolean2;
      this.brh = new SparseArray();
      this.bri = new SparseArray();
      this.bro = new a((byte)0);
      this.brp = new a((byte)0);
      this.buffer = new byte[''];
      this.brj = new com.google.android.exoplayer2.i.n(this.buffer, 0, 0);
      reset();
      AppMethodBeat.o(92239);
    }
    
    public final void a(k.a parama)
    {
      AppMethodBeat.i(92241);
      this.bri.append(parama.brw, parama);
      AppMethodBeat.o(92241);
    }
    
    public final void a(k.b paramb)
    {
      AppMethodBeat.i(92240);
      this.brh.append(paramb.bHj, paramb);
      AppMethodBeat.o(92240);
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92243);
      if (!this.bqX)
      {
        AppMethodBeat.o(92243);
        return;
      }
      paramInt2 -= paramInt1;
      if (this.buffer.length < this.brk + paramInt2) {
        this.buffer = Arrays.copyOf(this.buffer, (this.brk + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.brk, paramInt2);
      this.brk = (paramInt2 + this.brk);
      this.brj.l(this.buffer, 0, this.brk);
      if (!this.brj.fb(8))
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.brj.xb();
      int i3 = this.brj.em(2);
      this.brj.en(5);
      if (!this.brj.xo())
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.brj.xq();
      if (!this.brj.xo())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i4 = this.brj.xq();
      if (!this.brb)
      {
        this.bqX = false;
        this.brp.ep(i4);
        AppMethodBeat.o(92243);
        return;
      }
      if (!this.brj.xo())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i5 = this.brj.xq();
      if (this.bri.indexOfKey(i5) < 0)
      {
        this.bqX = false;
        AppMethodBeat.o(92243);
        return;
      }
      paramArrayOfByte = (k.a)this.bri.get(i5);
      k.b localb = (k.b)this.brh.get(paramArrayOfByte.bHj);
      if (localb.bHm)
      {
        if (!this.brj.fb(2))
        {
          AppMethodBeat.o(92243);
          return;
        }
        this.brj.en(2);
      }
      if (!this.brj.fb(localb.bHo))
      {
        AppMethodBeat.o(92243);
        return;
      }
      boolean bool2 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      int i6 = this.brj.em(localb.bHo);
      boolean bool3 = bool5;
      boolean bool1 = bool6;
      if (!localb.bHn)
      {
        if (!this.brj.fb(1))
        {
          AppMethodBeat.o(92243);
          return;
        }
        bool4 = this.brj.uI();
        bool2 = bool4;
        bool3 = bool5;
        bool1 = bool6;
        if (bool4)
        {
          if (!this.brj.fb(1))
          {
            AppMethodBeat.o(92243);
            return;
          }
          bool1 = this.brj.uI();
          bool3 = true;
          bool2 = bool4;
        }
      }
      if (this.brl == 5) {}
      for (boolean bool4 = true;; bool4 = false)
      {
        paramInt1 = 0;
        if (!bool4) {
          break label508;
        }
        if (this.brj.xo()) {
          break;
        }
        AppMethodBeat.o(92243);
        return;
      }
      paramInt1 = this.brj.xq();
      label508:
      int i1 = 0;
      int m = 0;
      int i2 = 0;
      int n = 0;
      int i;
      int j;
      int k;
      if (localb.bHp == 0)
      {
        if (!this.brj.fb(localb.bHq))
        {
          AppMethodBeat.o(92243);
          return;
        }
        i1 = this.brj.em(localb.bHq);
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (paramArrayOfByte.bHk)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!bool2)
          {
            if (!this.brj.xo())
            {
              AppMethodBeat.o(92243);
              return;
            }
            j = this.brj.xp();
            k = n;
            paramInt2 = i2;
            i = i1;
          }
        }
      }
      for (;;)
      {
        this.brp.a(localb, i3, i4, i6, i5, bool2, bool3, bool1, bool4, paramInt1, i, j, paramInt2, k);
        this.bqX = false;
        AppMethodBeat.o(92243);
        return;
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (localb.bHp == 1)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!localb.bHr)
          {
            if (!this.brj.xo())
            {
              AppMethodBeat.o(92243);
              return;
            }
            i2 = this.brj.xp();
            i = i1;
            j = m;
            paramInt2 = i2;
            k = n;
            if (paramArrayOfByte.bHk)
            {
              i = i1;
              j = m;
              paramInt2 = i2;
              k = n;
              if (!bool2)
              {
                if (!this.brj.xo())
                {
                  AppMethodBeat.o(92243);
                  return;
                }
                k = this.brj.xp();
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
      this.bqX = false;
      this.brq = false;
      this.brp.clear();
      AppMethodBeat.o(92242);
    }
    
    static final class a
    {
      boolean brA;
      int brB;
      int brC;
      int brD;
      int brE;
      int brF;
      boolean brr;
      boolean brs;
      k.b brt;
      int bru;
      int brv;
      int brw;
      boolean brx;
      boolean bry;
      boolean brz;
      int frameNum;
      
      public final void a(k.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
      {
        this.brt = paramb;
        this.bru = paramInt1;
        this.brv = paramInt2;
        this.frameNum = paramInt3;
        this.brw = paramInt4;
        this.brx = paramBoolean1;
        this.bry = paramBoolean2;
        this.brz = paramBoolean3;
        this.brA = paramBoolean4;
        this.brB = paramInt5;
        this.brC = paramInt6;
        this.brD = paramInt7;
        this.brE = paramInt8;
        this.brF = paramInt9;
        this.brr = true;
        this.brs = true;
      }
      
      public final void clear()
      {
        this.brs = false;
        this.brr = false;
      }
      
      public final void ep(int paramInt)
      {
        this.brv = paramInt;
        this.brs = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.j
 * JD-Core Version:    0.7.0.1
 */