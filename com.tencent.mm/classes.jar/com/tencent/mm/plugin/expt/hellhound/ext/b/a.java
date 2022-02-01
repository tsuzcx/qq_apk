package com.tencent.mm.plugin.expt.hellhound.ext.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.il;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b;
import com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderBizListener;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a zEy;
  
  static
  {
    AppMethodBeat.i(300257);
    zEy = new a.a((byte)0);
    AppMethodBeat.o(300257);
  }
  
  public static final void a(String paramString, Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(300254);
    if ((paramString != null) && (paramInteger != null))
    {
      paramInteger.intValue();
      Object localObject = c.zGj;
      int i;
      if ((s.p("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI", paramString)) || (s.p("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)) || (s.p("FinderHomeUI", paramString)) || (s.p("FinderHomeAffinityUI", paramString)) || (s.p("FinderConversationUI", paramString))) {
        i = 1;
      }
      while (i == 0) {
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(300254);
          return;
          i = 0;
          break;
        case 0: 
        case 1: 
          AppMethodBeat.o(300254);
          return;
        case 2: 
        case 3: 
          localObject = b.zKz;
          if (!s.p(b.a.dLz(), "143"))
          {
            AppMethodBeat.o(300254);
            return;
          }
          break;
        }
      }
      localObject = new il();
      ((il)localObject).hJV.eventId = paramInt;
      ((il)localObject).hJV.hJW = paramString;
      ((il)localObject).hJV.cHb = paramInteger.intValue();
      ((il)localObject).publish();
    }
    AppMethodBeat.o(300254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a
 * JD-Core Version:    0.7.0.1
 */