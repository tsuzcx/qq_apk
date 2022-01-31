package com.tencent.mm.plugin.card.compat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.card.compat.a.b;

public final class PluginCardCompat
  extends f
  implements b
{
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(18649);
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.card.compat.a.a.class, new e(new a()));
    }
    AppMethodBeat.o(18649);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(18648);
    super.installed();
    alias(b.class);
    AppMethodBeat.o(18648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.compat.PluginCardCompat
 * JD-Core Version:    0.7.0.1
 */