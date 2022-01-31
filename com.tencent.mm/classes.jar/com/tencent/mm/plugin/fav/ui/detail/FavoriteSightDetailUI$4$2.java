package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class FavoriteSightDetailUI$4$2
  implements n.d
{
  FavoriteSightDetailUI$4$2(FavoriteSightDetailUI.4 param4) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    case 1: 
    default: 
      return;
    case 0: 
      com.tencent.mm.plugin.fav.a.h.f(FavoriteSightDetailUI.a(this.kgi.kgg).field_localId, 1, 0);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("scene_from", 1);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("select_fav_local_id", FavoriteSightDetailUI.a(this.kgi.kgg).field_localId);
      d.c(this.kgi.kgg.mController.uMN, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
      paramMenuItem = this.kgi.kgg.keY;
      paramMenuItem.jYM += 1;
      return;
    case 2: 
      com.tencent.mm.ui.base.h.a(this.kgi.kgg.mController.uMN, this.kgi.kgg.getString(n.i.app_delete_tips), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = com.tencent.mm.ui.base.h.b(FavoriteSightDetailUI.4.2.this.kgi.kgg.mController.uMN, FavoriteSightDetailUI.4.2.this.kgi.kgg.getString(n.i.app_delete_tips), false, null);
          b.a(FavoriteSightDetailUI.a(FavoriteSightDetailUI.4.2.this.kgi.kgg).field_localId, new FavoriteSightDetailUI.4.2.1.1(this, paramAnonymousDialogInterface));
        }
      }, null);
      return;
    case 3: 
      paramMenuItem = this.kgi.kgg.keY;
      paramMenuItem.jYP += 1;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(this.kgi.kgg).field_localId);
      b.a(this.kgi.kgg.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
      return;
    }
    com.tencent.mm.plugin.fav.ui.g.a(this.kgi.kgg, FavoriteSightDetailUI.k(this.kgi.kgg), this.kgi.kgg.keY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4.2
 * JD-Core Version:    0.7.0.1
 */