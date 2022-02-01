package com.tencent.mm.plugin.expt.hellhound.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderBizListener;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a.a rbV;
  
  static
  {
    AppMethodBeat.i(196344);
    rbV = new a.a((byte)0);
    AppMethodBeat.o(196344);
  }
  
  public static final void a(String paramString, Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(196345);
    if (paramString == null)
    {
      AppMethodBeat.o(196345);
      return;
    }
    int i;
    if (paramInteger != null)
    {
      paramInteger.intValue();
      localObject = c.rdX;
      if ((!p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) && (!p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)) && (!p.i("FinderHomeUI", paramString)) && (!p.i("FinderConversationUI", paramString))) {
        break label92;
      }
      i = 1;
    }
    while (i == 0) {
      if ((paramInt == 1) || (paramInt == 0))
      {
        AppMethodBeat.o(196345);
        return;
        AppMethodBeat.o(196345);
        return;
        label92:
        i = 0;
      }
      else if ((paramInt == 3) || (paramInt == 2))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
        if ((p.i(b.a.cri(), "143") ^ true)) {
          AppMethodBeat.o(196345);
        }
      }
      else
      {
        AppMethodBeat.o(196345);
        return;
      }
    }
    Object localObject = new hi();
    ((hi)localObject).duO.duP = paramInt;
    ((hi)localObject).duO.duQ = paramString;
    ((hi)localObject).duO.aHQ = paramInteger.intValue();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(196345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a
 * JD-Core Version:    0.7.0.1
 */