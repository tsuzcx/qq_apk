package com.tencent.magicbrush.d;

import a.l;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$a
  implements Runnable
{
  c$a(MBRuntime paramMBRuntime, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(151507);
    if (this.bLL.isDestroyedUnlock())
    {
      AppMethodBeat.o(151507);
      return;
    }
    this.bLM.run();
    AppMethodBeat.o(151507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.d.c.a
 * JD-Core Version:    0.7.0.1
 */