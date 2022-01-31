package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class EmojiSortUI$3
  implements DialogInterface.OnCancelListener
{
  EmojiSortUI$3(EmojiSortUI paramEmojiSortUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53410);
    if (EmojiSortUI.c(this.lmp) != null) {
      g.RK().eHt.a(EmojiSortUI.c(this.lmp));
    }
    AppMethodBeat.o(53410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiSortUI.3
 * JD-Core Version:    0.7.0.1
 */