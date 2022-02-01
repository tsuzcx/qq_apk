package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.emoji.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.f;

final class LuckyMoneyNewYearSendUI$4
  implements a
{
  LuckyMoneyNewYearSendUI$4(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void a(long paramLong, boolean paramBoolean, String paramString)
  {
    int j = 0;
    AppMethodBeat.i(65691);
    ad.i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", new Object[] { Long.valueOf(LuckyMoneyNewYearSendUI.j(this.tnV)), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), paramString });
    if (bt.aw(LuckyMoneyNewYearSendUI.j(this.tnV), paramLong))
    {
      if (!paramBoolean) {
        break label114;
      }
      LuckyMoneyNewYearSendUI.a(this.tnV, paramString);
    }
    for (;;)
    {
      LuckyMoneyNewYearSendUI.a(this.tnV, true);
      paramString = b.fSs;
      b.b(LuckyMoneyNewYearSendUI.j(this.tnV), LuckyMoneyNewYearSendUI.A(this.tnV));
      AppMethodBeat.o(65691);
      return;
      label114:
      if (bt.iY(LuckyMoneyNewYearSendUI.y(this.tnV), 0))
      {
        paramLong = LuckyMoneyNewYearSendUI.j(this.tnV);
        paramString = aw.eLx().FyY.wp(paramLong);
        int i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.fZV() == EmojiInfo.a.FBz)
          {
            paramString = paramString.fZY();
            switch (com.tencent.mm.plugin.emoji.h.b.1.oJa[paramString.ordinal()])
            {
            }
          }
        }
        for (i = j; i != 0; i = 1)
        {
          LuckyMoneyNewYearSendUI.z(this.tnV);
          LuckyMoneyNewYearSendUI.a(this.tnV, 3);
          AppMethodBeat.o(65691);
          return;
        }
      }
      LuckyMoneyNewYearSendUI.a(this.tnV, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.4
 * JD-Core Version:    0.7.0.1
 */