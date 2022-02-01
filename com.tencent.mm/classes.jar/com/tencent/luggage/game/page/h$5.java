package com.tencent.luggage.game.page;

import com.tencent.luggage.game.c.e.c;
import com.tencent.luggage.game.c.f;
import com.tencent.luggage.game.d.a.a.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a;
import com.tencent.magicbrush.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

final class h$5
  implements e.c
{
  h$5(h paramh, b paramb) {}
  
  public final void B(List<f> paramList)
  {
    AppMethodBeat.i(178041);
    try
    {
      h localh = this.clm;
      Object localObject = this.clp.getMagicBrush();
      if (localObject == null)
      {
        ad.e("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
        AppMethodBeat.o(178041);
        return;
      }
      localObject = ((MBRuntime)localObject).clA.GR();
      paramList.add(new f("MinFPS", Math.round(localh.clj)));
      paramList.add(new f("RT-FPS", Math.round(((a)localObject).cvL)));
      paramList.add(new f("EX-FPS", Math.round(((a)localObject).cvM)));
      AppMethodBeat.o(178041);
      return;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(178041);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.page.h.5
 * JD-Core Version:    0.7.0.1
 */