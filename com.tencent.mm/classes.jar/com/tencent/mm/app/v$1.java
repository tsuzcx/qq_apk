package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class v$1
  implements ap.a
{
  v$1(v paramv) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(153473);
    String str = bo.ch(ah.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(ah.getPackageName())))
    {
      ab.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, top activity belongs to mm, skip kill tools");
      AppMethodBeat.o(153473);
      return false;
    }
    ab.i("MicroMsg.TempAppForegroundNotifyDeprecated", "onTimerExpired, kill tools process");
    d.awm("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    AppMethodBeat.o(153473);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.v.1
 * JD-Core Version:    0.7.0.1
 */