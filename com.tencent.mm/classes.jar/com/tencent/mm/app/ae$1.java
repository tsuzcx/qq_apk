package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;

final class ae$1
  implements aw.a
{
  ae$1(ae paramae) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19480);
    String str = bu.cK(ak.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(ak.getPackageName())))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
      AppMethodBeat.o(19480);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
    d.bax("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    AppMethodBeat.o(19480);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ae.1
 * JD-Core Version:    0.7.0.1
 */