package com.tencent.mm.plugin.game.ui;

import android.widget.ListView;
import com.tencent.mm.ui.r.a;

final class GameMessageUI$3
  implements r.a
{
  GameMessageUI$3(GameMessageUI paramGameMessageUI) {}
  
  public final void Wp()
  {
    if (GameMessageUI.b(this.lee).getCount() == 0)
    {
      GameMessageUI.e(this.lee).setVisibility(8);
      GameMessageUI.a(this.lee, 0);
      this.lee.enableOptionMenu(false);
      return;
    }
    GameMessageUI.e(this.lee).setVisibility(0);
    GameMessageUI.a(this.lee, 8);
    this.lee.enableOptionMenu(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.3
 * JD-Core Version:    0.7.0.1
 */