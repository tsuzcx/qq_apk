package com.tencent.mm.live.core.core.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/p2p/MMXp2pWrapper$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/p2p/MMXp2pWrapper;", "enableP2p", "", "getInstance", "hasInstance", "releaseInstance", "", "onlyResetReference", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static a beC()
  {
    AppMethodBeat.i(247862);
    if (a.beB() == null) {
      a.b(new a());
    }
    a locala = a.beB();
    s.checkNotNull(locala);
    AppMethodBeat.o(247862);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.b.a.a
 * JD-Core Version:    0.7.0.1
 */