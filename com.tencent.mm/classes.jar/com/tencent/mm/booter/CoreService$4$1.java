package com.tencent.mm.booter;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class CoreService$4$1
  implements ap.a
{
  CoreService$4$1(CoreService.4 param4) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(57728);
    CoreService.i(this.dYO.dYN).unLock();
    AppMethodBeat.o(57728);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.4.1
 * JD-Core Version:    0.7.0.1
 */