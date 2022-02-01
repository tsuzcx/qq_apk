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
  private final String aTm;
  private Format aTo;
  private com.google.android.exoplayer2.c.m aYi;
  private final l bfZ;
  private final com.google.android.exoplayer2.i.m bga;
  private String bgb;
  private int bgc;
  private boolean bgd;
  private long bge;
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
    this.bfZ = new l(new byte[8]);
    this.bga = new com.google.android.exoplayer2.i.m(this.bfZ.data);
    this.state = 0;
    this.aTm = paramString;
    AppMethodBeat.o(92197);
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92200);
    int i = Math.min(paramm.vy(), 8 - this.bgc);
    paramm.readBytes(paramArrayOfByte, this.bgc, i);
    this.bgc = (i + this.bgc);
    if (this.bgc == 8)
    {
      AppMethodBeat.o(92200);
      return true;
    }
    AppMethodBeat.o(92200);
    return false;
  }
  
  private void ti()
  {
    AppMethodBeat.i(92202);
    this.bfZ.setPosition(0);
    a.a locala = a.a(this.bfZ);
    if ((this.aTo == null) || (locala.channelCount != this.aTo.channelCount) || (locala.sampleRate != this.aTo.sampleRate) || (locala.mimeType != this.aTo.aSY))
    {
      this.aTo = Format.a(this.bgb, locala.mimeType, -1, -1, locala.channelCount, locala.sampleRate, null, null, this.aTm);
      this.aYi.f(this.aTo);
    }
    this.sampleSize = locala.aUr;
    this.bge = (1000000L * locala.sampleCount / this.aTo.sampleRate);
    AppMethodBeat.o(92202);
  }
  
  private boolean u(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92201);
    if (paramm.vy() > 0)
    {
      if (!this.bgd)
      {
        if (paramm.readUnsignedByte() == 11) {}
        for (bool = true;; bool = false)
        {
          this.bgd = bool;
          break;
        }
      }
      int i = paramm.readUnsignedByte();
      if (i == 119)
      {
        this.bgd = false;
        AppMethodBeat.o(92201);
        return true;
      }
      if (i == 11) {}
      for (boolean bool = true;; bool = false)
      {
        this.bgd = bool;
        break;
      }
    }
    AppMethodBeat.o(92201);
    return false;
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92198);
    paramd.ts();
    this.bgb = paramd.tt();
    this.aYi = paramg.dW(paramd.getTrackId());
    AppMethodBeat.o(92198);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92199);
    while (paramm.vy() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (u(paramm))
        {
          this.state = 1;
          this.bga.data[0] = 11;
          this.bga.data[1] = 119;
          this.bgc = 2;
        }
        break;
      case 1: 
        if (a(paramm, this.bga.data))
        {
          ti();
          this.bga.setPosition(0);
          this.aYi.a(this.bga, 8);
          this.state = 2;
        }
        break;
      case 2: 
        int i = Math.min(paramm.vy(), this.sampleSize - this.bgc);
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
    AppMethodBeat.o(92199);
  }
  
  public final void tg()
  {
    this.state = 0;
    this.bgc = 0;
    this.bgd = false;
  }
  
  public final void th() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.b
 * JD-Core Version:    0.7.0.1
 */