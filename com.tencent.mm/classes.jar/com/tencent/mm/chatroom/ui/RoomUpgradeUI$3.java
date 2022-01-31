package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.aa;

final class RoomUpgradeUI$3
  implements View.OnClickListener
{
  RoomUpgradeUI$3(RoomUpgradeUI paramRoomUpgradeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104237);
    if (RoomUpgradeUI.e(this.eie).getVisibility() == 0)
    {
      paramView = new Intent();
      RoomUpgradeUI.a(this.eie, this.eie.getString(2131298131, new Object[] { aa.dsG() }));
      paramView.putExtra("rawUrl", RoomUpgradeUI.f(this.eie));
      paramView.putExtra("geta8key_username", r.Zn());
      paramView.putExtra("showShare", false);
      d.b(this.eie, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView, 500);
    }
    AppMethodBeat.o(104237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI.3
 * JD-Core Version:    0.7.0.1
 */