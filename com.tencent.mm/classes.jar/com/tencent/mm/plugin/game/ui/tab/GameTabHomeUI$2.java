package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class GameTabHomeUI$2
  extends BroadcastReceiver
{
  GameTabHomeUI$2(GameTabHomeUI paramGameTabHomeUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(112251);
    if ((paramIntent != null) && ("com.tencent.mm.ACTION_EXIT".equals(paramIntent.getAction())) && (this.nDS != null) && (!this.nDS.isFinishing()))
    {
      ab.i("MicroMsg.GameTabHomeUI", "GameTabHomeUI exit!");
      this.nDS.finish();
    }
    AppMethodBeat.o(112251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI.2
 * JD-Core Version:    0.7.0.1
 */