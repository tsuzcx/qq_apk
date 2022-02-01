package com.tencent.mm.plugin.crashfix.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.plugin.crashfix.d.b;
import com.tencent.mm.sdk.b.c;

public final class a
  implements b
{
  boolean isFront;
  private final int png;
  private final int pnh;
  private final String[] pni;
  
  public a()
  {
    AppMethodBeat.i(190284);
    this.png = 0;
    this.pnh = 1;
    this.isFront = false;
    this.pni = new String[] { "com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI", "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode", "com.tencent.mm.app.WorkerProfile$", "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI" };
    AppMethodBeat.o(190284);
  }
  
  public final boolean Bz(int paramInt)
  {
    return true;
  }
  
  public final boolean ccT()
  {
    AppMethodBeat.i(190285);
    AppForegroundDelegate.cTA.a(new o()
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
    com.tencent.mm.sdk.b.a.IvT.b(new c() {});
    AppMethodBeat.o(190285);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.crashfix.d.b.a
 * JD-Core Version:    0.7.0.1
 */