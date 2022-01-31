package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class l$9
  implements Runnable
{
  l$9(l paraml, String paramString1, l.b paramb, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(113842);
    ab.d("MicroMsg.J2V8.V8ContextEngine", "eval with script(%s)", new Object[] { this.cbO });
    if (this.cbN != null)
    {
      Object localObject = this.cbI.Cu().executeScript(this.byz, this.cbO, 0);
      l.b localb = this.cbN;
      if (localObject == null) {}
      for (localObject = null;; localObject = localObject.toString())
      {
        localb.dO((String)localObject);
        AppMethodBeat.o(113842);
        return;
      }
    }
    this.cbI.Cu().executeVoidScript(this.byz, this.cbO, 0);
    AppMethodBeat.o(113842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.a.l.9
 * JD-Core Version:    0.7.0.1
 */