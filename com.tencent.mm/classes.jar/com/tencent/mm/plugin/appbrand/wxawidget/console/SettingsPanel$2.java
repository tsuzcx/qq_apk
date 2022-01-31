package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class SettingsPanel$2
  implements MMSwitchBtn.a
{
  SettingsPanel$2(SettingsPanel paramSettingsPanel) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(11189);
    ((e)g.E(e.class)).acl().cL(paramBoolean);
    AppMethodBeat.o(11189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.2
 * JD-Core Version:    0.7.0.1
 */