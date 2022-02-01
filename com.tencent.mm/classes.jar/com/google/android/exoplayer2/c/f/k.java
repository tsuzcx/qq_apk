package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class k
  implements h
{
  private boolean cLK;
  private com.google.android.exoplayer2.c.m cMa;
  private String cTX;
  private final n cUA;
  private final com.google.android.exoplayer2.i.m cUD;
  private final boolean[] cUl;
  private long cUn;
  private long cUp;
  private final s cUw;
  private final n cUz;
  private a cVd;
  private final n cVe;
  private final n cVf;
  private final n cVg;
  
  public k(s params)
  {
    AppMethodBeat.i(92250);
    this.cUw = params;
    this.cUl = new boolean[3];
    this.cVe = new n(32);
    this.cUz = new n(33);
    this.cUA = new n(34);
    this.cVf = new n(39);
    this.cVg = new n(40);
    this.cUD = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92250);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92254);
    if (this.cLK) {
      this.cVd.g(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.cVf.f(paramArrayOfByte, paramInt1, paramInt2);
      this.cVg.f(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(92254);
      return;
      this.cVe.f(paramArrayOfByte, paramInt1, paramInt2);
      this.cUz.f(paramArrayOfByte, paramInt1, paramInt2);
      this.cUA.f(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final void Si()
  {
    AppMethodBeat.i(92251);
    com.google.android.exoplayer2.i.k.c(this.cUl);
    this.cVe.reset();
    this.cUz.reset();
    this.cUA.reset();
    this.cVf.reset();
    this.cVg.reset();
    a locala = this.cVd;
    locala.cVj = false;
    locala.cVk = false;
    locala.cVl = false;
    locala.cUN = false;
    locala.cVm = false;
    this.cUn = 0L;
    AppMethodBeat.o(92251);
  }
  
  public final void Sj() {}
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92252);
    paramd.Sv();
    this.cTX = paramd.Sw();
    this.cMa = paramg.hz(paramd.getTrackId());
    this.cVd = new a(this.cMa);
    this.cUw.a(paramg, paramd);
    AppMethodBeat.o(92252);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    this.cUp = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92253);
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
    if (paramm.UF() > 0)
    {
      i = paramm.position;
      int i3 = paramm.limit;
      byte[] arrayOfByte1 = paramm.data;
      this.cUn += paramm.UF();
      this.cMa.a(paramm, paramm.UF());
      int i4;
      int i6;
      long l1;
      int k;
      long l2;
      if (i < i3)
      {
        i4 = com.google.android.exoplayer2.i.k.a(arrayOfByte1, i, i3, this.cUl);
        if (i4 == i3)
        {
          e(arrayOfByte1, i, i3);
          AppMethodBeat.o(92253);
          return;
        }
        i5 = com.google.android.exoplayer2.i.k.l(arrayOfByte1, i4);
        j = i4 - i;
        if (j > 0) {
          e(arrayOfByte1, i, i4);
        }
        i6 = i3 - i4;
        l1 = this.cUn - i6;
        if (j >= 0) {
          break label542;
        }
        k = -j;
        l2 = this.cUp;
        if (!this.cLK) {
          break label628;
        }
        localObject1 = this.cVd;
        if ((!((a)localObject1).cVm) || (!((a)localObject1).cVk)) {
          break label548;
        }
        ((a)localObject1).cUr = ((a)localObject1).cVh;
        ((a)localObject1).cVm = false;
      }
      do
      {
        for (;;)
        {
          if (this.cVf.hX(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.cVf.nalData, this.cVf.cVu);
            this.cUD.n(this.cVf.nalData, i);
            this.cUD.iH(5);
            this.cUw.a(l2, this.cUD);
          }
          if (this.cVg.hX(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.cVg.nalData, this.cVg.cVu);
            this.cUD.n(this.cVg.nalData, i);
            this.cUD.iH(5);
            this.cUw.a(l2, this.cUD);
          }
          l2 = this.cUp;
          if (!this.cLK) {
            break label1743;
          }
          localObject1 = this.cVd;
          ((a)localObject1).cVk = false;
          ((a)localObject1).cVl = false;
          ((a)localObject1).cUK = l2;
          ((a)localObject1).cVi = 0;
          ((a)localObject1).cUJ = l1;
          if (i5 >= 32)
          {
            if ((!((a)localObject1).cVm) && (((a)localObject1).cUN))
            {
              ((a)localObject1).hV(i6);
              ((a)localObject1).cUN = false;
            }
            if (i5 <= 34)
            {
              if (((a)localObject1).cVm) {
                break label1725;
              }
              bool = true;
              ((a)localObject1).cVl = bool;
              ((a)localObject1).cVm = true;
            }
          }
          if ((i5 < 16) || (i5 > 21)) {
            break label1731;
          }
          bool = true;
          ((a)localObject1).cVh = bool;
          if ((!((a)localObject1).cVh) && (i5 > 9)) {
            break label1737;
          }
          bool = true;
          ((a)localObject1).cVj = bool;
          this.cVf.hW(i5);
          this.cVg.hW(i5);
          i = i4 + 3;
          break label58;
          break;
          k = 0;
          break label161;
          if ((((a)localObject1).cVl) || (((a)localObject1).cVk))
          {
            if (((a)localObject1).cUN) {
              ((a)localObject1).hV((int)(l1 - ((a)localObject1).cUJ) + i6);
            }
            ((a)localObject1).cUq = ((a)localObject1).cUJ;
            ((a)localObject1).cUj = ((a)localObject1).cUK;
            ((a)localObject1).cUN = true;
            ((a)localObject1).cUr = ((a)localObject1).cVh;
          }
        }
        this.cVe.hX(k);
        this.cUz.hX(k);
        this.cUA.hX(k);
      } while ((!this.cVe.cVt) || (!this.cUz.cVt) || (!this.cUA.cVt));
      localObject1 = this.cMa;
      str = this.cTX;
      localObject2 = this.cVe;
      n localn1 = this.cUz;
      n localn2 = this.cUA;
      arrayOfByte2 = new byte[((n)localObject2).cVu + localn1.cVu + localn2.cVu];
      System.arraycopy(((n)localObject2).nalData, 0, arrayOfByte2, 0, ((n)localObject2).cVu);
      System.arraycopy(localn1.nalData, 0, arrayOfByte2, ((n)localObject2).cVu, localn1.cVu);
      System.arraycopy(localn2.nalData, 0, arrayOfByte2, ((n)localObject2).cVu + localn1.cVu, localn2.cVu);
      localObject2 = new com.google.android.exoplayer2.i.n(localn1.nalData, 0, localn1.cVu);
      ((com.google.android.exoplayer2.i.n)localObject2).hR(44);
      n = ((com.google.android.exoplayer2.i.n)localObject2).hQ(3);
      ((com.google.android.exoplayer2.i.n)localObject2).UD();
      ((com.google.android.exoplayer2.i.n)localObject2).hR(88);
      ((com.google.android.exoplayer2.i.n)localObject2).hR(8);
      i = 0;
      m = 0;
      while (m < n)
      {
        j = i;
        if (((com.google.android.exoplayer2.i.n)localObject2).Sg()) {
          j = i + 89;
        }
        i = j;
        if (((com.google.android.exoplayer2.i.n)localObject2).Sg()) {
          i = j + 8;
        }
        m += 1;
      }
      ((com.google.android.exoplayer2.i.n)localObject2).hR(i);
      if (n > 0) {
        ((com.google.android.exoplayer2.i.n)localObject2).hR((8 - n) * 2);
      }
      ((com.google.android.exoplayer2.i.n)localObject2).UT();
      int i10 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
      if (i10 == 3) {
        ((com.google.android.exoplayer2.i.n)localObject2).UD();
      }
      i2 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
      m = i2;
      j = i1;
      if (((com.google.android.exoplayer2.i.n)localObject2).Sg())
      {
        m = ((com.google.android.exoplayer2.i.n)localObject2).UT();
        i9 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
        i8 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
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
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
        if (!((com.google.android.exoplayer2.i.n)localObject2).Sg()) {
          break label1150;
        }
        i = 0;
      }
      for (;;)
      {
        if (i > n) {
          break label1157;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
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
      ((com.google.android.exoplayer2.i.n)localObject2).UT();
      ((com.google.android.exoplayer2.i.n)localObject2).UT();
      ((com.google.android.exoplayer2.i.n)localObject2).UT();
      ((com.google.android.exoplayer2.i.n)localObject2).UT();
      ((com.google.android.exoplayer2.i.n)localObject2).UT();
      ((com.google.android.exoplayer2.i.n)localObject2).UT();
      if ((((com.google.android.exoplayer2.i.n)localObject2).Sg()) && (((com.google.android.exoplayer2.i.n)localObject2).Sg()))
      {
        i = 0;
        while (i < 4)
        {
          n = 0;
          if (n < 6)
          {
            if (!((com.google.android.exoplayer2.i.n)localObject2).Sg())
            {
              ((com.google.android.exoplayer2.i.n)localObject2).UT();
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
                ((com.google.android.exoplayer2.i.n)localObject2).US();
              }
              i1 = 0;
              while (i1 < i2)
              {
                ((com.google.android.exoplayer2.i.n)localObject2).US();
                i1 += 1;
              }
              break label1242;
            }
          }
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).hR(2);
      if (((com.google.android.exoplayer2.i.n)localObject2).Sg())
      {
        ((com.google.android.exoplayer2.i.n)localObject2).hR(8);
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        ((com.google.android.exoplayer2.i.n)localObject2).UD();
      }
      int i8 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
      bool = false;
      i1 = 0;
      i = 0;
      label1382:
      if (i < i8)
      {
        if (i == 0) {
          break label1784;
        }
        bool = ((com.google.android.exoplayer2.i.n)localObject2).Sg();
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
        ((com.google.android.exoplayer2.i.n)localObject2).UD();
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        i2 = 0;
        for (;;)
        {
          n = i1;
          if (i2 > i1) {
            break;
          }
          if (((com.google.android.exoplayer2.i.n)localObject2).Sg()) {
            ((com.google.android.exoplayer2.i.n)localObject2).UD();
          }
          i2 += 1;
        }
      }
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
      i9 = ((com.google.android.exoplayer2.i.n)localObject2).UT();
      i2 = i1 + i9;
      n = 0;
      while (n < i1)
      {
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        ((com.google.android.exoplayer2.i.n)localObject2).UD();
        n += 1;
      }
      i1 = 0;
      for (;;)
      {
        n = i2;
        if (i1 >= i9) {
          break;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).UT();
        ((com.google.android.exoplayer2.i.n)localObject2).UD();
        i1 += 1;
      }
      i += 1;
      i1 = n;
      break label1382;
      if (((com.google.android.exoplayer2.i.n)localObject2).Sg())
      {
        i = 0;
        while (i < ((com.google.android.exoplayer2.i.n)localObject2).UT())
        {
          ((com.google.android.exoplayer2.i.n)localObject2).hR(i7 + 4 + 1);
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).hR(2);
      float f2 = 1.0F;
      float f1;
      if ((((com.google.android.exoplayer2.i.n)localObject2).Sg()) && (((com.google.android.exoplayer2.i.n)localObject2).Sg()))
      {
        i = ((com.google.android.exoplayer2.i.n)localObject2).hQ(8);
        if (i == 255)
        {
          i = ((com.google.android.exoplayer2.i.n)localObject2).hQ(16);
          n = ((com.google.android.exoplayer2.i.n)localObject2).hQ(16);
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
        this.cLK = true;
        break;
        if (i < com.google.android.exoplayer2.i.k.dkt.length)
        {
          f1 = com.google.android.exoplayer2.i.k.dkt[i];
          continue;
          bool = false;
          break label453;
          bool = false;
          break label483;
          bool = false;
          break label508;
          this.cVe.hW(i5);
          this.cUz.hW(i5);
          this.cUA.hW(i5);
          break label515;
          AppMethodBeat.o(92253);
          return;
        }
        f1 = 1.0F;
      }
    }
  }
  
  static final class a
  {
    private final com.google.android.exoplayer2.c.m cMa;
    long cUJ;
    long cUK;
    boolean cUN;
    long cUj;
    long cUq;
    boolean cUr;
    boolean cVh;
    int cVi;
    boolean cVj;
    boolean cVk;
    boolean cVl;
    boolean cVm;
    
    public a(com.google.android.exoplayer2.c.m paramm)
    {
      this.cMa = paramm;
    }
    
    public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.cVj)
      {
        int i = paramInt1 + 2 - this.cVi;
        if (i >= paramInt2) {
          break label55;
        }
        if ((paramArrayOfByte[i] & 0x80) == 0) {
          break label49;
        }
      }
      label49:
      for (boolean bool = true;; bool = false)
      {
        this.cVk = bool;
        this.cVj = false;
        return;
      }
      label55:
      this.cVi += paramInt2 - paramInt1;
    }
    
    final void hV(int paramInt)
    {
      AppMethodBeat.i(92249);
      if (this.cUr) {}
      for (int i = 1;; i = 0)
      {
        int j = (int)(this.cUJ - this.cUq);
        this.cMa.a(this.cUj, i, j, paramInt, null);
        AppMethodBeat.o(92249);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.k
 * JD-Core Version:    0.7.0.1
 */