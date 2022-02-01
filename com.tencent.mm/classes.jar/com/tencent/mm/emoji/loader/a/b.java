package com.tencent.mm.emoji.loader.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/cache/CoverMemoryCache;", "", "()V", "cacheMap", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "clear", "", "get", "key", "", "put", "bitmap", "plugin-emojisdk_release"})
public final class b
{
  private static final com.tencent.mm.memory.a.b<Bitmap> jGP;
  public static final b jGQ;
  
  static
  {
    AppMethodBeat.i(105416);
    jGQ = new b();
    jGP = new com.tencent.mm.memory.a.b(500, b.class);
    AppMethodBeat.o(105416);
  }
  
  public static Bitmap LI(String paramString)
  {
    AppMethodBeat.i(105413);
    Log.d(c.aBy(), "get: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(105413);
      return null;
    }
    paramString = (Bitmap)jGP.get(paramString);
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
    jGP.clear();
    AppMethodBeat.o(105415);
  }
  
  public static void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(105414);
    Log.d(c.aBy(), "put: " + paramString + ", " + paramBitmap);
    if (paramString != null)
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        jGP.put(paramString, paramBitmap);
        AppMethodBeat.o(105414);
        return;
      }
      jGP.remove(paramString);
    }
    AppMethodBeat.o(105414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a.b
 * JD-Core Version:    0.7.0.1
 */