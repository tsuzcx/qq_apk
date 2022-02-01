package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.g.c;
import com.tencent.mm.storagebase.h.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginGameLife$j
  implements h.b
{
  public static final j uwM;
  
  static
  {
    AppMethodBeat.i(211204);
    uwM = new j();
    AppMethodBeat.o(211204);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(211203);
    Object localObject = c.uyp;
    localObject = c.czG();
    AppMethodBeat.o(211203);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.j
 * JD-Core Version:    0.7.0.1
 */