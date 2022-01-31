package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.e;

final class FavoriteImgDetailUI$11
  implements n.d
{
  FavoriteImgDetailUI$11(FavoriteImgDetailUI paramFavoriteImgDetailUI, FavoriteImgDetailUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(74388);
    String str = b.b(this.mAB.cuL);
    if (!e.cN(str))
    {
      ab.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
      AppMethodBeat.o(74388);
      return;
    }
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74388);
      return;
      b.d(str, this.mAv.getContext());
      h.i(FavoriteImgDetailUI.b(this.mAv).field_localId, 0, 0);
      AppMethodBeat.o(74388);
      return;
      if (r.aoY(str))
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Select_Conv_Type", 3);
        paramMenuItem.putExtra("select_is_ret", true);
        d.b(this.mAv, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
      }
      for (;;)
      {
        h.i(FavoriteImgDetailUI.b(this.mAv).field_localId, 1, 0);
        AppMethodBeat.o(74388);
        return;
        b.c(str, this.mAv.getContext());
      }
      FavoriteImgDetailUI.a(str, this.mAv.getString(2131299818), this.mAv.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.11
 * JD-Core Version:    0.7.0.1
 */