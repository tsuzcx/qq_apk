package com.google.android.exoplayer2.c.g;

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
  private static final double[] bfR = { 23.976023976023978D, 24.0D, 25.0D, 29.970029970029969D, 30.0D, 50.0D, 59.940059940059939D, 60.0D };
  private boolean aXg;
  private com.google.android.exoplayer2.c.m aXw;
  private String bfE;
  private long bfQ;
  private final boolean[] bfT;
  private final a bfU;
  private long bfV;
  private boolean bfW;
  private long bfX;
  private long bfY;
  private boolean bfZ;
  private boolean bga;
  private long frameDurationUs;
  
  public i()
  {
    AppMethodBeat.i(92235);
    this.bfT = new boolean[4];
    this.bfU = new a();
    AppMethodBeat.o(92235);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92237);
    paramd.tj();
    this.bfE = paramd.tl();
    this.aXw = paramg.bh(paramd.getTrackId(), 2);
    AppMethodBeat.o(92237);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.bfX = paramLong;
  }
  
  public final void sX()
  {
    AppMethodBeat.i(92236);
    k.a(this.bfT);
    a locala = this.bfU;
    locala.bgc = false;
    locala.length = 0;
    locala.bgd = 0;
    this.bfV = 0L;
    this.bfW = false;
    AppMethodBeat.o(92236);
  }
  
  public final void sY() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92238);
    int i = paramm.position;
    int j = paramm.limit;
    byte[] arrayOfByte1 = paramm.data;
    this.bfV += paramm.vJ();
    this.aXw.a(paramm, paramm.vJ());
    int k = k.a(arrayOfByte1, i, j, this.bfT);
    if (k == j)
    {
      if (!this.aXg) {
        this.bfU.d(arrayOfByte1, i, j);
      }
      AppMethodBeat.o(92238);
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
    if (!this.aXg)
    {
      n = k - i;
      if (n > 0) {
        this.bfU.d(arrayOfByte1, i, k);
      }
      if (n >= 0) {
        break label709;
      }
      i = -n;
      localObject1 = this.bfU;
      if (!((a)localObject1).bgc) {
        break label727;
      }
      ((a)localObject1).length -= i;
      if ((((a)localObject1).bgd != 0) || (m != 181)) {
        break label715;
      }
      ((a)localObject1).bgd = ((a)localObject1).length;
      ((a)localObject1).d(a.bgb, 0, a.bgb.length);
      i = 0;
      if (i != 0)
      {
        localObject1 = this.bfU;
        localObject2 = this.bfE;
        arrayOfByte2 = Arrays.copyOf(((a)localObject1).data, ((a)localObject1).length);
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
        if (i < bfR.length)
        {
          double d2 = bfR[i];
          n = ((a)localObject1).bgd;
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
      this.aXw.f((Format)((Pair)localObject1).first);
      this.frameDurationUs = ((Long)((Pair)localObject1).second).longValue();
      this.aXg = true;
      if ((m == 0) || (m == 179))
      {
        n = j - k;
        if ((this.bfW) && (this.bga) && (this.aXg))
        {
          if (this.bfZ)
          {
            i = 1;
            i1 = (int)(this.bfV - this.bfY);
            this.aXw.a(this.bfQ, i, i1 - n, n, null);
          }
        }
        else
        {
          if ((!this.bfW) || (this.bga))
          {
            this.bfY = (this.bfV - n);
            if (this.bfX == -9223372036854775807L) {
              break label802;
            }
            l1 = this.bfX;
            label663:
            this.bfQ = l1;
            this.bfZ = false;
            this.bfX = -9223372036854775807L;
            this.bfW = true;
          }
          if (m != 0) {
            break label829;
          }
          bool = true;
          label694:
          this.bga = bool;
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
      ((a)localObject1).bgc = false;
      i = 1;
      break label225;
      label727:
      if (m != 179) {
        break label209;
      }
      ((a)localObject1).bgc = true;
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
      if (this.bfW)
      {
        l1 = this.bfQ + this.frameDurationUs;
        break label663;
      }
      l1 = 0L;
      break label663;
      label829:
      bool = false;
      break label694;
      if (m == 184) {
        this.bfZ = true;
      }
    }
  }
  
  static final class a
  {
    static final byte[] bgb = { 0, 0, 1 };
    boolean bgc;
    public int bgd;
    public byte[] data;
    public int length;
    
    public a()
    {
      AppMethodBeat.i(92233);
      this.data = new byte[''];
      AppMethodBeat.o(92233);
    }
    
    public final void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92234);
      if (!this.bgc)
      {
        AppMethodBeat.o(92234);
        return;
      }
      paramInt2 -= paramInt1;
      if (this.data.length < this.length + paramInt2) {
        this.data = Arrays.copyOf(this.data, (this.length + paramInt2) * 2);
      }
      System.arraycopy(paramArrayOfByte, paramInt1, this.data, this.length, paramInt2);
      this.length = (paramInt2 + this.length);
      AppMethodBeat.o(92234);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.i
 * JD-Core Version:    0.7.0.1
 */