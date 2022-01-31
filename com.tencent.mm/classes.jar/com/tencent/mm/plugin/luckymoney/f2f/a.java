package com.tencent.mm.plugin.luckymoney.f2f;

import android.media.SoundPool;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public final class a
{
  public volatile boolean hMo = false;
  public SoundPool lNa = new SoundPool(2, 3, 0);
  Hashtable<String, Integer> lNb = new Hashtable();
  Map<Integer, Boolean> lNc = new HashMap();
  
  public final void eE(String paramString)
  {
    if (this.lNb.containsKey(paramString))
    {
      int i = ((Integer)this.lNb.get(paramString)).intValue();
      if ((i >= 0) && (this.lNc.containsKey(Integer.valueOf(i))) && (((Boolean)this.lNc.get(Integer.valueOf(i))).booleanValue())) {
        this.lNa.play(i, 1.0F, 1.0F, 0, 0, 1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a
 * JD-Core Version:    0.7.0.1
 */