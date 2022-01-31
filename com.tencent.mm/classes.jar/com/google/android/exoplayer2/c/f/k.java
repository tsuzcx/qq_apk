package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class k
  implements h
{
  private boolean aBO;
  private com.google.android.exoplayer2.c.m aCe;
  private final s aKF;
  private final n aKI;
  private final n aKJ;
  private final com.google.android.exoplayer2.i.m aKM;
  private String aKf;
  private final boolean[] aKu;
  private long aKw;
  private long aKy;
  private k.a aLm;
  private final n aLn;
  private final n aLo;
  private final n aLp;
  
  public k(s params)
  {
    AppMethodBeat.i(95128);
    this.aKF = params;
    this.aKu = new boolean[3];
    this.aLn = new n(32);
    this.aKI = new n(33);
    this.aKJ = new n(34);
    this.aLo = new n(39);
    this.aLp = new n(40);
    this.aKM = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(95128);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95132);
    if (this.aBO) {
      this.aLm.g(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.aLo.f(paramArrayOfByte, paramInt1, paramInt2);
      this.aLp.f(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(95132);
      return;
      this.aLn.f(paramArrayOfByte, paramInt1, paramInt2);
      this.aKI.f(paramArrayOfByte, paramInt1, paramInt2);
      this.aKJ.f(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(95130);
    paramd.ox();
    this.aKf = paramd.oz();
    this.aCe = paramg.dm(paramd.oy());
    this.aLm = new k.a(this.aCe);
    this.aKF.a(paramg, paramd);
    AppMethodBeat.o(95130);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aKy = paramLong;
  }
  
  public final void ol()
  {
    AppMethodBeat.i(95129);
    com.google.android.exoplayer2.i.k.a(this.aKu);
    this.aLn.reset();
    this.aKI.reset();
    this.aKJ.reset();
    this.aLo.reset();
    this.aLp.reset();
    k.a locala = this.aLm;
    locala.aLs = false;
    locala.aLt = false;
    locala.aLu = false;
    locala.aKW = false;
    locala.aLv = false;
    this.aKw = 0L;
    AppMethodBeat.o(95129);
  }
  
  public final void om() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95131);
    int i;
    label58:
    int i5;
    int j;
    label161:
    Object localObject1;
    boolean bool;
    label453:
    label483:
    label508:
    String str;
    label515:
    label542:
    label548:
    label628:
    Object localObject2;
    byte[] arrayOfByte2;
    int n;
    int m;
    int i2;
    int i1;
    int i9;
    int i7;
    if (paramm.qM() > 0)
    {
      i = paramm.position;
      int i3 = paramm.limit;
      byte[] arrayOfByte1 = paramm.data;
      this.aKw += paramm.qM();
      this.aCe.a(paramm, paramm.qM());
      int i4;
      int i6;
      long l1;
      int k;
      long l2;
      if (i < i3)
      {
        i4 = com.google.android.exoplayer2.i.k.a(arrayOfByte1, i, i3, this.aKu);
        if (i4 == i3)
        {
          e(arrayOfByte1, i, i3);
          AppMethodBeat.o(95131);
          return;
        }
        i5 = com.google.android.exoplayer2.i.k.j(arrayOfByte1, i4);
        j = i4 - i;
        if (j > 0) {
          e(arrayOfByte1, i, i4);
        }
        i6 = i3 - i4;
        l1 = this.aKw - i6;
        if (j >= 0) {
          break label542;
        }
        k = -j;
        l2 = this.aKy;
        if (!this.aBO) {
          break label628;
        }
        localObject1 = this.aLm;
        if ((!((k.a)localObject1).aLv) || (!((k.a)localObject1).aLt)) {
          break label548;
        }
        ((k.a)localObject1).aKA = ((k.a)localObject1).aLq;
        ((k.a)localObject1).aLv = false;
      }
      do
      {
        for (;;)
        {
          if (this.aLo.dJ(k))
          {
            i = com.google.android.exoplayer2.i.k.h(this.aLo.nalData, this.aLo.aLD);
            this.aKM.l(this.aLo.nalData, i);
            this.aKM.en(5);
            this.aKF.a(l2, this.aKM);
          }
          if (this.aLp.dJ(k))
          {
            i = com.google.android.exoplayer2.i.k.h(this.aLp.nalData, this.aLp.aLD);
            this.aKM.l(this.aLp.nalData, i);
            this.aKM.en(5);
            this.aKF.a(l2, this.aKM);
          }
          l2 = this.aKy;
          if (!this.aBO) {
            break label1743;
          }
          localObject1 = this.aLm;
          ((k.a)localObject1).aLt = false;
          ((k.a)localObject1).aLu = false;
          ((k.a)localObject1).aKT = l2;
          ((k.a)localObject1).aLr = 0;
          ((k.a)localObject1).aKS = l1;
          if (i5 >= 32)
          {
            if ((!((k.a)localObject1).aLv) && (((k.a)localObject1).aKW))
            {
              ((k.a)localObject1).dH(i6);
              ((k.a)localObject1).aKW = false;
            }
            if (i5 <= 34)
            {
              if (((k.a)localObject1).aLv) {
                break label1725;
              }
              bool = true;
              ((k.a)localObject1).aLu = bool;
              ((k.a)localObject1).aLv = true;
            }
          }
          if ((i5 < 16) || (i5 > 21)) {
            break label1731;
          }
          bool = true;
          ((k.a)localObject1).aLq = bool;
          if ((!((k.a)localObject1).aLq) && (i5 > 9)) {
            break label1737;
          }
          bool = true;
          ((k.a)localObject1).aLs = bool;
          this.aLo.dI(i5);
          this.aLp.dI(i5);
          i = i4 + 3;
          break label58;
          break;
          k = 0;
          break label161;
          if ((((k.a)localObject1).aLu) || (((k.a)localObject1).aLt))
          {
            if (((k.a)localObject1).aKW) {
              ((k.a)localObject1).dH((int)(l1 - ((k.a)localObject1).aKS) + i6);
            }
            ((k.a)localObject1).aKz = ((k.a)localObject1).aKS;
            ((k.a)localObject1).aKr = ((k.a)localObject1).aKT;
            ((k.a)localObject1).aKW = true;
            ((k.a)localObject1).aKA = ((k.a)localObject1).aLq;
          }
        }
        this.aLn.dJ(k);
        this.aKI.dJ(k);
        this.aKJ.dJ(k);
      } while ((!this.aLn.aLC) || (!this.aKI.aLC) || (!this.aKJ.aLC));
      localObject1 = this.aCe;
      str = this.aKf;
      localObject2 = this.aLn;
      n localn1 = this.aKI;
      n localn2 = this.aKJ;
      arrayOfByte2 = new byte[((n)localObject2).aLD + localn1.aLD + localn2.aLD];
      System.arraycopy(((n)localObject2).nalData, 0, arrayOfByte2, 0, ((n)localObject2).aLD);
      System.arraycopy(localn1.nalData, 0, arrayOfByte2, ((n)localObject2).aLD, localn1.aLD);
      System.arraycopy(localn2.nalData, 0, arrayOfByte2, ((n)localObject2).aLD + localn1.aLD, localn2.aLD);
      localObject2 = new com.google.android.exoplayer2.i.n(localn1.nalData, 0, localn1.aLD);
      ((com.google.android.exoplayer2.i.n)localObject2).dE(44);
      n = ((com.google.android.exoplayer2.i.n)localObject2).dD(3);
      ((com.google.android.exoplayer2.i.n)localObject2).qK();
      ((com.google.android.exoplayer2.i.n)localObject2).dE(88);
      ((com.google.android.exoplayer2.i.n)localObject2).dE(8);
      i = 0;
      m = 0;
      while (m < n)
      {
        j = i;
        if (((com.google.android.exoplayer2.i.n)localObject2).oj()) {
          j = i + 89;
        }
        i = j;
        if (((com.google.android.exoplayer2.i.n)localObject2).oj()) {
          i = j + 8;
        }
        m += 1;
      }
      ((com.google.android.exoplayer2.i.n)localObject2).dE(i);
      if (n > 0) {
        ((com.google.android.exoplayer2.i.n)localObject2).dE((8 - n) * 2);
      }
      ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      int i10 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      if (i10 == 3) {
        ((com.google.android.exoplayer2.i.n)localObject2).qK();
      }
      i2 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      m = i2;
      j = i1;
      if (((com.google.android.exoplayer2.i.n)localObject2).oj())
      {
        m = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        i9 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        i8 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        if ((i10 == 1) || (i10 == 2))
        {
          i = 2;
          if (i10 != 1) {
            break label1144;
          }
          j = 2;
          label1048:
          m = i2 - i * (m + i9);
          j = i1 - j * (i7 + i8);
        }
      }
      else
      {
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        if (!((com.google.android.exoplayer2.i.n)localObject2).oj()) {
          break label1150;
        }
        i = 0;
      }
      for (;;)
      {
        if (i > n) {
          break label1157;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        i += 1;
        continue;
        i = 1;
        break;
        label1144:
        j = 1;
        break label1048;
        label1150:
        i = n;
      }
      label1157:
      ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      if ((((com.google.android.exoplayer2.i.n)localObject2).oj()) && (((com.google.android.exoplayer2.i.n)localObject2).oj()))
      {
        i = 0;
        while (i < 4)
        {
          n = 0;
          if (n < 6)
          {
            if (!((com.google.android.exoplayer2.i.n)localObject2).oj())
            {
              ((com.google.android.exoplayer2.i.n)localObject2).qZ();
              label1242:
              if (i != 3) {
                break label1313;
              }
            }
            label1313:
            for (i1 = 3;; i1 = 1)
            {
              n = i1 + n;
              break;
              i2 = Math.min(64, 1 << (i << 1) + 4);
              if (i > 1) {
                ((com.google.android.exoplayer2.i.n)localObject2).qY();
              }
              i1 = 0;
              while (i1 < i2)
              {
                ((com.google.android.exoplayer2.i.n)localObject2).qY();
                i1 += 1;
              }
              break label1242;
            }
          }
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).dE(2);
      if (((com.google.android.exoplayer2.i.n)localObject2).oj())
      {
        ((com.google.android.exoplayer2.i.n)localObject2).dE(8);
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        ((com.google.android.exoplayer2.i.n)localObject2).qK();
      }
      int i8 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      bool = false;
      i1 = 0;
      i = 0;
      label1382:
      if (i < i8)
      {
        if (i == 0) {
          break label1784;
        }
        bool = ((com.google.android.exoplayer2.i.n)localObject2).oj();
      }
    }
    label1725:
    label1731:
    label1737:
    label1743:
    label1784:
    for (;;)
    {
      if (bool)
      {
        ((com.google.android.exoplayer2.i.n)localObject2).qK();
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        i2 = 0;
        for (;;)
        {
          n = i1;
          if (i2 > i1) {
            break;
          }
          if (((com.google.android.exoplayer2.i.n)localObject2).oj()) {
            ((com.google.android.exoplayer2.i.n)localObject2).qK();
          }
          i2 += 1;
        }
      }
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      i9 = ((com.google.android.exoplayer2.i.n)localObject2).qZ();
      i2 = i1 + i9;
      n = 0;
      while (n < i1)
      {
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        ((com.google.android.exoplayer2.i.n)localObject2).qK();
        n += 1;
      }
      i1 = 0;
      for (;;)
      {
        n = i2;
        if (i1 >= i9) {
          break;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).qZ();
        ((com.google.android.exoplayer2.i.n)localObject2).qK();
        i1 += 1;
      }
      i += 1;
      i1 = n;
      break label1382;
      if (((com.google.android.exoplayer2.i.n)localObject2).oj())
      {
        i = 0;
        while (i < ((com.google.android.exoplayer2.i.n)localObject2).qZ())
        {
          ((com.google.android.exoplayer2.i.n)localObject2).dE(i7 + 4 + 1);
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).dE(2);
      float f2 = 1.0F;
      float f1;
      if ((((com.google.android.exoplayer2.i.n)localObject2).oj()) && (((com.google.android.exoplayer2.i.n)localObject2).oj()))
      {
        i = ((com.google.android.exoplayer2.i.n)localObject2).dD(8);
        if (i == 255)
        {
          i = ((com.google.android.exoplayer2.i.n)localObject2).dD(16);
          n = ((com.google.android.exoplayer2.i.n)localObject2).dD(16);
          f1 = f2;
          if (i != 0)
          {
            f1 = f2;
            if (n != 0) {
              f1 = i / n;
            }
          }
        }
      }
      for (;;)
      {
        ((com.google.android.exoplayer2.c.m)localObject1).f(Format.a(str, "video/hevc", m, j, Collections.singletonList(arrayOfByte2), f1));
        this.aBO = true;
        break;
        if (i < com.google.android.exoplayer2.i.k.baS.length)
        {
          f1 = com.google.android.exoplayer2.i.k.baS[i];
          continue;
          bool = false;
          break label453;
          bool = false;
          break label483;
          bool = false;
          break label508;
          this.aLn.dI(i5);
          this.aKI.dI(i5);
          this.aKJ.dI(i5);
          break label515;
          AppMethodBeat.o(95131);
          return;
        }
        f1 = 1.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.k
 * JD-Core Version:    0.7.0.1
 */