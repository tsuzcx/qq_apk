package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.sdk.platformtools.al;

final class SettingsPanel$1
  implements View.OnClickListener
{
  SettingsPanel$1(SettingsPanel paramSettingsPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11188);
    ((e)g.E(e.class)).ack().restart();
    al.p(new SettingsPanel.1.1(this), 2000L);
    AppMethodBeat.o(11188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.SettingsPanel.1
 * JD-Core Version:    0.7.0.1
 */