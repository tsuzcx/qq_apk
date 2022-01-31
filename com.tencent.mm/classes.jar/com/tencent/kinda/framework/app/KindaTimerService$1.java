package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

class KindaTimerService$1
  implements ap.a
{
  KindaTimerService$1(KindaTimerService paramKindaTimerService) {}
  
  public boolean onTimerExpired()
  {
    AppMethodBeat.i(144409);
    KindaTimerService.access$000(this.this$0).call();
    ab.d("KindaTimerService", "A callback to C++ from Kinda timer was performed.");
    AppMethodBeat.o(144409);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaTimerService.1
 * JD-Core Version:    0.7.0.1
 */