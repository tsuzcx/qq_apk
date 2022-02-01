package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

final class NotifyReceiver$a$3
  implements Runnable
{
  NotifyReceiver$a$3(NotifyReceiver.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131898);
    if (!g.agP().afY())
    {
      AppMethodBeat.o(131898);
      return;
    }
    if (bs.m((Integer)g.agR().agA().get(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ac.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
      AppMethodBeat.o(131898);
      return;
    }
    long l = bs.eWj();
    if ((l - NotifyReceiver.a.tr() > 0L) && (l - NotifyReceiver.a.tr() < 10000L))
    {
      ac.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", new Object[] { Long.valueOf(l - NotifyReceiver.a.tr()) });
      AppMethodBeat.o(131898);
      return;
    }
    NotifyReceiver.a.oH(l);
    ac.i("MicroMsg.NotifyReceiver", "begin post sync task");
    l = bs.Gn();
    com.tencent.mm.sdk.b.a.GpY.l(new oq());
    ac.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", new Object[] { Long.valueOf(bs.aO(l)) });
    NotifyReceiver.a.b(this.fmv);
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