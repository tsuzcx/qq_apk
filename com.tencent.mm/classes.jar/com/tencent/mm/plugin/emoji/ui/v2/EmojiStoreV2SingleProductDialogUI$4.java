package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.protocal.c.ut;

final class EmojiStoreV2SingleProductDialogUI$4
  implements i
{
  EmojiStoreV2SingleProductDialogUI$4(EmojiStoreV2SingleProductDialogUI paramEmojiStoreV2SingleProductDialogUI) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    if ((paramBitmap != null) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (EmojiStoreV2SingleProductDialogUI.e(this.jif) != null) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof ut)))
    {
      paramString = (ut)paramVarArgs[0];
      if ((EmojiStoreV2SingleProductDialogUI.a(this.jif) != null) && (paramString != null) && (paramString.jnU.equals(EmojiStoreV2SingleProductDialogUI.a(this.jif).jnU))) {
        EmojiStoreV2SingleProductDialogUI.f(this.jif);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.4
 * JD-Core Version:    0.7.0.1
 */