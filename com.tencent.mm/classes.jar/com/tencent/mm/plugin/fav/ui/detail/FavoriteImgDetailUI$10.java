package com.tencent.mm.plugin.fav.ui.detail;

import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;

final class FavoriteImgDetailUI$10
  implements n.c
{
  FavoriteImgDetailUI$10(FavoriteImgDetailUI paramFavoriteImgDetailUI, d paramd, FavoriteImgDetailUI.a parama) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(74387);
    paraml.clear();
    this.mAE.setFooterView(null);
    if (FavoriteImgDetailUI.a(this.mAv))
    {
      if (FavoriteImgDetailUI.b(this.mAv).bwl()) {
        paraml.e(2, this.mAv.getContext().getString(2131299826));
      }
      if (FavoriteImgDetailUI.b(this.mAv).bwm()) {
        paraml.e(1, this.mAv.getContext().getString(2131299779));
      }
      paraml.e(3, this.mAv.getContext().getString(2131299819));
      if (!bo.isNullOrNil(this.mAB.mAH)) {
        this.mAE.setFooterView(FavoriteImgDetailUI.b(this.mAv, this.mAB));
      }
    }
    AppMethodBeat.o(74387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.10
 * JD-Core Version:    0.7.0.1
 */