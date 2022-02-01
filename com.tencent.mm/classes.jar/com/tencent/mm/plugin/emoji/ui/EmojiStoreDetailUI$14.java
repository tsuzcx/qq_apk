package com.tencent.mm.plugin.emoji.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.ac;
import java.math.BigDecimal;
import java.util.ArrayList;

final class EmojiStoreDetailUI$14
  implements j.a
{
  EmojiStoreDetailUI$14(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void R(ArrayList<p> paramArrayList)
  {
    AppMethodBeat.i(176191);
    int i;
    if (paramArrayList == null)
    {
      i = 0;
      ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish] %s", new Object[] { Integer.valueOf(i) });
      EmojiStoreDetailUI.B(this.phq);
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = (p)paramArrayList.get(0);
        ac.i("MicroMsg.emoji.EmojiStoreDetailUI", "onQueryFinish: %s", new Object[] { paramArrayList });
        if (paramArrayList.Dhr != 10232) {
          break label175;
        }
        EmojiStoreDetailUI.a(this.phq, 4);
        EmojiStoreDetailUI.a(this.phq, paramArrayList.Dho);
        EmojiStoreDetailUI.b(this.phq, paramArrayList.Dhp);
        paramArrayList = new BigDecimal(paramArrayList.Dhq).divide(new BigDecimal(1000000));
        EmojiStoreDetailUI.c(this.phq, paramArrayList.toString());
      }
    }
    for (;;)
    {
      this.phq.Bv(1002);
      AppMethodBeat.o(176191);
      return;
      i = paramArrayList.size();
      break;
      label175:
      EmojiStoreDetailUI.a(this.phq, 10);
      EmojiStoreDetailUI.b(this.phq, paramArrayList.Dhr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.14
 * JD-Core Version:    0.7.0.1
 */