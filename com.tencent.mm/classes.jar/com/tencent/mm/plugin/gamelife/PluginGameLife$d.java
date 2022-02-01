package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.l;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
final class PluginGameLife$d
  implements b.c
{
  PluginGameLife$d(String paramString1, String paramString2, Runnable paramRunnable, AtomicInteger paramAtomicInteger, b paramb) {}
  
  public final void ah(Map<String, a> paramMap)
  {
    AppMethodBeat.i(211956);
    a locala = (a)paramMap.get(this.uIh);
    if ((locala != null) && (locala.isValid() == true))
    {
      paramMap = (a)paramMap.get(this.sxw);
      if ((paramMap != null) && (paramMap.isValid() == true))
      {
        this.uIg.run();
        AppMethodBeat.o(211956);
        return;
      }
    }
    if (this.uIe.getAndSet(-1) >= 0)
    {
      ae.e("GameLife.PluginGameLife", "checkSessionIdAndContact get contact failed");
      this.gll.invoke(null);
    }
    AppMethodBeat.o(211956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.d
 * JD-Core Version:    0.7.0.1
 */