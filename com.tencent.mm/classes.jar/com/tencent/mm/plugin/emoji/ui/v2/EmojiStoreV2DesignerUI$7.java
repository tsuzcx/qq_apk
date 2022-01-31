package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class EmojiStoreV2DesignerUI$7
  implements DialogInterface.OnCancelListener
{
  EmojiStoreV2DesignerUI$7(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (EmojiStoreV2DesignerUI.p(this.jgP) != null) {
      g.DO().dJT.c(EmojiStoreV2DesignerUI.p(this.jgP));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.7
 * JD-Core Version:    0.7.0.1
 */