package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.q.g;

final class RoomCardUI$11
  implements q.g
{
  RoomCardUI$11(RoomCardUI paramRoomCardUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(191261);
    if (paramInt == 0) {
      ClipboardHelper.setText(MMApplicationContext.getContext(), null, this.jip.getText().toString());
    }
    AppMethodBeat.o(191261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.11
 * JD-Core Version:    0.7.0.1
 */