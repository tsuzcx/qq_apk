package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPanel$1$1
  implements Runnable
{
  SettingsPanel$1$1(SettingsPanel.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(11187);
    Toast.makeText(this.jxX.jxW.getContext(), 2131306067, 1).show();
    if (SettingsPanel.a(this.jxX.jxW) != null) {
      SettingsPanel.a(this.jxX.jxW).run();
    }
    AppMethodBeat.o(11187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.1.1
 * JD-Core Version:    0.7.0.1
 */