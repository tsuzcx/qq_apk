package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.SoundPool;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(42141);
    try
    {
      Iterator localIterator = this.okw.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label185;
        }
        String str = (String)localIterator.next();
        if ((this.okx.get() == null) || (this.oky.jFQ)) {
          break;
        }
        AssetFileDescriptor localAssetFileDescriptor = ((Context)this.okx.get()).getResources().getAssets().openFd(str);
        this.oky.oku.put(str, Integer.valueOf(this.oky.okt.load(localAssetFileDescriptor, 0)));
        localAssetFileDescriptor.close();
      }
      ab.i("AsyncSoundPool", "context = null or soundPool is stopped");
    }
    catch (Exception localException)
    {
      ab.e("AsyncSoundPool", "load sound file error:" + localException.getMessage());
      AppMethodBeat.o(42141);
      return;
    }
    this.oky.okt.release();
    this.oky.oku.clear();
    this.oky.okv.clear();
    AppMethodBeat.o(42141);
    return;
    label185:
    AppMethodBeat.o(42141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.1
 * JD-Core Version:    0.7.0.1
 */