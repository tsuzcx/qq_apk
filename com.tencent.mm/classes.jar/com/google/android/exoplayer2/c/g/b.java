package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.a;
import com.google.android.exoplayer2.a.a.a;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements h
{
  private final String aSt;
  private Format aSv;
  private com.google.android.exoplayer2.c.m aXw;
  private final l bfr;
  private final com.google.android.exoplayer2.i.m bft;
  private String bfu;
  private int bfv;
  private boolean bfw;
  private long bfx;
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
    this.bfr = new l(new byte[8]);
    this.bft = new com.google.android.exoplayer2.i.m(this.bfr.data);
    this.state = 0;
    this.aSt = paramString;
    AppMethodBeat.o(92197);
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92200);
    int i = Math.min(paramm.vJ(), 8 - this.bfv);
    paramm.readBytes(paramArrayOfByte, this.bfv, i);
    this.bfv = (i + this.bfv);
    if (this.bfv == 8)
    {
      AppMethodBeat.o(92200);
      return true;
    }
    AppMethodBeat.o(92200);
    return false;
  }
  
  private void sZ()
  {
    AppMethodBeat.i(92202);
    this.bfr.setPosition(0);
    a.a locala = a.a(this.bfr);
    if ((this.aSv == null) || (locala.channelCount != this.aSv.channelCount) || (locala.sampleRate != this.aSv.sampleRate) || (locala.mimeType != this.aSv.aSd))
    {
      this.aSv = Format.a(this.bfu, locala.mimeType, -1, -1, locala.channelCount, locala.sampleRate, null, null, this.aSt);
      this.aXw.f(this.aSv);
    }
    this.sampleSize = locala.aTz;
    this.bfx = (1000000L * locala.sampleCount / this.aSv.sampleRate);
    AppMethodBeat.o(92202);
  }
  
  private boolean u(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92201);
    if (paramm.vJ() > 0)
    {
      if (!this.bfw)
      {
        if (paramm.readUnsignedByte() == 11) {}
        for (bool = true;; bool = false)
        {
          this.bfw = bool;
          break;
        }
      }
      int i = paramm.readUnsignedByte();
      if (i == 119)
      {
        this.bfw = false;
        AppMethodBeat.o(92201);
        return true;
      }
      if (i == 11) {}
      for (boolean bool = true;; bool = false)
      {
        this.bfw = bool;
        break;
      }
    }
    AppMethodBeat.o(92201);
    return false;
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92198);
    paramd.tj();
    this.bfu = paramd.tl();
    this.aXw = paramg.bh(paramd.getTrackId(), 1);
    AppMethodBeat.o(92198);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void sX()
  {
    this.state = 0;
    this.bfv = 0;
    this.bfw = false;
  }
  
  public final void sY() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92199);
    while (paramm.vJ() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (u(paramm))
        {
          this.state = 1;
          this.bft.data[0] = 11;
          this.bft.data[1] = 119;
          this.bfv = 2;
        }
        break;
      case 1: 
        if (a(paramm, this.bft.data))
        {
          sZ();
          this.bft.setPosition(0);
          this.aXw.a(this.bft, 8);
          this.state = 2;
        }
        break;
      case 2: 
        int i = Math.min(paramm.vJ(), this.sampleSize - this.bfv);
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
    AppMethodBeat.o(92199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.g.b
 * JD-Core Version:    0.7.0.1
 */