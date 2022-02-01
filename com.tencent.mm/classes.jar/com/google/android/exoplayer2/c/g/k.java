package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class k
  implements h
{
  private boolean aXg;
  private com.google.android.exoplayer2.c.m aXw;
  private String bfE;
  private final boolean[] bfT;
  private long bfV;
  private long bfX;
  private a bgL;
  private final n bgM;
  private final n bgN;
  private final n bgO;
  private final s bge;
  private final n bgh;
  private final n bgi;
  private final com.google.android.exoplayer2.i.m bgl;
  
  public k(s params)
  {
    AppMethodBeat.i(92250);
    this.bge = params;
    this.bfT = new boolean[3];
    this.bgM = new n(32);
    this.bgh = new n(33);
    this.bgi = new n(34);
    this.bgN = new n(39);
    this.bgO = new n(40);
    this.bgl = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92250);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92254);
    if (this.aXg) {
      this.bgL.g(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.bgN.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bgO.f(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(92254);
      return;
      this.bgM.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bgh.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bgi.f(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92252);
    paramd.tj();
    this.bfE = paramd.tl();
    this.aXw = paramg.bh(paramd.getTrackId(), 2);
    this.bgL = new a(this.aXw);
    this.bge.a(paramg, paramd);
    AppMethodBeat.o(92252);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bfX = paramLong;
  }
  
  public final void sX()
  {
    AppMethodBeat.i(92251);
    com.google.android.exoplayer2.i.k.a(this.bfT);
    this.bgM.reset();
    this.bgh.reset();
    this.bgi.reset();
    this.bgN.reset();
    this.bgO.reset();
    a locala = this.bgL;
    locala.bgR = false;
    locala.bgS = false;
    locala.bgT = false;
    locala.bgv = false;
    locala.bgU = false;
    this.bfV = 0L;
    AppMethodBeat.o(92251);
  }
  
  public final void sY() {}
  
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
    if (paramm.vJ() > 0)
    {
      i = paramm.position;
      int i3 = paramm.limit;
      byte[] arrayOfByte1 = paramm.data;
      this.bfV += paramm.vJ();
      this.aXw.a(paramm, paramm.vJ());
      int i4;
      int i6;
      long l1;
      int k;
      long l2;
      if (i < i3)
      {
        i4 = com.google.android.exoplayer2.i.k.a(arrayOfByte1, i, i3, this.bfT);
        if (i4 == i3)
        {
          e(arrayOfByte1, i, i3);
          AppMethodBeat.o(92253);
          return;
        }
        i5 = com.google.android.exoplayer2.i.k.n(arrayOfByte1, i4);
        j = i4 - i;
        if (j > 0) {
          e(arrayOfByte1, i, i4);
        }
        i6 = i3 - i4;
        l1 = this.bfV - i6;
        if (j >= 0) {
          break label542;
        }
        k = -j;
        l2 = this.bfX;
        if (!this.aXg) {
          break label628;
        }
        localObject1 = this.bgL;
        if ((!((a)localObject1).bgU) || (!((a)localObject1).bgS)) {
          break label548;
        }
        ((a)localObject1).bfZ = ((a)localObject1).bgP;
        ((a)localObject1).bgU = false;
      }
      do
      {
        for (;;)
        {
          if (this.bgN.eu(k))
          {
            i = com.google.android.exoplayer2.i.k.l(this.bgN.nalData, this.bgN.bhc);
            this.bgl.q(this.bgN.nalData, i);
            this.bgl.fl(5);
            this.bge.a(l2, this.bgl);
          }
          if (this.bgO.eu(k))
          {
            i = com.google.android.exoplayer2.i.k.l(this.bgO.nalData, this.bgO.bhc);
            this.bgl.q(this.bgO.nalData, i);
            this.bgl.fl(5);
            this.bge.a(l2, this.bgl);
          }
          l2 = this.bfX;
          if (!this.aXg) {
            break label1743;
          }
          localObject1 = this.bgL;
          ((a)localObject1).bgS = false;
          ((a)localObject1).bgT = false;
          ((a)localObject1).bgs = l2;
          ((a)localObject1).bgQ = 0;
          ((a)localObject1).bgr = l1;
          if (i5 >= 32)
          {
            if ((!((a)localObject1).bgU) && (((a)localObject1).bgv))
            {
              ((a)localObject1).es(i6);
              ((a)localObject1).bgv = false;
            }
            if (i5 <= 34)
            {
              if (((a)localObject1).bgU) {
                break label1725;
              }
              bool = true;
              ((a)localObject1).bgT = bool;
              ((a)localObject1).bgU = true;
            }
          }
          if ((i5 < 16) || (i5 > 21)) {
            break label1731;
          }
          bool = true;
          ((a)localObject1).bgP = bool;
          if ((!((a)localObject1).bgP) && (i5 > 9)) {
            break label1737;
          }
          bool = true;
          ((a)localObject1).bgR = bool;
          this.bgN.et(i5);
          this.bgO.et(i5);
          i = i4 + 3;
          break label58;
          break;
          k = 0;
          break label161;
          if ((((a)localObject1).bgT) || (((a)localObject1).bgS))
          {
            if (((a)localObject1).bgv) {
              ((a)localObject1).es((int)(l1 - ((a)localObject1).bgr) + i6);
            }
            ((a)localObject1).bfY = ((a)localObject1).bgr;
            ((a)localObject1).bfQ = ((a)localObject1).bgs;
            ((a)localObject1).bgv = true;
            ((a)localObject1).bfZ = ((a)localObject1).bgP;
          }
        }
        this.bgM.eu(k);
        this.bgh.eu(k);
        this.bgi.eu(k);
      } while ((!this.bgM.bhb) || (!this.bgh.bhb) || (!this.bgi.bhb));
      localObject1 = this.aXw;
      str = this.bfE;
      localObject2 = this.bgM;
      n localn1 = this.bgh;
      n localn2 = this.bgi;
      arrayOfByte2 = new byte[((n)localObject2).bhc + localn1.bhc + localn2.bhc];
      System.arraycopy(((n)localObject2).nalData, 0, arrayOfByte2, 0, ((n)localObject2).bhc);
      System.arraycopy(localn1.nalData, 0, arrayOfByte2, ((n)localObject2).bhc, localn1.bhc);
      System.arraycopy(localn2.nalData, 0, arrayOfByte2, ((n)localObject2).bhc + localn1.bhc, localn2.bhc);
      localObject2 = new com.google.android.exoplayer2.i.n(localn1.nalData, 0, localn1.bhc);
      ((com.google.android.exoplayer2.i.n)localObject2).ep(44);
      n = ((com.google.android.exoplayer2.i.n)localObject2).eo(3);
      ((com.google.android.exoplayer2.i.n)localObject2).vH();
      ((com.google.android.exoplayer2.i.n)localObject2).ep(88);
      ((com.google.android.exoplayer2.i.n)localObject2).ep(8);
      i = 0;
      m = 0;
      while (m < n)
      {
        j = i;
        if (((com.google.android.exoplayer2.i.n)localObject2).sV()) {
          j = i + 89;
        }
        i = j;
        if (((com.google.android.exoplayer2.i.n)localObject2).sV()) {
          i = j + 8;
        }
        m += 1;
      }
      ((com.google.android.exoplayer2.i.n)localObject2).ep(i);
      if (n > 0) {
        ((com.google.android.exoplayer2.i.n)localObject2).ep((8 - n) * 2);
      }
      ((com.google.android.exoplayer2.i.n)localObject2).vW();
      int i10 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
      if (i10 == 3) {
        ((com.google.android.exoplayer2.i.n)localObject2).vH();
      }
      i2 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
      m = i2;
      j = i1;
      if (((com.google.android.exoplayer2.i.n)localObject2).sV())
      {
        m = ((com.google.android.exoplayer2.i.n)localObject2).vW();
        i9 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
        i8 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
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
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
        if (!((com.google.android.exoplayer2.i.n)localObject2).sV()) {
          break label1150;
        }
        i = 0;
      }
      for (;;)
      {
        if (i > n) {
          break label1157;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
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
      ((com.google.android.exoplayer2.i.n)localObject2).vW();
      ((com.google.android.exoplayer2.i.n)localObject2).vW();
      ((com.google.android.exoplayer2.i.n)localObject2).vW();
      ((com.google.android.exoplayer2.i.n)localObject2).vW();
      ((com.google.android.exoplayer2.i.n)localObject2).vW();
      ((com.google.android.exoplayer2.i.n)localObject2).vW();
      if ((((com.google.android.exoplayer2.i.n)localObject2).sV()) && (((com.google.android.exoplayer2.i.n)localObject2).sV()))
      {
        i = 0;
        while (i < 4)
        {
          n = 0;
          if (n < 6)
          {
            if (!((com.google.android.exoplayer2.i.n)localObject2).sV())
            {
              ((com.google.android.exoplayer2.i.n)localObject2).vW();
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
                ((com.google.android.exoplayer2.i.n)localObject2).vV();
              }
              i1 = 0;
              while (i1 < i2)
              {
                ((com.google.android.exoplayer2.i.n)localObject2).vV();
                i1 += 1;
              }
              break label1242;
            }
          }
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).ep(2);
      if (((com.google.android.exoplayer2.i.n)localObject2).sV())
      {
        ((com.google.android.exoplayer2.i.n)localObject2).ep(8);
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        ((com.google.android.exoplayer2.i.n)localObject2).vH();
      }
      int i8 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
      bool = false;
      i1 = 0;
      i = 0;
      label1382:
      if (i < i8)
      {
        if (i == 0) {
          break label1784;
        }
        bool = ((com.google.android.exoplayer2.i.n)localObject2).sV();
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
        ((com.google.android.exoplayer2.i.n)localObject2).vH();
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        i2 = 0;
        for (;;)
        {
          n = i1;
          if (i2 > i1) {
            break;
          }
          if (((com.google.android.exoplayer2.i.n)localObject2).sV()) {
            ((com.google.android.exoplayer2.i.n)localObject2).vH();
          }
          i2 += 1;
        }
      }
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
      i9 = ((com.google.android.exoplayer2.i.n)localObject2).vW();
      i2 = i1 + i9;
      n = 0;
      while (n < i1)
      {
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        ((com.google.android.exoplayer2.i.n)localObject2).vH();
        n += 1;
      }
      i1 = 0;
      for (;;)
      {
        n = i2;
        if (i1 >= i9) {
          break;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).vW();
        ((com.google.android.exoplayer2.i.n)localObject2).vH();
        i1 += 1;
      }
      i += 1;
      i1 = n;
      break label1382;
      if (((com.google.android.exoplayer2.i.n)localObject2).sV())
      {
        i = 0;
        while (i < ((com.google.android.exoplayer2.i.n)localObject2).vW())
        {
          ((com.google.android.exoplayer2.i.n)localObject2).ep(i7 + 4 + 1);
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).ep(2);
      float f2 = 1.0F;
      float f1;
      if ((((com.google.android.exoplayer2.i.n)localObject2).sV()) && (((com.google.android.exoplayer2.i.n)localObject2).sV()))
      {
        i = ((com.google.android.exoplayer2.i.n)localObject2).eo(8);
        if (i == 255)
        {
          i = ((com.google.android.exoplayer2.i.n)localObject2).eo(16);
          n = ((com.google.android.exoplayer2.i.n)localObject2).eo(16);
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
        this.aXg = true;
        break;
        if (i < com.google.android.exoplayer2.i.k.byT.length)
        {
          f1 = com.google.android.exoplayer2.i.k.byT[i];
          continue;
          bool = false;
          break label453;
          bool = false;
          break label483;
          bool = false;
          break label508;
          this.bgM.et(i5);
          this.bgh.et(i5);
          this.bgi.et(i5);
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
    private final com.google.android.exoplayer2.c.m aXw;
    long bfQ;
    long bfY;
    boolean bfZ;
    boolean bgP;
    int bgQ;
    boolean bgR;
    boolean bgS;
    boolean bgT;
    boolean bgU;
    long bgr;
    long bgs;
    boolean bgv;
    
    public a(com.google.android.exoplayer2.c.m paramm)
    {
      this.aXw = paramm;
    }
    
    final void es(int paramInt)
    {
      AppMethodBeat.i(92249);
      if (this.bfZ) {}
      for (int i = 1;; i = 0)
      {
        int j = (int)(this.bgr - this.bfY);
        this.aXw.a(this.bfQ, i, j, paramInt, null);
        AppMethodBeat.o(92249);
        return;
      }
    }
    
    public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.bgR)
      {
        int i = paramInt1 + 2 - this.bgQ;
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
        this.bgS = bool;
        this.bgR = false;
        return;
      }
      label55:
      this.bgQ += paramInt2 - paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.k
 * JD-Core Version:    0.7.0.1
 */