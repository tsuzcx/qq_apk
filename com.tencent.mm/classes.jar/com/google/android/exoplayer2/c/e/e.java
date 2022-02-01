package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

final class e
{
  private static final int cSK;
  private final m cLN;
  public int cOg;
  public int cSL;
  public long cSM;
  public long cSN;
  public long cSO;
  public long cSP;
  public int cSQ;
  public int cSR;
  public final int[] cSS;
  public int type;
  
  static
  {
    AppMethodBeat.i(92159);
    cSK = x.du("OggS");
    AppMethodBeat.o(92159);
  }
  
  e()
  {
    AppMethodBeat.i(92157);
    this.cSS = new int['ÿ'];
    this.cLN = new m(255);
    AppMethodBeat.o(92157);
  }
  
  public final boolean c(f paramf, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92158);
    this.cLN.reset();
    reset();
    if ((paramf.RU() == -1L) || (paramf.RU() - paramf.RT() >= 27L)) {
      i = 1;
    }
    while ((i == 0) || (!paramf.b(this.cLN.data, 0, 27, true))) {
      if (paramBoolean)
      {
        AppMethodBeat.o(92158);
        return false;
        i = 0;
      }
      else
      {
        paramf = new EOFException();
        AppMethodBeat.o(92158);
        throw paramf;
      }
    }
    if (this.cLN.FT() != cSK)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92158);
        return false;
      }
      paramf = new o("expected OggS capture pattern at begin of page");
      AppMethodBeat.o(92158);
      throw paramf;
    }
    this.cSL = this.cLN.readUnsignedByte();
    if (this.cSL != 0)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(92158);
        return false;
      }
      paramf = new o("unsupported bit stream revision");
      AppMethodBeat.o(92158);
      throw paramf;
    }
    this.type = this.cLN.readUnsignedByte();
    this.cSM = this.cLN.UL();
    this.cSN = this.cLN.UJ();
    this.cSO = this.cLN.UJ();
    this.cSP = this.cLN.UJ();
    this.cSQ = this.cLN.readUnsignedByte();
    this.cOg = (this.cSQ + 27);
    this.cLN.reset();
    paramf.b(this.cLN.data, 0, this.cSQ);
    int i = j;
    while (i < this.cSQ)
    {
      this.cSS[i] = this.cLN.readUnsignedByte();
      this.cSR += this.cSS[i];
      i += 1;
    }
    AppMethodBeat.o(92158);
    return true;
  }
  
  public final void reset()
  {
    this.cSL = 0;
    this.type = 0;
    this.cSM = 0L;
    this.cSN = 0L;
    this.cSO = 0L;
    this.cSP = 0L;
    this.cSQ = 0;
    this.cOg = 0;
    this.cSR = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.e
 * JD-Core Version:    0.7.0.1
 */