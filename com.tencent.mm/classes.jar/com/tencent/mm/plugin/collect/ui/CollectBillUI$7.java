package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import com.tencent.mm.plugin.collect.b.a;
import com.tencent.mm.ui.base.n.d;

final class CollectBillUI$7
  implements n.d
{
  CollectBillUI$7(CollectBillUI paramCollectBillUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramMenuItem.getItemId() == 0)
    {
      paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
      paramMenuItem = (a)CollectBillUI.b(this.iKD).getItemAtPosition(paramMenuItem.position);
      if (paramMenuItem != null) {
        CollectBillUI.a(this.iKD, paramMenuItem.iGJ, paramMenuItem.timestamp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.7
 * JD-Core Version:    0.7.0.1
 */