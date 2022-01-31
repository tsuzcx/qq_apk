package com.tencent.mm.plugin.fav.ui.detail;

import android.widget.ProgressBar;
import android.widget.TextView;

final class FavoriteFileDetailUI$5
  implements Runnable
{
  FavoriteFileDetailUI$5(FavoriteFileDetailUI paramFavoriteFileDetailUI, float paramFloat, String paramString) {}
  
  public final void run()
  {
    FavoriteFileDetailUI.p(this.kfu).setProgress((int)this.kfw);
    FavoriteFileDetailUI.q(this.kfu).setText(this.val$tips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.5
 * JD-Core Version:    0.7.0.1
 */