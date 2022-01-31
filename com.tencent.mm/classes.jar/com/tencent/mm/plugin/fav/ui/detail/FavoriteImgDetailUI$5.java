package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class FavoriteImgDetailUI$5
  implements View.OnClickListener
{
  FavoriteImgDetailUI$5(FavoriteImgDetailUI paramFavoriteImgDetailUI) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_info_id", FavoriteImgDetailUI.b(this.kfM).field_localId);
    localIntent.putExtra("key_detail_data_id", ((xv)paramView.getTag()).kgC);
    b.a(this.kfM.mController.uMN, ".ui.FavImgGalleryUI", localIntent);
    paramView = this.kfM.keY;
    paramView.jYL += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.5
 * JD-Core Version:    0.7.0.1
 */