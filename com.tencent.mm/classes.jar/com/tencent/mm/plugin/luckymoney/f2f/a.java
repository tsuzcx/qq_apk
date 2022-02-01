package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
{
  public volatile boolean stopped;
  Map<Integer, Boolean> yRA;
  public SoundPool yRy;
  Hashtable<String, Integer> yRz;
  
  public a()
  {
    AppMethodBeat.i(65033);
    this.stopped = false;
    this.yRy = new SoundPool(2, 3, 0);
    this.yRz = new Hashtable();
    this.yRA = new HashMap();
    AppMethodBeat.o(65033);
  }
  
  public final void Df(String paramString)
  {
    AppMethodBeat.i(65034);
    if (this.yRz.containsKey(paramString))
    {
      int i = ((Integer)this.yRz.get(paramString)).intValue();
      if ((i >= 0) && (this.yRA.containsKey(Integer.valueOf(i))) && (((Boolean)this.yRA.get(Integer.valueOf(i))).booleanValue())) {
        this.yRy.play(i, 1.0F, 1.0F, 0, 0, 1.0F);
      }
    }
    AppMethodBeat.o(65034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a
 * JD-Core Version:    0.7.0.1
 */