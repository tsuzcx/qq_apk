package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.ui.tools.a.b.a;

final class EmojiAddCustomDialogUI$2
  implements b.a
{
  EmojiAddCustomDialogUI$2(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI, EmojiInfo paramEmojiInfo) {}
  
  public final void a(b paramb)
  {
    if (i.getEmojiStorageMgr().uBb.fc(false) >= l.aHC())
    {
      y.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      this.jcr.aIJ();
      EmojiAddCustomDialogUI.a(this.jcr);
      h.nFQ.f(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.b(this.jcr)), EmojiAddCustomDialogUI.c(this.jcr).Wv(), EmojiAddCustomDialogUI.c(this.jcr).field_designerID, EmojiAddCustomDialogUI.c(this.jcr).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.c(this.jcr).field_size), EmojiAddCustomDialogUI.d(this.jcr), EmojiAddCustomDialogUI.c(this.jcr).field_activityid });
      return;
    }
    if ((this.iWy.field_catalog == EmojiInfo.uCZ) || (bk.bl(this.iWy.field_groupId)) || ((!bk.bl(this.iWy.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ax(this.iWy.field_groupId))))
    {
      EmojiAddCustomDialogUI.a(this.jcr, this.iWy);
      return;
    }
    EmojiAddCustomDialogUI.l(this.iWy);
  }
  
  public final void aIT()
  {
    this.jcr.aIJ();
    EmojiAddCustomDialogUI.e(this.jcr);
    h.nFQ.f(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.b(this.jcr)), EmojiAddCustomDialogUI.c(this.jcr).Wv(), EmojiAddCustomDialogUI.c(this.jcr).field_designerID, EmojiAddCustomDialogUI.c(this.jcr).field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(EmojiAddCustomDialogUI.c(this.jcr).field_size), EmojiAddCustomDialogUI.d(this.jcr), EmojiAddCustomDialogUI.c(this.jcr).field_activityid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.2
 * JD-Core Version:    0.7.0.1
 */