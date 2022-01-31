package com.tencent.mm.chatroom.ui;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;

final class SelectedMemberChattingRecordUI$2
  implements MMLoadMoreListView.a
{
  SelectedMemberChattingRecordUI$2(SelectedMemberChattingRecordUI paramSelectedMemberChattingRecordUI) {}
  
  public final void yb()
  {
    SelectedMemberChattingRecordUI.a locala;
    if (SelectedMemberChattingRecordUI.a(this.dst) != null)
    {
      locala = SelectedMemberChattingRecordUI.a(this.dst);
      locala.dsv -= 16;
      if ((bk.bl(SelectedMemberChattingRecordUI.c(locala.dst))) || (!q.gS(SelectedMemberChattingRecordUI.c(locala.dst)))) {
        break label101;
      }
      locala.setCursor(((j)com.tencent.mm.kernel.g.r(j.class)).bhO().bU(locala.drJ, locala.dsw - locala.dsv));
    }
    for (;;)
    {
      SelectedMemberChattingRecordUI.a(this.dst).notifyDataSetChanged();
      return;
      label101:
      if (!q.gS(SelectedMemberChattingRecordUI.c(locala.dst))) {
        locala.setCursor(((j)com.tencent.mm.kernel.g.r(j.class)).bhO().E(locala.drJ, locala.dsu, locala.dsw - locala.dsv));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.2
 * JD-Core Version:    0.7.0.1
 */