package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;

final class FavoriteFileDetailUI$12
  implements View.OnClickListener
{
  FavoriteFileDetailUI$12(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74334);
    paramView = b.b(FavoriteFileDetailUI.a(this.mAf));
    if (4 == FavoriteFileDetailUI.c(this.mAf))
    {
      FavoriteFileDetailUI.d(this.mAf);
      FavoriteFileDetailUI.e(this.mAf);
      AppMethodBeat.o(74334);
      return;
    }
    FavoriteFileDetailUI.a(this.mAf, paramView);
    AppMethodBeat.o(74334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.12
 * JD-Core Version:    0.7.0.1
 */