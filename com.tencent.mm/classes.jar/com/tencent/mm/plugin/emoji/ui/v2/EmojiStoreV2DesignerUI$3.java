package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class EmojiStoreV2DesignerUI$3
  implements DialogInterface.OnClickListener
{
  EmojiStoreV2DesignerUI$3(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI, String paramString1, String paramString2, String paramString3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(53582);
    this.lpI.N(this.lgI, this.lks, this.lkt);
    this.lpI.bmf();
    ab.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.lgI });
    EmojiStoreV2DesignerUI.a(this.lpI, this.lgI);
    AppMethodBeat.o(53582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.3
 * JD-Core Version:    0.7.0.1
 */