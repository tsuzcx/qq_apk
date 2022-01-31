package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConsolePanel$6
  implements View.OnClickListener
{
  ConsolePanel$6(ConsolePanel paramConsolePanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11142);
    this.jxD.jxC = this.jxD.jxw.getText().toString();
    ConsolePanel.a(this.jxD);
    AppMethodBeat.o(11142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.6
 * JD-Core Version:    0.7.0.1
 */