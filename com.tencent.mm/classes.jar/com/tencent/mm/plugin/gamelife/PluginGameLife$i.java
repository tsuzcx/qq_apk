package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.g.d;
import com.tencent.mm.storagebase.h.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginGameLife$i
  implements h.b
{
  public static final i Dfd;
  
  static
  {
    AppMethodBeat.i(202968);
    Dfd = new i();
    AppMethodBeat.o(202968);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(202965);
    Object localObject = d.DhQ;
    localObject = d.dqy();
    AppMethodBeat.o(202965);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.i
 * JD-Core Version:    0.7.0.1
 */