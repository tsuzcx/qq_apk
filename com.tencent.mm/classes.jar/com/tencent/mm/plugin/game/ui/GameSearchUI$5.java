package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class GameSearchUI$5
  implements AdapterView.OnItemClickListener
{
  GameSearchUI$5(GameSearchUI paramGameSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(112192);
    paramAdapterView = GameSearchUI.b(this.nDB);
    if ((paramInt < 0) || (paramInt >= paramAdapterView.getCount())) {}
    for (paramAdapterView = null; paramAdapterView == null; paramAdapterView = ((r.b)paramAdapterView.getItem(paramInt)).nDd)
    {
      AppMethodBeat.o(112192);
      return;
    }
    if ((paramAdapterView.actionType == 1) && (!bo.isNullOrNil(paramAdapterView.appId)))
    {
      paramView = new Bundle();
      paramView.putCharSequence("game_app_id", paramAdapterView.appId);
      paramView.putInt("game_report_from_scene", paramAdapterView.cFj);
      paramInt = com.tencent.mm.plugin.game.f.c.b(this.nDB, paramAdapterView.appId, null, paramView);
      paramView = new HashMap();
      paramView.put("function_type", "search");
      paramView.put("funtion_value", paramAdapterView.nDf);
      paramView.put("keyword", GameSearchUI.f(this.nDB));
      paramView = a.h(paramView);
      com.tencent.mm.game.report.c.a(this.nDB, 14, paramAdapterView.cFj, paramAdapterView.position, paramInt, paramAdapterView.appId, GameSearchUI.g(this.nDB), paramView);
      AppMethodBeat.o(112192);
      return;
    }
    if ((paramAdapterView.actionType == 2) && (!bo.isNullOrNil(paramAdapterView.nDe)))
    {
      paramInt = com.tencent.mm.plugin.game.f.c.t(this.nDB, paramAdapterView.nDe, "game_center_detail");
      paramView = new HashMap();
      paramView.put("function_type", "search");
      paramView.put("funtion_value", paramAdapterView.nDf);
      paramView.put("keyword", GameSearchUI.f(this.nDB));
      paramView = a.h(paramView);
      com.tencent.mm.game.report.c.a(this.nDB, 14, paramAdapterView.cFj, paramAdapterView.position, paramInt, 0, paramAdapterView.appId, GameSearchUI.g(this.nDB), paramAdapterView.nCZ, String.valueOf(paramAdapterView.nDa), null, paramView);
    }
    AppMethodBeat.o(112192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI.5
 * JD-Core Version:    0.7.0.1
 */