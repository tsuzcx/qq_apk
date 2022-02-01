package com.tencent.mm.plugin.crashfix.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.n;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.sdk.b.c;

public final class a
  implements b
{
  boolean isFront;
  private final int pgA;
  private final int pgB;
  private final String[] pgC;
  
  public a()
  {
    AppMethodBeat.i(187011);
    this.pgA = 0;
    this.pgB = 1;
    this.isFront = false;
    this.pgC = new String[] { "com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI", "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode", "com.tencent.mm.app.WorkerProfile$", "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI" };
    AppMethodBeat.o(187011);
  }
  
  public final boolean Bn(int paramInt)
  {
    return true;
  }
  
  public final boolean cbE()
  {
    AppMethodBeat.i(187012);
    AppForegroundDelegate.cSQ.a(new n()
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
    com.tencent.mm.sdk.b.a.IbL.b(new c() {});
    AppMethodBeat.o(187012);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.b.a
 * JD-Core Version:    0.7.0.1
 */