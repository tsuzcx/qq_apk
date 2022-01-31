package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.j;
import java.util.Collections;

public final class k
  implements h
{
  private com.google.android.exoplayer2.c.k aCt;
  private final boolean[] aDJ;
  private long aDL;
  private long aDN;
  private final r aDU;
  private final n aDX;
  private final n aDY;
  private String aDt;
  private boolean aDx;
  private a aEB;
  private final n aEC;
  private final n aED;
  private final n aEE;
  private final j aEb;
  
  public k(r paramr)
  {
    this.aDU = paramr;
    this.aDJ = new boolean[3];
    this.aEC = new n(32);
    this.aDX = new n(33);
    this.aDY = new n(34);
    this.aED = new n(39);
    this.aEE = new n(40);
    this.aEb = new j();
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a locala;
    boolean bool;
    if (this.aDx)
    {
      locala = this.aEB;
      if (locala.aEH)
      {
        int i = paramInt1 + 2 - locala.aEG;
        if (i >= paramInt2) {
          break label92;
        }
        if ((paramArrayOfByte[i] & 0x80) == 0) {
          break label86;
        }
        bool = true;
        locala.aEI = bool;
        locala.aEH = false;
      }
    }
    for (;;)
    {
      this.aED.f(paramArrayOfByte, paramInt1, paramInt2);
      this.aEE.f(paramArrayOfByte, paramInt1, paramInt2);
      return;
      label86:
      bool = false;
      break;
      label92:
      locala.aEG += paramInt2 - paramInt1;
      continue;
      this.aEC.f(paramArrayOfByte, paramInt1, paramInt2);
      this.aDX.f(paramArrayOfByte, paramInt1, paramInt2);
      this.aDY.f(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final void a(f paramf, u.d paramd)
  {
    paramd.mg();
    this.aDt = paramd.mi();
    this.aCt = paramf.cQ(paramd.mh());
    this.aEB = new a(this.aCt);
    this.aDU.a(paramf, paramd);
  }
  
  public final void b(j paramj)
  {
    int i3;
    byte[] arrayOfByte1;
    int i4;
    while (paramj.oe() > 0)
    {
      i = paramj.position;
      i3 = paramj.limit;
      arrayOfByte1 = paramj.data;
      this.aDL += paramj.oe();
      this.aCt.a(paramj, paramj.oe());
      if (i < i3)
      {
        i4 = com.google.android.exoplayer2.i.h.a(arrayOfByte1, i, i3, this.aDJ);
        if (i4 != i3) {
          break label93;
        }
        e(arrayOfByte1, i, i3);
      }
    }
    return;
    label93:
    int i5 = com.google.android.exoplayer2.i.h.k(arrayOfByte1, i4);
    int j = i4 - i;
    if (j > 0) {
      e(arrayOfByte1, i, i4);
    }
    int i6 = i3 - i4;
    long l1 = this.aDL - i6;
    int k;
    label151:
    long l2;
    if (j < 0)
    {
      k = -j;
      l2 = this.aDN;
      if (!this.aDx) {
        break label618;
      }
      localObject1 = this.aEB;
      if ((!((a)localObject1).aEK) || (!((a)localObject1).aEI)) {
        break label538;
      }
      ((a)localObject1).aDP = ((a)localObject1).aEF;
      ((a)localObject1).aEK = false;
    }
    label443:
    label473:
    label498:
    label505:
    do
    {
      for (;;)
      {
        if (this.aED.dd(k))
        {
          i = com.google.android.exoplayer2.i.h.i(this.aED.aET, this.aED.aEU);
          this.aEb.m(this.aED.aET, i);
          this.aEb.dB(5);
          this.aDU.a(l2, this.aEb);
        }
        if (this.aEE.dd(k))
        {
          i = com.google.android.exoplayer2.i.h.i(this.aEE.aET, this.aEE.aEU);
          this.aEb.m(this.aEE.aET, i);
          this.aEb.dB(5);
          this.aDU.a(l2, this.aEb);
        }
        l2 = this.aDN;
        if (!this.aDx) {
          break label1732;
        }
        localObject1 = this.aEB;
        ((a)localObject1).aEI = false;
        ((a)localObject1).aEJ = false;
        ((a)localObject1).aEi = l2;
        ((a)localObject1).aEG = 0;
        ((a)localObject1).aEh = l1;
        if (i5 >= 32)
        {
          if ((!((a)localObject1).aEK) && (((a)localObject1).aEl))
          {
            ((a)localObject1).db(i6);
            ((a)localObject1).aEl = false;
          }
          if (i5 <= 34)
          {
            if (((a)localObject1).aEK) {
              break label1714;
            }
            bool = true;
            ((a)localObject1).aEJ = bool;
            ((a)localObject1).aEK = true;
          }
        }
        if ((i5 < 16) || (i5 > 21)) {
          break label1720;
        }
        bool = true;
        ((a)localObject1).aEF = bool;
        if ((!((a)localObject1).aEF) && (i5 > 9)) {
          break label1726;
        }
        bool = true;
        ((a)localObject1).aEH = bool;
        this.aED.dc(i5);
        this.aEE.dc(i5);
        i = i4 + 3;
        break;
        k = 0;
        break label151;
        if ((((a)localObject1).aEJ) || (((a)localObject1).aEI))
        {
          if (((a)localObject1).aEl) {
            ((a)localObject1).db((int)(l1 - ((a)localObject1).aEh) + i6);
          }
          ((a)localObject1).aDO = ((a)localObject1).aEh;
          ((a)localObject1).aDG = ((a)localObject1).aEi;
          ((a)localObject1).aEl = true;
          ((a)localObject1).aDP = ((a)localObject1).aEF;
        }
      }
      this.aEC.dd(k);
      this.aDX.dd(k);
      this.aDY.dd(k);
    } while ((!this.aEC.aES) || (!this.aDX.aES) || (!this.aDY.aES));
    label538:
    label618:
    Object localObject1 = this.aCt;
    String str = this.aDt;
    Object localObject2 = this.aEC;
    n localn1 = this.aDX;
    n localn2 = this.aDY;
    byte[] arrayOfByte2 = new byte[((n)localObject2).aEU + localn1.aEU + localn2.aEU];
    System.arraycopy(((n)localObject2).aET, 0, arrayOfByte2, 0, ((n)localObject2).aEU);
    System.arraycopy(localn1.aET, 0, arrayOfByte2, ((n)localObject2).aEU, localn1.aEU);
    System.arraycopy(localn2.aET, 0, arrayOfByte2, ((n)localObject2).aEU + localn1.aEU, localn2.aEU);
    localObject2 = new com.google.android.exoplayer2.i.k(localn1.aET, 0, localn1.aEU);
    ((com.google.android.exoplayer2.i.k)localObject2).dy(44);
    int n = ((com.google.android.exoplayer2.i.k)localObject2).dz(3);
    ((com.google.android.exoplayer2.i.k)localObject2).ok();
    ((com.google.android.exoplayer2.i.k)localObject2).dy(88);
    ((com.google.android.exoplayer2.i.k)localObject2).dy(8);
    int i = 0;
    int m = 0;
    while (m < n)
    {
      j = i;
      if (((com.google.android.exoplayer2.i.k)localObject2).ob()) {
        j = i + 89;
      }
      i = j;
      if (((com.google.android.exoplayer2.i.k)localObject2).ob()) {
        i = j + 8;
      }
      m += 1;
    }
    ((com.google.android.exoplayer2.i.k)localObject2).dy(i);
    if (n > 0) {
      ((com.google.android.exoplayer2.i.k)localObject2).dy((8 - n) * 2);
    }
    ((com.google.android.exoplayer2.i.k)localObject2).on();
    int i10 = ((com.google.android.exoplayer2.i.k)localObject2).on();
    if (i10 == 3) {
      ((com.google.android.exoplayer2.i.k)localObject2).ok();
    }
    int i2 = ((com.google.android.exoplayer2.i.k)localObject2).on();
    int i1 = ((com.google.android.exoplayer2.i.k)localObject2).on();
    m = i2;
    j = i1;
    int i9;
    int i7;
    if (((com.google.android.exoplayer2.i.k)localObject2).ob())
    {
      m = ((com.google.android.exoplayer2.i.k)localObject2).on();
      i9 = ((com.google.android.exoplayer2.i.k)localObject2).on();
      i7 = ((com.google.android.exoplayer2.i.k)localObject2).on();
      i8 = ((com.google.android.exoplayer2.i.k)localObject2).on();
      if ((i10 == 1) || (i10 == 2))
      {
        i = 2;
        if (i10 != 1) {
          break label1134;
        }
        j = 2;
        label1038:
        m = i2 - i * (m + i9);
        j = i1 - j * (i7 + i8);
      }
    }
    else
    {
      ((com.google.android.exoplayer2.i.k)localObject2).on();
      ((com.google.android.exoplayer2.i.k)localObject2).on();
      i7 = ((com.google.android.exoplayer2.i.k)localObject2).on();
      if (!((com.google.android.exoplayer2.i.k)localObject2).ob()) {
        break label1140;
      }
      i = 0;
    }
    for (;;)
    {
      if (i > n) {
        break label1147;
      }
      ((com.google.android.exoplayer2.i.k)localObject2).on();
      ((com.google.android.exoplayer2.i.k)localObject2).on();
      ((com.google.android.exoplayer2.i.k)localObject2).on();
      i += 1;
      continue;
      i = 1;
      break;
      label1134:
      j = 1;
      break label1038;
      label1140:
      i = n;
    }
    label1147:
    ((com.google.android.exoplayer2.i.k)localObject2).on();
    ((com.google.android.exoplayer2.i.k)localObject2).on();
    ((com.google.android.exoplayer2.i.k)localObject2).on();
    ((com.google.android.exoplayer2.i.k)localObject2).on();
    ((com.google.android.exoplayer2.i.k)localObject2).on();
    ((com.google.android.exoplayer2.i.k)localObject2).on();
    if ((((com.google.android.exoplayer2.i.k)localObject2).ob()) && (((com.google.android.exoplayer2.i.k)localObject2).ob()))
    {
      i = 0;
      while (i < 4)
      {
        n = 0;
        if (n < 6)
        {
          if (!((com.google.android.exoplayer2.i.k)localObject2).ob())
          {
            ((com.google.android.exoplayer2.i.k)localObject2).on();
            label1232:
            if (i != 3) {
              break label1303;
            }
          }
          label1303:
          for (i1 = 3;; i1 = 1)
          {
            n = i1 + n;
            break;
            i2 = Math.min(64, 1 << (i << 1) + 4);
            if (i > 1) {
              ((com.google.android.exoplayer2.i.k)localObject2).om();
            }
            i1 = 0;
            while (i1 < i2)
            {
              ((com.google.android.exoplayer2.i.k)localObject2).om();
              i1 += 1;
            }
            break label1232;
          }
        }
        i += 1;
      }
    }
    ((com.google.android.exoplayer2.i.k)localObject2).dy(2);
    if (((com.google.android.exoplayer2.i.k)localObject2).ob())
    {
      ((com.google.android.exoplayer2.i.k)localObject2).dy(8);
      ((com.google.android.exoplayer2.i.k)localObject2).on();
      ((com.google.android.exoplayer2.i.k)localObject2).on();
      ((com.google.android.exoplayer2.i.k)localObject2).ok();
    }
    int i8 = ((com.google.android.exoplayer2.i.k)localObject2).on();
    boolean bool = false;
    i1 = 0;
    i = 0;
    label1372:
    if (i < i8)
    {
      if (i == 0) {
        break label1767;
      }
      bool = ((com.google.android.exoplayer2.i.k)localObject2).ob();
    }
    label1714:
    label1720:
    label1726:
    label1732:
    label1767:
    for (;;)
    {
      if (bool)
      {
        ((com.google.android.exoplayer2.i.k)localObject2).ok();
        ((com.google.android.exoplayer2.i.k)localObject2).on();
        i2 = 0;
        for (;;)
        {
          n = i1;
          if (i2 > i1) {
            break;
          }
          if (((com.google.android.exoplayer2.i.k)localObject2).ob()) {
            ((com.google.android.exoplayer2.i.k)localObject2).ok();
          }
          i2 += 1;
        }
      }
      i1 = ((com.google.android.exoplayer2.i.k)localObject2).on();
      i9 = ((com.google.android.exoplayer2.i.k)localObject2).on();
      i2 = i1 + i9;
      n = 0;
      while (n < i1)
      {
        ((com.google.android.exoplayer2.i.k)localObject2).on();
        ((com.google.android.exoplayer2.i.k)localObject2).ok();
        n += 1;
      }
      i1 = 0;
      for (;;)
      {
        n = i2;
        if (i1 >= i9) {
          break;
        }
        ((com.google.android.exoplayer2.i.k)localObject2).on();
        ((com.google.android.exoplayer2.i.k)localObject2).ok();
        i1 += 1;
      }
      i += 1;
      i1 = n;
      break label1372;
      if (((com.google.android.exoplayer2.i.k)localObject2).ob())
      {
        i = 0;
        while (i < ((com.google.android.exoplayer2.i.k)localObject2).on())
        {
          ((com.google.android.exoplayer2.i.k)localObject2).dy(i7 + 4 + 1);
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.k)localObject2).dy(2);
      float f2 = 1.0F;
      float f1;
      if ((((com.google.android.exoplayer2.i.k)localObject2).ob()) && (((com.google.android.exoplayer2.i.k)localObject2).ob()))
      {
        i = ((com.google.android.exoplayer2.i.k)localObject2).dz(8);
        if (i == 255)
        {
          i = ((com.google.android.exoplayer2.i.k)localObject2).dz(16);
          n = ((com.google.android.exoplayer2.i.k)localObject2).dz(16);
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
        ((com.google.android.exoplayer2.c.k)localObject1).f(Format.a(str, "video/hevc", m, j, Collections.singletonList(arrayOfByte2), f1));
        this.aDx = true;
        break;
        if (i < com.google.android.exoplayer2.i.h.aSo.length)
        {
          f1 = com.google.android.exoplayer2.i.h.aSo[i];
          continue;
          bool = false;
          break label443;
          bool = false;
          break label473;
          bool = false;
          break label498;
          this.aEC.dc(i5);
          this.aDX.dc(i5);
          this.aDY.dc(i5);
          break label505;
        }
        f1 = 1.0F;
      }
    }
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aDN = paramLong;
  }
  
  public final void lY()
  {
    com.google.android.exoplayer2.i.h.b(this.aDJ);
    this.aEC.reset();
    this.aDX.reset();
    this.aDY.reset();
    this.aED.reset();
    this.aEE.reset();
    a locala = this.aEB;
    locala.aEH = false;
    locala.aEI = false;
    locala.aEJ = false;
    locala.aEl = false;
    locala.aEK = false;
    this.aDL = 0L;
  }
  
  public final void lZ() {}
  
  private static final class a
  {
    private final com.google.android.exoplayer2.c.k aCt;
    long aDG;
    long aDO;
    boolean aDP;
    boolean aEF;
    int aEG;
    boolean aEH;
    boolean aEI;
    boolean aEJ;
    boolean aEK;
    long aEh;
    long aEi;
    boolean aEl;
    
    public a(com.google.android.exoplayer2.c.k paramk)
    {
      this.aCt = paramk;
    }
    
    final void db(int paramInt)
    {
      if (this.aDP) {}
      for (int i = 1;; i = 0)
      {
        int j = (int)(this.aEh - this.aDO);
        this.aCt.a(this.aDG, i, j, paramInt, null);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.k
 * JD-Core Version:    0.7.0.1
 */