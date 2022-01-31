package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.h.d;

final class LuckyMoneyIndexUI$4$1
  implements h.d
{
  LuckyMoneyIndexUI$4$1(LuckyMoneyIndexUI.4 param4) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(42724);
    switch (paramInt2)
    {
    default: 
      h.qsU.e(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5) });
      paramInt1 = 2;
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(this.otJ.otI.getContext(), LuckyMoneyMyRecordUI.class);
      localIntent.putExtra("key_type", paramInt1);
      this.otJ.otI.startActivity(localIntent);
      AppMethodBeat.o(42724);
      return;
      h.qsU.e(11701, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI.4.1
 * JD-Core Version:    0.7.0.1
 */