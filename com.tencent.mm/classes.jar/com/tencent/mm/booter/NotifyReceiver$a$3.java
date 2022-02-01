package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

final class NotifyReceiver$a$3
  implements Runnable
{
  NotifyReceiver$a$3(NotifyReceiver.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131898);
    if (!g.ajP().aiZ())
    {
      AppMethodBeat.o(131898);
      return;
    }
    if (bu.o((Integer)g.ajR().ajA().get(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
      AppMethodBeat.o(131898);
      return;
    }
    long l = bu.fpO();
    if ((l - NotifyReceiver.a.uQ() > 0L) && (l - NotifyReceiver.a.uQ() < 10000L))
    {
      ae.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", new Object[] { Long.valueOf(l - NotifyReceiver.a.uQ()) });
      AppMethodBeat.o(131898);
      return;
    }
    NotifyReceiver.a.qU(l);
    ae.i("MicroMsg.NotifyReceiver", "begin post sync task");
    l = bu.HQ();
    com.tencent.mm.sdk.b.a.IvT.l(new pa());
    ae.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", new Object[] { Long.valueOf(bu.aO(l)) });
    NotifyReceiver.a.b(this.fGG);
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