package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class FavoriteFileDetailUI$13$2$2
  implements DialogInterface.OnClickListener
{
  FavoriteFileDetailUI$13$2$2(FavoriteFileDetailUI.13.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = h.b(this.kfB.kfA.kfu.mController.uMN, this.kfB.kfA.kfu.getString(n.i.app_delete_tips), false, null);
    b.a(FavoriteFileDetailUI.b(this.kfB.kfA.kfu).field_localId, new FavoriteFileDetailUI.13.2.2.1(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13.2.2
 * JD-Core Version:    0.7.0.1
 */