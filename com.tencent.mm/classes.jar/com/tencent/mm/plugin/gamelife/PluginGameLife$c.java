package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.a.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onDone"})
final class PluginGameLife$c
  implements f.a
{
  PluginGameLife$c(AtomicInteger paramAtomicInteger, b paramb, LinkedList paramLinkedList, Runnable paramRunnable) {}
  
  public final void aKD(String paramString)
  {
    AppMethodBeat.i(204485);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (this.DeW.getAndSet(-1) < 0) {
        break label87;
      }
      Log.e("GameLife.PluginGameLife", "checkSessionIdAndContact get session failed");
      this.jFa.invoke(null);
      AppMethodBeat.o(204485);
      return;
    }
    this.DeX.add(paramString);
    this.DeY.run();
    label87:
    AppMethodBeat.o(204485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.c
 * JD-Core Version:    0.7.0.1
 */