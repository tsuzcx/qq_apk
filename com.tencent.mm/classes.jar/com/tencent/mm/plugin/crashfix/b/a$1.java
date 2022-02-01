package com.tencent.mm.plugin.crashfix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(145617);
    try
    {
      Log.i("MicroMsg.SafeDismissDialog", "run on hijack runnable");
      a.a(this.xfi).run();
      AppMethodBeat.o(145617);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SafeDismissDialog", "protect : " + localException.getMessage());
      AppMethodBeat.o(145617);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.b.a.1
 * JD-Core Version:    0.7.0.1
 */