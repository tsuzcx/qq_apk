package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class SettingsPanel$3$1
  implements b.a
{
  SettingsPanel$3$1(SettingsPanel.3 param3, b paramb) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(141928);
    this.jxY.hide();
    if (paramBoolean) {
      SettingsPanel.b(this.jxZ.jxW).setText((CharSequence)paramObject1);
    }
    SettingsPanel.a(this.jxZ.jxW, this.jxY.dPp());
    AppMethodBeat.o(141928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.3.1
 * JD-Core Version:    0.7.0.1
 */