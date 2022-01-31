package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.storage.bi;

final class SelectedMemberChattingRecordUI$1
  implements AdapterView.OnItemClickListener
{
  SelectedMemberChattingRecordUI$1(SelectedMemberChattingRecordUI paramSelectedMemberChattingRecordUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bi)SelectedMemberChattingRecordUI.a(this.dst).getItem(paramInt);
    if (paramAdapterView != null) {
      SelectedMemberChattingRecordUI.a(this.dst, paramAdapterView.field_msgId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.1
 * JD-Core Version:    0.7.0.1
 */