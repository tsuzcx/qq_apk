package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bo;

final class EmojiCustomUI$14
  implements k.a
{
  EmojiCustomUI$14(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(53312);
    if ((!bo.isNullOrNil(paramString)) && ((paramString.length() == 32) || (paramString.equals("event_update_emoji"))) && (EmojiCustomUI.f(this.llF) != null))
    {
      EmojiCustomUI.f(this.llF).bmC();
      EmojiCustomUI.f(this.llF).notifyDataSetChanged();
    }
    AppMethodBeat.o(53312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.14
 * JD-Core Version:    0.7.0.1
 */