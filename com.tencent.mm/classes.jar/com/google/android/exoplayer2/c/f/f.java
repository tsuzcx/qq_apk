package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements h
{
  private Format bdI;
  private com.google.android.exoplayer2.c.m biD;
  private String bqF;
  private int bqM;
  private final com.google.android.exoplayer2.i.m bqu;
  private int bqw;
  private long bqy;
  private final String language;
  private int sampleSize;
  private int state;
  private long timeUs;
  
  public f(String paramString)
  {
    AppMethodBeat.i(92225);
    this.bqu = new com.google.android.exoplayer2.i.m(new byte[15]);
    this.bqu.data[0] = 127;
    this.bqu.data[1] = -2;
    this.bqu.data[2] = -128;
    this.bqu.data[3] = 1;
    this.state = 0;
    this.language = paramString;
    AppMethodBeat.o(92225);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92226);
    paramd.uR();
    this.bqF = paramd.uS();
    this.biD = paramg.eb(paramd.getTrackId());
    AppMethodBeat.o(92226);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92227);
    while (paramm.wV() > 0)
    {
      int i;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        while (paramm.wV() > 0)
        {
          this.bqM <<= 8;
          this.bqM |= paramm.readUnsignedByte();
          if (this.bqM == 2147385345) {
            this.bqM = 0;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.bqw = 4;
          this.state = 1;
          break;
        }
      case 1: 
        byte[] arrayOfByte = this.bqu.data;
        i = Math.min(paramm.wV(), 15 - this.bqw);
        paramm.readBytes(arrayOfByte, this.bqw, i);
        this.bqw += i;
        if (this.bqw == 15) {}
        for (i = 1; i != 0; i = 0)
        {
          arrayOfByte = this.bqu.data;
          if (this.bdI == null)
          {
            this.bdI = com.google.android.exoplayer2.a.h.a(arrayOfByte, this.bqF, this.language);
            this.biD.f(this.bdI);
          }
          this.sampleSize = com.google.android.exoplayer2.a.h.p(arrayOfByte);
          this.bqy = ((int)(com.google.android.exoplayer2.a.h.o(arrayOfByte) * 1000000L / this.bdI.sampleRate));
          this.bqu.setPosition(0);
          this.biD.a(this.bqu, 15);
          this.state = 2;
          break;
        }
      case 2: 
        i = Math.min(paramm.wV(), this.sampleSize - this.bqw);
        this.biD.a(paramm, i);
        this.bqw = (i + this.bqw);
        if (this.bqw == this.sampleSize)
        {
          this.biD.a(this.timeUs, 1, this.sampleSize, 0, null);
          this.timeUs += this.bqy;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92227);
  }
  
  public final void uF()
  {
    this.state = 0;
    this.bqw = 0;
    this.bqM = 0;
  }
  
  public final void uG() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.f
 * JD-Core Version:    0.7.0.1
 */