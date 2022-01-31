package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.i.2;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

final class FavoriteFileDetailUI$13$2
  implements n.d
{
  FavoriteFileDetailUI$13$2(FavoriteFileDetailUI.13 param13) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      if (FavoriteFileDetailUI.c(this.kfA.kfu) == 8)
      {
        paramMenuItem = com.tencent.mm.plugin.fav.a.b.b(FavoriteFileDetailUI.a(this.kfA.kfu));
        if (!e.bK(paramMenuItem))
        {
          y.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file not exists");
          Toast.makeText(this.kfA.kfu, this.kfA.kfu.getString(n.i.favorite_share_file_not_exists), 1).show();
          return;
        }
        if (new com.tencent.mm.vfs.b(paramMenuItem).length() > 10485760L)
        {
          y.e("MicroMsg.FavoriteFileDetailUI", "share file failed, file too large");
          Toast.makeText(this.kfA.kfu, this.kfA.kfu.getString(n.i.favorite_share_too_large), 1).show();
          return;
        }
      }
      paramMenuItem = this.kfA.kfu.keY;
      paramMenuItem.jYM += 1;
      FavoriteFileDetailUI.a(this.kfA.kfu, FavoriteFileDetailUI.b(this.kfA.kfu));
      return;
    case 1: 
      paramMenuItem = this.kfA.kfu.keY;
      paramMenuItem.jYN += 1;
      Object localObject = h.b(this.kfA.kfu.mController.uMN, this.kfA.kfu.getString(n.i.favorite_forward_tips), false, null);
      paramMenuItem = this.kfA.kfu.mController.uMN;
      com.tencent.mm.plugin.fav.a.g localg = FavoriteFileDetailUI.b(this.kfA.kfu);
      localObject = new FavoriteFileDetailUI.13.2.1(this, (Dialog)localObject);
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(Integer.valueOf(localg.field_id));
      paramMenuItem = new am("", localLinkedList, new i.2(localg, paramMenuItem, (Runnable)localObject));
      com.tencent.mm.kernel.g.Dk().a(paramMenuItem, 0);
      return;
    case 2: 
      h.a(this.kfA.kfu.mController.uMN, this.kfA.kfu.getString(n.i.app_delete_tips), "", new FavoriteFileDetailUI.13.2.2(this), null);
      return;
    case 3: 
      paramMenuItem = this.kfA.kfu.keY;
      paramMenuItem.jYP += 1;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteFileDetailUI.b(this.kfA.kfu).field_localId);
      com.tencent.mm.plugin.fav.a.b.a(this.kfA.kfu.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
      return;
    }
    FavoriteFileDetailUI.k(this.kfA.kfu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13.2
 * JD-Core Version:    0.7.0.1
 */