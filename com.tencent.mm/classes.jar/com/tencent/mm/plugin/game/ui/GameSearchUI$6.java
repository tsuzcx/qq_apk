package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

final class GameSearchUI$6
  implements AdapterView.OnItemClickListener
{
  GameSearchUI$6(GameSearchUI paramGameSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(42391);
    paramAdapterView = ((s)paramAdapterView.getAdapter()).EN(paramInt);
    if (bt.isNullOrNil(paramAdapterView.text))
    {
      AppMethodBeat.o(42391);
      return;
    }
    if (bt.isNullOrNil(paramAdapterView.appId))
    {
      paramView = new LinkedList();
      paramView.add(paramAdapterView.text);
      GameSearchUI.b(this.sna, paramView);
      GameSearchUI.h(this.sna);
      AppMethodBeat.o(42391);
      return;
    }
    switch (paramAdapterView.actionType)
    {
    default: 
      ad.e("MicroMsg.GameSearchUI", "unknowed actionType : " + paramAdapterView.actionType);
      AppMethodBeat.o(42391);
      return;
    case 1: 
      paramView = new Bundle();
      paramView.putCharSequence("game_app_id", paramAdapterView.appId);
      paramView.putInt("game_report_from_scene", 1402);
      i = c.a(this.sna, paramAdapterView.appId, null, paramView);
      e.a(this.sna, 14, 1402, paramInt, i, paramAdapterView.appId, GameSearchUI.g(this.sna), null);
      AppMethodBeat.o(42391);
      return;
    }
    int i = c.A(this.sna.getContext(), paramAdapterView.smF, "game_center_detail");
    e.a(this.sna, 14, 1402, paramInt, i, paramAdapterView.appId, GameSearchUI.g(this.sna), null);
    AppMethodBeat.o(42391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI.6
 * JD-Core Version:    0.7.0.1
 */