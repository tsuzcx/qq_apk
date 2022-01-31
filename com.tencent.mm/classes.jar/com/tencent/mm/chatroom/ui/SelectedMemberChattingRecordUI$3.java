package com.tencent.mm.chatroom.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class SelectedMemberChattingRecordUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SelectedMemberChattingRecordUI$3(SelectedMemberChattingRecordUI paramSelectedMemberChattingRecordUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    this.dst.setResult(0);
    this.dst.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.3
 * JD-Core Version:    0.7.0.1
 */