package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class NotifyReceiver$a$3
  implements Runnable
{
  NotifyReceiver$a$3(NotifyReceiver.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(57782);
    if (!g.RJ().QU())
    {
      AppMethodBeat.o(57782);
      return;
    }
    if (bo.g((Integer)g.RL().Ru().get(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      ab.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
      AppMethodBeat.o(57782);
      return;
    }
    long l = bo.aoy();
    if ((l - NotifyReceiver.a.ov() > 0L) && (l - NotifyReceiver.a.ov() < 10000L))
    {
      ab.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", new Object[] { Long.valueOf(l - NotifyReceiver.a.ov()) });
      AppMethodBeat.o(57782);
      return;
    }
    NotifyReceiver.a.fW(l);
    ab.i("MicroMsg.NotifyReceiver", "begin post sync task");
    l = bo.yB();
    com.tencent.mm.sdk.b.a.ymk.l(new mv());
    ab.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", new Object[] { Long.valueOf(bo.av(l)) });
    NotifyReceiver.a.b(this.dZl);
    AppMethodBeat.o(57782);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57783);
    String str = super.toString() + "|doPostSyncTask";
    AppMethodBeat.o(57783);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.a.3
 * JD-Core Version:    0.7.0.1
 */