package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

final class e
{
  private static final int bel;
  private final m aXj;
  public int aZG;
  public int bem;
  public long ben;
  public long beo;
  public long bep;
  public long beq;
  public int ber;
  public int bes;
  public final int[] bet;
  public int type;
  
  static
  {
    AppMethodBeat.i(92159);
    bel = x.aY("OggS");
    AppMethodBeat.o(92159);
  }
  
  e()
  {
    AppMethodBeat.i(92157);
    this.bet = new int['ÿ'];
    this.aXj = new m(255);
    AppMethodBeat.o(92157);
  }
  
  public final boolean c(f paramf, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92158);
    this.aXj.reset();
    reset();
    if ((paramf.getLength() == -1L) || (paramf.getLength() - paramf.sJ() >= 27L)) {
      i = 1;
    }
    while ((i == 0) || (!paramf.b(this.aXj.data, 0, 27, true))) {
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
    if (this.aXj.df() != bel)
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
    this.bem = this.aXj.readUnsignedByte();
    if (this.bem != 0)
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
    this.type = this.aXj.readUnsignedByte();
    this.ben = this.aXj.vO();
    this.beo = this.aXj.vM();
    this.bep = this.aXj.vM();
    this.beq = this.aXj.vM();
    this.ber = this.aXj.readUnsignedByte();
    this.aZG = (this.ber + 27);
    this.aXj.reset();
    paramf.b(this.aXj.data, 0, this.ber);
    int i = j;
    while (i < this.ber)
    {
      this.bet[i] = this.aXj.readUnsignedByte();
      this.bes += this.bet[i];
      i += 1;
    }
    AppMethodBeat.o(92158);
    return true;
  }
  
  public final void reset()
  {
    this.bem = 0;
    this.type = 0;
    this.ben = 0L;
    this.beo = 0L;
    this.bep = 0L;
    this.beq = 0L;
    this.ber = 0;
    this.aZG = 0;
    this.bes = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.e
 * JD-Core Version:    0.7.0.1
 */