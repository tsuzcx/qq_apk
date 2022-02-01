package com.google.android.exoplayer2.c.f;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;

public final class d
  implements h
{
  private static final byte[] cTT = { 73, 68, 51 };
  private boolean cLK;
  private com.google.android.exoplayer2.c.m cMa;
  private int cTO;
  private long cTQ;
  private final boolean cTU;
  private final l cTV;
  private final com.google.android.exoplayer2.i.m cTW;
  private String cTX;
  private com.google.android.exoplayer2.c.m cTY;
  private int cTZ;
  private boolean cUa;
  private com.google.android.exoplayer2.c.m cUb;
  private long cUc;
  private final String language;
  private int sampleSize;
  private int state;
  long timeUs;
  
  public d()
  {
    this(true, null);
  }
  
  public d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(92210);
    this.cTV = new l(new byte[7]);
    this.cTW = new com.google.android.exoplayer2.i.m(Arrays.copyOf(cTT, 10));
    Sl();
    this.cTU = paramBoolean;
    this.language = paramString;
    AppMethodBeat.o(92210);
  }
  
  private void Sm()
  {
    AppMethodBeat.i(92215);
    this.state = 1;
    this.cTO = cTT.length;
    this.sampleSize = 0;
    this.cTW.setPosition(0);
    AppMethodBeat.o(92215);
  }
  
  private void Sn()
  {
    this.state = 2;
    this.cTO = 0;
  }
  
  private void So()
  {
    AppMethodBeat.i(92217);
    this.cTY.a(this.cTW, 10);
    this.cTW.setPosition(6);
    a(this.cTY, 0L, 10, this.cTW.UM() + 10);
    AppMethodBeat.o(92217);
  }
  
  private void Sp()
  {
    int i = 2;
    AppMethodBeat.i(92218);
    this.cTV.setPosition(0);
    int j;
    if (!this.cLK)
    {
      j = this.cTV.hQ(2) + 1;
      if (j == 2) {
        break label232;
      }
      new StringBuilder("Detected audio object type: ").append(j).append(", but assuming AAC LC.");
    }
    for (;;)
    {
      j = this.cTV.hQ(4);
      this.cTV.hR(1);
      Object localObject = com.google.android.exoplayer2.i.d.F(i, j, this.cTV.hQ(3));
      Pair localPair = com.google.android.exoplayer2.i.d.y((byte[])localObject);
      localObject = Format.a(this.cTX, "audio/mp4a-latm", -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, this.language);
      this.cTQ = (1024000000L / ((Format)localObject).sampleRate);
      this.cMa.f((Format)localObject);
      this.cLK = true;
      for (;;)
      {
        this.cTV.hR(4);
        j = this.cTV.hQ(13) - 2 - 5;
        i = j;
        if (this.cUa) {
          i = j - 2;
        }
        a(this.cMa, this.cTQ, 0, i);
        AppMethodBeat.o(92218);
        return;
        this.cTV.hR(10);
      }
      label232:
      i = j;
    }
  }
  
  private void a(com.google.android.exoplayer2.c.m paramm, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.cTO = paramInt1;
    this.cUb = paramm;
    this.cUc = paramLong;
    this.sampleSize = paramInt2;
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92214);
    int i = Math.min(paramm.UF(), paramInt - this.cTO);
    paramm.readBytes(paramArrayOfByte, this.cTO, i);
    this.cTO = (i + this.cTO);
    if (this.cTO == paramInt)
    {
      AppMethodBeat.o(92214);
      return true;
    }
    AppMethodBeat.o(92214);
    return false;
  }
  
  private void v(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92216);
    byte[] arrayOfByte = paramm.data;
    int i = paramm.position;
    int k = paramm.limit;
    for (;;)
    {
      int j;
      if (i < k)
      {
        j = i + 1;
        i = arrayOfByte[i] & 0xFF;
        if ((this.cTZ == 512) && (i >= 240) && (i != 255))
        {
          if ((i & 0x1) == 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.cUa = bool;
            Sn();
            paramm.setPosition(j);
            AppMethodBeat.o(92216);
            return;
          }
        }
        switch (i | this.cTZ)
        {
        default: 
          if (this.cTZ == 256) {
            break label234;
          }
          this.cTZ = 256;
          i = j - 1;
          break;
        case 511: 
          this.cTZ = 512;
          i = j;
          break;
        case 329: 
          this.cTZ = 768;
          i = j;
          break;
        case 836: 
          this.cTZ = 1024;
          i = j;
          break;
        case 1075: 
          Sm();
          paramm.setPosition(j);
          AppMethodBeat.o(92216);
          return;
        }
      }
      else
      {
        paramm.setPosition(i);
        AppMethodBeat.o(92216);
        return;
        label234:
        i = j;
      }
    }
  }
  
  private void w(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92219);
    int i = Math.min(paramm.UF(), this.sampleSize - this.cTO);
    this.cUb.a(paramm, i);
    this.cTO = (i + this.cTO);
    if (this.cTO == this.sampleSize)
    {
      this.cUb.a(this.timeUs, 1, this.sampleSize, 0, null);
      this.timeUs += this.cUc;
      Sl();
    }
    AppMethodBeat.o(92219);
  }
  
  public final void Si()
  {
    AppMethodBeat.i(369524);
    Sl();
    AppMethodBeat.o(369524);
  }
  
  public final void Sj() {}
  
  final void Sl()
  {
    this.state = 0;
    this.cTO = 0;
    this.cTZ = 256;
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92212);
    paramd.Sv();
    this.cTX = paramd.Sw();
    this.cMa = paramg.hz(paramd.getTrackId());
    if (this.cTU)
    {
      paramd.Sv();
      this.cTY = paramg.hz(paramd.getTrackId());
      this.cTY.f(Format.t(paramd.Sw(), "application/id3"));
      AppMethodBeat.o(92212);
      return;
    }
    this.cTY = new com.google.android.exoplayer2.c.d();
    AppMethodBeat.o(92212);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92213);
    while (paramm.UF() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        v(paramm);
        break;
      case 1: 
        if (a(paramm, this.cTW.data, 10)) {
          So();
        }
        break;
      case 2: 
        if (this.cUa) {}
        for (int i = 7; a(paramm, this.cTV.data, i); i = 5)
        {
          Sp();
          break;
        }
      case 3: 
        w(paramm);
      }
    }
    AppMethodBeat.o(92213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.d
 * JD-Core Version:    0.7.0.1
 */