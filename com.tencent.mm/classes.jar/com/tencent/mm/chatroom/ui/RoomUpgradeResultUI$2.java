package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.aa;

final class RoomUpgradeResultUI$2
  implements View.OnClickListener
{
  RoomUpgradeResultUI$2(RoomUpgradeResultUI paramRoomUpgradeResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104221);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.ehU.getString(2131298131, new Object[] { aa.dsG() }));
    paramView.putExtra("geta8key_username", r.Zn());
    d.c(this.ehU, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
    AppMethodBeat.o(104221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI.2
 * JD-Core Version:    0.7.0.1
 */