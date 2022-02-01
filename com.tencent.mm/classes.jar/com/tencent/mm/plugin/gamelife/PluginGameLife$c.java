package com.tencent.mm.plugin.gamelife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.a.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.l;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onDone"})
final class PluginGameLife$c
  implements f.a
{
  PluginGameLife$c(AtomicInteger paramAtomicInteger, b paramb, LinkedList paramLinkedList, Runnable paramRunnable) {}
  
  public final void onDone(String paramString)
  {
    AppMethodBeat.i(211955);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (this.uIe.getAndSet(-1) < 0) {
        break label87;
      }
      ae.e("GameLife.PluginGameLife", "checkSessionIdAndContact get session failed");
      this.gll.invoke(null);
      AppMethodBeat.o(211955);
      return;
    }
    this.uIf.add(paramString);
    this.uIg.run();
    label87:
    AppMethodBeat.o(211955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.c
 * JD-Core Version:    0.7.0.1
 */