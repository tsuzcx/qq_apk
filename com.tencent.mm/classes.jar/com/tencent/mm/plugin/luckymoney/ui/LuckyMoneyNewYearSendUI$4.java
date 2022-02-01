package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.d.a;
import com.tencent.mm.emoji.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
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
    Log.i("MicroMsg.LuckyMoneyNewYearSendUI", "onResult() mTimeEnter:%s  timeEnter:%s  success:%s  md5:%s", new Object[] { Long.valueOf(LuckyMoneyNewYearSendUI.j(this.zgb)), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean), paramString });
    if (Util.isEqual(LuckyMoneyNewYearSendUI.j(this.zgb), paramLong))
    {
      if (!paramBoolean) {
        break label114;
      }
      LuckyMoneyNewYearSendUI.a(this.zgb, paramString);
    }
    for (;;)
    {
      LuckyMoneyNewYearSendUI.a(this.zgb, true);
      paramString = b.hdv;
      b.b(LuckyMoneyNewYearSendUI.j(this.zgb), LuckyMoneyNewYearSendUI.A(this.zgb));
      AppMethodBeat.o(65691);
      return;
      label114:
      if (Util.isEqual(LuckyMoneyNewYearSendUI.y(this.zgb), 0))
      {
        paramLong = LuckyMoneyNewYearSendUI.j(this.zgb);
        paramString = bj.gCJ().OpN.Nl(paramLong);
        int i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.hRH() == EmojiInfo.a.Osn)
          {
            paramString = paramString.hRK();
            switch (com.tencent.mm.plugin.emoji.h.b.1.rnE[paramString.ordinal()])
            {
            }
          }
        }
        for (i = j; i != 0; i = 1)
        {
          LuckyMoneyNewYearSendUI.z(this.zgb);
          LuckyMoneyNewYearSendUI.a(this.zgb, 3);
          AppMethodBeat.o(65691);
          return;
        }
      }
      LuckyMoneyNewYearSendUI.a(this.zgb, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.4
 * JD-Core Version:    0.7.0.1
 */