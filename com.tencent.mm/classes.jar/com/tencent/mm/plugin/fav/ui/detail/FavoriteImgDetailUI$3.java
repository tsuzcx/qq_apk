package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;

final class FavoriteImgDetailUI$3
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteImgDetailUI$3(FavoriteImgDetailUI paramFavoriteImgDetailUI, long paramLong) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.kfM.mController.uMN, 1, false);
    paramMenuItem.phH = new n.c()
    {
      public final void a(l paramAnonymousl)
      {
        if (FavoriteImgDetailUI.a(FavoriteImgDetailUI.3.this.kfM)) {
          paramAnonymousl.e(2, FavoriteImgDetailUI.3.this.kfM.getString(n.i.favorite_share_with_friend));
        }
        paramAnonymousl.e(3, FavoriteImgDetailUI.3.this.kfM.getString(n.i.favorite_save_as_note));
        paramAnonymousl.e(0, FavoriteImgDetailUI.3.this.kfM.getString(n.i.favorite_edit_tag_tips));
        paramAnonymousl.e(1, FavoriteImgDetailUI.3.this.kfM.mController.uMN.getString(n.i.app_delete));
      }
    };
    paramMenuItem.phI = new FavoriteImgDetailUI.3.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.3
 * JD-Core Version:    0.7.0.1
 */