package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.model.r;

final class GameCenterBaseUI$1
  implements Runnable
{
  GameCenterBaseUI$1(GameCenterBaseUI paramGameCenterBaseUI) {}
  
  public final void run()
  {
    GameCenterBaseUI.a(this.kYi);
    if (this.kYi.kYc)
    {
      GameCenterBaseUI.b(this.kYi);
      ((b)g.r(b.class)).aYe();
      r.aZq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterBaseUI.1
 * JD-Core Version:    0.7.0.1
 */