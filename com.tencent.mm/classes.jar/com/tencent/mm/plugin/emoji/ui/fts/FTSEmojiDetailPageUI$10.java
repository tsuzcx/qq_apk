package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class FTSEmojiDetailPageUI$10
  implements c.a
{
  FTSEmojiDetailPageUI$10(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI) {}
  
  public final void a(boolean paramBoolean, EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(53547);
    if ((paramEmojiInfo != null) && (paramBoolean) && (FTSEmojiDetailPageUI.a(this.loH) != null) && (FTSEmojiDetailPageUI.a(this.loH).Al().equals(paramEmojiInfo.Al())))
    {
      ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[] { FTSEmojiDetailPageUI.a(this.loH).Al() });
      al.d(new FTSEmojiDetailPageUI.10.1(this));
      AppMethodBeat.o(53547);
      return;
    }
    ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
    AppMethodBeat.o(53547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.10
 * JD-Core Version:    0.7.0.1
 */