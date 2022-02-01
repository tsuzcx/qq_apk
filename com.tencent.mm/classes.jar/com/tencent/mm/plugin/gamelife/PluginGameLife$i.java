package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.g.d;
import com.tencent.mm.storagebase.h.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginGameLife$i
  implements h.b
{
  public static final i yay;
  
  static
  {
    AppMethodBeat.i(241204);
    yay = new i();
    AppMethodBeat.o(241204);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(241203);
    Object localObject = d.yck;
    localObject = d.dax();
    AppMethodBeat.o(241203);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.i
 * JD-Core Version:    0.7.0.1
 */