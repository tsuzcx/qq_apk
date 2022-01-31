package com.tencent.mm.emoji.loader.a;

import a.l;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Landroid/graphics/Bitmap;", "get", "key", "put", "", "bitmap", "plugin-emojisdk_release"})
public final class b
{
  private static final h<String, Bitmap> evs;
  public static final b evt;
  
  static
  {
    AppMethodBeat.i(63170);
    evt = new b();
    evs = new h(60);
    AppMethodBeat.o(63170);
  }
  
  public static void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(63169);
    ab.i(c.Ot(), "put: " + paramString + ", " + paramBitmap);
    if (paramString != null)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        evs.put(paramString, paramBitmap);
        AppMethodBeat.o(63169);
        return;
      }
      evs.remove(paramString);
    }
    AppMethodBeat.o(63169);
  }
  
  public static Bitmap lK(String paramString)
  {
    AppMethodBeat.i(63168);
    ab.i(c.Ot(), "get: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(63168);
      return null;
    }
    paramString = (Bitmap)evs.get(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(63168);
      return null;
    }
    AppMethodBeat.o(63168);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.b
 * JD-Core Version:    0.7.0.1
 */