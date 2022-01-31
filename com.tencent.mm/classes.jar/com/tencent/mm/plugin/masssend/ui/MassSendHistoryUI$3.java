package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.m;

final class MassSendHistoryUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MassSendHistoryUI$3(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Contact_User", "masssendapp");
    a.eUR.d(paramMenuItem, this.mbC);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.3
 * JD-Core Version:    0.7.0.1
 */