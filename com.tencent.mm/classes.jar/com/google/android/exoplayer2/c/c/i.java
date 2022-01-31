package com.google.android.exoplayer2.c.c;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import java.util.Arrays;
import java.util.Collections;

public final class i
  implements h
{
  private static final double[] aDH = { 23.976023976023978D, 24.0D, 25.0D, 29.970029970029969D, 30.0D, 50.0D, 59.940059940059939D, 60.0D };
  private k aCt;
  private long aDG;
  private long aDI;
  private final boolean[] aDJ = new boolean[4];
  private final i.a aDK = new i.a();
  private long aDL;
  private boolean aDM;
  private long aDN;
  private long aDO;
  private boolean aDP;
  private boolean aDQ;
  private String aDt;
  private boolean aDx;
  
  public final void a(f paramf, u.d paramd)
  {
    paramd.mg();
    this.aDt = paramd.mi();
    this.aCt = paramf.cQ(paramd.mh());
  }
  
  public final void b(j paramj)
  {
    int i = paramj.position;
    int j = paramj.limit;
    byte[] arrayOfByte1 = paramj.data;
    this.aDL += paramj.oe();
    this.aCt.a(paramj, paramj.oe());
    int k = com.google.android.exoplayer2.i.h.a(arrayOfByte1, i, j, this.aDJ);
    if (k == j)
    {
      if (!this.aDx) {
        this.aDK.d(arrayOfByte1, i, j);
      }
      return;
    }
    int m = paramj.data[(k + 3)] & 0xFF;
    int n;
    label146:
    Object localObject1;
    label199:
    label215:
    Object localObject2;
    byte[] arrayOfByte2;
    int i1;
    float f;
    if (!this.aDx)
    {
      n = k - i;
      if (n > 0) {
        this.aDK.d(arrayOfByte1, i, k);
      }
      if (n >= 0) {
        break label701;
      }
      i = -n;
      localObject1 = this.aDK;
      if (!((i.a)localObject1).aDS) {
        break label719;
      }
      ((i.a)localObject1).length -= i;
      if ((((i.a)localObject1).aDT != 0) || (m != 181)) {
        break label707;
      }
      ((i.a)localObject1).aDT = ((i.a)localObject1).length;
      ((i.a)localObject1).d(i.a.aDR, 0, i.a.aDR.length);
      i = 0;
      if (i != 0)
      {
        localObject1 = this.aDK;
        localObject2 = this.aDt;
        arrayOfByte2 = Arrays.copyOf(((i.a)localObject1).data, ((i.a)localObject1).length);
        i1 = arrayOfByte2[4];
        i = arrayOfByte2[5] & 0xFF;
        n = arrayOfByte2[6];
        i1 = i >> 4 | (i1 & 0xFF) << 4;
        i = (i & 0xF) << 8 | n & 0xFF;
        f = 1.0F;
      }
    }
    label344:
    long l1;
    label577:
    boolean bool;
    switch ((arrayOfByte2[7] & 0xF0) >> 4)
    {
    default: 
      localObject2 = Format.a((String)localObject2, "video/mpeg2", i1, i, Collections.singletonList(arrayOfByte2), f);
      long l2 = 0L;
      i = (arrayOfByte2[7] & 0xF) - 1;
      l1 = l2;
      if (i >= 0)
      {
        l1 = l2;
        if (i < aDH.length)
        {
          double d2 = aDH[i];
          n = ((i.a)localObject1).aDT;
          i = (arrayOfByte2[(n + 9)] & 0x60) >> 5;
          n = arrayOfByte2[(n + 9)] & 0x1F;
          double d1 = d2;
          if (i != n) {
            d1 = d2 * ((i + 1.0D) / (n + 1));
          }
          l1 = (1000000.0D / d1);
        }
      }
      localObject1 = Pair.create(localObject2, Long.valueOf(l1));
      this.aCt.f((Format)((Pair)localObject1).first);
      this.aDI = ((Long)((Pair)localObject1).second).longValue();
      this.aDx = true;
      if ((m == 0) || (m == 179))
      {
        n = j - k;
        if ((this.aDM) && (this.aDQ) && (this.aDx))
        {
          if (this.aDP)
          {
            i = 1;
            i1 = (int)(this.aDL - this.aDO);
            this.aCt.a(this.aDG, i, i1 - n, n, null);
          }
        }
        else
        {
          if ((!this.aDM) || (this.aDQ))
          {
            this.aDO = (this.aDL - n);
            if (this.aDN == -9223372036854775807L) {
              break label794;
            }
            l1 = this.aDN;
            label655:
            this.aDG = l1;
            this.aDP = false;
            this.aDN = -9223372036854775807L;
            this.aDM = true;
          }
          if (m != 0) {
            break label821;
          }
          bool = true;
          label686:
          this.aDQ = bool;
        }
      }
      break;
    }
    for (;;)
    {
      i = k + 3;
      break;
      label701:
      i = 0;
      break label146;
      label707:
      ((i.a)localObject1).aDS = false;
      i = 1;
      break label215;
      label719:
      if (m != 179) {
        break label199;
      }
      ((i.a)localObject1).aDS = true;
      break label199;
      f = i * 4 / (i1 * 3);
      break label344;
      f = i * 16 / (i1 * 9);
      break label344;
      f = i * 121 / (i1 * 100);
      break label344;
      i = 0;
      break label577;
      label794:
      if (this.aDM)
      {
        l1 = this.aDG + this.aDI;
        break label655;
      }
      l1 = 0L;
      break label655;
      label821:
      bool = false;
      break label686;
      if (m == 184) {
        this.aDP = true;
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
    i.a locala = this.aDK;
    locala.aDS = false;
    locala.length = 0;
    locala.aDT = 0;
    this.aDL = 0L;
    this.aDM = false;
  }
  
  public final void lZ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.i
 * JD-Core Version:    0.7.0.1
 */