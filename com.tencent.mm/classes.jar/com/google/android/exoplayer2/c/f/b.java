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
  long aAT;
  private com.google.android.exoplayer2.c.m aCe;
  private final l aJT;
  private final com.google.android.exoplayer2.i.m aJU;
  private String aJV;
  private int aJW;
  private boolean aJX;
  private long aJY;
  private final String axa;
  private Format axd;
  private int sampleSize;
  private int state;
  
  public b()
  {
    this(null);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(95075);
    this.aJT = new l(new byte[8]);
    this.aJU = new com.google.android.exoplayer2.i.m(this.aJT.data);
    this.state = 0;
    this.axa = paramString;
    AppMethodBeat.o(95075);
  }
  
  private boolean a(com.google.android.exoplayer2.i.m paramm, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95078);
    int i = Math.min(paramm.qM(), 8 - this.aJW);
    paramm.readBytes(paramArrayOfByte, this.aJW, i);
    this.aJW = (i + this.aJW);
    if (this.aJW == 8)
    {
      AppMethodBeat.o(95078);
      return true;
    }
    AppMethodBeat.o(95078);
    return false;
  }
  
  private void on()
  {
    AppMethodBeat.i(95080);
    this.aJT.setPosition(0);
    a.a locala = a.a(this.aJT);
    if ((this.axd == null) || (locala.awU != this.axd.awU) || (locala.sampleRate != this.axd.sampleRate) || (locala.mimeType != this.axd.awK))
    {
      this.axd = Format.a(this.aJV, locala.mimeType, -1, -1, locala.awU, locala.sampleRate, null, null, this.axa);
      this.aCe.f(this.axd);
    }
    this.sampleSize = locala.ayg;
    this.aJY = (1000000L * locala.sampleCount / this.axd.sampleRate);
    AppMethodBeat.o(95080);
  }
  
  private boolean u(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95079);
    if (paramm.qM() > 0)
    {
      if (!this.aJX)
      {
        if (paramm.readUnsignedByte() == 11) {}
        for (bool = true;; bool = false)
        {
          this.aJX = bool;
          break;
        }
      }
      int i = paramm.readUnsignedByte();
      if (i == 119)
      {
        this.aJX = false;
        AppMethodBeat.o(95079);
        return true;
      }
      if (i == 11) {}
      for (boolean bool = true;; bool = false)
      {
        this.aJX = bool;
        break;
      }
    }
    AppMethodBeat.o(95079);
    return false;
  }
  
  public final void a(g paramg, v.d paramd)
  {
    AppMethodBeat.i(95076);
    paramd.ox();
    this.aJV = paramd.oz();
    this.aCe = paramg.dm(paramd.oy());
    AppMethodBeat.o(95076);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    this.aAT = paramLong;
  }
  
  public final void ol()
  {
    this.state = 0;
    this.aJW = 0;
    this.aJX = false;
  }
  
  public final void om() {}
  
  public final void t(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(95077);
    while (paramm.qM() > 0) {
      switch (this.state)
      {
      default: 
        break;
      case 0: 
        if (u(paramm))
        {
          this.state = 1;
          this.aJU.data[0] = 11;
          this.aJU.data[1] = 119;
          this.aJW = 2;
        }
        break;
      case 1: 
        if (a(paramm, this.aJU.data))
        {
          on();
          this.aJU.setPosition(0);
          this.aCe.a(this.aJU, 8);
          this.state = 2;
        }
        break;
      case 2: 
        int i = Math.min(paramm.qM(), this.sampleSize - this.aJW);
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
    AppMethodBeat.o(95077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.b
 * JD-Core Version:    0.7.0.1
 */