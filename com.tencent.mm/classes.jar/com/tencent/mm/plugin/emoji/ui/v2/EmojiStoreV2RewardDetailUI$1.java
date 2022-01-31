package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class EmojiStoreV2RewardDetailUI$1
  extends ak
{
  EmojiStoreV2RewardDetailUI$1(EmojiStoreV2RewardDetailUI paramEmojiStoreV2RewardDetailUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(53669);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(53669);
      return;
      if (EmojiStoreV2RewardDetailUI.a(this.lqe) != null)
      {
        EmojiStoreV2RewardDetailUI.a(this.lqe).setVisibility(8);
        AppMethodBeat.o(53669);
        return;
        if (EmojiStoreV2RewardDetailUI.a(this.lqe) != null) {
          EmojiStoreV2RewardDetailUI.a(this.lqe).setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI.1
 * JD-Core Version:    0.7.0.1
 */