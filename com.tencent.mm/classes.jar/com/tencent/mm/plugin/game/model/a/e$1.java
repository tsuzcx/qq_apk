package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;

final class e$1
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(41674);
    if ((g.aAc()) && (g.aAf().hpY))
    {
      g.aAf();
      if (!a.azj())
      {
        paramString = new jb();
        paramString.dNJ.dDe = 1;
        EventCenter.instance.publish(paramString);
      }
    }
    AppMethodBeat.o(41674);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(41673);
    if ((g.aAc()) && (g.aAf().hpY))
    {
      g.aAf();
      if (!a.azj())
      {
        paramString = new jb();
        paramString.dNJ.dDe = 2;
        EventCenter.instance.publish(paramString);
      }
    }
    AppMethodBeat.o(41673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e.1
 * JD-Core Version:    0.7.0.1
 */