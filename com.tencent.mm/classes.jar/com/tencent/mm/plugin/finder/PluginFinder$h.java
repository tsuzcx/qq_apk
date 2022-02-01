package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$h
  implements h.b
{
  public static final h qnM;
  
  static
  {
    AppMethodBeat.i(165065);
    qnM = new h();
    AppMethodBeat.o(165065);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(165064);
    Object localObject = i.KWu;
    localObject = i.clk();
    AppMethodBeat.o(165064);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.h
 * JD-Core Version:    0.7.0.1
 */