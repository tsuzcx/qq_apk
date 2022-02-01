package com.tencent.mm.plugin.expt.hellhound.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ia;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderBizListener;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a.a wiv;
  
  static
  {
    AppMethodBeat.i(256811);
    wiv = new a.a((byte)0);
    AppMethodBeat.o(256811);
  }
  
  public static final void a(String paramString, Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(256813);
    if (paramString == null)
    {
      AppMethodBeat.o(256813);
      return;
    }
    int i;
    if (paramInteger != null)
    {
      paramInteger.intValue();
      localObject = c.wkV;
      if ((!p.h("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) && (!p.h("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)) && (!p.h("FinderHomeUI", paramString)) && (!p.h("FinderConversationUI", paramString))) {
        break label92;
      }
      i = 1;
    }
    while (i == 0) {
      if ((paramInt == 1) || (paramInt == 0))
      {
        AppMethodBeat.o(256813);
        return;
        AppMethodBeat.o(256813);
        return;
        label92:
        i = 0;
      }
      else if ((paramInt == 3) || (paramInt == 2))
      {
        localObject = b.wov;
        if ((p.h(b.a.deK(), "143") ^ true)) {
          AppMethodBeat.o(256813);
        }
      }
      else
      {
        AppMethodBeat.o(256813);
        return;
      }
    }
    Object localObject = new ia();
    ((ia)localObject).fFd.eventId = paramInt;
    ((ia)localObject).fFd.fFe = paramString;
    ((ia)localObject).fFd.aNf = paramInteger.intValue();
    EventCenter.instance.publish((IEvent)localObject);
    AppMethodBeat.o(256813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a
 * JD-Core Version:    0.7.0.1
 */