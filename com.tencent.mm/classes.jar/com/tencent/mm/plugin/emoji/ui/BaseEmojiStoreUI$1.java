package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class BaseEmojiStoreUI$1
  implements DialogInterface.OnClickListener
{
  BaseEmojiStoreUI$1(BaseEmojiStoreUI paramBaseEmojiStoreUI, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jbL.j(this.iXv, this.jbJ, this.jbK, null);
    this.jbL.aIH();
    y.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.iXv });
    BaseEmojiStoreUI.a(this.jbL, this.iXv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.1
 * JD-Core Version:    0.7.0.1
 */