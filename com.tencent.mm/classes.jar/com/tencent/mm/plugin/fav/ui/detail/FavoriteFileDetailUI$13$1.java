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

final class FavoriteFileDetailUI$13$1
  implements n.c
{
  FavoriteFileDetailUI$13$1(FavoriteFileDetailUI.13 param13) {}
  
  public final void a(l paraml)
  {
    if (this.kfA.kfy)
    {
      FavoriteFileDetailUI.j(this.kfA.kfu);
      if ((!k.h(FavoriteFileDetailUI.a(this.kfA.kfu))) && (FavoriteFileDetailUI.a(this.kfA.kfu).sVO == 0))
      {
        if (this.kfA.bns != 8) {
          break label139;
        }
        paraml.e(0, this.kfA.kfu.getString(n.i.favorite_share_with_friend));
      }
    }
    for (;;)
    {
      if (this.kfA.kfz)
      {
        paraml.e(3, this.kfA.kfu.getString(n.i.favorite_edit_tag_tips));
        paraml.e(2, this.kfA.kfu.mController.uMN.getString(n.i.app_delete));
      }
      return;
      label139:
      if (this.kfA.bns == 15)
      {
        paraml.e(0, this.kfA.kfu.getString(n.i.favorite_share_with_friend));
        paraml.e(4, this.kfA.kfu.getString(n.i.save_video_to_local));
      }
      else if (this.kfA.bns == 4)
      {
        paraml.e(0, this.kfA.kfu.getString(n.i.favorite_share_with_friend));
        paraml.e(4, this.kfA.kfu.getString(n.i.save_video_to_local));
      }
      else
      {
        paraml.e(0, this.kfA.kfu.getString(n.i.favorite_share_with_friend));
        if ((this.kfA.kfz) && (FavoriteFileDetailUI.b(this.kfA.kfu).aPY())) {
          paraml.e(1, this.kfA.kfu.getString(n.i.favorite_post_to_sns));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.13.1
 * JD-Core Version:    0.7.0.1
 */