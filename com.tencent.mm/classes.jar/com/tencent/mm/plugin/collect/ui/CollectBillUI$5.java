package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CollectBillUI$5
  implements MenuItem.OnMenuItemClickListener
{
  CollectBillUI$5(CollectBillUI paramCollectBillUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent(this.iKD.mController.uMN, CollectBillListUI.class);
    this.iKD.startActivity(paramMenuItem);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.5
 * JD-Core Version:    0.7.0.1
 */