package com.tencent.mm.plugin.game.ui.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class GameTabBridgeUI$3
  extends BroadcastReceiver
{
  GameTabBridgeUI$3(GameTabBridgeUI paramGameTabBridgeUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(112240);
    if ((paramIntent != null) && ("com.tencent.mm.ACTION_EXIT".equals(paramIntent.getAction())) && (this.nDP != null) && (!this.nDP.isFinishing()))
    {
      ab.i("MicroMsg.GameTabBridgeUI", "GameTabBridgeUI exit!");
      this.nDP.finish();
    }
    AppMethodBeat.o(112240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI.3
 * JD-Core Version:    0.7.0.1
 */