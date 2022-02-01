package com.tencent.mm.plugin.crashfix.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.f.a.ly;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public final class a
  implements b
{
  boolean isFront;
  private final int ubE;
  private final int ubF;
  private final String[] ubG;
  
  public a()
  {
    AppMethodBeat.i(256637);
    this.ubE = 0;
    this.ubF = 1;
    this.isFront = false;
    this.ubG = new String[] { "com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI", "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode", "com.tencent.mm.app.WorkerProfile$", "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI" };
    AppMethodBeat.o(256637);
  }
  
  public final boolean IP(int paramInt)
  {
    return true;
  }
  
  public final boolean cPs()
  {
    AppMethodBeat.i(256639);
    AppForegroundDelegate.fby.a(new o()
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
    AppMethodBeat.o(256639);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.b.a
 * JD-Core Version:    0.7.0.1
 */