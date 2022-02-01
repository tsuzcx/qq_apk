package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class o
  implements a
{
  private Bitmap pqA;
  private f<String, Bitmap> yGD;
  
  public o()
  {
    AppMethodBeat.i(55750);
    this.pqA = null;
    this.yGD = new b(20, getClass());
    AppMethodBeat.o(55750);
  }
  
  public final Bitmap aCX(String paramString)
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
        paramString = (Bitmap)this.yGD.get(paramString);
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
  
  public final void aer(String paramString)
  {
    try
    {
      AppMethodBeat.i(55753);
      Log.d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", new Object[] { paramString });
      Iterator localIterator = this.yGD.snapshot().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          this.yGD.remove(str);
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
      if (this.yGD.get(paramString) != null)
      {
        Bitmap localBitmap = (Bitmap)this.yGD.get(paramString);
        if (!localBitmap.isRecycled())
        {
          Log.i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        this.yGD.remove(paramString);
      }
      this.yGD.put(paramString, paramBitmap);
      Log.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.yGD.size()) });
      AppMethodBeat.o(55752);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o
 * JD-Core Version:    0.7.0.1
 */