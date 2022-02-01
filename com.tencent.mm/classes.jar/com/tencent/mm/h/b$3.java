package com.tencent.mm.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.zn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class b$3
  implements Runnable
{
  b$3(b paramb, zn paramzn) {}
  
  public final void run()
  {
    AppMethodBeat.i(20096);
    Log.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
    EventCenter.instance.publish(this.iTr);
    AppMethodBeat.o(20096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.b.3
 * JD-Core Version:    0.7.0.1
 */