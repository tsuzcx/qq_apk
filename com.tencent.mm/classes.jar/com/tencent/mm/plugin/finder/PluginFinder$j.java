package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$j
  implements h.b
{
  public static final j rGQ;
  
  static
  {
    AppMethodBeat.i(200943);
    rGQ = new j();
    AppMethodBeat.o(200943);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(200942);
    Object localObject = p.syB;
    localObject = p.czG();
    AppMethodBeat.o(200942);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.j
 * JD-Core Version:    0.7.0.1
 */