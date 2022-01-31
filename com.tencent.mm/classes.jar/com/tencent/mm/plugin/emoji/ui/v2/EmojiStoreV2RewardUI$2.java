package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMFormInputView;

final class EmojiStoreV2RewardUI$2
  implements View.OnClickListener
{
  EmojiStoreV2RewardUI$2(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(53696);
    if (EmojiStoreV2RewardUI.d(this.lqH) != null)
    {
      paramView = EmojiStoreV2RewardUI.d(this.lqH).uw(0);
      if (EmojiStoreV2RewardUI.e(this.lqH).getText() != null)
      {
        paramView.Number = EmojiStoreV2RewardUI.e(this.lqH).getText().toString();
        EmojiStoreV2RewardUI.a(this.lqH, EmojiStoreV2RewardUI.f(this.lqH), paramView);
        AppMethodBeat.o(53696);
        return;
      }
      ab.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
      AppMethodBeat.o(53696);
      return;
    }
    ab.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
    AppMethodBeat.o(53696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.2
 * JD-Core Version:    0.7.0.1
 */