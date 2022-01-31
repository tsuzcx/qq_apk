package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.model.s;

final class GameMessageUI$2$1
  implements DialogInterface.OnClickListener
{
  GameMessageUI$2$1(GameMessageUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((c)g.r(c.class)).aYf().gk("GameRawMessage", "delete from GameRawMessage");
    GameMessageUI.b(this.lef.lee).yd();
    GameMessageUI.b(this.lef.lee).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.2.1
 * JD-Core Version:    0.7.0.1
 */