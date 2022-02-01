package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;

final class ae$1
  implements av.a
{
  ae$1(ae paramae) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19480);
    String str = bt.cI(aj.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(aj.getPackageName())))
    {
      ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
      AppMethodBeat.o(19480);
      return false;
    }
    ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
    d.aYU("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    AppMethodBeat.o(19480);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ae.1
 * JD-Core Version:    0.7.0.1
 */