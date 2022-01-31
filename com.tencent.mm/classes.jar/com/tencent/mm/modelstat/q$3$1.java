package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;

final class q$3$1
  implements Runnable
{
  q$3$1(q.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(78789);
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      AppMethodBeat.o(78789);
      return;
    }
    q.akJ().akC();
    AppMethodBeat.o(78789);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78790);
    String str = super.toString() + "|onNetworkChange";
    AppMethodBeat.o(78790);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.q.3.1
 * JD-Core Version:    0.7.0.1
 */