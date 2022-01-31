package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.s;

final class FavoriteSightDetailUI$4$1
  implements n.c
{
  FavoriteSightDetailUI$4$1(FavoriteSightDetailUI.4 param4) {}
  
  public final void a(l paraml)
  {
    if ((FavoriteSightDetailUI.a(this.kgi.kgg).aPX()) && (!FavoriteSightDetailUI.j(this.kgi.kgg).t(FavoriteSightDetailUI.a(this.kgi.kgg)))) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (FavoriteSightDetailUI.b(this.kgi.kgg).sVO == 0)) {
        paraml.e(0, this.kgi.kgg.getString(n.i.favorite_share_with_friend));
      }
      paraml.e(4, this.kgi.kgg.getString(n.i.favorite_save_as_note));
      paraml.e(3, this.kgi.kgg.getString(n.i.favorite_edit_tag_tips));
      paraml.e(2, this.kgi.kgg.mController.uMN.getString(n.i.app_delete));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.4.1
 * JD-Core Version:    0.7.0.1
 */