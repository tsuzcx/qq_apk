package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.findersdk.a.o;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderEnterPersonalMsgService;", "()V", "checkUpdatePersonalMsg", "", "sessionId", "", "Companion", "plugin-finder_release"})
public final class c
  implements o
{
  public static final a Adm;
  
  static
  {
    AppMethodBeat.i(275327);
    Adm = new a((byte)0);
    AppMethodBeat.o(275327);
  }
  
  public final void aEC(String paramString)
  {
    AppMethodBeat.i(275325);
    p.k(paramString, "sessionId");
    d.h((a)new b(paramString));
    AppMethodBeat.o(275325);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService$Companion;", "", "()V", "MMFinderPersonalMsgScene_Finder", "", "MMFinderPersonalMsgScene_WX", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.c
 * JD-Core Version:    0.7.0.1
 */