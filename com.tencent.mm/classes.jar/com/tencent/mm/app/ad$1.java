package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;

final class ad$1
  implements av.a
{
  ad$1(ad paramad) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19480);
    String str = bt.cC(aj.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(aj.getPackageName())))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
      AppMethodBeat.o(19480);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
    d.aNr("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    AppMethodBeat.o(19480);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ad.1
 * JD-Core Version:    0.7.0.1
 */