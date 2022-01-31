package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

final class e
{
  private static final int aIS;
  private final m aBR;
  public int aEo;
  public int aIT;
  public long aIU;
  public long aIV;
  public long aIW;
  public long aIX;
  public int aIY;
  public int aIZ;
  public final int[] aJa;
  public int type;
  
  static
  {
    AppMethodBeat.i(95043);
    aIS = x.aS("OggS");
    AppMethodBeat.o(95043);
  }
  
  e()
  {
    AppMethodBeat.i(95041);
    this.aJa = new int['ÿ'];
    this.aBR = new m(255);
    AppMethodBeat.o(95041);
  }
  
  public final boolean c(f paramf, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(95042);
    this.aBR.reset();
    reset();
    if ((paramf.getLength() == -1L) || (paramf.getLength() - paramf.nX() >= 27L)) {
      i = 1;
    }
    while ((i == 0) || (!paramf.b(this.aBR.data, 0, 27, true))) {
      if (paramBoolean)
      {
        AppMethodBeat.o(95042);
        return false;
        i = 0;
      }
      else
      {
        paramf = new EOFException();
        AppMethodBeat.o(95042);
        throw paramf;
      }
    }
    if (this.aBR.cc() != aIS)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(95042);
        return false;
      }
      paramf = new o("expected OggS capture pattern at begin of page");
      AppMethodBeat.o(95042);
      throw paramf;
    }
    this.aIT = this.aBR.readUnsignedByte();
    if (this.aIT != 0)
    {
      if (paramBoolean)
      {
        AppMethodBeat.o(95042);
        return false;
      }
      paramf = new o("unsupported bit stream revision");
      AppMethodBeat.o(95042);
      throw paramf;
    }
    this.type = this.aBR.readUnsignedByte();
    this.aIU = this.aBR.qR();
    this.aIV = this.aBR.qP();
    this.aIW = this.aBR.qP();
    this.aIX = this.aBR.qP();
    this.aIY = this.aBR.readUnsignedByte();
    this.aEo = (this.aIY + 27);
    this.aBR.reset();
    paramf.b(this.aBR.data, 0, this.aIY);
    int i = j;
    while (i < this.aIY)
    {
      this.aJa[i] = this.aBR.readUnsignedByte();
      this.aIZ += this.aJa[i];
      i += 1;
    }
    AppMethodBeat.o(95042);
    return true;
  }
  
  public final void reset()
  {
    this.aIT = 0;
    this.type = 0;
    this.aIU = 0L;
    this.aIV = 0L;
    this.aIW = 0L;
    this.aIX = 0L;
    this.aIY = 0;
    this.aEo = 0;
    this.aIZ = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.e
 * JD-Core Version:    0.7.0.1
 */