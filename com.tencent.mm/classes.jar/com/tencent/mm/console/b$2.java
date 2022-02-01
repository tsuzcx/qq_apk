package com.tencent.mm.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.sdk.event.EventCenter;

final class b$2
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(20105);
    EventCenter.instance.publish(new vv());
    AppMethodBeat.o(20105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.b.2
 * JD-Core Version:    0.7.0.1
 */