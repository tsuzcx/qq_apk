package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class EmojiStoreDetailUI$15
  implements h.a
{
  EmojiStoreDetailUI$15(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void x(ArrayList<n> paramArrayList)
  {
    y.d("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish]");
    EmojiStoreDetailUI.B(this.jeK);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (n)paramArrayList.get(0);
      if (paramArrayList.rTC != 10232) {
        break label77;
      }
      EmojiStoreDetailUI.a(this.jeK, 4);
      EmojiStoreDetailUI.a(this.jeK, paramArrayList.rTz);
    }
    for (;;)
    {
      this.jeK.pX(1002);
      return;
      label77:
      EmojiStoreDetailUI.a(this.jeK, 10);
      EmojiStoreDetailUI.b(this.jeK, paramArrayList.rTC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.15
 * JD-Core Version:    0.7.0.1
 */