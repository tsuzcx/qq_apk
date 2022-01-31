package com.tencent.mm.plugin.fav.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class FavBaseUI$5
  implements AbsListView.OnScrollListener
{
  FavBaseUI$5(FavBaseUI paramFavBaseUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(73930);
    if (paramInt == 0)
    {
      if (((ae)g.G(ae.class)).getFavItemInfoStorage().v(this.mvK.bxl().bxM(), this.mvK.bxl().getType()))
      {
        ab.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
        AppMethodBeat.o(73930);
        return;
      }
      if (FavBaseUI.a(this.mvK))
      {
        ab.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
        FavBaseUI.b(this.mvK);
      }
    }
    AppMethodBeat.o(73930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.5
 * JD-Core Version:    0.7.0.1
 */