package com.tencent.mm.plugin.luckymoney.ui;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.mm.plugin.luckymoney.b.f;

final class LuckyMoneyDetailUI$6
  implements SoundPool.OnLoadCompleteListener
{
  LuckyMoneyDetailUI$6(LuckyMoneyDetailUI paramLuckyMoneyDetailUI, f paramf) {}
  
  public final void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      if (paramInt1 != LuckyMoneyDetailUI.s(this.lVz)[0]) {
        break label29;
      }
      paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
    }
    label29:
    while ((paramInt1 != LuckyMoneyDetailUI.s(this.lVz)[1]) || (this.lUJ.ceq < 19000L)) {
      return;
    }
    paramSoundPool.play(paramInt1, 1.0F, 1.0F, 0, 0, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.6
 * JD-Core Version:    0.7.0.1
 */