package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class GameSearchUI$6
  implements AdapterView.OnItemClickListener
{
  GameSearchUI$6(GameSearchUI paramGameSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(112193);
    paramAdapterView = ((s)paramAdapterView.getAdapter()).xn(paramInt);
    if (bo.isNullOrNil(paramAdapterView.text))
    {
      AppMethodBeat.o(112193);
      return;
    }
    if (bo.isNullOrNil(paramAdapterView.appId))
    {
      paramView = new LinkedList();
      paramView.add(paramAdapterView.text);
      GameSearchUI.b(this.nDB, paramView);
      GameSearchUI.h(this.nDB);
      AppMethodBeat.o(112193);
      return;
    }
    switch (paramAdapterView.actionType)
    {
    default: 
      ab.e("MicroMsg.GameSearchUI", "unknowed actionType : " + paramAdapterView.actionType);
      AppMethodBeat.o(112193);
      return;
    case 1: 
      paramView = new Bundle();
      paramView.putCharSequence("game_app_id", paramAdapterView.appId);
      paramView.putInt("game_report_from_scene", 1402);
      i = com.tencent.mm.plugin.game.f.c.b(this.nDB, paramAdapterView.appId, null, paramView);
      com.tencent.mm.game.report.c.a(this.nDB, 14, 1402, paramInt, i, paramAdapterView.appId, GameSearchUI.g(this.nDB), null);
      AppMethodBeat.o(112193);
      return;
    }
    int i = com.tencent.mm.plugin.game.f.c.t(this.nDB.getContext(), paramAdapterView.nDg, "game_center_detail");
    com.tencent.mm.game.report.c.a(this.nDB, 14, 1402, paramInt, i, paramAdapterView.appId, GameSearchUI.g(this.nDB), null);
    AppMethodBeat.o(112193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI.6
 * JD-Core Version:    0.7.0.1
 */