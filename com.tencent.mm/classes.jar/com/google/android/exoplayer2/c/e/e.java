package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

final class e
{
  private static final int bpn;
  private final m bin;
  public int bkI;
  public int bpo;
  public long bpp;
  public long bpq;
  public long bpr;
  public long bps;
  public int bpt;
  public int bpu;
  public final int[] bpv;
  public int type;
  
  static
  {
    AppMethodBeat.i(92159);
    bpn = x.bJ("OggS");
    AppMethodBeat.o(92159);
  }
  
  e()
  {
    AppMethodBeat.i(92157);
    this.bpv = new int['ÿ'];
    this.bin = new m(255);
    AppMethodBeat.o(92157);
  }
  
  public final boolean c(f paramf, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92158);
    this.bin.reset();
    reset();
    if ((paramf.getLength() == -1L) || (paramf.getLength() - paramf.uw() >= 27L)) {
      i = 1;
    }
    while ((i == 0) || (!paramf.b(this.bin.data, 0, 27, true))) {
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
    if (this.bin.dE() != bpn)
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
    this.bpo = this.bin.readUnsignedByte();
    if (this.bpo != 0)
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
    this.type = this.bin.readUnsignedByte();
    this.bpp = this.bin.xi();
    this.bpq = this.bin.xg();
    this.bpr = this.bin.xg();
    this.bps = this.bin.xg();
    this.bpt = this.bin.readUnsignedByte();
    this.bkI = (this.bpt + 27);
    this.bin.reset();
    paramf.b(this.bin.data, 0, this.bpt);
    int i = j;
    while (i < this.bpt)
    {
      this.bpv[i] = this.bin.readUnsignedByte();
      this.bpu += this.bpv[i];
      i += 1;
    }
    AppMethodBeat.o(92158);
    return true;
  }
  
  public final void reset()
  {
    this.bpo = 0;
    this.type = 0;
    this.bpp = 0L;
    this.bpq = 0L;
    this.bpr = 0L;
    this.bps = 0L;
    this.bpt = 0;
    this.bkI = 0;
    this.bpu = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.e
 * JD-Core Version:    0.7.0.1
 */