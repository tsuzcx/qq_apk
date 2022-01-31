package com.tencent.mm.plugin.fav.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class FavBaseUI$5
  implements AbsListView.OnScrollListener
{
  FavBaseUI$5(FavBaseUI paramFavBaseUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (!((ae)g.t(ae.class)).getFavItemInfoStorage().q(this.kbo.aQX().aRx(), this.kbo.aQX().getType())) {
        break label53;
      }
      y.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
    }
    label53:
    while (!FavBaseUI.a(this.kbo)) {
      return;
    }
    y.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
    FavBaseUI.b(this.kbo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.5
 * JD-Core Version:    0.7.0.1
 */