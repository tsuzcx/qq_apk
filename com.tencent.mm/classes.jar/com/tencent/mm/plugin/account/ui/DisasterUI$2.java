package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class DisasterUI$2
  implements MenuItem.OnMenuItemClickListener
{
  DisasterUI$2(DisasterUI paramDisasterUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.nFQ.f(13939, new Object[] { Integer.valueOf(3) });
    y.i("MicroMsg.DisasterUI", "summerdiz back");
    this.flo.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.DisasterUI.2
 * JD-Core Version:    0.7.0.1
 */