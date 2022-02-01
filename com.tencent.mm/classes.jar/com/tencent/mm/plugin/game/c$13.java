package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.it;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class c$13
  extends o.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(204083);
    if ((g.aAc()) && (g.aAf().hpY))
    {
      g.aAf();
      a.azj();
    }
    AppMethodBeat.o(204083);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(204082);
    if ((g.aAc()) && (g.aAf().hpY))
    {
      g.aAf();
      if (!a.azj())
      {
        paramString = Long.valueOf(Util.nullAsNil((Long)g.aAh().azQ().get(ar.a.OcZ, Long.valueOf(0L))));
        if ((paramString.longValue() != 0L) && (Util.nowSecond() > paramString.longValue())) {
          b.dTd().I(true, 1);
        }
        int i = ((Integer)g.aAh().azQ().get(ar.a.Odf, Integer.valueOf(0))).intValue();
        if (1 != i)
        {
          Log.i("MicroMsg.GameEventListener", "checkVersionChange lastVersion:%d, currentVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
          g.aAh().azQ().set(ar.a.Odf, Integer.valueOf(1));
          paramString = new it();
          paramString.dNs.EX = 5;
          paramString.dNs.param = "5";
          EventCenter.instance.publish(paramString);
        }
      }
    }
    AppMethodBeat.o(204082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.13
 * JD-Core Version:    0.7.0.1
 */