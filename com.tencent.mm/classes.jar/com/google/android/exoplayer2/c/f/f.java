package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements h
{
  private Format aNg;
  private com.google.android.exoplayer2.c.m aSe;
  private final com.google.android.exoplayer2.i.m aZR;
  private int aZT;
  private long aZV;
  private String bac;
  private int baj;
  private final String language;
  private int sampleSize;
  private int state;
  private long timeUs;
  
  public f(String paramString)
  {
    AppMethodBeat.i(92225);
    this.aZR = new com.google.android.exoplayer2.i.m(new byte[15]);
    this.aZR.data[0] = 127;
    this.aZR.data[1] = -2;
    this.aZR.data[2] = -128;
    this.aZR.data[3] = 1;
    this.state = 0;
    this.language = paramString;
    AppMethodBeat.o(92225);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92226);
    paramd.sR();
    this.bac = paramd.sS();
    this.aSe = paramg.ej(paramd.getTrackId());
    AppMethodBeat.o(92226);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void sF()
  {
    this.state = 0;
    this.aZT = 0;
    this.baj = 0;
  }
  
  public final void sG() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92227);
    while (paramm.vg() > 0)
    {
      int i;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        while (paramm.vg() > 0)
        {
          this.baj <<= 8;
          this.baj |= paramm.readUnsignedByte();
          if (this.baj == 2147385345) {
            this.baj = 0;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.aZT = 4;
          this.state = 1;
          break;
        }
      case 1: 
        byte[] arrayOfByte = this.aZR.data;
        i = Math.min(paramm.vg(), 15 - this.aZT);
        paramm.readBytes(arrayOfByte, this.aZT, i);
        this.aZT += i;
        if (this.aZT == 15) {}
        for (i = 1; i != 0; i = 0)
        {
          arrayOfByte = this.aZR.data;
          if (this.aNg == null)
          {
            this.aNg = com.google.android.exoplayer2.a.h.a(arrayOfByte, this.bac, this.language);
            this.aSe.f(this.aNg);
          }
          this.sampleSize = com.google.android.exoplayer2.a.h.n(arrayOfByte);
          this.aZV = ((int)(com.google.android.exoplayer2.a.h.m(arrayOfByte) * 1000000L / this.aNg.sampleRate));
          this.aZR.setPosition(0);
          this.aSe.a(this.aZR, 15);
          this.state = 2;
          break;
        }
      case 2: 
        i = Math.min(paramm.vg(), this.sampleSize - this.aZT);
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
    AppMethodBeat.o(92227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.f
 * JD-Core Version:    0.7.0.1
 */