package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFormInputView;

final class EmojiStoreV2RewardUI$2
  implements View.OnClickListener
{
  EmojiStoreV2RewardUI$2(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void onClick(View paramView)
  {
    if (EmojiStoreV2RewardUI.d(this.jhK) != null)
    {
      paramView = EmojiStoreV2RewardUI.d(this.jhK).qa(0);
      if (EmojiStoreV2RewardUI.e(this.jhK).getText() != null)
      {
        paramView.sSz = EmojiStoreV2RewardUI.e(this.jhK).getText().toString();
        EmojiStoreV2RewardUI.a(this.jhK, EmojiStoreV2RewardUI.f(this.jhK), paramView);
        return;
      }
      y.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
      return;
    }
    y.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.2
 * JD-Core Version:    0.7.0.1
 */