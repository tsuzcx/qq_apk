package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ConsolePanel$1
  implements View.OnClickListener
{
  ConsolePanel$1(ConsolePanel paramConsolePanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(11139);
    this.jxD.jxq.clear();
    this.jxD.jxA.jxq.clear();
    this.jxD.jxA.ajb.notifyChanged();
    AppMethodBeat.o(11139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.1
 * JD-Core Version:    0.7.0.1
 */