package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.ad;
import com.tencent.mm.storagebase.h.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$r
  implements h.b
{
  public static final r wWh;
  
  static
  {
    AppMethodBeat.i(224605);
    wWh = new r();
    AppMethodBeat.o(224605);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(224602);
    Object localObject = ad.Amo;
    localObject = ad.dqy();
    AppMethodBeat.o(224602);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.r
 * JD-Core Version:    0.7.0.1
 */