package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.h.a;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.math.BigDecimal;
import java.util.ArrayList;

final class EmojiStoreDetailUI$15
  implements h.a
{
  EmojiStoreDetailUI$15(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void A(ArrayList<n> paramArrayList)
  {
    AppMethodBeat.i(53432);
    int i;
    if (paramArrayList == null)
    {
      i = 0;
      ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish] %s", new Object[] { Integer.valueOf(i) });
      EmojiStoreDetailUI.B(this.lnA);
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = (n)paramArrayList.get(0);
        ab.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", new Object[] { paramArrayList });
        if (paramArrayList.vKz != 10232) {
          break label175;
        }
        EmojiStoreDetailUI.a(this.lnA, 4);
        EmojiStoreDetailUI.a(this.lnA, paramArrayList.vKw);
        EmojiStoreDetailUI.b(this.lnA, paramArrayList.vKx);
        paramArrayList = new BigDecimal(paramArrayList.vKy).divide(new BigDecimal(1000000));
        EmojiStoreDetailUI.c(this.lnA, paramArrayList.toString());
      }
    }
    for (;;)
    {
      this.lnA.ut(1002);
      AppMethodBeat.o(53432);
      return;
      i = paramArrayList.size();
      break;
      label175:
      EmojiStoreDetailUI.a(this.lnA, 10);
      EmojiStoreDetailUI.b(this.lnA, paramArrayList.vKz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.15
 * JD-Core Version:    0.7.0.1
 */