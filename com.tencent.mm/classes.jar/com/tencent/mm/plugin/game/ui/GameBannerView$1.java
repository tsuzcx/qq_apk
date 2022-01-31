package com.tencent.mm.plugin.game.ui;

import android.support.v4.view.ViewPager;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import java.util.LinkedList;

final class GameBannerView$1
  implements am.a
{
  GameBannerView$1(GameBannerView paramGameBannerView) {}
  
  public final boolean tC()
  {
    if ((GameBannerView.a(this.kXl) != null) && (GameBannerView.b(this.kXl).size() > 1))
    {
      GameBannerView.a(this.kXl).m(GameBannerView.a(this.kXl).getCurrentItem() + 1, true);
      return true;
    }
    GameBannerView.c(this.kXl).stopTimer();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBannerView.1
 * JD-Core Version:    0.7.0.1
 */