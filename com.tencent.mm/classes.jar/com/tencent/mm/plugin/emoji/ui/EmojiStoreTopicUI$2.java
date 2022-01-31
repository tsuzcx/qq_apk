package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.i;

final class EmojiStoreTopicUI$2
  implements i
{
  EmojiStoreTopicUI$2(EmojiStoreTopicUI paramEmojiStoreTopicUI) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(53492);
    paramString = this.lnJ;
    if (paramString.llf != null) {
      paramString.llf.sendEmptyMessage(1009);
    }
    AppMethodBeat.o(53492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI.2
 * JD-Core Version:    0.7.0.1
 */