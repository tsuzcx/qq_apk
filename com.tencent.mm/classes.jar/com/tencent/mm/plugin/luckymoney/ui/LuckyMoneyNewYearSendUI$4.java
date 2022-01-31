package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.emoji.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.d;

final class LuckyMoneyNewYearSendUI$4
  implements a
{
  LuckyMoneyNewYearSendUI$4(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void a(long paramLong, boolean paramBoolean, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(42811);
    ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", new Object[] { Long.valueOf(LuckyMoneyNewYearSendUI.j(this.ovl)), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), paramString });
    if (bo.ah(LuckyMoneyNewYearSendUI.j(this.ovl), paramLong))
    {
      if (!paramBoolean) {
        break label114;
      }
      LuckyMoneyNewYearSendUI.a(this.ovl, paramString);
    }
    for (;;)
    {
      LuckyMoneyNewYearSendUI.a(this.ovl, true);
      paramString = b.eyc;
      b.b(LuckyMoneyNewYearSendUI.j(this.ovl), LuckyMoneyNewYearSendUI.z(this.ovl));
      AppMethodBeat.o(42811);
      return;
      label114:
      if (bo.hl(LuckyMoneyNewYearSendUI.x(this.ovl), 0))
      {
        paramLong = LuckyMoneyNewYearSendUI.j(this.ovl);
        paramString = at.dxt().yNn.or(paramLong);
        int i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.dzx() == EmojiInfo.a.yPF)
          {
            paramString = paramString.dzA();
            switch (com.tencent.mm.plugin.emoji.h.b.1.lsH[paramString.ordinal()])
            {
            }
          }
        }
        for (i = j; i != 0; i = 1)
        {
          LuckyMoneyNewYearSendUI.y(this.ovl);
          LuckyMoneyNewYearSendUI.a(this.ovl, 3);
          AppMethodBeat.o(42811);
          return;
        }
      }
      LuckyMoneyNewYearSendUI.a(this.ovl, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.4
 * JD-Core Version:    0.7.0.1
 */