package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bk;

final class EmojiCustomUI$14
  implements j.a
{
  EmojiCustomUI$14(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void a(String paramString, l paraml)
  {
    if ((!bk.bl(paramString)) && ((paramString.length() == 32) || (paramString.equals("event_update_emoji"))) && (EmojiCustomUI.e(this.jcS) != null))
    {
      EmojiCustomUI.e(this.jcS).aJc();
      EmojiCustomUI.e(this.jcS).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.14
 * JD-Core Version:    0.7.0.1
 */