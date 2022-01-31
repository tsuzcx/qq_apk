package com.tencent.mm.plugin.fav.ui.detail;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavoriteFileDetailUI$8
  implements Runnable
{
  FavoriteFileDetailUI$8(FavoriteFileDetailUI paramFavoriteFileDetailUI, float paramFloat, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(74330);
    FavoriteFileDetailUI.t(this.mAf).setProgress((int)this.mAi);
    FavoriteFileDetailUI.u(this.mAf).setText(this.val$tips);
    AppMethodBeat.o(74330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.8
 * JD-Core Version:    0.7.0.1
 */