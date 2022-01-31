package com.tencent.mm.chatroom.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.n.d;

final class RoomCardUI$9
  implements n.d
{
  RoomCardUI$9(RoomCardUI paramRoomCardUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(155174);
    if (paramInt == 0) {
      ((ClipboardManager)ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.ehq.getText().toString()));
    }
    AppMethodBeat.o(155174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.9
 * JD-Core Version:    0.7.0.1
 */