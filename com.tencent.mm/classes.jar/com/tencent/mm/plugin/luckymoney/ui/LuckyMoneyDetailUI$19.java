package com.tencent.mm.plugin.luckymoney.ui;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.q;

final class LuckyMoneyDetailUI$19
  implements SoundPool.OnLoadCompleteListener
{
  LuckyMoneyDetailUI$19(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, q paramq) {}
  
  public final void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65536);
    if (paramInt2 == 0)
    {
      if (paramInt1 == LuckyMoneyDetailUI.Q(this.KBZ)[0])
      {
        paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
        AppMethodBeat.o(65536);
        return;
      }
      if ((paramInt1 == LuckyMoneyDetailUI.Q(this.KBZ)[1]) && (this.KAd.ihV >= 19000L)) {
        paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
      }
    }
    AppMethodBeat.o(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.19
 * JD-Core Version:    0.7.0.1
 */