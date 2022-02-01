package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class k
  implements h
{
  private boolean aXS;
  private com.google.android.exoplayer2.c.m aYi;
  private long bgB;
  private long bgD;
  private final s bgK;
  private final n bgN;
  private final n bgO;
  private final com.google.android.exoplayer2.i.m bgR;
  private String bgl;
  private final boolean[] bgz;
  private a bhr;
  private final n bhs;
  private final n bht;
  private final n bhu;
  
  public k(s params)
  {
    AppMethodBeat.i(92250);
    this.bgK = params;
    this.bgz = new boolean[3];
    this.bhs = new n(32);
    this.bgN = new n(33);
    this.bgO = new n(34);
    this.bht = new n(39);
    this.bhu = new n(40);
    this.bgR = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92250);
  }
  
  private void e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92254);
    if (this.aXS) {
      this.bhr.g(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      this.bht.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bhu.f(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(92254);
      return;
      this.bhs.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bgN.f(paramArrayOfByte, paramInt1, paramInt2);
      this.bgO.f(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92252);
    paramd.ts();
    this.bgl = paramd.tt();
    this.aYi = paramg.dW(paramd.getTrackId());
    this.bhr = new a(this.aYi);
    this.bgK.a(paramg, paramd);
    AppMethodBeat.o(92252);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bgD = paramLong;
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
    if (paramm.vy() > 0)
    {
      i = paramm.position;
      int i3 = paramm.limit;
      byte[] arrayOfByte1 = paramm.data;
      this.bgB += paramm.vy();
      this.aYi.a(paramm, paramm.vy());
      int i4;
      int i6;
      long l1;
      int k;
      long l2;
      if (i < i3)
      {
        i4 = com.google.android.exoplayer2.i.k.a(arrayOfByte1, i, i3, this.bgz);
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
        l1 = this.bgB - i6;
        if (j >= 0) {
          break label542;
        }
        k = -j;
        l2 = this.bgD;
        if (!this.aXS) {
          break label628;
        }
        localObject1 = this.bhr;
        if ((!((a)localObject1).bhA) || (!((a)localObject1).bhy)) {
          break label548;
        }
        ((a)localObject1).bgF = ((a)localObject1).bhv;
        ((a)localObject1).bhA = false;
      }
      do
      {
        for (;;)
        {
          if (this.bht.eu(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.bht.nalData, this.bht.bhI);
            this.bgR.n(this.bht.nalData, i);
            this.bgR.eX(5);
            this.bgK.a(l2, this.bgR);
          }
          if (this.bhu.eu(k))
          {
            i = com.google.android.exoplayer2.i.k.j(this.bhu.nalData, this.bhu.bhI);
            this.bgR.n(this.bhu.nalData, i);
            this.bgR.eX(5);
            this.bgK.a(l2, this.bgR);
          }
          l2 = this.bgD;
          if (!this.aXS) {
            break label1743;
          }
          localObject1 = this.bhr;
          ((a)localObject1).bhy = false;
          ((a)localObject1).bhz = false;
          ((a)localObject1).bgY = l2;
          ((a)localObject1).bhw = 0;
          ((a)localObject1).bgX = l1;
          if (i5 >= 32)
          {
            if ((!((a)localObject1).bhA) && (((a)localObject1).bhb))
            {
              ((a)localObject1).es(i6);
              ((a)localObject1).bhb = false;
            }
            if (i5 <= 34)
            {
              if (((a)localObject1).bhA) {
                break label1725;
              }
              bool = true;
              ((a)localObject1).bhz = bool;
              ((a)localObject1).bhA = true;
            }
          }
          if ((i5 < 16) || (i5 > 21)) {
            break label1731;
          }
          bool = true;
          ((a)localObject1).bhv = bool;
          if ((!((a)localObject1).bhv) && (i5 > 9)) {
            break label1737;
          }
          bool = true;
          ((a)localObject1).bhx = bool;
          this.bht.et(i5);
          this.bhu.et(i5);
          i = i4 + 3;
          break label58;
          break;
          k = 0;
          break label161;
          if ((((a)localObject1).bhz) || (((a)localObject1).bhy))
          {
            if (((a)localObject1).bhb) {
              ((a)localObject1).es((int)(l1 - ((a)localObject1).bgX) + i6);
            }
            ((a)localObject1).bgE = ((a)localObject1).bgX;
            ((a)localObject1).bgx = ((a)localObject1).bgY;
            ((a)localObject1).bhb = true;
            ((a)localObject1).bgF = ((a)localObject1).bhv;
          }
        }
        this.bhs.eu(k);
        this.bgN.eu(k);
        this.bgO.eu(k);
      } while ((!this.bhs.bhH) || (!this.bgN.bhH) || (!this.bgO.bhH));
      localObject1 = this.aYi;
      str = this.bgl;
      localObject2 = this.bhs;
      n localn1 = this.bgN;
      n localn2 = this.bgO;
      arrayOfByte2 = new byte[((n)localObject2).bhI + localn1.bhI + localn2.bhI];
      System.arraycopy(((n)localObject2).nalData, 0, arrayOfByte2, 0, ((n)localObject2).bhI);
      System.arraycopy(localn1.nalData, 0, arrayOfByte2, ((n)localObject2).bhI, localn1.bhI);
      System.arraycopy(localn2.nalData, 0, arrayOfByte2, ((n)localObject2).bhI + localn1.bhI, localn2.bhI);
      localObject2 = new com.google.android.exoplayer2.i.n(localn1.nalData, 0, localn1.bhI);
      ((com.google.android.exoplayer2.i.n)localObject2).ep(44);
      n = ((com.google.android.exoplayer2.i.n)localObject2).eo(3);
      ((com.google.android.exoplayer2.i.n)localObject2).vw();
      ((com.google.android.exoplayer2.i.n)localObject2).ep(88);
      ((com.google.android.exoplayer2.i.n)localObject2).ep(8);
      i = 0;
      m = 0;
      while (m < n)
      {
        j = i;
        if (((com.google.android.exoplayer2.i.n)localObject2).te()) {
          j = i + 89;
        }
        i = j;
        if (((com.google.android.exoplayer2.i.n)localObject2).te()) {
          i = j + 8;
        }
        m += 1;
      }
      ((com.google.android.exoplayer2.i.n)localObject2).ep(i);
      if (n > 0) {
        ((com.google.android.exoplayer2.i.n)localObject2).ep((8 - n) * 2);
      }
      ((com.google.android.exoplayer2.i.n)localObject2).vL();
      int i10 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
      if (i10 == 3) {
        ((com.google.android.exoplayer2.i.n)localObject2).vw();
      }
      i2 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
      m = i2;
      j = i1;
      if (((com.google.android.exoplayer2.i.n)localObject2).te())
      {
        m = ((com.google.android.exoplayer2.i.n)localObject2).vL();
        i9 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
        i8 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
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
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        i7 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
        if (!((com.google.android.exoplayer2.i.n)localObject2).te()) {
          break label1150;
        }
        i = 0;
      }
      for (;;)
      {
        if (i > n) {
          break label1157;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
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
      ((com.google.android.exoplayer2.i.n)localObject2).vL();
      ((com.google.android.exoplayer2.i.n)localObject2).vL();
      ((com.google.android.exoplayer2.i.n)localObject2).vL();
      ((com.google.android.exoplayer2.i.n)localObject2).vL();
      ((com.google.android.exoplayer2.i.n)localObject2).vL();
      ((com.google.android.exoplayer2.i.n)localObject2).vL();
      if ((((com.google.android.exoplayer2.i.n)localObject2).te()) && (((com.google.android.exoplayer2.i.n)localObject2).te()))
      {
        i = 0;
        while (i < 4)
        {
          n = 0;
          if (n < 6)
          {
            if (!((com.google.android.exoplayer2.i.n)localObject2).te())
            {
              ((com.google.android.exoplayer2.i.n)localObject2).vL();
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
                ((com.google.android.exoplayer2.i.n)localObject2).vK();
              }
              i1 = 0;
              while (i1 < i2)
              {
                ((com.google.android.exoplayer2.i.n)localObject2).vK();
                i1 += 1;
              }
              break label1242;
            }
          }
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).ep(2);
      if (((com.google.android.exoplayer2.i.n)localObject2).te())
      {
        ((com.google.android.exoplayer2.i.n)localObject2).ep(8);
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        ((com.google.android.exoplayer2.i.n)localObject2).vw();
      }
      int i8 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
      bool = false;
      i1 = 0;
      i = 0;
      label1382:
      if (i < i8)
      {
        if (i == 0) {
          break label1784;
        }
        bool = ((com.google.android.exoplayer2.i.n)localObject2).te();
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
        ((com.google.android.exoplayer2.i.n)localObject2).vw();
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        i2 = 0;
        for (;;)
        {
          n = i1;
          if (i2 > i1) {
            break;
          }
          if (((com.google.android.exoplayer2.i.n)localObject2).te()) {
            ((com.google.android.exoplayer2.i.n)localObject2).vw();
          }
          i2 += 1;
        }
      }
      i1 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
      i9 = ((com.google.android.exoplayer2.i.n)localObject2).vL();
      i2 = i1 + i9;
      n = 0;
      while (n < i1)
      {
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        ((com.google.android.exoplayer2.i.n)localObject2).vw();
        n += 1;
      }
      i1 = 0;
      for (;;)
      {
        n = i2;
        if (i1 >= i9) {
          break;
        }
        ((com.google.android.exoplayer2.i.n)localObject2).vL();
        ((com.google.android.exoplayer2.i.n)localObject2).vw();
        i1 += 1;
      }
      i += 1;
      i1 = n;
      break label1382;
      if (((com.google.android.exoplayer2.i.n)localObject2).te())
      {
        i = 0;
        while (i < ((com.google.android.exoplayer2.i.n)localObject2).vL())
        {
          ((com.google.android.exoplayer2.i.n)localObject2).ep(i7 + 4 + 1);
          i += 1;
        }
      }
      ((com.google.android.exoplayer2.i.n)localObject2).ep(2);
      float f2 = 1.0F;
      float f1;
      if ((((com.google.android.exoplayer2.i.n)localObject2).te()) && (((com.google.android.exoplayer2.i.n)localObject2).te()))
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
        this.aXS = true;
        break;
        if (i < com.google.android.exoplayer2.i.k.bwB.length)
        {
          f1 = com.google.android.exoplayer2.i.k.bwB[i];
          continue;
          bool = false;
          break label453;
          bool = false;
          break label483;
          bool = false;
          break label508;
          this.bhs.et(i5);
          this.bgN.et(i5);
          this.bgO.et(i5);
          break label515;
          AppMethodBeat.o(92253);
          return;
        }
        f1 = 1.0F;
      }
    }
  }
  
  public final void tg()
  {
    AppMethodBeat.i(92251);
    com.google.android.exoplayer2.i.k.a(this.bgz);
    this.bhs.reset();
    this.bgN.reset();
    this.bgO.reset();
    this.bht.reset();
    this.bhu.reset();
    a locala = this.bhr;
    locala.bhx = false;
    locala.bhy = false;
    locala.bhz = false;
    locala.bhb = false;
    locala.bhA = false;
    this.bgB = 0L;
    AppMethodBeat.o(92251);
  }
  
  public final void th() {}
  
  static final class a
  {
    private final com.google.android.exoplayer2.c.m aYi;
    long bgE;
    boolean bgF;
    long bgX;
    long bgY;
    long bgx;
    boolean bhA;
    boolean bhb;
    boolean bhv;
    int bhw;
    boolean bhx;
    boolean bhy;
    boolean bhz;
    
    public a(com.google.android.exoplayer2.c.m paramm)
    {
      this.aYi = paramm;
    }
    
    final void es(int paramInt)
    {
      AppMethodBeat.i(92249);
      if (this.bgF) {}
      for (int i = 1;; i = 0)
      {
        int j = (int)(this.bgX - this.bgE);
        this.aYi.a(this.bgx, i, j, paramInt, null);
        AppMethodBeat.o(92249);
        return;
      }
    }
    
    public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (this.bhx)
      {
        int i = paramInt1 + 2 - this.bhw;
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
        this.bhy = bool;
        this.bhx = false;
        return;
      }
      label55:
      this.bhw += paramInt2 - paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.k
 * JD-Core Version:    0.7.0.1
 */