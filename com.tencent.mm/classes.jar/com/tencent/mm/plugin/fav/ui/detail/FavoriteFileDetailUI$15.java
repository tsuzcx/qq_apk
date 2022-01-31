package com.tencent.mm.plugin.fav.ui.detail;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;

final class FavoriteFileDetailUI$15
  implements View.OnClickListener
{
  FavoriteFileDetailUI$15(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(74337);
    if (FavoriteFileDetailUI.b(this.mAf).isDownloading())
    {
      b.d(FavoriteFileDetailUI.a(this.mAf));
      FavoriteFileDetailUI.h(this.mAf).setText(2131299749);
    }
    for (;;)
    {
      FavoriteFileDetailUI.i(this.mAf);
      AppMethodBeat.o(74337);
      return;
      b.n(FavoriteFileDetailUI.b(this.mAf));
      FavoriteFileDetailUI.h(this.mAf).setText(2131299750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.15
 * JD-Core Version:    0.7.0.1
 */