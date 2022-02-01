package com.tencent.mm.booter;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import java.util.ArrayList;

final class NotifyReceiver$NotifyReceiverService$1
  implements Runnable
{
  NotifyReceiver$NotifyReceiverService$1(NotifyReceiver.NotifyReceiverService paramNotifyReceiverService, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(196982);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1042);
    localIDKey.SetKey(63);
    localIDKey.SetValue(1L);
    this.val$list.add(localIDKey);
    e.Cxv.b(this.val$list, false);
    AppMethodBeat.o(196982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.NotifyReceiverService.1
 * JD-Core Version:    0.7.0.1
 */