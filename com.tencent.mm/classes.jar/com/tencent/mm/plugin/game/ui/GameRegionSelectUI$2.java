package com.tencent.mm.plugin.game.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.ui.base.h;

final class GameRegionSelectUI$2
  implements MenuItem.OnMenuItemClickListener
{
  GameRegionSelectUI$2(GameRegionSelectUI paramGameRegionSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112160);
    if (e.ek(this.nCz))
    {
      h.a(this.nCz, true, this.nCz.getString(2131300447), "", this.nCz.getString(2131300448), this.nCz.getString(2131300446), new GameRegionSelectUI.2.1(this), new GameRegionSelectUI.2.2(this));
      AppMethodBeat.o(112160);
      return true;
    }
    GameRegionSelectUI.a(this.nCz);
    paramMenuItem = new Intent();
    GameRegionPreference.a locala = e.eb(this.nCz);
    if (locala != null)
    {
      paramMenuItem.putExtra("gameRegionName", e.a(locala));
      this.nCz.setResult(-1, paramMenuItem);
    }
    for (;;)
    {
      this.nCz.finish();
      break;
      this.nCz.setResult(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionSelectUI.2
 * JD-Core Version:    0.7.0.1
 */