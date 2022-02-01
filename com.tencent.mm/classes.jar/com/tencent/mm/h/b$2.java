package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.zn;
import com.tencent.mm.sdk.event.EventCenter;

final class b$2
  implements Runnable
{
  b$2(b paramb, zn paramzn) {}
  
  public final void run()
  {
    AppMethodBeat.i(20095);
    EventCenter.instance.publish(this.iTq);
    AppMethodBeat.o(20095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.b.2
 * JD-Core Version:    0.7.0.1
 */