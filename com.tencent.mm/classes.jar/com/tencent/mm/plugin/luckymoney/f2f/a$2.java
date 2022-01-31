package com.tencent.mm.plugin.luckymoney.f2f;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.Map;

public final class a$2
  implements SoundPool.OnLoadCompleteListener
{
  public a$2(a parama) {}
  
  public final void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      this.lNf.lNc.put(Integer.valueOf(paramInt1), Boolean.valueOf(true));
      return;
    }
    this.lNf.lNc.put(Integer.valueOf(paramInt1), Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.2
 * JD-Core Version:    0.7.0.1
 */