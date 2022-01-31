package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.tools.e.b;

final class FavoriteVideoPlayUI$5
  implements e.b
{
  FavoriteVideoPlayUI$5(FavoriteVideoPlayUI paramFavoriteVideoPlayUI) {}
  
  public final void onAnimationEnd()
  {
    new ah().post(new FavoriteVideoPlayUI.5.1(this));
  }
  
  public final void onAnimationStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.5
 * JD-Core Version:    0.7.0.1
 */