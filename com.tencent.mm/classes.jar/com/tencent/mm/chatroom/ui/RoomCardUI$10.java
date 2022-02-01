package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u.i;

final class RoomCardUI$10
  implements u.i
{
  RoomCardUI$10(RoomCardUI paramRoomCardUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(241497);
    if (paramInt == 0) {
      ClipboardHelper.setText(MMApplicationContext.getContext(), null, this.lKF.getText().toString());
    }
    AppMethodBeat.o(241497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.10
 * JD-Core Version:    0.7.0.1
 */