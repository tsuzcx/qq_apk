package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

public final class h
{
  static int index = 0;
  private h.a jEj;
  int[] jFO;
  int jFP;
  boolean jFQ;
  ap jFR;
  
  public h(h.a parama)
  {
    AppMethodBeat.i(17673);
    this.jFO = new int[] { 1000, 1000, 1000, 2000, 5000, 9000, 1000 };
    this.jFP = 0;
    this.jFQ = false;
    this.jFR = new ap(Looper.getMainLooper(), new h.1(this), false);
    this.jEj = parama;
    AppMethodBeat.o(17673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h
 * JD-Core Version:    0.7.0.1
 */