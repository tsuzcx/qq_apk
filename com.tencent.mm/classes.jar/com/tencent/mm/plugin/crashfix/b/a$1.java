package com.tencent.mm.plugin.crashfix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(154694);
    try
    {
      ab.i("MicroMsg.SafeDismissDialog", "run on hijack runnable");
      a.a(this.kTa).run();
      AppMethodBeat.o(154694);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SafeDismissDialog", "protect : " + localException.getMessage());
      AppMethodBeat.o(154694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.b.a.1
 * JD-Core Version:    0.7.0.1
 */