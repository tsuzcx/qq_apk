package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.r;

final class GameMessageUI$2$1
  implements DialogInterface.OnClickListener
{
  GameMessageUI$2$1(GameMessageUI.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(112100);
    ((e)g.E(e.class)).bES().execSQL("GameRawMessage", "delete from GameRawMessage");
    GameMessageUI.b(this.nCa.nBZ).Kv();
    GameMessageUI.b(this.nCa.nBZ).notifyDataSetChanged();
    AppMethodBeat.o(112100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.2.1
 * JD-Core Version:    0.7.0.1
 */