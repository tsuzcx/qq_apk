package com.tencent.mm.booter;

import com.tencent.mm.h.a.md;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class NotifyReceiver$a$3
  implements Runnable
{
  NotifyReceiver$a$3(NotifyReceiver.a parama) {}
  
  public final void run()
  {
    if (!g.DN().Dc()) {
      return;
    }
    if (bk.g((Integer)g.DP().Dz().get(15, null)) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      y.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
      return;
    }
    long l = bk.UY();
    if ((l - NotifyReceiver.a.me() > 0L) && (l - NotifyReceiver.a.me() < 10000L))
    {
      y.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", new Object[] { Long.valueOf(l - NotifyReceiver.a.me()) });
      return;
    }
    NotifyReceiver.a.bm(l);
    y.i("MicroMsg.NotifyReceiver", "begin post sync task");
    l = bk.UZ();
    com.tencent.mm.sdk.b.a.udP.m(new md());
    y.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", new Object[] { Long.valueOf(bk.cp(l)) });
    NotifyReceiver.a.b(this.dhS);
  }
  
  public final String toString()
  {
    return super.toString() + "|doPostSyncTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.a.3
 * JD-Core Version:    0.7.0.1
 */