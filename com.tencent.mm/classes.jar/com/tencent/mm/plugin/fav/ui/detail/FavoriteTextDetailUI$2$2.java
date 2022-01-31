package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class FavoriteTextDetailUI$2$2
  implements n.d
{
  FavoriteTextDetailUI$2$2(FavoriteTextDetailUI.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
        } while ((FavoriteTextDetailUI.a(this.kgr.kgq) == null) || (FavoriteTextDetailUI.a(this.kgr.kgq).field_favProto == null));
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("key_value", FavoriteTextDetailUI.a(this.kgr.kgq).field_favProto.desc);
        paramMenuItem.putExtra("key_max_count", FavoriteTextDetailUI.access$100());
        paramMenuItem.putExtra("key_show_confirm", true);
        paramMenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(this.kgr.kgq).field_id);
        b.b(this.kgr.kgq, ".ui.FavTextEditUI", paramMenuItem, 1);
        paramMenuItem = this.kgr.kgq.keY;
        paramMenuItem.jYO += 1;
        return;
        com.tencent.mm.plugin.fav.ui.g.a(this.kgr.kgq, FavoriteTextDetailUI.b(this.kgr.kgq), this.kgr.kgq.keY);
        return;
      } while ((FavoriteTextDetailUI.a(this.kgr.kgq) == null) || (FavoriteTextDetailUI.a(this.kgr.kgq).field_favProto == null));
      paramMenuItem = this.kgr.kgq.keY;
      paramMenuItem.jYM += 1;
      b.e(FavoriteTextDetailUI.a(this.kgr.kgq).field_favProto.desc, this.kgr.kgq);
      com.tencent.mm.plugin.fav.a.h.f(FavoriteTextDetailUI.a(this.kgr.kgq).field_localId, 1, 0);
      return;
    case 3: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteTextDetailUI.a(this.kgr.kgq).field_localId);
      b.a(this.kgr.kgq.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
      paramMenuItem = this.kgr.kgq.keY;
      paramMenuItem.jYP += 1;
      return;
    }
    com.tencent.mm.ui.base.h.a(this.kgr.kgq.mController.uMN, this.kgr.kgq.getString(n.i.app_delete_tips), "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface = com.tencent.mm.ui.base.h.b(FavoriteTextDetailUI.2.2.this.kgr.kgq.mController.uMN, FavoriteTextDetailUI.2.2.this.kgr.kgq.getString(n.i.app_delete_tips), false, null);
        b.a(FavoriteTextDetailUI.b(FavoriteTextDetailUI.2.2.this.kgr.kgq), new FavoriteTextDetailUI.2.2.1.1(this, paramAnonymousDialogInterface));
      }
    }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI.2.2
 * JD-Core Version:    0.7.0.1
 */