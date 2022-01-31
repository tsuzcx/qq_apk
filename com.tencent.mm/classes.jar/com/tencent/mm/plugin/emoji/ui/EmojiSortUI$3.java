package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class EmojiSortUI$3
  implements DialogInterface.OnCancelListener
{
  EmojiSortUI$3(EmojiSortUI paramEmojiSortUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (EmojiSortUI.c(this.jdC) != null) {
      g.DO().dJT.c(EmojiSortUI.c(this.jdC));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.3
 * JD-Core Version:    0.7.0.1
 */