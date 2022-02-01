package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;

final class EmojiStoreV2DesignerUI$8
  implements DialogInterface.OnCancelListener
{
  EmojiStoreV2DesignerUI$8(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(270794);
    if (EmojiStoreV2DesignerUI.p(this.xWy) != null) {
      h.baD().mCm.a(EmojiStoreV2DesignerUI.p(this.xWy));
    }
    AppMethodBeat.o(270794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.8
 * JD-Core Version:    0.7.0.1
 */