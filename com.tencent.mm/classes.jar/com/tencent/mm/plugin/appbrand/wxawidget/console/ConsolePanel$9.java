package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.support.v7.widget.LinearLayoutManager;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import java.util.List;

final class ConsolePanel$9
  implements Runnable
{
  ConsolePanel$9(ConsolePanel paramConsolePanel, List paramList) {}
  
  public final void run()
  {
    int i = this.hEq.hEn.getItemCount();
    this.hEq.hEn.hEd.addAll(this.hEr);
    this.hEq.hEn.aj(i, this.hEr.size());
    if (((LinearLayoutManager)this.hEq.hdY.getLayoutManager()).ha() == i - 1) {
      this.hEq.hdY.smoothScrollToPosition(this.hEq.hEn.getItemCount() - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.wxawidget.console.ConsolePanel.9
 * JD-Core Version:    0.7.0.1
 */