package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.support.v7.widget.LinearLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import java.util.List;

final class ConsolePanel$9
  implements Runnable
{
  ConsolePanel$9(ConsolePanel paramConsolePanel, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(11145);
    int i = this.jxD.jxA.getItemCount();
    this.jxD.jxA.jxq.addAll(this.jxE);
    this.jxD.jxA.ap(i, this.jxE.size());
    if (((LinearLayoutManager)this.jxD.iOL.getLayoutManager()).iv() == i - 1) {
      this.jxD.iOL.smoothScrollToPosition(this.jxD.jxA.getItemCount() - 1);
    }
    AppMethodBeat.o(11145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.9
 * JD-Core Version:    0.7.0.1
 */