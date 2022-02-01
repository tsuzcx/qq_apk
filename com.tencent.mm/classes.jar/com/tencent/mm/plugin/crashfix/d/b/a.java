package com.tencent.mm.plugin.crashfix.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public final class a
  implements b
{
  boolean isFront;
  private final int qCE;
  private final int qCF;
  private final String[] qCG;
  
  public a()
  {
    AppMethodBeat.i(225328);
    this.qCE = 0;
    this.qCF = 1;
    this.isFront = false;
    this.qCG = new String[] { "com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI", "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode", "com.tencent.mm.app.WorkerProfile$", "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI" };
    AppMethodBeat.o(225328);
  }
  
  public final boolean Fh(int paramInt)
  {
    return true;
  }
  
  public final boolean cAO()
  {
    AppMethodBeat.i(225329);
    AppForegroundDelegate.djR.a(new o()
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
    EventCenter.instance.add(new IListener() {});
    AppMethodBeat.o(225329);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.b.a
 * JD-Core Version:    0.7.0.1
 */