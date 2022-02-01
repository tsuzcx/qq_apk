package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.a;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
final class PluginGameLife$d
  implements b.c
{
  PluginGameLife$d(String paramString1, String paramString2, Runnable paramRunnable, AtomicInteger paramAtomicInteger, b paramb) {}
  
  public final void ac(Map<String, a> paramMap)
  {
    AppMethodBeat.i(203900);
    a locala = (a)paramMap.get(this.DeZ);
    if ((locala != null) && (locala.isValid() == true))
    {
      paramMap = (a)paramMap.get(this.sJQ);
      if ((paramMap != null) && (paramMap.isValid() == true))
      {
        this.DeY.run();
        AppMethodBeat.o(203900);
        return;
      }
    }
    if (this.DeW.getAndSet(-1) >= 0)
    {
      Log.e("GameLife.PluginGameLife", "checkSessionIdAndContact get contact failed");
      this.jFa.invoke(null);
    }
    AppMethodBeat.o(203900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.d
 * JD-Core Version:    0.7.0.1
 */