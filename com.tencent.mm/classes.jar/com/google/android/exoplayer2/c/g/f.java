package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements h
{
  private final String aSt;
  private Format aSv;
  private com.google.android.exoplayer2.c.m aXw;
  private String bfE;
  private int bfL;
  private final com.google.android.exoplayer2.i.m bft;
  private int bfv;
  private long bfx;
  private int sampleSize;
  private int state;
  private long timeUs;
  
  public f(String paramString)
  {
    AppMethodBeat.i(92225);
    this.bft = new com.google.android.exoplayer2.i.m(new byte[15]);
    this.bft.data[0] = 127;
    this.bft.data[1] = -2;
    this.bft.data[2] = -128;
    this.bft.data[3] = 1;
    this.state = 0;
    this.aSt = paramString;
    AppMethodBeat.o(92225);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92226);
    paramd.tj();
    this.bfE = paramd.tl();
    this.aXw = paramg.bh(paramd.getTrackId(), 1);
    AppMethodBeat.o(92226);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void sX()
  {
    this.state = 0;
    this.bfv = 0;
    this.bfL = 0;
  }
  
  public final void sY() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92227);
    while (paramm.vJ() > 0)
    {
      int i;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        while (paramm.vJ() > 0)
        {
          this.bfL <<= 8;
          this.bfL |= paramm.readUnsignedByte();
          if (this.bfL == 2147385345) {
            this.bfL = 0;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.bfv = 4;
          this.state = 1;
          break;
        }
      case 1: 
        byte[] arrayOfByte = this.bft.data;
        i = Math.min(paramm.vJ(), 15 - this.bfv);
        paramm.readBytes(arrayOfByte, this.bfv, i);
        this.bfv += i;
        if (this.bfv == 15) {}
        for (i = 1; i != 0; i = 0)
        {
          arrayOfByte = this.bft.data;
          if (this.aSv == null)
          {
            this.aSv = com.google.android.exoplayer2.a.h.a(arrayOfByte, this.bfE, this.aSt);
            this.aXw.f(this.aSv);
          }
          this.sampleSize = com.google.android.exoplayer2.a.h.p(arrayOfByte);
          this.bfx = ((int)(com.google.android.exoplayer2.a.h.o(arrayOfByte) * 1000000L / this.aSv.sampleRate));
          this.bft.setPosition(0);
          this.aXw.a(this.bft, 15);
          this.state = 2;
          break;
        }
      case 2: 
        i = Math.min(paramm.vJ(), this.sampleSize - this.bfv);
        this.aXw.a(paramm, i);
        this.bfv = (i + this.bfv);
        if (this.bfv == this.sampleSize)
        {
          this.aXw.a(this.timeUs, 1, this.sampleSize, 0, null);
          this.timeUs += this.bfx;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(92227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.f
 * JD-Core Version:    0.7.0.1
 */