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
  private Bitmap mVW;
  private f<String, Bitmap> sPE;
  
  public o()
  {
    AppMethodBeat.i(55750);
    this.mVW = null;
    this.sPE = new b(20, getClass());
    AppMethodBeat.o(55750);
  }
  
  public final void Mf(String paramString)
  {
    try
    {
      AppMethodBeat.i(55753);
      ad.d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", new Object[] { paramString });
      Iterator localIterator = this.sPE.snapshot().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          this.sPE.remove(str);
        }
      }
      AppMethodBeat.o(55753);
    }
    finally {}
  }
  
  public final Bitmap aeS(String paramString)
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
        paramString = (Bitmap)this.sPE.get(paramString);
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
  
  public final void q(String paramString, Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(55752);
      if (this.sPE.get(paramString) != null)
      {
        Bitmap localBitmap = (Bitmap)this.sPE.get(paramString);
        if (!localBitmap.isRecycled())
        {
          ad.i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        this.sPE.remove(paramString);
      }
      this.sPE.put(paramString, paramBitmap);
      ad.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.sPE.size()) });
      AppMethodBeat.o(55752);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o
 * JD-Core Version:    0.7.0.1
 */