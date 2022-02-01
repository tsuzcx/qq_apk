package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.emoji.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
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
    ac.i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", new Object[] { Long.valueOf(LuckyMoneyNewYearSendUI.j(this.uwo)), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), paramString });
    if (bs.av(LuckyMoneyNewYearSendUI.j(this.uwo), paramLong))
    {
      if (!paramBoolean) {
        break label114;
      }
      LuckyMoneyNewYearSendUI.a(this.uwo, paramString);
    }
    for (;;)
    {
      LuckyMoneyNewYearSendUI.a(this.uwo, true);
      paramString = b.fWn;
      b.b(LuckyMoneyNewYearSendUI.j(this.uwo), LuckyMoneyNewYearSendUI.A(this.uwo));
      AppMethodBeat.o(65691);
      return;
      label114:
      if (bs.jl(LuckyMoneyNewYearSendUI.y(this.uwo), 0))
      {
        paramLong = LuckyMoneyNewYearSendUI.j(this.uwo);
        paramString = az.faZ().GXZ.AS(paramLong);
        int i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.fFY() == EmojiInfo.a.Haz)
          {
            paramString = paramString.fGs();
            switch (com.tencent.mm.plugin.emoji.h.b.1.pmA[paramString.ordinal()])
            {
            }
          }
        }
        for (i = j; i != 0; i = 1)
        {
          LuckyMoneyNewYearSendUI.z(this.uwo);
          LuckyMoneyNewYearSendUI.a(this.uwo, 3);
          AppMethodBeat.o(65691);
          return;
        }
      }
      LuckyMoneyNewYearSendUI.a(this.uwo, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.4
 * JD-Core Version:    0.7.0.1
 */