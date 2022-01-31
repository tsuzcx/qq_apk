package com.tencent.mm.plugin.location.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class k$3
  implements ap.a
{
  k$3(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(113532);
    this.oeg.display();
    AppMethodBeat.o(113532);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.3
 * JD-Core Version:    0.7.0.1
 */