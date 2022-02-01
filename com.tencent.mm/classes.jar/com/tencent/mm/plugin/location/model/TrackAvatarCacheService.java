package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.by.a.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class TrackAvatarCacheService
  implements a
{
  private static MMTrimMemoryEventListener Kdg = null;
  private com.tencent.mm.b.f<String, Bitmap> Kdf;
  private Bitmap hkp;
  
  public TrackAvatarCacheService()
  {
    AppMethodBeat.i(55750);
    this.hkp = null;
    if (Kdg != null) {
      Kdg.dead();
    }
    MMTrimMemoryEventListener localMMTrimMemoryEventListener = new MMTrimMemoryEventListener(this);
    Kdg = localMMTrimMemoryEventListener;
    localMMTrimMemoryEventListener.alive();
    this.Kdf = new b(20, getClass());
    AppMethodBeat.o(55750);
  }
  
  public final Bitmap aKc(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(55751);
        if (Util.isNullOrNil(paramString))
        {
          AppMethodBeat.o(55751);
          paramString = null;
          return paramString;
        }
        paramString = (Bitmap)this.Kdf.get(paramString);
        if ((paramString != null) && (!paramString.isRecycled()))
        {
          AppMethodBeat.o(55751);
          continue;
        }
        AppMethodBeat.o(55751);
      }
      finally {}
      paramString = null;
    }
  }
  
  public final void aft(String paramString)
  {
    try
    {
      AppMethodBeat.i(55753);
      Log.d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", new Object[] { paramString });
      Iterator localIterator = this.Kdf.snapshot().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          this.Kdf.remove(str);
        }
      }
      AppMethodBeat.o(55753);
    }
    finally {}
  }
  
  public final void p(String paramString, Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(55752);
      if (this.Kdf.get(paramString) != null)
      {
        Bitmap localBitmap = (Bitmap)this.Kdf.get(paramString);
        if (!localBitmap.isRecycled())
        {
          Log.i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        this.Kdf.remove(paramString);
      }
      this.Kdf.put(paramString, paramBitmap);
      Log.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.Kdf.size()) });
      AppMethodBeat.o(55752);
      return;
    }
    finally {}
  }
  
  static class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private final WeakReference<TrackAvatarCacheService> nph;
    
    public MMTrimMemoryEventListener(TrackAvatarCacheService paramTrackAvatarCacheService)
    {
      super();
      AppMethodBeat.i(264916);
      this.nph = new WeakReference(paramTrackAvatarCacheService);
      this.__eventId = oc.class.getName().hashCode();
      AppMethodBeat.o(264916);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.TrackAvatarCacheService
 * JD-Core Version:    0.7.0.1
 */