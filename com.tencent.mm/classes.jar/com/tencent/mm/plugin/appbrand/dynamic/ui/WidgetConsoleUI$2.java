package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WidgetConsoleUI$2
  implements Runnable
{
  WidgetConsoleUI$2(WidgetConsoleUI paramWidgetConsoleUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(11003);
    this.hqS.setMMTitle(String.format("%s%s", new Object[] { this.hqS.getString(2131306259), this.hqT }));
    Toast.makeText(this.hqS.getContext(), String.format("%s%s", new Object[] { this.hqS.id, this.hqT }), 1).show();
    AppMethodBeat.o(11003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.ui.WidgetConsoleUI.2
 * JD-Core Version:    0.7.0.1
 */