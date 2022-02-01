package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.by.a.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class o
  implements a
{
  private Bitmap nZT;
  private f<String, Bitmap> vaA;
  
  public o()
  {
    AppMethodBeat.i(55750);
    this.nZT = null;
    this.vaA = new b(20, getClass());
    AppMethodBeat.o(55750);
  }
  
  public final void TT(String paramString)
  {
    try
    {
      AppMethodBeat.i(55753);
      ad.d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", new Object[] { paramString });
      Iterator localIterator = this.vaA.snapshot().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          this.vaA.remove(str);
        }
      }
      AppMethodBeat.o(55753);
    }
    finally {}
  }
  
  public final Bitmap aoz(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(55751);
        if (bt.isNullOrNil(paramString))
        {
          AppMethodBeat.o(55751);
          paramString = null;
          return paramString;
        }
        paramString = (Bitmap)this.vaA.get(paramString);
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
  
  public final void p(String paramString, Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(55752);
      if (this.vaA.get(paramString) != null)
      {
        Bitmap localBitmap = (Bitmap)this.vaA.get(paramString);
        if (!localBitmap.isRecycled())
        {
          ad.i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        this.vaA.remove(paramString);
      }
      this.vaA.put(paramString, paramBitmap);
      ad.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.vaA.size()) });
      AppMethodBeat.o(55752);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o
 * JD-Core Version:    0.7.0.1
 */