package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;

final class RoomUpgradeResultUI$2
  implements View.OnClickListener
{
  RoomUpgradeResultUI$2(RoomUpgradeResultUI paramRoomUpgradeResultUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.dqw.getString(a.i.chatroom_how_to_upgrade, new Object[] { x.cqJ() }));
    paramView.putExtra("geta8key_username", q.Gj());
    d.c(this.dqw, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI.2
 * JD-Core Version:    0.7.0.1
 */