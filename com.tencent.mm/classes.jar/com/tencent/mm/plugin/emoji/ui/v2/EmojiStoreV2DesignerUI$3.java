package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class EmojiStoreV2DesignerUI$3
  implements DialogInterface.OnClickListener
{
  EmojiStoreV2DesignerUI$3(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jgP.K(this.iXv, this.jbJ, this.jbK);
    this.jgP.aIH();
    y.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.iXv });
    EmojiStoreV2DesignerUI.a(this.jgP, this.iXv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.3
 * JD-Core Version:    0.7.0.1
 */