package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.b;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$f
  implements h.b
{
  public static final f qWg;
  
  static
  {
    AppMethodBeat.i(165063);
    qWg = new f();
    AppMethodBeat.o(165063);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(165062);
    Object localObject = b.reh;
    localObject = b.cty();
    AppMethodBeat.o(165062);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.f
 * JD-Core Version:    0.7.0.1
 */