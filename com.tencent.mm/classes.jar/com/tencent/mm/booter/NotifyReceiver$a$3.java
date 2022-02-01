package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

final class NotifyReceiver$a$3
  implements Runnable
{
  NotifyReceiver$a$3(NotifyReceiver.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131898);
    if (!g.afz().aeI())
    {
      AppMethodBeat.o(131898);
      return;
    }
    if (bt.l((Integer)g.afB().afk().get(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
      AppMethodBeat.o(131898);
      return;
    }
    long l = bt.eGO();
    if ((l - NotifyReceiver.a.ti() > 0L) && (l - NotifyReceiver.a.ti() < 10000L))
    {
      ad.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", new Object[] { Long.valueOf(l - NotifyReceiver.a.ti()) });
      AppMethodBeat.o(131898);
      return;
    }
    NotifyReceiver.a.lf(l);
    ad.i("MicroMsg.NotifyReceiver", "begin post sync task");
    l = bt.GC();
    com.tencent.mm.sdk.b.a.ESL.l(new oh());
    ad.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", new Object[] { Long.valueOf(bt.aS(l)) });
    NotifyReceiver.a.b(this.fjb);
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