package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "map", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
final class f$b
  implements b.c
{
  public static final b uyj;
  
  static
  {
    AppMethodBeat.i(211362);
    uyj = new b();
    AppMethodBeat.o(211362);
  }
  
  public final void ab(Map<String, a> paramMap)
  {
    AppMethodBeat.i(211361);
    ad.i("GameLife.ConversationUpdateCallback", "contact prefetch result: ".concat(String.valueOf(paramMap)));
    AppMethodBeat.o(211361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.f.b
 * JD-Core Version:    0.7.0.1
 */