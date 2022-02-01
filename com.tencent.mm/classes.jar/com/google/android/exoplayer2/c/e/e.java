package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

final class e
{
  private static final int beX;
  private final m aXV;
  public int bas;
  public int beY;
  public long beZ;
  public long bfa;
  public long bfb;
  public long bfc;
  public int bfd;
  public int bfe;
  public final int[] bff;
  public int type;
  
  static
  {
    AppMethodBeat.i(92159);
    beX = x.aQ("OggS");
    AppMethodBeat.o(92159);
  }
  
  e()
  {
    AppMethodBeat.i(92157);
    this.bff = new int['ÿ'];
    this.aXV = new m(255);
    AppMethodBeat.o(92157);
  }
  
  public final boolean c(f paramf, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92158);
    this.aXV.reset();
    reset();
    if ((paramf.getLength() == -1L) || (paramf.getLength() - paramf.sS() >= 27L)) {
      i = 1;
    }
    while ((i == 0) || (!paramf.b(this.aXV.data, 0, 27, true))) {
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
    if (this.aXV.dm() != beX)
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
    this.beY = this.aXV.readUnsignedByte();
    if (this.beY != 0)
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
    this.type = this.aXV.readUnsignedByte();
    this.beZ = this.aXV.vD();
    this.bfa = this.aXV.vB();
    this.bfb = this.aXV.vB();
    this.bfc = this.aXV.vB();
    this.bfd = this.aXV.readUnsignedByte();
    this.bas = (this.bfd + 27);
    this.aXV.reset();
    paramf.b(this.aXV.data, 0, this.bfd);
    int i = j;
    while (i < this.bfd)
    {
      this.bff[i] = this.aXV.readUnsignedByte();
      this.bfe += this.bff[i];
      i += 1;
    }
    AppMethodBeat.o(92158);
    return true;
  }
  
  public final void reset()
  {
    this.beY = 0;
    this.type = 0;
    this.beZ = 0L;
    this.bfa = 0L;
    this.bfb = 0L;
    this.bfc = 0L;
    this.bfd = 0;
    this.bas = 0;
    this.bfe = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.e
 * JD-Core Version:    0.7.0.1
 */