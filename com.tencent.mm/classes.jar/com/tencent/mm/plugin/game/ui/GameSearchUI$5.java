package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

final class GameSearchUI$5
  implements AdapterView.OnItemClickListener
{
  GameSearchUI$5(GameSearchUI paramGameSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = GameSearchUI.b(this.lfG);
    if ((paramInt < 0) || (paramInt >= paramAdapterView.getCount()))
    {
      paramAdapterView = null;
      if (paramAdapterView != null) {
        break label42;
      }
    }
    label42:
    do
    {
      return;
      paramAdapterView = ((r.b)paramAdapterView.getItem(paramInt)).lfi;
      break;
      if ((paramAdapterView.actionType == 1) && (!bk.bl(paramAdapterView.appId)))
      {
        paramView = new Bundle();
        paramView.putCharSequence("game_app_id", paramAdapterView.appId);
        paramView.putInt("game_report_from_scene", paramAdapterView.bXn);
        paramInt = c.b(this.lfG, paramAdapterView.appId, null, paramView);
        paramView = new HashMap();
        paramView.put("function_type", "search");
        paramView.put("funtion_value", paramAdapterView.lfk);
        paramView.put("keyword", GameSearchUI.f(this.lfG));
        paramView = a.B(paramView);
        b.a(this.lfG, 14, paramAdapterView.bXn, paramAdapterView.position, paramInt, paramAdapterView.appId, GameSearchUI.g(this.lfG), paramView);
        return;
      }
    } while ((paramAdapterView.actionType != 2) || (bk.bl(paramAdapterView.lfj)));
    paramInt = c.o(this.lfG, paramAdapterView.lfj, "game_center_detail");
    paramView = new HashMap();
    paramView.put("function_type", "search");
    paramView.put("funtion_value", paramAdapterView.lfk);
    paramView.put("keyword", GameSearchUI.f(this.lfG));
    paramView = a.B(paramView);
    b.a(this.lfG, 14, paramAdapterView.bXn, paramAdapterView.position, paramInt, 0, paramAdapterView.appId, GameSearchUI.g(this.lfG), paramAdapterView.lfe, String.valueOf(paramAdapterView.lff), null, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI.5
 * JD-Core Version:    0.7.0.1
 */