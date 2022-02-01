package com.tencent.mm.plugin.fts.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.lg;

final class FTSAddWw$3
  implements MenuItem.OnMenuItemClickListener
{
  FTSAddWw$3(FTSAddWw paramFTSAddWw) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(111848);
    paramMenuItem = new lg();
    paramMenuItem.ud(FTSAddWw.a(this.HxA));
    paramMenuItem.isX = 2L;
    paramMenuItem.bMH();
    this.HxA.finish();
    AppMethodBeat.o(111848);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.3
 * JD-Core Version:    0.7.0.1
 */