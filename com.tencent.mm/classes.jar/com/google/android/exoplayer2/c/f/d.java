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
  private static final byte[] bqB = { 73, 68, 51 };
  private com.google.android.exoplayer2.c.m biD;
  private boolean bin;
  private final boolean bqC;
  private final l bqD;
  private final com.google.android.exoplayer2.i.m bqE;
  private String bqF;
  private com.google.android.exoplayer2.c.m bqG;
  private int bqH;
  private boolean bqI;
  private com.google.android.exoplayer2.c.m bqJ;
  private long bqK;
  private int bqw;
  private long bqy;
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
    this.bqD = new l(new byte[7]);
    this.bqE = new com.google.android.exoplayer2.i.m(Arrays.copyOf(bqB, 10));
    uI();
    this.bqC = paramBoolean;
    this.language = paramString;
    AppMethodBeat.o(92210);
  }
  
  private void a(com.google.android.exoplayer2.c.m paramm, long paramLong, int paramInt1, int paramInt2)
  {
    this.state = 3;
    this.bqw = paramInt1;
    this.bqJ = paramm;
    this.bqK = paramLong;
    this.sampleSize = paramInt2;
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92214);
    int i = Math.min(paramm.wV(), paramInt - this.bqw);
    paramm.readBytes(paramArrayOfByte, this.bqw, i);
    this.bqw = (i + this.bqw);
    if (this.bqw == paramInt)
    {
      AppMethodBeat.o(92214);
      return true;
    }
    AppMethodBeat.o(92214);
    return false;
  }
  
  private void uJ()
  {
    AppMethodBeat.i(92215);
    this.state = 1;
    this.bqw = bqB.length;
    this.sampleSize = 0;
    this.bqE.setPosition(0);
    AppMethodBeat.o(92215);
  }
  
  private void uK()
  {
    this.state = 2;
    this.bqw = 0;
  }
  
  private void uL()
  {
    AppMethodBeat.i(92217);
    this.bqG.a(this.bqE, 10);
    this.bqE.setPosition(6);
    a(this.bqG, 0L, 10, this.bqE.xb() + 10);
    AppMethodBeat.o(92217);
  }
  
  private void uM()
  {
    int i = 2;
    AppMethodBeat.i(92218);
    this.bqD.setPosition(0);
    int j;
    if (!this.bin)
    {
      j = this.bqD.es(2) + 1;
      if (j == 2) {
        break label232;
      }
      new StringBuilder("Detected audio object type: ").append(j).append(", but assuming AAC LC.");
    }
    for (;;)
    {
      j = this.bqD.es(4);
      this.bqD.et(1);
      Object localObject = com.google.android.exoplayer2.i.d.u(i, j, this.bqD.es(3));
      Pair localPair = com.google.android.exoplayer2.i.d.u((byte[])localObject);
      localObject = Format.a(this.bqF, "audio/mp4a-latm", -1, -1, ((Integer)localPair.second).intValue(), ((Integer)localPair.first).intValue(), Collections.singletonList(localObject), null, this.language);
      this.bqy = (1024000000L / ((Format)localObject).sampleRate);
      this.biD.f((Format)localObject);
      this.bin = true;
      for (;;)
      {
        this.bqD.et(4);
        j = this.bqD.es(13) - 2 - 5;
        i = j;
        if (this.bqI) {
          i = j - 2;
        }
        a(this.biD, this.bqy, 0, i);
        AppMethodBeat.o(92218);
        return;
        this.bqD.et(10);
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
        if ((this.bqH == 512) && (i >= 240) && (i != 255))
        {
          if ((i & 0x1) == 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.bqI = bool;
            uK();
            paramm.setPosition(j);
            AppMethodBeat.o(92216);
            return;
          }
        }
        switch (i | this.bqH)
        {
        default: 
          if (this.bqH == 256) {
            break label234;
          }
          this.bqH = 256;
          i = j - 1;
          break;
        case 511: 
          this.bqH = 512;
          i = j;
          break;
        case 329: 
          this.bqH = 768;
          i = j;
          break;
        case 836: 
          this.bqH = 1024;
          i = j;
          break;
        case 1075: 
          uJ();
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
    int i = Math.min(paramm.wV(), this.sampleSize - this.bqw);
    this.bqJ.a(paramm, i);
    this.bqw = (i + this.bqw);
    if (this.bqw == this.sampleSize)
    {
      this.bqJ.a(this.timeUs, 1, this.sampleSize, 0, null);
      this.timeUs += this.bqK;
      uI();
    }
    AppMethodBeat.o(92219);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92212);
    paramd.uR();
    this.bqF = paramd.uS();
    this.biD = paramg.eb(paramd.getTrackId());
    if (this.bqC)
    {
      paramd.uR();
      this.bqG = paramg.eb(paramd.getTrackId());
      this.bqG.f(Format.k(paramd.uS(), "application/id3"));
      AppMethodBeat.o(92212);
      return;
    }
    this.bqG = new com.google.android.exoplayer2.c.d();
    AppMethodBeat.o(92212);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92213);
    while (paramm.wV() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        v(paramm);
        break;
      case 1: 
        if (a(paramm, this.bqE.data, 10)) {
          uL();
        }
        break;
      case 2: 
        if (this.bqI) {}
        for (int i = 7; a(paramm, this.bqD.data, i); i = 5)
        {
          uM();
          break;
        }
      case 3: 
        w(paramm);
      }
    }
    AppMethodBeat.o(92213);
  }
  
  public final void uF()
  {
    AppMethodBeat.i(224271);
    uI();
    AppMethodBeat.o(224271);
  }
  
  public final void uG() {}
  
  final void uI()
  {
    this.state = 0;
    this.bqw = 0;
    this.bqH = 256;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.d
 * JD-Core Version:    0.7.0.1
 */