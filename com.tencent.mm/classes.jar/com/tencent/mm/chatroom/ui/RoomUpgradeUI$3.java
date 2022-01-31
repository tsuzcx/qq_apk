package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;

final class RoomUpgradeUI$3
  implements View.OnClickListener
{
  RoomUpgradeUI$3(RoomUpgradeUI paramRoomUpgradeUI) {}
  
  public final void onClick(View paramView)
  {
    if (RoomUpgradeUI.e(this.dqG).getVisibility() == 0)
    {
      paramView = new Intent();
      RoomUpgradeUI.a(this.dqG, this.dqG.getString(a.i.chatroom_how_to_upgrade, new Object[] { x.cqJ() }));
      paramView.putExtra("rawUrl", RoomUpgradeUI.f(this.dqG));
      paramView.putExtra("geta8key_username", q.Gj());
      paramView.putExtra("showShare", false);
      d.b(this.dqG, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView, 500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI.3
 * JD-Core Version:    0.7.0.1
 */