package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class m
  implements a
{
  private Bitmap jVm;
  private f<String, Bitmap> obd;
  
  public m()
  {
    AppMethodBeat.i(113375);
    this.jVm = null;
    this.obd = new b(20, getClass());
    AppMethodBeat.o(113375);
  }
  
  public final void Ey(String paramString)
  {
    try
    {
      AppMethodBeat.i(113378);
      ab.d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", new Object[] { paramString });
      Iterator localIterator = this.obd.snapshot().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          this.obd.remove(str);
        }
      }
      AppMethodBeat.o(113378);
    }
    finally {}
  }
  
  public final Bitmap RY(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(113376);
        if (bo.isNullOrNil(paramString))
        {
          AppMethodBeat.o(113376);
          paramString = null;
          return paramString;
        }
        ab.d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.obd.size()) });
        paramString = (Bitmap)this.obd.get(paramString);
        if ((paramString != null) && (!paramString.isRecycled()))
        {
          AppMethodBeat.o(113376);
          continue;
        }
        AppMethodBeat.o(113376);
      }
      finally {}
      paramString = null;
    }
  }
  
  public final void p(String paramString, Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(113377);
      if (this.obd.get(paramString) != null)
      {
        Bitmap localBitmap = (Bitmap)this.obd.get(paramString);
        if (!localBitmap.isRecycled())
        {
          ab.i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        this.obd.remove(paramString);
      }
      this.obd.put(paramString, paramBitmap);
      ab.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.obd.size()) });
      AppMethodBeat.o(113377);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.m
 * JD-Core Version:    0.7.0.1
 */