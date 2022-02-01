package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.findersdk.a.ac;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderEnterPersonalMsgService;", "()V", "checkUpdatePersonalMsg", "", "sessionId", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements ac
{
  public static final a FyW;
  
  static
  {
    AppMethodBeat.i(330046);
    FyW = new a((byte)0);
    AppMethodBeat.o(330046);
  }
  
  public final void aAv(String paramString)
  {
    AppMethodBeat.i(330053);
    s.u(paramString, "sessionId");
    d.B((a)new b(paramString));
    AppMethodBeat.o(330053);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderEnterPersonalMsgService$Companion;", "", "()V", "MMFinderPersonalMsgScene_Finder", "", "MMFinderPersonalMsgScene_WX", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.c
 * JD-Core Version:    0.7.0.1
 */