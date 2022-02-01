package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;

final class ae$1
  implements au.a
{
  ae$1(ae paramae) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(19480);
    String str = bs.cL(ai.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(ai.getPackageName())))
    {
      ac.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
      AppMethodBeat.o(19480);
      return false;
    }
    ac.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
    d.aSU("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    AppMethodBeat.o(19480);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ae.1
 * JD-Core Version:    0.7.0.1
 */