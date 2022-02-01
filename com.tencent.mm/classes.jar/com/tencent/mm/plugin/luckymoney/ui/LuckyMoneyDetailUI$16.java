package com.tencent.mm.plugin.luckymoney.ui;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.q;

final class LuckyMoneyDetailUI$16
  implements SoundPool.OnLoadCompleteListener
{
  LuckyMoneyDetailUI$16(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, q paramq) {}
  
  public final void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266210);
    if (paramInt2 == 0)
    {
      if (paramInt1 == LuckyMoneyDetailUI.M(this.EIF)[0])
      {
        paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
        AppMethodBeat.o(266210);
        return;
      }
      if ((paramInt1 == LuckyMoneyDetailUI.M(this.EIF)[1]) && (this.EGT.gbJ >= 19000L)) {
        paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
      }
    }
    AppMethodBeat.o(266210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.16
 * JD-Core Version:    0.7.0.1
 */