package com.tencent.mm.plugin.emoji.ui.v2;

import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class EmojiStoreV2SingleProductDialogUI$6
  implements d.a
{
  EmojiStoreV2SingleProductDialogUI$6(EmojiStoreV2SingleProductDialogUI paramEmojiStoreV2SingleProductDialogUI) {}
  
  public final void j(EmojiInfo paramEmojiInfo)
  {
    if ((paramEmojiInfo != null) && (EmojiStoreV2SingleProductDialogUI.a(this.jif) != null) && (EmojiStoreV2SingleProductDialogUI.a(this.jif).jnU.equals(paramEmojiInfo.Wv())))
    {
      EmojiStoreV2SingleProductDialogUI.f(this.jif);
      return;
    }
    y.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "somethings error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.6
 * JD-Core Version:    0.7.0.1
 */