package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.c.a;

final class FavoriteFileDetailUI$3
  implements View.OnLongClickListener
{
  FavoriteFileDetailUI$3(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(74323);
    ab.d("MicroMsg.FavoriteFileDetailUI", "onLongClick");
    if (FavoriteFileDetailUI.l(this.mAf) == null) {
      FavoriteFileDetailUI.a(this.mAf, new a(this.mAf.getContext()));
    }
    FavoriteFileDetailUI.l(this.mAf).a(paramView, this.mAf, FavoriteFileDetailUI.m(this.mAf), FavoriteFileDetailUI.n(this.mAf), FavoriteFileDetailUI.o(this.mAf));
    AppMethodBeat.o(74323);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.3
 * JD-Core Version:    0.7.0.1
 */