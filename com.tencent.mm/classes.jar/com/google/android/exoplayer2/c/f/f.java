package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements h
{
  private Format cHc;
  private com.google.android.exoplayer2.c.m cMa;
  private final com.google.android.exoplayer2.i.m cTM;
  private int cTO;
  private long cTQ;
  private String cTX;
  private int cUe;
  private final String language;
  private int sampleSize;
  private int state;
  private long timeUs;
  
  public f(String paramString)
  {
    AppMethodBeat.i(92225);
    this.cTM = new com.google.android.exoplayer2.i.m(new byte[15]);
    this.cTM.data[0] = 127;
    this.cTM.data[1] = -2;
    this.cTM.data[2] = -128;
    this.cTM.data[3] = 1;
    this.state = 0;
    this.language = paramString;
    AppMethodBeat.o(92225);
  }
  
  public final void Si()
  {
    this.state = 0;
    this.cTO = 0;
    this.cUe = 0;
  }
  
  public final void Sj() {}
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92226);
    paramd.Sv();
    this.cTX = paramd.Sw();
    this.cMa = paramg.hz(paramd.getTrackId());
    AppMethodBeat.o(92226);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92227);
    while (paramm.UF() > 0)
    {
      int i;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        while (paramm.UF() > 0)
        {
          this.cUe <<= 8;
          this.cUe |= paramm.readUnsignedByte();
          if (this.cUe == 2147385345) {
            this.cUe = 0;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.cTO = 4;
          this.state = 1;
          break;
        }
      case 1: 
        byte[] arrayOfByte = this.cTM.data;
        i = Math.min(paramm.UF(), 15 - this.cTO);
        paramm.readBytes(arrayOfByte, this.cTO, i);
        this.cTO += i;
        if (this.cTO == 15) {}
        for (i = 1; i != 0; i = 0)
        {
          arrayOfByte = this.cTM.data;
          if (this.cHc == null)
          {
            this.cHc = com.google.android.exoplayer2.a.h.a(arrayOfByte, this.cTX, this.language);
            this.cMa.f(this.cHc);
          }
          this.sampleSize = com.google.android.exoplayer2.a.h.t(arrayOfByte);
          this.cTQ = ((int)(com.google.android.exoplayer2.a.h.s(arrayOfByte) * 1000000L / this.cHc.sampleRate));
          this.cTM.setPosition(0);
          this.cMa.a(this.cTM, 15);
          this.state = 2;
          break;
        }
      case 2: 
        i = Math.min(paramm.UF(), this.sampleSize - this.cTO);
        this.cMa.a(paramm, i);
        this.cTO = (i + this.cTO);
        if (this.cTO == this.sampleSize)
        {
          this.cMa.a(this.timeUs, 1, this.sampleSize, 0, null);
          this.timeUs += this.cTQ;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.f
 * JD-Core Version:    0.7.0.1
 */