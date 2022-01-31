package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LocationExtUI$3
  implements MenuItem.OnMenuItemClickListener
{
  LocationExtUI$3(LocationExtUI paramLocationExtUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(113433);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("key_remark_result", LocationExtUI.b(this.occ));
    paramMenuItem.putExtra("key_tags_result", LocationExtUI.a(this.occ));
    this.occ.setResult(-1, paramMenuItem);
    this.occ.finish();
    AppMethodBeat.o(113433);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI.3
 * JD-Core Version:    0.7.0.1
 */