package com.google.android.exoplayer2.c.c;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import java.util.Arrays;
import java.util.Collections;

public final class d
  implements h
{
  private static final byte[] aDp = { 73, 68, 51 };
  private k aCt;
  private int aDk;
  private long aDm;
  private final boolean aDq;
  private final i aDr = new i(new byte[7]);
  private final j aDs = new j(Arrays.copyOf(aDp, 10));
  private String aDt;
  private k aDu;
  private int aDv;
  private boolean aDw;
  private boolean aDx;
  private k aDy;
  private long aDz;
  private final String auI;
  long ayE;
  private int sampleSize;
  private int state;
  
  public d()
  {
    this(true, null);
  }
  
  public d(boolean paramBoolean, String paramString)
  {
    ma();
    this.aDq = paramBoolean;
    this.auI = paramString;
  }
  
  private void a(k paramk, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.aDk = paramInt1;
    this.aDy = paramk;
    this.aDz = paramLong;
    this.sampleSize = paramInt2;
  }
  
  private boolean a(j paramj, byte[] paramArrayOfByte, int paramInt)
  {
    int i = Math.min(paramj.oe(), paramInt - this.aDk);
    paramj.readBytes(paramArrayOfByte, this.aDk, i);
    this.aDk = (i + this.aDk);
    return this.aDk == paramInt;
  }
  
  private void ma()
  {
    this.state = 0;
    this.aDk = 0;
    this.aDv = 256;
  }
  
  public final void a(f paramf, u.d paramd)
  {
    paramd.mg();
    this.aDt = paramd.mi();
    this.aCt = paramf.cQ(paramd.mh());
    if (this.aDq)
    {
      paramd.mg();
      this.aDu = paramf.cQ(paramd.mh());
      this.aDu.f(Format.j(paramd.mi(), "application/id3"));
      return;
    }
    this.aDu = new com.google.android.exoplayer2.c.c();
  }
  
  public final void b(j paramj)
  {
    label0:
    Object localObject;
    int i;
    int j;
    boolean bool;
    for (;;)
    {
      if (paramj.oe() > 0) {
        switch (this.state)
        {
        default: 
          break;
        case 0: 
          localObject = paramj.data;
          i = paramj.position;
          int k = paramj.limit;
          if (i >= k) {
            break label704;
          }
          j = i + 1;
          i = localObject[i] & 0xFF;
          if ((this.aDv == 512) && (i >= 240) && (i != 255)) {
            if ((i & 0x1) == 0)
            {
              bool = true;
              label112:
              this.aDw = bool;
              this.state = 2;
              this.aDk = 0;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramj.setPosition(j);
      break;
      bool = false;
      break label112;
      switch (i | this.aDv)
      {
      default: 
        if (this.aDv != 256)
        {
          this.aDv = 256;
          i = j - 1;
        }
        break;
      case 511: 
        this.aDv = 512;
        i = j;
        break;
      case 329: 
        this.aDv = 768;
        i = j;
        break;
      case 836: 
        this.aDv = 1024;
        i = j;
        break;
      case 1075: 
        this.state = 1;
        this.aDk = aDp.length;
        this.sampleSize = 0;
        this.aDs.setPosition(0);
        continue;
        if (!a(paramj, this.aDs.data, 10)) {
          break label0;
        }
        this.aDu.a(this.aDs, 10);
        this.aDs.setPosition(6);
        a(this.aDu, 0L, 10, this.aDs.og() + 10);
        break label0;
        if (this.aDw)
        {
          i = 7;
          label356:
          if (!a(paramj, this.aDr.data, i)) {
            break label0;
          }
          this.aDr.setPosition(0);
          if (this.aDx) {
            break label597;
          }
          j = this.aDr.dz(2) + 1;
          i = j;
          if (j != 2)
          {
            new StringBuilder("Detected audio object type: ").append(j).append(", but assuming AAC LC.");
            i = 2;
          }
          j = this.aDr.dz(4);
          this.aDr.dy(1);
          localObject = com.google.android.exoplayer2.i.c.s(i, j, this.aDr.dz(3));
          Pair localPair = com.google.android.exoplayer2.i.c.i((byte[])localObject);
          localObject = Format.a(this.aDt, "audio/mp4a-latm", -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, this.auI);
          this.aDm = (1024000000L / ((Format)localObject).sampleRate);
          this.aCt.f((Format)localObject);
          this.aDx = true;
        }
        for (;;)
        {
          this.aDr.dy(4);
          j = this.aDr.dz(13) - 2 - 5;
          i = j;
          if (this.aDw) {
            i = j - 2;
          }
          a(this.aCt, this.aDm, 0, i);
          break;
          i = 5;
          break label356;
          label597:
          this.aDr.dy(10);
        }
        i = Math.min(paramj.oe(), this.sampleSize - this.aDk);
        this.aDy.a(paramj, i);
        this.aDk = (i + this.aDk);
        if (this.aDk != this.sampleSize) {
          break label0;
        }
        this.aDy.a(this.ayE, 1, this.sampleSize, 0, null);
        this.ayE += this.aDz;
        ma();
        break label0;
        return;
        i = j;
        break;
        label704:
        j = i;
      }
    }
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.ayE = paramLong;
  }
  
  public final void lY()
  {
    ma();
  }
  
  public final void lZ() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.d
 * JD-Core Version:    0.7.0.1
 */