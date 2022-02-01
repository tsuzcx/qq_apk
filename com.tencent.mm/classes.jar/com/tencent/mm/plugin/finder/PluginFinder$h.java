package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.c;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$h
  implements h.b
{
  public static final h rOZ;
  
  static
  {
    AppMethodBeat.i(201361);
    rOZ = new h();
    AppMethodBeat.o(201361);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(201360);
    Object localObject = c.saq;
    localObject = c.cBk();
    AppMethodBeat.o(201360);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.h
 * JD-Core Version:    0.7.0.1
 */