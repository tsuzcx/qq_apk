package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$m
  implements h.b
{
  public static final m rPe;
  
  static
  {
    AppMethodBeat.i(201369);
    rPe = new m();
    AppMethodBeat.o(201369);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(201368);
    Object localObject = d.sIu;
    localObject = d.cBk();
    AppMethodBeat.o(201368);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.m
 * JD-Core Version:    0.7.0.1
 */