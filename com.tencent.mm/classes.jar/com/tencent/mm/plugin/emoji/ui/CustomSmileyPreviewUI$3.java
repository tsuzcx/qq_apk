package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class CustomSmileyPreviewUI$3
  implements n.c
{
  CustomSmileyPreviewUI$3(CustomSmileyPreviewUI paramCustomSmileyPreviewUI) {}
  
  public final void a(l paraml)
  {
    if ((CustomSmileyPreviewUI.b(this.jcf).field_catalog != EmojiInfo.uCZ) && (!CustomSmileyPreviewUI.b(this.jcf).cwC())) {
      paraml.fq(0, f.h.add_to_custom_smiley);
    }
    if ((CustomSmileyPreviewUI.b(this.jcf).field_catalog == EmojiInfo.uCZ) || (bk.bl(CustomSmileyPreviewUI.b(this.jcf).field_groupId)) || ((!bk.bl(CustomSmileyPreviewUI.b(this.jcf).field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ax(CustomSmileyPreviewUI.b(this.jcf).field_groupId)))) {
      paraml.fq(1, f.h.retransmits);
    }
    if (((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().h(CustomSmileyPreviewUI.b(this.jcf))) {
      paraml.fq(2, f.h.emoji_preview_imitate);
    }
    paraml.fq(3, f.h.emoji_expose);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.3
 * JD-Core Version:    0.7.0.1
 */