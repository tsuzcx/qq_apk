package com.tencent.mm.booter;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import java.util.ArrayList;

final class NotifyReceiver$1
  implements Runnable
{
  NotifyReceiver$1(NotifyReceiver paramNotifyReceiver, ArrayList paramArrayList) {}
  
  public final void run()
  {
    AppMethodBeat.i(238911);
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(1042);
    localIDKey.SetKey(61);
    localIDKey.SetValue(1L);
    this.val$list.add(localIDKey);
    f.Ozc.b(this.val$list, false);
    AppMethodBeat.o(238911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.NotifyReceiver.1
 * JD-Core Version:    0.7.0.1
 */