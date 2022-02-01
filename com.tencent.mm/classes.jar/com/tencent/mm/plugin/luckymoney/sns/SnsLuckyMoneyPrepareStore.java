package com.tencent.mm.plugin.luckymoney.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.luckymoney.flux.BaseStore;

public class SnsLuckyMoneyPrepareStore
  extends BaseStore
  implements h
{
  public final boolean fWN()
  {
    String str = c.a.TYPE;
    throw null;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(283879);
    if ((paramp instanceof a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        AppMethodBeat.o(283879);
        throw null;
      }
      paramString = c.a.TYPE;
      fWO();
    }
    AppMethodBeat.o(283879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareStore
 * JD-Core Version:    0.7.0.1
 */