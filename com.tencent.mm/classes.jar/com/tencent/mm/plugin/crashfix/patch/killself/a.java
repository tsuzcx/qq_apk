package com.tencent.mm.plugin.crashfix.patch.killself;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.f;
import com.tencent.mm.app.q;
import com.tencent.mm.plugin.crashfix.patch.b;

public final class a
  implements b
{
  boolean isFront;
  private final int xfq;
  private final int xfr;
  private final String[] xfs;
  
  public a()
  {
    AppMethodBeat.i(261567);
    this.xfq = 0;
    this.xfr = 1;
    this.isFront = false;
    this.xfs = new String[] { "com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI", "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode", "com.tencent.mm.app.WorkerProfile$", "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI" };
    AppMethodBeat.o(261567);
  }
  
  public final boolean Js(int paramInt)
  {
    return true;
  }
  
  public final boolean dtc()
  {
    AppMethodBeat.i(261585);
    AppForegroundDelegate.heY.a(new q()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        a.this.isFront = false;
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        a.this.isFront = true;
      }
    });
    new KillSelfMonitor.2(this, f.hfK).alive();
    AppMethodBeat.o(261585);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.patch.killself.a
 * JD-Core Version:    0.7.0.1
 */