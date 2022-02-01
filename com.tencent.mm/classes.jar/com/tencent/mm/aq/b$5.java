package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class b$5
  implements MTimerHandler.CallBack
{
  b$5(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(206976);
    Log.i("MicroMsg.CdnTransportService", "cdnCallbackExecuteTimeReport onTimerExpired");
    b.b(this.lIb);
    AppMethodBeat.o(206976);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aq.b.5
 * JD-Core Version:    0.7.0.1
 */