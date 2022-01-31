package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$8
  implements Runnable
{
  l$8(l paraml, l.b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(113841);
    if (this.cbN != null)
    {
      Object localObject = this.cbI.Cu().executeScript(this.byz);
      l.b localb = this.cbN;
      if (localObject == null) {}
      for (localObject = null;; localObject = localObject.toString())
      {
        localb.dO((String)localObject);
        AppMethodBeat.o(113841);
        return;
      }
    }
    this.cbI.Cu().executeVoidScript(this.byz);
    AppMethodBeat.o(113841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.d.a.l.8
 * JD-Core Version:    0.7.0.1
 */