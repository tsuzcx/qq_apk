package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.i;

final class FavoriteFileDetailUI$12
  implements View.OnClickListener
{
  FavoriteFileDetailUI$12(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    if (FavoriteFileDetailUI.b(this.kfu).isDownloading())
    {
      b.d(FavoriteFileDetailUI.a(this.kfu));
      FavoriteFileDetailUI.h(this.kfu).setText(n.i.favorite_item_restart_download);
    }
    for (;;)
    {
      FavoriteFileDetailUI.i(this.kfu);
      return;
      b.n(FavoriteFileDetailUI.b(this.kfu));
      FavoriteFileDetailUI.h(this.kfu).setText(n.i.favorite_item_restart_upload);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.12
 * JD-Core Version:    0.7.0.1
 */