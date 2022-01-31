package com.tencent.mm.plugin.luckymoney.f2f;

import android.media.SoundPool;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public final class a
{
  public volatile boolean jFQ;
  public SoundPool okt;
  Hashtable<String, Integer> oku;
  Map<Integer, Boolean> okv;
  
  public a()
  {
    AppMethodBeat.i(42143);
    this.jFQ = false;
    this.okt = new SoundPool(2, 3, 0);
    this.oku = new Hashtable();
    this.okv = new HashMap();
    AppMethodBeat.o(42143);
  }
  
  public final void kJ(String paramString)
  {
    AppMethodBeat.i(42144);
    if (this.oku.containsKey(paramString))
    {
      int i = ((Integer)this.oku.get(paramString)).intValue();
      if ((i >= 0) && (this.okv.containsKey(Integer.valueOf(i))) && (((Boolean)this.okv.get(Integer.valueOf(i))).booleanValue())) {
        this.okt.play(i, 1.0F, 1.0F, 0, 0, 1.0F);
      }
    }
    AppMethodBeat.o(42144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a
 * JD-Core Version:    0.7.0.1
 */