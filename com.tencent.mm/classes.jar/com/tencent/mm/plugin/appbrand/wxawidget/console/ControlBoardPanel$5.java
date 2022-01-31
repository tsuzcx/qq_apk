package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ControlBoardPanel$5
  implements View.OnClickListener
{
  ControlBoardPanel$5(ControlBoardPanel paramControlBoardPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11162);
    paramView = this.jxQ;
    if (paramView.jxP)
    {
      paramView.jxP = false;
      paramView.jxN.removeViewImmediate(paramView);
      d.b(paramView.hqR);
      if (paramView.jxG != null) {
        paramView.jxG.a(paramView, false);
      }
    }
    AppMethodBeat.o(11162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.5
 * JD-Core Version:    0.7.0.1
 */