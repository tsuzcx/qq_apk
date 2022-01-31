package com.tencent.mars.mm;

import com.tencent.mm.sdk.platformtools.ab;

final class MMLogic$1
  implements Runnable
{
  MMLogic$1(MMLogic.ReportInfo paramReportInfo) {}
  
  public final void run()
  {
    int i = MMLogic.access$100(this.val$item.actionId);
    if (i == 0)
    {
      ab.e("C2Java", "ActionId Can not convert");
      return;
    }
    this.val$item.actionId = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mars.mm.MMLogic.1
 * JD-Core Version:    0.7.0.1
 */