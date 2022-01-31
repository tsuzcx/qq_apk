package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class l$6
  implements Runnable
{
  l$6(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(113839);
    if (this.cbI.Cu() != null) {}
    try
    {
      V8Object localV8Object = this.cbI.Cu().getGlobalObject();
      this.cbI.cbG = localV8Object.getObject("console");
      this.cbI.cbE.add(new p().a(this.cbI));
      this.cbI.cbE.add(new r().a(this.cbI));
      this.cbI.cbE.add(new o(this.cbI.cbf).a(this.cbI));
      this.cbI.cbE.add(new q(this.cbI.cbD).a(this.cbI));
      AppMethodBeat.o(113839);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.e("MicroMsg.J2V8.V8ContextEngine", "get OriginConsole ex: %s", new Object[] { localThrowable.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.l.6
 * JD-Core Version:    0.7.0.1
 */