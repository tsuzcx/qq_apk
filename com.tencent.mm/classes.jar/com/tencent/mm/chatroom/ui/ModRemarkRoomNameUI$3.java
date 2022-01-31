package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.a.c;

final class ModRemarkRoomNameUI$3
  implements MenuItem.OnMenuItemClickListener
{
  ModRemarkRoomNameUI$3(ModRemarkRoomNameUI paramModRemarkRoomNameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.dpp.XM();
    paramMenuItem = b.Ak();
    if ((!bk.bl(paramMenuItem)) && ("".matches(".*[" + paramMenuItem + "].*")))
    {
      h.b(this.dpp.mController.uMN, this.dpp.getString(a.i.invalid_input_character_toast, new Object[] { paramMenuItem }), this.dpp.getString(a.i.app_tip), true);
      return false;
    }
    c.d(ModRemarkRoomNameUI.a(this.dpp)).fJ(1, 32).a(this.dpp);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.3
 * JD-Core Version:    0.7.0.1
 */