package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
final class g$b
  implements b.c
{
  public static final b DhJ;
  
  static
  {
    AppMethodBeat.i(203872);
    DhJ = new b();
    AppMethodBeat.o(203872);
  }
  
  public final void ac(Map<String, a> paramMap)
  {
    AppMethodBeat.i(203870);
    Log.i("GameLife.ConversationUpdateCallback", "contact prefetch result: ".concat(String.valueOf(paramMap)));
    AppMethodBeat.o(203870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.g.b
 * JD-Core Version:    0.7.0.1
 */