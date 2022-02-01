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
  private Format bdF;
  private com.google.android.exoplayer2.c.m biA;
  private final l bqo;
  private final com.google.android.exoplayer2.i.m bqp;
  private String bqq;
  private int bqr;
  private boolean bqs;
  private long bqt;
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
    this.bqo = new l(new byte[8]);
    this.bqp = new com.google.android.exoplayer2.i.m(this.bqo.data);
    this.state = 0;
    this.language = paramString;
    AppMethodBeat.o(92197);
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92200);
    int i = Math.min(paramm.xd(), 8 - this.bqr);
    paramm.readBytes(paramArrayOfByte, this.bqr, i);
    this.bqr = (i + this.bqr);
    if (this.bqr == 8)
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
    if (paramm.xd() > 0)
    {
      if (!this.bqs)
      {
        if (paramm.readUnsignedByte() == 11) {}
        for (bool = true;; bool = false)
        {
          this.bqs = bool;
          break;
        }
      }
      int i = paramm.readUnsignedByte();
      if (i == 119)
      {
        this.bqs = false;
        AppMethodBeat.o(92201);
        return true;
      }
      if (i == 11) {}
      for (boolean bool = true;; bool = false)
      {
        this.bqs = bool;
        break;
      }
    }
    AppMethodBeat.o(92201);
    return false;
  }
  
  private void uM()
  {
    AppMethodBeat.i(92202);
    this.bqo.setPosition(0);
    a.a locala = a.a(this.bqo);
    if ((this.bdF == null) || (locala.channelCount != this.bdF.channelCount) || (locala.sampleRate != this.bdF.sampleRate) || (locala.mimeType != this.bdF.bdq))
    {
      this.bdF = Format.a(this.bqq, locala.mimeType, -1, -1, locala.channelCount, locala.sampleRate, null, null, this.language);
      this.biA.f(this.bdF);
    }
    this.sampleSize = locala.beI;
    this.bqt = (1000000L * locala.sampleCount / this.bdF.sampleRate);
    AppMethodBeat.o(92202);
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92198);
    paramd.uW();
    this.bqq = paramd.uX();
    this.biA = paramg.dV(paramd.getTrackId());
    AppMethodBeat.o(92198);
  }
  
  public final void c(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92199);
    while (paramm.xd() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (u(paramm))
        {
          this.state = 1;
          this.bqp.data[0] = 11;
          this.bqp.data[1] = 119;
          this.bqr = 2;
        }
        break;
      case 1: 
        if (a(paramm, this.bqp.data))
        {
          uM();
          this.bqp.setPosition(0);
          this.biA.a(this.bqp, 8);
          this.state = 2;
        }
        break;
      case 2: 
        int i = Math.min(paramm.xd(), this.sampleSize - this.bqr);
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
    AppMethodBeat.o(92199);
  }
  
  public final void uK()
  {
    this.state = 0;
    this.bqr = 0;
    this.bqs = false;
  }
  
  public final void uL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.b
 * JD-Core Version:    0.7.0.1
 */