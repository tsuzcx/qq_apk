package com.tencent.mm.chatroom.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.ui.base.n.d;

final class RoomCardUI$7
  implements n.d
{
  RoomCardUI$7(RoomCardUI paramRoomCardUI, TextView paramTextView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramInt == 0) {
      ((ClipboardManager)this.dpT.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, this.dpT.getText().toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.7
 * JD-Core Version:    0.7.0.1
 */