package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;

final class ModRemarkRoomNameUI$3
  implements MenuItem.OnMenuItemClickListener
{
  ModRemarkRoomNameUI$3(ModRemarkRoomNameUI paramModRemarkRoomNameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(104119);
    this.egL.hideVKB();
    paramMenuItem = b.MZ();
    if ((!bo.isNullOrNil(paramMenuItem)) && ("".matches(".*[" + paramMenuItem + "].*")))
    {
      h.b(this.egL.getContext(), this.egL.getString(2131300749, new Object[] { paramMenuItem }), this.egL.getString(2131297087), true);
      AppMethodBeat.o(104119);
      return false;
    }
    c.d(ModRemarkRoomNameUI.a(this.egL)).hR(1, 32).a(this.egL);
    AppMethodBeat.o(104119);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.3
 * JD-Core Version:    0.7.0.1
 */