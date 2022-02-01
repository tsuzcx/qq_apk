package com.tencent.mm.plugin.game.ui.message;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class GameMsgCenterUI$5
  implements ViewPager.OnPageChangeListener
{
  GameMsgCenterUI$5(GameMsgCenterUI paramGameMsgCenterUI) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(183873);
    ad.i("MicroMsg.GameMsgCenterUI", "onPageSelected:%d", new Object[] { Integer.valueOf(paramInt) });
    this.uuA.setCurrentItem(paramInt);
    AppMethodBeat.o(183873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.GameMsgCenterUI.5
 * JD-Core Version:    0.7.0.1
 */