package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;

final class i$5
  implements Runnable
{
  i$5(i parami, PBool paramPBool, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(141605);
    if (this.jlx.value)
    {
      AppMethodBeat.o(141605);
      return;
    }
    this.jly.run();
    AppMethodBeat.o(141605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.5
 * JD-Core Version:    0.7.0.1
 */