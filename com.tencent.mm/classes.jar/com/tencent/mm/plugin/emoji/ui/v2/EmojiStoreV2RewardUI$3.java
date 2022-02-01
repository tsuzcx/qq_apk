package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class EmojiStoreV2RewardUI$3
  implements View.OnClickListener
{
  EmojiStoreV2RewardUI$3(EmojiStoreV2RewardUI paramEmojiStoreV2RewardUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109272);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (EmojiStoreV2RewardUI.g(this.rlF) == EmojiStoreV2RewardUI.a.rlG) {
      EmojiStoreV2RewardUI.a(this.rlF, EmojiStoreV2RewardUI.a.rlH);
    }
    a.a(this, "com/tencent/mm/plugin/emoji/ui/v2/EmojiStoreV2RewardUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.3
 * JD-Core Version:    0.7.0.1
 */