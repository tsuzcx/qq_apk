package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n$a
{
  public final long awy;
  public final long awz;
  public final i.b axf;
  public final long axg;
  public final long axh;
  public final boolean axi;
  public final boolean axj;
  
  n$a(i.b paramb, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.axf = paramb;
    this.awy = paramLong1;
    this.axg = paramLong2;
    this.awz = paramLong3;
    this.axh = paramLong4;
    this.axi = paramBoolean1;
    this.axj = paramBoolean2;
  }
  
  public final a mZ()
  {
    AppMethodBeat.i(95257);
    a locala = new a(this.axf.dM(-1), this.awy, this.axg, this.awz, this.axh, this.axi, this.axj);
    AppMethodBeat.o(95257);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.n.a
 * JD-Core Version:    0.7.0.1
 */