package com.tencent.mm.plugin.expt.hellhound.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderBizListener;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a.a sCB;
  
  static
  {
    AppMethodBeat.i(220809);
    sCB = new a.a((byte)0);
    AppMethodBeat.o(220809);
  }
  
  public static final void a(String paramString, Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(220810);
    if (paramString == null)
    {
      AppMethodBeat.o(220810);
      return;
    }
    int i;
    if (paramInteger != null)
    {
      paramInteger.intValue();
      localObject = c.sFa;
      if ((!p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) && (!p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)) && (!p.j("FinderHomeUI", paramString)) && (!p.j("FinderConversationUI", paramString))) {
        break label92;
      }
      i = 1;
    }
    while (i == 0) {
      if ((paramInt == 1) || (paramInt == 0))
      {
        AppMethodBeat.o(220810);
        return;
        AppMethodBeat.o(220810);
        return;
        label92:
        i = 0;
      }
      else if ((paramInt == 3) || (paramInt == 2))
      {
        localObject = b.sIy;
        if ((p.j(b.a.cPQ(), "143") ^ true)) {
          AppMethodBeat.o(220810);
        }
      }
      else
      {
        AppMethodBeat.o(220810);
        return;
      }
    }
    Object localObject = new hr();
    ((hr)localObject).dMk.eventId = paramInt;
    ((hr)localObject).dMk.dMl = paramString;
    ((hr)localObject).dMk.aHK = paramInteger.intValue();
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(220810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a
 * JD-Core Version:    0.7.0.1
 */