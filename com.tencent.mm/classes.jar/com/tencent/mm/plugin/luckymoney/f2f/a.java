package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
{
  public volatile boolean stopped;
  public SoundPool vxj;
  Hashtable<String, Integer> vxk;
  Map<Integer, Boolean> vxl;
  
  public a()
  {
    AppMethodBeat.i(65033);
    this.stopped = false;
    this.vxj = new SoundPool(2, 3, 0);
    this.vxk = new Hashtable();
    this.vxl = new HashMap();
    AppMethodBeat.o(65033);
  }
  
  public final void uP(String paramString)
  {
    AppMethodBeat.i(65034);
    if (this.vxk.containsKey(paramString))
    {
      int i = ((Integer)this.vxk.get(paramString)).intValue();
      if ((i >= 0) && (this.vxl.containsKey(Integer.valueOf(i))) && (((Boolean)this.vxl.get(Integer.valueOf(i))).booleanValue())) {
        this.vxj.play(i, 1.0F, 1.0F, 0, 0, 1.0F);
      }
    }
    AppMethodBeat.o(65034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a
 * JD-Core Version:    0.7.0.1
 */