package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.SoundPool;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a$1
  implements Runnable
{
  public a$1(a parama, Set paramSet, WeakReference paramWeakReference) {}
  
  public final void run()
  {
    try
    {
      Iterator localIterator = this.lNd.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((this.lNe.get() == null) || (this.lNf.hMo)) {
          break label124;
        }
        this.lNf.lNb.put(str, Integer.valueOf(this.lNf.lNa.load(((Context)this.lNe.get()).getResources().getAssets().openFd(str), 0)));
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("AsyncSoundPool", "load sound file error:" + localException.getMessage());
    }
    label124:
    y.i("AsyncSoundPool", "context = null or soundPool is stopped");
    this.lNf.lNa.release();
    this.lNf.lNb.clear();
    this.lNf.lNc.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.1
 * JD-Core Version:    0.7.0.1
 */