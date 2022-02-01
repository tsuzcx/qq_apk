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
  private Format bdI;
  private com.google.android.exoplayer2.c.m biD;
  private final l bqt;
  private final com.google.android.exoplayer2.i.m bqu;
  private String bqv;
  private int bqw;
  private boolean bqx;
  private long bqy;
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
    this.bqt = new l(new byte[8]);
    this.bqu = new com.google.android.exoplayer2.i.m(this.bqt.data);
    this.state = 0;
    this.language = paramString;
    AppMethodBeat.o(92197);
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92200);
    int i = Math.min(paramm.wV(), 8 - this.bqw);
    paramm.readBytes(paramArrayOfByte, this.bqw, i);
    this.bqw = (i + this.bqw);
    if (this.bqw == 8)
    {
      AppMethodBeat.o(92200);
      return true;
    }
    AppMethodBeat.o(92200);
    return false;
  }
  
  private boolean u(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92201);
    if (paramm.wV() > 0)
    {
      if (!this.bqx)
      {
        if (paramm.readUnsignedByte() == 11) {}
        for (bool = true;; bool = false)
        {
          this.bqx = bool;
          break;
        }
      }
      int i = paramm.readUnsignedByte();
      if (i == 119)
      {
        this.bqx = false;
        AppMethodBeat.o(92201);
        return true;
      }
      if (i == 11) {}
      for (boolean bool = true;; bool = false)
      {
        this.bqx = bool;
        break;
      }
    }
    AppMethodBeat.o(92201);
    return false;
  }
  
  private void uH()
  {
    AppMethodBeat.i(92202);
    this.bqt.setPosition(0);
    a.a locala = a.a(this.bqt);
    if ((this.bdI == null) || (locala.channelCount != this.bdI.channelCount) || (locala.sampleRate != this.bdI.sampleRate) || (locala.mimeType != this.bdI.bdt))
    {
      this.bdI = Format.a(this.bqv, locala.mimeType, -1, -1, locala.channelCount, locala.sampleRate, null, null, this.language);
      this.biD.f(this.bdI);
    }
    this.sampleSize = locala.beL;
    this.bqy = (1000000L * locala.sampleCount / this.bdI.sampleRate);
    AppMethodBeat.o(92202);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92198);
    paramd.uR();
    this.bqv = paramd.uS();
    this.biD = paramg.eb(paramd.getTrackId());
    AppMethodBeat.o(92198);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92199);
    while (paramm.wV() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (u(paramm))
        {
          this.state = 1;
          this.bqu.data[0] = 11;
          this.bqu.data[1] = 119;
          this.bqw = 2;
        }
        break;
      case 1: 
        if (a(paramm, this.bqu.data))
        {
          uH();
          this.bqu.setPosition(0);
          this.biD.a(this.bqu, 8);
          this.state = 2;
        }
        break;
      case 2: 
        int i = Math.min(paramm.wV(), this.sampleSize - this.bqw);
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
    AppMethodBeat.o(92199);
  }
  
  public final void uF()
  {
    this.state = 0;
    this.bqw = 0;
    this.bqx = false;
  }
  
  public final void uG() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.b
 * JD-Core Version:    0.7.0.1
 */