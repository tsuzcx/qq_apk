package com.google.android.exoplayer2.c.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;

public final class i
  implements h
{
  private static final double[] aKs = { 23.976023976023978D, 24.0D, 25.0D, 29.970029970029969D, 30.0D, 50.0D, 59.940059940059939D, 60.0D };
  private boolean aBO;
  private com.google.android.exoplayer2.c.m aCe;
  private boolean aKA;
  private boolean aKB;
  private String aKf;
  private long aKr;
  private long aKt;
  private final boolean[] aKu;
  private final i.a aKv;
  private long aKw;
  private boolean aKx;
  private long aKy;
  private long aKz;
  
  public i()
  {
    AppMethodBeat.i(95113);
    this.aKu = new boolean[4];
    this.aKv = new i.a();
    AppMethodBeat.o(95113);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(95115);
    paramd.ox();
    this.aKf = paramd.oz();
    this.aCe = paramg.dm(paramd.oy());
    AppMethodBeat.o(95115);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aKy = paramLong;
  }
  
  public final void ol()
  {
    AppMethodBeat.i(95114);
    k.a(this.aKu);
    i.a locala = this.aKv;
    locala.aKD = false;
    locala.length = 0;
    locala.aKE = 0;
    this.aKw = 0L;
    this.aKx = false;
    AppMethodBeat.o(95114);
  }
  
  public final void om() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95116);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte1 = paramm.data;
    this.aKw += paramm.qM();
    this.aCe.a(paramm, paramm.qM());
    int k = k.a(arrayOfByte1, i, j, this.aKu);
    if (k == j)
    {
      if (!this.aBO) {
        this.aKv.d(arrayOfByte1, i, j);
      }
      AppMethodBeat.o(95116);
      return;
    }
    int m = paramm.data[(k + 3)] & 0xFF;
    int n;
    label156:
    Object localObject1;
    label209:
    label225:
    Object localObject2;
    byte[] arrayOfByte2;
    int i1;
    float f;
    if (!this.aBO)
    {
      n = k - i;
      if (n > 0) {
        this.aKv.d(arrayOfByte1, i, k);
      }
      if (n >= 0) {
        break label709;
      }
      i = -n;
      localObject1 = this.aKv;
      if (!((i.a)localObject1).aKD) {
        break label727;
      }
      ((i.a)localObject1).length -= i;
      if ((((i.a)localObject1).aKE != 0) || (m != 181)) {
        break label715;
      }
      ((i.a)localObject1).aKE = ((i.a)localObject1).length;
      ((i.a)localObject1).d(i.a.aKC, 0, i.a.aKC.length);
      i = 0;
      if (i != 0)
      {
        localObject1 = this.aKv;
        localObject2 = this.aKf;
        arrayOfByte2 = Arrays.copyOf(((i.a)localObject1).data, ((i.a)localObject1).length);
        i1 = arrayOfByte2[4];
        i = arrayOfByte2[5] & 0xFF;
        n = arrayOfByte2[6];
        i1 = i >> 4 | (i1 & 0xFF) << 4;
        i = (i & 0xF) << 8 | n & 0xFF;
        f = 1.0F;
      }
    }
    label352:
    long l1;
    label585:
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
        if (i < aKs.length)
        {
          double d2 = aKs[i];
          n = ((i.a)localObject1).aKE;
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
      this.aCe.f((Format)((Pair)localObject1).first);
      this.aKt = ((Long)((Pair)localObject1).second).longValue();
      this.aBO = true;
      if ((m == 0) || (m == 179))
      {
        n = j - k;
        if ((this.aKx) && (this.aKB) && (this.aBO))
        {
          if (this.aKA)
          {
            i = 1;
            i1 = (int)(this.aKw - this.aKz);
            this.aCe.a(this.aKr, i, i1 - n, n, null);
          }
        }
        else
        {
          if ((!this.aKx) || (this.aKB))
          {
            this.aKz = (this.aKw - n);
            if (this.aKy == -9223372036854775807L) {
              break label802;
            }
            l1 = this.aKy;
            label663:
            this.aKr = l1;
            this.aKA = false;
            this.aKy = -9223372036854775807L;
            this.aKx = true;
          }
          if (m != 0) {
            break label829;
          }
          bool = true;
          label694:
          this.aKB = bool;
        }
      }
      break;
    }
    for (;;)
    {
      i = k + 3;
      break;
      label709:
      i = 0;
      break label156;
      label715:
      ((i.a)localObject1).aKD = false;
      i = 1;
      break label225;
      label727:
      if (m != 179) {
        break label209;
      }
      ((i.a)localObject1).aKD = true;
      break label209;
      f = i * 4 / (i1 * 3);
      break label352;
      f = i * 16 / (i1 * 9);
      break label352;
      f = i * 121 / (i1 * 100);
      break label352;
      i = 0;
      break label585;
      label802:
      if (this.aKx)
      {
        l1 = this.aKr + this.aKt;
        break label663;
      }
      l1 = 0L;
      break label663;
      label829:
      bool = false;
      break label694;
      if (m == 184) {
        this.aKA = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.i
 * JD-Core Version:    0.7.0.1
 */