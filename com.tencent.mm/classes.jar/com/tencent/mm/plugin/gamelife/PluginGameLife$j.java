package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.g.c;
import com.tencent.mm.storagebase.h.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginGameLife$j
  implements h.b
{
  public static final j yaz;
  
  static
  {
    AppMethodBeat.i(241206);
    yaz = new j();
    AppMethodBeat.o(241206);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(241205);
    Object localObject = c.ycj;
    localObject = c.dax();
    AppMethodBeat.o(241205);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.j
 * JD-Core Version:    0.7.0.1
 */