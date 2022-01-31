package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;

final class EmojiCustomUI$18
  extends ak
{
  EmojiCustomUI$18(EmojiCustomUI paramEmojiCustomUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53318);
    switch (paramMessage.what)
    {
    default: 
      ab.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
    case 1001: 
    case 1002: 
      do
      {
        AppMethodBeat.o(53318);
        return;
        EmojiCustomUI.h(this.llF);
        AppMethodBeat.o(53318);
        return;
      } while (at.isWifi(this.llF));
      if (EmojiCustomUI.c(this.llF).exz == EmojiSyncManager.b.exJ)
      {
        EmojiCustomUI.a(this.llF, true);
        AppMethodBeat.o(53318);
        return;
      }
      EmojiCustomUI.a(this.llF, false);
      AppMethodBeat.o(53318);
      return;
    case 1003: 
      EmojiCustomUI.i(this.llF).setVisibility(8);
      EmojiCustomUI.f(this.llF).notifyDataSetChanged();
      AppMethodBeat.o(53318);
      return;
    }
    if (EmojiCustomUI.f(this.llF) != null)
    {
      EmojiCustomUI.f(this.llF).bmC();
      EmojiCustomUI.f(this.llF).notifyDataSetChanged();
    }
    EmojiCustomUI.bmA();
    AppMethodBeat.o(53318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.18
 * JD-Core Version:    0.7.0.1
 */