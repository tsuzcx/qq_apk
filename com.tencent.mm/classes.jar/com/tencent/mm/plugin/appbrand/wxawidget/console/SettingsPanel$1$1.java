package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;

final class SettingsPanel$1$1
  implements Runnable
{
  SettingsPanel$1$1(SettingsPanel.1 param1) {}
  
  public final void run()
  {
    Toast.makeText(this.hEK.hEJ.getContext(), b.e.wxa_widget_restart_support_process_succ, 1).show();
    if (SettingsPanel.a(this.hEK.hEJ) != null) {
      SettingsPanel.a(this.hEK.hEJ).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.1.1
 * JD-Core Version:    0.7.0.1
 */