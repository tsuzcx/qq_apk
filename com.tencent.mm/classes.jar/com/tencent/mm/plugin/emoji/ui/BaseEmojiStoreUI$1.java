package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class BaseEmojiStoreUI$1
  implements DialogInterface.OnClickListener
{
  BaseEmojiStoreUI$1(BaseEmojiStoreUI paramBaseEmojiStoreUI, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(53213);
    this.lku.j(this.lgI, this.lks, this.lkt, null);
    this.lku.bmf();
    ab.i("MicroMsg.emoji.BaseEmojiStoreUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.lgI });
    BaseEmojiStoreUI.a(this.lku, this.lgI);
    AppMethodBeat.o(53213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.BaseEmojiStoreUI.1
 * JD-Core Version:    0.7.0.1
 */