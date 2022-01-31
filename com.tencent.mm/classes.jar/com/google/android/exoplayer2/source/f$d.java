package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$d
  implements l
{
  final int track;
  
  public f$d(f paramf, int paramInt)
  {
    this.track = paramInt;
  }
  
  public final void R(long paramLong)
  {
    AppMethodBeat.i(95485);
    f localf = this.aPK;
    int i = this.track;
    k localk = localf.aPv[i];
    if ((localf.aPJ) && (paramLong > localk.aQn.pd()))
    {
      localk.aQn.pn();
      AppMethodBeat.o(95485);
      return;
    }
    localk.g(paramLong, true);
    AppMethodBeat.o(95485);
  }
  
  public final int b(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(95484);
    f localf = this.aPK;
    int i = this.track;
    if ((localf.aPz) || (localf.pe()))
    {
      AppMethodBeat.o(95484);
      return -3;
    }
    i = localf.aPv[i].a(paramk, parame, paramBoolean, localf.aPJ, localf.aPG);
    AppMethodBeat.o(95484);
    return i;
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(95483);
    f localf = this.aPK;
    int i = this.track;
    if ((localf.aPJ) || ((!localf.pe()) && (localf.aPv[i].aQn.pl())))
    {
      AppMethodBeat.o(95483);
      return true;
    }
    AppMethodBeat.o(95483);
    return false;
  }
  
  public final void oX() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f.d
 * JD-Core Version:    0.7.0.1
 */