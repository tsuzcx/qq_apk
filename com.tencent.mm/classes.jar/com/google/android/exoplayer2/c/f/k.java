package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class k
  implements h
{
  private com.google.android.exoplayer2.c.m biD;
  private boolean bin;
  private String bqF;
  private final boolean[] bqT;
  private long bqV;
  private long bqX;
  private a brL;
  private final n brM;
  private final n brN;
  private final n brO;
  private final s bre;
  private final n brh;
  private final n bri;
  private final com.google.android.exoplayer2.i.m brl;
  
  public k(s params)
  {
    AppMethodBeat.i(92250);
    this.bre = params;
    this.bqT = new boolean[3];
    this.brM = new n(32);
    this.brh = new n(33);
    this.bri = new n(34);
    this.brN = new n(39);
    this.brO = new n(40);
    this.brl = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92250);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92254);
    if (this.bin) {
      this.brL.g(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.brN.f(paramArrayOfByte, paramInt1, paramInt2);
      this.brO.f(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(92254);
      return;
      this.brM.f(paramArrayOfByte, paramInt1, paramInt2);
      this.brh.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bri.f(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92252);
    paramd.uR();
    this.bqF = paramd.uS();
    this.biD = paramg.eb(paramd.getTrackId());
    this.brL = new a(this.biD);
    this.bre.a(paramg, paramd);
    AppMethodBeat.o(92252);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bqX = paramLong;
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
    if (paramm.wV() > 0)
    {
      i = paramm.position;
      int i3 = paramm.limit;
      byte[] arrayOfByte1 = paramm.data;
      this.bqV += paramm.wV();
      this.biD.a(paramm, paramm.wV());
      int i4;
      int i6;
      long l1;
      int k;
      long l2;
      if (i < i3)
      {
        i4 = com.google.android.exoplayer2.i.k.a(arrayOfByte1, i, i3, this.bqT);
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
        l1 = this.bqV - i6;
        if (j >= 0) {
          break label542;
        }
        k = -j;
        l2 = this.bqX;
        if (!this.bin) {
          break label628;
        }
        localObject1 = this.brL;
        if ((!((a)localObject1).brU) || (!((a)localObject1).brS)) {
          break label548;
        }
        ((a)localObject1).bqZ = ((a)localObject1).brP;
        ((a)localObject1).brU = false;
      }
      do
      {
        for (;;)
        {
          if (this.brN.ey(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.brN.nalData, this.brN.bsc);
            this.brl.n(this.brN.nalData, i);
            this.brl.fa(5);
            this.bre.a(l2, this.brl);
          }
          if (this.brO.ey(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.brO.nalData, this.brO.bsc);
            this.brl.n(this.brO.nalData, i);
            this.brl.fa(5);
            this.bre.a(l2, this.brl);
          }
          l2 = this.bqX;
          if (!this.bin) {
            break label1743;
          }
          localObject1 = this.brL;
          ((a)localObject1).brS = false;
          ((a)localObject1).brT = false;
          ((a)localObject1).brs = l2;
          ((a)localObject1).brQ = 0;
          ((a)localObject1).brr = l1;
          if (i5 >= 32)
          {
            if ((!((a)localObject1).brU) && (((a)localObject1).brv))
            {
              ((a)localObject1).ew(i6);
              ((a)localObject1).brv = false;
            }
            if (i5 <= 34)
            {
              if (((a)localObject1).brU) {
                break label1725;
              }
              bool = true;
              ((a)localObject1).brT = bool;
              ((a)localObject1).brU = true;
            }
          }
          if ((i5 < 16) || (i5 > 21)) {
            break label1731;
          }
          bool = true;
          ((a)localObject1).brP = bool;
          if ((!((a)localObject1).brP) && (i5 > 9)) {
            break label1737;
          }
          bool = true;
          ((a)localObject1).brR = bool;
          this.brN.ex(i5);
          this.brO.ex(i5);
          i = i4 + 3;
          break label58;
          break;
          k = 0;
          break label161;
          if ((((a)localObject1).brT) || (((a)localObject1).brS))
          {
            if (((a)localObject1).brv) {
              ((a)localObject1).ew((int)(l1 - ((a)localObject1).brr) + i6);
            }
            ((a)localObject1).bqY = ((a)localObject1).brr;
            ((a)localObject1).bqR = ((a)localObject1).brs;
            ((a)localObject1).brv = true;
            ((a)localObject1).bqZ = ((a)localObject1).brP;
          }
        }
        this.brM.ey(k);
        this.brh.ey(k);
        this.bri.ey(k);
      } while ((!this.brM.bsb) || (!this.brh.bsb) || (!this.bri.bsb));
      localObject1 = this.biD;
      str = this.bqF;
      localObject2 = this.brM;
      n localn1 = this.brh;
      n localn2 = this.bri;
      arrayOfByte2 = new byte[((n)localObject2).bsc + localn1.bsc + localn2.bsc];
      System.arraycopy(((n)localObject2).nalData, 0, arrayOfByte2, 0, ((n)localObject2).bsc);
      System.arraycopy(localn1.nalData, 0, arrayOfByte2, ((n)localObject2).bsc, localn1.bsc);
      System.arraycopy(localn2.nalData, 0, arrayOfByte2, ((n)localObject2).bsc + localn1.bsc, localn2.bsc);
      localObject2 = new com.google.android.exoplayer2.i.n(localn1.nalData, 0, localn1.bsc);
      ((com.google.android.exoplayer2.i.n)localObject2).et(44);
      n = ((com.google.android.exoplayer2.i.n)localObject2).es(3);
      ((com.google.android.exoplayer2.i.n)localObject2).wT();
      ((com.google.android.exoplayer2.i.n)localObject2).et(88);
      ((com.google.android.exoplayer2.i.n)localObject2).et(8);
      i = 0;
      m = 0;
      while (m < n)
      {
        j = i;
        if (((com.google.android.exoplayer2.i.n)localObject2).uD()) {
          j = i + 89;
        }
        i = j;
        if (((com.google.android.exoplayer2.i.n)localObject2).uD()) {
          i = j + 8;
        }
        m += 1;
      }
      ((com.google.android.exoplayer2.i.n)localObject2).et(i);
      if (n > 0) {
        ((com.google.android.exoplayer2.i.n)localObject2).et((8 - n) * 2);
      }
      ((com.google.android.exoplayer2.i.n)localObject2).xi();
      int i10 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
      if (i10 == 3) {
        ((com.google.android.exoplayer2.i.n)localObject2).wT();
      }
      i2 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
      m = i2;
      j = i1;
      if (((com.google.android.exoplayer2.i.n)localObject2).uD())
      {
        m = ((com.google.android.exoplayer2.i.n)localObject2).xi();
        i9 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
        i8 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
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
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
        if (!((com.google.android.exoplayer2.i.n)localObject2).uD()) {
          break label1150;
        }
        i = 0;
      }
      for (;;)
      {
        if (i > n) {
          break label1157;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
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
      ((com.google.android.exoplayer2.i.n)localObject2).xi();
      ((com.google.android.exoplayer2.i.n)localObject2).xi();
      ((com.google.android.exoplayer2.i.n)localObject2).xi();
      ((com.google.android.exoplayer2.i.n)localObject2).xi();
      ((com.google.android.exoplayer2.i.n)localObject2).xi();
      ((com.google.android.exoplayer2.i.n)localObject2).xi();
      if ((((com.google.android.exoplayer2.i.n)localObject2).uD()) && (((com.google.android.exoplayer2.i.n)localObject2).uD()))
      {
        i = 0;
        while (i < 4)
        {
          n = 0;
          if (n < 6)
          {
            if (!((com.google.android.exoplayer2.i.n)localObject2).uD())
            {
              ((com.google.android.exoplayer2.i.n)localObject2).xi();
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
                ((com.google.android.exoplayer2.i.n)localObject2).xh();
              }
              i1 = 0;
              while (i1 < i2)
              {
                ((com.google.android.exoplayer2.i.n)localObject2).xh();
                i1 += 1;
              }
              break label1242;
            }
          }
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).et(2);
      if (((com.google.android.exoplayer2.i.n)localObject2).uD())
      {
        ((com.google.android.exoplayer2.i.n)localObject2).et(8);
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        ((com.google.android.exoplayer2.i.n)localObject2).wT();
      }
      int i8 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
      bool = false;
      i1 = 0;
      i = 0;
      label1382:
      if (i < i8)
      {
        if (i == 0) {
          break label1784;
        }
        bool = ((com.google.android.exoplayer2.i.n)localObject2).uD();
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
        ((com.google.android.exoplayer2.i.n)localObject2).wT();
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        i2 = 0;
        for (;;)
        {
          n = i1;
          if (i2 > i1) {
            break;
          }
          if (((com.google.android.exoplayer2.i.n)localObject2).uD()) {
            ((com.google.android.exoplayer2.i.n)localObject2).wT();
          }
          i2 += 1;
        }
      }
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
      i9 = ((com.google.android.exoplayer2.i.n)localObject2).xi();
      i2 = i1 + i9;
      n = 0;
      while (n < i1)
      {
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        ((com.google.android.exoplayer2.i.n)localObject2).wT();
        n += 1;
      }
      i1 = 0;
      for (;;)
      {
        n = i2;
        if (i1 >= i9) {
          break;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).xi();
        ((com.google.android.exoplayer2.i.n)localObject2).wT();
        i1 += 1;
      }
      i += 1;
      i1 = n;
      break label1382;
      if (((com.google.android.exoplayer2.i.n)localObject2).uD())
      {
        i = 0;
        while (i < ((com.google.android.exoplayer2.i.n)localObject2).xi())
        {
          ((com.google.android.exoplayer2.i.n)localObject2).et(i7 + 4 + 1);
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).et(2);
      float f2 = 1.0F;
      float f1;
      if ((((com.google.android.exoplayer2.i.n)localObject2).uD()) && (((com.google.android.exoplayer2.i.n)localObject2).uD()))
      {
        i = ((com.google.android.exoplayer2.i.n)localObject2).es(8);
        if (i == 255)
        {
          i = ((com.google.android.exoplayer2.i.n)localObject2).es(16);
          n = ((com.google.android.exoplayer2.i.n)localObject2).es(16);
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
        this.bin = true;
        break;
        if (i < com.google.android.exoplayer2.i.k.bGP.length)
        {
          f1 = com.google.android.exoplayer2.i.k.bGP[i];
          continue;
          bool = false;
          break label453;
          bool = false;
          break label483;
          bool = false;
          break label508;
          this.brM.ex(i5);
          this.brh.ex(i5);
          this.bri.ex(i5);
          break label515;
          AppMethodBeat.o(92253);
          return;
        }
        f1 = 1.0F;
      }
    }
  }
  
  public final void uF()
  {
    AppMethodBeat.i(92251);
    com.google.android.exoplayer2.i.k.a(this.bqT);
    this.brM.reset();
    this.brh.reset();
    this.bri.reset();
    this.brN.reset();
    this.brO.reset();
    a locala = this.brL;
    locala.brR = false;
    locala.brS = false;
    locala.brT = false;
    locala.brv = false;
    locala.brU = false;
    this.bqV = 0L;
    AppMethodBeat.o(92251);
  }
  
  public final void uG() {}
  
  static final class a
  {
    private final com.google.android.exoplayer2.c.m biD;
    long bqR;
    long bqY;
    boolean bqZ;
    boolean brP;
    int brQ;
    boolean brR;
    boolean brS;
    boolean brT;
    boolean brU;
    long brr;
    long brs;
    boolean brv;
    
    public a(com.google.android.exoplayer2.c.m paramm)
    {
      this.biD = paramm;
    }
    
    final void ew(int paramInt)
    {
      AppMethodBeat.i(92249);
      if (this.bqZ) {}
      for (int i = 1;; i = 0)
      {
        int j = (int)(this.brr - this.bqY);
        this.biD.a(this.bqR, i, j, paramInt, null);
        AppMethodBeat.o(92249);
        return;
      }
    }
    
    public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.brR)
      {
        int i = paramInt1 + 2 - this.brQ;
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
        this.brS = bool;
        this.brR = false;
        return;
      }
      label55:
      this.brQ += paramInt2 - paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.k
 * JD-Core Version:    0.7.0.1
 */