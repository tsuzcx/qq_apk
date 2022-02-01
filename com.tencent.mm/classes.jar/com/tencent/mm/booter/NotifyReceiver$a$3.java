package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

final class NotifyReceiver$a$3
  implements Runnable
{
  NotifyReceiver$a$3(NotifyReceiver.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131898);
    if (!h.aHE().aGM())
    {
      AppMethodBeat.o(131898);
      return;
    }
    if (Util.nullAsNil((Integer)h.aHG().aHp().b(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
      AppMethodBeat.o(131898);
      return;
    }
    long l = Util.nowMilliSecond();
    if ((l - NotifyReceiver.a.sQ() > 0L) && (l - NotifyReceiver.a.sQ() < 10000L))
    {
      Log.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", new Object[] { Long.valueOf(l - NotifyReceiver.a.sQ()) });
      AppMethodBeat.o(131898);
      return;
    }
    NotifyReceiver.a.EN(l);
    Log.i("MicroMsg.NotifyReceiver", "begin post sync task");
    l = Util.currentTicks();
    EventCenter.instance.publish(new qq());
    Log.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    NotifyReceiver.a.b(this.iPY);
    AppMethodBeat.o(131898);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(131899);
    String str = super.toString() + "|doPostSyncTask";
    AppMethodBeat.o(131899);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.a.3
 * JD-Core Version:    0.7.0.1
 */