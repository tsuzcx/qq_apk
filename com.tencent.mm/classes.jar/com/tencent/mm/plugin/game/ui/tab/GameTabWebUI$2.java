package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class GameTabWebUI$2
  extends BroadcastReceiver
{
  GameTabWebUI$2(GameTabWebUI paramGameTabWebUI) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.mm.ACTION_EXIT".equals(paramIntent.getAction())) && (GameTabWebUI.b(this.lfY) != null) && (!GameTabWebUI.b(this.lfY).isFinishing()))
    {
      y.i("MicroMsg.GameTabWebUI", "%s exit!", new Object[] { GameTabWebUI.b(this.lfY).getClass().getSimpleName() });
      GameTabWebUI.b(this.lfY).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWebUI.2
 * JD-Core Version:    0.7.0.1
 */