package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.ce.a.a;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class o
  implements a
{
  private static a Ekx = null;
  private f<String, Bitmap> Ekw;
  private Bitmap fgf;
  
  public o()
  {
    AppMethodBeat.i(55750);
    this.fgf = null;
    if (Ekx != null) {
      Ekx.dead();
    }
    a locala = new a(this);
    Ekx = locala;
    locala.alive();
    this.Ekw = new b(20, getClass());
    AppMethodBeat.o(55750);
  }
  
  public final Bitmap aNh(String paramString)
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
        paramString = (Bitmap)this.Ekw.get(paramString);
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
  
  public final void aml(String paramString)
  {
    try
    {
      AppMethodBeat.i(55753);
      Log.d("MicroMsg.TrackAvatarCacheService", "clearCache, tag = %s", new Object[] { paramString });
      Iterator localIterator = this.Ekw.snapshot().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          this.Ekw.remove(str);
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
      if (this.Ekw.get(paramString) != null)
      {
        Bitmap localBitmap = (Bitmap)this.Ekw.get(paramString);
        if (!localBitmap.isRecycled())
        {
          Log.i("MicroMsg.TrackAvatarCacheService", "bitmap recycle %s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        this.Ekw.remove(paramString);
      }
      this.Ekw.put(paramString, paramBitmap);
      Log.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[] { paramString, Integer.valueOf(this.Ekw.size()) });
      AppMethodBeat.o(55752);
      return;
    }
    finally {}
  }
  
  static final class a
    extends IListener<mv>
  {
    private final WeakReference<o> kNt;
    
    public a(o paramo)
    {
      AppMethodBeat.i(244661);
      this.kNt = new WeakReference(paramo);
      this.__eventId = mv.class.getName().hashCode();
      AppMethodBeat.o(244661);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o
 * JD-Core Version:    0.7.0.1
 */