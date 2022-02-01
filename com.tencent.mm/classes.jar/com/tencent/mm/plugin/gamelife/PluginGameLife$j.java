package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.g.c;
import com.tencent.mm.storagebase.h.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginGameLife$j
  implements h.b
{
  public static final j Dfe;
  
  static
  {
    AppMethodBeat.i(203558);
    Dfe = new j();
    AppMethodBeat.o(203558);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(203556);
    Object localObject = c.DhP;
    localObject = c.dqy();
    AppMethodBeat.o(203556);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.j
 * JD-Core Version:    0.7.0.1
 */