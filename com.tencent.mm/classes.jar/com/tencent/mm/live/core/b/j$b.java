package com.tencent.mm.live.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.c.c;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
final class j$b
  implements MTimerHandler.CallBack
{
  j$b(j paramj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(196686);
    if (j.a(this.hEu) <= 5) {
      c.aEO();
    }
    for (;;)
    {
      c.qF(j.a(this.hEu));
      j.b(this.hEu);
      AppMethodBeat.o(196686);
      return true;
      if (j.a(this.hEu) <= 10) {
        c.aEP();
      } else if (j.a(this.hEu) > 10) {
        c.aEQ();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.b.j.b
 * JD-Core Version:    0.7.0.1
 */