package com.tencent.mm.booter;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class NotifyReceiver$NotifyService$1
  implements com.tencent.mm.kernel.api.g
{
  NotifyReceiver$NotifyService$1(NotifyReceiver.NotifyService paramNotifyService, long paramLong, Intent paramIntent) {}
  
  public final void BN()
  {
    AppMethodBeat.i(57789);
    com.tencent.mm.kernel.g.RM().b(this);
    NotifyReceiver.NotifyService.a(this.dZq);
    long l = System.currentTimeMillis() - this.dZo;
    ab.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.RM().eIn.eIH), Long.valueOf(l), Long.valueOf(Thread.currentThread().getId()) });
    e.qrI.e(11098, new Object[] { Integer.valueOf(3600), Long.valueOf(l) });
    e.qrI.idkeyStat(99L, 214L, 1L, false);
    al.p(new NotifyReceiver.NotifyService.1.1(this), 500L);
    AppMethodBeat.o(57789);
  }
  
  public final void br(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.NotifyService.1
 * JD-Core Version:    0.7.0.1
 */