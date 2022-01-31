package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.storage.bi;

final class SelectedMemberChattingRecordUI$1
  implements AdapterView.OnItemClickListener
{
  SelectedMemberChattingRecordUI$1(SelectedMemberChattingRecordUI paramSelectedMemberChattingRecordUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(104436);
    paramAdapterView = (bi)SelectedMemberChattingRecordUI.a(this.ekb).getItem(paramInt);
    if (paramAdapterView != null) {
      SelectedMemberChattingRecordUI.a(this.ekb, paramAdapterView.field_msgId);
    }
    AppMethodBeat.o(104436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.1
 * JD-Core Version:    0.7.0.1
 */