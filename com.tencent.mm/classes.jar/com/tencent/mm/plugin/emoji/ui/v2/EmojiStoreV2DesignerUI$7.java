package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class EmojiStoreV2DesignerUI$7
  implements DialogInterface.OnCancelListener
{
  EmojiStoreV2DesignerUI$7(EmojiStoreV2DesignerUI paramEmojiStoreV2DesignerUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(109148);
    if (EmojiStoreV2DesignerUI.p(this.pjx) != null) {
      g.agQ().ghe.a(EmojiStoreV2DesignerUI.p(this.pjx));
    }
    AppMethodBeat.o(109148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.7
 * JD-Core Version:    0.7.0.1
 */