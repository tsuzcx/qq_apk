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
  private static final byte[] aZY = { 73, 68, 51 };
  private boolean aRO;
  private com.google.android.exoplayer2.c.m aSe;
  private int aZT;
  private long aZV;
  private final boolean aZZ;
  private final l baa;
  private final com.google.android.exoplayer2.i.m bab;
  private String bac;
  private com.google.android.exoplayer2.c.m bad;
  private int bae;
  private boolean baf;
  private com.google.android.exoplayer2.c.m bag;
  private long bah;
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
    this.baa = new l(new byte[7]);
    this.bab = new com.google.android.exoplayer2.i.m(Arrays.copyOf(aZY, 10));
    sI();
    this.aZZ = paramBoolean;
    this.language = paramString;
    AppMethodBeat.o(92210);
  }
  
  private void a(com.google.android.exoplayer2.c.m paramm, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.aZT = paramInt1;
    this.bag = paramm;
    this.bah = paramLong;
    this.sampleSize = paramInt2;
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92214);
    int i = Math.min(paramm.vg(), paramInt - this.aZT);
    paramm.readBytes(paramArrayOfByte, this.aZT, i);
    this.aZT = (i + this.aZT);
    if (this.aZT == paramInt)
    {
      AppMethodBeat.o(92214);
      return true;
    }
    AppMethodBeat.o(92214);
    return false;
  }
  
  private void sJ()
  {
    AppMethodBeat.i(92215);
    this.state = 1;
    this.aZT = aZY.length;
    this.sampleSize = 0;
    this.bab.setPosition(0);
    AppMethodBeat.o(92215);
  }
  
  private void sK()
  {
    this.state = 2;
    this.aZT = 0;
  }
  
  private void sL()
  {
    AppMethodBeat.i(92217);
    this.bad.a(this.bab, 10);
    this.bab.setPosition(6);
    a(this.bad, 0L, 10, this.bab.vn() + 10);
    AppMethodBeat.o(92217);
  }
  
  private void sM()
  {
    int i = 2;
    AppMethodBeat.i(92218);
    this.baa.setPosition(0);
    int j;
    if (!this.aRO)
    {
      j = this.baa.eA(2) + 1;
      if (j == 2) {
        break label232;
      }
      new StringBuilder("Detected audio object type: ").append(j).append(", but assuming AAC LC.");
    }
    for (;;)
    {
      j = this.baa.eA(4);
      this.baa.eB(1);
      Object localObject = com.google.android.exoplayer2.i.d.p(i, j, this.baa.eA(3));
      Pair localPair = com.google.android.exoplayer2.i.d.s((byte[])localObject);
      localObject = Format.a(this.bac, "audio/mp4a-latm", -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, this.language);
      this.aZV = (1024000000L / ((Format)localObject).sampleRate);
      this.aSe.f((Format)localObject);
      this.aRO = true;
      for (;;)
      {
        this.baa.eB(4);
        j = this.baa.eA(13) - 2 - 5;
        i = j;
        if (this.baf) {
          i = j - 2;
        }
        a(this.aSe, this.aZV, 0, i);
        AppMethodBeat.o(92218);
        return;
        this.baa.eB(10);
      }
      label232:
      i = j;
    }
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
        if ((this.bae == 512) && (i >= 240) && (i != 255))
        {
          if ((i & 0x1) == 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.baf = bool;
            sK();
            paramm.setPosition(j);
            AppMethodBeat.o(92216);
            return;
          }
        }
        switch (i | this.bae)
        {
        default: 
          if (this.bae == 256) {
            break label234;
          }
          this.bae = 256;
          i = j - 1;
          break;
        case 511: 
          this.bae = 512;
          i = j;
          break;
        case 329: 
          this.bae = 768;
          i = j;
          break;
        case 836: 
          this.bae = 1024;
          i = j;
          break;
        case 1075: 
          sJ();
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
    int i = Math.min(paramm.vg(), this.sampleSize - this.aZT);
    this.bag.a(paramm, i);
    this.aZT = (i + this.aZT);
    if (this.aZT == this.sampleSize)
    {
      this.bag.a(this.timeUs, 1, this.sampleSize, 0, null);
      this.timeUs += this.bah;
      sI();
    }
    AppMethodBeat.o(92219);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92212);
    paramd.sR();
    this.bac = paramd.sS();
    this.aSe = paramg.ej(paramd.getTrackId());
    if (this.aZZ)
    {
      paramd.sR();
      this.bad = paramg.ej(paramd.getTrackId());
      this.bad.f(Format.l(paramd.sS(), "application/id3"));
      AppMethodBeat.o(92212);
      return;
    }
    this.bad = new com.google.android.exoplayer2.c.d();
    AppMethodBeat.o(92212);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void sF()
  {
    AppMethodBeat.i(292752);
    sI();
    AppMethodBeat.o(292752);
  }
  
  public final void sG() {}
  
  final void sI()
  {
    this.state = 0;
    this.aZT = 0;
    this.bae = 256;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92213);
    while (paramm.vg() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        v(paramm);
        break;
      case 1: 
        if (a(paramm, this.bab.data, 10)) {
          sL();
        }
        break;
      case 2: 
        if (this.baf) {}
        for (int i = 7; a(paramm, this.baa.data, i); i = 5)
        {
          sM();
          break;
        }
      case 3: 
        w(paramm);
      }
    }
    AppMethodBeat.o(92213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.d
 * JD-Core Version:    0.7.0.1
 */