package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l$4
  implements Runnable
{
  public l$4(l paraml, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(113838);
    this.cbI.cbC.waitForDebugger(this.cbK);
    if (this.cbI.cbG != null) {
      this.cbI.Cu().getGlobalObject().add("console", this.cbI.cbG);
    }
    AppMethodBeat.o(113838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.d.a.l.4
 * JD-Core Version:    0.7.0.1
 */