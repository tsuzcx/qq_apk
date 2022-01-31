package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class FavoriteImgDetailUI$3$2$1
  implements DialogInterface.OnClickListener
{
  FavoriteImgDetailUI$3$2$1(FavoriteImgDetailUI.3.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = h.b(this.kfP.kfO.kfM.mController.uMN, this.kfP.kfO.kfM.getString(n.i.app_delete_tips), false, null);
    b.a(FavoriteImgDetailUI.b(this.kfP.kfO.kfM).field_localId, new FavoriteImgDetailUI.3.2.1.1(this, paramDialogInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.3.2.1
 * JD-Core Version:    0.7.0.1
 */