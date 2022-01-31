package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class FavoriteVoiceDetailUI$2$2
  implements n.d
{
  FavoriteVoiceDetailUI$2$2(FavoriteVoiceDetailUI.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavoriteVoiceDetailUI.a(this.kgJ.kgI).field_localId);
      b.a(this.kgJ.kgI.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
      paramMenuItem = this.kgJ.kgI.keY;
      paramMenuItem.jYP += 1;
      return;
    case 1: 
      h.a(this.kgJ.kgI.mController.uMN, this.kgJ.kgI.getString(n.i.app_delete_tips), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = h.b(FavoriteVoiceDetailUI.2.2.this.kgJ.kgI.mController.uMN, FavoriteVoiceDetailUI.2.2.this.kgJ.kgI.getString(n.i.app_delete_tips), false, null);
          long l1 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.2.2.this.kgJ.kgI).field_localId;
          long l2 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.2.2.this.kgJ.kgI).field_id;
          b.a(FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.2.2.this.kgJ.kgI).field_localId, new FavoriteVoiceDetailUI.2.2.1.1(this, paramAnonymousDialogInterface, l1, l2));
        }
      }, null);
      return;
    }
    com.tencent.mm.plugin.fav.ui.g.a(this.kgJ.kgI, FavoriteVoiceDetailUI.b(this.kgJ.kgI), this.kgJ.kgI.keY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2.2
 * JD-Core Version:    0.7.0.1
 */