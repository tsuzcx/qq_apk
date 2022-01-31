package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ControlBoardPanel$3
  implements View.OnClickListener
{
  ControlBoardPanel$3(ControlBoardPanel paramControlBoardPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11160);
    if (this.jxQ.jxJ.getVisibility() == 0)
    {
      this.jxQ.jxH.setVisibility(8);
      this.jxQ.jxJ.setVisibility(8);
      this.jxQ.jxM.setSelected(false);
      ControlBoardPanel.a(this.jxQ);
      AppMethodBeat.o(11160);
      return;
    }
    this.jxQ.jxH.setVisibility(0);
    this.jxQ.hqR.setVisibility(8);
    this.jxQ.jxI.setVisibility(8);
    this.jxQ.jxJ.setVisibility(0);
    this.jxQ.jxK.setSelected(false);
    this.jxQ.jxL.setSelected(false);
    this.jxQ.jxM.setSelected(true);
    ControlBoardPanel.b(this.jxQ);
    AppMethodBeat.o(11160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.3
 * JD-Core Version:    0.7.0.1
 */