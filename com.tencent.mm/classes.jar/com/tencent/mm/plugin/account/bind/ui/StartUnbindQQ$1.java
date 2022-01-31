package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class StartUnbindQQ$1
  implements MenuItem.OnMenuItemClickListener
{
  StartUnbindQQ$1(StartUnbindQQ paramStartUnbindQQ) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(13761);
    this.gws.finish();
    AppMethodBeat.o(13761);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.1
 * JD-Core Version:    0.7.0.1
 */