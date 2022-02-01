package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$f
  implements h.b
{
  public static final f rOX;
  
  static
  {
    AppMethodBeat.i(201357);
    rOX = new f();
    AppMethodBeat.o(201357);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(201356);
    Object localObject = i.sIL;
    localObject = i.cBk();
    AppMethodBeat.o(201356);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.f
 * JD-Core Version:    0.7.0.1
 */