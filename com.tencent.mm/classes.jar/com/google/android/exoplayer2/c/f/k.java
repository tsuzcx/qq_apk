package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class k
  implements h
{
  private boolean aRO;
  private com.google.android.exoplayer2.c.m aSe;
  private final s baB;
  private final n baE;
  private final n baF;
  private final com.google.android.exoplayer2.i.m baI;
  private String bac;
  private final boolean[] baq;
  private long bas;
  private long bau;
  private a bbi;
  private final n bbj;
  private final n bbk;
  private final n bbl;
  
  public k(s params)
  {
    AppMethodBeat.i(92250);
    this.baB = params;
    this.baq = new boolean[3];
    this.bbj = new n(32);
    this.baE = new n(33);
    this.baF = new n(34);
    this.bbk = new n(39);
    this.bbl = new n(40);
    this.baI = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92250);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92254);
    if (this.aRO) {
      this.bbi.g(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.bbk.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bbl.f(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(92254);
      return;
      this.bbj.f(paramArrayOfByte, paramInt1, paramInt2);
      this.baE.f(paramArrayOfByte, paramInt1, paramInt2);
      this.baF.f(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92252);
    paramd.sR();
    this.bac = paramd.sS();
    this.aSe = paramg.ej(paramd.getTrackId());
    this.bbi = new a(this.aSe);
    this.baB.a(paramg, paramd);
    AppMethodBeat.o(92252);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bau = paramLong;
  }
  
  public final void sF()
  {
    AppMethodBeat.i(92251);
    com.google.android.exoplayer2.i.k.b(this.baq);
    this.bbj.reset();
    this.baE.reset();
    this.baF.reset();
    this.bbk.reset();
    this.bbl.reset();
    a locala = this.bbi;
    locala.bbo = false;
    locala.bbp = false;
    locala.bbq = false;
    locala.baS = false;
    locala.bbr = false;
    this.bas = 0L;
    AppMethodBeat.o(92251);
  }
  
  public final void sG() {}
  
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
    if (paramm.vg() > 0)
    {
      i = paramm.position;
      int i3 = paramm.limit;
      byte[] arrayOfByte1 = paramm.data;
      this.bas += paramm.vg();
      this.aSe.a(paramm, paramm.vg());
      int i4;
      int i6;
      long l1;
      int k;
      long l2;
      if (i < i3)
      {
        i4 = com.google.android.exoplayer2.i.k.a(arrayOfByte1, i, i3, this.baq);
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
        l1 = this.bas - i6;
        if (j >= 0) {
          break label542;
        }
        k = -j;
        l2 = this.bau;
        if (!this.aRO) {
          break label628;
        }
        localObject1 = this.bbi;
        if ((!((a)localObject1).bbr) || (!((a)localObject1).bbp)) {
          break label548;
        }
        ((a)localObject1).baw = ((a)localObject1).bbm;
        ((a)localObject1).bbr = false;
      }
      do
      {
        for (;;)
        {
          if (this.bbk.eH(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.bbk.nalData, this.bbk.bbz);
            this.baI.n(this.bbk.nalData, i);
            this.baI.fu(5);
            this.baB.a(l2, this.baI);
          }
          if (this.bbl.eH(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.bbl.nalData, this.bbl.bbz);
            this.baI.n(this.bbl.nalData, i);
            this.baI.fu(5);
            this.baB.a(l2, this.baI);
          }
          l2 = this.bau;
          if (!this.aRO) {
            break label1743;
          }
          localObject1 = this.bbi;
          ((a)localObject1).bbp = false;
          ((a)localObject1).bbq = false;
          ((a)localObject1).baP = l2;
          ((a)localObject1).bbn = 0;
          ((a)localObject1).baO = l1;
          if (i5 >= 32)
          {
            if ((!((a)localObject1).bbr) && (((a)localObject1).baS))
            {
              ((a)localObject1).eF(i6);
              ((a)localObject1).baS = false;
            }
            if (i5 <= 34)
            {
              if (((a)localObject1).bbr) {
                break label1725;
              }
              bool = true;
              ((a)localObject1).bbq = bool;
              ((a)localObject1).bbr = true;
            }
          }
          if ((i5 < 16) || (i5 > 21)) {
            break label1731;
          }
          bool = true;
          ((a)localObject1).bbm = bool;
          if ((!((a)localObject1).bbm) && (i5 > 9)) {
            break label1737;
          }
          bool = true;
          ((a)localObject1).bbo = bool;
          this.bbk.eG(i5);
          this.bbl.eG(i5);
          i = i4 + 3;
          break label58;
          break;
          k = 0;
          break label161;
          if ((((a)localObject1).bbq) || (((a)localObject1).bbp))
          {
            if (((a)localObject1).baS) {
              ((a)localObject1).eF((int)(l1 - ((a)localObject1).baO) + i6);
            }
            ((a)localObject1).bav = ((a)localObject1).baO;
            ((a)localObject1).bao = ((a)localObject1).baP;
            ((a)localObject1).baS = true;
            ((a)localObject1).baw = ((a)localObject1).bbm;
          }
        }
        this.bbj.eH(k);
        this.baE.eH(k);
        this.baF.eH(k);
      } while ((!this.bbj.bby) || (!this.baE.bby) || (!this.baF.bby));
      localObject1 = this.aSe;
      str = this.bac;
      localObject2 = this.bbj;
      n localn1 = this.baE;
      n localn2 = this.baF;
      arrayOfByte2 = new byte[((n)localObject2).bbz + localn1.bbz + localn2.bbz];
      System.arraycopy(((n)localObject2).nalData, 0, arrayOfByte2, 0, ((n)localObject2).bbz);
      System.arraycopy(localn1.nalData, 0, arrayOfByte2, ((n)localObject2).bbz, localn1.bbz);
      System.arraycopy(localn2.nalData, 0, arrayOfByte2, ((n)localObject2).bbz + localn1.bbz, localn2.bbz);
      localObject2 = new com.google.android.exoplayer2.i.n(localn1.nalData, 0, localn1.bbz);
      ((com.google.android.exoplayer2.i.n)localObject2).eB(44);
      n = ((com.google.android.exoplayer2.i.n)localObject2).eA(3);
      ((com.google.android.exoplayer2.i.n)localObject2).ve();
      ((com.google.android.exoplayer2.i.n)localObject2).eB(88);
      ((com.google.android.exoplayer2.i.n)localObject2).eB(8);
      i = 0;
      m = 0;
      while (m < n)
      {
        j = i;
        if (((com.google.android.exoplayer2.i.n)localObject2).sD()) {
          j = i + 89;
        }
        i = j;
        if (((com.google.android.exoplayer2.i.n)localObject2).sD()) {
          i = j + 8;
        }
        m += 1;
      }
      ((com.google.android.exoplayer2.i.n)localObject2).eB(i);
      if (n > 0) {
        ((com.google.android.exoplayer2.i.n)localObject2).eB((8 - n) * 2);
      }
      ((com.google.android.exoplayer2.i.n)localObject2).vu();
      int i10 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
      if (i10 == 3) {
        ((com.google.android.exoplayer2.i.n)localObject2).ve();
      }
      i2 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
      m = i2;
      j = i1;
      if (((com.google.android.exoplayer2.i.n)localObject2).sD())
      {
        m = ((com.google.android.exoplayer2.i.n)localObject2).vu();
        i9 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
        i8 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
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
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
        if (!((com.google.android.exoplayer2.i.n)localObject2).sD()) {
          break label1150;
        }
        i = 0;
      }
      for (;;)
      {
        if (i > n) {
          break label1157;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
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
      ((com.google.android.exoplayer2.i.n)localObject2).vu();
      ((com.google.android.exoplayer2.i.n)localObject2).vu();
      ((com.google.android.exoplayer2.i.n)localObject2).vu();
      ((com.google.android.exoplayer2.i.n)localObject2).vu();
      ((com.google.android.exoplayer2.i.n)localObject2).vu();
      ((com.google.android.exoplayer2.i.n)localObject2).vu();
      if ((((com.google.android.exoplayer2.i.n)localObject2).sD()) && (((com.google.android.exoplayer2.i.n)localObject2).sD()))
      {
        i = 0;
        while (i < 4)
        {
          n = 0;
          if (n < 6)
          {
            if (!((com.google.android.exoplayer2.i.n)localObject2).sD())
            {
              ((com.google.android.exoplayer2.i.n)localObject2).vu();
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
                ((com.google.android.exoplayer2.i.n)localObject2).vt();
              }
              i1 = 0;
              while (i1 < i2)
              {
                ((com.google.android.exoplayer2.i.n)localObject2).vt();
                i1 += 1;
              }
              break label1242;
            }
          }
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).eB(2);
      if (((com.google.android.exoplayer2.i.n)localObject2).sD())
      {
        ((com.google.android.exoplayer2.i.n)localObject2).eB(8);
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        ((com.google.android.exoplayer2.i.n)localObject2).ve();
      }
      int i8 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
      bool = false;
      i1 = 0;
      i = 0;
      label1382:
      if (i < i8)
      {
        if (i == 0) {
          break label1784;
        }
        bool = ((com.google.android.exoplayer2.i.n)localObject2).sD();
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
        ((com.google.android.exoplayer2.i.n)localObject2).ve();
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        i2 = 0;
        for (;;)
        {
          n = i1;
          if (i2 > i1) {
            break;
          }
          if (((com.google.android.exoplayer2.i.n)localObject2).sD()) {
            ((com.google.android.exoplayer2.i.n)localObject2).ve();
          }
          i2 += 1;
        }
      }
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
      i9 = ((com.google.android.exoplayer2.i.n)localObject2).vu();
      i2 = i1 + i9;
      n = 0;
      while (n < i1)
      {
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        ((com.google.android.exoplayer2.i.n)localObject2).ve();
        n += 1;
      }
      i1 = 0;
      for (;;)
      {
        n = i2;
        if (i1 >= i9) {
          break;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).vu();
        ((com.google.android.exoplayer2.i.n)localObject2).ve();
        i1 += 1;
      }
      i += 1;
      i1 = n;
      break label1382;
      if (((com.google.android.exoplayer2.i.n)localObject2).sD())
      {
        i = 0;
        while (i < ((com.google.android.exoplayer2.i.n)localObject2).vu())
        {
          ((com.google.android.exoplayer2.i.n)localObject2).eB(i7 + 4 + 1);
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).eB(2);
      float f2 = 1.0F;
      float f1;
      if ((((com.google.android.exoplayer2.i.n)localObject2).sD()) && (((com.google.android.exoplayer2.i.n)localObject2).sD()))
      {
        i = ((com.google.android.exoplayer2.i.n)localObject2).eA(8);
        if (i == 255)
        {
          i = ((com.google.android.exoplayer2.i.n)localObject2).eA(16);
          n = ((com.google.android.exoplayer2.i.n)localObject2).eA(16);
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
        this.aRO = true;
        break;
        if (i < com.google.android.exoplayer2.i.k.bqP.length)
        {
          f1 = com.google.android.exoplayer2.i.k.bqP[i];
          continue;
          bool = false;
          break label453;
          bool = false;
          break label483;
          bool = false;
          break label508;
          this.bbj.eG(i5);
          this.baE.eG(i5);
          this.baF.eG(i5);
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
    private final com.google.android.exoplayer2.c.m aSe;
    long baO;
    long baP;
    boolean baS;
    long bao;
    long bav;
    boolean baw;
    boolean bbm;
    int bbn;
    boolean bbo;
    boolean bbp;
    boolean bbq;
    boolean bbr;
    
    public a(com.google.android.exoplayer2.c.m paramm)
    {
      this.aSe = paramm;
    }
    
    final void eF(int paramInt)
    {
      AppMethodBeat.i(92249);
      if (this.baw) {}
      for (int i = 1;; i = 0)
      {
        int j = (int)(this.baO - this.bav);
        this.aSe.a(this.bao, i, j, paramInt, null);
        AppMethodBeat.o(92249);
        return;
      }
    }
    
    public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.bbo)
      {
        int i = paramInt1 + 2 - this.bbn;
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
        this.bbp = bool;
        this.bbo = false;
        return;
      }
      label55:
      this.bbn += paramInt2 - paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.k
 * JD-Core Version:    0.7.0.1
 */