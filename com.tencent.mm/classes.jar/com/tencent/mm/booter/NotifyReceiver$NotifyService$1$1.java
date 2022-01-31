package com.tencent.mm.booter;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.y;

final class NotifyReceiver$NotifyService$1$1
  implements Runnable
{
  NotifyReceiver$NotifyService$1$1(NotifyReceiver.NotifyService.1 param1) {}
  
  public final void run()
  {
    y.i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
    NotifyReceiver.NotifyService.a(this.dhY.dhX, this.dhY.dhW);
    f.nEG.a(99L, 215L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.NotifyService.1.1
 * JD-Core Version:    0.7.0.1
 */