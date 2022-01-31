package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class FTSEmojiDetailPageUI$10
  implements d.a
{
  FTSEmojiDetailPageUI$10(FTSEmojiDetailPageUI paramFTSEmojiDetailPageUI) {}
  
  public final void j(EmojiInfo paramEmojiInfo)
  {
    if ((paramEmojiInfo != null) && (FTSEmojiDetailPageUI.a(this.jfO) != null) && (FTSEmojiDetailPageUI.a(this.jfO).Wv().equals(paramEmojiInfo.Wv())))
    {
      y.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[] { FTSEmojiDetailPageUI.a(this.jfO).Wv() });
      ai.d(new FTSEmojiDetailPageUI.10.1(this));
      return;
    }
    y.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.10
 * JD-Core Version:    0.7.0.1
 */