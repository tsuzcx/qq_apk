package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ControlBoardPanel$2
  implements View.OnClickListener
{
  ControlBoardPanel$2(ControlBoardPanel paramControlBoardPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11159);
    if (this.jxQ.jxI.getVisibility() == 0)
    {
      this.jxQ.jxH.setVisibility(8);
      this.jxQ.jxI.setVisibility(8);
      this.jxQ.jxL.setSelected(false);
      ControlBoardPanel.a(this.jxQ);
      AppMethodBeat.o(11159);
      return;
    }
    this.jxQ.jxH.setVisibility(0);
    this.jxQ.hqR.setVisibility(8);
    this.jxQ.jxI.setVisibility(0);
    this.jxQ.jxJ.setVisibility(8);
    this.jxQ.jxK.setSelected(false);
    this.jxQ.jxL.setSelected(true);
    this.jxQ.jxM.setSelected(false);
    ControlBoardPanel.b(this.jxQ);
    AppMethodBeat.o(11159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.2
 * JD-Core Version:    0.7.0.1
 */