package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements h
{
  private final String aTm;
  private Format aTo;
  private com.google.android.exoplayer2.c.m aYi;
  private final com.google.android.exoplayer2.i.m bga;
  private int bgc;
  private long bge;
  private String bgl;
  private int bgs;
  private int sampleSize;
  private int state;
  private long timeUs;
  
  public f(String paramString)
  {
    AppMethodBeat.i(92225);
    this.bga = new com.google.android.exoplayer2.i.m(new byte[15]);
    this.bga.data[0] = 127;
    this.bga.data[1] = -2;
    this.bga.data[2] = -128;
    this.bga.data[3] = 1;
    this.state = 0;
    this.aTm = paramString;
    AppMethodBeat.o(92225);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92226);
    paramd.ts();
    this.bgl = paramd.tt();
    this.aYi = paramg.dW(paramd.getTrackId());
    AppMethodBeat.o(92226);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92227);
    while (paramm.vy() > 0)
    {
      int i;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        while (paramm.vy() > 0)
        {
          this.bgs <<= 8;
          this.bgs |= paramm.readUnsignedByte();
          if (this.bgs == 2147385345) {
            this.bgs = 0;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.bgc = 4;
          this.state = 1;
          break;
        }
      case 1: 
        byte[] arrayOfByte = this.bga.data;
        i = Math.min(paramm.vy(), 15 - this.bgc);
        paramm.readBytes(arrayOfByte, this.bgc, i);
        this.bgc += i;
        if (this.bgc == 15) {}
        for (i = 1; i != 0; i = 0)
        {
          arrayOfByte = this.bga.data;
          if (this.aTo == null)
          {
            this.aTo = com.google.android.exoplayer2.a.h.a(arrayOfByte, this.bgl, this.aTm);
            this.aYi.f(this.aTo);
          }
          this.sampleSize = com.google.android.exoplayer2.a.h.p(arrayOfByte);
          this.bge = ((int)(com.google.android.exoplayer2.a.h.o(arrayOfByte) * 1000000L / this.aTo.sampleRate));
          this.bga.setPosition(0);
          this.aYi.a(this.bga, 15);
          this.state = 2;
          break;
        }
      case 2: 
        i = Math.min(paramm.vy(), this.sampleSize - this.bgc);
        this.aYi.a(paramm, i);
        this.bgc = (i + this.bgc);
        if (this.bgc == this.sampleSize)
        {
          this.aYi.a(this.timeUs, 1, this.sampleSize, 0, null);
          this.timeUs += this.bge;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92227);
  }
  
  public final void tg()
  {
    this.state = 0;
    this.bgc = 0;
    this.bgs = 0;
  }
  
  public final void th() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.f
 * JD-Core Version:    0.7.0.1
 */