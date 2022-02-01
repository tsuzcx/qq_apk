package com.tencent.mm.live.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/plugin/LiveVisitorPreviewPlugin$exitRoom$1", "Lcom/tencent/mm/live/core/core/LiveCallback;", "callback", "", "errorCode", "", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class bk$c
  implements b
{
  public final void f(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(190392);
    ac.i("MicroMsg.LiveCoreVisitor", "on exit room finish");
    AppMethodBeat.o(190392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.bk.c
 * JD-Core Version:    0.7.0.1
 */