package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.j.c;
import com.tencent.mm.storagebase.h.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginGameLife$g
  implements h.b
{
  public static final g yav;
  
  static
  {
    AppMethodBeat.i(241200);
    yav = new g();
    AppMethodBeat.o(241200);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(241199);
    Object localObject = c.ycx;
    localObject = c.dax();
    AppMethodBeat.o(241199);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.g
 * JD-Core Version:    0.7.0.1
 */