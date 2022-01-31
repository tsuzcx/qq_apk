package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.j;

final class BindMContactIntroUI$23
  implements MenuItem.OnMenuItemClickListener
{
  BindMContactIntroUI$23(BindMContactIntroUI paramBindMContactIntroUI, int paramInt) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new j(this.fbF.mController.uMN);
    paramMenuItem.phH = new BindMContactIntroUI.23.1(this);
    paramMenuItem.phI = new BindMContactIntroUI.23.2(this);
    paramMenuItem.bJQ();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.23
 * JD-Core Version:    0.7.0.1
 */