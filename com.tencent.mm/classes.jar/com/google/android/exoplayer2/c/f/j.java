package com.google.android.exoplayer2.c.f;

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
  private boolean aBO;
  private com.google.android.exoplayer2.c.m aCe;
  private final s aKF;
  private final boolean aKG;
  private final boolean aKH;
  private final n aKI;
  private final n aKJ;
  private final n aKK;
  private j.a aKL;
  private final com.google.android.exoplayer2.i.m aKM;
  private String aKf;
  private final boolean[] aKu;
  private long aKw;
  private long aKy;
  
  public j(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(95122);
    this.aKF = params;
    this.aKG = paramBoolean1;
    this.aKH = paramBoolean2;
    this.aKu = new boolean[3];
    this.aKI = new n(7);
    this.aKJ = new n(8);
    this.aKK = new n(6);
    this.aKM = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(95122);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95126);
    if ((!this.aBO) || (this.aKL.aKH))
    {
      this.aKI.f(paramArrayOfByte, paramInt1, paramInt2);
      this.aKJ.f(paramArrayOfByte, paramInt1, paramInt2);
    }
    this.aKK.f(paramArrayOfByte, paramInt1, paramInt2);
    this.aKL.f(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(95126);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(95124);
    paramd.ox();
    this.aKf = paramd.oz();
    this.aCe = paramg.dm(paramd.oy());
    this.aKL = new j.a(this.aCe, this.aKG, this.aKH);
    this.aKF.a(paramg, paramd);
    AppMethodBeat.o(95124);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aKy = paramLong;
  }
  
  public final void ol()
  {
    AppMethodBeat.i(95123);
    k.a(this.aKu);
    this.aKI.reset();
    this.aKJ.reset();
    this.aKK.reset();
    this.aKL.reset();
    this.aKw = 0L;
    AppMethodBeat.o(95123);
  }
  
  public final void om() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95125);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte = paramm.data;
    this.aKw += paramm.qM();
    this.aCe.a(paramm, paramm.qM());
    int k = k.a(arrayOfByte, i, j, this.aKu);
    if (k == j)
    {
      e(arrayOfByte, i, j);
      AppMethodBeat.o(95125);
      return;
    }
    int m = k.i(arrayOfByte, k);
    int i1 = k - i;
    if (i1 > 0) {
      e(arrayOfByte, i, k);
    }
    int n = j - k;
    long l1 = this.aKw - n;
    label136:
    long l2;
    Object localObject1;
    label370:
    int i3;
    if (i1 < 0)
    {
      i = -i1;
      l2 = this.aKy;
      Object localObject2;
      if ((!this.aBO) || (this.aKL.aKH))
      {
        this.aKI.dJ(i);
        this.aKJ.dJ(i);
        if (this.aBO) {
          break label1060;
        }
        if ((this.aKI.aLC) && (this.aKJ.aLC))
        {
          paramm = new ArrayList();
          paramm.add(Arrays.copyOf(this.aKI.nalData, this.aKI.aLD));
          paramm.add(Arrays.copyOf(this.aKJ.nalData, this.aKJ.aLD));
          localObject1 = k.k(this.aKI.nalData, 3, this.aKI.aLD);
          localObject2 = k.k(this.aKJ.nalData, this.aKJ.aLD);
          this.aCe.f(Format.a(this.aKf, "video/avc", ((k.b)localObject1).width, ((k.b)localObject1).height, paramm, ((k.b)localObject1).baX));
          this.aBO = true;
          this.aKL.a((k.b)localObject1);
          this.aKL.a((k.a)localObject2);
          this.aKI.reset();
          this.aKJ.reset();
        }
      }
      if (this.aKK.dJ(i))
      {
        i = k.h(this.aKK.nalData, this.aKK.aLD);
        this.aKM.l(this.aKK.nalData, i);
        this.aKM.setPosition(4);
        this.aKF.a(l2, this.aKM);
      }
      paramm = this.aKL;
      if (paramm.aKR != 9)
      {
        if (paramm.aKH)
        {
          localObject1 = paramm.aKV;
          localObject2 = paramm.aKU;
          if ((!((j.a.a)localObject1).aKX) || ((((j.a.a)localObject2).aKX) && (((j.a.a)localObject1).frameNum == ((j.a.a)localObject2).frameNum) && (((j.a.a)localObject1).aLc == ((j.a.a)localObject2).aLc) && (((j.a.a)localObject1).aLd == ((j.a.a)localObject2).aLd) && ((!((j.a.a)localObject1).aLe) || (!((j.a.a)localObject2).aLe) || (((j.a.a)localObject1).aLf == ((j.a.a)localObject2).aLf)) && ((((j.a.a)localObject1).aLa == ((j.a.a)localObject2).aLa) || ((((j.a.a)localObject1).aLa != 0) && (((j.a.a)localObject2).aLa != 0))) && ((((j.a.a)localObject1).aKZ.bbb != 0) || (((j.a.a)localObject2).aKZ.bbb != 0) || ((((j.a.a)localObject1).aLi == ((j.a.a)localObject2).aLi) && (((j.a.a)localObject1).aLj == ((j.a.a)localObject2).aLj))) && ((((j.a.a)localObject1).aKZ.bbb != 1) || (((j.a.a)localObject2).aKZ.bbb != 1) || ((((j.a.a)localObject1).aLk == ((j.a.a)localObject2).aLk) && (((j.a.a)localObject1).aLl == ((j.a.a)localObject2).aLl))) && (((j.a.a)localObject1).aLg == ((j.a.a)localObject2).aLg) && ((!((j.a.a)localObject1).aLg) || (!((j.a.a)localObject2).aLg) || (((j.a.a)localObject1).aLh == ((j.a.a)localObject2).aLh)))) {
            break label1153;
          }
          i = 1;
          label723:
          if (i == 0) {}
        }
      }
      else
      {
        if (paramm.aKW)
        {
          i1 = (int)(l1 - paramm.aKS);
          if (!paramm.aKA) {
            break label1158;
          }
          i = 1;
          label753:
          int i2 = (int)(paramm.aKS - paramm.aKz);
          paramm.aCe.a(paramm.aKr, i, i2, n + i1, null);
        }
        paramm.aKz = paramm.aKS;
        paramm.aKr = paramm.aKT;
        paramm.aKA = false;
        paramm.aKW = true;
      }
      i3 = paramm.aKA;
      if (paramm.aKR != 5)
      {
        if ((!paramm.aKG) || (paramm.aKR != 1)) {
          break label1168;
        }
        localObject1 = paramm.aKV;
        if ((!((j.a.a)localObject1).aKY) || ((((j.a.a)localObject1).aLb != 7) && (((j.a.a)localObject1).aLb != 2))) {
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
      paramm.aKA = (i | i3);
      l2 = this.aKy;
      if ((!this.aBO) || (this.aKL.aKH))
      {
        this.aKI.dI(m);
        this.aKJ.dI(m);
      }
      this.aKK.dI(m);
      paramm = this.aKL;
      paramm.aKR = m;
      paramm.aKT = l2;
      paramm.aKS = l1;
      if (((paramm.aKG) && (paramm.aKR == 1)) || ((paramm.aKH) && ((paramm.aKR == 5) || (paramm.aKR == 1) || (paramm.aKR == 2))))
      {
        localObject1 = paramm.aKU;
        paramm.aKU = paramm.aKV;
        paramm.aKV = ((j.a.a)localObject1);
        paramm.aKV.clear();
        paramm.aKQ = 0;
        paramm.aKD = true;
      }
      i = k + 3;
      break;
      i = 0;
      break label136;
      label1060:
      if (this.aKI.aLC)
      {
        paramm = k.k(this.aKI.nalData, 3, this.aKI.aLD);
        this.aKL.a(paramm);
        this.aKI.reset();
        break label370;
      }
      if (!this.aKJ.aLC) {
        break label370;
      }
      paramm = k.k(this.aKJ.nalData, this.aKJ.aLD);
      this.aKL.a(paramm);
      this.aKJ.reset();
      break label370;
      i = 0;
      break label723;
      i = 0;
      break label753;
      i = 0;
      break label877;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.j
 * JD-Core Version:    0.7.0.1
 */