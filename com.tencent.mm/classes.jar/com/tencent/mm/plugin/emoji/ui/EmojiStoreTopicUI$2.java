package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.i;

final class EmojiStoreTopicUI$2
  implements i
{
  EmojiStoreTopicUI$2(EmojiStoreTopicUI paramEmojiStoreTopicUI) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    paramString = this.jeT;
    if (paramString.jct != null) {
      paramString.jct.sendEmptyMessage(1009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.2
 * JD-Core Version:    0.7.0.1
 */