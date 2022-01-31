package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class EmojiStoreV2SingleProductDialogUI$2
  implements DialogInterface.OnClickListener
{
  EmojiStoreV2SingleProductDialogUI$2(EmojiStoreV2SingleProductDialogUI paramEmojiStoreV2SingleProductDialogUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(53731);
    EmojiStoreV2SingleProductDialogUI.f(this.lqW);
    if (EmojiStoreV2SingleProductDialogUI.b(this.lqW) != null) {
      h.qsU.e(12787, new Object[] { Integer.valueOf(EmojiStoreV2SingleProductDialogUI.c(this.lqW)), Integer.valueOf(1), EmojiStoreV2SingleProductDialogUI.b(this.lqW).field_md5, Long.valueOf(EmojiStoreV2SingleProductDialogUI.d(this.lqW)), EmojiStoreV2SingleProductDialogUI.b(this.lqW).field_designerID, EmojiStoreV2SingleProductDialogUI.b(this.lqW).field_groupId, Integer.valueOf(EmojiStoreV2SingleProductDialogUI.e(this.lqW)) });
    }
    AppMethodBeat.o(53731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductDialogUI.2
 * JD-Core Version:    0.7.0.1
 */