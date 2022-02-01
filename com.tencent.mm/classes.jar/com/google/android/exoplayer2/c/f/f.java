package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements h
{
  private Format bdF;
  private com.google.android.exoplayer2.c.m biA;
  private String bqA;
  private int bqH;
  private final com.google.android.exoplayer2.i.m bqp;
  private int bqr;
  private long bqt;
  private final String language;
  private int sampleSize;
  private int state;
  private long timeUs;
  
  public f(String paramString)
  {
    AppMethodBeat.i(92225);
    this.bqp = new com.google.android.exoplayer2.i.m(new byte[15]);
    this.bqp.data[0] = 127;
    this.bqp.data[1] = -2;
    this.bqp.data[2] = -128;
    this.bqp.data[3] = 1;
    this.state = 0;
    this.language = paramString;
    AppMethodBeat.o(92225);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92226);
    paramd.uW();
    this.bqA = paramd.uX();
    this.biA = paramg.dV(paramd.getTrackId());
    AppMethodBeat.o(92226);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92227);
    while (paramm.xd() > 0)
    {
      int i;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        while (paramm.xd() > 0)
        {
          this.bqH <<= 8;
          this.bqH |= paramm.readUnsignedByte();
          if (this.bqH == 2147385345) {
            this.bqH = 0;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.bqr = 4;
          this.state = 1;
          break;
        }
      case 1: 
        byte[] arrayOfByte = this.bqp.data;
        i = Math.min(paramm.xd(), 15 - this.bqr);
        paramm.readBytes(arrayOfByte, this.bqr, i);
        this.bqr += i;
        if (this.bqr == 15) {}
        for (i = 1; i != 0; i = 0)
        {
          arrayOfByte = this.bqp.data;
          if (this.bdF == null)
          {
            this.bdF = com.google.android.exoplayer2.a.h.a(arrayOfByte, this.bqA, this.language);
            this.biA.f(this.bdF);
          }
          this.sampleSize = com.google.android.exoplayer2.a.h.p(arrayOfByte);
          this.bqt = ((int)(com.google.android.exoplayer2.a.h.o(arrayOfByte) * 1000000L / this.bdF.sampleRate));
          this.bqp.setPosition(0);
          this.biA.a(this.bqp, 15);
          this.state = 2;
          break;
        }
      case 2: 
        i = Math.min(paramm.xd(), this.sampleSize - this.bqr);
        this.biA.a(paramm, i);
        this.bqr = (i + this.bqr);
        if (this.bqr == this.sampleSize)
        {
          this.biA.a(this.timeUs, 1, this.sampleSize, 0, null);
          this.timeUs += this.bqt;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92227);
  }
  
  public final void uK()
  {
    this.state = 0;
    this.bqr = 0;
    this.bqH = 0;
  }
  
  public final void uL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.f
 * JD-Core Version:    0.7.0.1
 */