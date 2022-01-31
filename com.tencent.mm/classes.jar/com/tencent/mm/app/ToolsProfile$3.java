package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.xweb.WebView;

final class ToolsProfile$3
  implements ap.a
{
  ToolsProfile$3(ToolsProfile paramToolsProfile) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(15408);
    ab.i(ToolsProfile.access$000(), "onTimerExpired, check kill tools process");
    if (ToolsProfile.a(this.bZj) == 0)
    {
      ToolsProfile.a.access$200();
      boolean bool = WebView.getCanReboot();
      ab.i(ToolsProfile.access$000(), "onTimerExpired, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
      if ((bool) || (!ToolsProfile.a.isLocked()))
      {
        d.awm("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        AppMethodBeat.o(15408);
        return false;
      }
    }
    AppMethodBeat.o(15408);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.3
 * JD-Core Version:    0.7.0.1
 */