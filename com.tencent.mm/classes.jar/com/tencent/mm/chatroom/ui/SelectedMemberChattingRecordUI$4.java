package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SelectedMemberChattingRecordUI$4
  implements MenuItem.OnMenuItemClickListener
{
  SelectedMemberChattingRecordUI$4(SelectedMemberChattingRecordUI paramSelectedMemberChattingRecordUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(224395);
    this.fVP.setResult(0);
    this.fVP.finish();
    AppMethodBeat.o(224395);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.4
 * JD-Core Version:    0.7.0.1
 */