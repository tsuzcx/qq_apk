package com.tencent.mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

final class URISpanHandlerSet$JumpPatSettingUriSpanHandler$1
  implements Runnable
{
  URISpanHandlerSet$JumpPatSettingUriSpanHandler$1(URISpanHandlerSet.JumpPatSettingUriSpanHandler paramJumpPatSettingUriSpanHandler) {}
  
  public final void run()
  {
    AppMethodBeat.i(290204);
    LauncherUI localLauncherUI = LauncherUI.getInstance();
    if (localLauncherUI != null)
    {
      localLauncherUI.closeChatting(false);
      localLauncherUI.VXk.getMainTabUI().byt("tab_settings");
    }
    AppMethodBeat.o(290204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.URISpanHandlerSet.JumpPatSettingUriSpanHandler.1
 * JD-Core Version:    0.7.0.1
 */