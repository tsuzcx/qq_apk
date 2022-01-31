package com.tencent.mm.plugin.emoji.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class EmojiBaseActivity$b
  extends ak
{
  EmojiBaseActivity$b(EmojiBaseActivity paramEmojiBaseActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53298);
    super.handleMessage(paramMessage);
    this.llg.n(paramMessage);
    AppMethodBeat.o(53298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiBaseActivity.b
 * JD-Core Version:    0.7.0.1
 */