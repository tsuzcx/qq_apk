package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.j.c;
import com.tencent.mm.storagebase.h.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
final class PluginGameLife$g
  implements h.b
{
  public static final g Dfb;
  
  static
  {
    AppMethodBeat.i(202770);
    Dfb = new g();
    AppMethodBeat.o(202770);
  }
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(202769);
    Object localObject = c.Dic;
    localObject = c.dqy();
    AppMethodBeat.o(202769);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.g
 * JD-Core Version:    0.7.0.1
 */