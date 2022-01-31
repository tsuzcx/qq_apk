package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

final class ConsolePanel$8
  implements View.OnClickListener
{
  ConsolePanel$8(ConsolePanel paramConsolePanel) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    if (i < this.hEq.hEk.length)
    {
      Button localButton = this.hEq.hEk[i];
      if (localButton == paramView) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setSelected(bool);
        if ((bool) && (this.hEq.hEo != i))
        {
          this.hEq.hEo = i;
          ConsolePanel.a(this.hEq);
        }
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.8
 * JD-Core Version:    0.7.0.1
 */