package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.sdk.platformtools.ah;

final class EmojiStoreV2DesignerUI$15
  implements i
{
  EmojiStoreV2DesignerUI$15(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    if (EmojiStoreV2DesignerUI.k(this.jgP) != null) {
      EmojiStoreV2DesignerUI.k(this.jgP).sendEmptyMessage(10001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.15
 * JD-Core Version:    0.7.0.1
 */