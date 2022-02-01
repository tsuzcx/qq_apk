package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginFinder$n
  implements h.b
{
  public static final n rPf;
  
  static
  {
    AppMethodBeat.i(201371);
    rPf = new n();
    AppMethodBeat.o(201371);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(201370);
    Object localObject = w.sJX;
    localObject = w.cBk();
    AppMethodBeat.o(201370);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.PluginFinder.n
 * JD-Core Version:    0.7.0.1
 */