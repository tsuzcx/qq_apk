package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConsolePanel$4
  implements View.OnKeyListener
{
  ConsolePanel$4(ConsolePanel paramConsolePanel) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(11140);
    if (paramInt == 66)
    {
      this.jxD.jxC = this.jxD.jxw.getText().toString();
      ConsolePanel.a(this.jxD);
      f.da(paramView);
      AppMethodBeat.o(11140);
      return true;
    }
    AppMethodBeat.o(11140);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.4
 * JD-Core Version:    0.7.0.1
 */