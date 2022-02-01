package com.google.android.exoplayer2.c.g;

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
  private boolean aXg;
  private com.google.android.exoplayer2.c.m aXw;
  private String bfE;
  private final boolean[] bfT;
  private long bfV;
  private long bfX;
  private final s bge;
  private final boolean bgf;
  private final boolean bgg;
  private final n bgh;
  private final n bgi;
  private final n bgj;
  private a bgk;
  private final com.google.android.exoplayer2.i.m bgl;
  
  public j(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92244);
    this.bge = params;
    this.bgf = paramBoolean1;
    this.bgg = paramBoolean2;
    this.bfT = new boolean[3];
    this.bgh = new n(7);
    this.bgi = new n(8);
    this.bgj = new n(6);
    this.bgl = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92244);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92248);
    if ((!this.aXg) || (this.bgk.bgg))
    {
      this.bgh.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bgi.f(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.bgj.f(paramArrayOfByte, paramInt1, paramInt2);
    this.bgk.f(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(92248);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92246);
    paramd.tj();
    this.bfE = paramd.tl();
    this.aXw = paramg.bh(paramd.getTrackId(), 2);
    this.bgk = new a(this.aXw, this.bgf, this.bgg);
    this.bge.a(paramg, paramd);
    AppMethodBeat.o(92246);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bfX = paramLong;
  }
  
  public final void sX()
  {
    AppMethodBeat.i(92245);
    k.a(this.bfT);
    this.bgh.reset();
    this.bgi.reset();
    this.bgj.reset();
    this.bgk.reset();
    this.bfV = 0L;
    AppMethodBeat.o(92245);
  }
  
  public final void sY() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92247);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte = paramm.data;
    this.bfV += paramm.vJ();
    this.aXw.a(paramm, paramm.vJ());
    int k = k.a(arrayOfByte, i, j, this.bfT);
    if (k == j)
    {
      e(arrayOfByte, i, j);
      AppMethodBeat.o(92247);
      return;
    }
    int m = k.m(arrayOfByte, k);
    int i1 = k - i;
    if (i1 > 0) {
      e(arrayOfByte, i, k);
    }
    int n = j - k;
    long l1 = this.bfV - n;
    label136:
    long l2;
    Object localObject1;
    label370:
    int i3;
    if (i1 < 0)
    {
      i = -i1;
      l2 = this.bfX;
      Object localObject2;
      if ((!this.aXg) || (this.bgk.bgg))
      {
        this.bgh.eu(i);
        this.bgi.eu(i);
        if (this.aXg) {
          break label1060;
        }
        if ((this.bgh.bhb) && (this.bgi.bhb))
        {
          paramm = new ArrayList();
          paramm.add(Arrays.copyOf(this.bgh.nalData, this.bgh.bhc));
          paramm.add(Arrays.copyOf(this.bgi.nalData, this.bgi.bhc));
          localObject1 = k.l(this.bgh.nalData, 3, this.bgh.bhc);
          localObject2 = k.p(this.bgi.nalData, this.bgi.bhc);
          this.aXw.f(Format.a(this.bfE, "video/avc", ((k.b)localObject1).width, ((k.b)localObject1).height, paramm, ((k.b)localObject1).byY));
          this.aXg = true;
          this.bgk.a((k.b)localObject1);
          this.bgk.a((k.a)localObject2);
          this.bgh.reset();
          this.bgi.reset();
        }
      }
      if (this.bgj.eu(i))
      {
        i = k.l(this.bgj.nalData, this.bgj.bhc);
        this.bgl.q(this.bgj.nalData, i);
        this.bgl.setPosition(4);
        this.bge.a(l2, this.bgl);
      }
      paramm = this.bgk;
      if (paramm.bgq != 9)
      {
        if (paramm.bgg)
        {
          localObject1 = paramm.bgu;
          localObject2 = paramm.bgt;
          if ((!((j.a.a)localObject1).bgw) || ((((j.a.a)localObject2).bgw) && (((j.a.a)localObject1).frameNum == ((j.a.a)localObject2).frameNum) && (((j.a.a)localObject1).bgB == ((j.a.a)localObject2).bgB) && (((j.a.a)localObject1).bgC == ((j.a.a)localObject2).bgC) && ((!((j.a.a)localObject1).bgD) || (!((j.a.a)localObject2).bgD) || (((j.a.a)localObject1).bgE == ((j.a.a)localObject2).bgE)) && ((((j.a.a)localObject1).bgz == ((j.a.a)localObject2).bgz) || ((((j.a.a)localObject1).bgz != 0) && (((j.a.a)localObject2).bgz != 0))) && ((((j.a.a)localObject1).bgy.bzc != 0) || (((j.a.a)localObject2).bgy.bzc != 0) || ((((j.a.a)localObject1).bgH == ((j.a.a)localObject2).bgH) && (((j.a.a)localObject1).bgI == ((j.a.a)localObject2).bgI))) && ((((j.a.a)localObject1).bgy.bzc != 1) || (((j.a.a)localObject2).bgy.bzc != 1) || ((((j.a.a)localObject1).bgJ == ((j.a.a)localObject2).bgJ) && (((j.a.a)localObject1).bgK == ((j.a.a)localObject2).bgK))) && (((j.a.a)localObject1).bgF == ((j.a.a)localObject2).bgF) && ((!((j.a.a)localObject1).bgF) || (!((j.a.a)localObject2).bgF) || (((j.a.a)localObject1).bgG == ((j.a.a)localObject2).bgG)))) {
            break label1153;
          }
          i = 1;
          label723:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramm.bgv)
        {
          i1 = (int)(l1 - paramm.bgr);
          if (!paramm.bfZ) {
            break label1158;
          }
          i = 1;
          label753:
          int i2 = (int)(paramm.bgr - paramm.bfY);
          paramm.aXw.a(paramm.bfQ, i, i2, n + i1, null);
        }
        paramm.bfY = paramm.bgr;
        paramm.bfQ = paramm.bgs;
        paramm.bfZ = false;
        paramm.bgv = true;
      }
      i3 = paramm.bfZ;
      if (paramm.bgq != 5)
      {
        if ((!paramm.bgf) || (paramm.bgq != 1)) {
          break label1168;
        }
        localObject1 = paramm.bgu;
        if ((!((j.a.a)localObject1).bgx) || ((((j.a.a)localObject1).bgA != 7) && (((j.a.a)localObject1).bgA != 2))) {
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
      paramm.bfZ = (i | i3);
      l2 = this.bfX;
      if ((!this.aXg) || (this.bgk.bgg))
      {
        this.bgh.et(m);
        this.bgi.et(m);
      }
      this.bgj.et(m);
      paramm = this.bgk;
      paramm.bgq = m;
      paramm.bgs = l2;
      paramm.bgr = l1;
      if (((paramm.bgf) && (paramm.bgq == 1)) || ((paramm.bgg) && ((paramm.bgq == 5) || (paramm.bgq == 1) || (paramm.bgq == 2))))
      {
        localObject1 = paramm.bgt;
        paramm.bgt = paramm.bgu;
        paramm.bgu = ((j.a.a)localObject1);
        paramm.bgu.clear();
        paramm.bgp = 0;
        paramm.bgc = true;
      }
      i = k + 3;
      break;
      i = 0;
      break label136;
      label1060:
      if (this.bgh.bhb)
      {
        paramm = k.l(this.bgh.nalData, 3, this.bgh.bhc);
        this.bgk.a(paramm);
        this.bgh.reset();
        break label370;
      }
      if (!this.bgi.bhb) {
        break label370;
      }
      paramm = k.p(this.bgi.nalData, this.bgi.bhc);
      this.bgk.a(paramm);
      this.bgi.reset();
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
    final com.google.android.exoplayer2.c.m aXw;
    long bfQ;
    long bfY;
    boolean bfZ;
    boolean bgc;
    final boolean bgf;
    final boolean bgg;
    private final SparseArray<k.b> bgm;
    private final SparseArray<k.a> bgn;
    private final com.google.android.exoplayer2.i.n bgo;
    int bgp;
    int bgq;
    long bgr;
    long bgs;
    a bgt;
    a bgu;
    boolean bgv;
    private byte[] buffer;
    
    public a(com.google.android.exoplayer2.c.m paramm, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92239);
      this.aXw = paramm;
      this.bgf = paramBoolean1;
      this.bgg = paramBoolean2;
      this.bgm = new SparseArray();
      this.bgn = new SparseArray();
      this.bgt = new a((byte)0);
      this.bgu = new a((byte)0);
      this.buffer = new byte[''];
      this.bgo = new com.google.android.exoplayer2.i.n(this.buffer, 0, 0);
      reset();
      AppMethodBeat.o(92239);
    }
    
    public final void a(k.a parama)
    {
      AppMethodBeat.i(92241);
      this.bgn.append(parama.bgB, parama);
      AppMethodBeat.o(92241);
    }
    
    public final void a(k.b paramb)
    {
      AppMethodBeat.i(92240);
      this.bgm.append(paramb.byW, paramb);
      AppMethodBeat.o(92240);
    }
    
    public final void f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92243);
      if (!this.bgc)
      {
        AppMethodBeat.o(92243);
        return;
      }
      paramInt2 -= paramInt1;
      if (this.buffer.length < this.bgp + paramInt2) {
        this.buffer = Arrays.copyOf(this.buffer, (this.bgp + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.bgp, paramInt2);
      this.bgp = (paramInt2 + this.bgp);
      this.bgo.m(this.buffer, 0, this.bgp);
      if (!this.bgo.fn(8))
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.bgo.vH();
      int i3 = this.bgo.eo(2);
      this.bgo.ep(5);
      if (!this.bgo.vU())
      {
        AppMethodBeat.o(92243);
        return;
      }
      this.bgo.vW();
      if (!this.bgo.vU())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i4 = this.bgo.vW();
      if (!this.bgg)
      {
        this.bgc = false;
        this.bgu.er(i4);
        AppMethodBeat.o(92243);
        return;
      }
      if (!this.bgo.vU())
      {
        AppMethodBeat.o(92243);
        return;
      }
      int i5 = this.bgo.vW();
      if (this.bgn.indexOfKey(i5) < 0)
      {
        this.bgc = false;
        AppMethodBeat.o(92243);
        return;
      }
      paramArrayOfByte = (k.a)this.bgn.get(i5);
      k.b localb = (k.b)this.bgm.get(paramArrayOfByte.byW);
      if (localb.byZ)
      {
        if (!this.bgo.fn(2))
        {
          AppMethodBeat.o(92243);
          return;
        }
        this.bgo.ep(2);
      }
      if (!this.bgo.fn(localb.bzb))
      {
        AppMethodBeat.o(92243);
        return;
      }
      boolean bool2 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      int i6 = this.bgo.eo(localb.bzb);
      boolean bool3 = bool5;
      boolean bool1 = bool6;
      if (!localb.bza)
      {
        if (!this.bgo.fn(1))
        {
          AppMethodBeat.o(92243);
          return;
        }
        bool4 = this.bgo.sV();
        bool2 = bool4;
        bool3 = bool5;
        bool1 = bool6;
        if (bool4)
        {
          if (!this.bgo.fn(1))
          {
            AppMethodBeat.o(92243);
            return;
          }
          bool1 = this.bgo.sV();
          bool3 = true;
          bool2 = bool4;
        }
      }
      if (this.bgq == 5) {}
      for (boolean bool4 = true;; bool4 = false)
      {
        paramInt1 = 0;
        if (!bool4) {
          break label508;
        }
        if (this.bgo.vU()) {
          break;
        }
        AppMethodBeat.o(92243);
        return;
      }
      paramInt1 = this.bgo.vW();
      label508:
      int i1 = 0;
      int m = 0;
      int i2 = 0;
      int n = 0;
      int i;
      int j;
      int k;
      if (localb.bzc == 0)
      {
        if (!this.bgo.fn(localb.bzd))
        {
          AppMethodBeat.o(92243);
          return;
        }
        i1 = this.bgo.eo(localb.bzd);
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (paramArrayOfByte.byX)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!bool2)
          {
            if (!this.bgo.vU())
            {
              AppMethodBeat.o(92243);
              return;
            }
            j = this.bgo.vV();
            k = n;
            paramInt2 = i2;
            i = i1;
          }
        }
      }
      for (;;)
      {
        this.bgu.a(localb, i3, i4, i6, i5, bool2, bool3, bool1, bool4, paramInt1, i, j, paramInt2, k);
        this.bgc = false;
        AppMethodBeat.o(92243);
        return;
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (localb.bzc == 1)
        {
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (!localb.bze)
          {
            if (!this.bgo.vU())
            {
              AppMethodBeat.o(92243);
              return;
            }
            i2 = this.bgo.vV();
            i = i1;
            j = m;
            paramInt2 = i2;
            k = n;
            if (paramArrayOfByte.byX)
            {
              i = i1;
              j = m;
              paramInt2 = i2;
              k = n;
              if (!bool2)
              {
                if (!this.bgo.vU())
                {
                  AppMethodBeat.o(92243);
                  return;
                }
                k = this.bgo.vV();
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
      this.bgc = false;
      this.bgv = false;
      this.bgu.clear();
      AppMethodBeat.o(92242);
    }
    
    static final class a
    {
      int bgA;
      int bgB;
      boolean bgC;
      boolean bgD;
      boolean bgE;
      boolean bgF;
      int bgG;
      int bgH;
      int bgI;
      int bgJ;
      int bgK;
      boolean bgw;
      boolean bgx;
      k.b bgy;
      int bgz;
      int frameNum;
      
      public final void a(k.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
      {
        this.bgy = paramb;
        this.bgz = paramInt1;
        this.bgA = paramInt2;
        this.frameNum = paramInt3;
        this.bgB = paramInt4;
        this.bgC = paramBoolean1;
        this.bgD = paramBoolean2;
        this.bgE = paramBoolean3;
        this.bgF = paramBoolean4;
        this.bgG = paramInt5;
        this.bgH = paramInt6;
        this.bgI = paramInt7;
        this.bgJ = paramInt8;
        this.bgK = paramInt9;
        this.bgw = true;
        this.bgx = true;
      }
      
      public final void clear()
      {
        this.bgx = false;
        this.bgw = false;
      }
      
      public final void er(int paramInt)
      {
        this.bgA = paramInt;
        this.bgx = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.j
 * JD-Core Version:    0.7.0.1
 */