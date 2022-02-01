package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;

final class LaunchAAUI$22
  implements y.a
{
  LaunchAAUI$22(LaunchAAUI paramLaunchAAUI, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(213043);
    if (paramBoolean)
    {
      Log.i("MicroMsg.Aa.LaunchAAUI", "click launchDialog confirm，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.b(this.jXQ)), Integer.valueOf(LaunchAAUI.c(this.jXQ)) });
      LaunchAAUI.b(this.jXQ, this.gtu);
      this.jXQ.uZ(12);
      h.CyF.a(13721, new Object[] { Integer.valueOf(8), Integer.valueOf(4) });
      AppMethodBeat.o(213043);
      return;
    }
    Log.i("MicroMsg.Aa.LaunchAAUI", "click launchDialog cancel，mode：%s，submode：%s", new Object[] { Integer.valueOf(LaunchAAUI.b(this.jXQ)), Integer.valueOf(LaunchAAUI.c(this.jXQ)) });
    this.jXQ.uZ(13);
    AppMethodBeat.o(213043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAUI.22
 * JD-Core Version:    0.7.0.1
 */