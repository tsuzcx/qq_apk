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
  private Format cHc;
  private com.google.android.exoplayer2.c.m cMa;
  private final l cTL;
  private final com.google.android.exoplayer2.i.m cTM;
  private String cTN;
  private int cTO;
  private boolean cTP;
  private long cTQ;
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
    this.cTL = new l(new byte[8]);
    this.cTM = new com.google.android.exoplayer2.i.m(this.cTL.data);
    this.state = 0;
    this.language = paramString;
    AppMethodBeat.o(92197);
  }
  
  private void Sk()
  {
    AppMethodBeat.i(92202);
    this.cTL.setPosition(0);
    a.a locala = a.a(this.cTL);
    if ((this.cHc == null) || (locala.channelCount != this.cHc.channelCount) || (locala.sampleRate != this.cHc.sampleRate) || (locala.mimeType != this.cHc.cGN))
    {
      this.cHc = Format.a(this.cTN, locala.mimeType, -1, -1, locala.channelCount, locala.sampleRate, null, null, this.language);
      this.cMa.f(this.cHc);
    }
    this.sampleSize = locala.cIf;
    this.cTQ = (1000000L * locala.sampleCount / this.cHc.sampleRate);
    AppMethodBeat.o(92202);
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92200);
    int i = Math.min(paramm.UF(), 8 - this.cTO);
    paramm.readBytes(paramArrayOfByte, this.cTO, i);
    this.cTO = (i + this.cTO);
    if (this.cTO == 8)
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
    if (paramm.UF() > 0)
    {
      if (!this.cTP)
      {
        if (paramm.readUnsignedByte() == 11) {}
        for (bool = true;; bool = false)
        {
          this.cTP = bool;
          break;
        }
      }
      int i = paramm.readUnsignedByte();
      if (i == 119)
      {
        this.cTP = false;
        AppMethodBeat.o(92201);
        return true;
      }
      if (i == 11) {}
      for (boolean bool = true;; bool = false)
      {
        this.cTP = bool;
        break;
      }
    }
    AppMethodBeat.o(92201);
    return false;
  }
  
  public final void Si()
  {
    this.state = 0;
    this.cTO = 0;
    this.cTP = false;
  }
  
  public final void Sj() {}
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(92198);
    paramd.Sv();
    this.cTN = paramd.Sw();
    this.cMa = paramg.hz(paramd.getTrackId());
    AppMethodBeat.o(92198);
  }
  
  public final void h(long paramLong, boolean paramBoolean)
  {
    this.timeUs = paramLong;
  }
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92199);
    while (paramm.UF() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (u(paramm))
        {
          this.state = 1;
          this.cTM.data[0] = 11;
          this.cTM.data[1] = 119;
          this.cTO = 2;
        }
        break;
      case 1: 
        if (a(paramm, this.cTM.data))
        {
          Sk();
          this.cTM.setPosition(0);
          this.cMa.a(this.cTM, 8);
          this.state = 2;
        }
        break;
      case 2: 
        int i = Math.min(paramm.UF(), this.sampleSize - this.cTO);
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
    AppMethodBeat.o(92199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.b
 * JD-Core Version:    0.7.0.1
 */