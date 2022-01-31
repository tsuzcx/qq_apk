package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.m;

final class MassSendHistoryUI$2
  implements MenuItem.OnMenuItemClickListener
{
  MassSendHistoryUI$2(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (MassSendHistoryUI.g(this.mbC)) {
      this.mbC.finish();
    }
    for (;;)
    {
      return true;
      paramMenuItem = new Intent();
      paramMenuItem.addFlags(67108864);
      a.eUR.q(paramMenuItem, this.mbC);
      this.mbC.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.2
 * JD-Core Version:    0.7.0.1
 */