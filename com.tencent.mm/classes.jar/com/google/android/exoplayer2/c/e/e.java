package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;

final class e
{
  private static final int bps;
  private final m biq;
  public int bkN;
  public final int[] bpA;
  public int bpt;
  public long bpu;
  public long bpv;
  public long bpw;
  public long bpx;
  public int bpy;
  public int bpz;
  public int type;
  
  static
  {
    AppMethodBeat.i(92159);
    bps = x.bJ("OggS");
    AppMethodBeat.o(92159);
  }
  
  e()
  {
    AppMethodBeat.i(92157);
    this.bpA = new int['ÿ'];
    this.biq = new m(255);
    AppMethodBeat.o(92157);
  }
  
  public final boolean c(f paramf, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(92158);
    this.biq.reset();
    reset();
    if ((paramf.getLength() == -1L) || (paramf.getLength() - paramf.ur() >= 27L)) {
      i = 1;
    }
    while ((i == 0) || (!paramf.b(this.biq.data, 0, 27, true))) {
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
    if (this.biq.dB() != bps)
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
    this.bpt = this.biq.readUnsignedByte();
    if (this.bpt != 0)
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
    this.type = this.biq.readUnsignedByte();
    this.bpu = this.biq.xa();
    this.bpv = this.biq.wY();
    this.bpw = this.biq.wY();
    this.bpx = this.biq.wY();
    this.bpy = this.biq.readUnsignedByte();
    this.bkN = (this.bpy + 27);
    this.biq.reset();
    paramf.b(this.biq.data, 0, this.bpy);
    int i = j;
    while (i < this.bpy)
    {
      this.bpA[i] = this.biq.readUnsignedByte();
      this.bpz += this.bpA[i];
      i += 1;
    }
    AppMethodBeat.o(92158);
    return true;
  }
  
  public final void reset()
  {
    this.bpt = 0;
    this.type = 0;
    this.bpu = 0L;
    this.bpv = 0L;
    this.bpw = 0L;
    this.bpx = 0L;
    this.bpy = 0;
    this.bkN = 0;
    this.bpz = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.e
 * JD-Core Version:    0.7.0.1
 */