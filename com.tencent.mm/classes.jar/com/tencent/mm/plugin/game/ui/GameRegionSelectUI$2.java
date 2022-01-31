package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.ui.base.h;

final class GameRegionSelectUI$2
  implements MenuItem.OnMenuItemClickListener
{
  GameRegionSelectUI$2(GameRegionSelectUI paramGameRegionSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (f.dx(this.leE))
    {
      h.a(this.leE, true, this.leE.getString(g.i.game_region_dlg_info), "", this.leE.getString(g.i.game_region_dlg_switch), this.leE.getString(g.i.game_region_dlg_cancel), new DialogInterface.OnClickListener()new GameRegionSelectUI.2.2
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          f.dy(GameRegionSelectUI.2.this.leE);
          GameRegionSelectUI.a(GameRegionSelectUI.2.this.leE);
          paramAnonymousDialogInterface = new Intent();
          GameRegionPreference.a locala = f.jdMethod_do(GameRegionSelectUI.2.this.leE);
          if (locala != null)
          {
            paramAnonymousDialogInterface.putExtra("gameRegionName", f.a(locala));
            GameRegionSelectUI.2.this.leE.setResult(-1, paramAnonymousDialogInterface);
          }
          for (;;)
          {
            GameRegionSelectUI.2.this.leE.finish();
            return;
            GameRegionSelectUI.2.this.leE.setResult(1);
          }
        }
      }, new GameRegionSelectUI.2.2(this));
      return true;
    }
    GameRegionSelectUI.a(this.leE);
    paramMenuItem = new Intent();
    GameRegionPreference.a locala = f.jdMethod_do(this.leE);
    if (locala != null)
    {
      paramMenuItem.putExtra("gameRegionName", f.a(locala));
      this.leE.setResult(-1, paramMenuItem);
    }
    for (;;)
    {
      this.leE.finish();
      return true;
      this.leE.setResult(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameRegionSelectUI.2
 * JD-Core Version:    0.7.0.1
 */