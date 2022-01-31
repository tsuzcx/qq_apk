package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiStoreDetailUI$20
  implements i
{
  EmojiStoreDetailUI$20(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    y.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", new Object[] { paramString });
    if (paramBitmap != null) {
      this.jeK.pX(1006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.20
 * JD-Core Version:    0.7.0.1
 */