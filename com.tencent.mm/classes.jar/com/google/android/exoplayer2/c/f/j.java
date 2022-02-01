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
  private com.google.android.exoplayer2.c.m biD;
  private boolean bin;
  private String bqF;
  private final boolean[] bqT;
  private long bqV;
  private long bqX;
  private final s bre;
  private final boolean brf;
  private final boolean brg;
  private final n brh;
  private final n bri;
  private final n brj;
  private a brk;
  private final com.google.android.exoplayer2.i.m brl;
  
  public j(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92244);
    this.bre = params;
    this.brf = paramBoolean1;
    this.brg = paramBoolean2;
    this.bqT = new boolean[3];
    this.brh = new n(7);
    this.bri = new n(8);
    this.brj = new n(6);
    this.brl = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92244);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92248);
    if ((!this.bin) || (this.brk.brg))
    {
      this.brh.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bri.f(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.brj.f(paramArrayOfByte, paramInt1, paramInt2);
    this.brk.f(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(92248);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92246);
    paramd.uR();
    this.bqF = paramd.uS();
    this.biD = paramg.eb(paramd.getTrackId());
    this.brk = new a(this.biD, this.brf, this.brg);
    this.bre.a(paramg, paramd);
    AppMethodBeat.o(92246);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bqX = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92247);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte = paramm.data;
    this.bqV += paramm.wV();
    this.biD.a(paramm, paramm.wV());
    int k = k.a(arrayOfByte, i, j, this.bqT);
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
    long l1 = this.bqV - n;
    label136:
    long l2;
    Object localObject1;
    label370:
    int i3;
    if (i1 < 0)
    {
      i = -i1;
      l2 = this.bqX;
      Object localObject2;
      if ((!this.bin) || (this.brk.brg))
      {
        this.brh.ey(i);
        this.bri.ey(i);
        if (this.bin) {
          break label1060;
        }
        if ((this.brh.bsb) && (this.bri.bsb))
        {
          paramm = new ArrayList();
          paramm.add(Arrays.copyOf(this.brh.nalData, this.brh.bsc));
          paramm.add(Arrays.copyOf(this.bri.nalData, this.bri.bsc));
          localObject1 = k.k(this.brh.nalData, 3, this.brh.bsc);
          localObject2 = k.m(this.bri.nalData, this.bri.bsc);
          this.biD.f(Format.a(this.bqF, "video/avc", ((k.b)localObject1).width, ((k.b)localObject1).height, paramm, ((k.b)localObject1).bGU));
          this.bin = true;
          this.brk.a((k.b)localObject1);
          this.brk.a((k.a)localObject2);
          this.brh.reset();
          this.bri.reset();
        }
      }
      if (this.brj.ey(i))
      {
        i = k.j(this.brj.nalData, this.brj.bsc);
        this.brl.n(this.brj.nalData, i);
        this.brl.setPosition(4);
        this.bre.a(l2, this.brl);
      }
      paramm = this.brk;
      if (paramm.brq != 9)
      {
        if (paramm.brg)
        {
          localObject1 = paramm.bru;
          localObject2 = paramm.brt;
          if ((!((j.a.a)localObject1).brw) || ((((j.a.a)localObject2).brw) && (((j.a.a)localObject1).frameNum == ((j.a.a)localObject2).frameNum) && (((j.a.a)localObject1).brB == ((j.a.a)localObject2).brB) && (((j.a.a)localObject1).brC == ((j.a.a)localObject2).brC) && ((!((j.a.a)localObject1).brD) || (!((j.a.a)localObject2).brD) || (((j.a.a)localObject1).brE == ((j.a.a)localObject2).brE)) && ((((j.a.a)localObject1).brz == ((j.a.a)localObject2).brz) || ((((j.a.a)localObject1).brz != 0) && (((j.a.a)localObject2).brz != 0))) && ((((j.a.a)localObject1).bry.bGY != 0) || (((j.a.a)localObject2).bry.bGY != 0) || ((((j.a.a)localObject1).brH == ((j.a.a)localObject2).brH) && (((j.a.a)localObject1).brI == ((j.a.a)localObject2).brI))) && ((((j.a.a)localObject1).bry.bGY != 1) || (((j.a.a)localObject2).bry.bGY != 1) || ((((j.a.a)localObject1).brJ == ((j.a.a)localObject2).brJ) && (((j.a.a)localObject1).brK == ((j.a.a)localObject2).brK))) && (((j.a.a)localObject1).brF == ((j.a.a)localObject2).brF) && ((!((j.a.a)localObject1).brF) || (!((j.a.a)localObject2).brF) || (((j.a.a)localObject1).brG == ((j.a.a)localObject2).brG)))) {
            break label1153;
          }
          i = 1;
          label723:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramm.brv)
        {
          i1 = (int)(l1 - paramm.brr);
          if (!paramm.bqZ) {
            break label1158;
          }
          i = 1;
          label753:
          int i2 = (int)(paramm.brr - paramm.bqY);
          paramm.biD.a(paramm.bqR, i, i2, n + i1, null);
        }
        paramm.bqY = paramm.brr;
        paramm.bqR = paramm.brs;
        paramm.bqZ = false;
        paramm.brv = true;
      }
      i3 = paramm.bqZ;
      if (paramm.brq != 5)
      {
        if ((!paramm.brf) || (paramm.brq != 1)) {
          break label1168;
        }
        localObject1 = paramm.bru;
        if ((!((j.a.a)localObject1).brx) || ((((j.a.a)localObject1).brA != 7) && (((j.a.a)localObject1).brA != 2))) {
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
      paramm.bqZ = (i | i3);
      l2 = this.bqX;
      if ((!this.bin) || (this.brk.brg))
      {
        this.brh.ex(m);
        this.bri.ex(m);
      }
      this.brj.ex(m);
      paramm = this.brk;
      paramm.brq = m;
      paramm.brs = l2;
      paramm.brr = l1;
      if (((paramm.brf) && (paramm.brq == 1)) || ((paramm.brg) && ((paramm.brq == 5) || (paramm.brq == 1) || (paramm.brq == 2))))
      {
        localObject1 = paramm.brt;
        paramm.brt = paramm.bru;
        paramm.bru = ((j.a.a)localObject1);
        paramm.bru.clear();
        paramm.brp = 0;
        paramm.brc = true;
      }
      i = k + 3;
      break;
      i = 0;
      break label136;
      label1060:
      if (this.brh.bsb)
      {
        paramm = k.k(this.brh.nalData, 3, this.brh.bsc);
        this.brk.a(paramm);
        this.brh.reset();
        break label370;
      }
      if (!this.bri.bsb) {
        break label370;
      }
      paramm = k.m(this.bri.nalData, this.bri.bsc);
      this.brk.a(paramm);
      this.bri.reset();
      break label370;
      i = 0;
      break label723;
      i = 0;
      break label753;
      i = 0;
      break label877;
    }
  }
  
  public final void uF()
  {
    AppMethodBeat.i(92245);
    k.a(this.bqT);
    this.brh.reset();
    this.bri.reset();
    this.brj.reset();
    this.brk.reset();
    this.bqV = 0L;
    AppMethodBeat.o(92245);
  }
  
  public final void uG() {}
  
  static final class a
  {
    final com.google.android.exoplayer2.c.m biD;
    long bqR;
    long bqY;
    boolean bqZ;
    boolean brc;
    final boolean brf;
    final boolean brg;
    private final SparseArray<k.b> brm;
    private final SparseArray<k.a> brn;
    private final com.google.android.exoplayer2.i.n bro;
    int brp;
    int brq;
    long brr;
    long brs;
    a brt;
    a bru;
    boolean brv;
    private byte[] buffer;
    
    public a(com.google.android.exoplayer2.c.m paramm, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92239);
      this.biD = paramm;
      this.brf = paramBoolean1;
      this.brg = paramBoolean2;
      this.brm = new SparseArray();
      this.brn = new SparseArray();
      this.brt = new a((byte)0);
      this.bru = new a((byte)0);
      this.buffer = new byte[''];
      this.bro = new com.google.android.exoplayer2.i.n(this.buffer, 0, 0);
      reset();
      AppMethodBeat.o(92239);
    }
    
    public final void a(k.a parama)
    {
      AppMethodBeat.i(92241);
      this.brn.append(parama.brB, parama);
      AppMethodBeat.o(92241);
    }
    
    public final void a(k.b paramb)
    {
      AppMethodBeat.i(92240);
      this.brm.append(paramb.bGS, paramb);
      AppMethodBeat.o(92240);
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92243);
      if (!this.brc)
      {
        AppMethodBeat.o(92243);
        return;
      }
      paramInt2 -= paramInt1;
      if (this.buffer.length < this.brp + paramInt2) {
        this.buffer = Arrays.copyOf(this.buffer, (this.brp + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.brp, paramInt2);
      this.brp = (paramInt2 + this.brp);
      this.bro.l(this.buffer, 0, this.brp);
      if (!this.bro.fc(8))
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.bro.wT();
      int i3 = this.bro.es(2);
      this.bro.et(5);
      if (!this.bro.xg())
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.bro.xi();
      if (!this.bro.xg())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i4 = this.bro.xi();
      if (!this.brg)
      {
        this.brc = false;
        this.bru.ev(i4);
        AppMethodBeat.o(92243);
        return;
      }
      if (!this.bro.xg())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i5 = this.bro.xi();
      if (this.brn.indexOfKey(i5) < 0)
      {
        this.brc = false;
        AppMethodBeat.o(92243);
        return;
      }
      paramArrayOfByte = (k.a)this.brn.get(i5);
      k.b localb = (k.b)this.brm.get(paramArrayOfByte.bGS);
      if (localb.bGV)
      {
        if (!this.bro.fc(2))
        {
          AppMethodBeat.o(92243);
          return;
        }
        this.bro.et(2);
      }
      if (!this.bro.fc(localb.bGX))
      {
        AppMethodBeat.o(92243);
        return;
      }
      boolean bool2 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      int i6 = this.bro.es(localb.bGX);
      boolean bool3 = bool5;
      boolean bool1 = bool6;
      if (!localb.bGW)
      {
        if (!this.bro.fc(1))
        {
          AppMethodBeat.o(92243);
          return;
        }
        bool4 = this.bro.uD();
        bool2 = bool4;
        bool3 = bool5;
        bool1 = bool6;
        if (bool4)
        {
          if (!this.bro.fc(1))
          {
            AppMethodBeat.o(92243);
            return;
          }
          bool1 = this.bro.uD();
          bool3 = true;
          bool2 = bool4;
        }
      }
      if (this.brq == 5) {}
      for (boolean bool4 = true;; bool4 = false)
      {
        paramInt1 = 0;
        if (!bool4) {
          break label508;
        }
        if (this.bro.xg()) {
          break;
        }
        AppMethodBeat.o(92243);
        return;
      }
      paramInt1 = this.bro.xi();
      label508:
      int i1 = 0;
      int m = 0;
      int i2 = 0;
      int n = 0;
      int i;
      int j;
      int k;
      if (localb.bGY == 0)
      {
        if (!this.bro.fc(localb.bGZ))
        {
          AppMethodBeat.o(92243);
          return;
        }
        i1 = this.bro.es(localb.bGZ);
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (paramArrayOfByte.bGT)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!bool2)
          {
            if (!this.bro.xg())
            {
              AppMethodBeat.o(92243);
              return;
            }
            j = this.bro.xh();
            k = n;
            paramInt2 = i2;
            i = i1;
          }
        }
      }
      for (;;)
      {
        this.bru.a(localb, i3, i4, i6, i5, bool2, bool3, bool1, bool4, paramInt1, i, j, paramInt2, k);
        this.brc = false;
        AppMethodBeat.o(92243);
        return;
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (localb.bGY == 1)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!localb.bHa)
          {
            if (!this.bro.xg())
            {
              AppMethodBeat.o(92243);
              return;
            }
            i2 = this.bro.xh();
            i = i1;
            j = m;
            paramInt2 = i2;
            k = n;
            if (paramArrayOfByte.bGT)
            {
              i = i1;
              j = m;
              paramInt2 = i2;
              k = n;
              if (!bool2)
              {
                if (!this.bro.xg())
                {
                  AppMethodBeat.o(92243);
                  return;
                }
                k = this.bro.xh();
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
      this.brc = false;
      this.brv = false;
      this.bru.clear();
      AppMethodBeat.o(92242);
    }
    
    static final class a
    {
      int brA;
      int brB;
      boolean brC;
      boolean brD;
      boolean brE;
      boolean brF;
      int brG;
      int brH;
      int brI;
      int brJ;
      int brK;
      boolean brw;
      boolean brx;
      k.b bry;
      int brz;
      int frameNum;
      
      public final void a(k.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
      {
        this.bry = paramb;
        this.brz = paramInt1;
        this.brA = paramInt2;
        this.frameNum = paramInt3;
        this.brB = paramInt4;
        this.brC = paramBoolean1;
        this.brD = paramBoolean2;
        this.brE = paramBoolean3;
        this.brF = paramBoolean4;
        this.brG = paramInt5;
        this.brH = paramInt6;
        this.brI = paramInt7;
        this.brJ = paramInt8;
        this.brK = paramInt9;
        this.brw = true;
        this.brx = true;
      }
      
      public final void clear()
      {
        this.brx = false;
        this.brw = false;
      }
      
      public final void ev(int paramInt)
      {
        this.brA = paramInt;
        this.brx = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.j
 * JD-Core Version:    0.7.0.1
 */