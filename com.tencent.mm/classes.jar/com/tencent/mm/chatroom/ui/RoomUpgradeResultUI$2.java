package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.LocaleUtil;

final class RoomUpgradeResultUI$2
  implements View.OnClickListener
{
  RoomUpgradeResultUI$2(RoomUpgradeResultUI paramRoomUpgradeResultUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(12769);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.lLx.getString(a.i.chatroom_how_to_upgrade, new Object[] { LocaleUtil.getApplicationLanguage() }));
    paramView.putExtra("geta8key_username", z.bAM());
    c.g(this.lLx, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
    a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(12769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI.2
 * JD-Core Version:    0.7.0.1
 */