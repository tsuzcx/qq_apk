package com.tencent.mm.chatroom.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.n.d;

final class RoomCardUI$9
  implements n.d
{
  RoomCardUI$9(RoomCardUI paramRoomCardUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(12699);
    if (paramInt == 0) {
      ((ClipboardManager)ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.fxL.getText().toString()));
    }
    AppMethodBeat.o(12699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.9
 * JD-Core Version:    0.7.0.1
 */