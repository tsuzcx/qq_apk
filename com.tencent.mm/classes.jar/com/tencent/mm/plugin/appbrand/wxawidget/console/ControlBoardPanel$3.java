package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;

final class ControlBoardPanel$3
  implements View.OnClickListener
{
  ControlBoardPanel$3(ControlBoardPanel paramControlBoardPanel) {}
  
  public final void onClick(View paramView)
  {
    if (this.hED.hEw.getVisibility() == 0)
    {
      this.hED.hEu.setVisibility(8);
      this.hED.hEw.setVisibility(8);
      this.hED.hEz.setSelected(false);
      ControlBoardPanel.a(this.hED);
      return;
    }
    this.hED.hEu.setVisibility(0);
    this.hED.fXr.setVisibility(8);
    this.hED.hEv.setVisibility(8);
    this.hED.hEw.setVisibility(0);
    this.hED.hEx.setSelected(false);
    this.hED.hEy.setSelected(false);
    this.hED.hEz.setSelected(true);
    ControlBoardPanel.b(this.hED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.3
 * JD-Core Version:    0.7.0.1
 */