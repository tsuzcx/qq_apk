package com.tencent.mm.plugin.expt.hellhound.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderBizListener;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a.a qTX;
  
  static
  {
    AppMethodBeat.i(210677);
    qTX = new a.a((byte)0);
    AppMethodBeat.o(210677);
  }
  
  public static final void a(String paramString, Integer paramInteger, int paramInt)
  {
    AppMethodBeat.i(210678);
    if (paramString == null)
    {
      AppMethodBeat.o(210678);
      return;
    }
    int i;
    if (paramInteger != null)
    {
      paramInteger.intValue();
      localObject = c.qVY;
      if ((!p.i("com.tencent.mm.plugin.finder.ui.FinderHomeUI", paramString)) && (!p.i("com.tencent.mm.plugin.finder.ui.FinderConversationUI", paramString)) && (!p.i("FinderHomeUI", paramString)) && (!p.i("FinderConversationUI", paramString))) {
        break label92;
      }
      i = 1;
    }
    while (i == 0) {
      if ((paramInt == 1) || (paramInt == 0))
      {
        AppMethodBeat.o(210678);
        return;
        AppMethodBeat.o(210678);
        return;
        label92:
        i = 0;
      }
      else if ((paramInt == 3) || (paramInt == 2))
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
        if ((p.i(b.a.cpG(), "143") ^ true)) {
          AppMethodBeat.o(210678);
        }
      }
      else
      {
        AppMethodBeat.o(210678);
        return;
      }
    }
    Object localObject = new hh();
    ((hh)localObject).dtJ.dtK = paramInt;
    ((hh)localObject).dtJ.dtL = paramString;
    ((hh)localObject).dtJ.aHQ = paramInteger.intValue();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    AppMethodBeat.o(210678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a
 * JD-Core Version:    0.7.0.1
 */