package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPanel$5
  implements View.OnClickListener
{
  SettingsPanel$5(SettingsPanel paramSettingsPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11194);
    if (SettingsPanel.d(this.jxW) != null) {
      SettingsPanel.d(this.jxW).onClick(paramView);
    }
    AppMethodBeat.o(11194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.5
 * JD-Core Version:    0.7.0.1
 */