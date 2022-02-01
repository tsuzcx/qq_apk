package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

final class e
{
  private static final int aYP;
  private final m aRR;
  public int aUk;
  public int aYQ;
  public long aYR;
  public long aYS;
  public long aYT;
  public long aYU;
  public int aYV;
  public int aYW;
  public final int[] aYX;
  public int type;
  
  static
  {
    AppMethodBeat.i(92159);
    aYP = x.bU("OggS");
    AppMethodBeat.o(92159);
  }
  
  e()
  {
    AppMethodBeat.i(92157);
    this.aYX = new int['ÿ'];
    this.aRR = new m(255);
    AppMethodBeat.o(92157);
  }
  
  public final boolean c(f paramf, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92158);
    this.aRR.reset();
    reset();
    if ((paramf.sr() == -1L) || (paramf.sr() - paramf.sq() >= 27L)) {
      i = 1;
    }
    while ((i == 0) || (!paramf.b(this.aRR.data, 0, 27, true))) {
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
    if (this.aRR.ii() != aYP)
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
    this.aYQ = this.aRR.readUnsignedByte();
    if (this.aYQ != 0)
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
    this.type = this.aRR.readUnsignedByte();
    this.aYR = this.aRR.vm();
    this.aYS = this.aRR.vk();
    this.aYT = this.aRR.vk();
    this.aYU = this.aRR.vk();
    this.aYV = this.aRR.readUnsignedByte();
    this.aUk = (this.aYV + 27);
    this.aRR.reset();
    paramf.b(this.aRR.data, 0, this.aYV);
    int i = j;
    while (i < this.aYV)
    {
      this.aYX[i] = this.aRR.readUnsignedByte();
      this.aYW += this.aYX[i];
      i += 1;
    }
    AppMethodBeat.o(92158);
    return true;
  }
  
  public final void reset()
  {
    this.aYQ = 0;
    this.type = 0;
    this.aYR = 0L;
    this.aYS = 0L;
    this.aYT = 0L;
    this.aYU = 0L;
    this.aYV = 0;
    this.aUk = 0;
    this.aYW = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.e
 * JD-Core Version:    0.7.0.1
 */