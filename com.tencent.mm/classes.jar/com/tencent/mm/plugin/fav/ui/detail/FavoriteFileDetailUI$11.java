package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class FavoriteFileDetailUI$11
  implements View.OnClickListener
{
  FavoriteFileDetailUI$11(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteFileDetailUI.b(this.kfu).field_id), Long.valueOf(FavoriteFileDetailUI.b(this.kfu).field_localId), Integer.valueOf(FavoriteFileDetailUI.b(this.kfu).field_itemStatus) });
    if (!f.zF())
    {
      h.h(this.kfu.mController.uMN, n.i.favorite_no_sdcard, n.i.favorite);
      return;
    }
    if ((FavoriteFileDetailUI.b(this.kfu).aQa()) || (bk.bl(FavoriteFileDetailUI.a(this.kfu).sUG))) {
      b.l(FavoriteFileDetailUI.b(this.kfu));
    }
    for (;;)
    {
      FavoriteFileDetailUI.g(this.kfu);
      return;
      if (!FavoriteFileDetailUI.f(this.kfu))
      {
        b.a(FavoriteFileDetailUI.b(this.kfu), FavoriteFileDetailUI.a(this.kfu), true);
      }
      else
      {
        FavoriteFileDetailUI.b(this.kfu).field_itemStatus = 7;
        b.b(FavoriteFileDetailUI.a(this.kfu), 18, -1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.11
 * JD-Core Version:    0.7.0.1
 */