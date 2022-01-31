package com.tencent.mm.plugin.choosemsgfile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChooseMsgFileListUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ChooseMsgFileListUI$2(ChooseMsgFileListUI paramChooseMsgFileListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(54412);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("ERRMSG", "cancel");
    this.kFZ.setResult(1, paramMenuItem);
    this.kFZ.finish();
    this.kFZ.overridePendingTransition(2131034230, 2131034228);
    AppMethodBeat.o(54412);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.2
 * JD-Core Version:    0.7.0.1
 */