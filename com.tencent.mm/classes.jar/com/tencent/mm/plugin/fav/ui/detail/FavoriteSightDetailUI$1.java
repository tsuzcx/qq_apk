package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class FavoriteSightDetailUI$1
  implements View.OnClickListener
{
  FavoriteSightDetailUI$1(FavoriteSightDetailUI paramFavoriteSightDetailUI) {}
  
  public final void onClick(View paramView)
  {
    if ((a.bk(paramView.getContext())) || (a.bi(paramView.getContext()))) {
      return;
    }
    y.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteSightDetailUI.a(this.kgg).field_id), Long.valueOf(FavoriteSightDetailUI.a(this.kgg).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(this.kgg).field_itemStatus) });
    if (FavoriteSightDetailUI.a(this.kgg).isDone())
    {
      if (b.f(FavoriteSightDetailUI.b(this.kgg)))
      {
        m.a(m.a.jZh, FavoriteSightDetailUI.a(this.kgg));
        FavoriteSightDetailUI.a(this.kgg, true, paramView.getContext());
        return;
      }
      if (bk.bl(FavoriteSightDetailUI.b(this.kgg).sUG))
      {
        FavoriteSightDetailUI.a(this.kgg, false, paramView.getContext());
        return;
      }
      y.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      label168:
      if (!FavoriteSightDetailUI.a(this.kgg).aQa()) {
        break label292;
      }
      b.l(FavoriteSightDetailUI.a(this.kgg));
    }
    for (;;)
    {
      FavoriteSightDetailUI.a(this.kgg, false);
      return;
      if (FavoriteSightDetailUI.a(this.kgg).aQb())
      {
        if (!bk.bl(FavoriteSightDetailUI.b(this.kgg).sUG)) {
          break label168;
        }
        FavoriteSightDetailUI.a(this.kgg, false, paramView.getContext());
        return;
      }
      if ((!FavoriteSightDetailUI.a(this.kgg).isDownloading()) && (!FavoriteSightDetailUI.a(this.kgg).aPZ())) {
        break label168;
      }
      if (FavoriteSightDetailUI.c(this.kgg).getVisibility() != 8) {
        break;
      }
      FavoriteSightDetailUI.a(this.kgg, false);
      return;
      label292:
      b.m(FavoriteSightDetailUI.a(this.kgg));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.1
 * JD-Core Version:    0.7.0.1
 */