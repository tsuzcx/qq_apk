package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class l$10
  implements Runnable
{
  public l$10(l paraml, String paramString1, l.b paramb, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    AppMethodBeat.i(145891);
    ab.d("MicroMsg.J2V8.V8ContextEngine", "eval script(%s) with code cache", new Object[] { this.cbO });
    if (this.cbN != null)
    {
      Object localObject = this.cbI.Cu().executeScript(this.byz, this.cbO, 0, this.cbP, this.cbQ);
      l.b localb = this.cbN;
      if (localObject == null) {}
      for (localObject = null;; localObject = localObject.toString())
      {
        localb.dO((String)localObject);
        AppMethodBeat.o(145891);
        return;
      }
    }
    this.cbI.Cu().executeVoidScript(this.byz, this.cbO, 0, this.cbP, this.cbQ);
    AppMethodBeat.o(145891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.a.l.10
 * JD-Core Version:    0.7.0.1
 */