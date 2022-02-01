package com.tencent.mm.modelimage.loader.impr;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.modelimage.loader.b.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class DefaultImageMemoryCacheListener
  implements o
{
  private static MMTrimMemoryEventListener oKR = null;
  private final com.tencent.mm.b.f<String, Bitmap> npk;
  private final com.tencent.mm.b.f<String, Bitmap> npl;
  
  public DefaultImageMemoryCacheListener()
  {
    AppMethodBeat.i(130419);
    this.npk = new b(50, getClass());
    this.npl = new b(10, getClass());
    if (oKR != null) {
      oKR.dead();
    }
    MMTrimMemoryEventListener localMMTrimMemoryEventListener = new MMTrimMemoryEventListener(this);
    oKR = localMMTrimMemoryEventListener;
    localMMTrimMemoryEventListener.alive();
    AppMethodBeat.o(130419);
  }
  
  public final Bitmap Eo(String paramString)
  {
    AppMethodBeat.i(130420);
    if (!Util.isNullOrNil(paramString))
    {
      if (this.npk.get(paramString) == null)
      {
        paramString = (Bitmap)this.npl.get(paramString);
        AppMethodBeat.o(130420);
        return paramString;
      }
      paramString = (Bitmap)this.npk.get(paramString);
      AppMethodBeat.o(130420);
      return paramString;
    }
    AppMethodBeat.o(130420);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(130422);
    Bitmap localBitmap;
    try
    {
      if (this.npk != null)
      {
        Object localObject1 = this.npk.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              Log.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.npk.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(130422);
    }
    if (this.npl != null)
    {
      Object localObject3 = this.npl.snapshot();
      if ((!((Map)localObject3).isEmpty()) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject3).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            Log.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      this.npl.clear();
    }
    AppMethodBeat.o(130422);
  }
  
  public final void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130421);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
      AppMethodBeat.o(130421);
      return;
    }
    if (paramBitmap == null)
    {
      Log.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
      AppMethodBeat.o(130421);
      return;
    }
    Bitmap localBitmap;
    long l;
    if ((paramBitmap != null) && ((paramBitmap instanceof Bitmap)))
    {
      localBitmap = (Bitmap)paramBitmap;
      if (Build.VERSION.SDK_INT >= 12) {
        l = localBitmap.getByteCount();
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[] { paramString, Long.valueOf(l), Util.getSizeKB(l) });
      if (l <= 524288L) {
        break;
      }
      this.npl.put(paramString, paramBitmap);
      AppMethodBeat.o(130421);
      return;
      int i = localBitmap.getRowBytes();
      l = localBitmap.getHeight() * i;
      continue;
      l = 0L;
    }
    this.npk.put(paramString, paramBitmap);
    AppMethodBeat.o(130421);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(239020);
    this.npk.remove(paramString);
    this.npl.remove(paramString);
    AppMethodBeat.o(239020);
  }
  
  static class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private final WeakReference<DefaultImageMemoryCacheListener> nph;
    
    public MMTrimMemoryEventListener(DefaultImageMemoryCacheListener paramDefaultImageMemoryCacheListener)
    {
      super();
      AppMethodBeat.i(239013);
      this.nph = new WeakReference(paramDefaultImageMemoryCacheListener);
      this.__eventId = oc.class.getName().hashCode();
      AppMethodBeat.o(239013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.loader.impr.DefaultImageMemoryCacheListener
 * JD-Core Version:    0.7.0.1
 */