package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ModRemarkRoomNameUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ModRemarkRoomNameUI$2(ModRemarkRoomNameUI paramModRemarkRoomNameUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(104118);
    this.egL.setResult(0);
    this.egL.finish();
    AppMethodBeat.o(104118);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.2
 * JD-Core Version:    0.7.0.1
 */