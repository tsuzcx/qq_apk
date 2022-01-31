package com.tencent.mm.plugin.emoji.ui;

import android.os.Message;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.sdk.platformtools.ah;

final class EmojiAddCustomDialogUI$1
  extends ah
{
  EmojiAddCustomDialogUI$1(EmojiAddCustomDialogUI paramEmojiAddCustomDialogUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    EmojiAddCustomDialogUI.a(this.jcr, this.jcr.getString(f.h.emoji_store_watting_add));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI.1
 * JD-Core Version:    0.7.0.1
 */