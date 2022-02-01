package com.tencent.mm.plugin.emoji.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.d.h.a;

final class f$1
  implements h.a
{
  f$1(String paramString) {}
  
  public final void onResult(boolean paramBoolean)
  {
    AppMethodBeat.i(108439);
    if (paramBoolean)
    {
      f.eb(this.oJE, 1);
      AppMethodBeat.o(108439);
      return;
    }
    f.eb(this.oJE, 2);
    AppMethodBeat.o(108439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.f.1
 * JD-Core Version:    0.7.0.1
 */