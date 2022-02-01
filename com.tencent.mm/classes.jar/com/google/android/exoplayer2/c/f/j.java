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
  private boolean aXS;
  private com.google.android.exoplayer2.c.m aYi;
  private long bgB;
  private long bgD;
  private final s bgK;
  private final boolean bgL;
  private final boolean bgM;
  private final n bgN;
  private final n bgO;
  private final n bgP;
  private a bgQ;
  private final com.google.android.exoplayer2.i.m bgR;
  private String bgl;
  private final boolean[] bgz;
  
  public j(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92244);
    this.bgK = params;
    this.bgL = paramBoolean1;
    this.bgM = paramBoolean2;
    this.bgz = new boolean[3];
    this.bgN = new n(7);
    this.bgO = new n(8);
    this.bgP = new n(6);
    this.bgR = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92244);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92248);
    if ((!this.aXS) || (this.bgQ.bgM))
    {
      this.bgN.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bgO.f(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.bgP.f(paramArrayOfByte, paramInt1, paramInt2);
    this.bgQ.f(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(92248);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92246);
    paramd.ts();
    this.bgl = paramd.tt();
    this.aYi = paramg.dW(paramd.getTrackId());
    this.bgQ = new a(this.aYi, this.bgL, this.bgM);
    this.bgK.a(paramg, paramd);
    AppMethodBeat.o(92246);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bgD = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92247);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte = paramm.data;
    this.bgB += paramm.vy();
    this.aYi.a(paramm, paramm.vy());
    int k = k.a(arrayOfByte, i, j, this.bgz);
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
    long l1 = this.bgB - n;
    label136:
    long l2;
    Object localObject1;
    label370:
    int i3;
    if (i1 < 0)
    {
      i = -i1;
      l2 = this.bgD;
      Object localObject2;
      if ((!this.aXS) || (this.bgQ.bgM))
      {
        this.bgN.eu(i);
        this.bgO.eu(i);
        if (this.aXS) {
          break label1060;
        }
        if ((this.bgN.bhH) && (this.bgO.bhH))
        {
          paramm = new ArrayList();
          paramm.add(Arrays.copyOf(this.bgN.nalData, this.bgN.bhI));
          paramm.add(Arrays.copyOf(this.bgO.nalData, this.bgO.bhI));
          localObject1 = k.k(this.bgN.nalData, 3, this.bgN.bhI);
          localObject2 = k.m(this.bgO.nalData, this.bgO.bhI);
          this.aYi.f(Format.a(this.bgl, "video/avc", ((k.b)localObject1).width, ((k.b)localObject1).height, paramm, ((k.b)localObject1).bwG));
          this.aXS = true;
          this.bgQ.a((k.b)localObject1);
          this.bgQ.a((k.a)localObject2);
          this.bgN.reset();
          this.bgO.reset();
        }
      }
      if (this.bgP.eu(i))
      {
        i = k.j(this.bgP.nalData, this.bgP.bhI);
        this.bgR.n(this.bgP.nalData, i);
        this.bgR.setPosition(4);
        this.bgK.a(l2, this.bgR);
      }
      paramm = this.bgQ;
      if (paramm.bgW != 9)
      {
        if (paramm.bgM)
        {
          localObject1 = paramm.bha;
          localObject2 = paramm.bgZ;
          if ((!((j.a.a)localObject1).bhc) || ((((j.a.a)localObject2).bhc) && (((j.a.a)localObject1).frameNum == ((j.a.a)localObject2).frameNum) && (((j.a.a)localObject1).bhh == ((j.a.a)localObject2).bhh) && (((j.a.a)localObject1).bhi == ((j.a.a)localObject2).bhi) && ((!((j.a.a)localObject1).bhj) || (!((j.a.a)localObject2).bhj) || (((j.a.a)localObject1).bhk == ((j.a.a)localObject2).bhk)) && ((((j.a.a)localObject1).bhf == ((j.a.a)localObject2).bhf) || ((((j.a.a)localObject1).bhf != 0) && (((j.a.a)localObject2).bhf != 0))) && ((((j.a.a)localObject1).bhe.bwK != 0) || (((j.a.a)localObject2).bhe.bwK != 0) || ((((j.a.a)localObject1).bhn == ((j.a.a)localObject2).bhn) && (((j.a.a)localObject1).bho == ((j.a.a)localObject2).bho))) && ((((j.a.a)localObject1).bhe.bwK != 1) || (((j.a.a)localObject2).bhe.bwK != 1) || ((((j.a.a)localObject1).bhp == ((j.a.a)localObject2).bhp) && (((j.a.a)localObject1).bhq == ((j.a.a)localObject2).bhq))) && (((j.a.a)localObject1).bhl == ((j.a.a)localObject2).bhl) && ((!((j.a.a)localObject1).bhl) || (!((j.a.a)localObject2).bhl) || (((j.a.a)localObject1).bhm == ((j.a.a)localObject2).bhm)))) {
            break label1153;
          }
          i = 1;
          label723:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramm.bhb)
        {
          i1 = (int)(l1 - paramm.bgX);
          if (!paramm.bgF) {
            break label1158;
          }
          i = 1;
          label753:
          int i2 = (int)(paramm.bgX - paramm.bgE);
          paramm.aYi.a(paramm.bgx, i, i2, n + i1, null);
        }
        paramm.bgE = paramm.bgX;
        paramm.bgx = paramm.bgY;
        paramm.bgF = false;
        paramm.bhb = true;
      }
      i3 = paramm.bgF;
      if (paramm.bgW != 5)
      {
        if ((!paramm.bgL) || (paramm.bgW != 1)) {
          break label1168;
        }
        localObject1 = paramm.bha;
        if ((!((j.a.a)localObject1).bhd) || ((((j.a.a)localObject1).bhg != 7) && (((j.a.a)localObject1).bhg != 2))) {
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
      paramm.bgF = (i | i3);
      l2 = this.bgD;
      if ((!this.aXS) || (this.bgQ.bgM))
      {
        this.bgN.et(m);
        this.bgO.et(m);
      }
      this.bgP.et(m);
      paramm = this.bgQ;
      paramm.bgW = m;
      paramm.bgY = l2;
      paramm.bgX = l1;
      if (((paramm.bgL) && (paramm.bgW == 1)) || ((paramm.bgM) && ((paramm.bgW == 5) || (paramm.bgW == 1) || (paramm.bgW == 2))))
      {
        localObject1 = paramm.bgZ;
        paramm.bgZ = paramm.bha;
        paramm.bha = ((j.a.a)localObject1);
        paramm.bha.clear();
        paramm.bgV = 0;
        paramm.bgI = true;
      }
      i = k + 3;
      break;
      i = 0;
      break label136;
      label1060:
      if (this.bgN.bhH)
      {
        paramm = k.k(this.bgN.nalData, 3, this.bgN.bhI);
        this.bgQ.a(paramm);
        this.bgN.reset();
        break label370;
      }
      if (!this.bgO.bhH) {
        break label370;
      }
      paramm = k.m(this.bgO.nalData, this.bgO.bhI);
      this.bgQ.a(paramm);
      this.bgO.reset();
      break label370;
      i = 0;
      break label723;
      i = 0;
      break label753;
      i = 0;
      break label877;
    }
  }
  
  public final void tg()
  {
    AppMethodBeat.i(92245);
    k.a(this.bgz);
    this.bgN.reset();
    this.bgO.reset();
    this.bgP.reset();
    this.bgQ.reset();
    this.bgB = 0L;
    AppMethodBeat.o(92245);
  }
  
  public final void th() {}
  
  static final class a
  {
    final com.google.android.exoplayer2.c.m aYi;
    long bgE;
    boolean bgF;
    boolean bgI;
    final boolean bgL;
    final boolean bgM;
    private final SparseArray<k.b> bgS;
    private final SparseArray<k.a> bgT;
    private final com.google.android.exoplayer2.i.n bgU;
    int bgV;
    int bgW;
    long bgX;
    long bgY;
    a bgZ;
    long bgx;
    a bha;
    boolean bhb;
    private byte[] buffer;
    
    public a(com.google.android.exoplayer2.c.m paramm, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92239);
      this.aYi = paramm;
      this.bgL = paramBoolean1;
      this.bgM = paramBoolean2;
      this.bgS = new SparseArray();
      this.bgT = new SparseArray();
      this.bgZ = new a((byte)0);
      this.bha = new a((byte)0);
      this.buffer = new byte[''];
      this.bgU = new com.google.android.exoplayer2.i.n(this.buffer, 0, 0);
      reset();
      AppMethodBeat.o(92239);
    }
    
    public final void a(k.a parama)
    {
      AppMethodBeat.i(92241);
      this.bgT.append(parama.bhh, parama);
      AppMethodBeat.o(92241);
    }
    
    public final void a(k.b paramb)
    {
      AppMethodBeat.i(92240);
      this.bgS.append(paramb.bwE, paramb);
      AppMethodBeat.o(92240);
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92243);
      if (!this.bgI)
      {
        AppMethodBeat.o(92243);
        return;
      }
      paramInt2 -= paramInt1;
      if (this.buffer.length < this.bgV + paramInt2) {
        this.buffer = Arrays.copyOf(this.buffer, (this.bgV + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.bgV, paramInt2);
      this.bgV = (paramInt2 + this.bgV);
      this.bgU.l(this.buffer, 0, this.bgV);
      if (!this.bgU.eZ(8))
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.bgU.vw();
      int i3 = this.bgU.eo(2);
      this.bgU.ep(5);
      if (!this.bgU.vJ())
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.bgU.vL();
      if (!this.bgU.vJ())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i4 = this.bgU.vL();
      if (!this.bgM)
      {
        this.bgI = false;
        this.bha.er(i4);
        AppMethodBeat.o(92243);
        return;
      }
      if (!this.bgU.vJ())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i5 = this.bgU.vL();
      if (this.bgT.indexOfKey(i5) < 0)
      {
        this.bgI = false;
        AppMethodBeat.o(92243);
        return;
      }
      paramArrayOfByte = (k.a)this.bgT.get(i5);
      k.b localb = (k.b)this.bgS.get(paramArrayOfByte.bwE);
      if (localb.bwH)
      {
        if (!this.bgU.eZ(2))
        {
          AppMethodBeat.o(92243);
          return;
        }
        this.bgU.ep(2);
      }
      if (!this.bgU.eZ(localb.bwJ))
      {
        AppMethodBeat.o(92243);
        return;
      }
      boolean bool2 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      int i6 = this.bgU.eo(localb.bwJ);
      boolean bool3 = bool5;
      boolean bool1 = bool6;
      if (!localb.bwI)
      {
        if (!this.bgU.eZ(1))
        {
          AppMethodBeat.o(92243);
          return;
        }
        bool4 = this.bgU.te();
        bool2 = bool4;
        bool3 = bool5;
        bool1 = bool6;
        if (bool4)
        {
          if (!this.bgU.eZ(1))
          {
            AppMethodBeat.o(92243);
            return;
          }
          bool1 = this.bgU.te();
          bool3 = true;
          bool2 = bool4;
        }
      }
      if (this.bgW == 5) {}
      for (boolean bool4 = true;; bool4 = false)
      {
        paramInt1 = 0;
        if (!bool4) {
          break label508;
        }
        if (this.bgU.vJ()) {
          break;
        }
        AppMethodBeat.o(92243);
        return;
      }
      paramInt1 = this.bgU.vL();
      label508:
      int i1 = 0;
      int m = 0;
      int i2 = 0;
      int n = 0;
      int i;
      int j;
      int k;
      if (localb.bwK == 0)
      {
        if (!this.bgU.eZ(localb.bwL))
        {
          AppMethodBeat.o(92243);
          return;
        }
        i1 = this.bgU.eo(localb.bwL);
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (paramArrayOfByte.bwF)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!bool2)
          {
            if (!this.bgU.vJ())
            {
              AppMethodBeat.o(92243);
              return;
            }
            j = this.bgU.vK();
            k = n;
            paramInt2 = i2;
            i = i1;
          }
        }
      }
      for (;;)
      {
        this.bha.a(localb, i3, i4, i6, i5, bool2, bool3, bool1, bool4, paramInt1, i, j, paramInt2, k);
        this.bgI = false;
        AppMethodBeat.o(92243);
        return;
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (localb.bwK == 1)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!localb.bwM)
          {
            if (!this.bgU.vJ())
            {
              AppMethodBeat.o(92243);
              return;
            }
            i2 = this.bgU.vK();
            i = i1;
            j = m;
            paramInt2 = i2;
            k = n;
            if (paramArrayOfByte.bwF)
            {
              i = i1;
              j = m;
              paramInt2 = i2;
              k = n;
              if (!bool2)
              {
                if (!this.bgU.vJ())
                {
                  AppMethodBeat.o(92243);
                  return;
                }
                k = this.bgU.vK();
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
      this.bgI = false;
      this.bhb = false;
      this.bha.clear();
      AppMethodBeat.o(92242);
    }
    
    static final class a
    {
      boolean bhc;
      boolean bhd;
      k.b bhe;
      int bhf;
      int bhg;
      int bhh;
      boolean bhi;
      boolean bhj;
      boolean bhk;
      boolean bhl;
      int bhm;
      int bhn;
      int bho;
      int bhp;
      int bhq;
      int frameNum;
      
      public final void a(k.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
      {
        this.bhe = paramb;
        this.bhf = paramInt1;
        this.bhg = paramInt2;
        this.frameNum = paramInt3;
        this.bhh = paramInt4;
        this.bhi = paramBoolean1;
        this.bhj = paramBoolean2;
        this.bhk = paramBoolean3;
        this.bhl = paramBoolean4;
        this.bhm = paramInt5;
        this.bhn = paramInt6;
        this.bho = paramInt7;
        this.bhp = paramInt8;
        this.bhq = paramInt9;
        this.bhc = true;
        this.bhd = true;
      }
      
      public final void clear()
      {
        this.bhd = false;
        this.bhc = false;
      }
      
      public final void er(int paramInt)
      {
        this.bhg = paramInt;
        this.bhd = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.j
 * JD-Core Version:    0.7.0.1
 */