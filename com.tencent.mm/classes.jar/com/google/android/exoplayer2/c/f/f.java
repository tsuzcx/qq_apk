package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  implements h
{
  private long aAT;
  private com.google.android.exoplayer2.c.m aCe;
  private final com.google.android.exoplayer2.i.m aJU;
  private int aJW;
  private long aJY;
  private String aKf;
  private int aKm;
  private final String axa;
  private Format axd;
  private int sampleSize;
  private int state;
  
  public f(String paramString)
  {
    AppMethodBeat.i(95103);
    this.aJU = new com.google.android.exoplayer2.i.m(new byte[15]);
    this.aJU.data[0] = 127;
    this.aJU.data[1] = -2;
    this.aJU.data[2] = -128;
    this.aJU.data[3] = 1;
    this.state = 0;
    this.axa = paramString;
    AppMethodBeat.o(95103);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(95104);
    paramd.ox();
    this.aKf = paramd.oz();
    this.aCe = paramg.dm(paramd.oy());
    AppMethodBeat.o(95104);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aAT = paramLong;
  }
  
  public final void ol()
  {
    this.state = 0;
    this.aJW = 0;
    this.aKm = 0;
  }
  
  public final void om() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95105);
    while (paramm.qM() > 0)
    {
      int i;
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        while (paramm.qM() > 0)
        {
          this.aKm <<= 8;
          this.aKm |= paramm.readUnsignedByte();
          if (this.aKm == 2147385345) {
            this.aKm = 0;
          }
        }
        for (i = 1; i != 0; i = 0)
        {
          this.aJW = 4;
          this.state = 1;
          break;
        }
      case 1: 
        byte[] arrayOfByte = this.aJU.data;
        i = Math.min(paramm.qM(), 15 - this.aJW);
        paramm.readBytes(arrayOfByte, this.aJW, i);
        this.aJW += i;
        if (this.aJW == 15) {}
        for (i = 1; i != 0; i = 0)
        {
          arrayOfByte = this.aJU.data;
          if (this.axd == null)
          {
            this.axd = com.google.android.exoplayer2.a.h.a(arrayOfByte, this.aKf, this.axa);
            this.aCe.f(this.axd);
          }
          this.sampleSize = com.google.android.exoplayer2.a.h.k(arrayOfByte);
          this.aJY = ((int)(com.google.android.exoplayer2.a.h.j(arrayOfByte) * 1000000L / this.axd.sampleRate));
          this.aJU.setPosition(0);
          this.aCe.a(this.aJU, 15);
          this.state = 2;
          break;
        }
      case 2: 
        i = Math.min(paramm.qM(), this.sampleSize - this.aJW);
        this.aCe.a(paramm, i);
        this.aJW = (i + this.aJW);
        if (this.aJW == this.sampleSize)
        {
          this.aCe.a(this.aAT, 1, this.sampleSize, 0, null);
          this.aAT += this.aJY;
          this.state = 0;
        }
        break;
      }
    }
    AppMethodBeat.o(95105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.f
 * JD-Core Version:    0.7.0.1
 */