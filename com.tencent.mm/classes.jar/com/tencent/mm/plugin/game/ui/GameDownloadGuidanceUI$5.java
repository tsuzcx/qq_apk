package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.model.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class GameDownloadGuidanceUI$5
  implements Runnable
{
  GameDownloadGuidanceUI$5(GameDownloadGuidanceUI paramGameDownloadGuidanceUI, a parama, long paramLong) {}
  
  public final void run()
  {
    if (this.kYD == null) {
      GameDownloadGuidanceUI.a(this.laC, new bh());
    }
    for (;;)
    {
      ai.d(new GameDownloadGuidanceUI.5.1(this, new ac(this.kYD)));
      return;
      GameDownloadGuidanceUI.a(this.laC, (bh)this.kYD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.5
 * JD-Core Version:    0.7.0.1
 */