package com.tencent.mm.plugin.emoji.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class EmojiBaseActivity$a
  extends ah
{
  EmojiBaseActivity$a(EmojiBaseActivity paramEmojiBaseActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    this.jcu.h(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity.a
 * JD-Core Version:    0.7.0.1
 */