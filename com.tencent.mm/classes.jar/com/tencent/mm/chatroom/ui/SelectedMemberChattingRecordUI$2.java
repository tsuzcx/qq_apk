package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;

final class SelectedMemberChattingRecordUI$2
  implements MMLoadMoreListView.a
{
  SelectedMemberChattingRecordUI$2(SelectedMemberChattingRecordUI paramSelectedMemberChattingRecordUI) {}
  
  public final void Kt()
  {
    AppMethodBeat.i(104437);
    SelectedMemberChattingRecordUI.a locala;
    if (SelectedMemberChattingRecordUI.a(this.ekb) != null)
    {
      locala = SelectedMemberChattingRecordUI.a(this.ekb);
      locala.ekd -= 16;
      if ((bo.isNullOrNil(SelectedMemberChattingRecordUI.c(locala.ekb))) || (!r.nB(SelectedMemberChattingRecordUI.c(locala.ekb)))) {
        break label111;
      }
      locala.setCursor(((j)g.E(j.class)).bPQ().cL(locala.ejr, locala.eke - locala.ekd));
    }
    for (;;)
    {
      SelectedMemberChattingRecordUI.a(this.ekb).notifyDataSetChanged();
      AppMethodBeat.o(104437);
      return;
      label111:
      if (!r.nB(SelectedMemberChattingRecordUI.c(locala.ekb))) {
        locala.setCursor(((j)g.E(j.class)).bPQ().L(locala.ejr, locala.ekc, locala.eke - locala.ekd));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI.2
 * JD-Core Version:    0.7.0.1
 */