package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class CustomSmileyPreviewUI$3
  implements n.c
{
  CustomSmileyPreviewUI$3(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(138340);
    if ((CustomSmileyPreviewUI.b(this.lkP).field_catalog != EmojiInfo.yPm) && (!CustomSmileyPreviewUI.b(this.lkP).dzq())) {
      paraml.hx(0, 2131296431);
    }
    if ((CustomSmileyPreviewUI.b(this.lkP).field_catalog == EmojiInfo.yPm) || (bo.isNullOrNil(CustomSmileyPreviewUI.b(this.lkP).field_groupId)) || ((!bo.isNullOrNil(CustomSmileyPreviewUI.b(this.lkP).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(CustomSmileyPreviewUI.b(this.lkP).field_groupId)))) {
      paraml.hx(1, 2131302657);
    }
    com.tencent.mm.pluginsdk.a.d locald = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
    CustomSmileyPreviewUI.b(this.lkP);
    if (locald.bkX()) {
      paraml.hx(2, 2131299163);
    }
    paraml.hx(3, 2131299140);
    AppMethodBeat.o(138340);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.3
 * JD-Core Version:    0.7.0.1
 */