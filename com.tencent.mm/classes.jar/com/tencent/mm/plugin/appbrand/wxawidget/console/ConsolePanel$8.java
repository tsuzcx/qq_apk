package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConsolePanel$8
  implements View.OnClickListener
{
  ConsolePanel$8(ConsolePanel paramConsolePanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11144);
    int i = 0;
    if (i < this.jxD.jxx.length)
    {
      Button localButton = this.jxD.jxx[i];
      if (localButton == paramView) {}
      for (boolean bool = true;; bool = false)
      {
        localButton.setSelected(bool);
        if ((bool) && (this.jxD.jxB != i))
        {
          this.jxD.jxB = i;
          ConsolePanel.a(this.jxD);
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(11144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.8
 * JD-Core Version:    0.7.0.1
 */