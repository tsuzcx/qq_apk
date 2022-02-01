package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah.b;

final class CoreService$1
  implements ah.b
{
  CoreService$1(CoreService paramCoreService) {}
  
  public final void cancel()
  {
    AppMethodBeat.i(131838);
    MMReceivers.AlarmReceiver.bJ(this.fiA.getApplicationContext());
    AppMethodBeat.o(131838);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(131837);
    MMReceivers.AlarmReceiver.bI(this.fiA.getApplicationContext());
    AppMethodBeat.o(131837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.1
 * JD-Core Version:    0.7.0.1
 */