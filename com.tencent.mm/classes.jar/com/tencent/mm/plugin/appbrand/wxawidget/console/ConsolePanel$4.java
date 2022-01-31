package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

final class ConsolePanel$4
  implements View.OnKeyListener
{
  ConsolePanel$4(ConsolePanel paramConsolePanel) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 66)
    {
      this.hEq.hEp = this.hEq.hEj.getText().toString();
      ConsolePanel.a(this.hEq);
      f.cy(paramView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.4
 * JD-Core Version:    0.7.0.1
 */