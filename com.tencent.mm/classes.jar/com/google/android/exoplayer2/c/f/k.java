package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class k
  implements h
{
  private com.google.android.exoplayer2.c.m biA;
  private boolean bik;
  private String bqA;
  private final boolean[] bqO;
  private long bqQ;
  private long bqS;
  private final s bqZ;
  private a brG;
  private final n brH;
  private final n brI;
  private final n brJ;
  private final n brc;
  private final n brd;
  private final com.google.android.exoplayer2.i.m brg;
  
  public k(s params)
  {
    AppMethodBeat.i(92250);
    this.bqZ = params;
    this.bqO = new boolean[3];
    this.brH = new n(32);
    this.brc = new n(33);
    this.brd = new n(34);
    this.brI = new n(39);
    this.brJ = new n(40);
    this.brg = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92250);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92254);
    if (this.bik) {
      this.brG.g(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.brI.f(paramArrayOfByte, paramInt1, paramInt2);
      this.brJ.f(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(92254);
      return;
      this.brH.f(paramArrayOfByte, paramInt1, paramInt2);
      this.brc.f(paramArrayOfByte, paramInt1, paramInt2);
      this.brd.f(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92252);
    paramd.uW();
    this.bqA = paramd.uX();
    this.biA = paramg.dV(paramd.getTrackId());
    this.brG = new a(this.biA);
    this.bqZ.a(paramg, paramd);
    AppMethodBeat.o(92252);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bqS = paramLong;
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
    if (paramm.xd() > 0)
    {
      i = paramm.position;
      int i3 = paramm.limit;
      byte[] arrayOfByte1 = paramm.data;
      this.bqQ += paramm.xd();
      this.biA.a(paramm, paramm.xd());
      int i4;
      int i6;
      long l1;
      int k;
      long l2;
      if (i < i3)
      {
        i4 = com.google.android.exoplayer2.i.k.a(arrayOfByte1, i, i3, this.bqO);
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
        l1 = this.bqQ - i6;
        if (j >= 0) {
          break label542;
        }
        k = -j;
        l2 = this.bqS;
        if (!this.bik) {
          break label628;
        }
        localObject1 = this.brG;
        if ((!((a)localObject1).brP) || (!((a)localObject1).brN)) {
          break label548;
        }
        ((a)localObject1).bqU = ((a)localObject1).brK;
        ((a)localObject1).brP = false;
      }
      do
      {
        for (;;)
        {
          if (this.brI.es(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.brI.nalData, this.brI.brX);
            this.brg.n(this.brI.nalData, i);
            this.brg.eZ(5);
            this.bqZ.a(l2, this.brg);
          }
          if (this.brJ.es(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.brJ.nalData, this.brJ.brX);
            this.brg.n(this.brJ.nalData, i);
            this.brg.eZ(5);
            this.bqZ.a(l2, this.brg);
          }
          l2 = this.bqS;
          if (!this.bik) {
            break label1743;
          }
          localObject1 = this.brG;
          ((a)localObject1).brN = false;
          ((a)localObject1).brO = false;
          ((a)localObject1).brn = l2;
          ((a)localObject1).brL = 0;
          ((a)localObject1).brm = l1;
          if (i5 >= 32)
          {
            if ((!((a)localObject1).brP) && (((a)localObject1).brq))
            {
              ((a)localObject1).eq(i6);
              ((a)localObject1).brq = false;
            }
            if (i5 <= 34)
            {
              if (((a)localObject1).brP) {
                break label1725;
              }
              bool = true;
              ((a)localObject1).brO = bool;
              ((a)localObject1).brP = true;
            }
          }
          if ((i5 < 16) || (i5 > 21)) {
            break label1731;
          }
          bool = true;
          ((a)localObject1).brK = bool;
          if ((!((a)localObject1).brK) && (i5 > 9)) {
            break label1737;
          }
          bool = true;
          ((a)localObject1).brM = bool;
          this.brI.er(i5);
          this.brJ.er(i5);
          i = i4 + 3;
          break label58;
          break;
          k = 0;
          break label161;
          if ((((a)localObject1).brO) || (((a)localObject1).brN))
          {
            if (((a)localObject1).brq) {
              ((a)localObject1).eq((int)(l1 - ((a)localObject1).brm) + i6);
            }
            ((a)localObject1).bqT = ((a)localObject1).brm;
            ((a)localObject1).bqM = ((a)localObject1).brn;
            ((a)localObject1).brq = true;
            ((a)localObject1).bqU = ((a)localObject1).brK;
          }
        }
        this.brH.es(k);
        this.brc.es(k);
        this.brd.es(k);
      } while ((!this.brH.brW) || (!this.brc.brW) || (!this.brd.brW));
      localObject1 = this.biA;
      str = this.bqA;
      localObject2 = this.brH;
      n localn1 = this.brc;
      n localn2 = this.brd;
      arrayOfByte2 = new byte[((n)localObject2).brX + localn1.brX + localn2.brX];
      System.arraycopy(((n)localObject2).nalData, 0, arrayOfByte2, 0, ((n)localObject2).brX);
      System.arraycopy(localn1.nalData, 0, arrayOfByte2, ((n)localObject2).brX, localn1.brX);
      System.arraycopy(localn2.nalData, 0, arrayOfByte2, ((n)localObject2).brX + localn1.brX, localn2.brX);
      localObject2 = new com.google.android.exoplayer2.i.n(localn1.nalData, 0, localn1.brX);
      ((com.google.android.exoplayer2.i.n)localObject2).en(44);
      n = ((com.google.android.exoplayer2.i.n)localObject2).em(3);
      ((com.google.android.exoplayer2.i.n)localObject2).xb();
      ((com.google.android.exoplayer2.i.n)localObject2).en(88);
      ((com.google.android.exoplayer2.i.n)localObject2).en(8);
      i = 0;
      m = 0;
      while (m < n)
      {
        j = i;
        if (((com.google.android.exoplayer2.i.n)localObject2).uI()) {
          j = i + 89;
        }
        i = j;
        if (((com.google.android.exoplayer2.i.n)localObject2).uI()) {
          i = j + 8;
        }
        m += 1;
      }
      ((com.google.android.exoplayer2.i.n)localObject2).en(i);
      if (n > 0) {
        ((com.google.android.exoplayer2.i.n)localObject2).en((8 - n) * 2);
      }
      ((com.google.android.exoplayer2.i.n)localObject2).xq();
      int i10 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
      if (i10 == 3) {
        ((com.google.android.exoplayer2.i.n)localObject2).xb();
      }
      i2 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
      m = i2;
      j = i1;
      if (((com.google.android.exoplayer2.i.n)localObject2).uI())
      {
        m = ((com.google.android.exoplayer2.i.n)localObject2).xq();
        i9 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
        i8 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
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
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
        if (!((com.google.android.exoplayer2.i.n)localObject2).uI()) {
          break label1150;
        }
        i = 0;
      }
      for (;;)
      {
        if (i > n) {
          break label1157;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
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
      ((com.google.android.exoplayer2.i.n)localObject2).xq();
      ((com.google.android.exoplayer2.i.n)localObject2).xq();
      ((com.google.android.exoplayer2.i.n)localObject2).xq();
      ((com.google.android.exoplayer2.i.n)localObject2).xq();
      ((com.google.android.exoplayer2.i.n)localObject2).xq();
      ((com.google.android.exoplayer2.i.n)localObject2).xq();
      if ((((com.google.android.exoplayer2.i.n)localObject2).uI()) && (((com.google.android.exoplayer2.i.n)localObject2).uI()))
      {
        i = 0;
        while (i < 4)
        {
          n = 0;
          if (n < 6)
          {
            if (!((com.google.android.exoplayer2.i.n)localObject2).uI())
            {
              ((com.google.android.exoplayer2.i.n)localObject2).xq();
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
                ((com.google.android.exoplayer2.i.n)localObject2).xp();
              }
              i1 = 0;
              while (i1 < i2)
              {
                ((com.google.android.exoplayer2.i.n)localObject2).xp();
                i1 += 1;
              }
              break label1242;
            }
          }
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).en(2);
      if (((com.google.android.exoplayer2.i.n)localObject2).uI())
      {
        ((com.google.android.exoplayer2.i.n)localObject2).en(8);
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        ((com.google.android.exoplayer2.i.n)localObject2).xb();
      }
      int i8 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
      bool = false;
      i1 = 0;
      i = 0;
      label1382:
      if (i < i8)
      {
        if (i == 0) {
          break label1784;
        }
        bool = ((com.google.android.exoplayer2.i.n)localObject2).uI();
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
        ((com.google.android.exoplayer2.i.n)localObject2).xb();
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        i2 = 0;
        for (;;)
        {
          n = i1;
          if (i2 > i1) {
            break;
          }
          if (((com.google.android.exoplayer2.i.n)localObject2).uI()) {
            ((com.google.android.exoplayer2.i.n)localObject2).xb();
          }
          i2 += 1;
        }
      }
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
      i9 = ((com.google.android.exoplayer2.i.n)localObject2).xq();
      i2 = i1 + i9;
      n = 0;
      while (n < i1)
      {
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        ((com.google.android.exoplayer2.i.n)localObject2).xb();
        n += 1;
      }
      i1 = 0;
      for (;;)
      {
        n = i2;
        if (i1 >= i9) {
          break;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).xq();
        ((com.google.android.exoplayer2.i.n)localObject2).xb();
        i1 += 1;
      }
      i += 1;
      i1 = n;
      break label1382;
      if (((com.google.android.exoplayer2.i.n)localObject2).uI())
      {
        i = 0;
        while (i < ((com.google.android.exoplayer2.i.n)localObject2).xq())
        {
          ((com.google.android.exoplayer2.i.n)localObject2).en(i7 + 4 + 1);
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).en(2);
      float f2 = 1.0F;
      float f1;
      if ((((com.google.android.exoplayer2.i.n)localObject2).uI()) && (((com.google.android.exoplayer2.i.n)localObject2).uI()))
      {
        i = ((com.google.android.exoplayer2.i.n)localObject2).em(8);
        if (i == 255)
        {
          i = ((com.google.android.exoplayer2.i.n)localObject2).em(16);
          n = ((com.google.android.exoplayer2.i.n)localObject2).em(16);
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
        this.bik = true;
        break;
        if (i < com.google.android.exoplayer2.i.k.bHg.length)
        {
          f1 = com.google.android.exoplayer2.i.k.bHg[i];
          continue;
          bool = false;
          break label453;
          bool = false;
          break label483;
          bool = false;
          break label508;
          this.brH.er(i5);
          this.brc.er(i5);
          this.brd.er(i5);
          break label515;
          AppMethodBeat.o(92253);
          return;
        }
        f1 = 1.0F;
      }
    }
  }
  
  public final void uK()
  {
    AppMethodBeat.i(92251);
    com.google.android.exoplayer2.i.k.a(this.bqO);
    this.brH.reset();
    this.brc.reset();
    this.brd.reset();
    this.brI.reset();
    this.brJ.reset();
    a locala = this.brG;
    locala.brM = false;
    locala.brN = false;
    locala.brO = false;
    locala.brq = false;
    locala.brP = false;
    this.bqQ = 0L;
    AppMethodBeat.o(92251);
  }
  
  public final void uL() {}
  
  static final class a
  {
    private final com.google.android.exoplayer2.c.m biA;
    long bqM;
    long bqT;
    boolean bqU;
    boolean brK;
    int brL;
    boolean brM;
    boolean brN;
    boolean brO;
    boolean brP;
    long brm;
    long brn;
    boolean brq;
    
    public a(com.google.android.exoplayer2.c.m paramm)
    {
      this.biA = paramm;
    }
    
    final void eq(int paramInt)
    {
      AppMethodBeat.i(92249);
      if (this.bqU) {}
      for (int i = 1;; i = 0)
      {
        int j = (int)(this.brm - this.bqT);
        this.biA.a(this.bqM, i, j, paramInt, null);
        AppMethodBeat.o(92249);
        return;
      }
    }
    
    public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.brM)
      {
        int i = paramInt1 + 2 - this.brL;
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
        this.brN = bool;
        this.brM = false;
        return;
      }
      label55:
      this.brL += paramInt2 - paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.k
 * JD-Core Version:    0.7.0.1
 */