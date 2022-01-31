package com.tencent.mm.plugin.fts.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.w;

final class FTSAddWw$3
  implements MenuItem.OnMenuItemClickListener
{
  FTSAddWw$3(FTSAddWw paramFTSAddWw) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(61755);
    paramMenuItem = new w();
    paramMenuItem.fr(FTSAddWw.a(this.mWE));
    paramMenuItem.cTG = 2L;
    paramMenuItem.ake();
    this.mWE.finish();
    AppMethodBeat.o(61755);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.3
 * JD-Core Version:    0.7.0.1
 */