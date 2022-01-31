package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class FavoriteImgDetailUI$3$2
  implements n.d
{
  FavoriteImgDetailUI$3$2(FavoriteImgDetailUI.3 param3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteImgDetailUI.b(this.kfO.kfM).field_localId);
      b.a(this.kfO.kfM.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
      paramMenuItem = this.kfO.kfM.keY;
      paramMenuItem.jYP += 1;
      return;
    case 1: 
      com.tencent.mm.ui.base.h.a(this.kfO.kfM.mController.uMN, this.kfO.kfM.getString(n.i.app_delete_tips), "", new FavoriteImgDetailUI.3.2.1(this), null);
      return;
    case 2: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("scene_from", 1);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("select_fav_local_id", FavoriteImgDetailUI.b(this.kfO.kfM).field_localId);
      d.c(this.kfO.kfM, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
      com.tencent.mm.plugin.fav.a.h.f(FavoriteImgDetailUI.b(this.kfO.kfM).field_localId, 1, 0);
      paramMenuItem = this.kfO.kfM.keY;
      paramMenuItem.jYM += 1;
      return;
    }
    com.tencent.mm.plugin.fav.ui.g.a(this.kfO.kfM, this.kfO.kfN, this.kfO.kfM.keY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.3.2
 * JD-Core Version:    0.7.0.1
 */