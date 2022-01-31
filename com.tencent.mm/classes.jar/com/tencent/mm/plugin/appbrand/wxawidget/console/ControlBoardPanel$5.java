package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

final class ControlBoardPanel$5
  implements View.OnClickListener
{
  ControlBoardPanel$5(ControlBoardPanel paramControlBoardPanel) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.hED;
    if (paramView.hEC)
    {
      paramView.hEC = false;
      paramView.hEA.removeViewImmediate(paramView);
      d.b(paramView.fXr);
      if (paramView.hEt != null) {
        paramView.hEt.a(paramView, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.5
 * JD-Core Version:    0.7.0.1
 */