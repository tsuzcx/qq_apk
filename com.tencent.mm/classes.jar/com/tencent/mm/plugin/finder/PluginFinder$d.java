package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$d
  implements h.b
{
  public static final d rOV;
  
  static
  {
    AppMethodBeat.i(201353);
    rOV = new d();
    AppMethodBeat.o(201353);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(201352);
    Object localObject = c.sIt;
    localObject = c.cBk();
    AppMethodBeat.o(201352);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.d
 * JD-Core Version:    0.7.0.1
 */