package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aws;
import com.tencent.mm.ui.base.n.d;

final class CollectMainUI$19$4
  implements n.d
{
  CollectMainUI$19$4(CollectMainUI.19 param19) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 1: 
      do
      {
        return;
      } while (CollectMainUI.d(this.iLY.iLP) == null);
      CollectMainUI.cF(CollectMainUI.d(this.iLY.iLP).username, CollectMainUI.d(this.iLY.iLP).ttj);
      h.nFQ.f(15387, new Object[] { Integer.valueOf(1) });
      return;
    }
    CollectMainUI.e(this.iLY.iLP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.19.4
 * JD-Core Version:    0.7.0.1
 */