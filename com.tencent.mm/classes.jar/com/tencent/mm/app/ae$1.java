package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

final class ae$1
  implements MTimerHandler.CallBack
{
  ae$1(ae paramae) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19480);
    String str = Util.getTopActivityName(MMApplicationContext.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(MMApplicationContext.getSourcePackageName())))
    {
      Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
      AppMethodBeat.o(19480);
      return false;
    }
    Log.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
    d.bpG("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    AppMethodBeat.o(19480);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.ae.1
 * JD-Core Version:    0.7.0.1
 */