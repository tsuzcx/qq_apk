package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$j
  implements h.b
{
  public static final j rPb;
  
  static
  {
    AppMethodBeat.i(201365);
    rPb = new j();
    AppMethodBeat.o(201365);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(201364);
    Object localObject = p.sJs;
    localObject = p.cBk();
    AppMethodBeat.o(201364);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.j
 * JD-Core Version:    0.7.0.1
 */