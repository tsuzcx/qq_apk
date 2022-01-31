package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

final class GameSearchUI$6
  implements AdapterView.OnItemClickListener
{
  GameSearchUI$6(GameSearchUI paramGameSearchUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((s)paramAdapterView.getAdapter()).sn(paramInt);
    if (bk.bl(paramAdapterView.text)) {
      return;
    }
    if (bk.bl(paramAdapterView.appId))
    {
      paramView = new LinkedList();
      paramView.add(paramAdapterView.text);
      GameSearchUI.b(this.lfG, paramView);
      GameSearchUI.h(this.lfG);
      return;
    }
    switch (paramAdapterView.actionType)
    {
    default: 
      y.e("MicroMsg.GameSearchUI", "unknowed actionType : " + paramAdapterView.actionType);
      return;
    case 1: 
      paramView = new Bundle();
      paramView.putCharSequence("game_app_id", paramAdapterView.appId);
      paramView.putInt("game_report_from_scene", 1402);
      i = c.b(this.lfG, paramAdapterView.appId, null, paramView);
      b.a(this.lfG, 14, 1402, paramInt, i, paramAdapterView.appId, GameSearchUI.g(this.lfG), null);
      return;
    }
    int i = c.o(this.lfG.mController.uMN, paramAdapterView.lfl, "game_center_detail");
    b.a(this.lfG, 14, 1402, paramInt, i, paramAdapterView.appId, GameSearchUI.g(this.lfG), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI.6
 * JD-Core Version:    0.7.0.1
 */