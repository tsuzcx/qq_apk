package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
final class f$b
  implements b.c
{
  public static final b uJM;
  
  static
  {
    AppMethodBeat.i(212133);
    uJM = new b();
    AppMethodBeat.o(212133);
  }
  
  public final void ah(Map<String, a> paramMap)
  {
    AppMethodBeat.i(212132);
    ae.i("GameLife.ConversationUpdateCallback", "contact prefetch result: ".concat(String.valueOf(paramMap)));
    AppMethodBeat.o(212132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.f.b
 * JD-Core Version:    0.7.0.1
 */