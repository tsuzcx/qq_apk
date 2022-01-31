package com.tencent.mm.plugin.location.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LocationExtUI$4
  implements MenuItem.OnMenuItemClickListener
{
  LocationExtUI$4(LocationExtUI paramLocationExtUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(113434);
    this.occ.finish();
    AppMethodBeat.o(113434);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.LocationExtUI.4
 * JD-Core Version:    0.7.0.1
 */