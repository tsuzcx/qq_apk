package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Timer;

final class m$1
  implements Runnable
{
  m$1(m paramm, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(113852);
    if (this.cbW.cba == null)
    {
      localObject = new IllegalStateException("V8DebuggerHelper v8 null");
      AppMethodBeat.o(113852);
      throw ((Throwable)localObject);
    }
    this.cbW.cba.waitForDebugger(this.cbK);
    Object localObject = this.cbW;
    if (((m)localObject).cbU == null)
    {
      ((m)localObject).cbU = new Timer();
      ((m)localObject).cbU.schedule(new m.4((m)localObject), 2000L, 2000L);
    }
    AppMethodBeat.o(113852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.m.1
 * JD-Core Version:    0.7.0.1
 */