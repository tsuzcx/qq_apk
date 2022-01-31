package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceLikeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ExdeviceLikeUI$1(ExdeviceLikeUI paramExdeviceLikeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(19968);
    paramMenuItem = new Intent(this.lMP, ExdeviceRankInfoUI.class);
    paramMenuItem.putExtra("app_username", ExdeviceLikeUI.a(this.lMP));
    paramMenuItem.putExtra("rank_id", "#");
    paramMenuItem.putExtra("key_is_latest", true);
    paramMenuItem.putExtra("device_type", 1);
    this.lMP.startActivity(paramMenuItem);
    this.lMP.finish();
    AppMethodBeat.o(19968);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeUI.1
 * JD-Core Version:    0.7.0.1
 */