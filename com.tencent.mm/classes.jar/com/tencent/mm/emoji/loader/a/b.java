package com.tencent.mm.emoji.loader.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "clear", "", "get", "key", "", "put", "bitmap", "plugin-emojisdk_release"})
public final class b
{
  private static final com.tencent.mm.memory.a.b<Bitmap> gVT;
  public static final b gVU;
  
  static
  {
    AppMethodBeat.i(105416);
    gVU = new b();
    gVT = new com.tencent.mm.memory.a.b(300, b.class);
    AppMethodBeat.o(105416);
  }
  
  public static Bitmap EP(String paramString)
  {
    AppMethodBeat.i(105413);
    Log.d(c.auD(), "get: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105413);
      return null;
    }
    paramString = (Bitmap)gVT.get(paramString);
    if ((paramString == null) || (paramString.isRecycled()))
    {
      AppMethodBeat.o(105413);
      return null;
    }
    AppMethodBeat.o(105413);
    return paramString;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(105415);
    gVT.clear();
    AppMethodBeat.o(105415);
  }
  
  public static void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105414);
    Log.d(c.auD(), "put: " + paramString + ", " + paramBitmap);
    if (paramString != null)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        gVT.put(paramString, paramBitmap);
        AppMethodBeat.o(105414);
        return;
      }
      gVT.remove(paramString);
    }
    AppMethodBeat.o(105414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.b
 * JD-Core Version:    0.7.0.1
 */