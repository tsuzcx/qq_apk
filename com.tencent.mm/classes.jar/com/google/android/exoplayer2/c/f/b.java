package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.a;
import com.google.android.exoplayer2.a.a.a;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements h
{
  private Format aNg;
  private com.google.android.exoplayer2.c.m aSe;
  private final l aZQ;
  private final com.google.android.exoplayer2.i.m aZR;
  private String aZS;
  private int aZT;
  private boolean aZU;
  private long aZV;
  private final String language;
  private int sampleSize;
  private int state;
  long timeUs;
  
  public b()
  {
    this(null);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(92197);
    this.aZQ = new l(new byte[8]);
    this.aZR = new com.google.android.exoplayer2.i.m(this.aZQ.data);
    this.state = 0;
    this.language = paramString;
    AppMethodBeat.o(92197);
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92200);
    int i = Math.min(paramm.vg(), 8 - this.aZT);
    paramm.readBytes(paramArrayOfByte, this.aZT, i);
    this.aZT = (i + this.aZT);
    if (this.aZT == 8)
    {
      AppMethodBeat.o(92200);
      return true;
    }
    AppMethodBeat.o(92200);
    return false;
  }
  
  private void sH()
  {
    AppMethodBeat.i(92202);
    this.aZQ.setPosition(0);
    a.a locala = a.a(this.aZQ);
    if ((this.aNg == null) || (locala.channelCount != this.aNg.channelCount) || (locala.sampleRate != this.aNg.sampleRate) || (locala.mimeType != this.aNg.aMQ))
    {
      this.aNg = Format.a(this.aZS, locala.mimeType, -1, -1, locala.channelCount, locala.sampleRate, null, null, this.language);
      this.aSe.f(this.aNg);
    }
    this.sampleSize = locala.aOj;
    this.aZV = (1000000L * locala.sampleCount / this.aNg.sampleRate);
    AppMethodBeat.o(92202);
  }
  
  private boolean u(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92201);
    if (paramm.vg() > 0)
    {
      if (!this.aZU)
      {
        if (paramm.readUnsignedByte() == 11) {}
        for (bool = true;; bool = false)
        {
          this.aZU = bool;
          break;
        }
      }
      int i = paramm.readUnsignedByte();
      if (i == 119)
      {
        this.aZU = false;
        AppMethodBeat.o(92201);
        return true;
      }
      if (i == 11) {}
      for (boolean bool = true;; bool = false)
      {
        this.aZU = bool;
        break;
      }
    }
    AppMethodBeat.o(92201);
    return false;
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92198);
    paramd.sR();
    this.aZS = paramd.sS();
    this.aSe = paramg.ej(paramd.getTrackId());
    AppMethodBeat.o(92198);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void sF()
  {
    this.state = 0;
    this.aZT = 0;
    this.aZU = false;
  }
  
  public final void sG() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92199);
    while (paramm.vg() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (u(paramm))
        {
          this.state = 1;
          this.aZR.data[0] = 11;
          this.aZR.data[1] = 119;
          this.aZT = 2;
        }
        break;
      case 1: 
        if (a(paramm, this.aZR.data))
        {
          sH();
          this.aZR.setPosition(0);
          this.aSe.a(this.aZR, 8);
          this.state = 2;
        }
        break;
      case 2: 
        int i = Math.min(paramm.vg(), this.sampleSize - this.aZT);
        this.aSe.a(paramm, i);
        this.aZT = (i + this.aZT);
        if (this.aZT == this.sampleSize)
        {
          this.aSe.a(this.timeUs, 1, this.sampleSize, 0, null);
          this.timeUs += this.aZV;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.b
 * JD-Core Version:    0.7.0.1
 */