package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.tools.b.b;
import com.tencent.mm.ui.tools.b.b.a;

final class EmojiAddCustomDialogUI$2
  implements b.a
{
  EmojiAddCustomDialogUI$2(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI, EmojiInfo paramEmojiInfo) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(53270);
    paramb = e.ewz;
    if (e.OC().getBoolean("custom_full", false))
    {
      ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
      this.lld.bmh();
      EmojiAddCustomDialogUI.a(this.lld);
      h.qsU.e(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.b(this.lld)), EmojiAddCustomDialogUI.c(this.lld).Al(), EmojiAddCustomDialogUI.c(this.lld).field_designerID, EmojiAddCustomDialogUI.c(this.lld).field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.c(this.lld).field_size), EmojiAddCustomDialogUI.d(this.lld), EmojiAddCustomDialogUI.c(this.lld).field_activityid });
      AppMethodBeat.o(53270);
      return;
    }
    if ((this.lfG.field_catalog == EmojiInfo.yPm) || (bo.isNullOrNil(this.lfG.field_groupId)) || (bo.isEqual(this.lfG.field_groupId, "capture")) || ((!bo.isNullOrNil(this.lfG.field_groupId)) && (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Ky(this.lfG.field_groupId))))
    {
      EmojiAddCustomDialogUI.v(this.lfG);
      AppMethodBeat.o(53270);
      return;
    }
    EmojiAddCustomDialogUI.w(this.lfG);
    AppMethodBeat.o(53270);
  }
  
  public final void bmr()
  {
    AppMethodBeat.i(53271);
    this.lld.bmh();
    EmojiAddCustomDialogUI.e(this.lld);
    h.qsU.e(10431, new Object[] { Integer.valueOf(EmojiAddCustomDialogUI.b(this.lld)), EmojiAddCustomDialogUI.c(this.lld).Al(), EmojiAddCustomDialogUI.c(this.lld).field_designerID, EmojiAddCustomDialogUI.c(this.lld).field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(EmojiAddCustomDialogUI.c(this.lld).field_size), EmojiAddCustomDialogUI.d(this.lld), EmojiAddCustomDialogUI.c(this.lld).field_activityid });
    AppMethodBeat.o(53271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.2
 * JD-Core Version:    0.7.0.1
 */