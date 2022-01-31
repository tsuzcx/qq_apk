package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class EmojiStoreV2RewardUI$8
  implements DialogInterface.OnCancelListener
{
  EmojiStoreV2RewardUI$8(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(53702);
    g.RK().eHt.a(EmojiStoreV2RewardUI.m(this.lqH));
    AppMethodBeat.o(53702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.8
 * JD-Core Version:    0.7.0.1
 */